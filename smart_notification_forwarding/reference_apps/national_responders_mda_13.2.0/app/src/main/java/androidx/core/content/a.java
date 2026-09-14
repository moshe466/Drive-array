package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.core.app.n;
import androidx.core.content.res.h;
import java.io.File;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2307a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f2308b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static TypedValue f2309c;

    /* renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0030a {
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i10) {
            return context.getDrawable(i10);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* loaded from: classes.dex */
    static class c {
        static int a(Context context, int i10) {
            return context.getColor(i10);
        }

        static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* loaded from: classes.dex */
    static class d {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File b(Context context) {
            return context.getDataDir();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public static int a(Context context, String str) {
        androidx.core.util.c.d(str, "permission must be non-null");
        return (androidx.core.os.a.c() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : n.d(context).a() ? 0 : -1;
    }

    public static Context b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d.a(context);
        }
        return null;
    }

    private static File c(File file) {
        synchronized (f2308b) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to create files subdir ");
                sb2.append(file.getPath());
            }
            return file;
        }
    }

    public static int d(Context context, int i10) {
        return Build.VERSION.SDK_INT >= 23 ? c.a(context, i10) : context.getResources().getColor(i10);
    }

    public static ColorStateList e(Context context, int i10) {
        return h.c(context.getResources(), i10, context.getTheme());
    }

    public static Drawable f(Context context, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            return b.b(context, i10);
        }
        if (i11 < 16) {
            synchronized (f2307a) {
                if (f2309c == null) {
                    f2309c = new TypedValue();
                }
                context.getResources().getValue(i10, f2309c, true);
                i10 = f2309c.resourceId;
            }
        }
        return context.getResources().getDrawable(i10);
    }

    public static File g(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? b.c(context) : c(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static boolean h(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            C0030a.a(context, intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void i(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            C0030a.b(context, intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }
}
