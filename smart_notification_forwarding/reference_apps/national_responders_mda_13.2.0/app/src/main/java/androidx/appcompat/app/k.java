package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private static Field f697a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f698b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f699c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f700d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f701e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f702f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f703g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f704h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Resources resources) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return;
        }
        if (i10 >= 24) {
            d(resources);
        } else if (i10 >= 23) {
            c(resources);
        } else if (i10 >= 21) {
            b(resources);
        }
    }

    private static void b(Resources resources) {
        if (!f698b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f697a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f698b = true;
        }
        Field field = f697a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f698b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f697a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f698b = true;
        }
        Object obj = null;
        Field field = f697a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f704h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f703g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f704h = true;
        }
        Field field = f703g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException unused2) {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f698b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f697a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            f698b = true;
        }
        Field field2 = f697a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException unused4) {
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) {
        if (!f700d) {
            try {
                f699c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            f700d = true;
        }
        Class<?> cls = f699c;
        if (cls == null) {
            return;
        }
        if (!f702f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f701e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            f702f = true;
        }
        Field field = f701e;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
