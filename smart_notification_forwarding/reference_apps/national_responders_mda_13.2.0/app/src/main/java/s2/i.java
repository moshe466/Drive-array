package s2;

import q2.u0;

/* loaded from: classes.dex */
public interface i {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        private double f14038e;

        /* renamed from: f, reason: collision with root package name */
        private double f14039f;

        /* renamed from: g, reason: collision with root package name */
        private float f14040g;

        /* renamed from: a, reason: collision with root package name */
        private String f14034a = null;

        /* renamed from: b, reason: collision with root package name */
        private int f14035b = 0;

        /* renamed from: c, reason: collision with root package name */
        private long f14036c = Long.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        private short f14037d = -1;

        /* renamed from: h, reason: collision with root package name */
        private int f14041h = 0;

        /* renamed from: i, reason: collision with root package name */
        private int f14042i = -1;

        public i a() {
            if (this.f14034a == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            int i10 = this.f14035b;
            if (i10 == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((i10 & 4) != 0 && this.f14042i < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
            }
            if (this.f14036c == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.f14037d == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (this.f14041h >= 0) {
                return new u0(this.f14034a, this.f14035b, (short) 1, this.f14038e, this.f14039f, this.f14040g, this.f14036c, this.f14041h, this.f14042i);
            }
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        }

        public a b(double d10, double d11, float f10) {
            b2.p.b(d10 >= -90.0d && d10 <= 90.0d, "Invalid latitude: " + d10);
            b2.p.b(d11 >= -180.0d && d11 <= 180.0d, "Invalid longitude: " + d11);
            b2.p.b(f10 > 0.0f, "Invalid radius: " + f10);
            this.f14037d = (short) 1;
            this.f14038e = d10;
            this.f14039f = d11;
            this.f14040g = f10;
            return this;
        }

        public a c(long j10) {
            if (j10 < 0) {
                this.f14036c = -1L;
            } else {
                this.f14036c = g2.h.d().b() + j10;
            }
            return this;
        }

        public a d(String str) {
            this.f14034a = (String) b2.p.l(str, "Request ID can't be set to null");
            return this;
        }

        public a e(int i10) {
            this.f14035b = i10;
            return this;
        }
    }

    String f();
}
