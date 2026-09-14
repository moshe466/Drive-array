package A;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import t.C0694j;

/* loaded from: classes.dex */
public final class i extends E1.b {

    /* renamed from: b, reason: collision with root package name */
    public static final Class f15b;

    /* renamed from: c, reason: collision with root package name */
    public static final Constructor f16c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f17d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f18e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi24Impl", e4.getClass().getName(), e4);
            cls = null;
            method = null;
            method2 = null;
        }
        f16c = constructor;
        f15b = cls;
        f17d = method2;
        f18e = method;
    }

    public static boolean B(Object obj, ByteBuffer byteBuffer, int i, int i3, boolean z3) {
        try {
            return ((Boolean) f17d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i3), Boolean.valueOf(z3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface C(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f15b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f18e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // E1.b
    public final Typeface e(Context context, z.e eVar, Resources resources, int i) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        FileInputStream fileInputStream;
        try {
            obj = f16c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            for (z.f fVar : eVar.f6779a) {
                int i3 = fVar.f6785f;
                File x3 = T.b.x(context);
                if (x3 != null) {
                    try {
                        if (T.b.f(x3, resources, i3)) {
                            try {
                                fileInputStream = new FileInputStream(x3);
                            } catch (IOException unused2) {
                                mappedByteBuffer = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (mappedByteBuffer != null && B(obj, mappedByteBuffer, fVar.f6784e, fVar.f6781b, fVar.f6782c)) {
                                }
                            } finally {
                                break;
                            }
                        }
                    } finally {
                        x3.delete();
                    }
                }
                mappedByteBuffer = null;
                if (mappedByteBuffer != null) {
                }
            }
            return C(obj);
        }
        return null;
    }

    @Override // E1.b
    public final Typeface f(Context context, G.i[] iVarArr, int i) {
        Object obj;
        try {
            obj = f16c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            int i3 = 0;
            C0694j c0694j = new C0694j(0);
            int length = iVarArr.length;
            while (true) {
                if (i3 < length) {
                    G.i iVar = iVarArr[i3];
                    Uri uri = iVar.f791a;
                    ByteBuffer byteBuffer = (ByteBuffer) c0694j.get(uri);
                    if (byteBuffer == null) {
                        byteBuffer = T.b.E(context, uri);
                        c0694j.put(uri, byteBuffer);
                    }
                    if (byteBuffer == null || !B(obj, byteBuffer, iVar.f792b, iVar.f793c, iVar.f794d)) {
                        break;
                    }
                    i3++;
                } else {
                    Typeface C3 = C(obj);
                    if (C3 != null) {
                        return Typeface.create(C3, i);
                    }
                }
            }
        }
        return null;
    }
}
