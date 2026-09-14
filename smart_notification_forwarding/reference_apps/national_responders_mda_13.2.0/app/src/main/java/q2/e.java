package q2;

import a2.a;
import a2.e;
import android.app.PendingIntent;
import android.content.Context;

/* loaded from: classes.dex */
public final class e extends a2.e implements s2.b {

    /* renamed from: j, reason: collision with root package name */
    static final a.g f13482j;

    /* renamed from: k, reason: collision with root package name */
    public static final a2.a f13483k;

    static {
        a.g gVar = new a.g();
        f13482j = gVar;
        f13483k = new a2.a("ActivityRecognition.API", new c(), gVar);
    }

    public e(Context context) {
        super(context, f13483k, a.d.f53a, e.a.f65c);
    }

    @Override // s2.b
    public final z2.l<Void> d(final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.v.a().b(new com.google.android.gms.common.api.internal.r() { // from class: q2.z1
            @Override // com.google.android.gms.common.api.internal.r
            public final void c(Object obj, Object obj2) {
                PendingIntent pendingIntent2 = pendingIntent;
                a2.a aVar = e.f13483k;
                d dVar = new d((z2.m) obj2);
                b2.p.l(dVar, "ResultHolder not provided.");
                ((v1) ((m1) obj).I()).b0(pendingIntent2, new com.google.android.gms.common.api.internal.t(dVar));
            }
        }).e(2406).a());
    }

    @Override // s2.b
    public final z2.l<Void> f(final s2.e eVar, final PendingIntent pendingIntent) {
        eVar.g(q());
        return o(com.google.android.gms.common.api.internal.v.a().b(new com.google.android.gms.common.api.internal.r() { // from class: q2.b
            @Override // com.google.android.gms.common.api.internal.r
            public final void c(Object obj, Object obj2) {
                s2.e eVar2 = s2.e.this;
                PendingIntent pendingIntent2 = pendingIntent;
                a2.a aVar = e.f13483k;
                d dVar = new d((z2.m) obj2);
                b2.p.l(eVar2, "activityTransitionRequest must be specified.");
                b2.p.l(pendingIntent2, "PendingIntent must be specified.");
                b2.p.l(dVar, "ResultHolder not provided.");
                ((v1) ((m1) obj).I()).T(eVar2, pendingIntent2, new com.google.android.gms.common.api.internal.t(dVar));
            }
        }).e(2405).a());
    }
}
