package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    final String f6207a;

    /* renamed from: b, reason: collision with root package name */
    final String f6208b;

    /* renamed from: c, reason: collision with root package name */
    final long f6209c;

    /* renamed from: d, reason: collision with root package name */
    final long f6210d;

    /* renamed from: e, reason: collision with root package name */
    final long f6211e;

    /* renamed from: f, reason: collision with root package name */
    final long f6212f;

    /* renamed from: g, reason: collision with root package name */
    final long f6213g;

    /* renamed from: h, reason: collision with root package name */
    final Long f6214h;

    /* renamed from: i, reason: collision with root package name */
    final Long f6215i;

    /* renamed from: j, reason: collision with root package name */
    final Long f6216j;

    /* renamed from: k, reason: collision with root package name */
    final Boolean f6217k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        b2.p.g(str);
        b2.p.g(str2);
        b2.p.a(j10 >= 0);
        b2.p.a(j11 >= 0);
        b2.p.a(j12 >= 0);
        b2.p.a(j14 >= 0);
        this.f6207a = str;
        this.f6208b = str2;
        this.f6209c = j10;
        this.f6210d = j11;
        this.f6211e = j12;
        this.f6212f = j13;
        this.f6213g = j14;
        this.f6214h = l10;
        this.f6215i = l11;
        this.f6216j = l12;
        this.f6217k = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str, String str2, long j10, long j11, long j12, long j13, Long l10, Long l11, Long l12, Boolean bool) {
        this(str, str2, 0L, 0L, 0L, j12, 0L, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m a(long j10) {
        return new m(this.f6207a, this.f6208b, this.f6209c, this.f6210d, this.f6211e, j10, this.f6213g, this.f6214h, this.f6215i, this.f6216j, this.f6217k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m b(long j10, long j11) {
        return new m(this.f6207a, this.f6208b, this.f6209c, this.f6210d, this.f6211e, this.f6212f, j10, Long.valueOf(j11), this.f6215i, this.f6216j, this.f6217k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m c(Long l10, Long l11, Boolean bool) {
        return new m(this.f6207a, this.f6208b, this.f6209c, this.f6210d, this.f6211e, this.f6212f, this.f6213g, this.f6214h, l10, l11, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
