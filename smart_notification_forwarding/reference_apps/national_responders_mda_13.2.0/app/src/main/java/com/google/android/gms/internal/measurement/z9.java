package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes.dex */
public final class z9<K, V> implements Comparable<z9>, Map.Entry<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private final Comparable f5737f;

    /* renamed from: g, reason: collision with root package name */
    private V f5738g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q9 f5739h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public z9(q9 q9Var, K k10, V v10) {
        this.f5739h = q9Var;
        this.f5737f = k10;
        this.f5738g = v10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z9(q9 q9Var, Map.Entry<K, V> entry) {
        this(q9Var, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean j(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(z9 z9Var) {
        return ((Comparable) getKey()).compareTo((Comparable) z9Var.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return j(this.f5737f, entry.getKey()) && j(this.f5738g, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f5737f;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f5738g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f5737f;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v10 = this.f5738g;
        return hashCode ^ (v10 != null ? v10.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v10) {
        this.f5739h.q();
        V v11 = this.f5738g;
        this.f5738g = v10;
        return v11;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5737f);
        String valueOf2 = String.valueOf(this.f5738g);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }
}
