package Q1;

import F0.C0062n1;
import K1.f;
import android.content.Context;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f1722b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final f f1723a;

    public a(C0062n1 c0062n1) {
        Context context = (Context) c0062n1.f589d;
        String str = c0062n1.f586a;
        String str2 = c0062n1.f587b;
        if (str != null) {
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            } else {
                applicationContext.getSharedPreferences(str2, 0).edit();
            }
            this.f1723a = (f) c0062n1.f592g;
            return;
        }
        throw new IllegalArgumentException("keysetName cannot be null");
    }
}
