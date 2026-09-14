package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2171a = (IconCompat) aVar.v(remoteActionCompat.f2171a, 1);
        remoteActionCompat.f2172b = aVar.l(remoteActionCompat.f2172b, 2);
        remoteActionCompat.f2173c = aVar.l(remoteActionCompat.f2173c, 3);
        remoteActionCompat.f2174d = (PendingIntent) aVar.r(remoteActionCompat.f2174d, 4);
        remoteActionCompat.f2175e = aVar.h(remoteActionCompat.f2175e, 5);
        remoteActionCompat.f2176f = aVar.h(remoteActionCompat.f2176f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f2171a, 1);
        aVar.D(remoteActionCompat.f2172b, 2);
        aVar.D(remoteActionCompat.f2173c, 3);
        aVar.H(remoteActionCompat.f2174d, 4);
        aVar.z(remoteActionCompat.f2175e, 5);
        aVar.z(remoteActionCompat.f2176f, 6);
    }
}
