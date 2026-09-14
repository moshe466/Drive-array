package R;

import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class f0 extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public M f1872a;

    /* renamed from: b, reason: collision with root package name */
    public int f1873b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ K1.m f1874c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(K1.m mVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1874c = mVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new f0(this.f1874c, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((f0) create((P2.E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0157, code lost:
    
        if (r3 == r0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0132, code lost:
    
        if (r3 == R2.e.f2048n) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0134, code lost:
    
        r4.b();
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0143, code lost:
    
        throw new java.lang.IllegalStateException(r18);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0176  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0166 -> B:6:0x0168). Please report as a decompilation issue!!! */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R.f0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
