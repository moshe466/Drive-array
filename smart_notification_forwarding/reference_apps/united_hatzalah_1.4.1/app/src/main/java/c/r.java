package c;

import s2.C0684i;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3841a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f3842b;

    public /* synthetic */ r(x xVar, int i) {
        this.f3841a = i;
        this.f3842b = xVar;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f3841a) {
            case 0:
                this.f3842b.c();
                break;
            case 1:
                this.f3842b.b();
                break;
            default:
                this.f3842b.c();
                break;
        }
        return C0684i.f6340a;
    }
}
