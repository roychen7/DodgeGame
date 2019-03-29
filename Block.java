import java.awt.*;

public class Block extends GameObject {
    public boolean bool = false;
    public int type;

    public int getType() {
        return type;
    }

    public Block(double x, double y, double rotAngle, double side) {
        super(x, y);
        type = 3;
        if (side == 1) {
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
        } else if (side == 2) {
            if (y == 0) {
                if (rotAngle == 1) {
                    velX = -5;
                    velY = 2;
                } else if (rotAngle == 2) {
                    velX = -5;
                    velY = 5;
                } else if (rotAngle == 3) {
                    velX = -2;
                    velY = 5;
                }
            } else if (y == 100) {
                if (rotAngle == 1) {
                    velX = -5;
                    velY = 2;
                } else if (rotAngle == 2) {
                    velX = -5;
                    velY = 5;
                } else if (rotAngle == 3) {
                    velX = -2;
                    velY = 5;
                }
            } else if (y == 200) {
                if (rotAngle == 1) {
                    velX = -4;
                    velY = 3;
                } else if (rotAngle == 2) {
                    velX = -6;
                    velY = 3;
                } else if (rotAngle == 3) {
                    velX = -2;
                    velY = 5;
                }
            } else if (y == 300) {
                if (rotAngle == 1) {
                    velX = -4;
                    velY = 3;
                } else if (rotAngle == 2) {
                    velX = -6;
                    velY = 3;
                } else if (rotAngle == 3) {
                    velX = -2;
                    velY = 5;
                }
            } else if (y == 400) {
                if (rotAngle == 1) {
                    velX = -5;
                    velY = -1;
                } else if (rotAngle == 2) {
                    velX  = -6;
                    velY = 2;
                } else if (rotAngle == 3) {
                    velX = -5;
                    velY = 7;
                }
            } else if (y == 500) {
                if (rotAngle == 1) {
                    velX = -5;
                    velY = -3;
                } else if (rotAngle == 2) {
                    velX = -6;
                    velY = 6;
                } else if (rotAngle == 3) {
                    velX = -6;
                    velY = 3;
                }
            } else if (y == 600) {
                if (rotAngle == 1) {
                    velX = -5;
                    velY = -3;
                } else if (rotAngle == 2) {
                    velX = -6;
                    velY = 6;
                } else if (rotAngle == 3) {
                    velX = -6;
                    velY = 3;
                }
            } else if (y == 700) {
                if (rotAngle == 1) {
                    velX = -4;
                    velY = -5;
                } else if (rotAngle == 2) {
                    velX = -4;
                    velY = -2;
                } else if (rotAngle == 3) {
                    velX = -5;
                    velY = 3;
                }
            } else if (y == 800) {
                if (rotAngle == 1) {
                    velX = -4;
                    velY = -6;
                } else if (rotAngle == 2) {
                    velX = -5;
                    velY = -4;
                } else if (rotAngle == 3) {
                    velX = -5;
                    velY = -2;
                }
            } else if (y == 900) {
                if (rotAngle == 1) {
                    velX = -4;
                    velY = -7;
                } else if (rotAngle == 2) {
                    velX = -5;
                    velY = -4;
                } else if (rotAngle == 3) {
                    velX = -5;
                    velY = -1;
                }
            }
        }
    }

    public void tick ()  {
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
        x += velX;
        y += velY;
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
