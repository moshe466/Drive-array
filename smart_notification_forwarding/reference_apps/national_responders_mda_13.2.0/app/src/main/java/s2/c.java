package s2;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class c extends c2.a {
    public static final Parcelable.Creator<c> CREATOR = new t();

    /* renamed from: f, reason: collision with root package name */
    private final int f14002f;

    /* renamed from: g, reason: collision with root package name */
    private final int f14003g;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f14004a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f14005b = -1;

        public c a() {
            b2.p.o(this.f14004a != -1, "Activity type not set.");
            b2.p.o(this.f14005b != -1, "Activity transition type not set.");
            return new c(this.f14004a, this.f14005b);
        }

        public a b(int i10) {
            c.l(i10);
            this.f14005b = i10;
            return this;
        }

        public a c(int i10) {
            this.f14004a = i10;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i10, int i11) {
        this.f14002f = i10;
        this.f14003g = i11;
    }

    public static void l(int i10) {
        b2.p.b(i10 >= 0 && i10 <= 1, "Transition type " + i10 + " is not valid.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f14002f == cVar.f14002f && this.f14003g == cVar.f14003g;
    }

    public int g() {
        return this.f14002f;
    }

    public int hashCode() {
        return b2.o.b(Integer.valueOf(this.f14002f), Integer.valueOf(this.f14003g));
    }

    public int j() {
        return this.f14003g;
    }

    public String toString() {
        return "ActivityTransition [mActivityType=" + this.f14002f + ", mTransitionType=" + this.f14003g + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        b2.p.k(parcel);
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, g());
        c2.c.k(parcel, 2, j());
        c2.c.b(parcel, a10);
    }
}
