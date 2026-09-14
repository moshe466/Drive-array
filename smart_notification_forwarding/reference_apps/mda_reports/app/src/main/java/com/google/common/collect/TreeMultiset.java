package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient AvlNode<E> header;
    private final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a = new int[BoundType.values().length];

        static {
            try {
                a[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int a(AvlNode<?> avlNode) {
                return ((AvlNode) avlNode).elemCount;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long b(@NullableDecl AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode) avlNode).totalCount;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int a(AvlNode<?> avlNode) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long b(@NullableDecl AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode) avlNode).distinctElements;
            }
        };

        abstract int a(AvlNode<?> avlNode);

        abstract long b(@NullableDecl AvlNode<?> avlNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class AvlNode<E> {
        private int distinctElements;

        @NullableDecl
        private final E elem;
        private int elemCount;
        private int height;

        @NullableDecl
        private AvlNode<E> left;

        @NullableDecl
        private AvlNode<E> pred;

        @NullableDecl
        private AvlNode<E> right;

        @NullableDecl
        private AvlNode<E> succ;
        private long totalCount;

        AvlNode(@NullableDecl E e, int i) {
            Preconditions.checkArgument(i > 0);
            this.elem = e;
            this.elemCount = i;
            this.totalCount = i;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        private AvlNode<E> addLeftChild(E e, int i) {
            this.left = new AvlNode<>(e, i);
            TreeMultiset.successor(this.pred, this.left, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += i;
            return this;
        }

        private AvlNode<E> addRightChild(E e, int i) {
            this.right = new AvlNode<>(e, i);
            TreeMultiset.successor(this, this.right, this.succ);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += i;
            return this;
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public AvlNode<E> ceiling(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                return avlNode == null ? this : (AvlNode) MoreObjects.firstNonNull(avlNode.ceiling(comparator, e), this);
            }
            if (compare == 0) {
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return null;
            }
            return avlNode2.ceiling(comparator, e);
        }

        private AvlNode<E> deleteMe() {
            int i = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.successor(this.pred, this.succ);
            AvlNode<E> avlNode = this.left;
            if (avlNode == null) {
                return this.right;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.height >= avlNode2.height) {
                AvlNode<E> avlNode3 = this.pred;
                avlNode3.left = avlNode.removeMax(avlNode3);
                avlNode3.right = this.right;
                avlNode3.distinctElements = this.distinctElements - 1;
                avlNode3.totalCount = this.totalCount - i;
                return avlNode3.rebalance();
            }
            AvlNode<E> avlNode4 = this.succ;
            avlNode4.right = avlNode2.removeMin(avlNode4);
            avlNode4.left = this.left;
            avlNode4.distinctElements = this.distinctElements - 1;
            avlNode4.totalCount = this.totalCount - i;
            return avlNode4.rebalance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public AvlNode<E> floor(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.elem);
            if (compare > 0) {
                AvlNode<E> avlNode = this.right;
                return avlNode == null ? this : (AvlNode) MoreObjects.firstNonNull(avlNode.floor(comparator, e), this);
            }
            if (compare == 0) {
                return this;
            }
            AvlNode<E> avlNode2 = this.left;
            if (avlNode2 == null) {
                return null;
            }
            return avlNode2.floor(comparator, e);
        }

        private static int height(@NullableDecl AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return ((AvlNode) avlNode).height;
        }

        private AvlNode<E> rebalance() {
            int balanceFactor = balanceFactor();
            if (balanceFactor == -2) {
                if (this.right.balanceFactor() > 0) {
                    this.right = this.right.rotateRight();
                }
                return rotateLeft();
            }
            if (balanceFactor != 2) {
                recomputeHeight();
                return this;
            }
            if (this.left.balanceFactor() < 0) {
                this.left = this.left.rotateLeft();
            }
            return rotateRight();
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.a((AvlNode<?>) this.left) + 1 + TreeMultiset.a((AvlNode<?>) this.right);
            this.totalCount = this.elemCount + totalCount(this.left) + totalCount(this.right);
        }

        private AvlNode<E> removeMax(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return this.left;
            }
            this.right = avlNode2.removeMax(avlNode);
            this.distinctElements--;
            this.totalCount -= avlNode.elemCount;
            return rebalance();
        }

        private AvlNode<E> removeMin(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.left;
            if (avlNode2 == null) {
                return this.right;
            }
            this.left = avlNode2.removeMin(avlNode);
            this.distinctElements--;
            this.totalCount -= avlNode.elemCount;
            return rebalance();
        }

        private AvlNode<E> rotateLeft() {
            Preconditions.checkState(this.right != null);
            AvlNode<E> avlNode = this.right;
            this.right = avlNode.left;
            avlNode.left = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private AvlNode<E> rotateRight() {
            Preconditions.checkState(this.left != null);
            AvlNode<E> avlNode = this.left;
            this.left = avlNode.right;
            avlNode.right = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private static long totalCount(@NullableDecl AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0L;
            }
            return ((AvlNode) avlNode).totalCount;
        }

        int a() {
            return this.elemCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> a(Comparator<? super E> comparator, @NullableDecl E e, int i, int i2, int[] iArr) {
            int i3;
            int i4;
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : addLeftChild(e, i2);
                }
                this.left = avlNode.a(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 != 0 || iArr[0] == 0) {
                        if (i2 > 0 && iArr[0] == 0) {
                            i4 = this.distinctElements + 1;
                        }
                        this.totalCount += i2 - iArr[0];
                    } else {
                        i4 = this.distinctElements - 1;
                    }
                    this.distinctElements = i4;
                    this.totalCount += i2 - iArr[0];
                }
                return rebalance();
            }
            if (compare <= 0) {
                int i5 = this.elemCount;
                iArr[0] = i5;
                if (i == i5) {
                    if (i2 == 0) {
                        return deleteMe();
                    }
                    this.totalCount += i2 - i5;
                    this.elemCount = i2;
                }
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return (i != 0 || i2 <= 0) ? this : addRightChild(e, i2);
            }
            this.right = avlNode2.a(comparator, e, i, i2, iArr);
            if (iArr[0] == i) {
                if (i2 != 0 || iArr[0] == 0) {
                    if (i2 > 0 && iArr[0] == 0) {
                        i3 = this.distinctElements + 1;
                    }
                    this.totalCount += i2 - iArr[0];
                } else {
                    i3 = this.distinctElements - 1;
                }
                this.distinctElements = i3;
                this.totalCount += i2 - iArr[0];
            }
            return rebalance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> a(Comparator<? super E> comparator, @NullableDecl E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return addLeftChild(e, i);
                }
                int i2 = avlNode.height;
                this.left = avlNode.a(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += i;
                return this.left.height == i2 ? this : rebalance();
            }
            if (compare <= 0) {
                int i3 = this.elemCount;
                iArr[0] = i3;
                long j = i;
                Preconditions.checkArgument(((long) i3) + j <= 2147483647L);
                this.elemCount += i;
                this.totalCount += j;
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return addRightChild(e, i);
            }
            int i4 = avlNode2.height;
            this.right = avlNode2.a(comparator, e, i, iArr);
            if (iArr[0] == 0) {
                this.distinctElements++;
            }
            this.totalCount += i;
            return this.right.height == i4 ? this : rebalance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> b(Comparator<? super E> comparator, @NullableDecl E e, int i, int[] iArr) {
            long j;
            long j2;
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.left = avlNode.b(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.distinctElements--;
                        j2 = this.totalCount;
                        i = iArr[0];
                    } else {
                        j2 = this.totalCount;
                    }
                    this.totalCount = j2 - i;
                }
                return iArr[0] == 0 ? this : rebalance();
            }
            if (compare <= 0) {
                int i2 = this.elemCount;
                iArr[0] = i2;
                if (i >= i2) {
                    return deleteMe();
                }
                this.elemCount = i2 - i;
                this.totalCount -= i;
                return this;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.right = avlNode2.b(comparator, e, i, iArr);
            if (iArr[0] > 0) {
                if (i >= iArr[0]) {
                    this.distinctElements--;
                    j = this.totalCount;
                    i = iArr[0];
                } else {
                    j = this.totalCount;
                }
                this.totalCount = j - i;
            }
            return rebalance();
        }

        E b() {
            return this.elem;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> c(Comparator<? super E> comparator, @NullableDecl E e, int i, int[] iArr) {
            int i2;
            long j;
            int i3;
            int i4;
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return i > 0 ? addLeftChild(e, i) : this;
                }
                this.left = avlNode.c(comparator, e, i, iArr);
                if (i != 0 || iArr[0] == 0) {
                    if (i > 0 && iArr[0] == 0) {
                        i4 = this.distinctElements + 1;
                    }
                    j = this.totalCount;
                    i3 = iArr[0];
                } else {
                    i4 = this.distinctElements - 1;
                }
                this.distinctElements = i4;
                j = this.totalCount;
                i3 = iArr[0];
            } else {
                if (compare <= 0) {
                    iArr[0] = this.elemCount;
                    if (i == 0) {
                        return deleteMe();
                    }
                    this.totalCount += i - r3;
                    this.elemCount = i;
                    return this;
                }
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return i > 0 ? addRightChild(e, i) : this;
                }
                this.right = avlNode2.c(comparator, e, i, iArr);
                if (i != 0 || iArr[0] == 0) {
                    if (i > 0 && iArr[0] == 0) {
                        i2 = this.distinctElements + 1;
                    }
                    j = this.totalCount;
                    i3 = iArr[0];
                } else {
                    i2 = this.distinctElements - 1;
                }
                this.distinctElements = i2;
                j = this.totalCount;
                i3 = iArr[0];
            }
            this.totalCount = j + (i - i3);
            return rebalance();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int count(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.count(comparator, e);
            }
            if (compare <= 0) {
                return this.elemCount;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return 0;
            }
            return avlNode2.count(comparator, e);
        }

        public String toString() {
            return Multisets.immutableEntry(b(), a()).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Reference<T> {

        @NullableDecl
        private T value;

        private Reference() {
        }

        void a() {
            this.value = null;
        }

        public void checkAndSet(@NullableDecl T t, T t2) {
            if (this.value != t) {
                throw new ConcurrentModificationException();
            }
            this.value = t2;
        }

        @NullableDecl
        public T get() {
            return this.value;
        }
    }

    TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.a());
        this.rootReference = reference;
        this.range = generalRange;
        this.header = avlNode;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.a((Comparator) comparator);
        this.header = new AvlNode<>(null, 1);
        AvlNode<E> avlNode = this.header;
        successor(avlNode, avlNode);
        this.rootReference = new Reference<>();
    }

    static int a(@NullableDecl AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return ((AvlNode) avlNode).distinctElements;
    }

    private long aggregateAboveRange(Aggregate aggregate, @NullableDecl AvlNode<E> avlNode) {
        long b;
        long aggregateAboveRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.e(), ((AvlNode) avlNode).elem);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, ((AvlNode) avlNode).right);
        }
        if (compare == 0) {
            int i = AnonymousClass4.a[this.range.d().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.b(((AvlNode) avlNode).right);
                }
                throw new AssertionError();
            }
            b = aggregate.a(avlNode);
            aggregateAboveRange = aggregate.b(((AvlNode) avlNode).right);
        } else {
            b = aggregate.b(((AvlNode) avlNode).right) + aggregate.a(avlNode);
            aggregateAboveRange = aggregateAboveRange(aggregate, ((AvlNode) avlNode).left);
        }
        return b + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @NullableDecl AvlNode<E> avlNode) {
        long b;
        long aggregateBelowRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.c(), ((AvlNode) avlNode).elem);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, ((AvlNode) avlNode).left);
        }
        if (compare == 0) {
            int i = AnonymousClass4.a[this.range.b().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.b(((AvlNode) avlNode).left);
                }
                throw new AssertionError();
            }
            b = aggregate.a(avlNode);
            aggregateBelowRange = aggregate.b(((AvlNode) avlNode).left);
        } else {
            b = aggregate.b(((AvlNode) avlNode).left) + aggregate.a(avlNode);
            aggregateBelowRange = aggregateBelowRange(aggregate, ((AvlNode) avlNode).right);
        }
        return b + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        AvlNode<E> avlNode = this.rootReference.get();
        long b = aggregate.b(avlNode);
        if (this.range.f()) {
            b -= aggregateBelowRange(aggregate, avlNode);
        }
        return this.range.g() ? b - aggregateAboveRange(aggregate, avlNode) : b;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    public static <E> TreeMultiset<E> create(@NullableDecl Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public AvlNode<E> firstNode() {
        AvlNode<E> avlNode;
        if (this.rootReference.get() == null) {
            return null;
        }
        if (this.range.f()) {
            E c = this.range.c();
            AvlNode<E> ceiling = this.rootReference.get().ceiling(comparator(), c);
            if (ceiling == null) {
                return null;
            }
            if (this.range.b() == BoundType.OPEN && comparator().compare(c, ceiling.b()) == 0) {
                ceiling = ((AvlNode) ceiling).succ;
            }
            avlNode = ceiling;
        } else {
            avlNode = ((AvlNode) this.header).succ;
        }
        if (avlNode == this.header || !this.range.a((GeneralRange<E>) avlNode.b())) {
            return null;
        }
        return avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public AvlNode<E> lastNode() {
        AvlNode<E> avlNode;
        if (this.rootReference.get() == null) {
            return null;
        }
        if (this.range.g()) {
            E e = this.range.e();
            AvlNode<E> floor = this.rootReference.get().floor(comparator(), e);
            if (floor == null) {
                return null;
            }
            if (this.range.d() == BoundType.OPEN && comparator().compare(e, floor.b()) == 0) {
                floor = ((AvlNode) floor).pred;
            }
            avlNode = floor;
        } else {
            avlNode = ((AvlNode) this.header).pred;
        }
        if (avlNode == this.header || !this.range.a((GeneralRange<E>) avlNode.b())) {
            return null;
        }
        return avlNode;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Serialization.a(AbstractSortedMultiset.class, "comparator").a((Serialization.FieldSetter) this, (Object) comparator);
        Serialization.a(TreeMultiset.class, "range").a((Serialization.FieldSetter) this, (Object) GeneralRange.a(comparator));
        Serialization.a(TreeMultiset.class, "rootReference").a((Serialization.FieldSetter) this, (Object) new Reference());
        AvlNode avlNode = new AvlNode(null, 1);
        Serialization.a(TreeMultiset.class, "header").a((Serialization.FieldSetter) this, (Object) avlNode);
        successor(avlNode, avlNode);
        Serialization.a(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2) {
        ((AvlNode) avlNode).succ = avlNode2;
        ((AvlNode) avlNode2).pred = avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        successor(avlNode, avlNode2);
        successor(avlNode2, avlNode3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.TreeMultiset.1
            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                int a = avlNode.a();
                return a == 0 ? TreeMultiset.this.count(getElement()) : a;
            }

            @Override // com.google.common.collect.Multiset.Entry
            public E getElement() {
                return (E) avlNode.b();
            }
        };
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        Serialization.a(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@NullableDecl E e, int i) {
        CollectPreconditions.a(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        Preconditions.checkArgument(this.range.a((GeneralRange<E>) e));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.a(comparator(), e, i, iArr));
            return iArr[0];
        }
        comparator().compare(e, e);
        AvlNode<E> avlNode2 = new AvlNode<>(e, i);
        AvlNode<E> avlNode3 = this.header;
        successor(avlNode3, avlNode2, avlNode3);
        this.rootReference.checkAndSet(avlNode, avlNode2);
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset
    int b() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> c() {
        return Multisets.a(d());
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.f() || this.range.g()) {
            Iterators.b(d());
            return;
        }
        AvlNode<E> avlNode = ((AvlNode) this.header).succ;
        while (true) {
            AvlNode<E> avlNode2 = this.header;
            if (avlNode == avlNode2) {
                successor(avlNode2, avlNode2);
                this.rootReference.a();
                return;
            }
            AvlNode<E> avlNode3 = ((AvlNode) avlNode).succ;
            ((AvlNode) avlNode).elemCount = 0;
            ((AvlNode) avlNode).left = null;
            ((AvlNode) avlNode).right = null;
            ((AvlNode) avlNode).pred = null;
            ((AvlNode) avlNode).succ = null;
            avlNode = avlNode3;
        }
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        try {
            AvlNode<E> avlNode = this.rootReference.get();
            if (this.range.a((GeneralRange<E>) obj) && avlNode != null) {
                return avlNode.count(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> d() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.2
            AvlNode<E> a;

            @NullableDecl
            Multiset.Entry<E> b;

            {
                this.a = TreeMultiset.this.firstNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.a == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.b(this.a.b())) {
                    return true;
                }
                this.a = null;
                return false;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.a);
                this.b = wrapEntry;
                this.a = ((AvlNode) this.a).succ == TreeMultiset.this.header ? null : ((AvlNode) this.a).succ;
                return wrapEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                CollectPreconditions.a(this.b != null);
                TreeMultiset.this.setCount(this.b.getElement(), 0);
                this.b = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    Iterator<Multiset.Entry<E>> f() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.3
            AvlNode<E> a;
            Multiset.Entry<E> b = null;

            {
                this.a = TreeMultiset.this.lastNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.a == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.c(this.a.b())) {
                    return true;
                }
                this.a = null;
                return false;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.a);
                this.b = wrapEntry;
                this.a = ((AvlNode) this.a).pred == TreeMultiset.this.header ? null : ((AvlNode) this.a).pred;
                return wrapEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                CollectPreconditions.a(this.b != null);
                TreeMultiset.this.setCount(this.b.getElement(), 0);
                this.b = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@NullableDecl E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.a(GeneralRange.b(comparator(), e, boundType)), this.header);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.a((Multiset) this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        CollectPreconditions.a(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        AvlNode<E> avlNode = this.rootReference.get();
        int[] iArr = new int[1];
        try {
            if (this.range.a((GeneralRange<E>) obj) && avlNode != null) {
                this.rootReference.checkAndSet(avlNode, avlNode.b(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e, int i) {
        CollectPreconditions.a(i, "count");
        if (!this.range.a((GeneralRange<E>) e)) {
            Preconditions.checkArgument(i == 0);
            return 0;
        }
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            if (i > 0) {
                add(e, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.c(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e, int i, int i2) {
        CollectPreconditions.a(i2, "newCount");
        CollectPreconditions.a(i, "oldCount");
        Preconditions.checkArgument(this.range.a((GeneralRange<E>) e));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.a(comparator(), e, i, i2, iArr));
            return iArr[0] == i;
        }
        if (i != 0) {
            return false;
        }
        if (i2 > 0) {
            add(e, i2);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@NullableDecl Object obj, BoundType boundType, @NullableDecl Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@NullableDecl E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.a(GeneralRange.a(comparator(), e, boundType)), this.header);
    }
}
