import java.awt.*;

public abstract class GameObject {
    protected double x, y;
    protected int type;
    protected double velX, velY;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void updateBoolean();

    public abstract int getType();

    public abstract void tick();

    public abstract void render(Graphics g);

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getVelX() {
        return velX;
    }
    public double getVelY() {
        return velY;
    }
    public void setVelX(int x) {
        this.velX = x;
    }
    public void setVelY(int y) {
        this.velY = y;
    }
}
