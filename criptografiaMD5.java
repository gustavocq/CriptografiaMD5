import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class criptografiaMD5 {

    public static String Encriptar(String bhash) throws NoSuchAlgorithmException {
        MessageDigest md5Hash = MessageDigest.getInstance("MD5");

        // Converter a String para array de bytes, que é como a biblioteca trabalha.
        byte[] data = md5Hash.digest(bhash.getBytes());

        // Cria-se um StringBuilder para recompôr a string.
        StringBuilder sBuilder = new StringBuilder();

        // Loop para formatar cada byte como uma String em hexadecimal
        for (int i = 0; i < data.length; i++) {
            sBuilder.append(String.format("%02x", data[i]));
        }

        return sBuilder.toString();
    }    

    public static void main (String [] args) throws NoSuchAlgorithmException {

        String string;

        string = JOptionPane.showInputDialog(null,"Insira a Hash que deseja criptografar:");
        String resultado = Encriptar(string);

        Object[] options = {"OK", "Copiar"};
        int choice = JOptionPane.showOptionDialog(null,
                "Resultado: " + resultado,
                "Resultado da Criptografia",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 1) {
            // Copia o resultado para a área de transferência
            StringSelection selection = new StringSelection(resultado);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, null);
        }
    }	
}
