package P2;

import F0.G1;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: P2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0144c extends m0 {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1644k = AtomicReferenceFieldUpdater.newUpdater(C0144c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;

    /* renamed from: e, reason: collision with root package name */
    public final C0163m f1645e;

    /* renamed from: f, reason: collision with root package name */
    public Q f1646f;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ C0148e f1647j;

    public C0144c(C0148e c0148e, C0163m c0163m) {
        this.f1647j = c0148e;
        this.f1645e = c0163m;
    }

    @Override // P2.InterfaceC0153g0
    public final void a(Throwable th) {
        C0163m c0163m = this.f1645e;
        if (th != null) {
            c0163m.getClass();
            G1 C3 = c0163m.C(new C0171v(th, false), null);
            if (C3 != null) {
                c0163m.f(C3);
                C0146d c0146d = (C0146d) f1644k.get(this);
                if (c0146d != null) {
                    c0146d.b();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C0148e.f1650b;
        C0148e c0148e = this.f1647j;
        if (atomicIntegerFieldUpdater.decrementAndGet(c0148e) == 0) {
            J[] jArr = c0148e.f1651a;
            ArrayList arrayList = new ArrayList(jArr.length);
            for (J j2 : jArr) {
                arrayList.add(j2.getCompleted());
            }
            c0163m.resumeWith(arrayList);
        }
    }
}
