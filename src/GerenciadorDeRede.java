import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GerenciadorDeRede {

    private DatagramSocket socket;

    public GerenciadorDeRede(int port) throws Exception {

        socket = new DatagramSocket(port);
    }

    public void enviaMensagem(String mensagem, String ip, int port) throws Exception {

        byte[] buffer = mensagem.getBytes();

        InetAddress address = InetAddress.getByName(ip);

        DatagramPacket packet =
                new DatagramPacket(
                        buffer,
                        buffer.length,
                        address,
                        port
                );

        socket.send(packet);
    }

    public DatagramPacket recebeMensagem() throws Exception {

        byte[] buffer = new byte[1024];

        DatagramPacket packet =
                new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        return packet;
    }
}