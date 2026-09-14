package k0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class I implements Parcelable {
    public static final Parcelable.Creator<I> CREATOR = new G0.i(11);

    /* renamed from: a, reason: collision with root package name */
    public int f5178a;

    /* renamed from: b, reason: collision with root package name */
    public int f5179b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f5180c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5181d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f5178a + ", mGapDir=" + this.f5179b + ", mHasUnwantedGapAfter=" + this.f5181d + ", mGapPerSpan=" + Arrays.toString(this.f5180c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5178a);
        parcel.writeInt(this.f5179b);
        parcel.writeInt(this.f5181d ? 1 : 0);
        int[] iArr = this.f5180c;
        if (iArr != null && iArr.length > 0) {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f5180c);
        } else {
            parcel.writeInt(0);
        }
    }
}
