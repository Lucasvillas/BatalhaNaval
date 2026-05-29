import java.net.DatagramPacket;

public class RecebeThread extends Thread {
    private GerenciadorDeRede rede;
    private Mapa mapa;

    public RecebeThread(GerenciadorDeRede rede, Mapa mapa) {
        this.rede = rede;
        this.mapa = mapa;
    }

    @Override
    public void run() {
        while(true) {
            try {
                DatagramPacket packet = rede.recebeMensagem();
                String msg = new String(packet.getData(), 0, packet.getLength());

             
                if(msg.startsWith("TIRO")) {
                    String[] parts = msg.split(":");
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);

                    boolean hit = mapa.receiveShot(x, y);
                    
                    String feedback = hit ? "RESULT:ACERTOU!" : "RESULT:ERROU!";
                    rede.enviaMensagem(feedback, msg, y);(feedback, packet.getAddress().getHostAddress(), packet.getPort());

                    System.out.println("\n[INIMIGO] Atirou em (" + x + "," + y + ")");
                    System.out.println(hit ? "RESULTADO: Seu navio foi atingido!" : "RESULTADO: Ele errou!");
                    
                    mapa.printMapa();
                    
                    if(mapa.lost()) {
                        System.out.println("GAME OVER! Voce perdeu.");
                        System.exit(0);
                    }
                    Main.minhaVez = true; 
                } 
                
                else if(msg.startsWith("RESULT")) {
                    System.out.println("\n[SISTEMA] " + msg);

                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}