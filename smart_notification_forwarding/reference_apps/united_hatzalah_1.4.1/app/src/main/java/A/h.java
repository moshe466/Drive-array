package A;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class h extends E1.b {

    /* renamed from: b, reason: collision with root package name */
    public static Class f10b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Constructor f11c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Method f12d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Method f13e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f14f = false;

    public static boolean B(Object obj, String str, int i, boolean z3) {
        C();
        try {
            return ((Boolean) f12d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void C() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f14f) {
            return;
        }
        f14f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi21Impl", e4.getClass().getName(), e4);
            method = null;
            cls = null;
            method2 = null;
        }
        f11c = constructor;
        f10b = cls;
        f12d = method2;
        f13e = method;
    }

    @Override // E1.b
    public Typeface e(Context context, z.e eVar, Resources resources, int i) {
        C();
        try {
            Object newInstance = f11c.newInstance(null);
            for (z.f fVar : eVar.f6779a) {
                File x3 = T.b.x(context);
                if (x3 == null) {
                    return null;
                }
                try {
                    if (!T.b.f(x3, resources, fVar.f6785f)) {
                        return null;
                    }
                    if (!B(newInstance, x3.getPath(), fVar.f6781b, fVar.f6782c)) {
                        return null;
                    }
                    x3.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    x3.delete();
                }
            }
            C();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) f10b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f13e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // E1.b
    public Typeface f(Context context, G.i[] iVarArr, int i) {
        File file;
        String readlink;
        if (iVarArr.length >= 1) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(o(iVarArr, i).f791a, "r", null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                        return null;
                    }
                } else {
                    try {
                        try {
                            readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
                        } catch (Throwable th) {
                            try {
                                openFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (ErrnoException unused) {
                    }
                    try {
                        if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                            file = new File(readlink);
                            if (file != null && file.canRead()) {
                                Typeface createFromFile = Typeface.createFromFile(file);
                                openFileDescriptor.close();
                                return createFromFile;
                            }
                            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                            Typeface h2 = h(context, fileInputStream);
                            fileInputStream.close();
                            openFileDescriptor.close();
                            return h2;
                        }
                        Typeface h22 = h(context, fileInputStream);
                        fileInputStream.close();
                        openFileDescriptor.close();
                        return h22;
                    } finally {
                    }
                    file = null;
                    if (file != null) {
                        Typeface createFromFile2 = Typeface.createFromFile(file);
                        openFileDescriptor.close();
                        return createFromFile2;
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
                }
            } catch (IOException unused2) {
            }
        }
        return null;
    }
}
