
package gamecharacter;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println(
                        "Using the default Java appearance.");
            }

            GameGUI game = new GameGUI();
            game.setVisible(true);
        });
    }
}
