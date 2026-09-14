package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0263c implements Parcelable {
    public static final Parcelable.Creator<C0263c> CREATOR = new G0.i(3);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3353a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3354b;

    public C0263c(Parcel parcel) {
        this.f3353a = parcel.createStringArrayList();
        this.f3354b = parcel.createTypedArrayList(C0261b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f3353a);
        parcel.writeTypedList(this.f3354b);
    }
}
