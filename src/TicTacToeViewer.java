import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private TicTacToe ticTacToe;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private Image markerO;
    private Image markerX;
    private final int HEADER_HEIGHT = 23;


    // Constructor
    public TicTacToeViewer(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        markerO = new ImageIcon("Resources/O.png").getImage();
        markerX = new ImageIcon("Resources/X.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    // Image getters
    public Image getMarkerO() {
        return markerO;
    }

    public Image getMarkerX() {
        return markerX;
    }

    public void paint(Graphics g) {

        Square[][] board = ticTacToe.getBoard();
        // Change color to red and set font to be red and in italics
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.ITALIC, 20));

    // Label axis
        // Label rows
        for (int i = 0; i < board.length; i++) {
            String num = Integer.toString(i);
            g.drawString(num, 50, (100 * (i + 1)) + 50);
        }
        // Label cols
        for (int i = 0; i < board.length; i++) {
            String num = Integer.toString(i);
            g.drawString(num, (100 * (i + 1)) + 50, 50 + HEADER_HEIGHT);
        }
        // Reset color
        g.setColor(Color.BLACK);

    // Draw squares
        if (board != null) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j].draw(g);
                }
            }
        }

        if (ticTacToe.getGameOver() == true) {
            // Print winner
            String winner = ticTacToe.getWinner();
            g.setFont(new Font("Serif", Font.BOLD, 75));
            if (winner.equals("X")) {
                // make sure it's centered
                g.drawString("X Wins", 125, 475);
            }
            else if (winner.equals("O")) {
                g.drawString("O Wins", 125, 475);
            }
            else {
                g.drawString("It's a tie!", 125, 475);
            }
        }
    }




}
