package q2;

import android.location.Location;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class e0 extends w1 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z2.m f13484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(n0 n0Var, z2.m mVar) {
        this.f13484a = mVar;
    }

    @Override // q2.x1
    public final void H(Status status, Location location) {
        com.google.android.gms.common.api.internal.w.a(status, location, this.f13484a);
    }
}
