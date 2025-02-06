import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private TicTacToeViewer window;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer window) {
        this.row = row;
        this.col = col;
        this.window = window;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    // Draw square
    public void draw(Graphics g) {
        int xLoc = (row + 1) * 100;
        int yLoc = (col + 1) * 100;
        g.drawRect(xLoc, yLoc, 100, 100);

        // Highlighting winning squares
        if (isWinningSquare == true) {
            g.setColor(Color.GREEN);
            g.fillRect(xLoc, yLoc, 100, 100);
            g.setColor(Color.BLACK);
        }

        if (marker.equals("O")) {
            g.drawImage(window.getMarkerO(), xLoc, yLoc, 100, 100, window);
        }
        else if (marker.equals("X")) {
            g.drawImage(window.getMarkerX(), xLoc, yLoc, 100, 100, window);
        }

    }
}
