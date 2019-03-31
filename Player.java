import java.awt.*;

public class Player extends GameObject {
    private boolean moving;
    private double destX;
    private double destY;
    private int type;
    public double speed;
    private int lives;
    private int score;

    public Player(double x, double y) {
        super(x, y);
        moving = false;
        velX = 5;
        velY = 5;
        destX = x;
        destY = y;
        speed = 9;
        type = 1;
        lives = 3;
        score = 0;
    }

    public void updateBoolean() {

    }

    public void incScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public void incScore(int inc) {
        score = score + inc;
    }

    public int getType() {
        return type;
    }

    public void setMoving(boolean b) {
        moving = b;
    }

    public void setDestX(int x) {
        this.destX = x;
    }

    public void setDestY(int y) {
        this.destY = y;
    }

    public double getDestX() {
        return destX;
    }

    public double getDestY() {
        return destY;
    }

    public void move() {
    }

    public void tick() {
        if (Game.gameState == 1) {
            if ((Math.abs(x - destX) < 8) && (Math.abs(y - destY) < 8)) {
                moving = false;
            } else if (moving) {

                double diffX = destX - x;
                double diffY = destY - y;

                double temp = speed * speed;
                double tempDiffX = diffX * diffX;
                double tempDiffY = diffY * diffY;

                double a = temp / (tempDiffX + tempDiffY);
                a = Math.sqrt(a);
                velX = a * diffX;
                velY = a * diffY;

                x += velX;
                y += velY;
            }
        }
    }

    public int decLives() {
        lives--;
        if (lives > 0) {
            return 1;
        } else return -1;
    }

    public int returnLives() {
        return lives;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillOval((int)x, (int)y, 64, 64);
        g.drawString("Score:" + " " + getScore(), (int)x, (int)y);
        g.drawString("Lives left: " + returnLives(), (int)x, (int)y +80);
    }
}
