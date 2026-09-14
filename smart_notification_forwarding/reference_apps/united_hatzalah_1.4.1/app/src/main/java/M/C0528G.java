package m;

import l.InterfaceC0500D;

/* renamed from: m.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0528G extends AbstractViewOnTouchListenerC0582z0 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ O f5526m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ S f5527n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0528G(S s3, S s4, O o2) {
        super(s4);
        this.f5527n = s3;
        this.f5526m = o2;
    }

    @Override // m.AbstractViewOnTouchListenerC0582z0
    public final InterfaceC0500D b() {
        return this.f5526m;
    }

    @Override // m.AbstractViewOnTouchListenerC0582z0
    public final boolean c() {
        S s3 = this.f5527n;
        if (!s3.getInternalPopup().a()) {
            s3.f5590f.l(AbstractC0530I.b(s3), AbstractC0530I.a(s3));
            return true;
        }
        return true;
    }
}
