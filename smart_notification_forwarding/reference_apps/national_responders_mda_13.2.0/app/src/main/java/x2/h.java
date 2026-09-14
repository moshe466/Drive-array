package x2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends c2.a implements a2.j {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* renamed from: f, reason: collision with root package name */
    private final List f15406f;

    /* renamed from: g, reason: collision with root package name */
    private final String f15407g;

    public h(List list, String str) {
        this.f15406f = list;
        this.f15407g = str;
    }

    @Override // a2.j
    public final Status c() {
        return this.f15407g != null ? Status.f4747k : Status.f4750n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.r(parcel, 1, this.f15406f, false);
        c2.c.q(parcel, 2, this.f15407g, false);
        c2.c.b(parcel, a10);
    }
}
