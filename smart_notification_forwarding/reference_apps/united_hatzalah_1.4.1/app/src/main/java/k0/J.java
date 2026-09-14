package k0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class J implements Parcelable {
    public static final Parcelable.Creator<J> CREATOR = new G0.i(12);

    /* renamed from: a, reason: collision with root package name */
    public int f5182a;

    /* renamed from: b, reason: collision with root package name */
    public int f5183b;

    /* renamed from: c, reason: collision with root package name */
    public int f5184c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f5185d;

    /* renamed from: e, reason: collision with root package name */
    public int f5186e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f5187f;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f5188j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5189k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5190l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5191m;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5182a);
        parcel.writeInt(this.f5183b);
        parcel.writeInt(this.f5184c);
        if (this.f5184c > 0) {
            parcel.writeIntArray(this.f5185d);
        }
        parcel.writeInt(this.f5186e);
        if (this.f5186e > 0) {
            parcel.writeIntArray(this.f5187f);
        }
        parcel.writeInt(this.f5189k ? 1 : 0);
        parcel.writeInt(this.f5190l ? 1 : 0);
        parcel.writeInt(this.f5191m ? 1 : 0);
        parcel.writeList(this.f5188j);
    }
}
