package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2337a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<e, SparseArray<d>> f2338b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f2339c = new Object();

    /* loaded from: classes.dex */
    static class a {
        static Drawable a(Resources resources, int i10, int i11) {
            return resources.getDrawableForDensity(i10, i11);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        static ColorStateList b(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        final ColorStateList f2340a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f2341b;

        /* renamed from: c, reason: collision with root package name */
        final int f2342c;

        d(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f2340a = colorStateList;
            this.f2341b = configuration;
            this.f2342c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        final Resources f2343a;

        /* renamed from: b, reason: collision with root package name */
        final Resources.Theme f2344b;

        e(Resources resources, Resources.Theme theme) {
            this.f2343a = resources;
            this.f2344b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f2343a.equals(eVar.f2343a) && androidx.core.util.c.a(this.f2344b, eVar.f2344b);
        }

        public int hashCode() {
            return androidx.core.util.c.b(this.f2343a, this.f2344b);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i10, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.i
                @Override // java.lang.Runnable
                public final void run() {
                    h.f.this.f(i10);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.j
                @Override // java.lang.Runnable
                public final void run() {
                    h.f.this.g(typeface);
                }
            });
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i10);

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    /* loaded from: classes.dex */
    public static final class g {

        /* loaded from: classes.dex */
        static class a {

            /* renamed from: a, reason: collision with root package name */
            private static final Object f2345a = new Object();

            /* renamed from: b, reason: collision with root package name */
            private static Method f2346b;

            /* renamed from: c, reason: collision with root package name */
            private static boolean f2347c;

            @SuppressLint({"BanUncheckedReflection"})
            static void a(Resources.Theme theme) {
                synchronized (f2345a) {
                    if (!f2347c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f2346b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        f2347c = true;
                    }
                    Method method = f2346b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            f2346b = null;
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                b.a(theme);
            } else if (i10 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(e eVar, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f2339c) {
            WeakHashMap<e, SparseArray<d>> weakHashMap = f2338b;
            SparseArray<d> sparseArray = weakHashMap.get(eVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(eVar, sparseArray);
            }
            sparseArray.append(i10, new d(colorStateList, eVar.f2343a.getConfiguration(), theme));
        }
    }

    private static ColorStateList b(e eVar, int i10) {
        d dVar;
        Resources.Theme theme;
        synchronized (f2339c) {
            SparseArray<d> sparseArray = f2338b.get(eVar);
            if (sparseArray != null && sparseArray.size() > 0 && (dVar = sparseArray.get(i10)) != null) {
                if (dVar.f2341b.equals(eVar.f2343a.getConfiguration()) && (((theme = eVar.f2344b) == null && dVar.f2342c == 0) || (theme != null && dVar.f2342c == theme.hashCode()))) {
                    return dVar.f2340a;
                }
                sparseArray.remove(i10);
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources, int i10, Resources.Theme theme) {
        e eVar = new e(resources, theme);
        ColorStateList b10 = b(eVar, i10);
        if (b10 != null) {
            return b10;
        }
        ColorStateList h10 = h(resources, i10, theme);
        if (h10 == null) {
            return Build.VERSION.SDK_INT >= 23 ? c.b(resources, i10, theme) : resources.getColorStateList(i10);
        }
        a(eVar, i10, h10, theme);
        return h10;
    }

    public static Drawable d(Resources resources, int i10, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? b.a(resources, i10, theme) : resources.getDrawable(i10);
    }

    public static Drawable e(Resources resources, int i10, int i11, Resources.Theme theme) {
        int i12 = Build.VERSION.SDK_INT;
        return i12 >= 21 ? b.b(resources, i10, i11, theme) : i12 >= 15 ? a.a(resources, i10, i11) : resources.getDrawable(i10);
    }

    public static Typeface f(Context context, int i10, TypedValue typedValue, int i11, f fVar) {
        if (context.isRestricted()) {
            return null;
        }
        return j(context, i10, typedValue, i11, fVar, null, true, false);
    }

    private static TypedValue g() {
        ThreadLocal<TypedValue> threadLocal = f2337a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList h(Resources resources, int i10, Resources.Theme theme) {
        if (i(resources, i10)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i10), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean i(Resources resources, int i10) {
        TypedValue g10 = g();
        resources.getValue(i10, g10, true);
        int i11 = g10.type;
        return i11 >= 28 && i11 <= 31;
    }

    private static Typeface j(Context context, int i10, TypedValue typedValue, int i11, f fVar, Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface k10 = k(context, resources, typedValue, i10, i11, fVar, handler, z10, z11);
        if (k10 != null || fVar != null || z11) {
            return k10;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface k(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.content.res.h.f r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r2 = r16
            r0 = r17
            r3 = r18
            r10 = r20
            r11 = r21
            java.lang.CharSequence r1 = r0.string
            if (r1 == 0) goto L9b
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = -3
            r14 = 0
            if (r1 != 0) goto L22
            if (r10 == 0) goto L21
            r10.c(r13, r11)
        L21:
            return r14
        L22:
            int r1 = r0.assetCookie
            r6 = r19
            android.graphics.Typeface r1 = androidx.core.graphics.e.f(r2, r3, r12, r1, r6)
            if (r1 == 0) goto L32
            if (r10 == 0) goto L31
            r10.d(r1, r11)
        L31:
            return r1
        L32:
            if (r23 == 0) goto L35
            return r14
        L35:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            java.lang.String r4 = ".xml"
            boolean r1 = r1.endsWith(r4)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            if (r1 == 0) goto L66
            android.content.res.XmlResourceParser r1 = r2.getXml(r3)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            androidx.core.content.res.e$b r1 = androidx.core.content.res.e.b(r1, r2)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            if (r1 != 0) goto L51
            if (r10 == 0) goto L50
            r10.c(r13, r11)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
        L50:
            return r14
        L51:
            int r5 = r0.assetCookie     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            r0 = r15
            r2 = r16
            r3 = r18
            r4 = r12
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            android.graphics.Typeface r0 = androidx.core.graphics.e.c(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            return r0
        L66:
            int r4 = r0.assetCookie     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            r0 = r15
            r1 = r16
            r2 = r18
            r3 = r12
            r5 = r19
            android.graphics.Typeface r0 = androidx.core.graphics.e.d(r0, r1, r2, r3, r4, r5)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            if (r10 == 0) goto L7f
            if (r0 == 0) goto L7c
            r10.d(r0, r11)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
            goto L7f
        L7c:
            r10.c(r13, r11)     // Catch: java.io.IOException -> L80 org.xmlpull.v1.XmlPullParserException -> L88
        L7f:
            return r0
        L80:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to read xml resource "
            goto L8f
        L88:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to parse xml resource "
        L8f:
            r0.append(r1)
            r0.append(r12)
            if (r10 == 0) goto L9a
            r10.c(r13, r11)
        L9a:
            return r14
        L9b:
            android.content.res.Resources$NotFoundException r1 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Resource \""
            r4.append(r5)
            java.lang.String r2 = r2.getResourceName(r3)
            r4.append(r2)
            java.lang.String r2 = "\" ("
            r4.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r18)
            r4.append(r2)
            java.lang.String r2 = ") is not a Font: "
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.k(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.h$f, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
