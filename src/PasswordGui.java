import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum Case {
    LOWERCASE, UPPERCASE, COMBINED
}

public class PasswordGui extends JFrame {
    JPanel mainPanel;
    private JLabel info;
    private JLabel instructions;
    private JRadioButton lowerCaseRB;
    private JLabel caseValue;
    private JRadioButton upperCaseRB;
    private JRadioButton combinedCaseRB;
    private JRadioButton yesNumberRB;
    private JLabel numbers;
    private JRadioButton noNumberRB;
    private JLabel symbols;
    private JRadioButton yesSymbolsRB;
    private JRadioButton noSymbolsRB;
    private JButton generateButton;
    private JLabel Length;
    private JSpinner passwordLength;
    private Integer passLength;
    private Case letterCase;
    private Boolean numbersOption = false;
    private Boolean symbolsOption = false;

    public PasswordGui() {
        SpinnerModel length = new SpinnerNumberModel(1, 1, 30, 1);
        passwordLength.setModel(length);
        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor)passwordLength.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) jsEditor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionsCheck();
                new GeneratedPassword(PasswordGui.this, passLength, letterCase.toString(), numbersOption, symbolsOption);
            }
        });
    }

    private void optionsCheck() {
        if (lowerCaseRB.isSelected()){
            letterCase = Case.LOWERCASE;
        } else if (upperCaseRB.isSelected()){
            letterCase = Case.UPPERCASE;
        } else if (combinedCaseRB.isSelected()){
            letterCase = Case.COMBINED;
        }

        numbersOption = yesNumberRB.isSelected();

        symbolsOption = yesSymbolsRB.isSelected();

        passLength = Integer.parseInt(passwordLength.getValue().toString());

    }

    public static void main(String[] args) {
        PasswordGui p = new PasswordGui();
        p.setContentPane(p.mainPanel);
        p.setTitle("Password Generator");
        p.setSize(500, 400);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        p.setResizable(false);
        p.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}