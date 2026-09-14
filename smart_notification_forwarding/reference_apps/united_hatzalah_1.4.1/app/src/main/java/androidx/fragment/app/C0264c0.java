package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.fragment.app.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0264c0 implements Parcelable {
    public static final Parcelable.Creator<C0264c0> CREATOR = new G0.i(4);

    /* renamed from: a, reason: collision with root package name */
    public String f3355a;

    /* renamed from: b, reason: collision with root package name */
    public int f3356b;

    public C0264c0(String str, int i) {
        this.f3355a = str;
        this.f3356b = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3355a);
        parcel.writeInt(this.f3356b);
    }
}
