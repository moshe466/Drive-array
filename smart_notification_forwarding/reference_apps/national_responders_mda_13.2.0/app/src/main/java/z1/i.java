package z1;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class i extends c2.a {
    public static final Parcelable.Creator<i> CREATOR = new j();

    /* renamed from: f, reason: collision with root package name */
    private final boolean f16075f;

    /* renamed from: g, reason: collision with root package name */
    private final String f16076g;

    /* renamed from: h, reason: collision with root package name */
    private final int f16077h;

    /* renamed from: i, reason: collision with root package name */
    private final int f16078i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(boolean z10, String str, int i10, int i11) {
        this.f16075f = z10;
        this.f16076g = str;
        this.f16077h = m.a(i10) - 1;
        this.f16078i = h.a(i11) - 1;
    }

    public final String g() {
        return this.f16076g;
    }

    public final boolean j() {
        return this.f16075f;
    }

    public final int l() {
        return h.a(this.f16078i);
    }

    public final int s() {
        return m.a(this.f16077h);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.c(parcel, 1, this.f16075f);
        c2.c.q(parcel, 2, this.f16076g, false);
        c2.c.k(parcel, 3, this.f16077h);
        c2.c.k(parcel, 4, this.f16078i);
        c2.c.b(parcel, a10);
    }
}
