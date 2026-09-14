package db;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a extends ArrayList<k> implements j {
    public a(int i10) {
        super(i10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof k) {
            return l((k) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof k) {
            return t((k) obj);
        }
        return -1;
    }

    public /* bridge */ boolean l(k kVar) {
        return super.contains(kVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof k) {
            return u((k) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof k) {
            return w((k) obj);
        }
        return false;
    }

    public /* bridge */ int s() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return s();
    }

    public /* bridge */ int t(k kVar) {
        return super.indexOf(kVar);
    }

    public /* bridge */ int u(k kVar) {
        return super.lastIndexOf(kVar);
    }

    public /* bridge */ boolean w(k kVar) {
        return super.remove(kVar);
    }
}
