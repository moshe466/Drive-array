package b2;

import android.app.PendingIntent;
import android.os.Bundle;

/* loaded from: classes.dex */
abstract class p0 extends z0 {

    /* renamed from: d, reason: collision with root package name */
    public final int f4058d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f4059e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ c f4060f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(c cVar, int i10, Bundle bundle) {
        super(cVar, Boolean.TRUE);
        this.f4060f = cVar;
        this.f4058d = i10;
        this.f4059e = bundle;
    }

    @Override // b2.z0
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        com.google.android.gms.common.a aVar;
        if (this.f4058d != 0) {
            this.f4060f.n0(1, null);
            Bundle bundle = this.f4059e;
            aVar = new com.google.android.gms.common.a(this.f4058d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
        } else {
            if (g()) {
                return;
            }
            this.f4060f.n0(1, null);
            aVar = new com.google.android.gms.common.a(8, null);
        }
        f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.z0
    public final void b() {
    }

    protected abstract void f(com.google.android.gms.common.a aVar);

    protected abstract boolean g();
}
