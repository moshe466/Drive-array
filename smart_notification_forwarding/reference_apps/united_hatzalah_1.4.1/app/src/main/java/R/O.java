package R;

import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class O extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.q f1796a;

    /* renamed from: b, reason: collision with root package name */
    public int f1797b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1798c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.q f1799d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ P f1800e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1801f;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f1802j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(kotlin.jvm.internal.q qVar, P p, Object obj, boolean z3, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1799d = qVar;
        this.f1800e = p;
        this.f1801f = obj;
        this.f1802j = z3;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        O o2 = new O(this.f1799d, this.f1800e, this.f1801f, this.f1802j, interfaceC0763d);
        o2.f1798c = obj;
        return o2;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((O) create((a0) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r6.b(r2, r7) == r0) goto L16;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r7.f1797b
            java.lang.Object r2 = r7.f1801f
            R.P r3 = r7.f1800e
            kotlin.jvm.internal.q r4 = r7.f1799d
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L28
            if (r1 == r6) goto L1e
            if (r1 != r5) goto L16
            a.AbstractC0228a.C(r8)
            goto L65
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlin.jvm.internal.q r1 = r7.f1796a
            java.lang.Object r6 = r7.f1798c
            R.a0 r6 = (R.a0) r6
            a.AbstractC0228a.C(r8)
            goto L4f
        L28:
            a.AbstractC0228a.C(r8)
            java.lang.Object r8 = r7.f1798c
            R.a0 r8 = (R.a0) r8
            R.j0 r1 = r3.g()
            r7.f1798c = r8
            r7.f1796a = r4
            r7.f1797b = r6
            F0.j2 r1 = r1.f1904b
            java.lang.Object r1 = r1.f546b
            java.util.concurrent.atomic.AtomicInteger r1 = (java.util.concurrent.atomic.AtomicInteger) r1
            int r1 = r1.incrementAndGet()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r1)
            if (r6 != r0) goto L4b
            goto L64
        L4b:
            r1 = r6
            r6 = r8
            r8 = r1
            r1 = r4
        L4f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.f5311a = r8
            r8 = 0
            r7.f1798c = r8
            r7.f1796a = r8
            r7.f1797b = r5
            java.lang.Object r8 = r6.b(r2, r7)
            if (r8 != r0) goto L65
        L64:
            return r0
        L65:
            boolean r8 = r7.f1802j
            if (r8 == 0) goto L7d
            F0.G1 r8 = r3.f1810h
            R.c r0 = new R.c
            if (r2 == 0) goto L74
            int r1 = r2.hashCode()
            goto L75
        L74:
            r1 = 0
        L75:
            int r3 = r4.f5311a
            r0.<init>(r2, r1, r3)
            r8.n(r0)
        L7d:
            s2.i r8 = s2.C0684i.f6340a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: R.O.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
