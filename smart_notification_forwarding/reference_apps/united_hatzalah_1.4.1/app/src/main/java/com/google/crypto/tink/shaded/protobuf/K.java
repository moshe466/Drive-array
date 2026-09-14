package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: b, reason: collision with root package name */
    public static final C0348u f4049b = new C0348u(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f4050a;

    public K(C0341m c0341m) {
        B.a(c0341m, "output");
        this.f4050a = c0341m;
        c0341m.f4131j = this;
    }

    public void a(int i, AbstractC0337i abstractC0337i) {
        C0341m c0341m = (C0341m) this.f4050a;
        c0341m.W(i, 2);
        c0341m.X(abstractC0337i.size());
        C0336h c0336h = (C0336h) abstractC0337i;
        c0341m.Q(c0336h.f4105d, c0336h.l(), c0336h.size());
    }

    public void b(int i, Object obj, b0 b0Var) {
        C0341m c0341m = (C0341m) this.f4050a;
        c0341m.W(i, 3);
        b0Var.i((AbstractC0329a) obj, c0341m.f4131j);
        c0341m.W(i, 4);
    }

    public void c(int i, Object obj, b0 b0Var) {
        C0341m c0341m = (C0341m) this.f4050a;
        AbstractC0329a abstractC0329a = (AbstractC0329a) obj;
        c0341m.W(i, 2);
        c0341m.X(abstractC0329a.b(b0Var));
        b0Var.i(abstractC0329a, c0341m.f4131j);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.crypto.tink.shaded.protobuf.J] */
    public K() {
        O o2;
        try {
            o2 = (O) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            o2 = f4049b;
        }
        O[] oArr = {C0348u.f4155b, o2};
        ?? obj = new Object();
        obj.f4048a = oArr;
        Charset charset = B.f4029a;
        this.f4050a = obj;
    }
}
