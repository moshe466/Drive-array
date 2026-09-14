package R;

import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* renamed from: R.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0195u extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public C0178c f1942a;

    /* renamed from: b, reason: collision with root package name */
    public int f1943b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1944c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f1945d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0195u(P p, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1945d = p;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        C0195u c0195u = new C0195u(this.f1945d, interfaceC0763d);
        c0195u.f1944c = obj;
        return c0195u;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0195u) create((S2.e) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r3.emit(r12, r11) == r0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
    
        if ((r1 instanceof R.b0) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c8  */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R.C0195u.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
