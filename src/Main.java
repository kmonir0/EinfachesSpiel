import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GewinnModel model = new GewinnModel();
                GewinnView view = new GewinnView();
                new GewinnController(model, view);
                view.setVisible(true);
            }
        });
    }
}