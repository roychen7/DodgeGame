import java.awt.*;

public class Projectile extends GameObject {
    private double startX;
    private double startY;
    private double destX;
    private double destY;
    private double speed;
    private boolean show;
    public int type = 4;
    private boolean friendly;
    private boolean bool;

    public int getType() {
        return this.type;
    }

    public void updateBoolean() {
        if (Game.secondsPassed % 2 == 0) {
            bool = false;
        }
    }

    public void setFriendly(boolean b) {
        this.friendly = b;
    }

    public boolean getFriendly() {
        return this.friendly;
    }
    public Projectile(double x, double y, double destX, double destY, boolean friendly) {
        super(x, y);
        this.startX = x;
        this.startY = y;
        this.destX = destX;
        this.destY = destY;
        this.friendly = friendly;
        speed = 15;
        show = true;
        bool = false;
        }

    public void tick() {
        if (show) {
            if (!bool) {
                if (Game.findEnemy() != -1) {
                    double xDiff = x - Game.handler.objects.get(Game.findEnemy()).getX();
                    double yDiff = y - Game.handler.objects.get(Game.findEnemy()).getY();
                    double distTotalSquared = xDiff * xDiff + yDiff * yDiff;
                    double distTotal = Math.sqrt(distTotalSquared);
                    if (distTotal < 75) {
                        Enemy e = (Enemy)Game.handler.objects.get(Game.findEnemy());
                        if (e.getHP() > 26) {
                            e.decHP();
                            System.out.println(e.getHP() + " hp remaining");
                        } else {
                            Game.handler.objects.remove(e);
                            Game.p.incScore(5);
                        }
                        bool = true;
                    }
                }
            }

            double tempX = destX - startX;
            double tempY = destY - startY;
            tempX = tempX * tempX;
            tempY = tempY * tempY;

            double tempInt = speed * speed;
            tempInt = tempInt/(tempX + tempY);
            tempInt = Math.sqrt(tempInt);
            velX = tempInt * (destX - startX);
            velY = tempInt * (destY - startY);

            x += velX;
            y += velY;

            double distX1 = x - startX;
            double distY1 = y - startY;
            distX1 = distX1 * distX1;
            distY1 = distY1 * distY1;
            double distZ = Math.sqrt(distX1 + distY1);
            if (distZ > Game.dist) {
                show = false;
            }
        } else {
            Game.handler.objects.remove(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval((int)x, (int)y, 50, 50);
    }
}
