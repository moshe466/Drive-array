package h;

import F0.C0035g2;
import F0.G1;
import F0.b3;
import J.S;
import J.X;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import g.AbstractC0424a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import k.AbstractC0458b;
import k.C0461e;
import k.C0466j;
import m.C0540e;
import m.C0548i;
import m.C0567s;
import m.InterfaceC0557m0;
import m.s1;
import m.z1;
import t.C0694j;

/* loaded from: classes.dex */
public final class y extends o implements l.k, LayoutInflater.Factory2 {

    /* renamed from: k0, reason: collision with root package name */
    public static final C0694j f4871k0 = new C0694j(0);

    /* renamed from: l0, reason: collision with root package name */
    public static final int[] f4872l0 = {R.attr.windowBackground};

    /* renamed from: m0, reason: collision with root package name */
    public static final boolean f4873m0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: n0, reason: collision with root package name */
    public static final boolean f4874n0 = true;

    /* renamed from: A, reason: collision with root package name */
    public p f4875A;

    /* renamed from: C, reason: collision with root package name */
    public boolean f4877C;

    /* renamed from: D, reason: collision with root package name */
    public ViewGroup f4878D;

    /* renamed from: E, reason: collision with root package name */
    public TextView f4879E;

    /* renamed from: F, reason: collision with root package name */
    public View f4880F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f4881G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f4882H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f4883I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f4884J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f4885K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f4886L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f4887M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f4888N;

    /* renamed from: O, reason: collision with root package name */
    public x[] f4889O;

    /* renamed from: P, reason: collision with root package name */
    public x f4890P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f4891Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f4892R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f4893S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f4894T;

    /* renamed from: U, reason: collision with root package name */
    public Configuration f4895U;

    /* renamed from: V, reason: collision with root package name */
    public final int f4896V;

    /* renamed from: W, reason: collision with root package name */
    public int f4897W;

    /* renamed from: X, reason: collision with root package name */
    public int f4898X;

    /* renamed from: Y, reason: collision with root package name */
    public boolean f4899Y;

    /* renamed from: Z, reason: collision with root package name */
    public v f4900Z;

    /* renamed from: a0, reason: collision with root package name */
    public v f4901a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f4902b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f4903c0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f4905e0;

    /* renamed from: f0, reason: collision with root package name */
    public Rect f4906f0;

    /* renamed from: g0, reason: collision with root package name */
    public Rect f4907g0;

    /* renamed from: h0, reason: collision with root package name */
    public C0430B f4908h0;

    /* renamed from: i0, reason: collision with root package name */
    public OnBackInvokedDispatcher f4909i0;

    /* renamed from: j0, reason: collision with root package name */
    public OnBackInvokedCallback f4910j0;

    /* renamed from: m, reason: collision with root package name */
    public final Object f4911m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f4912n;

    /* renamed from: o, reason: collision with root package name */
    public Window f4913o;
    public u p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f4914q;

    /* renamed from: r, reason: collision with root package name */
    public AbstractC0431a f4915r;

    /* renamed from: s, reason: collision with root package name */
    public C0466j f4916s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f4917t;

    /* renamed from: u, reason: collision with root package name */
    public InterfaceC0557m0 f4918u;

    /* renamed from: v, reason: collision with root package name */
    public C0035g2 f4919v;

    /* renamed from: w, reason: collision with root package name */
    public q f4920w;

    /* renamed from: x, reason: collision with root package name */
    public AbstractC0458b f4921x;
    public ActionBarContextView y;

    /* renamed from: z, reason: collision with root package name */
    public PopupWindow f4922z;

    /* renamed from: B, reason: collision with root package name */
    public X f4876B = null;

    /* renamed from: d0, reason: collision with root package name */
    public final p f4904d0 = new p(this, 0);

