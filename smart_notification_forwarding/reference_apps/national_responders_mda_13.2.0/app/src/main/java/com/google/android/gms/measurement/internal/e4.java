package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.bc;
import v1.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e4 extends q5 {
    static final Pair<String, Long> D = new Pair<>("", 0L);
    public final k4 A;
    public final i4 B;
    public final j4 C;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f5956c;

    /* renamed from: d, reason: collision with root package name */
    public l4 f5957d;

    /* renamed from: e, reason: collision with root package name */
    public final i4 f5958e;

    /* renamed from: f, reason: collision with root package name */
    public final i4 f5959f;

    /* renamed from: g, reason: collision with root package name */
    public final i4 f5960g;

    /* renamed from: h, reason: collision with root package name */
    public final i4 f5961h;

    /* renamed from: i, reason: collision with root package name */
    public final i4 f5962i;

    /* renamed from: j, reason: collision with root package name */
    public final i4 f5963j;

    /* renamed from: k, reason: collision with root package name */
    public final i4 f5964k;

    /* renamed from: l, reason: collision with root package name */
    public final k4 f5965l;

    /* renamed from: m, reason: collision with root package name */
    private String f5966m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5967n;

    /* renamed from: o, reason: collision with root package name */
    private long f5968o;

    /* renamed from: p, reason: collision with root package name */
    public final i4 f5969p;

    /* renamed from: q, reason: collision with root package name */
    public final i4 f5970q;

    /* renamed from: r, reason: collision with root package name */
    public final g4 f5971r;

    /* renamed from: s, reason: collision with root package name */
    public final k4 f5972s;

    /* renamed from: t, reason: collision with root package name */
    public final g4 f5973t;

    /* renamed from: u, reason: collision with root package name */
    public final i4 f5974u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5975v;

    /* renamed from: w, reason: collision with root package name */
    public g4 f5976w;

    /* renamed from: x, reason: collision with root package name */
    public g4 f5977x;

    /* renamed from: y, reason: collision with root package name */
    public i4 f5978y;

    /* renamed from: z, reason: collision with root package name */
    public final k4 f5979z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e4(t4 t4Var) {
        super(t4Var);
        this.f5958e = new i4(this, "last_upload", 0L);
        this.f5959f = new i4(this, "last_upload_attempt", 0L);
        this.f5960g = new i4(this, "backoff", 0L);
        this.f5961h = new i4(this, "last_delete_stale", 0L);
        this.f5969p = new i4(this, "time_before_start", 10000L);
        this.f5970q = new i4(this, "session_timeout", 1800000L);
        this.f5971r = new g4(this, "start_new_session", true);
        this.f5974u = new i4(this, "last_pause_time", 0L);
        this.f5972s = new k4(this, "non_personalized_ads", null);
        this.f5973t = new g4(this, "allow_remote_dynamite", false);
        this.f5962i = new i4(this, "midnight_offset", 0L);
        this.f5963j = new i4(this, "first_open_time", 0L);
        this.f5964k = new i4(this, "app_install_time", 0L);
        this.f5965l = new k4(this, "app_instance_id", null);
        this.f5976w = new g4(this, "app_backgrounded", false);
        this.f5977x = new g4(this, "deep_link_retrieval_complete", false);
        this.f5978y = new i4(this, "deep_link_retrieval_attempts", 0L);
        this.f5979z = new k4(this, "firebase_feature_rollouts", null);
        this.A = new k4(this, "deferred_attribution_cache", null);
        this.B = new i4(this, "deferred_attribution_cache_timestamp", 0L);
        this.C = new j4(this, "default_event_parameters", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void A(Boolean bool) {
        if (bc.a() && m().t(s.H0)) {
            c();
            SharedPreferences.Editor edit = E().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B(String str) {
        c();
        SharedPreferences.Editor edit = E().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(boolean z10) {
        c();
        h().N().b("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor edit = E().edit();
        edit.putBoolean("deferred_analytics_collection", z10);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(String str) {
        c();
        SharedPreferences.Editor edit = E().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences E() {
        c();
        q();
        return this.f5956c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String F() {
        c();
        return E().getString("gmp_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String G() {
        c();
        return E().getString("admob_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean H() {
        c();
        if (E().contains("use_service")) {
            return Boolean.valueOf(E().getBoolean("use_service", false));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void I() {
        c();
        Boolean J = J();
        SharedPreferences.Editor edit = E().edit();
        edit.clear();
        edit.apply();
        if (J != null) {
            v(J);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean J() {
        c();
        if (E().contains("measurement_enabled")) {
            return Boolean.valueOf(E().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean K() {
        if (!bc.a() || !m().t(s.H0)) {
            return null;
        }
        c();
        if (E().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(E().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    public final int L() {
        c();
        return E().getInt("consent_source", 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final v2.a M() {
        c();
        return v2.a.f(E().getString("consent_settings", "G1"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String N() {
        c();
        String string = E().getString("previous_os_version", null);
        d().q();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = E().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean O() {
        return this.f5956c.contains("deferred_analytics_collection");
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final void o() {
        SharedPreferences sharedPreferences = i().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f5956c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f5975v = z10;
        if (!z10) {
            SharedPreferences.Editor edit = this.f5956c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f5957d = new l4(this, "health_monitor", Math.max(0L, s.f6396c.a(null).longValue()));
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair<String, Boolean> u(String str) {
        c();
        long b10 = f().b();
        if (this.f5966m != null && b10 < this.f5968o) {
            return new Pair<>(this.f5966m, Boolean.valueOf(this.f5967n));
        }
        this.f5968o = b10 + m().B(str);
        v1.a.d(true);
        try {
            a.C0300a b11 = v1.a.b(i());
            if (b11 != null) {
                this.f5966m = b11.a();
                this.f5967n = b11.b();
            }
            if (this.f5966m == null) {
                this.f5966m = "";
            }
        } catch (Exception e10) {
            h().M().b("Unable to get advertising id", e10);
            this.f5966m = "";
        }
        v1.a.d(false);
        return new Pair<>(this.f5966m, Boolean.valueOf(this.f5967n));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void v(Boolean bool) {
        c();
        SharedPreferences.Editor edit = E().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(boolean z10) {
        c();
        SharedPreferences.Editor edit = E().edit();
        edit.putBoolean("use_service", z10);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean x(int i10) {
        return v2.a.g(i10, E().getInt("consent_source", 100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean y(long j10) {
        return j10 - this.f5970q.a() > this.f5974u.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean z(v2.a aVar, int i10) {
        if (!bc.a() || !m().t(s.H0)) {
            return false;
        }
        c();
        if (!x(i10)) {
            return false;
        }
        SharedPreferences.Editor edit = E().edit();
        edit.putString("consent_settings", aVar.d());
        edit.putInt("consent_source", i10);
        edit.apply();
        return true;
    }
}
