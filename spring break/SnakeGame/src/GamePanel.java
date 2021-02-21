import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25; // As the unit size is used throughout the program, we can change this value to alter the entire grid size
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    // Holds x coords of snakes body parts
    final int x[] = new int [GAME_UNITS];
    // Holds y coords of snakes body parts
    final int y[] = new int [GAME_UNITS];

    int bodyParts = 6;
    int applesEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R'; //Snake starts going right, R, L, U, D
    boolean running = false;

    Timer timer;
    Random random;


    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new myKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (running) {
            /* Used to visualize the grid whilst developing the game
            for (int i = 0; i < (SCREEN_HEIGHT/ UNIT_SIZE); i++) {
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }
             */

            // Drawing the apple
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Drawing the snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) { // Then we are dealing with the head of the snake
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else { // Not dealing with the body of the snake
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }

                // The current score
                g.setColor(Color.BLUE);
                g.setFont(new Font("Ink Free", Font.BOLD, 40));
                // Font metrics are useful for lining up text on a screen
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());

            }
        } else { // If snake Died
            gameOver(g);
        }

    }

    public void newApple() {
        appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

    }

    public void move() {
        // Used for shifting the body parts
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U': // Moving Up
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D': // Moving Down
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L': // Moving Left
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R': // Moving Right
                x[0] = x[0] + UNIT_SIZE;
                break;

        }

    }

    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() { // Checks if any of the snakes body parts are overlapping
        // Checks if head collides with the body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) { // If head x coord or head y coord is same as coord of body part then there must have been a collision
                running = false; // Stops the game
            }
        }

        // Checks if head touches left border
        if (x[0] < (0)) {
            running = false;
        }

        // Checks if head touches right border
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }

        // Checks if head touches top border
        if (y[0] < 0) {
            running = false;
        }

        // Checks of head touches the bottom border
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running){
            timer.stop();
        }

    }

    public void gameOver(Graphics g) {
        // Gameover text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        // Font metrics are useful for lining up text on a screen
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

        // Final Score
        g.setColor(Color.BLUE);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        // Font metrics are useful for lining up text on a screen
        metrics = getFontMetrics(g.getFont());
        g.drawString("Final Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Final Score: " + applesEaten)) / 2, (SCREEN_HEIGHT / 2) - 90);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        } repaint();

    }

    public class myKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            // Grabs User input
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }

        }
    }

}
