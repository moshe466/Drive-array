package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
    private final boolean isReverse;
    private final ArrayDeque<LLRBValueNode<K, V>> nodeStack = new ArrayDeque<>();

    public ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k4, Comparator<K> comparator, boolean z3) {
        int i;
        this.isReverse = z3;
        while (!lLRBNode.isEmpty()) {
            if (k4 != null) {
                if (z3) {
                    i = comparator.compare(k4, lLRBNode.getKey());
                } else {
                    i = comparator.compare(lLRBNode.getKey(), k4);
                }
            } else {
                i = 1;
            }
            if (i < 0) {
                if (z3) {
                    lLRBNode = lLRBNode.getLeft();
                } else {
                    lLRBNode = lLRBNode.getRight();
                }
            } else {
                if (i == 0) {
                    this.nodeStack.push((LLRBValueNode) lLRBNode);
                    return;
                }
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                if (z3) {
                    lLRBNode = lLRBNode.getRight();
                } else {
                    lLRBNode = lLRBNode.getLeft();
                }
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nodeStack.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode<K, V> pop = this.nodeStack.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.isReverse) {
                for (LLRBNode<K, V> left = pop.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.nodeStack.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode<K, V> right = pop.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.nodeStack.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }
}
