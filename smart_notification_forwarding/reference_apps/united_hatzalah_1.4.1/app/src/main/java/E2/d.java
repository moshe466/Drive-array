package e2;

import F0.Q;
import F2.p;
import P2.E;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class d extends AbstractC0793i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f4458a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Q f4459b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Q q3, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f4459b = q3;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new d(this.f4459b, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        ((d) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
        return EnumC0779a.f6740a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
    
        if (P2.G.h(3600000, r9) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (F0.Q.c(r0, r2, r9) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        return r3;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0044 -> B:12:0x0026). Please report as a decompilation issue!!! */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            F0.Q r0 = r9.f4459b
            java.lang.Object r1 = r0.f361b
            c2.a r1 = (c2.C0328a) r1
            java.lang.Object r2 = r0.f360a
            F0.g2 r2 = (F0.C0035g2) r2
            x2.a r3 = x2.EnumC0779a.f6740a
            int r4 = r9.f4458a
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L23
            if (r4 == r6) goto L1f
            if (r4 != r5) goto L17
            goto L23
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1f:
            a.AbstractC0228a.C(r10)     // Catch: java.lang.Exception -> L2f
            goto L32
        L23:
            a.AbstractC0228a.C(r10)
        L26:
            r9.f4458a = r6     // Catch: java.lang.Exception -> L2f
            java.io.Serializable r10 = F0.Q.c(r0, r2, r9)     // Catch: java.lang.Exception -> L2f
            if (r10 != r3) goto L32
            goto L46
        L2f:
            r1.getClass()
        L32:
            r2.getClass()
            r1.getClass()
            r2.getClass()
            r9.f4458a = r5
            r7 = 3600000(0x36ee80, double:1.7786363E-317)
            java.lang.Object r10 = P2.G.h(r7, r9)
            if (r10 != r3) goto L26
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
