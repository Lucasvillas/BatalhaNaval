import java.util.Scanner;

public class Main {

    public static volatile boolean minhaVez = false; 

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        if (args.length < 1) {
            System.out.println("Use: java Main <sua_porta>");
            return;
        }

        int porta = Integer.parseInt(args[0]);
        
        minhaVez = (porta == 5000);

        System.out.print("IP do inimigo: ");
        String ipInimigo = scanner.nextLine();

        System.out.print("Porta do inimigo: ");
        int portaInimiga = Integer.parseInt(scanner.nextLine());

        Mapa mapa = new Mapa();
        mapa.posicionarNavios(scanner);

        GerenciadorDeRede rede = new GerenciadorDeRede(porta);
        RecebeThread receiver = new RecebeThread(rede, mapa);
        receiver.start();

        System.out.println("\n--- JOGO INICIADO ---");
        mapa.printMapa();

        while (true) {
            if (minhaVez) {
                try {
                    System.out.println("\n>>>> SUA VEZ DE ATACAR! <<<<");
                    System.out.print("X: ");
                    int x = Integer.parseInt(scanner.nextLine());
                    System.out.print("Y: ");
                    int y = Integer.parseInt(scanner.nextLine());

                    rede.enviaMensagem("TIRO:" + x + ":" + y, ipInimigo, portaInimiga);
                    minhaVez = false; // Bloqueia até receber resposta ou tiro
                } catch (Exception e) {
                    System.out.println("Erro na entrada! Digite apenas números.");
                }
            } else {
     
                Thread.sleep(100); 
            }
        }
    }
}