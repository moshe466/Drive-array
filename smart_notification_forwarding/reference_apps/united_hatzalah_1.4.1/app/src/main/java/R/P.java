package R;

import F0.C0047j2;
import F0.G1;
import P2.C0;
import P2.InterfaceC0157i0;
import com.google.android.gms.common.api.Api;
import java.util.List;
import s2.C0682g;
import t2.AbstractC0707i;
import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class P implements InterfaceC0183h {

    /* renamed from: a, reason: collision with root package name */
    public final V f1803a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0177b f1804b;

    /* renamed from: c, reason: collision with root package name */
    public final P2.E f1805c;

    /* renamed from: f, reason: collision with root package name */
    public int f1808f;

    /* renamed from: g, reason: collision with root package name */
    public C0 f1809g;
    public final K1.m i;

    /* renamed from: j, reason: collision with root package name */
    public final C0682g f1811j;

    /* renamed from: k, reason: collision with root package name */
    public final C0682g f1812k;

    /* renamed from: l, reason: collision with root package name */
    public final K1.m f1813l;

    /* renamed from: d, reason: collision with root package name */
    public final C0194t f1806d = new C0194t(new C0195u(this, null));

    /* renamed from: e, reason: collision with root package name */
    public final Y2.d f1807e = Y2.e.a();

    /* renamed from: h, reason: collision with root package name */
    public final G1 f1810h = new G1((byte) 0);

    /* JADX WARN: Type inference failed for: r3v4, types: [K1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v9, types: [K1.m, java.lang.Object] */
    public P(V v2, List list, InterfaceC0177b interfaceC0177b, P2.E e4) {
        this.f1803a = v2;
        this.f1804b = interfaceC0177b;
        this.f1805c = e4;
        ?? obj = new Object();
        obj.f1105d = this;
        obj.f1102a = Y2.e.a();
        obj.f1104c = P2.G.a();
        obj.f1103b = AbstractC0707i.q0(list);
        this.i = obj;
        this.f1811j = T.b.A(new C0188m(this, 1));
        this.f1812k = T.b.A(new C0188m(this, 0));
        L l3 = new L(this, 0);
        M m4 = new M(this, null);
        ?? obj2 = new Object();
        obj2.f1102a = e4;
        obj2.f1103b = m4;
        obj2.f1104c = E1.b.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, 6);
        obj2.f1105d = new C0047j2(6);
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) e4.a().get(P2.B.f1595b);
        if (interfaceC0157i0 != null) {
            interfaceC0157i0.invokeOnCompletion(new Q2.d(1, l3, obj2));
        }
        this.f1813l = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x0058, TryCatch #0 {all -> 0x0058, blocks: (B:12:0x0048, B:14:0x0050, B:16:0x0054, B:17:0x005a), top: B:11:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(R.P r4, y2.AbstractC0787c r5) {
        /*
            boolean r0 = r5 instanceof R.C0196v
            if (r0 == 0) goto L13
            r0 = r5
            R.v r0 = (R.C0196v) r0
            int r1 = r0.f1950e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1950e = r1
            goto L18
        L13:
            R.v r0 = new R.v
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1948c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1950e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            Y2.d r4 = r0.f1947b
            R.P r0 = r0.f1946a
            a.AbstractC0228a.C(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.AbstractC0228a.C(r5)
            Y2.d r5 = r4.f1807e
            r0.f1946a = r4
            r0.f1947b = r5
            r0.f1950e = r3
            java.lang.Object r0 = r5.d(r0)
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.f1808f     // Catch: java.lang.Throwable -> L58
            int r1 = r1 + (-1)
            r4.f1808f = r1     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto L5c
            P2.C0 r1 = r4.f1809g     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L5a
            r1.cancel(r0)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r4 = move-exception
            goto L62
        L5a:
            r4.f1809g = r0     // Catch: java.lang.Throwable -> L58
        L5c:
            r5.f(r0)
            s2.i r4 = s2.C0684i.f6340a
            return r4
        L62:
            r5.f(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: R.P.b(R.P, y2.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|(7:55|(1:(1:(1:59)(2:61|62))(3:63|64|65))(1:66)|60|17|(1:19)(1:23)|20|21)(5:8|9|10|(3:12|13|14)(3:30|(1:32)(1:53)|(2:34|(2:36|(1:38))(2:45|46))(2:47|(2:49|50)(2:51|52)))|24)|39|40|41))|68|6|(0)(0)|39|40|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0076, code lost:
    
        if (r9 == r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0079, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
    
        if (r9 != r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0052  */
    /* JADX WARN: Type inference failed for: r2v3, types: [y2.i, F2.p] */
    /* JADX WARN: Type inference failed for: r2v9, types: [y2.i, F2.p] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(R.P r9, R.c0 r10, y2.AbstractC0787c r11) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R.P.c(R.P, R.c0, y2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #0 {all -> 0x005e, blocks: (B:12:0x0048, B:14:0x004f), top: B:11:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(R.P r4, y2.AbstractC0787c r5) {
        /*
            boolean r0 = r5 instanceof R.C0199y
            if (r0 == 0) goto L13
            r0 = r5
            R.y r0 = (R.C0199y) r0
            int r1 = r0.f1963e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1963e = r1
            goto L18
        L13:
            R.y r0 = new R.y
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1961c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1963e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            Y2.d r4 = r0.f1960b
            R.P r0 = r0.f1959a
            a.AbstractC0228a.C(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.AbstractC0228a.C(r5)
            Y2.d r5 = r4.f1807e
            r0.f1959a = r4
            r0.f1960b = r5
            r0.f1963e = r3
            java.lang.Object r0 = r5.d(r0)
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.f1808f     // Catch: java.lang.Throwable -> L5e
            int r1 = r1 + r3
            r4.f1808f = r1     // Catch: java.lang.Throwable -> L5e
            if (r1 != r3) goto L60
            P2.E r1 = r4.f1805c     // Catch: java.lang.Throwable -> L5e
            R.z r2 = new R.z     // Catch: java.lang.Throwable -> L5e
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L5e
            r3 = 3
            P2.C0 r1 = P2.G.r(r1, r0, r2, r3)     // Catch: java.lang.Throwable -> L5e
            r4.f1809g = r1     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            r4 = move-exception
            goto L66
        L60:
            r5.f(r0)
            s2.i r4 = s2.C0684i.f6340a
            return r4
        L66:
            r5.f(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: R.P.d(R.P, y2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(R.P r8, boolean r9, w2.InterfaceC0763d r10) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R.P.e(R.P, boolean, w2.d):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|72|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x005f, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013b A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:27:0x0129, B:29:0x013b, B:32:0x0143), top: B:26:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143 A[Catch: all -> 0x0167, TRY_LEAVE, TryCatch #1 {all -> 0x0167, blocks: (B:27:0x0129, B:29:0x013b, B:32:0x0143), top: B:26:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f A[Catch: CorruptionException -> 0x005f, TryCatch #3 {CorruptionException -> 0x005f, blocks: (B:36:0x005a, B:37:0x00fe, B:40:0x0068, B:41:0x00e0, B:56:0x0085, B:58:0x009f, B:59:0x00a5, B:65:0x008e, B:68:0x00cd), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlin.jvm.internal.q, java.lang.Object, java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.r, java.lang.Object, java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(R.P r9, boolean r10, y2.AbstractC0787c r11) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R.P.f(R.P, boolean, y2.c):java.lang.Object");
    }

    @Override // R.InterfaceC0183h
    public final Object a(F2.p pVar, InterfaceC0763d interfaceC0763d) {
        o0 o0Var = (o0) interfaceC0763d.getContext().get(n0.f1926a);
        if (o0Var != null) {
            o0Var.a(this);
        }
        return P2.G.z(new o0(o0Var, this), new K(this, pVar, null), interfaceC0763d);
    }

    public final j0 g() {
        return (j0) this.f1812k.a();
    }

    @Override // R.InterfaceC0183h
    public final S2.d getData() {
        return this.f1806d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (r4.p(r0) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(y2.AbstractC0787c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof R.A
            if (r0 == 0) goto L13
            r0 = r6
            R.A r0 = (R.A) r0
            int r1 = r0.f1739e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1739e = r1
            goto L18
        L13:
            R.A r0 = new R.A
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f1737c
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1739e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            int r1 = r0.f1736b
            R.P r0 = r0.f1735a
            a.AbstractC0228a.C(r6)     // Catch: java.lang.Throwable -> L2e
            goto L66
        L2e:
            r6 = move-exception
            goto L6d
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            R.P r2 = r0.f1735a
            a.AbstractC0228a.C(r6)
            goto L51
        L3e:
            a.AbstractC0228a.C(r6)
            R.j0 r6 = r5.g()
            r0.f1735a = r5
            r0.f1739e = r4
            java.lang.Integer r6 = r6.a()
            if (r6 != r1) goto L50
            goto L65
        L50:
            r2 = r5
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            K1.m r4 = r2.i     // Catch: java.lang.Throwable -> L69
            r0.f1735a = r2     // Catch: java.lang.Throwable -> L69
            r0.f1736b = r6     // Catch: java.lang.Throwable -> L69
            r0.f1739e = r3     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = r4.p(r0)     // Catch: java.lang.Throwable -> L69
            if (r6 != r1) goto L66
        L65:
            return r1
        L66:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        L69:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L6d:
            F0.G1 r0 = r0.f1810h
            R.d0 r2 = new R.d0
            r2.<init>(r6, r1)
            r0.n(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: R.P.h(y2.c):java.lang.Object");
    }

    public final Object i(AbstractC0787c abstractC0787c) {
        return ((Y) this.f1811j.a()).a(new C0192q(3, (InterfaceC0763d) null), abstractC0787c);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.internal.q, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r11, boolean r12, y2.AbstractC0787c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof R.N
            if (r0 == 0) goto L13
            r0 = r13
            R.N r0 = (R.N) r0
            int r1 = r0.f1795d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1795d = r1
            goto L18
        L13:
            R.N r0 = new R.N
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f1793b
            x2.a r1 = x2.EnumC0779a.f6740a
            int r2 = r0.f1795d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.jvm.internal.q r11 = r0.f1792a
            a.AbstractC0228a.C(r13)
            goto L56
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            a.AbstractC0228a.C(r13)
            kotlin.jvm.internal.q r5 = new kotlin.jvm.internal.q
            r5.<init>()
            s2.g r13 = r10.f1811j
            java.lang.Object r13 = r13.a()
            R.Y r13 = (R.Y) r13
            R.O r4 = new R.O
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f1792a = r5
            r0.f1795d = r3
            java.lang.Object r11 = r13.b(r4, r0)
            if (r11 != r1) goto L55
            return r1
        L55:
            r11 = r5
        L56:
            int r11 = r11.f5311a
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: R.P.j(java.lang.Object, boolean, y2.c):java.lang.Object");
    }
}
