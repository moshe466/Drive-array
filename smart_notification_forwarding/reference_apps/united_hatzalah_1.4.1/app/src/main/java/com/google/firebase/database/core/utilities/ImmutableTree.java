package com.google.firebase.database.core.utilities;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class ImmutableTree<T> implements Iterable<Map.Entry<Path, T>> {
    private static final ImmutableTree EMPTY;
    private static final ImmutableSortedMap EMPTY_CHILDREN;
    private final ImmutableSortedMap<ChildKey, ImmutableTree<T>> children;
    private final T value;

    /* loaded from: classes.dex */
    public interface TreeVisitor<T, R> {
        R onNodeValue(Path path, T t3, R r3);
    }

    static {
        ImmutableSortedMap emptyMap = ImmutableSortedMap.Builder.emptyMap(StandardComparator.getComparator(ChildKey.class));
        EMPTY_CHILDREN = emptyMap;
        EMPTY = new ImmutableTree(null, emptyMap);
    }

    public ImmutableTree(T t3, ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap) {
        this.value = t3;
        this.children = immutableSortedMap;
    }

    public static <V> ImmutableTree<V> emptyInstance() {
        return EMPTY;
    }

    public boolean containsMatchingValue(Predicate<? super T> predicate) {
        T t3 = this.value;
        if (t3 != null && predicate.evaluate(t3)) {
            return true;
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            if (it.next().getValue().containsMatchingValue(predicate)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImmutableTree.class != obj.getClass()) {
            return false;
        }
        ImmutableTree immutableTree = (ImmutableTree) obj;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap == null ? immutableTree.children != null : !immutableSortedMap.equals(immutableTree.children)) {
            return false;
        }
        T t3 = this.value;
        T t4 = immutableTree.value;
        if (t3 == null ? t4 == null : t3.equals(t4)) {
            return true;
        }
        return false;
    }

    public Path findRootMostMatchingPath(Path path, Predicate<? super T> predicate) {
        ChildKey front;
        ImmutableTree<T> immutableTree;
        Path findRootMostMatchingPath;
        T t3 = this.value;
        if (t3 != null && predicate.evaluate(t3)) {
            return Path.getEmptyPath();
        }
        if (path.isEmpty() || (immutableTree = this.children.get((front = path.getFront()))) == null || (findRootMostMatchingPath = immutableTree.findRootMostMatchingPath(path.popFront(), predicate)) == null) {
            return null;
        }
        return new Path(front).child(findRootMostMatchingPath);
    }

    public Path findRootMostPathWithValue(Path path) {
        return findRootMostMatchingPath(path, Predicate.TRUE);
    }

    public <R> R fold(R r3, TreeVisitor<? super T, R> treeVisitor) {
        return (R) fold(Path.getEmptyPath(), treeVisitor, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void foreach(TreeVisitor<T, Void> treeVisitor) {
        fold(Path.getEmptyPath(), treeVisitor, null);
    }

    public T get(Path path) {
        if (path.isEmpty()) {
            return this.value;
        }
        ImmutableTree<T> immutableTree = this.children.get(path.getFront());
        if (immutableTree != null) {
            return immutableTree.get(path.popFront());
        }
        return null;
    }

    public ImmutableTree<T> getChild(ChildKey childKey) {
        ImmutableTree<T> immutableTree = this.children.get(childKey);
        if (immutableTree != null) {
            return immutableTree;
        }
        return emptyInstance();
    }

    public ImmutableSortedMap<ChildKey, ImmutableTree<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        T t3 = this.value;
        int i3 = 0;
        if (t3 != null) {
            i = t3.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap != null) {
            i3 = immutableSortedMap.hashCode();
        }
        return i4 + i3;
    }

    public boolean isEmpty() {
        if (this.value == null && this.children.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Path, T>> iterator() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() { // from class: com.google.firebase.database.core.utilities.ImmutableTree.2
            @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
            public /* bridge */ /* synthetic */ Void onNodeValue(Path path, Object obj, Void r3) {
                return onNodeValue2(path, (Path) obj, r3);
            }

            /* renamed from: onNodeValue, reason: avoid collision after fix types in other method */
            public Void onNodeValue2(Path path, T t3, Void r4) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(path, t3));
                return null;
            }
        });
        return arrayList.iterator();
    }

    public T leafMostValue(Path path) {
        return leafMostValueMatching(path, Predicate.TRUE);
    }

    public T leafMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t3;
        T t4 = this.value;
        if (t4 != null && predicate.evaluate(t4)) {
            t3 = this.value;
        } else {
            t3 = null;
        }
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext()) {
            immutableTree = immutableTree.children.get(it.next());
            if (immutableTree == null) {
                break;
            }
            T t5 = immutableTree.value;
            if (t5 != null && predicate.evaluate(t5)) {
                t3 = immutableTree.value;
            }
        }
        return t3;
    }

    public ImmutableTree<T> remove(Path path) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> insert;
        if (path.isEmpty()) {
            if (this.children.isEmpty()) {
                return emptyInstance();
            }
            return new ImmutableTree<>(null, this.children);
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTree = this.children.get(front);
        if (immutableTree != null) {
            ImmutableTree<T> remove = immutableTree.remove(path.popFront());
            if (remove.isEmpty()) {
                insert = this.children.remove(front);
            } else {
                insert = this.children.insert(front, remove);
            }
            if (this.value == null && insert.isEmpty()) {
                return emptyInstance();
            }
            return new ImmutableTree<>(this.value, insert);
        }
        return this;
    }

    public T rootMostValue(Path path) {
        return rootMostValueMatching(path, Predicate.TRUE);
    }

    public T rootMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t3 = this.value;
        if (t3 != null && predicate.evaluate(t3)) {
            return this.value;
        }
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext()) {
            immutableTree = immutableTree.children.get(it.next());
            if (immutableTree == null) {
                return null;
            }
            T t4 = immutableTree.value;
            if (t4 != null && predicate.evaluate(t4)) {
                return immutableTree.value;
            }
        }
        return null;
    }

    public ImmutableTree<T> set(Path path, T t3) {
        if (path.isEmpty()) {
            return new ImmutableTree<>(t3, this.children);
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTree = this.children.get(front);
        if (immutableTree == null) {
            immutableTree = emptyInstance();
        }
        return new ImmutableTree<>(this.value, this.children.insert(front, immutableTree.set(path.popFront(), t3)));
    }

    public ImmutableTree<T> setTree(Path path, ImmutableTree<T> immutableTree) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> insert;
        if (path.isEmpty()) {
            return immutableTree;
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTree2 = this.children.get(front);
        if (immutableTree2 == null) {
            immutableTree2 = emptyInstance();
        }
        ImmutableTree<T> tree = immutableTree2.setTree(path.popFront(), immutableTree);
        if (tree.isEmpty()) {
            insert = this.children.remove(front);
        } else {
            insert = this.children.insert(front, tree);
        }
        return new ImmutableTree<>(this.value, insert);
    }

    public ImmutableTree<T> subtree(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        ImmutableTree<T> immutableTree = this.children.get(path.getFront());
        if (immutableTree != null) {
            return immutableTree.subtree(path.popFront());
        }
        return emptyInstance();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImmutableTree { value=");
        sb.append(getValue());
        sb.append(", children={");
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            sb.append(next.getKey().asString());
            sb.append("=");
            sb.append(next.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }

    public Collection<T> values() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() { // from class: com.google.firebase.database.core.utilities.ImmutableTree.1
            @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
            public /* bridge */ /* synthetic */ Void onNodeValue(Path path, Object obj, Void r3) {
                return onNodeValue2(path, (Path) obj, r3);
            }

            /* renamed from: onNodeValue, reason: avoid collision after fix types in other method */
            public Void onNodeValue2(Path path, T t3, Void r3) {
                arrayList.add(t3);
                return null;
            }
        });
        return arrayList;
    }

    private <R> R fold(Path path, TreeVisitor<? super T, R> treeVisitor, R r3) {
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            r3 = (R) next.getValue().fold(path.child(next.getKey()), treeVisitor, r3);
        }
        Object obj = this.value;
        return obj != null ? treeVisitor.onNodeValue(path, obj, r3) : r3;
    }

    public ImmutableTree(T t3) {
        this(t3, EMPTY_CHILDREN);
    }
}
