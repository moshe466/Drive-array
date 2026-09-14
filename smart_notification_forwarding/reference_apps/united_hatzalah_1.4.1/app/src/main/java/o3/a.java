package o3;

import java.io.Serializable;
import java.util.Queue;
import p3.e;

/* loaded from: classes.dex */
public final class a implements n3.b, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f5952a;

    /* renamed from: b, reason: collision with root package name */
    public e f5953b;

    /* renamed from: c, reason: collision with root package name */
    public Queue f5954c;

    @Override // n3.b
    public final void A(String str, Object obj, Serializable serializable) {
        B(3, str, obj, serializable);
    }

    public final void B(int i, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            D(i, new Object[]{obj});
        } else {
            D(i, new Object[]{obj, obj2});
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(int r3, java.lang.String r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            int r4 = r5.length
            if (r4 != 0) goto L4
            goto L10
        L4:
            int r4 = r5.length
            int r4 = r4 + (-1)
            r4 = r5[r4]
            boolean r0 = r4 instanceof java.lang.Throwable
            if (r0 == 0) goto L10
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            goto L11
        L10:
            r4 = 0
        L11:
            if (r4 == 0) goto L2d
            int r4 = r5.length
            if (r4 == 0) goto L25
            int r4 = r5.length
            int r4 = r4 + (-1)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            if (r4 <= 0) goto L21
            r1 = 0
            java.lang.System.arraycopy(r5, r1, r0, r1, r4)
        L21:
            r2.D(r3, r0)
            return
        L25:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "non-sensical empty or null argument array"
            r3.<init>(r4)
            throw r3
        L2d:
            r2.D(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.a.C(int, java.lang.String, java.lang.Object[]):void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, o3.b] */
    public final void D(int i, Object[] objArr) {
        ?? obj = new Object();
        System.currentTimeMillis();
        obj.f5955a = i;
        obj.f5956b = this.f5953b;
        Thread.currentThread().getName();
        obj.f5957c = objArr;
        this.f5954c.add(obj);
    }

    @Override // n3.b
    public final boolean a() {
        return true;
    }

    @Override // n3.b
    public final boolean b() {
        return true;
    }

    @Override // n3.b
    public final void c(Object obj, Object obj2) {
        B(1, "Error assigning value '{}' to '{}'", obj, obj2);
    }

    @Override // n3.b
    public final void e(String str, Throwable th) {
        D(1, null);
    }

    @Override // n3.b
    public final void f(Object obj, String str) {
        D(5, new Object[]{obj});
    }

    @Override // n3.b
    public final boolean g() {
        return true;
    }

    @Override // n3.b
    public final String getName() {
        return this.f5952a;
    }

    @Override // n3.b
    public final void h(String str, Object... objArr) {
        C(2, str, objArr);
    }

    @Override // n3.b
    public final boolean i() {
        return true;
    }

    @Override // n3.b
    public final void j(String str) {
        D(4, null);
    }

    @Override // n3.b
    public final boolean k() {
        return true;
    }

    @Override // n3.b
    public final void l(String str, Integer num) {
        D(2, new Object[]{num});
    }

    @Override // n3.b
    public final void m(String str, Object obj, Serializable serializable) {
        B(5, str, obj, serializable);
    }

    @Override // n3.b
    public final void n(String str, Object... objArr) {
        C(4, str, objArr);
    }

    @Override // n3.b
    public final void o(Object... objArr) {
        C(1, "pipesClientId={} didn't receive ready byte from server within StartupTimeoutMillis {}; ms elapsed {}; did read >{}<", objArr);
    }

    @Override // n3.b
    public final void p(String str, Throwable th) {
        D(2, null);
    }

    @Override // n3.b
    public final void q(Object obj, String str) {
        D(1, new Object[]{obj});
    }

    @Override // n3.b
    public final void r(Object obj, String str, Object obj2) {
        B(2, str, obj, obj2);
    }

    @Override // n3.b
    public final void s(String str, Throwable th) {
        D(4, null);
    }

    @Override // n3.b
    public final void t(String str) {
        D(3, null);
    }

    @Override // n3.b
    public final void u(String str) {
        D(2, null);
    }

    @Override // n3.b
    public final void v(String str) {
        D(5, null);
    }

    @Override // n3.b
    public final void x(Object obj, String str) {
        D(4, new Object[]{obj});
    }

    @Override // n3.b
    public final void y(Object obj, String str, Object obj2) {
        B(4, str, obj, obj2);
    }

    @Override // n3.b
    public final void z(String str, Integer num) {
        D(3, new Object[]{num});
    }
}
