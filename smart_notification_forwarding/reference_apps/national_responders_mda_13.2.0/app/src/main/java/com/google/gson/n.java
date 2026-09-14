package com.google.gson;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class n extends k {

    /* renamed from: a, reason: collision with root package name */
    private final z4.h<String, k> f7517a = new z4.h<>();

    public Set<Map.Entry<String, k>> A() {
        return this.f7517a.entrySet();
    }

    public k B(String str) {
        return this.f7517a.get(str);
    }

    public h C(String str) {
        return (h) this.f7517a.get(str);
    }

    public boolean D(String str) {
        return this.f7517a.containsKey(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f7517a.equals(this.f7517a));
    }

    public int hashCode() {
        return this.f7517a.hashCode();
    }

    public void x(String str, k kVar) {
        z4.h<String, k> hVar = this.f7517a;
        if (kVar == null) {
            kVar = m.f7516a;
        }
        hVar.put(str, kVar);
    }

    public void y(String str, Number number) {
        x(str, number == null ? m.f7516a : new q(number));
    }

    public void z(String str, String str2) {
        x(str, str2 == null ? m.f7516a : new q(str2));
    }
}
