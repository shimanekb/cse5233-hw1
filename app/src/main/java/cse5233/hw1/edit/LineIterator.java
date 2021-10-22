package cse5233.hw1.edit;

import java.util.Iterator;
import java.util.function.Consumer;

public class LineIterator implements Iterator<DiagramElement> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public DiagramElement next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super DiagramElement> action) {
        Iterator.super.forEachRemaining(action);
    }
}
