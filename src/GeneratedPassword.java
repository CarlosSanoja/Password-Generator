import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratedPassword extends JFrame {
    private JPanel generatedPassword;
    private JLabel Info;
    private JLabel newPassword;
    private JButton copyButton;

    public GeneratedPassword(JFrame frame, Integer passwordLength, String letterCase, Boolean numbers, Boolean symbols){
        PasswordGenerator password = new PasswordGenerator();
        String clave = password.passwordGenerator(passwordLength, letterCase, numbers, symbols);
        System.out.println(clave);
        System.out.println("passwordLength = " + passwordLength + ", letterCase = " + letterCase + ", numbers = " + numbers + ", symbols = " + symbols);

        GeneratedPassword g = new GeneratedPassword(clave);
        g.setContentPane(g.generatedPassword);
        g.setTitle("New password");
        g.setSize(350, 200);
        g.setLocationRelativeTo(frame);
        g.setVisible(true);
        g.setResizable(false);

    }

    public GeneratedPassword(String texto){
        newPassword.setText(texto);
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection strSelection = new StringSelection(newPassword.getText());
                Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipBoard.setContents(strSelection, null);
                JOptionPane.showMessageDialog(null, "Password copied to clipboard");
            }
        });
    }

}
