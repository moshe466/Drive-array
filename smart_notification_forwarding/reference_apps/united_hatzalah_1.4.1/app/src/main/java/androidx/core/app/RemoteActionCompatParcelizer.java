package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import s0.AbstractC0647a;
import s0.C0648b;
import s0.InterfaceC0649c;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0647a abstractC0647a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC0649c interfaceC0649c = remoteActionCompat.f3038a;
        boolean z3 = true;
        if (abstractC0647a.e(1)) {
            interfaceC0649c = abstractC0647a.g();
        }
        remoteActionCompat.f3038a = (IconCompat) interfaceC0649c;
        CharSequence charSequence = remoteActionCompat.f3039b;
        if (abstractC0647a.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0648b) abstractC0647a).f6231e);
        }
        remoteActionCompat.f3039b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f3040c;
        if (abstractC0647a.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0648b) abstractC0647a).f6231e);
        }
        remoteActionCompat.f3040c = charSequence2;
        remoteActionCompat.f3041d = (PendingIntent) abstractC0647a.f(remoteActionCompat.f3041d, 4);
        boolean z4 = remoteActionCompat.f3042e;
        if (abstractC0647a.e(5)) {
            if (((C0648b) abstractC0647a).f6231e.readInt() != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        remoteActionCompat.f3042e = z4;
        boolean z5 = remoteActionCompat.f3043f;
        if (!abstractC0647a.e(6)) {
            z3 = z5;
        } else if (((C0648b) abstractC0647a).f6231e.readInt() == 0) {
            z3 = false;
        }
        remoteActionCompat.f3043f = z3;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0647a abstractC0647a) {
        abstractC0647a.getClass();
        IconCompat iconCompat = remoteActionCompat.f3038a;
        abstractC0647a.h(1);
        abstractC0647a.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f3039b;
        abstractC0647a.h(2);
        Parcel parcel = ((C0648b) abstractC0647a).f6231e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f3040c;
        abstractC0647a.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f3041d;
        abstractC0647a.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z3 = remoteActionCompat.f3042e;
        abstractC0647a.h(5);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = remoteActionCompat.f3043f;
        abstractC0647a.h(6);
        parcel.writeInt(z4 ? 1 : 0);
    }
}
