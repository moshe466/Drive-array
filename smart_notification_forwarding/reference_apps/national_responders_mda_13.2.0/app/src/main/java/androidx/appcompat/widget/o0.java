package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: i, reason: collision with root package name */
    private static o0 f1451i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, l.h<ColorStateList>> f1453a;

    /* renamed from: b, reason: collision with root package name */
    private l.g<String, e> f1454b;

    /* renamed from: c, reason: collision with root package name */
    private l.h<String> f1455c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap<Context, l.d<WeakReference<Drawable.ConstantState>>> f1456d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f1457e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1458f;

    /* renamed from: g, reason: collision with root package name */
    private f f1459g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f1450h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final c f1452j = new c(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.o0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return g.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.o0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends l.e<Integer, PorterDuffColorFilter> {
        public c(int i10) {
            super(i10);
        }

        private static int h(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i10, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(i10, mode)));
        }

        PorterDuffColorFilter j(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(h(i10, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.o0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        h.c.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean a(Context context, int i10, Drawable drawable);

        PorterDuff.Mode b(int i10);

        Drawable c(o0 o0Var, Context context, int i10);

        ColorStateList d(Context context, int i10);

        boolean e(Context context, int i10, Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.o0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.h.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f1454b == null) {
            this.f1454b = new l.g<>();
        }
        this.f1454b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j10, Drawable drawable) {
        boolean z10;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            l.d<WeakReference<Drawable.ConstantState>> dVar = this.f1456d.get(context);
            if (dVar == null) {
                dVar = new l.d<>();
                this.f1456d.put(context, dVar);
            }
            dVar.m(j10, new WeakReference<>(constantState));
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    private void c(Context context, int i10, ColorStateList colorStateList) {
        if (this.f1453a == null) {
            this.f1453a = new WeakHashMap<>();
        }
        l.h<ColorStateList> hVar = this.f1453a.get(context);
        if (hVar == null) {
            hVar = new l.h<>();
            this.f1453a.put(context, hVar);
        }
        hVar.a(i10, colorStateList);
    }

    private void d(Context context) {
        if (this.f1458f) {
            return;
        }
        this.f1458f = true;
        Drawable j10 = j(context, h.d.f10405a);
        if (j10 == null || !q(j10)) {
            this.f1458f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i10) {
        if (this.f1457e == null) {
            this.f1457e = new TypedValue();
        }
        TypedValue typedValue = this.f1457e;
        context.getResources().getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        f fVar = this.f1459g;
        Drawable c10 = fVar == null ? null : fVar.c(this, context, i10);
        if (c10 != null) {
            c10.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e10, c10);
        }
        return c10;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized o0 h() {
        o0 o0Var;
        synchronized (o0.class) {
            if (f1451i == null) {
                o0 o0Var2 = new o0();
                f1451i = o0Var2;
                p(o0Var2);
            }
            o0Var = f1451i;
        }
        return o0Var;
    }

    private synchronized Drawable i(Context context, long j10) {
        l.d<WeakReference<Drawable.ConstantState>> dVar = this.f1456d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> h10 = dVar.h(j10);
        if (h10 != null) {
            Drawable.ConstantState constantState = h10.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.n(j10);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter i11;
        synchronized (o0.class) {
            c cVar = f1452j;
            i11 = cVar.i(i10, mode);
            if (i11 == null) {
                i11 = new PorterDuffColorFilter(i10, mode);
                cVar.j(i10, mode, i11);
            }
        }
        return i11;
    }

    private ColorStateList n(Context context, int i10) {
        l.h<ColorStateList> hVar;
        WeakHashMap<Context, l.h<ColorStateList>> weakHashMap = this.f1453a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.h(i10);
    }

    private static void p(o0 o0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            o0Var.a("vector", new g());
            o0Var.a("animated-vector", new b());
            o0Var.a("animated-selector", new a());
            o0Var.a("drawable", new d());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.h) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i10) {
        int next;
        l.g<String, e> gVar = this.f1454b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        l.h<String> hVar = this.f1455c;
        if (hVar != null) {
            String h10 = hVar.h(i10);
            if ("appcompat_skip_skip".equals(h10) || (h10 != null && this.f1454b.get(h10) == null)) {
                return null;
            }
        } else {
            this.f1455c = new l.h<>();
        }
        if (this.f1457e == null) {
            this.f1457e = new TypedValue();
        }
        TypedValue typedValue = this.f1457e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1455c.a(i10, name);
                e eVar = this.f1454b.get(name);
                if (eVar != null) {
                    i11 = eVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (i11 != null) {
                    i11.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, e10, i11);
                }
            } catch (Exception unused) {
            }
        }
        if (i11 == null) {
            this.f1455c.a(i10, "appcompat_skip_skip");
        }
        return i11;
    }

    private Drawable v(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList m10 = m(context, i10);
        if (m10 == null) {
            f fVar = this.f1459g;
            if ((fVar == null || !fVar.e(context, i10, drawable)) && !x(context, i10, drawable) && z10) {
                return null;
            }
            return drawable;
        }
        if (g0.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable q10 = androidx.core.graphics.drawable.a.q(drawable);
        androidx.core.graphics.drawable.a.o(q10, m10);
        PorterDuff.Mode o10 = o(i10);
        if (o10 == null) {
            return q10;
        }
        androidx.core.graphics.drawable.a.p(q10, o10);
        return q10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Drawable drawable, w0 w0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (g0.a(drawable)) {
            if (!(drawable.mutate() == drawable)) {
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = w0Var.f1537d;
        if (z10 || w0Var.f1536c) {
            drawable.setColorFilter(g(z10 ? w0Var.f1534a : null, w0Var.f1536c ? w0Var.f1535b : f1450h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i10) {
        return k(context, i10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i10, boolean z10) {
        Drawable r10;
        d(context);
        r10 = r(context, i10);
        if (r10 == null) {
            r10 = f(context, i10);
        }
        if (r10 == null) {
            r10 = androidx.core.content.a.f(context, i10);
        }
        if (r10 != null) {
            r10 = v(context, i10, z10, r10);
        }
        if (r10 != null) {
            g0.b(r10);
        }
        return r10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i10) {
        ColorStateList n10;
        n10 = n(context, i10);
        if (n10 == null) {
            f fVar = this.f1459g;
            n10 = fVar == null ? null : fVar.d(context, i10);
            if (n10 != null) {
                c(context, i10, n10);
            }
        }
        return n10;
    }

    PorterDuff.Mode o(int i10) {
        f fVar = this.f1459g;
        if (fVar == null) {
            return null;
        }
        return fVar.b(i10);
    }

    public synchronized void s(Context context) {
        l.d<WeakReference<Drawable.ConstantState>> dVar = this.f1456d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, g1 g1Var, int i10) {
        Drawable r10 = r(context, i10);
        if (r10 == null) {
            r10 = g1Var.a(i10);
        }
        if (r10 == null) {
            return null;
        }
        return v(context, i10, false, r10);
    }

    public synchronized void u(f fVar) {
        this.f1459g = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Context context, int i10, Drawable drawable) {
        f fVar = this.f1459g;
        return fVar != null && fVar.a(context, i10, drawable);
    }
}
