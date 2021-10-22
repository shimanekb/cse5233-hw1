package cse5233.hw1.edit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class Diagram implements DiagramElement {

    private final Collection<DiagramElement> elements;

    public Diagram() {
        this.elements = new ArrayList<>();
    }

    public void add(DiagramElement element) {
        elements.add(element);
    }

    public boolean remove(DiagramElement element) {
        boolean found = false;
        if(elements.contains(element)) {
            elements.remove(element);
            found = true;
        }

        return found;
    }

    public Optional<DiagramElement> get(DiagramElement element) {
        return elements.stream().filter(ele -> ele == element).findFirst();
    }

    @Override
    public void draw() {
        elements.stream().forEach(element -> element.draw());
    }
}
