package k0;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: k0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0489m implements Parcelable {
    public static final Parcelable.Creator<C0489m> CREATOR = new G0.i(10);

    /* renamed from: a, reason: collision with root package name */
    public int f5260a;

    /* renamed from: b, reason: collision with root package name */
    public int f5261b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5262c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5260a);
        parcel.writeInt(this.f5261b);
        parcel.writeInt(this.f5262c ? 1 : 0);
    }
}
