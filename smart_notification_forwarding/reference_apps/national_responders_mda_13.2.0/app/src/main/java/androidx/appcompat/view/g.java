package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.y0;
import androidx.core.view.k;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class<?>[] f770e;

    /* renamed from: f, reason: collision with root package name */
    static final Class<?>[] f771f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f772a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f773b;

    /* renamed from: c, reason: collision with root package name */
    Context f774c;

    /* renamed from: d, reason: collision with root package name */
    private Object f775d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?>[] f776c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f777a;

        /* renamed from: b, reason: collision with root package name */
        private Method f778b;

        public a(Object obj, String str) {
            this.f777a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f778b = cls.getMethod(str, f776c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f778b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f778b.invoke(this.f777a, menuItem)).booleanValue();
                }
                this.f778b.invoke(this.f777a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f779a;

        /* renamed from: b, reason: collision with root package name */
        private int f780b;

        /* renamed from: c, reason: collision with root package name */
        private int f781c;

        /* renamed from: d, reason: collision with root package name */
        private int f782d;

        /* renamed from: e, reason: collision with root package name */
        private int f783e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f784f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f785g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f786h;

        /* renamed from: i, reason: collision with root package name */
        private int f787i;

        /* renamed from: j, reason: collision with root package name */
        private int f788j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f789k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f790l;

        /* renamed from: m, reason: collision with root package name */
        private int f791m;

        /* renamed from: n, reason: collision with root package name */
        private char f792n;

        /* renamed from: o, reason: collision with root package name */
        private int f793o;

        /* renamed from: p, reason: collision with root package name */
        private char f794p;

        /* renamed from: q, reason: collision with root package name */
        private int f795q;

        /* renamed from: r, reason: collision with root package name */
        private int f796r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f797s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f798t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f799u;

        /* renamed from: v, reason: collision with root package name */
        private int f800v;

        /* renamed from: w, reason: collision with root package name */
        private int f801w;

        /* renamed from: x, reason: collision with root package name */
        private String f802x;

        /* renamed from: y, reason: collision with root package name */
        private String f803y;

        /* renamed from: z, reason: collision with root package name */
        private String f804z;

        public b(Menu menu) {
            this.f779a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f774c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot instantiate class: ");
                sb2.append(str);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z10 = false;
            menuItem.setChecked(this.f797s).setVisible(this.f798t).setEnabled(this.f799u).setCheckable(this.f796r >= 1).setTitleCondensed(this.f790l).setIcon(this.f791m);
            int i10 = this.f800v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f804z != null) {
                if (g.this.f774c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f804z));
            }
            if (this.f796r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.f802x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f770e, g.this.f772a));
                z10 = true;
            }
            int i11 = this.f801w;
            if (i11 > 0 && !z10) {
                menuItem.setActionView(i11);
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                k.a(menuItem, bVar);
            }
            k.c(menuItem, this.B);
            k.g(menuItem, this.C);
            k.b(menuItem, this.f792n, this.f793o);
            k.f(menuItem, this.f794p, this.f795q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                k.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                k.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f786h = true;
            i(this.f779a.add(this.f780b, this.f787i, this.f788j, this.f789k));
        }

        public SubMenu b() {
            this.f786h = true;
            SubMenu addSubMenu = this.f779a.addSubMenu(this.f780b, this.f787i, this.f788j, this.f789k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f786h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f774c.obtainStyledAttributes(attributeSet, e.j.f9039j1);
            this.f780b = obtainStyledAttributes.getResourceId(e.j.f9049l1, 0);
            this.f781c = obtainStyledAttributes.getInt(e.j.f9059n1, 0);
            this.f782d = obtainStyledAttributes.getInt(e.j.f9064o1, 0);
            this.f783e = obtainStyledAttributes.getInt(e.j.f9069p1, 0);
            this.f784f = obtainStyledAttributes.getBoolean(e.j.f9054m1, true);
            this.f785g = obtainStyledAttributes.getBoolean(e.j.f9044k1, true);
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(AttributeSet attributeSet) {
            y0 u10 = y0.u(g.this.f774c, attributeSet, e.j.f9074q1);
            this.f787i = u10.n(e.j.f9089t1, 0);
            this.f788j = (u10.k(e.j.f9104w1, this.f781c) & (-65536)) | (u10.k(e.j.f9109x1, this.f782d) & 65535);
            this.f789k = u10.p(e.j.f9114y1);
            this.f790l = u10.p(e.j.f9119z1);
            this.f791m = u10.n(e.j.f9079r1, 0);
            this.f792n = c(u10.o(e.j.A1));
            this.f793o = u10.k(e.j.H1, 4096);
            this.f794p = c(u10.o(e.j.B1));
            this.f795q = u10.k(e.j.L1, 4096);
            int i10 = e.j.C1;
            this.f796r = u10.s(i10) ? u10.a(i10, false) : this.f783e;
            this.f797s = u10.a(e.j.f9094u1, false);
            this.f798t = u10.a(e.j.f9099v1, this.f784f);
            this.f799u = u10.a(e.j.f9084s1, this.f785g);
            this.f800v = u10.k(e.j.M1, -1);
            this.f804z = u10.o(e.j.D1);
            this.f801w = u10.n(e.j.E1, 0);
            this.f802x = u10.o(e.j.G1);
            String o10 = u10.o(e.j.F1);
            this.f803y = o10;
            if ((o10 != null) && this.f801w == 0 && this.f802x == null) {
                this.A = (androidx.core.view.b) e(o10, g.f771f, g.this.f773b);
            } else {
                this.A = null;
            }
            this.B = u10.p(e.j.I1);
            this.C = u10.p(e.j.N1);
            int i11 = e.j.K1;
            if (u10.s(i11)) {
                this.E = g0.d(u10.k(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = e.j.J1;
            if (u10.s(i12)) {
                this.D = u10.c(i12);
            } else {
                this.D = null;
            }
            u10.w();
            this.f786h = false;
        }

        public void h() {
            this.f780b = 0;
            this.f781c = 0;
            this.f782d = 0;
            this.f783e = 0;
            this.f784f = true;
            this.f785g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f770e = clsArr;
        f771f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f774c = context;
        Object[] objArr = {context};
        this.f772a = objArr;
        this.f773b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.a() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals("item") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
            r12 = this;
            androidx.appcompat.view.g$b r0 = new androidx.appcompat.view.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r4
            r6 = 0
            r7 = 0
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r4
            r7 = 0
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            androidx.core.view.b r15 = r0.A
            if (r15 == 0) goto L82
            boolean r15 = r15.a()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = 1
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = 1
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object b() {
        if (this.f775d == null) {
            this.f775d = a(this.f774c);
        }
        return this.f775d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof u.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f774c.getResources().getLayout(i10);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
