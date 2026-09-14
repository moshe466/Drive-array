package w;

import F0.AbstractC0083t;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public final class k extends AbstractC0083t {

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f6643b;

    /* renamed from: c, reason: collision with root package name */
    public IconCompat f6644c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6645d;

    @Override // F0.AbstractC0083t
    public final void a(o oVar) {
        Bitmap a2;
        Notification.Builder builder = oVar.f6670b;
        Context context = oVar.f6669a;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(builder).setBigContentTitle(null);
        IconCompat iconCompat = this.f6643b;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                j.a(bigContentTitle, iconCompat.f(context));
            } else if (iconCompat.d() == 1) {
                IconCompat iconCompat2 = this.f6643b;
                int i = iconCompat2.f3045a;
                if (i == -1) {
                    Object obj = iconCompat2.f3046b;
                    if (obj instanceof Bitmap) {
                        a2 = (Bitmap) obj;
                    } else {
                        a2 = null;
                    }
                } else if (i == 1) {
                    a2 = (Bitmap) iconCompat2.f3046b;
                } else if (i == 5) {
                    a2 = IconCompat.a((Bitmap) iconCompat2.f3046b, true);
                } else {
                    throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                }
                bigContentTitle = bigContentTitle.bigPicture(a2);
            }
        }
        if (this.f6645d) {
            IconCompat iconCompat3 = this.f6644c;
            if (iconCompat3 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else {
                i.a(bigContentTitle, iconCompat3.f(context));
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            j.c(bigContentTitle, false);
            j.b(bigContentTitle, null);
        }
    }

    @Override // F0.AbstractC0083t
    public final String g() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }
}
