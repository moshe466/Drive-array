package p3;

import android.content.Context;
import android.os.Bundle;
import b2.p;
import com.google.android.gms.internal.measurement.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p3.a;

/* loaded from: classes.dex */
public class b implements p3.a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile p3.a f13048c;

    /* renamed from: a, reason: collision with root package name */
    private final u2.a f13049a;

    /* renamed from: b, reason: collision with root package name */
    final Map<String, Object> f13050b;

    /* loaded from: classes.dex */
    class a implements a.InterfaceC0268a {
        a(b bVar, String str) {
        }
    }

    private b(u2.a aVar) {
        p.k(aVar);
        this.f13049a = aVar;
        this.f13050b = new ConcurrentHashMap();
    }

    public static p3.a d(o3.c cVar, Context context, o4.d dVar) {
        p.k(cVar);
        p.k(context);
        p.k(dVar);
        p.k(context.getApplicationContext());
        if (f13048c == null) {
            synchronized (b.class) {
                if (f13048c == null) {
                    Bundle bundle = new Bundle(1);
                    if (cVar.q()) {
                        dVar.b(o3.a.class, d.f13052f, c.f13051a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", cVar.p());
                    }
                    f13048c = new b(h.b(context, null, null, null, bundle).f());
                }
            }
        }
        return f13048c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void e(o4.a aVar) {
        boolean z10 = ((o3.a) aVar.a()).f12466a;
        synchronized (b.class) {
            ((b) f13048c).f13049a.d(z10);
        }
    }

    private final boolean f(String str) {
        return (str.isEmpty() || !this.f13050b.containsKey(str) || this.f13050b.get(str) == null) ? false : true;
    }

    @Override // p3.a
    public a.InterfaceC0268a a(String str, a.b bVar) {
        p.k(bVar);
        if (!q3.b.a(str) || f(str)) {
            return null;
        }
        u2.a aVar = this.f13049a;
        Object aVar2 = "fiam".equals(str) ? new q3.a(aVar, bVar) : ("crash".equals(str) || "clx".equals(str)) ? new q3.c(aVar, bVar) : null;
        if (aVar2 == null) {
            return null;
        }
        this.f13050b.put(str, aVar2);
        return new a(this, str);
    }

    @Override // p3.a
    public void b(String str, String str2, Object obj) {
        if (q3.b.a(str) && q3.b.c(str, str2)) {
            this.f13049a.c(str, str2, obj);
        }
    }

    @Override // p3.a
    public void c(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (q3.b.a(str) && q3.b.b(str2, bundle) && q3.b.d(str, str2, bundle)) {
            q3.b.e(str, str2, bundle);
            this.f13049a.a(str, str2, bundle);
        }
    }
}
