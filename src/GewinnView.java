import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    private JLabel lblRundenergebnisHeader;
    private JLabel lblGesamtpunkteHeader;
    private JLabel lblRundenergebnis;
    private JLabel lblGesamtpunkte;

    private JLabel lblDeineZahl;
    private JLabel lblComputerZahl;

    private JTextField tfDeineZahl;
    private JTextField tfComputerZahl;

    private JButton btnNochEinmal;

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Top Panel: Ergebnisse
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        lblRundenergebnisHeader = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        lblGesamtpunkteHeader = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);

        lblRundenergebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        lblRundenergebnis.setOpaque(true);
        lblRundenergebnis.setBackground(Color.WHITE);
        lblRundenergebnis.setFont(new Font("SansSerif", Font.BOLD, 12));

        lblGesamtpunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        lblGesamtpunkte.setOpaque(true);
        lblGesamtpunkte.setBackground(Color.WHITE);
        lblGesamtpunkte.setFont(new Font("SansSerif", Font.BOLD, 12));

        topPanel.add(lblRundenergebnisHeader);
        topPanel.add(lblGesamtpunkteHeader);
        topPanel.add(lblRundenergebnis);
        topPanel.add(lblGesamtpunkte);

        add(topPanel, BorderLayout.NORTH);

        // Center Panel: Eingabe und Computerzahl
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        lblDeineZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        lblComputerZahl = new JLabel("Computer:", SwingConstants.CENTER);

        tfDeineZahl = new JTextField();
        tfDeineZahl.setHorizontalAlignment(JTextField.CENTER);
        tfDeineZahl.setFont(new Font("SansSerif", Font.BOLD, 18));

        tfComputerZahl = new JTextField();
        tfComputerZahl.setHorizontalAlignment(JTextField.CENTER);
        tfComputerZahl.setFont(new Font("SansSerif", Font.BOLD, 18));
        tfComputerZahl.setEditable(false);

        centerPanel.add(lblDeineZahl);
        centerPanel.add(lblComputerZahl);
        centerPanel.add(tfDeineZahl);
        centerPanel.add(tfComputerZahl);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel: Button
        JPanel bottomPanel = new JPanel();
        btnNochEinmal = new JButton("Noch einmal!");
        bottomPanel.add(btnNochEinmal);

        add(bottomPanel, BorderLayout.SOUTH);
        btnNochEinmal.setEnabled(false);
    }

    // Getter für den Controller
    public JTextField getTfDeineZahl() { return tfDeineZahl; }
    public JTextField getTfComputerZahl() { return tfComputerZahl; }
    public JLabel getLblRundenergebnis() { return lblRundenergebnis; }
    public JLabel getLblGesamtpunkte() { return lblGesamtpunkte; }
    public JButton getBtnNochEinmal() { return btnNochEinmal; }

    public void setErgebnisFarbeGruen() {
        lblRundenergebnis.setBackground(Color.GREEN);
    }

    public void setErgebnisFarbeRot() {
        lblRundenergebnis.setBackground(Color.RED);
    }

    public void setErgebnisFarbeZuruecksetzen() {
        lblRundenergebnis.setBackground(null);
    }
}