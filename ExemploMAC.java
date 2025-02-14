import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ExemploMAC{
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); //declarando variavel com instancia
                // interfaces Recebe a lista de todas as interfaces de rede disponíveis no sistema/

            while (interfaces.hasMoreElements()) {      //se tem mais elementos a serem iterados 
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("Interface de rede: " + networkInterface.getName());
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    //System.out.print("Endereço MAC da interface " + networkInterface.getName() + ": ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : "");
                    }
                    System.out.println();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}