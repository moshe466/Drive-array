package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int ENDPOINT = -2;

    @VisibleForTesting
    transient long[] f;
    private transient int firstEntry;
    private transient int lastEntry;

    ObjectCountLinkedHashMap() {
        this(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountLinkedHashMap(int i) {
        this(i, 1.0f);
    }

    ObjectCountLinkedHashMap(int i, float f) {
        super(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountLinkedHashMap(ObjectCountHashMap<K> objectCountHashMap) {
        a(objectCountHashMap.b(), 1.0f);
        int a = objectCountHashMap.a();
        while (a != -1) {
            put(objectCountHashMap.c(a), objectCountHashMap.d(a));
            a = objectCountHashMap.f(a);
        }
    }

    public static <K> ObjectCountLinkedHashMap<K> create() {
        return new ObjectCountLinkedHashMap<>();
    }

    public static <K> ObjectCountLinkedHashMap<K> createWithExpectedSize(int i) {
        return new ObjectCountLinkedHashMap<>(i);
    }

    private int getPredecessor(int i) {
        return (int) (this.f[i] >>> 32);
    }

    private int getSuccessor(int i) {
        return (int) this.f[i];
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public int a() {
        int i = this.firstEntry;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public int a(int i, int i2) {
        return i == b() ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void a(int i, float f) {
        super.a(i, f);
        this.firstEntry = -2;
        this.lastEntry = -2;
        this.f = new long[i];
        Arrays.fill(this.f, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void a(int i, K k, int i2, int i3) {
        super.a(i, k, i2, i3);
        setSucceeds(this.lastEntry, i);
        setSucceeds(i, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void e(int i) {
        int b = b() - 1;
        setSucceeds(getPredecessor(i), getSuccessor(i));
        if (i < b) {
            setSucceeds(getPredecessor(b), i);
            setSucceeds(i, getSuccessor(b));
        }
        super.e(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public int f(int i) {
        int successor = getSuccessor(i);
        if (successor == -2) {
            return -1;
        }
        return successor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void h(int i) {
        super.h(i);
        long[] jArr = this.f;
        int length = jArr.length;
        this.f = Arrays.copyOf(jArr, i);
        Arrays.fill(this.f, length, i, -1L);
    }
}
