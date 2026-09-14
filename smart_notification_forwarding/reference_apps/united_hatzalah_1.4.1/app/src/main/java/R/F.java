package R;

import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class F extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public Object f1763a;

    /* renamed from: b, reason: collision with root package name */
    public int f1764b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f1765c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f1766d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1767e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(P p, int i, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1766d = p;
        this.f1767e = i;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        F f4 = new F(this.f1766d, this.f1767e, interfaceC0763d);
        f4.f1765c = ((Boolean) obj).booleanValue();
        return f4;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((F) create(bool, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:
    
        if (r7 == r0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0055  */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r6.f1764b
            R.P r2 = r6.f1766d
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L22
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            java.lang.Object r0 = r6.f1763a
            a.AbstractC0228a.C(r7)
            goto L45
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            boolean r1 = r6.f1765c
            a.AbstractC0228a.C(r7)
            goto L32
        L22:
            a.AbstractC0228a.C(r7)
            boolean r1 = r6.f1765c
            r6.f1765c = r1
            r6.f1764b = r4
            java.lang.Object r7 = r2.i(r6)
            if (r7 != r0) goto L32
            goto L42
        L32:
            if (r1 == 0) goto L4c
            R.j0 r1 = r2.g()
            r6.f1763a = r7
            r6.f1764b = r3
            java.lang.Integer r1 = r1.a()
            if (r1 != r0) goto L43
        L42:
            return r0
        L43:
            r0 = r7
            r7 = r1
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            goto L51
        L4c:
            int r0 = r6.f1767e
            r5 = r0
            r0 = r7
            r7 = r5
        L51:
            R.c r1 = new R.c
            if (r0 == 0) goto L5a
            int r2 = r0.hashCode()
            goto L5b
        L5a:
            r2 = 0
        L5b:
            r1.<init>(r0, r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: R.F.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
