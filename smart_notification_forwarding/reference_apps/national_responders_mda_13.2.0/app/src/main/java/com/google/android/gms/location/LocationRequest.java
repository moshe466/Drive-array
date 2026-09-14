package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import b2.o;
import b2.p;
import com.google.android.gms.common.internal.ReflectedParcelable;
import q2.m0;
import q2.w0;
import s2.b0;
import s2.r;
import s2.s;

/* loaded from: classes.dex */
public final class LocationRequest extends c2.a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new b();

    /* renamed from: f, reason: collision with root package name */
    private int f5749f;

    /* renamed from: g, reason: collision with root package name */
    private long f5750g;

    /* renamed from: h, reason: collision with root package name */
    private long f5751h;

    /* renamed from: i, reason: collision with root package name */
    private long f5752i;

    /* renamed from: j, reason: collision with root package name */
    private long f5753j;

    /* renamed from: k, reason: collision with root package name */
    private int f5754k;

    /* renamed from: l, reason: collision with root package name */
    private float f5755l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5756m;

    /* renamed from: n, reason: collision with root package name */
    private long f5757n;

    /* renamed from: o, reason: collision with root package name */
    private final int f5758o;

    /* renamed from: p, reason: collision with root package name */
    private final int f5759p;

    /* renamed from: q, reason: collision with root package name */
    private final String f5760q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f5761r;

    /* renamed from: s, reason: collision with root package name */
    private final WorkSource f5762s;

    /* renamed from: t, reason: collision with root package name */
    private final m0 f5763t;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f5764a;

        /* renamed from: b, reason: collision with root package name */
        private long f5765b;

        /* renamed from: c, reason: collision with root package name */
        private long f5766c;

        /* renamed from: d, reason: collision with root package name */
        private long f5767d;

        /* renamed from: e, reason: collision with root package name */
        private long f5768e;

        /* renamed from: f, reason: collision with root package name */
        private int f5769f;

        /* renamed from: g, reason: collision with root package name */
        private float f5770g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f5771h;

        /* renamed from: i, reason: collision with root package name */
        private long f5772i;

        /* renamed from: j, reason: collision with root package name */
        private int f5773j;

        /* renamed from: k, reason: collision with root package name */
        private int f5774k;

        /* renamed from: l, reason: collision with root package name */
        private String f5775l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f5776m;

        /* renamed from: n, reason: collision with root package name */
        private WorkSource f5777n;

        /* renamed from: o, reason: collision with root package name */
        private m0 f5778o;

        public a(int i10, long j10) {
            p.b(j10 >= 0, "intervalMillis must be greater than or equal to 0");
            r.a(i10);
            this.f5764a = i10;
            this.f5765b = j10;
            this.f5766c = -1L;
            this.f5767d = 0L;
            this.f5768e = Long.MAX_VALUE;
            this.f5769f = Integer.MAX_VALUE;
            this.f5770g = 0.0f;
            this.f5771h = true;
            this.f5772i = -1L;
            this.f5773j = 0;
            this.f5774k = 0;
            this.f5775l = null;
            this.f5776m = false;
            this.f5777n = null;
            this.f5778o = null;
        }

        public a(long j10) {
            p.b(j10 >= 0, "intervalMillis must be greater than or equal to 0");
            this.f5765b = j10;
            this.f5764a = 102;
            this.f5766c = -1L;
            this.f5767d = 0L;
            this.f5768e = Long.MAX_VALUE;
            this.f5769f = Integer.MAX_VALUE;
            this.f5770g = 0.0f;
            this.f5771h = true;
            this.f5772i = -1L;
            this.f5773j = 0;
            this.f5774k = 0;
            this.f5775l = null;
            this.f5776m = false;
            this.f5777n = null;
            this.f5778o = null;
        }

        public a(LocationRequest locationRequest) {
            this.f5764a = locationRequest.x();
            this.f5765b = locationRequest.l();
            this.f5766c = locationRequest.w();
            this.f5767d = locationRequest.t();
            this.f5768e = locationRequest.g();
            this.f5769f = locationRequest.u();
            this.f5770g = locationRequest.v();
            this.f5771h = locationRequest.A();
            this.f5772i = locationRequest.s();
            this.f5773j = locationRequest.j();
            this.f5774k = locationRequest.B();
            this.f5775l = locationRequest.E();
            this.f5776m = locationRequest.F();
            this.f5777n = locationRequest.C();
            this.f5778o = locationRequest.D();
        }

        public LocationRequest a() {
            int i10 = this.f5764a;
            long j10 = this.f5765b;
            long j11 = this.f5766c;
            if (j11 == -1) {
                j11 = j10;
            } else if (i10 != 105) {
                j11 = Math.min(j11, j10);
            }
            long max = Math.max(this.f5767d, this.f5765b);
            long j12 = this.f5768e;
            int i11 = this.f5769f;
            float f10 = this.f5770g;
            boolean z10 = this.f5771h;
            long j13 = this.f5772i;
            return new LocationRequest(i10, j10, j11, max, Long.MAX_VALUE, j12, i11, f10, z10, j13 == -1 ? this.f5765b : j13, this.f5773j, this.f5774k, this.f5775l, this.f5776m, new WorkSource(this.f5777n), this.f5778o);
        }

        public a b(long j10) {
            p.b(j10 > 0, "durationMillis must be greater than 0");
            this.f5768e = j10;
            return this;
        }

        public a c(int i10) {
            b0.a(i10);
            this.f5773j = i10;
            return this;
        }

        public a d(long j10) {
            boolean z10 = true;
            if (j10 != -1 && j10 < 0) {
                z10 = false;
            }
            p.b(z10, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.f5772i = j10;
            return this;
        }

        public a e(long j10) {
            boolean z10 = true;
            if (j10 != -1 && j10 < 0) {
                z10 = false;
            }
            p.b(z10, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.f5766c = j10;
            return this;
        }

        public a f(int i10) {
            r.a(i10);
            this.f5764a = i10;
            return this;
        }

        public a g(boolean z10) {
            this.f5771h = z10;
            return this;
        }

        public final a h(boolean z10) {
            this.f5776m = z10;
            return this;
        }

        @Deprecated
        public final a i(String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.f5775l = str;
            }
            return this;
        }

        public final a j(int i10) {
            boolean z10;
            int i11 = 2;
            if (i10 == 0 || i10 == 1) {
                i11 = i10;
            } else {
                if (i10 != 2) {
                    i11 = i10;
                    z10 = false;
                    p.c(z10, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i10));
                    this.f5774k = i11;
                    return this;
                }
                i10 = 2;
            }
            z10 = true;
            p.c(z10, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i10));
            this.f5774k = i11;
            return this;
        }

        public final a k(WorkSource workSource) {
            this.f5777n = workSource;
            return this;
        }
    }

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequest(int i10, long j10, long j11, long j12, long j13, long j14, int i11, float f10, boolean z10, long j15, int i12, int i13, String str, boolean z11, WorkSource workSource, m0 m0Var) {
        this.f5749f = i10;
        long j16 = j10;
        this.f5750g = j16;
        this.f5751h = j11;
        this.f5752i = j12;
        this.f5753j = j13 == Long.MAX_VALUE ? j14 : Math.min(Math.max(1L, j13 - SystemClock.elapsedRealtime()), j14);
        this.f5754k = i11;
        this.f5755l = f10;
        this.f5756m = z10;
        this.f5757n = j15 != -1 ? j15 : j16;
        this.f5758o = i12;
        this.f5759p = i13;
        this.f5760q = str;
        this.f5761r = z11;
        this.f5762s = workSource;
        this.f5763t = m0Var;
    }

    private static String G(long j10) {
        return j10 == Long.MAX_VALUE ? "∞" : w0.a(j10);
    }

    public boolean A() {
        return this.f5756m;
    }

    public final int B() {
        return this.f5759p;
    }

    public final WorkSource C() {
        return this.f5762s;
    }

    public final m0 D() {
        return this.f5763t;
    }

    @Deprecated
    public final String E() {
        return this.f5760q;
    }

    public final boolean F() {
        return this.f5761r;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f5749f == locationRequest.f5749f && ((z() || this.f5750g == locationRequest.f5750g) && this.f5751h == locationRequest.f5751h && y() == locationRequest.y() && ((!y() || this.f5752i == locationRequest.f5752i) && this.f5753j == locationRequest.f5753j && this.f5754k == locationRequest.f5754k && this.f5755l == locationRequest.f5755l && this.f5756m == locationRequest.f5756m && this.f5758o == locationRequest.f5758o && this.f5759p == locationRequest.f5759p && this.f5761r == locationRequest.f5761r && this.f5762s.equals(locationRequest.f5762s) && o.a(this.f5760q, locationRequest.f5760q) && o.a(this.f5763t, locationRequest.f5763t)))) {
                return true;
            }
        }
        return false;
    }

    public long g() {
        return this.f5753j;
    }

    public int hashCode() {
        return o.b(Integer.valueOf(this.f5749f), Long.valueOf(this.f5750g), Long.valueOf(this.f5751h), this.f5762s);
    }

    public int j() {
        return this.f5758o;
    }

    public long l() {
        return this.f5750g;
    }

    public long s() {
        return this.f5757n;
    }

    public long t() {
        return this.f5752i;
    }

    public String toString() {
        long j10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        if (!z()) {
            sb2.append("@");
            if (y()) {
                w0.b(this.f5750g, sb2);
                sb2.append("/");
                j10 = this.f5752i;
            } else {
                j10 = this.f5750g;
            }
            w0.b(j10, sb2);
            sb2.append(" ");
        }
        sb2.append(r.b(this.f5749f));
        if (z() || this.f5751h != this.f5750g) {
            sb2.append(", minUpdateInterval=");
            sb2.append(G(this.f5751h));
        }
        if (this.f5755l > 0.0d) {
            sb2.append(", minUpdateDistance=");
            sb2.append(this.f5755l);
        }
        boolean z10 = z();
        long j11 = this.f5757n;
        if (!z10 ? j11 != this.f5750g : j11 != Long.MAX_VALUE) {
            sb2.append(", maxUpdateAge=");
            sb2.append(G(this.f5757n));
        }
        if (this.f5753j != Long.MAX_VALUE) {
            sb2.append(", duration=");
            w0.b(this.f5753j, sb2);
        }
        if (this.f5754k != Integer.MAX_VALUE) {
            sb2.append(", maxUpdates=");
            sb2.append(this.f5754k);
        }
        if (this.f5759p != 0) {
            sb2.append(", ");
            sb2.append(s.a(this.f5759p));
        }
        if (this.f5758o != 0) {
            sb2.append(", ");
            sb2.append(b0.b(this.f5758o));
        }
        if (this.f5756m) {
            sb2.append(", waitForAccurateLocation");
        }
        if (this.f5761r) {
            sb2.append(", bypass");
        }
        if (this.f5760q != null) {
            sb2.append(", moduleId=");
            sb2.append(this.f5760q);
        }
        if (!g2.p.f(this.f5762s)) {
            sb2.append(", ");
            sb2.append(this.f5762s);
        }
        if (this.f5763t != null) {
            sb2.append(", impersonation=");
            sb2.append(this.f5763t);
        }
        sb2.append(']');
        return sb2.toString();
    }

    public int u() {
        return this.f5754k;
    }

    public float v() {
        return this.f5755l;
    }

    public long w() {
        return this.f5751h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, x());
        c2.c.m(parcel, 2, l());
        c2.c.m(parcel, 3, w());
        c2.c.k(parcel, 6, u());
        c2.c.h(parcel, 7, v());
        c2.c.m(parcel, 8, t());
        c2.c.c(parcel, 9, A());
        c2.c.m(parcel, 10, g());
        c2.c.m(parcel, 11, s());
        c2.c.k(parcel, 12, j());
        c2.c.k(parcel, 13, this.f5759p);
        c2.c.q(parcel, 14, this.f5760q, false);
        c2.c.c(parcel, 15, this.f5761r);
        c2.c.o(parcel, 16, this.f5762s, i10, false);
        c2.c.o(parcel, 17, this.f5763t, i10, false);
        c2.c.b(parcel, a10);
    }

    public int x() {
        return this.f5749f;
    }

    public boolean y() {
        long j10 = this.f5752i;
        return j10 > 0 && (j10 >> 1) >= this.f5750g;
    }

    public boolean z() {
        return this.f5749f == 105;
    }
}
