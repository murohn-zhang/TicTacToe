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
        if (board != null) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j].draw(g);
                }
            }
        }
    }

    // draw header
    // add axis labels
    // draw squares
}
