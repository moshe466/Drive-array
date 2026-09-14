package f4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.crashlytics.internal.common.h0;
import com.google.firebase.crashlytics.internal.common.r;
import com.google.firebase.crashlytics.internal.common.s;
import com.google.firebase.crashlytics.internal.common.u;
import com.google.firebase.crashlytics.internal.common.x;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import z2.k;
import z2.l;
import z2.m;
import z2.o;

/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9359a;

    /* renamed from: b, reason: collision with root package name */
    private final g4.g f9360b;

    /* renamed from: c, reason: collision with root package name */
    private final f f9361c;

    /* renamed from: d, reason: collision with root package name */
    private final r f9362d;

    /* renamed from: e, reason: collision with root package name */
    private final f4.a f9363e;

    /* renamed from: f, reason: collision with root package name */
    private final h4.d f9364f;

    /* renamed from: g, reason: collision with root package name */
    private final s f9365g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicReference<g4.e> f9366h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicReference<m<g4.b>> f9367i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements k<Void, Void> {
        a() {
        }

        @Override // z2.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l<Void> a(Void r52) {
            JSONObject a10 = d.this.f9364f.a(d.this.f9360b, true);
            if (a10 != null) {
                g4.f b10 = d.this.f9361c.b(a10);
                d.this.f9363e.c(b10.d(), a10);
                d.this.q(a10, "Loaded settings: ");
                d dVar = d.this;
                dVar.r(dVar.f9360b.f9796f);
                d.this.f9366h.set(b10);
                ((m) d.this.f9367i.get()).e(b10.c());
                m mVar = new m();
                mVar.e(b10.c());
                d.this.f9367i.set(mVar);
            }
            return o.e(null);
        }
    }

    d(Context context, g4.g gVar, r rVar, f fVar, f4.a aVar, h4.d dVar, s sVar) {
        AtomicReference<g4.e> atomicReference = new AtomicReference<>();
        this.f9366h = atomicReference;
        this.f9367i = new AtomicReference<>(new m());
        this.f9359a = context;
        this.f9360b = gVar;
        this.f9362d = rVar;
        this.f9361c = fVar;
        this.f9363e = aVar;
        this.f9364f = dVar;
        this.f9365g = sVar;
        atomicReference.set(b.e(rVar));
    }

    public static d l(Context context, String str, x xVar, y3.c cVar, String str2, String str3, String str4, s sVar) {
        String e10 = xVar.e();
        h0 h0Var = new h0();
        return new d(context, new g4.g(str, xVar.f(), xVar.g(), xVar.h(), xVar, com.google.firebase.crashlytics.internal.common.h.h(com.google.firebase.crashlytics.internal.common.h.p(context), str, str3, str2), str3, str2, u.determineFrom(e10).getId()), h0Var, new f(h0Var), new f4.a(context), new h4.c(str4, String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), cVar), sVar);
    }

    private g4.f m(c cVar) {
        s3.b f10;
        String str;
        g4.f fVar = null;
        try {
            if (c.SKIP_CACHE_LOOKUP.equals(cVar)) {
                return null;
            }
            JSONObject b10 = this.f9363e.b();
            if (b10 != null) {
                g4.f b11 = this.f9361c.b(b10);
                if (b11 == null) {
                    s3.b.f().e("Failed to parse cached settings data.", null);
                    return null;
                }
                q(b10, "Loaded cached settings: ");
                long a10 = this.f9362d.a();
                if (!c.IGNORE_CACHE_EXPIRATION.equals(cVar) && b11.e(a10)) {
                    f10 = s3.b.f();
                    str = "Cached settings have expired.";
                }
                try {
                    s3.b.f().b("Returning cached settings.");
                    return b11;
                } catch (Exception e10) {
                    e = e10;
                    fVar = b11;
                    s3.b.f().e("Failed to get cached settings", e);
                    return fVar;
                }
            }
            f10 = s3.b.f();
            str = "No cached settings data found.";
            f10.b(str);
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    private String n() {
        return com.google.firebase.crashlytics.internal.common.h.t(this.f9359a).getString("existing_instance_identifier", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) {
        s3.b.f().b(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean r(String str) {
        SharedPreferences.Editor edit = com.google.firebase.crashlytics.internal.common.h.t(this.f9359a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    @Override // f4.e
    public l<g4.b> a() {
        return this.f9367i.get().a();
    }

    @Override // f4.e
    public g4.e b() {
        return this.f9366h.get();
    }

    boolean k() {
        return !n().equals(this.f9360b.f9796f);
    }

    public l<Void> o(c cVar, Executor executor) {
        g4.f m10;
        if (!k() && (m10 = m(cVar)) != null) {
            this.f9366h.set(m10);
            this.f9367i.get().e(m10.c());
            return o.e(null);
        }
        g4.f m11 = m(c.IGNORE_CACHE_EXPIRATION);
        if (m11 != null) {
            this.f9366h.set(m11);
            this.f9367i.get().e(m11.c());
        }
        return this.f9365g.h().q(executor, new a());
    }

    public l<Void> p(Executor executor) {
        return o(c.USE_CACHE, executor);
    }
}
