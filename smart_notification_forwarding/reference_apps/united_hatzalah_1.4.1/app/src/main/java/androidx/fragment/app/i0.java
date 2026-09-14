package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new G0.i(5);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f3415a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f3416b;

    /* renamed from: c, reason: collision with root package name */
    public C0261b[] f3417c;

    /* renamed from: d, reason: collision with root package name */
    public int f3418d;

    /* renamed from: e, reason: collision with root package name */
    public String f3419e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f3420f;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f3421j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f3422k;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f3415a);
        parcel.writeStringList(this.f3416b);
        parcel.writeTypedArray(this.f3417c, i);
        parcel.writeInt(this.f3418d);
        parcel.writeString(this.f3419e);
        parcel.writeStringList(this.f3420f);
        parcel.writeTypedList(this.f3421j);
        parcel.writeTypedList(this.f3422k);
    }
}
