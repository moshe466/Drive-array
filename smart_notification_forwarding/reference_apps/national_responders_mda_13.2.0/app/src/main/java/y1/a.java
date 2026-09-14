package y1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class a extends c2.a {
    public static final Parcelable.Creator<a> CREATOR = new f();

    /* renamed from: f, reason: collision with root package name */
    private Intent f15833f;

    public a(Intent intent) {
        this.f15833f = intent;
    }

    public final Intent g() {
        return this.f15833f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.o(parcel, 1, this.f15833f, i10, false);
        c2.c.b(parcel, a10);
    }
}
