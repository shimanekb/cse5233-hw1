package cse5233.hw1.edit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.*;

public class Diagram implements DiagramElement {

    private static final Logger logger = LoggerFactory.getLogger(Diagram.class);

    private final Collection<DiagramElement> elements;

    private final DiagramIterator diagramIterator;

    public Diagram() {
        this.elements = new ArrayList<>();
        this.diagramIterator = new DiagramIterator();
    }

    public void add(DiagramElement element) {
        elements.add(element);
    }

    public boolean remove(DiagramElement element) {
        boolean removed = false;
        Iterator<DiagramElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            DiagramElement e = iterator.next();
            if (e.equals(element)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        return removed;
    }

    public Optional<DiagramElement> get(DiagramElement element) {
        return elements.stream().filter(ele -> ele == element).findFirst();
    }

    @Override
    public void draw(Graphics g) {
        logger.info("Drawing diagram with " + elements.size() + " elements.");
        elements.stream().forEach(element -> element.draw(g));
    }

}
