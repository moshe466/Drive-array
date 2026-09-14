package e;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: e.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0359a implements Parcelable {
    public static final Parcelable.Creator<C0359a> CREATOR = new G0.i(8);

    /* renamed from: a, reason: collision with root package name */
    public final int f4415a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f4416b;

    public C0359a(int i, Intent intent) {
        this.f4415a = i;
        this.f4416b = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i = this.f4415a;
        if (i != -1) {
            if (i != 0) {
                str = String.valueOf(i);
            } else {
                str = "RESULT_CANCELED";
            }
        } else {
            str = "RESULT_OK";
        }
        sb.append(str);
        sb.append(", data=");
        sb.append(this.f4416b);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        int i3;
        kotlin.jvm.internal.j.e(dest, "dest");
        dest.writeInt(this.f4415a);
        Intent intent = this.f4416b;
        if (intent == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        dest.writeInt(i3);
        if (intent != null) {
            intent.writeToParcel(dest, i);
        }
    }
}
