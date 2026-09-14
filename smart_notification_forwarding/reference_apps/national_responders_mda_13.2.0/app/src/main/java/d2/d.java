package d2;

import a2.a;
import a2.e;
import android.content.Context;
import b2.t;
import b2.v;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.v;
import m2.f;
import z2.l;
import z2.m;

/* loaded from: classes.dex */
public final class d extends a2.e implements com.google.android.gms.common.internal.a {

    /* renamed from: j, reason: collision with root package name */
    private static final a.g f8649j;

    /* renamed from: k, reason: collision with root package name */
    private static final a.AbstractC0006a f8650k;

    /* renamed from: l, reason: collision with root package name */
    private static final a2.a f8651l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f8652m = 0;

    static {
        a.g gVar = new a.g();
        f8649j = gVar;
        c cVar = new c();
        f8650k = cVar;
        f8651l = new a2.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, v vVar) {
        super(context, f8651l, vVar, e.a.f65c);
    }

    @Override // com.google.android.gms.common.internal.a
    public final l<Void> e(final t tVar) {
        v.a a10 = com.google.android.gms.common.api.internal.v.a();
        a10.d(f.f12012a);
        a10.c(false);
        a10.b(new r() { // from class: d2.b
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.r
            public final void c(Object obj, Object obj2) {
                t tVar2 = t.this;
                int i10 = d.f8652m;
                ((a) ((e) obj).I()).z(tVar2);
                ((m) obj2).c(null);
            }
        });
        return j(a10.a());
    }
}
