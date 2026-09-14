package q2;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* loaded from: classes.dex */
final class l0 extends s2.d0 {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f13506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(h0 h0Var) {
        this.f13506a = h0Var;
    }

    @Override // s2.e0
    public final void L(LocationAvailability locationAvailability) {
        this.f13506a.zza().c(new j0(this, locationAvailability));
    }

    @Override // s2.e0
    public final void m() {
        this.f13506a.zza().c(new k0(this));
    }

    @Override // s2.e0
    public final void v0(LocationResult locationResult) {
        this.f13506a.zza().c(new i0(this, locationResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x0() {
        this.f13506a.zza().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l0 z(com.google.android.gms.common.api.internal.l lVar) {
        this.f13506a.b(lVar);
        return this;
    }
}
