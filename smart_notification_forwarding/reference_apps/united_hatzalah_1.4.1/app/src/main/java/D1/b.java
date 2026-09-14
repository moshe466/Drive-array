package d1;

import android.media.MediaDrm;
import android.os.Build;
import java.security.MessageDigest;
import java.util.UUID;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import t2.AbstractC0705g;

/* loaded from: classes.dex */
public final class b extends k implements F2.a {
    @Override // F2.a
    public final Object invoke() {
        MediaDrm mediaDrm = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
        byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
        j.d(propertyByteArray, "getPropertyByteArray(...)");
        if (Build.VERSION.SDK_INT >= 28) {
            mediaDrm.release();
        } else {
            mediaDrm.release();
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        j.d(messageDigest, "getInstance(...)");
        messageDigest.update(propertyByteArray);
        byte[] digest = messageDigest.digest();
        j.d(digest, "digest(...)");
        return AbstractC0705g.L(digest, "", c.f4414a, 30);
    }
}
