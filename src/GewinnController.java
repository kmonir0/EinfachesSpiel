import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        // Enter-Taste im Textfeld verarbeiten
        this.view.getTfDeineZahl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spielRundeAusfuehren();
            }
        });

        // "Noch einmal!"-Button verarbeiten
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
            view.getLblGesamtpunkte().setText(String.valueOf(model.getGesamtPunkte()));

            int erg = model.getRundenErgebnis();
            if (model.hatGewonnen()) {
                view.getLblRundenergebnis().setText("Gewonnen!");
            } else if (model.hatVerloren()) {
                view.getLblRundenergebnis().setText("Verloren");
            } else {
                String ergText = (erg > 0 ? "+" + erg : String.valueOf(erg));
                view.getLblRundenergebnis().setText(ergText);
            }

            // Farbliches Feedback setzen
            if (model.hatGewonnen() || erg > 0) {
                view.setErgebnisFarbeGruen();
            } else if (model.hatVerloren() || erg < 0) {
                view.setErgebnisFarbeRot();
            } else {
                view.setErgebnisFarbeZuruecksetzen();
            }

            // Bedienelemente sperren
            view.sperreEingabe();

        } catch (NumberFormatException ex) {
            view.getLblRundenergebnis().setText("Bitte eine Zahl eingeben!");
        }
    }

    private void resetRunde() {
        // Farbe zurücksetzen
        view.setErgebnisFarbeZuruecksetzen();

        // Entsperren in der View aufrufen
        view.entsperreEingabe();

        view.getTfComputerZahl().setText("");

        if (!model.hatGewonnen() && !model.hatVerloren()) {
            view.getLblRundenergebnis().setText("Tippe eine Zahl von 1 bis 9");
        }
    }
}