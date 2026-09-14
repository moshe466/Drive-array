package A;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class j extends h {

    /* renamed from: g, reason: collision with root package name */
    public final Class f19g;

    /* renamed from: h, reason: collision with root package name */
    public final Constructor f20h;
    public final Method i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f21j;

    /* renamed from: k, reason: collision with root package name */
    public final Method f22k;

    /* renamed from: l, reason: collision with root package name */
    public final Method f23l;

    /* renamed from: m, reason: collision with root package name */
    public final Method f24m;

    public j() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            method2 = G(cls2);
            Class cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method4 = cls2.getMethod("freeze", null);
            method5 = cls2.getMethod("abortCreation", null);
            method = H(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e4.getClass().getName()), e4);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f19g = cls;
        this.f20h = constructor;
        this.i = method2;
        this.f21j = method3;
        this.f22k = method4;
        this.f23l = method5;
        this.f24m = method;
    }

    public static Method G(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    public final boolean D(Context context, Object obj, String str, int i, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface E(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f19g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f24m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean F(Object obj) {
        try {
            return ((Boolean) this.f22k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method H(Class cls) {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // A.h, E1.b
    public final Typeface e(Context context, z.e eVar, Resources resources, int i) {
        Object obj;
        if (this.i != null) {
            try {
                obj = this.f20h.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj != null) {
                z.f[] fVarArr = eVar.f6779a;
                int length = fVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        z.f fVar = fVarArr[i3];
                        Context context2 = context;
                        if (!D(context2, obj, fVar.f6780a, fVar.f6784e, fVar.f6781b, fVar.f6782c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fVar.f6783d))) {
                            try {
                                this.f23l.invoke(obj, null);
                                break;
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        } else {
                            i3++;
                            context = context2;
                        }
                    } else if (F(obj)) {
                        return E(obj);
                    }
                }
            }
            return null;
        }
        return super.e(context, eVar, resources, i);
    }

    @Override // A.h, E1.b
    public final Typeface f(Context context, G.i[] iVarArr, int i) {
        Object obj;
        Typeface E3;
        boolean z3;
        if (iVarArr.length >= 1) {
            try {
                if (this.i != null) {
                    HashMap hashMap = new HashMap();
                    for (G.i iVar : iVarArr) {
                        if (iVar.f796f == 0) {
                            Uri uri = iVar.f791a;
                            if (!hashMap.containsKey(uri)) {
                                hashMap.put(uri, T.b.E(context, uri));
                            }
                        }
                    }
                    Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                    try {
                        obj = this.f20h.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        obj = null;
                    }
                    if (obj != null) {
                        int length = iVarArr.length;
                        int i3 = 0;
                        boolean z4 = false;
                        while (true) {
                            Method method = this.f23l;
                            if (i3 < length) {
                                G.i iVar2 = iVarArr[i3];
                                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(iVar2.f791a);
                                if (byteBuffer != null) {
                                    try {
                                        z3 = ((Boolean) this.f21j.invoke(obj, byteBuffer, Integer.valueOf(iVar2.f792b), null, Integer.valueOf(iVar2.f793c), Integer.valueOf(iVar2.f794d ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        z3 = false;
                                    }
                                    if (!z3) {
                                        method.invoke(obj, null);
                                        break;
                                    }
                                    z4 = true;
                                }
                                i3++;
                                z4 = z4;
                            } else if (!z4) {
                                method.invoke(obj, null);
                            } else if (F(obj) && (E3 = E(obj)) != null) {
                                return Typeface.create(E3, i);
                            }
                        }
                    }
                } else {
                    G.i o2 = o(iVarArr, i);
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(o2.f791a, "r", null);
                    if (openFileDescriptor == null) {
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                            return null;
                        }
                    } else {
                        try {
                            Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(o2.f793c).setItalic(o2.f794d).build();
                            openFileDescriptor.close();
                            return build;
                        } finally {
                        }
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // E1.b
    public final Typeface i(Context context, Resources resources, int i, String str, int i3) {
        Object obj;
        if (this.i != null) {
            try {
                obj = this.f20h.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj != null) {
                if (!D(context, obj, str, 0, -1, -1, null)) {
                    try {
                        this.f23l.invoke(obj, null);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                } else if (F(obj)) {
                    return E(obj);
                }
            }
            return null;
        }
        return super.i(context, resources, i, str, i3);
    }
}
