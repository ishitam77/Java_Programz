import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JTextField rupeesField, wonField;
    private JButton rupeesToWonBtn, wonToRupeesBtn;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 200);

        // create the rupees to won panel
        JPanel rupeesToWonPanel = new JPanel();
        rupeesToWonPanel.setLayout(new GridLayout(2, 2));
        JLabel rupeesLabel = new JLabel("Rupees (Result)");
        rupeesField = new JTextField(10);
        JLabel wonLabel = new JLabel("<<<<Korean-Won (Enter)");
        wonField = new JTextField(10);
        wonField.setEditable(false);
        rupeesToWonBtn = new JButton("Convert");
        rupeesToWonBtn.addActionListener(this);
        rupeesToWonPanel.add(rupeesLabel);
        rupeesToWonPanel.add(rupeesField);
        rupeesToWonPanel.add(wonLabel);
        rupeesToWonPanel.add(wonField);
        rupeesToWonPanel.add(rupeesToWonBtn);

        // create the won to rupees panel
        JPanel wonToRupeesPanel = new JPanel();
        wonToRupeesPanel.setLayout(new GridLayout(2, 2));
        JLabel wonLabel2 = new JLabel("Won (Result)");
        JTextField wonField2 = new JTextField(10);
        JLabel rupeesLabel2 = new JLabel("<<<<Indian-Rupee (Enter)");
        JTextField rupeesField2 = new JTextField(10);
        rupeesField2.setEditable(false);
        wonToRupeesBtn = new JButton("Convert");
        wonToRupeesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double won = Double.parseDouble(wonField2.getText());
                    double rupees = won / 16.38;
                    rupeesField2.setText(String.format("%.2f", rupees));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CurrencyConverter.this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        wonToRupeesPanel.add(wonLabel2);
        wonToRupeesPanel.add(wonField2);
        wonToRupeesPanel.add(rupeesLabel2);
        wonToRupeesPanel.add(rupeesField2);
        wonToRupeesPanel.add(wonToRupeesBtn);

        // add the panels to the frame
        setLayout(new GridLayout(2, 1));
        add(rupeesToWonPanel);
        add(wonToRupeesPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rupeesToWonBtn) {
            try {
                double rupees = Double.parseDouble(rupeesField.getText());
                double won = rupees * 16.38;
                wonField.setText(String.format("%.2f", won));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
