import java.awt.*;

public class Enemy extends GameObject {
    public boolean moving;
    private double destX;
    private double destY;
    private double speed;

    public Enemy(double x, double y, ID id) {
        super(x, y, id);
        velX = 0;
        velY = 0;
        destX = x;
        destY = y;
        speed = 2;
    }

    public void setDestX(double x) {
        this.destX = x;
    }

    public void setDestY(double y) {
        this.destY = y;
    }
    public void tick() {
        destX = Game.p.getX();
        destY = Game.p.getY();
        if ((Math.abs(x - destX) < 8) && (Math.abs(y - destY) < 8)) {
            moving = false;
        } else {
            moving = true;
        }
        if (moving) {

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

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 50, 50);
    }
}