    public y(Context context, Window window, InterfaceC0442l interfaceC0442l, Object obj) {
        AbstractActivityC0441k abstractActivityC0441k = null;
        this.f4896V = -100;
        this.f4912n = context;
        this.f4914q = interfaceC0442l;
        this.f4911m = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (context instanceof AbstractActivityC0441k) {
                        abstractActivityC0441k = (AbstractActivityC0441k) context;
                        break;
                    } else if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    break;
                }
            }
            if (abstractActivityC0441k != null) {
                this.f4896V = ((y) abstractActivityC0441k.getDelegate()).f4896V;
            }
        }
        if (this.f4896V == -100) {
            String name = this.f4911m.getClass().getName();
            C0694j c0694j = f4871k0;
            Integer num = (Integer) c0694j.get(name);
            if (num != null) {
                this.f4896V = num.intValue();
                c0694j.remove(this.f4911m.getClass().getName());
            }
        }
        if (window != null) {
            o(window);
        }
        C0567s.c();
    }

    public static F.f p(Context context) {
        F.f fVar;
        F.f fVar2;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 33 || (fVar = o.f4835c) == null) {
            return null;
        }
        F.g gVar = fVar.f162a;
        F.f b4 = s.b(context.getApplicationContext().getResources().getConfiguration());
        if (gVar.f163a.isEmpty()) {
            fVar2 = F.f.f161b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i = 0; i < b4.f162a.f163a.size() + gVar.f163a.size(); i++) {
                if (i < gVar.f163a.size()) {
                    locale = gVar.f163a.get(i);
                } else {
                    locale = b4.f162a.f163a.get(i - gVar.f163a.size());
                }
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
            }
            fVar2 = new F.f(new F.g(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        if (fVar2.f162a.f163a.isEmpty()) {
            return b4;
        }
        return fVar2;
    }

    public static Configuration t(Context context, int i, F.f fVar, Configuration configuration, boolean z3) {
        int i3;
        if (i != 1) {
            if (i != 2) {
                if (z3) {
                    i3 = 0;
                } else {
                    i3 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                }
            } else {
                i3 = 32;
            }
        } else {
            i3 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (fVar != null) {
            s.d(configuration2, fVar);
        }
        return configuration2;
    }

    public final void A() {
        w();
        if (this.f4883I && this.f4915r == null) {
            Object obj = this.f4911m;
            if (obj instanceof Activity) {
                this.f4915r = new N((Activity) obj, this.f4884J);
            } else if (obj instanceof Dialog) {
                this.f4915r = new N((Dialog) obj);
            }
            AbstractC0431a abstractC0431a = this.f4915r;
            if (abstractC0431a != null) {
                abstractC0431a.o(this.f4905e0);
            }
        }
    }

    public final void B(int i) {
        this.f4903c0 = (1 << i) | this.f4903c0;
        if (!this.f4902b0) {
            View decorView = this.f4913o.getDecorView();
            WeakHashMap weakHashMap = S.f954a;
            decorView.postOnAnimation(this.f4904d0);
            this.f4902b0 = true;
        }
    }

    public final int C(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i == 3) {
                            if (this.f4901a0 == null) {
                                this.f4901a0 = new v(this, context);
                            }
                            return this.f4901a0.g();
                        }
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return y(context).g();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean D() {
        boolean z3 = this.f4891Q;
        this.f4891Q = false;
        x z4 = z(0);
        if (z4.f4868m) {
            if (!z3) {
                s(z4, true);
                return true;
            }
        } else {
            AbstractC0458b abstractC0458b = this.f4921x;
            if (abstractC0458b != null) {
                abstractC0458b.a();
                return true;
            }
            A();
            AbstractC0431a abstractC0431a = this.f4915r;
            if (abstractC0431a == null || !abstractC0431a.b()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        if (r2.f5392f.getCount() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0155, code lost:
    
        if (r2 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(h.x r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.E(h.x, android.view.KeyEvent):void");
    }

    public final boolean F(x xVar, int i, KeyEvent keyEvent) {
        l.m mVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((!xVar.f4866k && !G(xVar, keyEvent)) || (mVar = xVar.f4864h) == null) {
            return false;
        }
        return mVar.performShortcut(i, keyEvent, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d5, code lost:
    
        if (r13.f4864h == null) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G(h.x r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.G(h.x, android.view.KeyEvent):boolean");
    }

    public final void H() {
        if (!this.f4877C) {
        } else {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void I() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z3 = false;
            if (this.f4909i0 != null && (z(0).f4868m || this.f4921x != null)) {
                z3 = true;
            }
            if (z3 && this.f4910j0 == null) {
                this.f4910j0 = t.b(this.f4909i0, this);
            } else if (!z3 && (onBackInvokedCallback = this.f4910j0) != null) {
                t.c(this.f4909i0, onBackInvokedCallback);
            }
        }
    }

    @Override // h.o
    public final void a() {
        if (this.f4915r != null) {
            A();
            if (!this.f4915r.g()) {
                B(0);
            }
        }
    }

    @Override // h.o
    public final void c() {
        String str;
        this.f4892R = true;
        n(false, true);
        x();
        Object obj = this.f4911m;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = m3.b.t(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e4) {
                    throw new IllegalArgumentException(e4);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                AbstractC0431a abstractC0431a = this.f4915r;
                if (abstractC0431a == null) {
                    this.f4905e0 = true;
                } else {
                    abstractC0431a.o(true);
                }
            }
            synchronized (o.f4840k) {
                o.e(this);
                o.f4839j.add(new WeakReference(this));
            }
        }
        this.f4895U = new Configuration(this.f4912n.getResources().getConfiguration());
        this.f4893S = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // h.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4911m
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = h.o.f4840k
            monitor-enter(r0)
            h.o.e(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f4902b0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f4913o
            android.view.View r0 = r0.getDecorView()
            h.p r1 = r3.f4904d0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f4894T = r0
            int r0 = r3.f4896V
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f4911m
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            t.j r0 = h.y.f4871k0
            java.lang.Object r1 = r3.f4911m
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f4896V
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            t.j r0 = h.y.f4871k0
            java.lang.Object r1 = r3.f4911m
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            h.a r0 = r3.f4915r
            if (r0 == 0) goto L63
            r0.j()
        L63:
            h.v r0 = r3.f4900Z
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            h.v r0 = r3.f4901a0
            if (r0 == 0) goto L71
            r0.c()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.d():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r6.k() != false) goto L20;
     */
    @Override // l.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(l.m r6) {
        /*
            r5 = this;
            m.m0 r6 = r5.f4918u
            r0 = 1
            r1 = 0
            if (r6 == 0) goto Ld3
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.e()
            m.n0 r6 = r6.f2836e
            m.s1 r6 = (m.s1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f5772a
            int r2 = r6.getVisibility()
            if (r2 != 0) goto Ld3
            androidx.appcompat.widget.ActionMenuView r6 = r6.f2986a
            if (r6 == 0) goto Ld3
            boolean r6 = r6.f2860v
            if (r6 == 0) goto Ld3
            android.content.Context r6 = r5.f4912n
            android.view.ViewConfiguration r6 = android.view.ViewConfiguration.get(r6)
            boolean r6 = r6.hasPermanentMenuKey()
            if (r6 == 0) goto L4a
            m.m0 r6 = r5.f4918u
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.e()
            m.n0 r6 = r6.f2836e
            m.s1 r6 = (m.s1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f5772a
            androidx.appcompat.widget.ActionMenuView r6 = r6.f2986a
            if (r6 == 0) goto Ld3
            m.i r6 = r6.f2861w
            if (r6 == 0) goto Ld3
            m.g r2 = r6.f5687x
            if (r2 != 0) goto L4a
            boolean r6 = r6.k()
            if (r6 == 0) goto Ld3
        L4a:
            android.view.Window r6 = r5.f4913o
            android.view.Window$Callback r6 = r6.getCallback()
            m.m0 r2 = r5.f4918u
            androidx.appcompat.widget.ActionBarOverlayLayout r2 = (androidx.appcompat.widget.ActionBarOverlayLayout) r2
            r2.e()
            m.n0 r2 = r2.f2836e
            m.s1 r2 = (m.s1) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f5772a
            boolean r2 = r2.o()
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 == 0) goto L8c
            m.m0 r0 = r5.f4918u
            androidx.appcompat.widget.ActionBarOverlayLayout r0 = (androidx.appcompat.widget.ActionBarOverlayLayout) r0
            r0.e()
            m.n0 r0 = r0.f2836e
            m.s1 r0 = (m.s1) r0
            androidx.appcompat.widget.Toolbar r0 = r0.f5772a
            androidx.appcompat.widget.ActionMenuView r0 = r0.f2986a
            if (r0 == 0) goto L7e
            m.i r0 = r0.f2861w
            if (r0 == 0) goto L7e
            boolean r0 = r0.g()
        L7e:
            boolean r0 = r5.f4894T
            if (r0 != 0) goto Ld2
            h.x r0 = r5.z(r1)
            l.m r0 = r0.f4864h
            r6.onPanelClosed(r3, r0)
            return
        L8c:
            if (r6 == 0) goto Ld2
            boolean r2 = r5.f4894T
            if (r2 != 0) goto Ld2
            boolean r2 = r5.f4902b0
            if (r2 == 0) goto La9
            int r2 = r5.f4903c0
            r0 = r0 & r2
            if (r0 == 0) goto La9
            android.view.Window r0 = r5.f4913o
            android.view.View r0 = r0.getDecorView()
            h.p r2 = r5.f4904d0
            r0.removeCallbacks(r2)
            r2.run()
        La9:
            h.x r0 = r5.z(r1)
            l.m r2 = r0.f4864h
            if (r2 == 0) goto Ld2
            boolean r4 = r0.f4870o
            if (r4 != 0) goto Ld2
            android.view.View r4 = r0.f4863g
            boolean r1 = r6.onPreparePanel(r1, r4, r2)
            if (r1 == 0) goto Ld2
            l.m r0 = r0.f4864h
            r6.onMenuOpened(r3, r0)
            m.m0 r6 = r5.f4918u
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.e()
            m.n0 r6 = r6.f2836e
            m.s1 r6 = (m.s1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f5772a
            r6.u()
        Ld2:
            return
        Ld3:
            h.x r6 = r5.z(r1)
            r6.f4869n = r0
            r5.s(r6, r1)
            r0 = 0
            r5.E(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.f(l.m):void");
    }

    @Override // h.o
    public final boolean g(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.f4887M && i == 108) {
            return false;
        }
        if (this.f4883I && i == 1) {
            this.f4883I = false;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    if (i != 10) {
                        if (i != 108) {
                            if (i != 109) {
                                return this.f4913o.requestFeature(i);
                            }
                            H();
                            this.f4884J = true;
                            return true;
                        }
                        H();
                        this.f4883I = true;
                        return true;
                    }
                    H();
                    this.f4885K = true;
                    return true;
                }
                H();
                this.f4882H = true;
                return true;
            }
            H();
            this.f4881G = true;
            return true;
        }
        H();
        this.f4887M = true;
        return true;
    }

    @Override // h.o
    public final void h(int i) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.f4878D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f4912n).inflate(i, viewGroup);
        this.p.a(this.f4913o.getCallback());
    }

    @Override // l.k
    public final boolean i(l.m mVar, MenuItem menuItem) {
        int i;
        x xVar;
        Window.Callback callback = this.f4913o.getCallback();
        if (callback != null && !this.f4894T) {
            l.m k4 = mVar.k();
            x[] xVarArr = this.f4889O;
            if (xVarArr != null) {
                i = xVarArr.length;
            } else {
                i = 0;
            }
            int i3 = 0;
            while (true) {
                if (i3 < i) {
                    xVar = xVarArr[i3];
                    if (xVar != null && xVar.f4864h == k4) {
                        break;
                    }
                    i3++;
                } else {
                    xVar = null;
                    break;
                }
            }
            if (xVar != null) {
                return callback.onMenuItemSelected(xVar.f4857a, menuItem);
            }
        }
        return false;
    }

    @Override // h.o
    public final void j(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.f4878D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.p.a(this.f4913o.getCallback());
    }

    @Override // h.o
    public final void k(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.f4878D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.p.a(this.f4913o.getCallback());
    }

    @Override // h.o
    public final void l(CharSequence charSequence) {
        this.f4917t = charSequence;
        InterfaceC0557m0 interfaceC0557m0 = this.f4918u;
        if (interfaceC0557m0 != null) {
            interfaceC0557m0.setWindowTitle(charSequence);
            return;
        }
        AbstractC0431a abstractC0431a = this.f4915r;
        if (abstractC0431a != null) {
            abstractC0431a.s(charSequence);
            return;
        }
        TextView textView = this.f4879E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0196  */
    /* JADX WARN: Type inference failed for: r0v2, types: [F0.d0, java.lang.Object, k.a] */
    /* JADX WARN: Type inference failed for: r1v0, types: [h.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v14, types: [k.f, l.k, java.lang.Object, k.b] */
    @Override // h.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k.AbstractC0458b m(k.InterfaceC0457a r9) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.m(k.a):k.b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0228 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.n(boolean, boolean):boolean");
    }

    public final void o(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f4913o == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof u)) {
                u uVar = new u(this, callback);
                this.p = uVar;
                window.setCallback(uVar);
                Context context = this.f4912n;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f4872l0);
                if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                    C0567s a2 = C0567s.a();
                    synchronized (a2) {
                        drawable = a2.f5767a.d(context, resourceId, true);
                    }
                } else {
                    drawable = null;
                }
                if (drawable != null) {
                    window.setBackgroundDrawable(drawable);
                }
                obtainStyledAttributes.recycle();
                this.f4913o = window;
                if (Build.VERSION.SDK_INT >= 33 && (onBackInvokedDispatcher = this.f4909i0) == null) {
                    Object obj = this.f4911m;
                    if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f4910j0) != null) {
                        t.c(onBackInvokedDispatcher, onBackInvokedCallback);
                        this.f4910j0 = null;
                    }
                    if (obj instanceof Activity) {
                        Activity activity = (Activity) obj;
                        if (activity.getWindow() != null) {
                            this.f4909i0 = t.a(activity);
                            I();
                            return;
                        }
                    }
                    this.f4909i0 = null;
                    I();
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:64:0x01c2
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void q(int i, x xVar, l.m mVar) {
        if (mVar == null) {
            if (xVar == null && i >= 0) {
                x[] xVarArr = this.f4889O;
                if (i < xVarArr.length) {
                    xVar = xVarArr[i];
                }
            }
            if (xVar != null) {
                mVar = xVar.f4864h;
            }
        }
        if ((xVar == null || xVar.f4868m) && !this.f4894T) {
            u uVar = this.p;
            Window.Callback callback = this.f4913o.getCallback();
            uVar.getClass();
            try {
                uVar.f4851e = true;
                callback.onPanelClosed(i, mVar);
            } finally {
                uVar.f4851e = false;
            }
        }
    }

    public final void r(l.m mVar) {
        C0548i c0548i;
        if (this.f4888N) {
            return;
        }
        this.f4888N = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f4918u;
        actionBarOverlayLayout.e();
        ActionMenuView actionMenuView = ((s1) actionBarOverlayLayout.f2836e).f5772a.f2986a;
        if (actionMenuView != null && (c0548i = actionMenuView.f2861w) != null) {
            c0548i.g();
            C0540e c0540e = c0548i.f5686w;
            if (c0540e != null && c0540e.b()) {
                c0540e.i.dismiss();
            }
        }
        Window.Callback callback = this.f4913o.getCallback();
        if (callback != null && !this.f4894T) {
            callback.onPanelClosed(108, mVar);
        }
        this.f4888N = false;
    }

    public final void s(x xVar, boolean z3) {
        w wVar;
        InterfaceC0557m0 interfaceC0557m0;
        if (z3 && xVar.f4857a == 0 && (interfaceC0557m0 = this.f4918u) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0557m0;
            actionBarOverlayLayout.e();
            if (((s1) actionBarOverlayLayout.f2836e).f5772a.o()) {
                r(xVar.f4864h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f4912n.getSystemService("window");
        if (windowManager != null && xVar.f4868m && (wVar = xVar.f4861e) != null) {
            windowManager.removeView(wVar);
            if (z3) {
                q(xVar.f4857a, xVar, null);
            }
        }
        xVar.f4866k = false;
        xVar.f4867l = false;
        xVar.f4868m = false;
        xVar.f4862f = null;
        xVar.f4869n = true;
        if (this.f4890P == xVar) {
            this.f4890P = null;
        }
        if (xVar.f4857a == 0) {
            I();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4.dispatchKeyEvent(r7) != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f0, code lost:
    
        if (r7.g() != false) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.u(android.view.KeyEvent):boolean");
    }

    public final void v(int i) {
        x z3 = z(i);
        if (z3.f4864h != null) {
            Bundle bundle = new Bundle();
            z3.f4864h.t(bundle);
            if (bundle.size() > 0) {
                z3.p = bundle;
            }
            z3.f4864h.w();
            z3.f4864h.clear();
        }
        z3.f4870o = true;
        z3.f4869n = true;
        if ((i == 108 || i == 0) && this.f4918u != null) {
            x z4 = z(0);
            z4.f4866k = false;
            G(z4, null);
        }
    }

    public final void w() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.f4877C) {
            Context context2 = this.f4912n;
            int[] iArr = AbstractC0424a.f4635j;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            if (obtainStyledAttributes.hasValue(117)) {
                if (obtainStyledAttributes.getBoolean(126, false)) {
                    g(1);
                } else if (obtainStyledAttributes.getBoolean(117, false)) {
                    g(108);
                }
                if (obtainStyledAttributes.getBoolean(118, false)) {
                    g(109);
                }
                if (obtainStyledAttributes.getBoolean(119, false)) {
                    g(10);
                }
                this.f4886L = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                x();
                this.f4913o.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (!this.f4887M) {
                    if (this.f4886L) {
                        viewGroup = (ViewGroup) from.inflate(com.uh.sf.R.layout.abc_dialog_title_material, (ViewGroup) null);
                        this.f4884J = false;
                        this.f4883I = false;
                    } else if (this.f4883I) {
                        TypedValue typedValue = new TypedValue();
                        context2.getTheme().resolveAttribute(com.uh.sf.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            context = new C0461e(context2, typedValue.resourceId);
                        } else {
                            context = context2;
                        }
                        viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(com.uh.sf.R.layout.abc_screen_toolbar, (ViewGroup) null);
                        InterfaceC0557m0 interfaceC0557m0 = (InterfaceC0557m0) viewGroup.findViewById(com.uh.sf.R.id.decor_content_parent);
                        this.f4918u = interfaceC0557m0;
                        interfaceC0557m0.setWindowCallback(this.f4913o.getCallback());
                        if (this.f4884J) {
                            ((ActionBarOverlayLayout) this.f4918u).d(109);
                        }
                        if (this.f4881G) {
                            ((ActionBarOverlayLayout) this.f4918u).d(2);
                        }
                        if (this.f4882H) {
                            ((ActionBarOverlayLayout) this.f4918u).d(5);
                        }
                    } else {
                        viewGroup = null;
                    }
                } else {
                    viewGroup = this.f4885K ? (ViewGroup) from.inflate(com.uh.sf.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(com.uh.sf.R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (viewGroup != null) {
                    q qVar = new q(this);
                    WeakHashMap weakHashMap = S.f954a;
                    J.J.j(viewGroup, qVar);
                    if (this.f4918u == null) {
                        this.f4879E = (TextView) viewGroup.findViewById(com.uh.sf.R.id.title);
                    }
                    Method method = z1.f5853a;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, null);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.uh.sf.R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f4913o.findViewById(R.id.content);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(R.id.content);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.f4913o.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new G1(this, 16));
                    this.f4878D = viewGroup;
                    Object obj = this.f4911m;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f4917t;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        InterfaceC0557m0 interfaceC0557m02 = this.f4918u;
                        if (interfaceC0557m02 != null) {
                            interfaceC0557m02.setWindowTitle(charSequence);
                        } else {
                            AbstractC0431a abstractC0431a = this.f4915r;
                            if (abstractC0431a != null) {
                                abstractC0431a.s(charSequence);
                            } else {
                                TextView textView = this.f4879E;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f4878D.findViewById(R.id.content);
                    View decorView = this.f4913o.getDecorView();
                    contentFrameLayout2.f2874j.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    WeakHashMap weakHashMap2 = S.f954a;
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(iArr);
                    obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(122)) {
                        obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(123)) {
                        obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(120)) {
                        obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(121)) {
                        obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.f4877C = true;
                    x z3 = z(0);
                    if (!this.f4894T && z3.f4864h == null) {
                        B(108);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f4883I + ", windowActionBarOverlay: " + this.f4884J + ", android:windowIsFloating: " + this.f4886L + ", windowActionModeOverlay: " + this.f4885K + ", windowNoTitle: " + this.f4887M + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void x() {
        if (this.f4913o == null) {
            Object obj = this.f4911m;
            if (obj instanceof Activity) {
                o(((Activity) obj).getWindow());
            }
        }
        if (this.f4913o != null) {
        } else {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final M1.f y(Context context) {
        if (this.f4900Z == null) {
            if (b3.f467e == null) {
                Context applicationContext = context.getApplicationContext();
                b3.f467e = new b3(applicationContext, (LocationManager) applicationContext.getSystemService("location"), 9);
            }
            this.f4900Z = new v(this, b3.f467e);
        }
        return this.f4900Z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r2 <= r5) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [h.x, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h.x z(int r5) {
        /*
            r4 = this;
            h.x[] r0 = r4.f4889O
            r1 = 0
            if (r0 == 0) goto L8
            int r2 = r0.length
            if (r2 > r5) goto L15
        L8:
            int r2 = r5 + 1
            h.x[] r2 = new h.x[r2]
            if (r0 == 0) goto L12
            int r3 = r0.length
            java.lang.System.arraycopy(r0, r1, r2, r1, r3)
        L12:
            r4.f4889O = r2
            r0 = r2
        L15:
            r2 = r0[r5]
            if (r2 != 0) goto L24
            h.x r2 = new h.x
            r2.<init>()
            r2.f4857a = r5
            r2.f4869n = r1
            r0[r5] = r2
        L24:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.z(int):h.x");
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
