package m;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public final class P extends View.BaseSavedState {
    public static final Parcelable.Creator<P> CREATOR = new G0.i(13);

    /* renamed from: a, reason: collision with root package name */
    public boolean f5575a;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f5575a ? (byte) 1 : (byte) 0);
    }
}
