package w;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import java.util.HashSet;
import java.util.Set;
import org.apache.tika.metadata.TikaCoreProperties;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static String f6675c;

    /* renamed from: a, reason: collision with root package name */
    public final NotificationManager f6677a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6674b = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static HashSet f6676d = new HashSet();

    public p(Context context) {
        this.f6677a = (NotificationManager) context.getSystemService("notification");
    }

    public static Set a(Context context) {
        HashSet hashSet;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f6674b) {
            if (string != null) {
                try {
                    if (!string.equals(f6675c)) {
                        String[] split = string.split(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, -1);
                        HashSet hashSet2 = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet2.add(unflattenFromString.getPackageName());
                            }
                        }
                        f6676d = hashSet2;
                        f6675c = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hashSet = f6676d;
        }
        return hashSet;
    }
}
