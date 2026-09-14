package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

@GwtIncompatible
/* loaded from: classes2.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] f;
    private transient int firstEntry;
    private transient int lastEntry;

    CompactLinkedHashMap() {
        this(3);
    }

    CompactLinkedHashMap(int i) {
        this(i, 1.0f, false);
    }

    CompactLinkedHashMap(int i, float f, boolean z) {
        super(i, f);
        this.accessOrder = z;
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactLinkedHashMap<>(i);
    }

    private int getPredecessor(int i) {
        return (int) (this.f[i] >>> 32);
    }

    private void setPredecessor(int i, int i2) {
        long[] jArr = this.f;
        jArr[i] = (jArr[i] & 4294967295L) | (i2 << 32);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstEntry = i2;
        } else {
            setSuccessor(i, i2);
        }
        if (i2 == -2) {
            this.lastEntry = i;
        } else {
            setPredecessor(i2, i);
        }
    }

    private void setSuccessor(int i, int i2) {
        long[] jArr = this.f;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & 4294967295L);
    }

    @Override // com.google.common.collect.CompactHashMap
    int a(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // com.google.common.collect.CompactHashMap
    void a(int i) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i), b(i));
            setSucceeds(this.lastEntry, i);
            setSucceeds(i, -2);
            this.e++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void a(int i, float f) {
        super.a(i, f);
        this.firstEntry = -2;
        this.lastEntry = -2;
        this.f = new long[i];
        Arrays.fill(this.f, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void a(int i, K k, V v, int i2) {
        super.a(i, k, v, i2);
        setSucceeds(this.lastEntry, i);
        setSucceeds(i, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    int b(int i) {
        return (int) this.f[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void c(int i) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i), b(i));
        if (i < size) {
            setSucceeds(getPredecessor(size), i);
            setSucceeds(i, b(size));
        }
        super.c(i);
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void d(int i) {
        super.d(i);
        this.f = Arrays.copyOf(this.f, i);
    }

    @Override // com.google.common.collect.CompactHashMap
    int e() {
        return this.firstEntry;
    }
}
