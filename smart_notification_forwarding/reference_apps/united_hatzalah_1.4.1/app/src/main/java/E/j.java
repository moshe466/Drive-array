package e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new G0.i(9);

    /* renamed from: a, reason: collision with root package name */
    public final IntentSender f4436a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f4437b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4438c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4439d;

    public j(IntentSender intentSender, Intent intent, int i, int i3) {
        this.f4436a = intentSender;
        this.f4437b = intent;
        this.f4438c = i;
        this.f4439d = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        kotlin.jvm.internal.j.e(dest, "dest");
        dest.writeParcelable(this.f4436a, i);
        dest.writeParcelable(this.f4437b, i);
        dest.writeInt(this.f4438c);
        dest.writeInt(this.f4439d);
    }
}
