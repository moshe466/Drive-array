package q2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class n1 extends c2.a implements a2.j {
    public static final Parcelable.Creator<n1> CREATOR;

    /* renamed from: f, reason: collision with root package name */
    private final Status f13516f;

    static {
        new n1(Status.f4747k);
        CREATOR = new o1();
    }

    public n1(Status status) {
        this.f13516f = status;
    }

    @Override // a2.j
    public final Status c() {
        return this.f13516f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.o(parcel, 1, this.f13516f, i10, false);
        c2.c.b(parcel, a10);
    }
}
