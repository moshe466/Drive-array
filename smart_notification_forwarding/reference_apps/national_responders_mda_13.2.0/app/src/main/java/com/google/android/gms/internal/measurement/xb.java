package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class xb implements ub {
    private static final t2<Long> A;
    private static final t2<Long> B;
    private static final t2<Long> C;
    private static final t2<Long> D;
    private static final t2<Long> E;
    private static final t2<String> F;
    private static final t2<Long> G;

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Long> f5670a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Long> f5671b;

    /* renamed from: c, reason: collision with root package name */
    private static final t2<String> f5672c;

    /* renamed from: d, reason: collision with root package name */
    private static final t2<String> f5673d;

    /* renamed from: e, reason: collision with root package name */
    private static final t2<Long> f5674e;

    /* renamed from: f, reason: collision with root package name */
    private static final t2<Long> f5675f;

    /* renamed from: g, reason: collision with root package name */
    private static final t2<Long> f5676g;

    /* renamed from: h, reason: collision with root package name */
    private static final t2<Long> f5677h;

    /* renamed from: i, reason: collision with root package name */
    private static final t2<Long> f5678i;

    /* renamed from: j, reason: collision with root package name */
    private static final t2<Long> f5679j;

    /* renamed from: k, reason: collision with root package name */
    private static final t2<Long> f5680k;

    /* renamed from: l, reason: collision with root package name */
    private static final t2<Long> f5681l;

    /* renamed from: m, reason: collision with root package name */
    private static final t2<Long> f5682m;

    /* renamed from: n, reason: collision with root package name */
    private static final t2<Long> f5683n;

    /* renamed from: o, reason: collision with root package name */
    private static final t2<Long> f5684o;

    /* renamed from: p, reason: collision with root package name */
    private static final t2<Long> f5685p;

    /* renamed from: q, reason: collision with root package name */
    private static final t2<Long> f5686q;

    /* renamed from: r, reason: collision with root package name */
    private static final t2<Long> f5687r;

    /* renamed from: s, reason: collision with root package name */
    private static final t2<Long> f5688s;

    /* renamed from: t, reason: collision with root package name */
    private static final t2<Long> f5689t;

    /* renamed from: u, reason: collision with root package name */
    private static final t2<Long> f5690u;

    /* renamed from: v, reason: collision with root package name */
    private static final t2<Long> f5691v;

    /* renamed from: w, reason: collision with root package name */
    private static final t2<Long> f5692w;

    /* renamed from: x, reason: collision with root package name */
    private static final t2<Long> f5693x;

    /* renamed from: y, reason: collision with root package name */
    private static final t2<Long> f5694y;

    /* renamed from: z, reason: collision with root package name */
    private static final t2<Long> f5695z;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5670a = y2Var.b("measurement.ad_id_cache_time", 10000L);
        f5671b = y2Var.b("measurement.config.cache_time", 86400000L);
        y2Var.c("measurement.log_tag", "FA");
        f5672c = y2Var.c("measurement.config.url_authority", "app-measurement.com");
        f5673d = y2Var.c("measurement.config.url_scheme", "https");
        f5674e = y2Var.b("measurement.upload.debug_upload_interval", 1000L);
        f5675f = y2Var.b("measurement.lifetimevalue.max_currency_tracked", 4L);
        f5676g = y2Var.b("measurement.store.max_stored_events_per_app", 100000L);
        f5677h = y2Var.b("measurement.experiment.max_ids", 50L);
        f5678i = y2Var.b("measurement.audience.filter_result_max_count", 200L);
        f5679j = y2Var.b("measurement.alarm_manager.minimum_interval", 60000L);
        f5680k = y2Var.b("measurement.upload.minimum_delay", 500L);
        f5681l = y2Var.b("measurement.monitoring.sample_period_millis", 86400000L);
        f5682m = y2Var.b("measurement.upload.realtime_upload_interval", 10000L);
        f5683n = y2Var.b("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        y2Var.b("measurement.config.cache_time.service", 3600000L);
        f5684o = y2Var.b("measurement.service_client.idle_disconnect_millis", 5000L);
        y2Var.c("measurement.log_tag.service", "FA-SVC");
        f5685p = y2Var.b("measurement.upload.stale_data_deletion_interval", 86400000L);
        f5686q = y2Var.b("measurement.upload.backoff_period", 43200000L);
        f5687r = y2Var.b("measurement.upload.initial_upload_delay_time", 15000L);
        f5688s = y2Var.b("measurement.upload.interval", 3600000L);
        f5689t = y2Var.b("measurement.upload.max_bundle_size", 65536L);
        f5690u = y2Var.b("measurement.upload.max_bundles", 100L);
        f5691v = y2Var.b("measurement.upload.max_conversions_per_day", 500L);
        f5692w = y2Var.b("measurement.upload.max_error_events_per_day", 1000L);
        f5693x = y2Var.b("measurement.upload.max_events_per_bundle", 1000L);
        f5694y = y2Var.b("measurement.upload.max_events_per_day", 100000L);
        f5695z = y2Var.b("measurement.upload.max_public_events_per_day", 50000L);
        A = y2Var.b("measurement.upload.max_queue_time", 2419200000L);
        B = y2Var.b("measurement.upload.max_realtime_events_per_day", 10L);
        C = y2Var.b("measurement.upload.max_batch_size", 65536L);
        D = y2Var.b("measurement.upload.retry_count", 6L);
        E = y2Var.b("measurement.upload.retry_time", 1800000L);
        F = y2Var.c("measurement.upload.url", "https://app-measurement.com/a");
        G = y2Var.b("measurement.upload.window_interval", 3600000L);
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long A() {
        return E.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long B() {
        return f5688s.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long C() {
        return f5684o.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long D() {
        return f5680k.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long E() {
        return f5676g.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long F() {
        return B.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final String G() {
        return F.o();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long a() {
        return f5671b.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final String b() {
        return f5672c.o();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final String c() {
        return f5673d.o();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long d() {
        return f5674e.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long e() {
        return f5685p.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long f() {
        return f5681l.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long g() {
        return f5694y.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long h() {
        return f5686q.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long i() {
        return f5682m.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long j() {
        return f5693x.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long k() {
        return f5678i.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long m() {
        return f5675f.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long n() {
        return f5689t.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long o() {
        return C.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long p() {
        return f5677h.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long q() {
        return G.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long r() {
        return f5690u.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long s() {
        return f5695z.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long t() {
        return f5691v.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long u() {
        return D.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long v() {
        return f5687r.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long w() {
        return f5683n.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long x() {
        return f5679j.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long y() {
        return A.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long z() {
        return f5692w.o().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final long zza() {
        return f5670a.o().longValue();
    }
}
