import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;


public class Game extends Canvas implements Runnable {

    private static final int WIDTH = 1800;
    private static final int HEIGHT = 1200;
    public static final int dist = 600;
    public static int secondsPassed = 0;
    static Timer t;
    private Thread thread;
    private static boolean running = false;
    private static boolean notDoneYet = true;
    public static Handler handler;
    public static Player p;
    public static Enemy e;
    public static Graphics g;
    private int enemyCounter;
    private int blockSpd;
    public static int gameState;
    private int noClicks;
    public static FileWriter writer;
    public static String scores = System.getProperty("user.dir") + "/src/Highscores";
    List<String> temp;
    ArrayList<Integer> tempInts;
    public static  BufferedImage fireball;

    public Game() throws IOException, URISyntaxException {
        fireball = ImageIO.read(new File("fireball.png"));
        tempInts = new ArrayList<>();
        customCursor();
        writer = new FileWriter();
        noClicks = 0;
        blockSpd = 50;
        gameState = 0;
        enemyCounter = 0;
        new Window(WIDTH, HEIGHT, "Dodge", this);

        handler = new Handler();
        p = new Player(900, 600);
        handler.addObject(p);

        // add mouse functionality for the game. Different functionalities are implemented
        // for different gamestates
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (gameState == 0) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if ((650 <= e.getX() && e.getX() <= 1200) && (550 <= e.getY() && e.getY() <= 650)) {
                            gameState = 1;
                            noClicks++;
                        }
                    }
                }
                if (gameState == 1) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        p.setMoving(true);
                        p.setDestX(e.getX());
                        p.setDestY(e.getY());
                    } else if (SwingUtilities.isLeftMouseButton(e)) {
                        if (!hasProj()) {
                            if (noClicks != 1) {
                                try {
                                    handler.addObject(new Projectile(p.getX(), p.getY(), e.getX(), e.getY(), true));
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                            noClicks++;
                        }
                    }
                }
                if (gameState == 2) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if ((650 <= e.getX() && e.getX() <= 1200) && (550 <= e.getY() && e.getY() <= 650)) {
                            handler.removeAll();
                            gameState = 1;
                            p = new Player(900, 600);
                            blockSpd = 50;
                            enemyCounter = 0;
                            handler.addObject(p);
                            secondsPassed = 0;
                            noClicks++;
                        }
                    }
                }
            }
        });



        /*
        addKeyListener(new KeyAdapter() {
            public void KeyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    PointerInfo point = MouseInfo.getPointerInfo();
                    Point pointer = point.getLocation();
                    double tempX = pointer.getX();
                    double tempY = pointer.getY();

                    double e1 = tempX;
                    double e2 = tempY;

                    tempX = tempX - p.getX();
                    tempY = tempY - p.getY();

                    tempX = tempX * tempX;
                    tempY = tempY * tempY;
                        handler.addObject(new Projectile(p.getX(), p.getY(), e1, e2, true));
                }
            }
        });
        */
    }

    // function to create custom cursor used in-game
    public void customCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image curs = toolkit.getImage("glowing-cursor-2.png");
        Point click = new Point(0,0);
        Cursor cursor = toolkit.createCustomCursor(curs, click, "Custom");

        setCursor(cursor);
    }

    public void incEnemyCounter() {
        enemyCounter++;
    }

    public int getEnemyCounter() {
        return enemyCounter;
    }

    /*
    public void keyPressed(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_EQUALS) {

            PointerInfo point = MouseInfo.getPointerInfo();
            Point pointer = point.getLocation();
            double tempX = pointer.getX();
            double tempY = pointer.getY();

            double e1 = tempX;
            double e2 = tempY;


            System.out.println("Pressed");


            handler.addObject(new Projectile(p.getX(), p.getY(), e1, e2, true));
        }
        }
        */

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

    // function to initialize and keep the program running
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
                try {
                    tick();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                delta--;
            }
            if (running) {
                try {
                    render();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    // if gameState is 1, then add new obstacles every second and calculate updated position of game objects
    // that are active
    private void tick() throws IOException {
        if (gameState == 1) {
            handler.tick();
            int randomX;
            int randomY;
            while (true) {
                randomX = ThreadLocalRandom.current().nextInt(0, 1801);
                randomY = ThreadLocalRandom.current().nextInt(0, 1201);
                if (distance(randomX, p.getX(), randomY, p.getY()) > 1000) {
                    break;
                }
            }
            if (noOfEnemies() < 1) {
                incEnemyCounter();
                handler.addObject(new Enemy(randomX, randomY, enemyCounter));
            }
            if (notDoneYet) {
                if (secondsPassed % 2 == 0) {
                    if (blockSpd + 1 > 100) {
                        blockSpd = 100;
                    } else {
                        blockSpd++;
                    }
                }
                int singOrDoub = ThreadLocalRandom.current().nextInt(1, 3);
                if (singOrDoub == 1) {
                    if (secondsPassed % 1 == 0) {
                        int side = ThreadLocalRandom.current().nextInt(1, 5);
                        int posGivenSide = ThreadLocalRandom.current().nextInt(0, 10);
                        int rotAngle = ThreadLocalRandom.current().nextInt(1, 4);
                        if (gameState == 1) {
                            if (side == 1) {
                                if (posGivenSide == 0) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 0, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 0, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 0, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 1) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 100, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 100, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 100, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 2) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 200, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 200, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 200, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 3) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 300, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 300, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 300, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 4) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 400, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 400, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 400, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 5) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 500, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 500, 2, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 500, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 6) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 600, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 600, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 600, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 7) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 700, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 700, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 700, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 8) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 800, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 800, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 800, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 9) {
                                    if (rotAngle == 1) {
                                        addBlock(0, 900, 1, 1, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(0, 900, 2, 1, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(0, 900, 3, 1, blockSpd);
                                    }
                                    notDoneYet = false;
                                }
                            } else if (side == 2) {
                                if (posGivenSide == 0) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 0, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 0, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 0, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 1) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 100, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 100, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 100, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 2) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 200, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 200, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 200, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 3) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 300, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 300, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 300, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 4) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 400, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 400, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 400, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 5) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 500, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 500, 2, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 500, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 6) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 600, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 600, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 600, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 7) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 700, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 700, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 700, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 8) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 800, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 800, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 800, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                } else if (posGivenSide == 9) {
                                    if (rotAngle == 1) {
                                        addBlock(1800, 900, 1, 2, blockSpd);
                                    } else if (rotAngle == 2) {
                                        addBlock(1800, 900, 2, 2, blockSpd);
                                    } else if (rotAngle == 3) {
                                        addBlock(1800, 900, 3, 2, blockSpd);
                                    }
                                    notDoneYet = false;
                                }
                            }
                        }
                    }
                } else if (singOrDoub == 2) {
                    int doubRand = ThreadLocalRandom.current().nextInt(1,21);
                    if (doubRand == 1) {
                        addBlock(0, 0, 1, 1, blockSpd);
                        addBlock(1800, 600, 1, 2, blockSpd);
                    } else if (doubRand == 2) {
                        addBlock(0, 400, 2, 1, blockSpd);
                        addBlock(1800, 700, 1, 2, blockSpd);
                    } else if (doubRand == 3) {
                        addBlock(0, 300, 3, 1, blockSpd);
                        addBlock(1800, 500, 1, 2, blockSpd);
                    } else if (doubRand == 4) {
                        addBlock(0, 200, 3, 1, blockSpd);
                        addBlock(1800, 600, 2, 2, blockSpd);
                    } else if (doubRand == 5) {
                        addBlock(0, 100, 2, 1, blockSpd);
                        addBlock(0, 300, 3, 1, blockSpd);
                    } else if (doubRand == 6) {
                        addBlock(0, 600, 2, 1, blockSpd);
                        addBlock(1800, 500, 3, 2, blockSpd);
                    } else if (doubRand == 7) {
                        addBlock(0, 500, 1, 1, blockSpd);
                        addBlock(1800, 400, 2, 2, blockSpd);
                    } else if (doubRand == 8) {
                        addBlock(0, 100, 2, 1, blockSpd);
                        addBlock(1800, 200, 2, 2, blockSpd);
                    } else if (doubRand == 9) {
                        addBlock(0, 100, 3, 1, blockSpd);
                        addBlock(1800, 800, 3, 2, blockSpd);
                    } else if (doubRand == 10) {
                        addBlock(0, 900, 3, 1, blockSpd);
                        addBlock(1800, 100, 3, 2, blockSpd);
                    } else if (doubRand == 11) {
                        addBlock(0, 500, 3, 1, blockSpd);
                        addBlock(1800, 700, 2, 2, blockSpd);
                    } else if (doubRand == 12) {
                        addBlock(0, 400, 3, 1, blockSpd);
                        addBlock(1800, 900, 2, 2, blockSpd);
                    } else if (doubRand == 13) {
                        addBlock(0, 0, 3, 1, blockSpd);
                        addBlock(1800, 600, 1, 2, blockSpd);
                    } else if (doubRand == 14) {
                        addBlock(0, 600, 1, 1, blockSpd);
                        addBlock(1800, 200, 3, 2, blockSpd);
                    } else if (doubRand == 15) {
                        addBlock(0, 800, 3, 1, blockSpd);
                        addBlock(1800, 300, 1, 2, blockSpd);
                    } else if (doubRand == 16) {
                        addBlock(0, 700, 2, 1, blockSpd);
                        addBlock(1800, 400, 3, 2, blockSpd);
                    } else if (doubRand == 17) {
                        addBlock(0, 300, 2, 1, blockSpd);
                        addBlock(1800, 800, 1, 2, blockSpd);
                    } else if (doubRand == 18) {
                        addBlock(0, 900, 2, 1, blockSpd);
                        addBlock(1800, 100, 3, 2, blockSpd);
                    } else if (doubRand == 19) {
                        addBlock(0, 900, 3, 1, blockSpd);
                        addBlock(1800, 0, 2, 2, blockSpd);
                    } else if (doubRand == 20) {
                        addBlock(0, 900, 1, 1, blockSpd);
                        addBlock(1800, 600, 1, 2, blockSpd);
                    }
                    notDoneYet = false;
                }
            }
        }
    }

    // function to either render the intro screen, render all game objects, or render the end game screen
    private void render() throws IOException {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        if (gameState == 0) {
            g = bs.getDrawGraphics();
            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            final BufferedImage image = ImageIO.read(new File("C:\\Users\\Roy\\Desktop\\clouds_battle_by_arsenixc.jpg"));

            g.drawImage(image, 0, 0, null);
            g.drawString("Click here to begin", 650, 600);
            g.drawString("How to play:", 700, 200);
            g.drawString("Left click to shoot at the green enemies", 400, 300);
            g.drawString("and dodge the incoming circles!", 450, 400);
            temp = writer.readFromFile(scores);
            g.drawString("Current", 1525, 150);
            g.drawString("Highscores", 1475, 210);

            for (int i = 0; i < temp.size(); i++) {
                g.drawString(temp.get(i),1600,50*(i+6));
            }
            g.dispose();
            bs.show();
        }
        if (gameState == 1) {
            g = bs.getDrawGraphics();
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            handler.render(g);

            g.dispose();
            bs.show();
        } else if (gameState == 2) {
            g = bs.getDrawGraphics();
            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            // background
            final BufferedImage image = ImageIO.read(new File("C:\\Users\\Roy\\Desktop\\clouds_battle_by_arsenixc.jpg"));

            g.drawImage(image, 0, 0, null);
            g.drawString("Click here to restart", 650, 600);
            g.drawString("Current", 1525, 150);
            g.drawString("Highscores", 1475, 210);

            temp = writer.readFromFile(scores);
            for (int i = 0; i < temp.size(); i++) {
                g.drawString(temp.get(i),1600,50*(i+6));
            }
            g.dispose();
            bs.show();
        }
    }

    public Handler getHandler() {
        return this.handler;
    }

    private void addBlock(double posX, double posY, double rotAngle, double side, int blockSpd) {
            Block b = new Block(posX, posY, rotAngle, side, blockSpd);
            handler.addObject(b);
        }

    public static int findEnemy() {
        int ret = -1;
        for (int i = 0; i < handler.objects.size(); i++) {
            if (handler.objects.get(i).getType() == 2) {
                ret = i;
            }
        }
        return ret;
    }

    private static boolean hasProj() {
        for (int i = 0; i < handler.objects.size(); i++) {
            if (handler.objects.get(i).getType() == 4) {
                return true;
            }
        }
        return false;
    }

    private static int noOfEnemies() {
        int ret = 0;
        for (int i = 0; i < handler.objects.size(); i++) {
            if (handler.objects.get(i).getType() == 2) {
                ret++;
            }
        }
        return ret;
    }

    public static void setRunning(boolean b) {
        running = b;
    }
    public static void main(String args[]) throws IOException, URISyntaxException {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                notDoneYet = true;
                for (int i = 0; i < handler.objects.size(); i++) {
                    if (handler.objects.get(i).getType() == 3) {
                        if (handler.objects.get(i).getX() < 0 || handler.objects.get(i).getX() > 1800) {
                            handler.objects.remove(handler.objects.get(i));
                        } else if (handler.objects.get(i).getY() < 0 || handler.objects.get(i).getY() > 1200) {
                            handler.objects.remove(handler.objects.get(i));
                        }
                    }
                }

                for (int i = 0; i < handler.objects.size(); i++) {
                        handler.objects.get(i).updateBoolean();
                }
            }
        };
        t = new Timer();
        t.schedule(timerTask, 1000, 1000);
        new Game();
    }
}
