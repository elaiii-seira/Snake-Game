import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Moving_Snake {

    public Moving_Snake() {

        // Frame setup
        final JFrame f = new JFrame("Snake");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        f.setLayout(null);
        f.setSize(600, 600);
        f.setLocationRelativeTo(null);

        // Labels
        final JLabel L = new JLabel("Welcome to Eat it All Snake");
        L.setBounds(150, 100, 300, 20);
        L.setForeground(Color.WHITE);
        L.setFont(new Font("Rubik", Font.BOLD, 18));

        final JLabel L1 = new JLabel("Choose whether to start the game:");
        L1.setBounds(170, 150, 300, 15);
        L1.setForeground(Color.WHITE);
        L1.setFont(new Font("Rubik", Font.BOLD, 12));

        // Start Button
        final JButton b1 = new JButton("START");
        b1.setBounds(150, 180, 250, 50);
        b1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLUE);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
                f.dispose(); // Close the main menu window
            }
        });

        // Exit Button
        final JButton b2 = new JButton("EXIT");
        b2.setBounds(150, 250, 250, 50);
        b2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.RED);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add components to frame
        f.add(L);
        f.add(L1);
        f.add(b1);
        f.add(b2);

        f.setVisible(true);
    }

    private void startGame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create a new SnakeGame object
                SnakeGame game = new SnakeGame(600, 600);
                
                // Add the SnakeGame to a new JFrame
                JFrame frame = new JFrame("Snake Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.BLACK);
                frame.add(game);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                // Start the game
                game.startGame();
                game.requestFocusInWindow();
            }
        });
    }

    public static void main(String[] args) {
        new Moving_Snake();
    }
}
