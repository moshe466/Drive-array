package m;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class q1 extends Q.c {
    public static final Parcelable.Creator<q1> CREATOR = new Q.b(4);

    /* renamed from: c, reason: collision with root package name */
    public int f5755c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5756d;

    public q1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        boolean z3;
        this.f5755c = parcel.readInt();
        if (parcel.readInt() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f5756d = z3;
    }

    @Override // Q.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f5755c);
        parcel.writeInt(this.f5756d ? 1 : 0);
    }
}
