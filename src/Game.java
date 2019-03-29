import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;


public class Game extends Canvas implements Runnable {

    private static final int WIDTH = 1800;
    private static final int HEIGHT = 1200;
    static int secondsPassed = 0;
    static Timer t;
    private Thread thread;
    private boolean running = false;
    private static boolean notDoneYet = true;
    private static Handler handler;
    public static Player p;
    public static Enemy e;
    public static Graphics g;

    public Game() {
        new Window(WIDTH, HEIGHT, "Dodge", this);

        handler = new Handler();
        p = new Player(100, 100, ID.Player);
        handler.addObject(p);
        e = new Enemy(800, 800, ID.Enemy);
        handler.addObject(e);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    p.setMoving(true);
                    p.setDestX(e.getX());
                    p.setDestY(e.getY());
                }
            }
        });
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        if (notDoneYet) {
            if (secondsPassed % 1 == 0) {
                int side = ThreadLocalRandom.current().nextInt(1, 5);
                int posGivenSide = ThreadLocalRandom.current().nextInt(0, 10);
                int rotAngle = ThreadLocalRandom.current().nextInt(1, 4);
                if (side == 1) {
                    if (posGivenSide == 0) {
                        if (rotAngle == 1) {
                            addBlock(0, 0, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 0, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 0, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 1) {
                        if (rotAngle == 1) {
                            addBlock(0, 100, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 100, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 100, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 2) {
                        if (rotAngle == 1) {
                            addBlock(0, 200, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 200, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 200, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 3) {
                        if (rotAngle == 1) {
                            addBlock(0, 300, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 300, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 300, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 4) {
                        if (rotAngle == 1) {
                            addBlock(0, 400, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 400, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 400, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 5) {
                        if (rotAngle == 1) {
                            addBlock(0, 500, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 500, ID.Block, 2);
                        } else if (rotAngle == 2) {
                            addBlock (0, 500, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 6) {
                        if (rotAngle == 1) {
                            addBlock (0, 600, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 600, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 600, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 7) {
                        if (rotAngle == 1) {
                            addBlock(0, 700, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 700, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 700, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 8) {
                        if (rotAngle == 1) {
                            addBlock(0, 800, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 800, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 800, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 9) {
                        if (rotAngle == 1) {
                            addBlock(0, 900, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 900, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 900, ID.Block, 3);
                        }
                        notDoneYet = false;
                    }
                } else if (side == 2) {
                    if (posGivenSide == 0) {
                        if (rotAngle == 1) {
                            addBlock(0, 0, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 0, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 0, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 1) {
                        if (rotAngle == 1) {
                            addBlock(0, 100, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 100, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 100, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 2) {
                        if (rotAngle == 1) {
                            addBlock(0, 200, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 200, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 200, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 3) {
                        if (rotAngle == 1) {
                            addBlock(0, 300, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 300, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 300, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 4) {
                        if (rotAngle == 1) {
                            addBlock(0, 400, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 400, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 400, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 5) {
                        if (rotAngle == 1) {
                            addBlock(0, 500, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 500, ID.Block, 2);
                        } else if (rotAngle == 2) {
                            addBlock(0, 500, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 6) {
                        if (rotAngle == 1) {
                            addBlock(0, 600, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 600, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 600, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 7) {
                        if (rotAngle == 1) {
                            addBlock(0, 700, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 700, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 700, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 8) {
                        if (rotAngle == 1) {
                            addBlock(0, 800, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 800, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 800, ID.Block, 3);
                        }
                        notDoneYet = false;
                    } else if (posGivenSide == 9) {
                        if (rotAngle == 1) {
                            addBlock(0, 900, ID.Block, 1);
                        } else if (rotAngle == 2) {
                            addBlock(0, 900, ID.Block, 2);
                        } else if (rotAngle == 3) {
                            addBlock(0, 900, ID.Block, 3);
                        }
                        notDoneYet = false;
                    }
                }
            }
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }


    private void addBlock(double posX, double posY, ID id, double rotAngle) {
            Block b = new Block(posX, posY, id, rotAngle);
            handler.addObject(b);
        }

    public static void main(String args[]) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                notDoneYet = true;
            }
        };
        t = new Timer();
        t.schedule(timerTask, 1000, 1000);
        new Game();
    }
}
