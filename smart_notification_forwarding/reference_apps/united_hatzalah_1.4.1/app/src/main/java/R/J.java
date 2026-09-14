package R;

import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class J extends AbstractC0793i implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public Object f1778a;

    /* renamed from: b, reason: collision with root package name */
    public int f1779b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ P f1780c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0768i f1781d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AbstractC0793i f1782e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public J(P p, InterfaceC0768i interfaceC0768i, F2.p pVar, InterfaceC0763d interfaceC0763d) {
        super(1, interfaceC0763d);
        this.f1780c = p;
        this.f1781d = interfaceC0768i;
        this.f1782e = (AbstractC0793i) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(InterfaceC0763d interfaceC0763d) {
        return new J(this.f1780c, this.f1781d, this.f1782e, interfaceC0763d);
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        return ((J) create((InterfaceC0763d) obj)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        if (r9 == r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0034, code lost:
    
        if (r9 == r0) goto L29;
     */
    /* JADX WARN: Type inference failed for: r6v0, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r8.f1779b
            R.P r2 = r8.f1780c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2b
            if (r1 == r5) goto L27
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            java.lang.Object r0 = r8.f1778a
            a.AbstractC0228a.C(r9)
            return r0
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            java.lang.Object r1 = r8.f1778a
            R.c r1 = (R.C0178c) r1
            a.AbstractC0228a.C(r9)
            goto L4f
        L27:
            a.AbstractC0228a.C(r9)
            goto L37
        L2b:
            a.AbstractC0228a.C(r9)
            r8.f1779b = r5
            java.lang.Object r9 = R.P.f(r2, r5, r8)
            if (r9 != r0) goto L37
            goto L6f
        L37:
            r1 = r9
            R.c r1 = (R.C0178c) r1
            R.I r9 = new R.I
            y2.i r6 = r8.f1782e
            r7 = 0
            r9.<init>(r6, r1, r7)
            r8.f1778a = r1
            r8.f1779b = r4
            w2.i r4 = r8.f1781d
            java.lang.Object r9 = P2.G.z(r4, r9, r8)
            if (r9 != r0) goto L4f
            goto L6f
        L4f:
            java.lang.Object r4 = r1.f1852b
            if (r4 == 0) goto L58
            int r4 = r4.hashCode()
            goto L59
        L58:
            r4 = 0
        L59:
            int r6 = r1.f1853c
            if (r4 != r6) goto L71
            java.lang.Object r1 = r1.f1852b
            boolean r1 = kotlin.jvm.internal.j.a(r1, r9)
            if (r1 != 0) goto L70
            r8.f1778a = r9
            r8.f1779b = r3
            java.lang.Object r1 = r2.j(r9, r5, r8)
            if (r1 != r0) goto L70
        L6f:
            return r0
        L70:
            return r9
        L71:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data in DataStore was mutated but DataStore is only compatible with Immutable types."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: R.J.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
