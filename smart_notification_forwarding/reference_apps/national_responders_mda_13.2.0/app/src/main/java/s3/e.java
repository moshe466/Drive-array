package s3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.firebase.crashlytics.internal.common.h;
import com.google.firebase.crashlytics.internal.common.m;
import com.google.firebase.crashlytics.internal.common.s;
import com.google.firebase.crashlytics.internal.common.u;
import com.google.firebase.crashlytics.internal.common.x;
import java.util.concurrent.Executor;
import z2.k;
import z2.l;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final y3.c f14074a = new y3.c();

    /* renamed from: b, reason: collision with root package name */
    private final o3.c f14075b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f14076c;

    /* renamed from: d, reason: collision with root package name */
    private PackageManager f14077d;

    /* renamed from: e, reason: collision with root package name */
    private String f14078e;

    /* renamed from: f, reason: collision with root package name */
    private PackageInfo f14079f;

    /* renamed from: g, reason: collision with root package name */
    private String f14080g;

    /* renamed from: h, reason: collision with root package name */
    private String f14081h;

    /* renamed from: i, reason: collision with root package name */
    private String f14082i;

    /* renamed from: j, reason: collision with root package name */
    private String f14083j;

    /* renamed from: k, reason: collision with root package name */
    private String f14084k;

    /* renamed from: l, reason: collision with root package name */
    private x f14085l;

    /* renamed from: m, reason: collision with root package name */
    private s f14086m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements k<g4.b, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14087a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f4.d f14088b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Executor f14089c;

        a(String str, f4.d dVar, Executor executor) {
            this.f14087a = str;
            this.f14088b = dVar;
            this.f14089c = executor;
        }

        @Override // z2.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l<Void> a(g4.b bVar) {
            try {
                e.this.i(bVar, this.f14087a, this.f14088b, this.f14089c, true);
                return null;
            } catch (Exception e10) {
                s3.b.f().e("Error performing auto configuration.", e10);
                throw e10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements k<Void, g4.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f4.d f14091a;

        b(e eVar, f4.d dVar) {
            this.f14091a = dVar;
        }

        @Override // z2.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l<g4.b> a(Void r12) {
            return this.f14091a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements z2.c<Void, Object> {
        c(e eVar) {
        }

        @Override // z2.c
        public Object a(l<Void> lVar) {
            if (lVar.p()) {
                return null;
            }
            s3.b.f().e("Error fetching settings.", lVar.k());
            return null;
        }
    }

    public e(o3.c cVar, Context context, x xVar, s sVar) {
        this.f14075b = cVar;
        this.f14076c = context;
        this.f14085l = xVar;
        this.f14086m = sVar;
    }

    private g4.a b(String str, String str2) {
        return new g4.a(str, str2, e().d(), this.f14081h, this.f14080g, h.h(h.p(d()), str2, this.f14081h, this.f14080g), this.f14083j, u.determineFrom(this.f14082i).getId(), this.f14084k, "0");
    }

    private x e() {
        return this.f14085l;
    }

    private static String g() {
        return m.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g4.b bVar, String str, f4.d dVar, Executor executor, boolean z10) {
        if ("new".equals(bVar.f9776a)) {
            if (!j(bVar, str, z10)) {
                s3.b.f().e("Failed to create app with Crashlytics service.", null);
                return;
            }
        } else if (!"configured".equals(bVar.f9776a)) {
            if (bVar.f9781f) {
                s3.b.f().b("Server says an update is required - forcing a full App update.");
                k(bVar, str, z10);
                return;
            }
            return;
        }
        dVar.o(f4.c.SKIP_CACHE_LOOKUP, executor);
    }

    private boolean j(g4.b bVar, String str, boolean z10) {
        return new h4.b(f(), bVar.f9777b, this.f14074a, g()).i(b(bVar.f9780e, str), z10);
    }

    private boolean k(g4.b bVar, String str, boolean z10) {
        return new h4.e(f(), bVar.f9777b, this.f14074a, g()).i(b(bVar.f9780e, str), z10);
    }

    public void c(Executor executor, f4.d dVar) {
        this.f14086m.h().q(executor, new b(this, dVar)).q(executor, new a(this.f14075b.j().c(), dVar, executor));
    }

    public Context d() {
        return this.f14076c;
    }

    String f() {
        return h.u(this.f14076c, "com.crashlytics.ApiEndpoint");
    }

    public boolean h() {
        try {
            this.f14082i = this.f14085l.e();
            this.f14077d = this.f14076c.getPackageManager();
            String packageName = this.f14076c.getPackageName();
            this.f14078e = packageName;
            PackageInfo packageInfo = this.f14077d.getPackageInfo(packageName, 0);
            this.f14079f = packageInfo;
            this.f14080g = Integer.toString(packageInfo.versionCode);
            String str = this.f14079f.versionName;
            if (str == null) {
                str = "0.0";
            }
            this.f14081h = str;
            this.f14083j = this.f14077d.getApplicationLabel(this.f14076c.getApplicationInfo()).toString();
            this.f14084k = Integer.toString(this.f14076c.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            s3.b.f().e("Failed init", e10);
            return false;
        }
    }

    public f4.d l(Context context, o3.c cVar, Executor executor) {
        f4.d l10 = f4.d.l(context, cVar.j().c(), this.f14085l, this.f14074a, this.f14080g, this.f14081h, f(), this.f14086m);
        l10.p(executor).h(executor, new c(this));
        return l10;
    }
}
