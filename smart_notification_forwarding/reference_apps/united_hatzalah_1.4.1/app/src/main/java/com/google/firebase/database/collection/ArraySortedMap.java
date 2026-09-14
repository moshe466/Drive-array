package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ArraySortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private final Comparator<K> comparator;
    private final K[] keys;
    private final V[] values;

    public ArraySortedMap(Comparator<K> comparator) {
        this.keys = (K[]) new Object[0];
        this.values = (V[]) new Object[0];
        this.comparator = comparator;
    }

    private static <T> T[] addToArray(T[] tArr, int i, T t3) {
        T[] tArr2 = (T[]) new Object[tArr.length + 1];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        tArr2[i] = t3;
        System.arraycopy(tArr, i, tArr2, i + 1, (r0 - i) - 1);
        return tArr2;
    }

    public static <A, B, C> ArraySortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i = 0;
        for (A a2 : list) {
            objArr[i] = a2;
            objArr2[i] = map.get(keyTranslator.translate(a2));
            i++;
        }
        return new ArraySortedMap<>(comparator, objArr, objArr2);
    }

    private int findKey(K k4) {
        int i = 0;
        for (K k5 : this.keys) {
            if (this.comparator.compare(k4, k5) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int findKeyOrInsertPosition(K k4) {
        int i = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i >= kArr.length || this.comparator.compare(kArr[i], k4) >= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    public static <K, V> ArraySortedMap<K, V> fromMap(Map<K, V> map, Comparator<K> comparator) {
        return buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    private Iterator<Map.Entry<K, V>> iterator(int i, boolean z3) {
        return new Iterator<Map.Entry<K, V>>(i, z3) { // from class: com.google.firebase.database.collection.ArraySortedMap.1
            int currentPos;
            final /* synthetic */ int val$pos;
            final /* synthetic */ boolean val$reverse;

            {
                this.val$pos = i;
                this.val$reverse = z3;
                this.currentPos = i;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.val$reverse) {
                    if (this.currentPos < 0) {
                        return false;
                    }
                    return true;
                }
                if (this.currentPos >= ArraySortedMap.this.keys.length) {
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                Object obj = ArraySortedMap.this.keys[this.currentPos];
                Object[] objArr = ArraySortedMap.this.values;
                int i3 = this.currentPos;
                Object obj2 = objArr[i3];
                this.currentPos = this.val$reverse ? i3 - 1 : i3 + 1;
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        };
    }

    private static <T> T[] removeFromArray(T[] tArr, int i) {
        int length = tArr.length - 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        System.arraycopy(tArr, i + 1, tArr2, i, length - i);
        return tArr2;
    }

    private static <T> T[] replaceInArray(T[] tArr, int i, T t3) {
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i] = t3;
        return tArr2;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean containsKey(K k4) {
        if (findKey(k4) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V get(K k4) {
        int findKey = findKey(k4);
        if (findKey != -1) {
            return this.values[findKey];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> getComparator() {
        return this.comparator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMaxKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMinKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getPredecessorKey(K k4) {
        int findKey = findKey(k4);
        if (findKey != -1) {
            if (findKey > 0) {
                return this.keys[findKey - 1];
            }
            return null;
        }
        throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getSuccessorKey(K k4) {
        int findKey = findKey(k4);
        if (findKey != -1) {
            K[] kArr = this.keys;
            if (findKey < kArr.length - 1) {
                return kArr[findKey + 1];
            }
            return null;
        }
        throw new IllegalArgumentException("Can't find successor of nonexistent key");
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        int i = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i < kArr.length) {
                nodeVisitor.visitEntry(kArr[i], this.values[i]);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int indexOf(K k4) {
        return findKey(k4);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> insert(K k4, V v2) {
        int findKey = findKey(k4);
        if (findKey != -1) {
            K[] kArr = this.keys;
            if (kArr[findKey] == k4 && this.values[findKey] == v2) {
                return this;
            }
            return new ArraySortedMap(this.comparator, replaceInArray(kArr, findKey, k4), replaceInArray(this.values, findKey, v2));
        }
        if (this.keys.length > 25) {
            HashMap hashMap = new HashMap(this.keys.length + 1);
            int i = 0;
            while (true) {
                K[] kArr2 = this.keys;
                if (i < kArr2.length) {
                    hashMap.put(kArr2[i], this.values[i]);
                    i++;
                } else {
                    hashMap.put(k4, v2);
                    return RBTreeSortedMap.fromMap(hashMap, this.comparator);
                }
            }
        } else {
            int findKeyOrInsertPosition = findKeyOrInsertPosition(k4);
            return new ArraySortedMap(this.comparator, addToArray(this.keys, findKeyOrInsertPosition, k4), addToArray(this.values, findKeyOrInsertPosition, v2));
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        if (this.keys.length == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> iteratorFrom(K k4) {
        return iterator(findKeyOrInsertPosition(k4), false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k4) {
        int findKey = findKey(k4);
        if (findKey == -1) {
            return this;
        }
        return new ArraySortedMap(this.comparator, removeFromArray(this.keys, findKey), removeFromArray(this.values, findKey));
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return iterator(this.keys.length - 1, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k4) {
        int findKeyOrInsertPosition = findKeyOrInsertPosition(k4);
        K[] kArr = this.keys;
        if (findKeyOrInsertPosition < kArr.length && this.comparator.compare(kArr[findKeyOrInsertPosition], k4) == 0) {
            return iterator(findKeyOrInsertPosition, true);
        }
        return iterator(findKeyOrInsertPosition - 1, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.keys.length;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return iterator(0, false);
    }

    private ArraySortedMap(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.keys = kArr;
        this.values = vArr;
        this.comparator = comparator;
    }
}
