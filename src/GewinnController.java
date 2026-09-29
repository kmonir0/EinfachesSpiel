import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        // Listener für Enter-Taste im Textfeld
        this.view.getTfDeineZahl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spielRundeAusfuehren();
            }
        });

        // Listener für "Noch einmal!"-Button
        this.view.getBtnNochEinmal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetRunde();
            }
        });
    }

    private void spielRundeAusfuehren() {
        try {
            int eingabe = Integer.parseInt(view.getTfDeineZahl().getText().trim());
            if (eingabe < 1 || eingabe > 9) {
                view.getLblRundenergebnis().setText("Ungültige Zahl (1-9)!");
                return;
            }

            model.berechneRunde(eingabe);

            // Ansicht aktualisieren
            view.getTfComputerZahl().setText(String.valueOf(model.getComputerZahl()));

            int erg = model.getRundenErgebnis();
            String ergText = (erg > 0 ? "+" + erg : String.valueOf(erg));
            view.getLblRundenergebnis().setText(ergText);

            // Farbliches Feedback setzen (version-2.0)
            if (erg > 0) {
                view.setErgebnisFarbeGruen();
            } else if (erg < 0) {
                view.setErgebnisFarbeRot();
            } else {
                view.setErgebnisFarbeZuruecksetzen();
            }

            // Gewinn- / Verlustzustand auswerten
            if (model.hatGewonnen()) {
                view.getLblGesamtpunkte().setText(String.valueOf(model.getGesamtPunkte()));
                view.getLblRundenergebnis().setText("Gewonnen!");
            } else if (model.hatVerloren()) {
                view.getLblGesamtpunkte().setText(String.valueOf(model.getGesamtPunkte()));
                view.getLblRundenergebnis().setText("Verloren");
            } else {
                view.getLblGesamtpunkte().setText(String.valueOf(model.getGesamtPunkte()));
            }

        } catch (NumberFormatException ex) {
            view.getLblRundenergebnis().setText("Bitte eine Zahl eingeben!");
        }
    }

    private void resetRunde() {

        // Farbe und Felder zurücksetzen (version-2.0)
        view.setErgebnisFarbeZuruecksetzen();
        view.getTfComputerZahl().setText("");

        if (!model.hatGewonnen() && !model.hatVerloren()) {
            view.getLblRundenergebnis().setText("Tippe eine Zahl von 1 bis 9");
        }
    }
}