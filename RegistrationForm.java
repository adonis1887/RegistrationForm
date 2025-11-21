/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADONIS
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {

    JLabel labelTitulli, labelEmri, labelMbiemri, labelEmail, labelFjalekalimi, labelGjinia, labelQyteti, labelKoment;
    JTextField textFieldEmri, textFieldMbiemri, textFieldEmail;
    JPasswordField passwordFieldFjalekalimi;

    JRadioButton radioButtonMashkull, radioButtonFemer;
    ButtonGroup groupGjinia;

    JComboBox<String> comboBoxQyteti;

    JTextArea textAreaKoment;
    JScrollPane scrollPaneKoment;

    JButton buttonRegjistrohu, buttonPastro;

    JMenuBar menuBar;
    JMenu menuOpsione;
    JMenuItem menuItemDalje;

    public RegistrationForm() {

        setTitle("Registration Form");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        labelTitulli = new JLabel("Registration Form");
        labelTitulli.setFont(new Font("Arial", Font.BOLD, 22));
        labelTitulli.setBounds(150, 10, 300, 30);
        add(labelTitulli);

        labelEmri = new JLabel("Emri:");
        labelEmri.setBounds(50, 60, 100, 25);
        add(labelEmri);

        textFieldEmri = new JTextField();
        textFieldEmri.setBounds(180, 60, 240, 25);
        add(textFieldEmri);

        labelMbiemri = new JLabel("Mbiemri:");
        labelMbiemri.setBounds(50, 100, 100, 25);
        add(labelMbiemri);

        textFieldMbiemri = new JTextField();
        textFieldMbiemri.setBounds(180, 100, 240, 25);
        add(textFieldMbiemri);

        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(50, 140, 100, 25);
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(180, 140, 240, 25);
        add(textFieldEmail);

        labelFjalekalimi = new JLabel("Fjalëkalimi:");
        labelFjalekalimi.setBounds(50, 180, 120, 25);
        add(labelFjalekalimi);

        passwordFieldFjalekalimi = new JPasswordField();
        passwordFieldFjalekalimi.setBounds(180, 180, 240, 25);
        add(passwordFieldFjalekalimi);

        labelGjinia = new JLabel("Gjinia:");
        labelGjinia.setBounds(50, 220, 100, 25);
        add(labelGjinia);

        radioButtonMashkull = new JRadioButton("Mashkull");
        radioButtonMashkull.setBounds(180, 220, 100, 25);

        radioButtonFemer = new JRadioButton("Femër");
        radioButtonFemer.setBounds(280, 220, 100, 25);

        groupGjinia = new ButtonGroup();
        groupGjinia.add(radioButtonMashkull);
        groupGjinia.add(radioButtonFemer);

        add(radioButtonMashkull);
        add(radioButtonFemer);

        labelQyteti = new JLabel("Qyteti:");
        labelQyteti.setBounds(50, 260, 100, 25);
        add(labelQyteti);

        String[] qytetet = {"Prishtinë", "Fushë Kosovë", "Mitrovicë", "Ferizaj", "Gjakovë", "Pejë", "Prizren"};
        comboBoxQyteti = new JComboBox<>(qytetet);
        comboBoxQyteti.setBounds(180, 260, 240, 25);
        add(comboBoxQyteti);

        labelKoment = new JLabel("Koment / Adresë:");
        labelKoment.setBounds(50, 300, 150, 25);
        add(labelKoment);

        textAreaKoment = new JTextArea();
        textAreaKoment.setLineWrap(true);
        textAreaKoment.setWrapStyleWord(true);

        scrollPaneKoment = new JScrollPane(textAreaKoment);
        scrollPaneKoment.setBounds(180, 300, 240, 90);
        add(scrollPaneKoment);

        buttonRegjistrohu = new JButton("Regjistrohu");
        buttonRegjistrohu.setBounds(180, 420, 110, 35);
        buttonRegjistrohu.addActionListener(this);
        add(buttonRegjistrohu);

        buttonPastro = new JButton("Pastro");
        buttonPastro.setBounds(310, 420, 110, 35);
        buttonPastro.addActionListener(this);
        add(buttonPastro);

        // Menu
        menuBar = new JMenuBar();
        menuOpsione = new JMenu("Opsione");
        menuItemDalje = new JMenuItem("Dalje");
        menuItemDalje.addActionListener(e -> System.exit(0));

        menuOpsione.add(menuItemDalje);
        menuBar.add(menuOpsione);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonRegjistrohu) {

            String emri = textFieldEmri.getText().trim();
            String mbiemri = textFieldMbiemri.getText().trim();
            String email = textFieldEmail.getText().trim();
            String password = String.valueOf(passwordFieldFjalekalimi.getPassword()).trim();
            String gjinia = radioButtonMashkull.isSelected() ? "Mashkull" :
                            radioButtonFemer.isSelected() ? "Femër" : "";
            String qyteti = comboBoxQyteti.getSelectedItem().toString();
            String koment = textAreaKoment.getText().trim();

            if (emri.isEmpty() || mbiemri.isEmpty() || email.isEmpty() ||
                password.isEmpty() || gjinia.isEmpty() || koment.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Ju lutem plotësoni të gjitha fushat para regjistrimit.",
                        "Gabim",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String message = "Regjistrimi u krye me sukses.\n\n"
                    + "Emri: " + emri + "\n"
                    + "Mbiemri: " + mbiemri + "\n"
                    + "Email: " + email + "\n"
                    + "Gjinia: " + gjinia + "\n"
                    + "Qyteti: " + qyteti + "\n"
                    + "Koment: " + koment;

            JOptionPane.showMessageDialog(this, message, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == buttonPastro) {
            textFieldEmri.setText("");
            textFieldMbiemri.setText("");
            textFieldEmail.setText("");
            passwordFieldFjalekalimi.setText("");
            groupGjinia.clearSelection();
            comboBoxQyteti.setSelectedIndex(0);
            textAreaKoment.setText("");
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}