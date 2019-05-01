import java.awt.*;
import java.io.IOException;

public class Block extends GameObject {
    public boolean bool = false;
    public int type;

    public int getType() {
        return type;
    }

    public double calcNewVel(double dx, double dy, double targetSpd) {
        targetSpd = targetSpd * targetSpd;
        dx = dx * dx;
        dy = dy * dy;
        double ret = targetSpd / (dx + dy);
        ret = Math.sqrt(ret);
        return ret;
    }
    public Block(double x, double y, double rotAngle, double side, int blockSpd) {
        super(x, y);
        type = 3;
        if (side == 1) {
                if (y == 0) {
                    if (rotAngle == 1) {
                        velX = 5*calcNewVel(5, 2, Math.sqrt((5*5)+(2*2))+(blockSpd/5));
                        velY = 2*calcNewVel(5, 2, Math.sqrt((5*5)+(2*2))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 5*calcNewVel(5, 5, Math.sqrt((5*5)+(5*5))+(blockSpd/5));
                        velY = 5*calcNewVel(5, 5, Math.sqrt((5*5)+(5*5))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 2*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                        velY = 5*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                    }
                } else if (y == 100) {
                    if (rotAngle == 1) {
                        velX = 5*calcNewVel(5, 2, Math.sqrt((5*5)+(2*2))+(blockSpd/5));
                        velY = 2*calcNewVel(5, 2, Math.sqrt((5*5)+(2*2))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 5*calcNewVel(5, 5, Math.sqrt((5*5)+(5*5))+(blockSpd/5));
                        velY = 5*calcNewVel(5, 5, Math.sqrt((5*5)+(5*5))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 2*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                        velY = 5*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                    }
                } else if (y == 200) {
                    if (rotAngle == 1) {
                        velX = 4*calcNewVel(4, 3, Math.sqrt((4*4)+3*3)+(blockSpd/5));
                        velY = 3*calcNewVel(4, 3, Math.sqrt((4*4)+3*3)+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 5*calcNewVel(5, 3, Math.sqrt((5*5)+3*3)+(blockSpd/5));
                        velY = 3*calcNewVel(5, 3, Math.sqrt((5*5)+3*3)+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 2*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                        velY = 5*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                    }
                } else if (y == 300) {
                    if (rotAngle == 1) {
                        velX = 4*calcNewVel(4, 3, Math.sqrt((4*4)+(3*3))+(blockSpd/5));
                        velY = 3*calcNewVel(4, 3, Math.sqrt((4*4)+(3*3))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 6*calcNewVel(6, 3, Math.sqrt((6*6)+(3*3))+(blockSpd/5));
                        velY = 3*calcNewVel(6, 3, Math.sqrt((6*6)+(3*3))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 2*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                        velY = 5*calcNewVel(2, 5, Math.sqrt((2*2)+(5*5))+(blockSpd/5));
                    }
                } else if (y == 400) {
                    if (rotAngle == 1) {
                        velX = 5*calcNewVel(5, -1, Math.sqrt((5*5)+(-1*-1))+(blockSpd/5));
                        velY = -1*calcNewVel(5, -1, Math.sqrt((5*5)+(-1*-1))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 6*calcNewVel(6, 2, Math.sqrt((6*6)+(2*2))+(blockSpd/5));
                        velY = 2*calcNewVel(6, 2, Math.sqrt((6*6)+(2*2))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 5*calcNewVel(5, 7, Math.sqrt((5*5)+(7*7))+(blockSpd/5));
                        velY = 7*calcNewVel(5, 7, Math.sqrt((5*5)+(7*7))+(blockSpd/5));
                    }
                } else if (y == 500) {
                    if (rotAngle == 1) {
                        velX = 5*calcNewVel(5, -3, Math.sqrt((5*5)+(3*3))+(blockSpd/5));
                        velY = -3*calcNewVel(5, -3, Math.sqrt((5*5)+(3*3))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 6*calcNewVel(6, 6, Math.sqrt((6*6)+(6*6))+(blockSpd/5));
                        velY = 6*calcNewVel(6, 6, Math.sqrt((6*6)+(6*6))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 6*calcNewVel(6, 3, Math.sqrt((6*6)+(3*3))+(blockSpd/5));
                        velY = 3*calcNewVel(6, 3, Math.sqrt((6*6)+(3*3))+(blockSpd/5));
                    }
                } else if (y == 600) {
                    if (rotAngle == 1) {
                        velX = 5*calcNewVel(5, -3, Math.sqrt((5*5)+(3*3))+(blockSpd/5));
                        velY = -3*calcNewVel(5, -3, Math.sqrt((5*5)+(3*3))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 6*calcNewVel(6, 6, Math.sqrt((6*6)+(6*6))+(blockSpd/5));
                        velY = 6*calcNewVel(6, 6, Math.sqrt((6*6)+(6*6))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 6*calcNewVel(6, 3, Math.sqrt((6*6)+(3*3))+(blockSpd/5));
                        velY = 3*calcNewVel(6, 3, Math.sqrt((6*6)+(3*3))+(blockSpd/5));
                    }
                } else if (y == 700) {
                    if (rotAngle == 1) {
                        velX = 4*calcNewVel(4, -5, Math.sqrt((4*4)+(-5*-5))+(blockSpd/5));
                        velY = -5*calcNewVel(4, -5, Math.sqrt((4*4)+(-5*-5))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 4*calcNewVel(4, -2, Math.sqrt((4*4)+(-2*-2))+(blockSpd/5));
                        velY = -2*calcNewVel(4, -2, Math.sqrt((4*4)+(-2*-2))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 5*calcNewVel(5, 3, Math.sqrt((5*5)+(3*3))+(blockSpd/5));
                        velY = 3*calcNewVel(5, 3, Math.sqrt((5*5)+(3*3))+(blockSpd/5));
                    }
                } else if (y == 800) {
                    if (rotAngle == 1) {
                        velX = 4*calcNewVel(4, -6, Math.sqrt((4*4)+(-6*-6))+(blockSpd/5));
                        velY = -6*calcNewVel(4, -6, Math.sqrt((4*4)+(-6*-6))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 5*calcNewVel(5, -4, Math.sqrt((5*5)+(-4*-4))+(blockSpd/5));
                        velY = -4*calcNewVel(5, -4, Math.sqrt((5*5)+(-4*-4))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 5*calcNewVel(5, -2, Math.sqrt((5*5)+(-2*-2))+(blockSpd/5));
                        velY = -2*calcNewVel(5, -2, Math.sqrt((5*5)+(-2*-2))+(blockSpd/5));
                    }
                } else if (y == 900) {
                    if (rotAngle == 1) {
                        velX = 4*calcNewVel(4, -7, Math.sqrt((4*4)+(-7*-7))+(blockSpd/5));
                        velY = -7*calcNewVel(4, -7, Math.sqrt((4*4)+(-7*-7))+(blockSpd/5));
                    } else if (rotAngle == 2) {
                        velX = 5*calcNewVel(5, -4, Math.sqrt((5*5)+(-4*-4))+(blockSpd/5));
                        velY = -4*calcNewVel(5, -4, Math.sqrt((5*5)+(-4*-4))+(blockSpd/5));
                    } else if (rotAngle == 3) {
                        velX = 5*calcNewVel(5, -1, Math.sqrt((5*5)+(-1*-1))+(blockSpd/5));
                        velY = -1*calcNewVel(5, -1, Math.sqrt((5*5)+(-1*-1))+(blockSpd/5));
                    }
                }
        } else if (side == 2) {
            if (y == 0) {
                if (rotAngle == 1) {
                    velX = -5*calcNewVel(-5, 2, Math.sqrt((-5*-5)+(2*2))+(blockSpd/5));
                    velY = 2*calcNewVel(-5, 2, Math.sqrt((-5*-5)+(2*2))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -5*calcNewVel(-5, 5, Math.sqrt((-5*-5)+(5*5))+(blockSpd/5));
                    velY = 5*calcNewVel(-5, 5, Math.sqrt((-5*-5)+(5*5))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -2*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                    velY = 5*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                }
            } else if (y == 100) {
                if (rotAngle == 1) {
                    velX = -5*calcNewVel(-5, 2, Math.sqrt((-5*-5)+(2*2))+(blockSpd/5));
                    velY = 2*calcNewVel(-5, 2, Math.sqrt((-5*-5)+(2*2))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -5*calcNewVel(-5, 5, Math.sqrt((-5*-5)+(5*5))+(blockSpd/5));
                    velY = 5*calcNewVel(-5, 5, Math.sqrt((-5*-5)+(5*5))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -2*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                    velY = 5*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                }
            } else if (y == 200) {
                if (rotAngle == 1) {
                    velX = -4*calcNewVel(-4, 3, Math.sqrt((-4*-4)+(3*3))+(blockSpd/5));
                    velY = 3*calcNewVel(-4, 3, Math.sqrt((-4*-4)+(3*3))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -6*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                    velY = 3*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -2*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                    velY = 5*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                }
            } else if (y == 300) {
                if (rotAngle == 1) {
                    velX = -4*calcNewVel(-4, 3, Math.sqrt((-4*-4)+(3*3))+(blockSpd/5));
                    velY = 3*calcNewVel(-4, 3, Math.sqrt((-4*-4)+(3*3))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -6*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                    velY = 3*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -2*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                    velY = 5*calcNewVel(-2, 5, Math.sqrt((-2*-2)+(5*5))+(blockSpd/5));
                }
            } else if (y == 400) {
                if (rotAngle == 1) {
                    velX = -5*calcNewVel(-5, -1, Math.sqrt((-5*-5)+(-1*-1))+(blockSpd/5));
                    velY = -1*calcNewVel(-5, -1, Math.sqrt((-5*-5)+(-1*-1))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX  = -6*calcNewVel(-6, 2, Math.sqrt((-6*-6)+(2*2))+(blockSpd/5));
                    velY = 2*calcNewVel(-6, 2, Math.sqrt((-6*-6)+(2*2))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -5*calcNewVel(-5, 7, Math.sqrt((-5*-5)+(7*7))+(blockSpd/5));
                    velY = 7*calcNewVel(-5, 7, Math.sqrt((-5*-5)+(7*7))+(blockSpd/5));
                }
            } else if (y == 500) {
                if (rotAngle == 1) {
                    velX = -5*calcNewVel(-5, -3, Math.sqrt((-5*-5)+(-3*-3))+(blockSpd/5));
                    velY = -3*calcNewVel(-5, -3, Math.sqrt((-5*-5)+(-3*-3))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -6*calcNewVel(-6, 6, Math.sqrt((-6*-6)+(6*6))+(blockSpd/5));
                    velY = 6*calcNewVel(-6, 6, Math.sqrt((-6*-6)+(6*6))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -6*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                    velY = 3*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                }
            } else if (y == 600) {
                if (rotAngle == 1) {
                    velX = -5*calcNewVel(-5, -3, Math.sqrt((-5*-5)+(3*3))+(blockSpd/5));
                    velY = -3*calcNewVel(-5, -3, Math.sqrt((-5*-5)+(3*3))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -6*calcNewVel(-6, 6, Math.sqrt((-6*-6)+(6*6))+(blockSpd/5));
                    velY = 6*calcNewVel(-6, 6, Math.sqrt((-6*-6)+(6*6))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -6*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                    velY = 3*calcNewVel(-6, 3, Math.sqrt((-6*-6)+(3*3))+(blockSpd/5));
                }
            } else if (y == 700) {
                if (rotAngle == 1) {
                    velX = -4*calcNewVel(-4, -5, Math.sqrt((-4*-4)+(-5*-5))+(blockSpd/5));
                    velY = -5*calcNewVel(-4, -5, Math.sqrt((-4*-4)+(-5*-5))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -4*calcNewVel(-4, -2, Math.sqrt((-4*-4)+(-2*-2))+(blockSpd/5));
                    velY = -2*calcNewVel(-4, -2, Math.sqrt((-4*-4)+(-2*-2))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -5*calcNewVel(-5, 3, Math.sqrt((-5*-5)+(3*3))+(blockSpd/5));
                    velY = 3*calcNewVel(-5, 3, Math.sqrt((-5*-5)+(3*3))+(blockSpd/5));
                }
            } else if (y == 800) {
                if (rotAngle == 1) {
                    velX = -4*calcNewVel(-4, -6, Math.sqrt((-4*-4)+(-6*-6))+(blockSpd/5));
                    velY = -6*calcNewVel(-4, -6, Math.sqrt((-4*-4)+(-6*-6))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -5*calcNewVel(-5, -4, Math.sqrt((-5*-5)+(-4*-4))+(blockSpd/5));
                    velY = -4*calcNewVel(-5, -4, Math.sqrt((-5*-5)+(-4*-4))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -5*calcNewVel(-5, -2, Math.sqrt((-5*-5)+(-2*-2))+(blockSpd/5));
                    velY = -2*calcNewVel(-5, -2, Math.sqrt((-5*-5)+(-2*-2))+(blockSpd/5));
                }
            } else if (y == 900) {
                if (rotAngle == 1) {
                    velX = -4*calcNewVel(-4, -7, Math.sqrt((-4*-4)+(-7*-7))+(blockSpd/5));
                    velY = -7*calcNewVel(-4, -7, Math.sqrt((-4*-4)+(-7*-7))+(blockSpd/5));
                } else if (rotAngle == 2) {
                    velX = -5*calcNewVel(-5, -4, Math.sqrt((-5*-5)+(-4*-4))+(blockSpd/5));
                    velY = -4*calcNewVel(-5, -4, Math.sqrt((-5*-5)+(-4*-4))+(blockSpd/5));
                } else if (rotAngle == 3) {
                    velX = -5*calcNewVel(-5, -1, Math.sqrt((-5*-5)+(-1*-1))+(blockSpd/5));
                    velY = -1*calcNewVel(-5, -1, Math.sqrt((-5*-5)+(-1*-1))+(blockSpd/5));
                }
            }
        }
    }

    public void tick () throws IOException {
        if (Game.gameState == 1) {
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
                        Game.handler.objects.remove(Game.p);
                        Game.writer.writeToFile(Game.scores, Integer.toString(Game.p.getScore()));
                        Game.gameState = 2;
                    }
                    bool = true;
                }
            }
            x += velX;
            y += velY;
        }
    }
    public void updateBoolean() {
        if (Game.secondsPassed % 2 == 0) {
            bool = false;
        }
    }

        public void render (Graphics g){
            g.setColor(Color.white);
            g.fillOval((int)x, (int)y, 90, 90);
        }
}
