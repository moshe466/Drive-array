package com.google.crypto.tink.shaded.protobuf;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class T implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0329a f4070a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f4071b;

    /* renamed from: c, reason: collision with root package name */
    public final C0345q f4072c;

    public T(d0 d0Var, C0345q c0345q, AbstractC0329a abstractC0329a) {
        this.f4071b = d0Var;
        c0345q.getClass();
        this.f4072c = c0345q;
        this.f4070a = abstractC0329a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void a(Object obj, Object obj2) {
        c0.w(this.f4071b, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void b(Object obj) {
        ((f0) this.f4071b).getClass();
        ((AbstractC0351x) obj).unknownFields.f4100e = false;
        this.f4072c.getClass();
        AbstractC0008a.z(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final boolean c(Object obj) {
        this.f4072c.getClass();
        AbstractC0008a.z(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final boolean d(AbstractC0351x abstractC0351x, AbstractC0351x abstractC0351x2) {
        f0 f0Var = (f0) this.f4071b;
        f0Var.getClass();
        e0 e0Var = abstractC0351x.unknownFields;
        f0Var.getClass();
        if (!e0Var.equals(abstractC0351x2.unknownFields)) {
            return false;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final int e(AbstractC0351x abstractC0351x) {
        ((f0) this.f4071b).getClass();
        return abstractC0351x.unknownFields.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final int f(AbstractC0351x abstractC0351x) {
        ((f0) this.f4071b).getClass();
        e0 e0Var = abstractC0351x.unknownFields;
        int i = e0Var.f4099d;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < e0Var.f4096a; i4++) {
            int i5 = e0Var.f4097b[i4] >>> 3;
            i3 += C0341m.F(3, (AbstractC0337i) e0Var.f4098c[i4]) + C0341m.N(i5) + C0341m.M(2) + (C0341m.M(1) * 2);
        }
        e0Var.f4099d = i3;
        return i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void g(Object obj, byte[] bArr, int i, int i3, C0332d c0332d) {
        AbstractC0351x abstractC0351x = (AbstractC0351x) obj;
        if (abstractC0351x.unknownFields == e0.f4095f) {
            abstractC0351x.unknownFields = e0.c();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void h(Object obj, C0340l c0340l, C0344p c0344p) {
        this.f4071b.a(obj);
        this.f4072c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final void i(Object obj, K k4) {
        this.f4072c.getClass();
        AbstractC0008a.z(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0
    public final Object newInstance() {
        AbstractC0329a abstractC0329a = this.f4070a;
        if (abstractC0329a instanceof AbstractC0351x) {
            return ((AbstractC0351x) abstractC0329a).q();
        }
        return abstractC0329a.d().c();
    }
}
