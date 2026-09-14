package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class c0 implements Parcelable {
    public static final Parcelable.Creator<c0> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    final String f2909f;

    /* renamed from: g, reason: collision with root package name */
    final String f2910g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f2911h;

    /* renamed from: i, reason: collision with root package name */
    final int f2912i;

    /* renamed from: j, reason: collision with root package name */
    final int f2913j;

    /* renamed from: k, reason: collision with root package name */
    final String f2914k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f2915l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f2916m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f2917n;

    /* renamed from: o, reason: collision with root package name */
    final Bundle f2918o;

    /* renamed from: p, reason: collision with root package name */
    final boolean f2919p;

    /* renamed from: q, reason: collision with root package name */
    final int f2920q;

    /* renamed from: r, reason: collision with root package name */
    Bundle f2921r;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<c0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c0 createFromParcel(Parcel parcel) {
            return new c0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c0[] newArray(int i10) {
            return new c0[i10];
        }
    }

    c0(Parcel parcel) {
        this.f2909f = parcel.readString();
        this.f2910g = parcel.readString();
        this.f2911h = parcel.readInt() != 0;
        this.f2912i = parcel.readInt();
        this.f2913j = parcel.readInt();
        this.f2914k = parcel.readString();
        this.f2915l = parcel.readInt() != 0;
        this.f2916m = parcel.readInt() != 0;
        this.f2917n = parcel.readInt() != 0;
        this.f2918o = parcel.readBundle();
        this.f2919p = parcel.readInt() != 0;
        this.f2921r = parcel.readBundle();
        this.f2920q = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Fragment fragment) {
        this.f2909f = fragment.getClass().getName();
        this.f2910g = fragment.f2836k;
        this.f2911h = fragment.f2845t;
        this.f2912i = fragment.C;
        this.f2913j = fragment.D;
        this.f2914k = fragment.E;
        this.f2915l = fragment.H;
        this.f2916m = fragment.f2843r;
        this.f2917n = fragment.G;
        this.f2918o = fragment.f2837l;
        this.f2919p = fragment.F;
        this.f2920q = fragment.V.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(n nVar, ClassLoader classLoader) {
        Fragment a10 = nVar.a(classLoader, this.f2909f);
        Bundle bundle = this.f2918o;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a10.I1(this.f2918o);
        a10.f2836k = this.f2910g;
        a10.f2845t = this.f2911h;
        a10.f2847v = true;
        a10.C = this.f2912i;
        a10.D = this.f2913j;
        a10.E = this.f2914k;
        a10.H = this.f2915l;
        a10.f2843r = this.f2916m;
        a10.G = this.f2917n;
        a10.F = this.f2919p;
        a10.V = h.c.values()[this.f2920q];
        Bundle bundle2 = this.f2921r;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        a10.f2832g = bundle2;
        return a10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f2909f);
        sb2.append(" (");
        sb2.append(this.f2910g);
        sb2.append(")}:");
        if (this.f2911h) {
            sb2.append(" fromLayout");
        }
        if (this.f2913j != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f2913j));
        }
        String str = this.f2914k;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f2914k);
        }
        if (this.f2915l) {
            sb2.append(" retainInstance");
        }
        if (this.f2916m) {
            sb2.append(" removing");
        }
        if (this.f2917n) {
            sb2.append(" detached");
        }
        if (this.f2919p) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2909f);
        parcel.writeString(this.f2910g);
        parcel.writeInt(this.f2911h ? 1 : 0);
        parcel.writeInt(this.f2912i);
        parcel.writeInt(this.f2913j);
        parcel.writeString(this.f2914k);
        parcel.writeInt(this.f2915l ? 1 : 0);
        parcel.writeInt(this.f2916m ? 1 : 0);
        parcel.writeInt(this.f2917n ? 1 : 0);
        parcel.writeBundle(this.f2918o);
        parcel.writeInt(this.f2919p ? 1 : 0);
        parcel.writeBundle(this.f2921r);
        parcel.writeInt(this.f2920q);
    }
}
