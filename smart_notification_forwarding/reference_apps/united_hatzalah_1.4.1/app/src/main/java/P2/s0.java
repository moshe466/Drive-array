package P2;

import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0792h;

/* loaded from: classes.dex */
public final class s0 extends AbstractC0792h implements F2.p {

    /* renamed from: b, reason: collision with root package name */
    public y0 f1694b;

    /* renamed from: c, reason: collision with root package name */
    public U2.j f1695c;

    /* renamed from: d, reason: collision with root package name */
    public int f1696d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f1697e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w0 f1698f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(w0 w0Var, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f1698f = w0Var;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        s0 s0Var = new s0(this.f1698f, interfaceC0763d);
        s0Var.f1697e = obj;
        return s0Var;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((s0) create((M2.e) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0062 -> B:6:0x0077). Please report as a decompilation issue!!! */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r5.f1696d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            U2.j r1 = r5.f1695c
            P2.y0 r3 = r5.f1694b
            java.lang.Object r4 = r5.f1697e
            M2.e r4 = (M2.e) r4
            a.AbstractC0228a.C(r6)
            goto L77
        L18:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L20:
            a.AbstractC0228a.C(r6)
            goto L7c
        L24:
            a.AbstractC0228a.C(r6)
            java.lang.Object r6 = r5.f1697e
            M2.e r6 = (M2.e) r6
            P2.w0 r1 = r5.f1698f
            java.lang.Object r1 = r1.x()
            boolean r4 = r1 instanceof P2.C0167q
            if (r4 == 0) goto L3f
            P2.q r1 = (P2.C0167q) r1
            P2.r r1 = r1.f1687e
            r5.f1696d = r3
            r6.b(r1, r5)
            return r0
        L3f:
            boolean r3 = r1 instanceof P2.InterfaceC0147d0
            if (r3 == 0) goto L7c
            P2.d0 r1 = (P2.InterfaceC0147d0) r1
            P2.y0 r1 = r1.c()
            if (r1 == 0) goto L7c
            java.lang.Object r3 = r1.f()
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.j.c(r3, r4)
            U2.j r3 = (U2.j) r3
            r4 = r3
            r3 = r1
            r1 = r4
            r4 = r6
        L5a:
            boolean r6 = r1.equals(r3)
            if (r6 != 0) goto L7c
            boolean r6 = r1 instanceof P2.C0167q
            if (r6 == 0) goto L77
            r6 = r1
            P2.q r6 = (P2.C0167q) r6
            P2.r r6 = r6.f1687e
            r5.f1697e = r4
            r5.f1694b = r3
            r5.f1695c = r1
            r5.f1696d = r2
            r4.b(r6, r5)
            x2.a r6 = x2.EnumC0779a.f6740a
            return r0
        L77:
            U2.j r1 = r1.g()
            goto L5a
        L7c:
            s2.i r6 = s2.C0684i.f6340a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.s0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
