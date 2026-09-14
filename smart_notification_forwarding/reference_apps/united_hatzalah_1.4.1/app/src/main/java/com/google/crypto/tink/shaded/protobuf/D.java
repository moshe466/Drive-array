package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class D extends AbstractC0330b implements E, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4043b;

    static {
        new D(10).f4085a = false;
    }

    public D(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.A
    public final A a(int i) {
        ArrayList arrayList = this.f4043b;
        if (i >= arrayList.size()) {
            ArrayList arrayList2 = new ArrayList(i);
            arrayList2.addAll(arrayList);
            return new D(arrayList2);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        d();
        this.f4043b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0330b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f4043b.size(), collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final List b() {
        return Collections.unmodifiableList(this.f4043b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final void c(AbstractC0337i abstractC0337i) {
        d();
        this.f4043b.add(abstractC0337i);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0330b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        d();
        this.f4043b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final E e() {
        if (this.f4085a) {
            return new i0(this);
        }
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.E
    public final Object f(int i) {
        return this.f4043b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        String str;
        ArrayList arrayList = this.f4043b;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0337i) {
            AbstractC0337i abstractC0337i = (AbstractC0337i) obj;
            abstractC0337i.getClass();
            Charset charset = B.f4029a;
            if (abstractC0337i.size() == 0) {
                str = "";
            } else {
                C0336h c0336h = (C0336h) abstractC0337i;
                str = new String(c0336h.f4105d, c0336h.l(), c0336h.size(), charset);
            }
            C0336h c0336h2 = (C0336h) abstractC0337i;
            int l3 = c0336h2.l();
            if (q0.f4147a.r(c0336h2.f4105d, l3, c0336h2.size() + l3)) {
                arrayList.set(i, str);
            }
            return str;
        }
        byte[] bArr = (byte[]) obj;
        String str2 = new String(bArr, B.f4029a);
        if (q0.f4147a.r(bArr, 0, bArr.length)) {
            arrayList.set(i, str2);
        }
        return str2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0330b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        d();
        Object remove = this.f4043b.remove(i);
        ((AbstractList) this).modCount++;
        if (remove instanceof String) {
            return (String) remove;
        }
        if (remove instanceof AbstractC0337i) {
            AbstractC0337i abstractC0337i = (AbstractC0337i) remove;
            abstractC0337i.getClass();
            Charset charset = B.f4029a;
            if (abstractC0337i.size() == 0) {
                return "";
            }
            C0336h c0336h = (C0336h) abstractC0337i;
            return new String(c0336h.f4105d, c0336h.l(), c0336h.size(), charset);
        }
        return new String((byte[]) remove, B.f4029a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        d();
        Object obj2 = this.f4043b.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof AbstractC0337i) {
            AbstractC0337i abstractC0337i = (AbstractC0337i) obj2;
            abstractC0337i.getClass();
            Charset charset = B.f4029a;
            if (abstractC0337i.size() == 0) {
                return "";
            }
            C0336h c0336h = (C0336h) abstractC0337i;
            return new String(c0336h.f4105d, c0336h.l(), c0336h.size(), charset);
        }
        return new String((byte[]) obj2, B.f4029a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4043b.size();
    }

    public D(ArrayList arrayList) {
        this.f4043b = arrayList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0330b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        d();
        if (collection instanceof E) {
            collection = ((E) collection).b();
        }
        boolean addAll = this.f4043b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }
}
