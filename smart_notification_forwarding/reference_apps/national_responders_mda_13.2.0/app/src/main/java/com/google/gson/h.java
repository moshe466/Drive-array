package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends k implements Iterable<k> {

    /* renamed from: f, reason: collision with root package name */
    private final List<k> f7515f = new ArrayList();

    @Override // com.google.gson.k
    public int c() {
        if (this.f7515f.size() == 1) {
            return this.f7515f.get(0).c();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).f7515f.equals(this.f7515f));
    }

    public int hashCode() {
        return this.f7515f.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f7515f.iterator();
    }

    @Override // com.google.gson.k
    public long l() {
        if (this.f7515f.size() == 1) {
            return this.f7515f.get(0).l();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.k
    public String s() {
        if (this.f7515f.size() == 1) {
            return this.f7515f.get(0).s();
        }
        throw new IllegalStateException();
    }

    public int size() {
        return this.f7515f.size();
    }

    public void x(k kVar) {
        if (kVar == null) {
            kVar = m.f7516a;
        }
        this.f7515f.add(kVar);
    }

    public void y(String str) {
        this.f7515f.add(str == null ? m.f7516a : new q(str));
    }

    public k z(int i10) {
        return this.f7515f.get(i10);
    }
}
