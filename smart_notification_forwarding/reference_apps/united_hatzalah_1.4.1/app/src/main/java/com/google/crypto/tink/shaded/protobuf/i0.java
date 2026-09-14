package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class i0 extends AbstractList implements E, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final D f4110a;

    public i0(D d2) {
        this.f4110a = d2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final List b() {
        return Collections.unmodifiableList(this.f4110a.f4043b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final void c(AbstractC0337i abstractC0337i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final E e() {
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final Object f(int i) {
        return this.f4110a.f4043b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.f4110a.get(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Iterator, java.lang.Object, com.google.crypto.tink.shaded.protobuf.h0] */
    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        ?? obj = new Object();
        obj.f4106a = this.f4110a.iterator();
        return obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ListIterator, com.google.crypto.tink.shaded.protobuf.g0, java.lang.Object] */
    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        ?? obj = new Object();
        obj.f4104a = this.f4110a.listIterator(i);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4110a.size();
    }
}
