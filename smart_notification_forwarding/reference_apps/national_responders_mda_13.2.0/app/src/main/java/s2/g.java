package s2;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import q2.m0;
import q2.w0;

/* loaded from: classes.dex */
public final class g extends c2.a {
    public static final Parcelable.Creator<g> CREATOR = new y();

    /* renamed from: f, reason: collision with root package name */
    private final long f14016f;

    /* renamed from: g, reason: collision with root package name */
    private final int f14017g;

    /* renamed from: h, reason: collision with root package name */
    private final int f14018h;

    /* renamed from: i, reason: collision with root package name */
    private final long f14019i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f14020j;

    /* renamed from: k, reason: collision with root package name */
    private final int f14021k;

    /* renamed from: l, reason: collision with root package name */
    private final String f14022l;

    /* renamed from: m, reason: collision with root package name */
    private final WorkSource f14023m;

    /* renamed from: n, reason: collision with root package name */
    private final m0 f14024n;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f14025a = 60000;

        /* renamed from: b, reason: collision with root package name */
        private int f14026b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f14027c = 102;

        /* renamed from: d, reason: collision with root package name */
        private long f14028d = Long.MAX_VALUE;

        /* renamed from: e, reason: collision with root package name */
        private boolean f14029e = false;

        /* renamed from: f, reason: collision with root package name */
        private int f14030f = 0;

        /* renamed from: g, reason: collision with root package name */
        private String f14031g = null;

        /* renamed from: h, reason: collision with root package name */
        private WorkSource f14032h = null;

        /* renamed from: i, reason: collision with root package name */
        private m0 f14033i = null;

        public g a() {
            return new g(this.f14025a, this.f14026b, this.f14027c, this.f14028d, this.f14029e, this.f14030f, this.f14031g, new WorkSource(this.f14032h), this.f14033i);
        }

        public a b(int i10) {
            r.a(i10);
            this.f14027c = i10;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(long j10, int i10, int i11, long j11, boolean z10, int i12, String str, WorkSource workSource, m0 m0Var) {
        boolean z11 = true;
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            z11 = false;
        }
        b2.p.a(z11);
        this.f14016f = j10;
        this.f14017g = i10;
        this.f14018h = i11;
        this.f14019i = j11;
        this.f14020j = z10;
        this.f14021k = i12;
        this.f14022l = str;
        this.f14023m = workSource;
        this.f14024n = m0Var;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f14016f == gVar.f14016f && this.f14017g == gVar.f14017g && this.f14018h == gVar.f14018h && this.f14019i == gVar.f14019i && this.f14020j == gVar.f14020j && this.f14021k == gVar.f14021k && b2.o.a(this.f14022l, gVar.f14022l) && b2.o.a(this.f14023m, gVar.f14023m) && b2.o.a(this.f14024n, gVar.f14024n);
    }

    public long g() {
        return this.f14019i;
    }

    public int hashCode() {
        return b2.o.b(Long.valueOf(this.f14016f), Integer.valueOf(this.f14017g), Integer.valueOf(this.f14018h), Long.valueOf(this.f14019i));
    }

    public int j() {
        return this.f14017g;
    }

    public long l() {
        return this.f14016f;
    }

    public int s() {
        return this.f14018h;
    }

    public final int t() {
        return this.f14021k;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CurrentLocationRequest[");
        sb2.append(r.b(this.f14018h));
        if (this.f14016f != Long.MAX_VALUE) {
            sb2.append(", maxAge=");
            w0.b(this.f14016f, sb2);
        }
        if (this.f14019i != Long.MAX_VALUE) {
            sb2.append(", duration=");
            sb2.append(this.f14019i);
            sb2.append("ms");
        }
        if (this.f14017g != 0) {
            sb2.append(", ");
            sb2.append(b0.b(this.f14017g));
        }
        if (this.f14020j) {
            sb2.append(", bypass");
        }
        if (this.f14021k != 0) {
            sb2.append(", ");
            sb2.append(s.a(this.f14021k));
        }
        if (this.f14022l != null) {
            sb2.append(", moduleId=");
            sb2.append(this.f14022l);
        }
        if (!g2.p.f(this.f14023m)) {
            sb2.append(", workSource=");
            sb2.append(this.f14023m);
        }
        if (this.f14024n != null) {
            sb2.append(", impersonation=");
            sb2.append(this.f14024n);
        }
        sb2.append(']');
        return sb2.toString();
    }

    public final WorkSource u() {
        return this.f14023m;
    }

    @Deprecated
    public final String v() {
        return this.f14022l;
    }

    public final boolean w() {
        return this.f14020j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.m(parcel, 1, l());
        c2.c.k(parcel, 2, j());
        c2.c.k(parcel, 3, s());
        c2.c.m(parcel, 4, g());
        c2.c.c(parcel, 5, this.f14020j);
        c2.c.o(parcel, 6, this.f14023m, i10, false);
        c2.c.k(parcel, 7, this.f14021k);
        c2.c.q(parcel, 8, this.f14022l, false);
        c2.c.o(parcel, 9, this.f14024n, i10, false);
        c2.c.b(parcel, a10);
    }
}
