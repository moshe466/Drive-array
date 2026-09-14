package t2;

import java.util.Iterator;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0792h;

/* loaded from: classes.dex */
public final class x extends AbstractC0792h implements F2.p {

    /* renamed from: b, reason: collision with root package name */
    public Object f6488b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f6489c;

    /* renamed from: d, reason: collision with root package name */
    public int f6490d;

    /* renamed from: e, reason: collision with root package name */
    public int f6491e;

    /* renamed from: f, reason: collision with root package name */
    public int f6492f;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6493j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f6494k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6495l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Iterator f6496m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f6497n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f6498o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(int i, int i3, Iterator it, boolean z3, boolean z4, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.f6494k = i;
        this.f6495l = i3;
        this.f6496m = it;
        this.f6497n = z3;
        this.f6498o = z4;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        x xVar = new x(this.f6494k, this.f6495l, this.f6496m, this.f6497n, this.f6498o, interfaceC0763d);
        xVar.f6493j = obj;
        return xVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((x) create((M2.e) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0097  */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.x.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
