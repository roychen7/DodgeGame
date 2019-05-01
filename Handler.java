import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();
    public void tick() throws IOException {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).tick();
        }
    }
    public void render(Graphics g) throws IOException {
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
