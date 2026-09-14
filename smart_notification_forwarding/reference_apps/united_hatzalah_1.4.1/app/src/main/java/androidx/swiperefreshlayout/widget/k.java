package androidx.swiperefreshlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public final class k extends View.BaseSavedState {
    public static final Parcelable.Creator<k> CREATOR = new G0.i(7);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3781a;

    public k(Parcelable parcelable, boolean z3) {
        super(parcelable);
        this.f3781a = z3;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f3781a ? (byte) 1 : (byte) 0);
    }

    public k(Parcel parcel) {
        super(parcel);
        this.f3781a = parcel.readByte() != 0;
    }
}
