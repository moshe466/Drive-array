package E;

import android.app.Notification;
import android.location.Location;

/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(Location location) {
        return location.isMock();
    }

    public static void b(Notification.Action.Builder builder) {
        builder.setAuthenticationRequired(false);
    }
}
