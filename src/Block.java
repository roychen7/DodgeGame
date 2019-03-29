import java.awt.*;

public class Block extends GameObject {
    private boolean moving;
    private double destX;
    private double destY;
    private double speed;
    private double rotAngle;
    private boolean alreadyRotated;
    private int counter = 0;

    public Block(double x, double y, ID id) {
        super(x, y, id);
        velX = 5;
        velY = 5;
    }

    public Block(double x, double y, ID id, double rotAngle) {
        super(x, y, id);
        if (x == 0) {
            if (y == 0) {
                if (rotAngle == 1) {
                    velX = 5;
                    velY = 2;
                } else if (rotAngle == 2) {
                    velX = 5;
                    velY = 5;
                } else if (rotAngle == 3) {
                    velX = 2;
                    velY = 5;
                }
            } else if (y == 100) {
                if (rotAngle == 1) {
                    velX = 5;
                    velY = 2;
                } else if (rotAngle == 2) {
                    velX = 5;
                    velY = 5;
                } else if (rotAngle == 3) {
                    velX = 2;
                    velY = 5;
                }
            } else if (y == 200) {
                if (rotAngle == 1) {
                    velX = 4;
                    velY = 3;
                } else if (rotAngle == 2) {
                    velX = 6;
                    velY = 3;
                } else if (rotAngle == 3) {
                    velX = 2;
                    velY = 5;
                }
            } else if (y == 300) {
                if (rotAngle == 1) {
                    velX = 4;
                    velY = 3;
                } else if (rotAngle == 2) {
                    velX = 6;
                    velY = 3;
                } else if (rotAngle == 3) {
                    velX = 2;
                    velY = 5;
                }
            } else if (y == 400) {
                if (rotAngle == 1) {
                    velX = 5;
                    velY = -1;
                } else if (rotAngle == 2) {
                    velX  = 6;
                    velY = 2;
                } else if (rotAngle == 3) {
                    velX = 5;
                    velY = 7;
                }
            } else if (y == 500) {
                if (rotAngle == 1) {
                    velX = 5;
                    velY = -3;
                } else if (rotAngle == 2) {
                    velX = 6;
                    velY = 6;
                } else if (rotAngle == 3) {
                    velX = 6;
                    velY = 3;
                }
            } else if (y == 600) {
                if (rotAngle == 1) {
                    velX = 5;
                    velY = -3;
                } else if (rotAngle == 2) {
                    velX = 6;
                    velY = 6;
                } else if (rotAngle == 3) {
                    velX = 6;
                    velY = 3;
                }
            } else if (y == 700) {
                if (rotAngle == 1) {
                    velX = 4;
                    velY = -5;
                } else if (rotAngle == 2) {
                    velX = 4;
                    velY = -2;
                } else if (rotAngle == 3) {
                    velX = 5;
                    velY = 3;
                }
            } else if (y == 800) {
                if (rotAngle == 1) {
                    velX = 4;
                    velY = -6;
                } else if (rotAngle == 2) {
                    velX = 5;
                    velY = -4;
                } else if (rotAngle == 3) {
                    velX = 5;
                    velY = -2;
                }
            } else if (y == 900) {
                if (rotAngle == 1) {
                    velX = 4;
                    velY = -7;
                } else if (rotAngle == 2) {
                    velX = 5;
                    velY = -4;
                } else if (rotAngle == 3) {
                    velX = 5;
                    velY = -1;
                }
            }
        }
    }

        public void setRotAngle ( double x){
            rotAngle = x;
        }

        public void tick () {
        x += velX;
        y += velY;
        }

        public void render (Graphics g){
            g.setColor(Color.white);
            double tempX = x;
            double tempY = y;
            tempX = tempX - 15; // r = 90
            tempY = tempY - 15; // r = 90
            g.fillOval((int)tempX, (int)tempY, 90, 90);
        }
}
