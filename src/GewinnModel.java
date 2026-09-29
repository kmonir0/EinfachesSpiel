import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30; // Startpunkte gemäß Spielregeln
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    public void berechneComputerZahl() {
        Random random = new Random();
        this.computerZahl = random.nextInt(9) + 1; // Zahl von 1 bis 9
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();

        int diff = Math.abs(this.spielerZahl - this.computerZahl);

        if (diff == 0) {
            this.rundenErgebnis = 20; // Gleiche Zahl
        } else if (diff == 1) {
            this.rundenErgebnis = 5;  // Um 1 größer oder kleiner
        } else {
            this.rundenErgebnis = -10; // Andere Zahl
        }

        this.gesamtPunkte += this.rundenErgebnis;
    }
    public boolean hatGewonnen() {
        return this.gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return this.gesamtPunkte <= 0;
    }
}