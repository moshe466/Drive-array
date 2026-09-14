package k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import l.p;
import l.t;

/* renamed from: k.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0465i {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f5119A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f5120B;

    /* renamed from: E, reason: collision with root package name */
    public final /* synthetic */ C0466j f5123E;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f5124a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5131h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f5132j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f5133k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f5134l;

    /* renamed from: m, reason: collision with root package name */
    public int f5135m;

    /* renamed from: n, reason: collision with root package name */
    public char f5136n;

    /* renamed from: o, reason: collision with root package name */
    public int f5137o;
    public char p;

    /* renamed from: q, reason: collision with root package name */
    public int f5138q;

    /* renamed from: r, reason: collision with root package name */
    public int f5139r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5140s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5141t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5142u;

    /* renamed from: v, reason: collision with root package name */
    public int f5143v;

    /* renamed from: w, reason: collision with root package name */
    public int f5144w;

    /* renamed from: x, reason: collision with root package name */
    public String f5145x;
    public String y;

    /* renamed from: z, reason: collision with root package name */
    public p f5146z;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f5121C = null;

    /* renamed from: D, reason: collision with root package name */
    public PorterDuff.Mode f5122D = null;

    /* renamed from: b, reason: collision with root package name */
    public int f5125b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f5126c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f5127d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f5128e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5129f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5130g = true;

    public C0465i(C0466j c0466j, Menu menu) {
        this.f5123E = c0466j;
        this.f5124a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f5123E.f5151c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [android.view.MenuItem$OnMenuItemClickListener, k.h, java.lang.Object] */
    public final void b(MenuItem menuItem) {
        boolean z3;
        MenuItem enabled = menuItem.setChecked(this.f5140s).setVisible(this.f5141t).setEnabled(this.f5142u);
        boolean z4 = false;
        if (this.f5139r >= 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        enabled.setCheckable(z3).setTitleCondensed(this.f5134l).setIcon(this.f5135m);
        int i = this.f5143v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        String str = this.y;
        C0466j c0466j = this.f5123E;
        if (str != null) {
            if (!c0466j.f5151c.isRestricted()) {
                if (c0466j.f5152d == null) {
                    c0466j.f5152d = C0466j.a(c0466j.f5151c);
                }
                Object obj = c0466j.f5152d;
                String str2 = this.y;
                ?? obj2 = new Object();
                obj2.f5117a = obj;
                Class<?> cls = obj.getClass();
                try {
                    obj2.f5118b = cls.getMethod(str2, MenuItemOnMenuItemClickListenerC0464h.f5116c);
                    menuItem.setOnMenuItemClickListener(obj2);
                } catch (Exception e4) {
                    InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str2 + " in class " + cls.getName());
                    inflateException.initCause(e4);
                    throw inflateException;
                }
            } else {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
        }
        if (this.f5139r >= 2) {
            if (menuItem instanceof l.o) {
                l.o oVar = (l.o) menuItem;
                oVar.f5449x = (oVar.f5449x & (-5)) | 4;
            } else if (menuItem instanceof t) {
                t tVar = (t) menuItem;
                D.a aVar = tVar.f5458c;
                try {
                    if (tVar.f5459d == null) {
                        tVar.f5459d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    tVar.f5459d.invoke(aVar, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
        String str3 = this.f5145x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, C0466j.f5147e, c0466j.f5149a));
            z4 = true;
        }
        int i3 = this.f5144w;
        if (i3 > 0 && !z4) {
            menuItem.setActionView(i3);
        }
        p pVar = this.f5146z;
        if (pVar != null && (menuItem instanceof D.a)) {
            ((D.a) menuItem).a(pVar);
        }
        CharSequence charSequence = this.f5119A;
        boolean z5 = menuItem instanceof D.a;
        if (z5) {
            ((D.a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B.a.n(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f5120B;
        if (z5) {
            ((D.a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B.a.v(menuItem, charSequence2);
        }
        char c4 = this.f5136n;
        int i4 = this.f5137o;
        if (z5) {
            ((D.a) menuItem).setAlphabeticShortcut(c4, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B.a.l(menuItem, c4, i4);
        }
        char c5 = this.p;
        int i5 = this.f5138q;
        if (z5) {
            ((D.a) menuItem).setNumericShortcut(c5, i5);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B.a.r(menuItem, c5, i5);
        }
        PorterDuff.Mode mode = this.f5122D;
        if (mode != null) {
            if (z5) {
                ((D.a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                B.a.q(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f5121C;
        if (colorStateList != null) {
            if (z5) {
                ((D.a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                B.a.p(menuItem, colorStateList);
            }
        }
    }
}
