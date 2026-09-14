package c5;

import com.google.gson.l;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    private static Class f4391d;

    /* renamed from: b, reason: collision with root package name */
    private final Object f4392b = d();

    /* renamed from: c, reason: collision with root package name */
    private final Field f4393c = c();

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f4391d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // c5.b
    public void b(AccessibleObject accessibleObject) {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e10) {
            throw new l("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e10);
        }
    }

    boolean e(AccessibleObject accessibleObject) {
        if (this.f4392b != null && this.f4393c != null) {
            try {
                f4391d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f4392b, accessibleObject, Long.valueOf(((Long) f4391d.getMethod("objectFieldOffset", Field.class).invoke(this.f4392b, this.f4393c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
