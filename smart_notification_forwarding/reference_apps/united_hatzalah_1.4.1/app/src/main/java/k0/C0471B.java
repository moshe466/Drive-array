package k0;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: k0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0471B extends Q.c {
    public static final Parcelable.Creator<C0471B> CREATOR = new Q.b(2);

    /* renamed from: c, reason: collision with root package name */
    public Parcelable f5163c;

    public C0471B(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5163c = parcel.readParcelable(classLoader == null ? t.class.getClassLoader() : classLoader);
    }

    @Override // Q.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f5163c, 0);
    }
}
