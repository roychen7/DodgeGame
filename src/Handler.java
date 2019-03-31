import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();
    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).tick();
        }
    }
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }

    public void addObject(GameObject go) {
        this.objects.add(go);
    }

    public void removeAll() {
        for (int i = 0; i < objects.size(); i++) {
            objects.remove(objects.get(i));
        }
    }
}
