import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ExemploMAC {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                // Verifica se a interface está ativa e não é loopback
                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                    byte[] mac = networkInterface.getHardwareAddress();

                    // Verifica se a interface tem um endereço MAC e se o nome sugere que é Wi-Fi
                    if (mac != null && ((networkInterface.getName().startsWith("wireless")) ||
                        (networkInterface.getName().startsWith("wlan")) ||
                        (networkInterface.getName().startsWith("wlp")))) {
                        System.out.print("Endereço MAC da interface Wi-Fi: ");
                        for (int i = 0; i < mac.length; i++) {
                            System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : "");
                        }
                        System.out.println();
                        break; // Sai do loop após encontrar a interface Wi-Fi ativa
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}