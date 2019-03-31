import java.awt.*;

public class Enemy extends GameObject {
    public boolean moving;
    private double destX;
    private double destY;
    private double speed;
    public int type;
    private int hp;
    private boolean bool;

    public Enemy(double x, double y, int enemyCounter) {
        super(x, y);
        velX = 0;
        velY = 0;
        destX = x;
        destY = y;
        if (2 + (enemyCounter/5) > 7) {
            speed = 7;
        } else {
            speed = 2 + (enemyCounter / 5);
        }
        type = 2;
        hp = 100;
        bool = false;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getHP() {
        return this.hp;
    }

    public void decHP() {
        hp = hp - 25;
    }

    public int getType() {
        return type;
    }
    public void setDestX(double x) {
        this.destX = x;
    }

    public void setDestY(double y) {
        this.destY = y;
    }

    public void updateBoolean() {
        if (Game.secondsPassed % 2 == 0) {
            bool = false;
        }
    }

    public void tick() {
        if (!bool) {
            double xDiff = x - Game.p.getX();
            double yDiff = y - Game.p.getY();
            double distTotalSquared = xDiff * xDiff + yDiff * yDiff;
            double distTotal = Math.sqrt(distTotalSquared);
            if (distTotal < 77) {
                if (Game.p.decLives() > 0) {
                    System.out.println(Game.p.returnLives() + " lives remaining!");
                } else {
                    System.out.println("Game over!");
                }
                bool = true;
            }
        }
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
        g.setColor(Color.red);
        g.fillOval((int)x, (int)y, 100, 100);
        g.drawString("HP: " + getHP(), (int)x, (int)y);
    }
}
