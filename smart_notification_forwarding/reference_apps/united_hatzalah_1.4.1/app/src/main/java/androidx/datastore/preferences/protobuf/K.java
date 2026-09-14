package androidx.datastore.preferences.protobuf;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class K implements S {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0234a f3115a;

    /* renamed from: b, reason: collision with root package name */
    public final Y f3116b;

    /* renamed from: c, reason: collision with root package name */
    public final C0247n f3117c;

    public K(Y y, C0247n c0247n, AbstractC0234a abstractC0234a) {
        this.f3116b = y;
        c0247n.getClass();
        this.f3117c = c0247n;
        this.f3115a = abstractC0234a;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final void a(Object obj, Object obj2) {
        T.k(this.f3116b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final void b(Object obj) {
        ((a0) this.f3116b).getClass();
        Z z3 = ((AbstractC0253u) obj).unknownFields;
        if (z3.f3153e) {
            z3.f3153e = false;
        }
        this.f3117c.getClass();
        AbstractC0008a.z(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final boolean c(Object obj) {
        this.f3117c.getClass();
        AbstractC0008a.z(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final void d(Object obj, B b4) {
        this.f3117c.getClass();
        AbstractC0008a.z(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final int e(AbstractC0253u abstractC0253u) {
        ((a0) this.f3116b).getClass();
        Z z3 = abstractC0253u.unknownFields;
        int i = z3.f3152d;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < z3.f3149a; i4++) {
            int i5 = z3.f3150b[i4] >>> 3;
            i3 += C0244k.K(3, (C0240g) z3.f3151c[i4]) + C0244k.N(i5) + C0244k.M(2) + (C0244k.M(1) * 2);
        }
        z3.f3152d = i3;
        return i3;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final int f(AbstractC0253u abstractC0253u) {
        ((a0) this.f3116b).getClass();
        return abstractC0253u.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final boolean g(AbstractC0253u abstractC0253u, AbstractC0253u abstractC0253u2) {
        a0 a0Var = (a0) this.f3116b;
        a0Var.getClass();
        Z z3 = abstractC0253u.unknownFields;
        a0Var.getClass();
        if (!z3.equals(abstractC0253u2.unknownFields)) {
            return false;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final void h(Object obj, C0243j c0243j, C0246m c0246m) {
        this.f3116b.a(obj);
        this.f3117c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public final AbstractC0253u newInstance() {
        AbstractC0234a abstractC0234a = this.f3115a;
        if (abstractC0234a instanceof AbstractC0253u) {
            return ((AbstractC0253u) abstractC0234a).i();
        }
        return ((AbstractC0251s) ((AbstractC0253u) abstractC0234a).c(5)).b();
    }
}
