package org.yaml.snakeyaml.util;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ArrayStack<T> {
    private ArrayList<T> stack;

    public ArrayStack(int i) {
        this.stack = new ArrayList<>(i);
    }

    public void push(T t) {
        this.stack.add(t);
    }

    public T pop() {
        return this.stack.remove(r0.size() - 1);
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void clear() {
        this.stack.clear();
    }
}
