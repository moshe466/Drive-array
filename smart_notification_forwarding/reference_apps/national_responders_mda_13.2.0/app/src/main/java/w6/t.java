package w6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public String f15257a;

    /* renamed from: b, reason: collision with root package name */
    public String f15258b;

    /* renamed from: e, reason: collision with root package name */
    public a f15261e;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15260d = false;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f15259c = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum a {
        Phone,
        Audio,
        Location,
        IO,
        Camera,
        Overlay,
        SMS
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT > 22) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public boolean b(Context context) {
        if (this.f15260d) {
            return a(context);
        }
        Iterator<String> it = this.f15259c.iterator();
        while (it.hasNext()) {
            if (androidx.core.content.a.a(context, it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    public void c(Activity activity) {
        if (this.f15260d) {
            d(activity);
        } else {
            androidx.core.app.b.n(activity, (String[]) this.f15259c.toArray(new String[this.f15259c.size()]), 0);
        }
    }

    public boolean d(Activity activity) {
        activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 12344);
        return false;
    }
}
