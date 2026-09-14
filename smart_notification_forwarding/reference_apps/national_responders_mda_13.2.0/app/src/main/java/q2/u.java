package q2;

import a2.a;
import a2.e;
import android.app.PendingIntent;
import android.content.Context;

/* loaded from: classes.dex */
public final class u extends a2.e implements s2.k {
    public u(Context context) {
        super(context, q.f13528k, a.d.f53a, e.a.f65c);
    }

    @Override // s2.k
    public final z2.l<Void> a(final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.v.a().b(new com.google.android.gms.common.api.internal.r() { // from class: q2.t
            @Override // com.google.android.gms.common.api.internal.r
            public final void c(Object obj, Object obj2) {
                ((n0) obj).v0(pendingIntent, (z2.m) obj2);
            }
        }).e(2425).a());
    }

    @Override // s2.k
    public final z2.l<Void> b(s2.m mVar, final PendingIntent pendingIntent) {
        final s2.m j10 = mVar.j(q());
        return o(com.google.android.gms.common.api.internal.v.a().b(new com.google.android.gms.common.api.internal.r() { // from class: q2.s
            @Override // com.google.android.gms.common.api.internal.r
            public final void c(Object obj, Object obj2) {
                ((n0) obj).s0(s2.m.this, pendingIntent, (z2.m) obj2);
            }
        }).e(2424).a());
    }
}
