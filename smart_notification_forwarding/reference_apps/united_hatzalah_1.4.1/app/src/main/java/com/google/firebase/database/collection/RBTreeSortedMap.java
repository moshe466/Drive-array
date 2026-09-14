package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private Comparator<K> comparator;
    private LLRBNode<K, V> root;

    /* loaded from: classes.dex */
    public static class Builder<A, B, C> {
        private final ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator;
        private final List<A> keys;
        private LLRBValueNode<A, C> leaf;
        private LLRBValueNode<A, C> root;
        private final Map<B, C> values;

        /* loaded from: classes.dex */
        public static class Base1_2 implements Iterable<BooleanChunk> {
            private final int length;
            private long value;

            public Base1_2(int i) {
                int i3 = i + 1;
                int floor = (int) Math.floor(Math.log(i3) / Math.log(2.0d));
                this.length = floor;
                this.value = (((long) Math.pow(2.0d, floor)) - 1) & i3;
            }

            @Override // java.lang.Iterable
            public Iterator<BooleanChunk> iterator() {
                return new Iterator<BooleanChunk>() { // from class: com.google.firebase.database.collection.RBTreeSortedMap.Builder.Base1_2.1
                    private int current;

                    {
                        this.current = Base1_2.this.length - 1;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.current >= 0) {
                            return true;
                        }
                        return false;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public BooleanChunk next() {
                        long j2 = Base1_2.this.value & (1 << this.current);
                        BooleanChunk booleanChunk = new BooleanChunk();
                        booleanChunk.isOne = j2 == 0;
                        booleanChunk.chunkSize = (int) Math.pow(2.0d, this.current);
                        this.current--;
                        return booleanChunk;
                    }
                };
            }
        }

        /* loaded from: classes.dex */
        public static class BooleanChunk {
            public int chunkSize;
            public boolean isOne;
        }

        private Builder(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator) {
            this.keys = list;
            this.values = map;
            this.keyTranslator = keyTranslator;
        }

        private LLRBNode<A, C> buildBalancedTree(int i, int i3) {
            if (i3 == 0) {
                return LLRBEmptyNode.getInstance();
            }
            if (i3 == 1) {
                A a2 = this.keys.get(i);
                return new LLRBBlackValueNode(a2, getValue(a2), null, null);
            }
            int i4 = i3 / 2;
            int i5 = i + i4;
            LLRBNode<A, C> buildBalancedTree = buildBalancedTree(i, i4);
            LLRBNode<A, C> buildBalancedTree2 = buildBalancedTree(i5 + 1, i4);
            A a4 = this.keys.get(i5);
            return new LLRBBlackValueNode(a4, getValue(a4), buildBalancedTree, buildBalancedTree2);
        }

        public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
            Builder builder = new Builder(list, map, keyTranslator);
            Collections.sort(list, comparator);
            Iterator<BooleanChunk> it = new Base1_2(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                BooleanChunk next = it.next();
                int i = next.chunkSize;
                size -= i;
                if (next.isOne) {
                    builder.buildPennant(LLRBNode.Color.BLACK, i, size);
                } else {
                    builder.buildPennant(LLRBNode.Color.BLACK, i, size);
                    int i3 = next.chunkSize;
                    size -= i3;
                    builder.buildPennant(LLRBNode.Color.RED, i3, size);
                }
            }
            LLRBNode lLRBNode = builder.root;
            if (lLRBNode == null) {
                lLRBNode = LLRBEmptyNode.getInstance();
            }
            return new RBTreeSortedMap<>(lLRBNode, comparator);
        }

        private void buildPennant(LLRBNode.Color color, int i, int i3) {
            LLRBValueNode<A, C> lLRBBlackValueNode;
            LLRBNode<A, C> buildBalancedTree = buildBalancedTree(i3 + 1, i - 1);
            A a2 = this.keys.get(i3);
            if (color == LLRBNode.Color.RED) {
                lLRBBlackValueNode = new LLRBRedValueNode<>(a2, getValue(a2), null, buildBalancedTree);
            } else {
                lLRBBlackValueNode = new LLRBBlackValueNode<>(a2, getValue(a2), null, buildBalancedTree);
            }
            if (this.root == null) {
                this.root = lLRBBlackValueNode;
                this.leaf = lLRBBlackValueNode;
            } else {
                this.leaf.setLeft(lLRBBlackValueNode);
                this.leaf = lLRBBlackValueNode;
            }
        }

        private C getValue(A a2) {
            return this.values.get(this.keyTranslator.translate(a2));
        }
    }

    public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        return Builder.buildFrom(list, map, keyTranslator, comparator);
    }

    public static <A, B> RBTreeSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator) {
        return Builder.buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    private LLRBNode<K, V> getNode(K k4) {
        LLRBNode<K, V> lLRBNode = this.root;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k4, lLRBNode.getKey());
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                if (compare == 0) {
                    return lLRBNode;
                }
                lLRBNode = lLRBNode.getRight();
            }
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean containsKey(K k4) {
        if (getNode(k4) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V get(K k4) {
        LLRBNode<K, V> node = getNode(k4);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> getComparator() {
        return this.comparator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMaxKey() {
        return this.root.getMax().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMinKey() {
        return this.root.getMin().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getPredecessorKey(K k4) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k4, lLRBNode.getKey());
            if (compare == 0) {
                if (!lLRBNode.getLeft().isEmpty()) {
                    LLRBNode<K, V> left = lLRBNode.getLeft();
                    while (!left.getRight().isEmpty()) {
                        left = left.getRight();
                    }
                    return left.getKey();
                }
                if (lLRBNode2 == null) {
                    return null;
                }
                return lLRBNode2.getKey();
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getRight();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + k4);
    }

    public LLRBNode<K, V> getRoot() {
        return this.root;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getSuccessorKey(K k4) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(lLRBNode.getKey(), k4);
            if (compare == 0) {
                if (!lLRBNode.getRight().isEmpty()) {
                    LLRBNode<K, V> right = lLRBNode.getRight();
                    while (!right.getLeft().isEmpty()) {
                        right = right.getLeft();
                    }
                    return right.getKey();
                }
                if (lLRBNode2 == null) {
                    return null;
                }
                return lLRBNode2.getKey();
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.getRight();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getLeft();
            }
        }
        throw new IllegalArgumentException("Couldn't find successor key of non-present key: " + k4);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.root.inOrderTraversal(nodeVisitor);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int indexOf(K k4) {
        LLRBNode<K, V> lLRBNode = this.root;
        int i = 0;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k4, lLRBNode.getKey());
            if (compare == 0) {
                return lLRBNode.getLeft().size() + i;
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                int size = lLRBNode.getLeft().size() + 1 + i;
                lLRBNode = lLRBNode.getRight();
                i = size;
            }
        }
        return -1;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> insert(K k4, V v2) {
        return new RBTreeSortedMap(this.root.insert(k4, v2, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> iteratorFrom(K k4) {
        return new ImmutableSortedMapIterator(this.root, k4, this.comparator, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k4) {
        if (!containsKey(k4)) {
            return this;
        }
        return new RBTreeSortedMap(this.root.remove(k4, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k4) {
        return new ImmutableSortedMapIterator(this.root, k4, this.comparator, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.root.size();
    }

    public RBTreeSortedMap(Comparator<K> comparator) {
        this.root = LLRBEmptyNode.getInstance();
        this.comparator = comparator;
    }

    private RBTreeSortedMap(LLRBNode<K, V> lLRBNode, Comparator<K> comparator) {
        this.root = lLRBNode;
        this.comparator = comparator;
    }
}
