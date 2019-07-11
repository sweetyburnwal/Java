package lecture24;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.BufferPoolMXBean;
import java.util.logging.Handler;

/**
 * Created by piyush0 on 23/07/17.
 */
public class TTT extends JFrame implements ActionListener {

    public static final int BOARD_SIZE = 3;

    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
    private boolean crossTurn = false;

    private enum GameStatus {
        X_Wins, Z_Wins, Tie, Incomplete
    }



    public TTT() {

        super.setTitle("Tic Tac Toe");
        super.setResizable(false);
        super.setSize(600, 600);

        GridLayout layout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
        super.setLayout(layout);

        Font font = new Font("Comic Sans", 1, 125);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JButton button = new JButton("");
                button.setFont(font);
                button.addActionListener(this);
                buttons[row][col] = button;
                super.add(button);
            }
        }
        super.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        makeMove(button);

        GameStatus gs = getGameStatus();

        if (gs != GameStatus.Incomplete) {
            declareWinner(gs);
        }

    }

    private void declareWinner(GameStatus gs) {

        if (gs == GameStatus.X_Wins) {
            JOptionPane.showMessageDialog(this, "X Wins");
        } else if (gs == GameStatus.Z_Wins) {
            JOptionPane.showMessageDialog(this, "Z Wins");
        } else if (gs == GameStatus.Tie) {
            JOptionPane.showMessageDialog(this, "Tie");
        }

        int choice = JOptionPane.showConfirmDialog(this, "Restart?");

        if (choice == JOptionPane.YES_OPTION) {

            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    buttons[row][col].setText("");
                }
            }

            crossTurn = false;
        } else {
            super.dispose();
        }

    }

    private void makeMove(JButton button) {

        if (button.getText().length() > 0) {
            JOptionPane.showMessageDialog(this, "Invalid Move");
            return;
        }

        if (crossTurn) {
            button.setText("X");
        } else {
            button.setText("0");
        }

        crossTurn = !crossTurn;
    }

    private GameStatus getGameStatus() {

        String text1 = "";
        String text2 = "";

        int row = 0;
        int col = 0;

        while (row < BOARD_SIZE - 1) {

            text1 = buttons[row][col].getText();
            text2 = buttons[row + 1][col + 1].getText();
            if (!text1.equals(text2) || text1.length() == 0) {
                break;
            }
            col++;
            row++;
        }

        if (row == BOARD_SIZE - 1) {
            if (text1.equals("X")) {
                return GameStatus.X_Wins;
            } else {
                return GameStatus.Z_Wins;
            }
        }


        row = 0;
        col = BOARD_SIZE - 1;

        while (row < BOARD_SIZE - 1) {

            text1 = buttons[row][col].getText();
            text2 = buttons[row + 1][col - 1].getText();

            if (!text1.equals(text2) || text1.length() == 0) {
                break;
            }

            row++;
            col--;
        }


        if (row == BOARD_SIZE - 1) {
            if (text1.equals("X")) {
                return GameStatus.X_Wins;
            } else {
                return GameStatus.Z_Wins;
            }
        }


        row = 0;

        while (row < BOARD_SIZE) {

            col = 0;

            while (col < BOARD_SIZE - 1) {

                text1 = buttons[row][col].getText();
                text2 = buttons[row][col + 1].getText();

                if (!text1.equals(text2) || text1.length() == 0) {
                    break;
                }


                col++;
            }

            if (col == BOARD_SIZE - 1) {
                if (text1.equals("X")) {
                    return GameStatus.X_Wins;
                } else {
                    return GameStatus.Z_Wins;
                }
            }

            row++;
        }

        col = 0;
        while (col < BOARD_SIZE) {

            row = 0;

            while (row < BOARD_SIZE - 1) {

                text1 = buttons[row][col].getText();
                text2 = buttons[row + 1][col].getText();

                if (!text1.equals(text2) || text1.length() == 0) {
                    break;
                }

                row++;
            }

            if (row == BOARD_SIZE - 1) {
                if (text1.equals("X")) {
                    return GameStatus.X_Wins;
                } else {
                    return GameStatus.Z_Wins;
                }
            }

            col++;
        }


        for (row = 0; row < BOARD_SIZE; row++) {
            for (col = 0; col < BOARD_SIZE; col++) {
                if (buttons[row][col].getText().length() == 0) {
                    return GameStatus.Incomplete;
                }
            }
        }

        return GameStatus.Tie;
    }


}
