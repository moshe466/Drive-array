package androidx.versionedparcelable;

import G0.i;
import android.os.Parcel;
import android.os.Parcelable;
import s0.C0648b;
import s0.InterfaceC0649c;

/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new i(14);

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0649c f3782a;

    public ParcelImpl(Parcel parcel) {
        this.f3782a = new C0648b(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new C0648b(parcel).i(this.f3782a);
    }
}
