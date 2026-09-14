package w;

import F0.AbstractC0083t;
import android.app.Notification;

/* loaded from: classes.dex */
public final class l extends AbstractC0083t {

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f6646b;

    @Override // F0.AbstractC0083t
    public final void a(o oVar) {
        new Notification.BigTextStyle(oVar.f6670b).setBigContentTitle(null).bigText(this.f6646b);
    }

    @Override // F0.AbstractC0083t
    public final String g() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
