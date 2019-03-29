import java.awt.*;

public class Player extends GameObject {
    private boolean moving;
    private double destX;
    private double destY;
    private double speed;

    public Player(double x, double y, ID id) {
        super(x, y, id);
        moving = false;
        velX = 5;
        velY = 5;
        destX = x;
        destY = y;
        speed = 9;
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
            velX = a*diffX;
            velY = a*diffY;

            x += velX;
            y += velY;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval((int)x, (int)y, 64, 64);
    }
}
