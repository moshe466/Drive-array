package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.g1;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.y0;
import androidx.core.content.res.h;
import androidx.core.view.a0;
import androidx.core.view.f;
import androidx.core.view.g0;
import androidx.core.view.k0;
import androidx.lifecycle.h;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends androidx.appcompat.app.e implements g.a, LayoutInflater.Factory2 {

    /* renamed from: g0, reason: collision with root package name */
    private static final l.g<String, Integer> f614g0 = new l.g<>();

    /* renamed from: h0, reason: collision with root package name */
    private static final boolean f615h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final int[] f616i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final boolean f617j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final boolean f618k0;

    /* renamed from: l0, reason: collision with root package name */
    private static boolean f619l0;
    ViewGroup A;
    private TextView B;
    private View C;
    private boolean D;
    private boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    private boolean K;
    private u[] L;
    private u M;
    private boolean N;
    private boolean O;
    private boolean P;
    boolean Q;
    private Configuration R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private q W;
    private q X;
    boolean Y;
    int Z;

    /* renamed from: a0, reason: collision with root package name */
    private final Runnable f620a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f621b0;

    /* renamed from: c0, reason: collision with root package name */
    private Rect f622c0;

    /* renamed from: d0, reason: collision with root package name */
    private Rect f623d0;

    /* renamed from: e0, reason: collision with root package name */
    private androidx.appcompat.app.i f624e0;

    /* renamed from: f0, reason: collision with root package name */
    private androidx.appcompat.app.j f625f0;

    /* renamed from: i, reason: collision with root package name */
    final Object f626i;

    /* renamed from: j, reason: collision with root package name */
    final Context f627j;

    /* renamed from: k, reason: collision with root package name */
    Window f628k;

    /* renamed from: l, reason: collision with root package name */
    private o f629l;

    /* renamed from: m, reason: collision with root package name */
    final androidx.appcompat.app.d f630m;

    /* renamed from: n, reason: collision with root package name */
    androidx.appcompat.app.a f631n;

    /* renamed from: o, reason: collision with root package name */
    MenuInflater f632o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f633p;

    /* renamed from: q, reason: collision with root package name */
    private e0 f634q;

    /* renamed from: r, reason: collision with root package name */
    private i f635r;

    /* renamed from: s, reason: collision with root package name */
    private v f636s;

    /* renamed from: t, reason: collision with root package name */
    androidx.appcompat.view.b f637t;

    /* renamed from: u, reason: collision with root package name */
    ActionBarContextView f638u;

    /* renamed from: v, reason: collision with root package name */
    PopupWindow f639v;

    /* renamed from: w, reason: collision with root package name */
    Runnable f640w;

    /* renamed from: x, reason: collision with root package name */
    g0 f641x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f642y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f643z;

    /* loaded from: classes.dex */
    class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f644a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f644a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f644a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f644a.uncaughtException(thread, notFoundException);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if ((fVar.Z & 1) != 0) {
                fVar.U(0);
            }
            f fVar2 = f.this;
            if ((fVar2.Z & 4096) != 0) {
                fVar2.U(108);
            }
            f fVar3 = f.this;
            fVar3.Y = false;
            fVar3.Z = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements androidx.core.view.u {
        c() {
        }

        @Override // androidx.core.view.u
        public k0 a(View view, k0 k0Var) {
            int k10 = k0Var.k();
            int L0 = f.this.L0(k0Var, null);
            if (k10 != L0) {
                k0Var = k0Var.o(k0Var.i(), L0, k0Var.j(), k0Var.h());
            }
            return a0.a0(view, k0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements i0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.i0.a
        public void a(Rect rect) {
            rect.top = f.this.L0(null, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            f.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.app.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0019f implements Runnable {

        /* renamed from: androidx.appcompat.app.f$f$a */
        /* loaded from: classes.dex */
        class a extends androidx.core.view.i0 {
            a() {
            }

            @Override // androidx.core.view.h0
            public void b(View view) {
                f.this.f638u.setAlpha(1.0f);
                f.this.f641x.h(null);
                f.this.f641x = null;
            }

            @Override // androidx.core.view.i0, androidx.core.view.h0
            public void c(View view) {
                f.this.f638u.setVisibility(0);
            }
        }

        RunnableC0019f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.f639v.showAtLocation(fVar.f638u, 55, 0, 0);
            f.this.V();
            if (!f.this.D0()) {
                f.this.f638u.setAlpha(1.0f);
                f.this.f638u.setVisibility(0);
            } else {
                f.this.f638u.setAlpha(0.0f);
                f fVar2 = f.this;
                fVar2.f641x = a0.c(fVar2.f638u).b(1.0f);
                f.this.f641x.h(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends androidx.core.view.i0 {
        g() {
        }

        @Override // androidx.core.view.h0
        public void b(View view) {
            f.this.f638u.setAlpha(1.0f);
            f.this.f641x.h(null);
            f.this.f641x = null;
        }

        @Override // androidx.core.view.i0, androidx.core.view.h0
        public void c(View view) {
            f.this.f638u.setVisibility(0);
            if (f.this.f638u.getParent() instanceof View) {
                a0.g0((View) f.this.f638u.getParent());
            }
        }
    }

    /* loaded from: classes.dex */
    interface h {
        boolean a(int i10);

        View onCreatePanelView(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class i implements m.a {
        i() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z10) {
            f.this.L(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback f02 = f.this.f0();
            if (f02 == null) {
                return true;
            }
            f02.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f653a;

        /* loaded from: classes.dex */
        class a extends androidx.core.view.i0 {
            a() {
            }

            @Override // androidx.core.view.h0
            public void b(View view) {
                f.this.f638u.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.f639v;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.f638u.getParent() instanceof View) {
                    a0.g0((View) f.this.f638u.getParent());
                }
                f.this.f638u.k();
                f.this.f641x.h(null);
                f fVar2 = f.this;
                fVar2.f641x = null;
                a0.g0(fVar2.A);
            }
        }

        public j(b.a aVar) {
            this.f653a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            a0.g0(f.this.A);
            return this.f653a.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public void b(androidx.appcompat.view.b bVar) {
            this.f653a.b(bVar);
            f fVar = f.this;
            if (fVar.f639v != null) {
                fVar.f628k.getDecorView().removeCallbacks(f.this.f640w);
            }
            f fVar2 = f.this;
            if (fVar2.f638u != null) {
                fVar2.V();
                f fVar3 = f.this;
                fVar3.f641x = a0.c(fVar3.f638u).b(0.0f);
                f.this.f641x.h(new a());
            }
            f fVar4 = f.this;
            androidx.appcompat.app.d dVar = fVar4.f630m;
            if (dVar != null) {
                dVar.p(fVar4.f637t);
            }
            f fVar5 = f.this;
            fVar5.f637t = null;
            a0.g0(fVar5.A);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f653a.c(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f653a.d(bVar, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class k {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }
    }

    /* loaded from: classes.dex */
    static class l {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends androidx.appcompat.view.i {

        /* renamed from: g, reason: collision with root package name */
        private h f656g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f657h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f658i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f659j;

        o(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f658i = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f658i = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f657h = true;
                callback.onContentChanged();
            } finally {
                this.f657h = false;
            }
        }

        public void d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f659j = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f659j = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f658i ? a().dispatchKeyEvent(keyEvent) : f.this.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.r0(keyEvent.getKeyCode(), keyEvent);
        }

        final ActionMode e(ActionMode.Callback callback) {
            f.a aVar = new f.a(f.this.f627j, callback);
            androidx.appcompat.view.b F0 = f.this.F0(aVar);
            if (F0 != null) {
                return aVar.e(F0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f657h) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            View onCreatePanelView;
            h hVar = this.f656g;
            return (hVar == null || (onCreatePanelView = hVar.onCreatePanelView(i10)) == null) ? super.onCreatePanelView(i10) : onCreatePanelView;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            f.this.u0(i10);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            if (this.f659j) {
                a().onPanelClosed(i10, menu);
            } else {
                super.onPanelClosed(i10, menu);
                f.this.v0(i10);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i10 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.a0(true);
            }
            h hVar = this.f656g;
            boolean z10 = hVar != null && hVar.a(i10);
            if (!z10) {
                z10 = super.onPreparePanel(i10, view, menu);
            }
            if (gVar != null) {
                gVar.a0(false);
            }
            return z10;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.g gVar;
            u d02 = f.this.d0(0, true);
            if (d02 == null || (gVar = d02.f678j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i10);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return f.this.m0() ? e(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            return (f.this.m0() && i10 == 0) ? e(callback) : super.onWindowStartingActionMode(callback, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class p extends q {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f661c;

        p(Context context) {
            super();
            this.f661c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.f.q
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.q
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !l.a(this.f661c)) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.f.q
        public void d() {
            f.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class q {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f663a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                q.this.d();
            }
        }

        q() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f663a;
            if (broadcastReceiver != null) {
                try {
                    f.this.f627j.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f663a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b10 = b();
            if (b10 == null || b10.countActions() == 0) {
                return;
            }
            if (this.f663a == null) {
                this.f663a = new a();
            }
            f.this.f627j.registerReceiver(this.f663a, b10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class r extends q {

        /* renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.m f666c;

        r(androidx.appcompat.app.m mVar) {
            super();
            this.f666c = mVar;
        }

        @Override // androidx.appcompat.app.f.q
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.q
        public int c() {
            return this.f666c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.f.q
        public void d() {
            f.this.F();
        }
    }

    /* loaded from: classes.dex */
    private static class s {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class t extends ContentFrameLayout {
        public t(Context context) {
            super(context);
        }

        private boolean c(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            f.this.N(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(f.a.b(getContext(), i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class u {

        /* renamed from: a, reason: collision with root package name */
        int f669a;

        /* renamed from: b, reason: collision with root package name */
        int f670b;

        /* renamed from: c, reason: collision with root package name */
        int f671c;

        /* renamed from: d, reason: collision with root package name */
        int f672d;

        /* renamed from: e, reason: collision with root package name */
        int f673e;

        /* renamed from: f, reason: collision with root package name */
        int f674f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f675g;

        /* renamed from: h, reason: collision with root package name */
        View f676h;

        /* renamed from: i, reason: collision with root package name */
        View f677i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.g f678j;

        /* renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.e f679k;

        /* renamed from: l, reason: collision with root package name */
        Context f680l;

        /* renamed from: m, reason: collision with root package name */
        boolean f681m;

        /* renamed from: n, reason: collision with root package name */
        boolean f682n;

        /* renamed from: o, reason: collision with root package name */
        boolean f683o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f684p;

        /* renamed from: q, reason: collision with root package name */
        boolean f685q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f686r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f687s;

        u(int i10) {
            this.f669a = i10;
        }

        androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.f678j == null) {
                return null;
            }
            if (this.f679k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f680l, e.g.f8965j);
                this.f679k = eVar;
                eVar.k(aVar);
                this.f678j.b(this.f679k);
            }
            return this.f679k.c(this.f675g);
        }

        public boolean b() {
            if (this.f676h == null) {
                return false;
            }
            return this.f677i != null || this.f679k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f678j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.O(this.f679k);
            }
            this.f678j = gVar;
            if (gVar == null || (eVar = this.f679k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(e.a.f8854a, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(e.a.E, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 == 0) {
                i11 = e.i.f8989b;
            }
            newTheme.applyStyle(i11, true);
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f680l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(e.j.f9098v0);
            this.f670b = obtainStyledAttributes.getResourceId(e.j.f9113y0, 0);
            this.f674f = obtainStyledAttributes.getResourceId(e.j.f9108x0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class v implements m.a {
        v() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z10) {
            androidx.appcompat.view.menu.g D = gVar.D();
            boolean z11 = D != gVar;
            f fVar = f.this;
            if (z11) {
                gVar = D;
            }
            u Y = fVar.Y(gVar);
            if (Y != null) {
                if (!z11) {
                    f.this.O(Y, z10);
                } else {
                    f.this.K(Y.f669a, Y, D);
                    f.this.O(Y, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback f02;
            if (gVar != gVar.D()) {
                return true;
            }
            f fVar = f.this;
            if (!fVar.F || (f02 = fVar.f0()) == null || f.this.Q) {
                return true;
            }
            f02.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = i10 < 21;
        f615h0 = z10;
        f616i0 = new int[]{R.attr.windowBackground};
        f617j0 = !"robolectric".equals(Build.FINGERPRINT);
        f618k0 = i10 >= 17;
        if (!z10 || f619l0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        f619l0 = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private f(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        l.g<String, Integer> gVar;
        Integer num;
        androidx.appcompat.app.c I0;
        this.f641x = null;
        this.f642y = true;
        this.S = -100;
        this.f620a0 = new b();
        this.f627j = context;
        this.f630m = dVar;
        this.f626i = obj;
        if (this.S == -100 && (obj instanceof Dialog) && (I0 = I0()) != null) {
            this.S = I0.n0().k();
        }
        if (this.S == -100 && (num = (gVar = f614g0).get(obj.getClass().getName())) != null) {
            this.S = num.intValue();
            gVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            I(window);
        }
        androidx.appcompat.widget.k.h();
    }

    private boolean A0(u uVar, KeyEvent keyEvent) {
        e0 e0Var;
        e0 e0Var2;
        e0 e0Var3;
        if (this.Q) {
            return false;
        }
        if (uVar.f681m) {
            return true;
        }
        u uVar2 = this.M;
        if (uVar2 != null && uVar2 != uVar) {
            O(uVar2, false);
        }
        Window.Callback f02 = f0();
        if (f02 != null) {
            uVar.f677i = f02.onCreatePanelView(uVar.f669a);
        }
        int i10 = uVar.f669a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (e0Var3 = this.f634q) != null) {
            e0Var3.d();
        }
        if (uVar.f677i == null) {
            if (z10) {
                y0();
            }
            androidx.appcompat.view.menu.g gVar = uVar.f678j;
            if (gVar == null || uVar.f686r) {
                if (gVar == null && (!j0(uVar) || uVar.f678j == null)) {
                    return false;
                }
                if (z10 && this.f634q != null) {
                    if (this.f635r == null) {
                        this.f635r = new i();
                    }
                    this.f634q.a(uVar.f678j, this.f635r);
                }
                uVar.f678j.d0();
                if (!f02.onCreatePanelMenu(uVar.f669a, uVar.f678j)) {
                    uVar.c(null);
                    if (z10 && (e0Var = this.f634q) != null) {
                        e0Var.a(null, this.f635r);
                    }
                    return false;
                }
                uVar.f686r = false;
            }
            uVar.f678j.d0();
            Bundle bundle = uVar.f687s;
            if (bundle != null) {
                uVar.f678j.P(bundle);
                uVar.f687s = null;
            }
            if (!f02.onPreparePanel(0, uVar.f677i, uVar.f678j)) {
                if (z10 && (e0Var2 = this.f634q) != null) {
                    e0Var2.a(null, this.f635r);
                }
                uVar.f678j.c0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            uVar.f684p = z11;
            uVar.f678j.setQwertyMode(z11);
            uVar.f678j.c0();
        }
        uVar.f681m = true;
        uVar.f682n = false;
        this.M = uVar;
        return true;
    }

    private void B0(boolean z10) {
        e0 e0Var = this.f634q;
        if (e0Var == null || !e0Var.h() || (ViewConfiguration.get(this.f627j).hasPermanentMenuKey() && !this.f634q.e())) {
            u d02 = d0(0, true);
            d02.f685q = true;
            O(d02, false);
            x0(d02, null);
            return;
        }
        Window.Callback f02 = f0();
        if (this.f634q.b() && z10) {
            this.f634q.f();
            if (this.Q) {
                return;
            }
            f02.onPanelClosed(108, d0(0, true).f678j);
            return;
        }
        if (f02 == null || this.Q) {
            return;
        }
        if (this.Y && (this.Z & 1) != 0) {
            this.f628k.getDecorView().removeCallbacks(this.f620a0);
            this.f620a0.run();
        }
        u d03 = d0(0, true);
        androidx.appcompat.view.menu.g gVar = d03.f678j;
        if (gVar == null || d03.f686r || !f02.onPreparePanel(0, d03.f677i, gVar)) {
            return;
        }
        f02.onMenuOpened(108, d03.f678j);
        this.f634q.g();
    }

    private int C0(int i10) {
        if (i10 == 8) {
            return 108;
        }
        if (i10 == 9) {
            return 109;
        }
        return i10;
    }

    private boolean E0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f628k.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || a0.R((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean G(boolean z10) {
        if (this.Q) {
            return false;
        }
        int J = J();
        boolean J0 = J0(n0(this.f627j, J), z10);
        if (J == 0) {
            c0(this.f627j).e();
        } else {
            q qVar = this.W;
            if (qVar != null) {
                qVar.a();
            }
        }
        if (J == 3) {
            b0(this.f627j).e();
        } else {
            q qVar2 = this.X;
            if (qVar2 != null) {
                qVar2.a();
            }
        }
        return J0;
    }

    private void H() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.A.findViewById(R.id.content);
        View decorView = this.f628k.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f627j.obtainStyledAttributes(e.j.f9098v0);
        obtainStyledAttributes.getValue(e.j.H0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(e.j.I0, contentFrameLayout.getMinWidthMinor());
        int i10 = e.j.F0;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = e.j.G0;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = e.j.D0;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = e.j.E0;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void H0() {
        if (this.f643z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void I(Window window) {
        if (this.f628k != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof o) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        o oVar = new o(callback);
        this.f629l = oVar;
        window.setCallback(oVar);
        y0 u10 = y0.u(this.f627j, null, f616i0);
        Drawable h10 = u10.h(0);
        if (h10 != null) {
            window.setBackgroundDrawable(h10);
        }
        u10.w();
        this.f628k = window;
    }

    private androidx.appcompat.app.c I0() {
        for (Context context = this.f627j; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.c) {
                return (androidx.appcompat.app.c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private int J() {
        int i10 = this.S;
        return i10 != -100 ? i10 : androidx.appcompat.app.e.j();
    }

    private boolean J0(int i10, boolean z10) {
        boolean z11 = false;
        Configuration P = P(this.f627j, i10, null, false);
        boolean l02 = l0(this.f627j);
        Configuration configuration = this.R;
        if (configuration == null) {
            configuration = this.f627j.getResources().getConfiguration();
        }
        int i11 = configuration.uiMode & 48;
        int i12 = P.uiMode & 48;
        boolean z12 = true;
        if (i11 != i12 && z10 && !l02 && this.O && (f617j0 || this.P)) {
            Object obj = this.f626i;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                androidx.core.app.b.m((Activity) this.f626i);
                z11 = true;
            }
        }
        if (z11 || i11 == i12) {
            z12 = z11;
        } else {
            K0(i12, l02, null);
        }
        if (z12) {
            Object obj2 = this.f626i;
            if (obj2 instanceof androidx.appcompat.app.c) {
                ((androidx.appcompat.app.c) obj2).r0(i10);
            }
        }
        return z12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K0(int i10, boolean z10, Configuration configuration) {
        Resources resources = this.f627j.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            androidx.appcompat.app.k.a(resources);
        }
        int i12 = this.T;
        if (i12 != 0) {
            this.f627j.setTheme(i12);
            if (i11 >= 23) {
                this.f627j.getTheme().applyStyle(this.T, true);
            }
        }
        if (z10) {
            Object obj = this.f626i;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.l) {
                    if (!((androidx.lifecycle.l) activity).b().b().isAtLeast(h.c.CREATED)) {
                        return;
                    }
                } else if (!this.P || this.Q) {
                    return;
                }
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    private void M() {
        q qVar = this.W;
        if (qVar != null) {
            qVar.a();
        }
        q qVar2 = this.X;
        if (qVar2 != null) {
            qVar2.a();
        }
    }

    private void M0(View view) {
        Context context;
        int i10;
        if ((a0.K(view) & 8192) != 0) {
            context = this.f627j;
            i10 = e.c.f8882b;
        } else {
            context = this.f627j;
            i10 = e.c.f8881a;
        }
        view.setBackgroundColor(androidx.core.content.a.d(context, i10));
    }

    private Configuration P(Context context, int i10, Configuration configuration, boolean z10) {
        int i11 = i10 != 1 ? i10 != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup Q() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f627j.obtainStyledAttributes(e.j.f9098v0);
        int i10 = e.j.A0;
        if (!obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(e.j.J0, false)) {
            z(1);
        } else if (obtainStyledAttributes.getBoolean(i10, false)) {
            z(108);
        }
        if (obtainStyledAttributes.getBoolean(e.j.B0, false)) {
            z(109);
        }
        if (obtainStyledAttributes.getBoolean(e.j.C0, false)) {
            z(10);
        }
        this.I = obtainStyledAttributes.getBoolean(e.j.f9103w0, false);
        obtainStyledAttributes.recycle();
        X();
        this.f628k.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f627j);
        if (this.J) {
            viewGroup = (ViewGroup) from.inflate(this.H ? e.g.f8970o : e.g.f8969n, (ViewGroup) null);
        } else if (this.I) {
            viewGroup = (ViewGroup) from.inflate(e.g.f8961f, (ViewGroup) null);
            this.G = false;
            this.F = false;
        } else if (this.F) {
            TypedValue typedValue = new TypedValue();
            this.f627j.getTheme().resolveAttribute(e.a.f8859f, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f627j, typedValue.resourceId) : this.f627j).inflate(e.g.f8971p, (ViewGroup) null);
            e0 e0Var = (e0) viewGroup.findViewById(e.f.f8945p);
            this.f634q = e0Var;
            e0Var.setWindowCallback(f0());
            if (this.G) {
                this.f634q.k(109);
            }
            if (this.D) {
                this.f634q.k(2);
            }
            if (this.E) {
                this.f634q.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.F + ", windowActionBarOverlay: " + this.G + ", android:windowIsFloating: " + this.I + ", windowActionModeOverlay: " + this.H + ", windowNoTitle: " + this.J + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a0.w0(viewGroup, new c());
        } else if (viewGroup instanceof i0) {
            ((i0) viewGroup).setOnFitSystemWindowsListener(new d());
        }
        if (this.f634q == null) {
            this.B = (TextView) viewGroup.findViewById(e.f.M);
        }
        h1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(e.f.f8931b);
        ViewGroup viewGroup2 = (ViewGroup) this.f628k.findViewById(R.id.content);
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
        this.f628k.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    private void W() {
        if (this.f643z) {
            return;
        }
        this.A = Q();
        CharSequence e02 = e0();
        if (!TextUtils.isEmpty(e02)) {
            e0 e0Var = this.f634q;
            if (e0Var != null) {
                e0Var.setWindowTitle(e02);
            } else if (y0() != null) {
                y0().z(e02);
            } else {
                TextView textView = this.B;
                if (textView != null) {
                    textView.setText(e02);
                }
            }
        }
        H();
        w0(this.A);
        this.f643z = true;
        u d02 = d0(0, false);
        if (this.Q) {
            return;
        }
        if (d02 == null || d02.f678j == null) {
            k0(108);
        }
    }

    private void X() {
        if (this.f628k == null) {
            Object obj = this.f626i;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.f628k == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration Z(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 24) {
                m.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i15 = configuration.touchscreen;
            int i16 = configuration2.touchscreen;
            if (i15 != i16) {
                configuration3.touchscreen = i16;
            }
            int i17 = configuration.keyboard;
            int i18 = configuration2.keyboard;
            if (i17 != i18) {
                configuration3.keyboard = i18;
            }
            int i19 = configuration.keyboardHidden;
            int i20 = configuration2.keyboardHidden;
            if (i19 != i20) {
                configuration3.keyboardHidden = i20;
            }
            int i21 = configuration.navigation;
            int i22 = configuration2.navigation;
            if (i21 != i22) {
                configuration3.navigation = i22;
            }
            int i23 = configuration.navigationHidden;
            int i24 = configuration2.navigationHidden;
            if (i23 != i24) {
                configuration3.navigationHidden = i24;
            }
            int i25 = configuration.orientation;
            int i26 = configuration2.orientation;
            if (i25 != i26) {
                configuration3.orientation = i26;
            }
            int i27 = configuration.screenLayout & 15;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 15)) {
                configuration3.screenLayout |= i28 & 15;
            }
            int i29 = configuration.screenLayout & 192;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 192)) {
                configuration3.screenLayout |= i30 & 192;
            }
            int i31 = configuration.screenLayout & 48;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 48)) {
                configuration3.screenLayout |= i32 & 48;
            }
            int i33 = configuration.screenLayout & 768;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & 768)) {
                configuration3.screenLayout |= i34 & 768;
            }
            if (i14 >= 26) {
                n.a(configuration, configuration2, configuration3);
            }
            int i35 = configuration.uiMode & 15;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 15)) {
                configuration3.uiMode |= i36 & 15;
            }
            int i37 = configuration.uiMode & 48;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 48)) {
                configuration3.uiMode |= i38 & 48;
            }
            int i39 = configuration.screenWidthDp;
            int i40 = configuration2.screenWidthDp;
            if (i39 != i40) {
                configuration3.screenWidthDp = i40;
            }
            int i41 = configuration.screenHeightDp;
            int i42 = configuration2.screenHeightDp;
            if (i41 != i42) {
                configuration3.screenHeightDp = i42;
            }
            int i43 = configuration.smallestScreenWidthDp;
            int i44 = configuration2.smallestScreenWidthDp;
            if (i43 != i44) {
                configuration3.smallestScreenWidthDp = i44;
            }
            if (i14 >= 17) {
                k.b(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private q b0(Context context) {
        if (this.X == null) {
            this.X = new p(context);
        }
        return this.X;
    }

    private q c0(Context context) {
        if (this.W == null) {
            this.W = new r(androidx.appcompat.app.m.a(context));
        }
        return this.W;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g0() {
        /*
            r3 = this;
            r3.W()
            boolean r0 = r3.F
            if (r0 == 0) goto L37
            androidx.appcompat.app.a r0 = r3.f631n
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.f626i
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            androidx.appcompat.app.n r0 = new androidx.appcompat.app.n
            java.lang.Object r1 = r3.f626i
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.G
            r0.<init>(r1, r2)
        L1d:
            r3.f631n = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            androidx.appcompat.app.n r0 = new androidx.appcompat.app.n
            java.lang.Object r1 = r3.f626i
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            androidx.appcompat.app.a r0 = r3.f631n
            if (r0 == 0) goto L37
            boolean r1 = r3.f621b0
            r0.u(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.g0():void");
    }

    private boolean h0(u uVar) {
        View view = uVar.f677i;
        if (view != null) {
            uVar.f676h = view;
            return true;
        }
        if (uVar.f678j == null) {
            return false;
        }
        if (this.f636s == null) {
            this.f636s = new v();
        }
        View view2 = (View) uVar.a(this.f636s);
        uVar.f676h = view2;
        return view2 != null;
    }

    private boolean i0(u uVar) {
        uVar.d(a0());
        uVar.f675g = new t(uVar.f680l);
        uVar.f671c = 81;
        return true;
    }

    private boolean j0(u uVar) {
        Context context = this.f627j;
        int i10 = uVar.f669a;
        if ((i10 == 0 || i10 == 108) && this.f634q != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(e.a.f8859f, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(e.a.f8860g, typedValue, true);
            } else {
                theme.resolveAttribute(e.a.f8860g, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.R(this);
        uVar.c(gVar);
        return true;
    }

    private void k0(int i10) {
        this.Z = (1 << i10) | this.Z;
        if (this.Y) {
            return;
        }
        a0.e0(this.f628k.getDecorView(), this.f620a0);
        this.Y = true;
    }

    private boolean l0(Context context) {
        if (!this.V && (this.f626i instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i10 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f626i.getClass()), i10 >= 29 ? 269221888 : i10 >= 24 ? 786432 : 0);
                this.U = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused) {
                this.U = false;
            }
        }
        this.V = true;
        return this.U;
    }

    private boolean q0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        u d02 = d0(i10, true);
        if (d02.f683o) {
            return false;
        }
        return A0(d02, keyEvent);
    }

    private boolean t0(int i10, KeyEvent keyEvent) {
        boolean z10;
        AudioManager audioManager;
        e0 e0Var;
        if (this.f637t != null) {
            return false;
        }
        boolean z11 = true;
        u d02 = d0(i10, true);
        if (i10 != 0 || (e0Var = this.f634q) == null || !e0Var.h() || ViewConfiguration.get(this.f627j).hasPermanentMenuKey()) {
            boolean z12 = d02.f683o;
            if (z12 || d02.f682n) {
                O(d02, true);
                z11 = z12;
            } else {
                if (d02.f681m) {
                    if (d02.f686r) {
                        d02.f681m = false;
                        z10 = A0(d02, keyEvent);
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        x0(d02, keyEvent);
                    }
                }
                z11 = false;
            }
        } else if (this.f634q.b()) {
            z11 = this.f634q.f();
        } else {
            if (!this.Q && A0(d02, keyEvent)) {
                z11 = this.f634q.g();
            }
            z11 = false;
        }
        if (z11 && (audioManager = (AudioManager) this.f627j.getApplicationContext().getSystemService("audio")) != null) {
            audioManager.playSoundEffect(0);
        }
        return z11;
    }

    private void x0(u uVar, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        if (uVar.f683o || this.Q) {
            return;
        }
        if (uVar.f669a == 0) {
            if ((this.f627j.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback f02 = f0();
        if (f02 != null && !f02.onMenuOpened(uVar.f669a, uVar.f678j)) {
            O(uVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f627j.getSystemService("window");
        if (windowManager != null && A0(uVar, keyEvent)) {
            ViewGroup viewGroup = uVar.f675g;
            if (viewGroup == null || uVar.f685q) {
                if (viewGroup == null) {
                    if (!i0(uVar) || uVar.f675g == null) {
                        return;
                    }
                } else if (uVar.f685q && viewGroup.getChildCount() > 0) {
                    uVar.f675g.removeAllViews();
                }
                if (!h0(uVar) || !uVar.b()) {
                    uVar.f685q = true;
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = uVar.f676h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                uVar.f675g.setBackgroundResource(uVar.f670b);
                ViewParent parent = uVar.f676h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(uVar.f676h);
                }
                uVar.f675g.addView(uVar.f676h, layoutParams2);
                if (!uVar.f676h.hasFocus()) {
                    uVar.f676h.requestFocus();
                }
            } else {
                View view = uVar.f677i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i10 = -1;
                    uVar.f682n = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i10, -2, uVar.f672d, uVar.f673e, 1002, 8519680, -3);
                    layoutParams3.gravity = uVar.f671c;
                    layoutParams3.windowAnimations = uVar.f674f;
                    windowManager.addView(uVar.f675g, layoutParams3);
                    uVar.f683o = true;
                }
            }
            i10 = -2;
            uVar.f682n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i10, -2, uVar.f672d, uVar.f673e, 1002, 8519680, -3);
            layoutParams32.gravity = uVar.f671c;
            layoutParams32.windowAnimations = uVar.f674f;
            windowManager.addView(uVar.f675g, layoutParams32);
            uVar.f683o = true;
        }
    }

    private boolean z0(u uVar, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.g gVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((uVar.f681m || A0(uVar, keyEvent)) && (gVar = uVar.f678j) != null) {
            z10 = gVar.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f634q == null) {
            O(uVar, true);
        }
        return z10;
    }

    @Override // androidx.appcompat.app.e
    public void A(int i10) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f627j).inflate(i10, viewGroup);
        this.f629l.c(this.f628k.getCallback());
    }

    @Override // androidx.appcompat.app.e
    public void B(View view) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f629l.c(this.f628k.getCallback());
    }

    @Override // androidx.appcompat.app.e
    public void C(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f629l.c(this.f628k.getCallback());
    }

    @Override // androidx.appcompat.app.e
    public void D(int i10) {
        this.T = i10;
    }

    final boolean D0() {
        ViewGroup viewGroup;
        return this.f643z && (viewGroup = this.A) != null && a0.S(viewGroup);
    }

    @Override // androidx.appcompat.app.e
    public final void E(CharSequence charSequence) {
        this.f633p = charSequence;
        e0 e0Var = this.f634q;
        if (e0Var != null) {
            e0Var.setWindowTitle(charSequence);
            return;
        }
        if (y0() != null) {
            y0().z(charSequence);
            return;
        }
        TextView textView = this.B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean F() {
        return G(true);
    }

    public androidx.appcompat.view.b F0(b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.f637t;
        if (bVar != null) {
            bVar.c();
        }
        j jVar = new j(aVar);
        androidx.appcompat.app.a m10 = m();
        if (m10 != null) {
            androidx.appcompat.view.b A = m10.A(jVar);
            this.f637t = A;
            if (A != null && (dVar = this.f630m) != null) {
                dVar.n(A);
            }
        }
        if (this.f637t == null) {
            this.f637t = G0(jVar);
        }
        return this.f637t;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.appcompat.view.b G0(androidx.appcompat.view.b.a r8) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.G0(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    void K(int i10, u uVar, Menu menu) {
        if (menu == null) {
            if (uVar == null && i10 >= 0) {
                u[] uVarArr = this.L;
                if (i10 < uVarArr.length) {
                    uVar = uVarArr[i10];
                }
            }
            if (uVar != null) {
                menu = uVar.f678j;
            }
        }
        if ((uVar == null || uVar.f683o) && !this.Q) {
            this.f629l.d(this.f628k.getCallback(), i10, menu);
        }
    }

    void L(androidx.appcompat.view.menu.g gVar) {
        if (this.K) {
            return;
        }
        this.K = true;
        this.f634q.l();
        Window.Callback f02 = f0();
        if (f02 != null && !this.Q) {
            f02.onPanelClosed(108, gVar);
        }
        this.K = false;
    }

    final int L0(k0 k0Var, Rect rect) {
        boolean z10;
        boolean z11;
        int k10 = k0Var != null ? k0Var.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f638u;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f638u.getLayoutParams();
            if (this.f638u.isShown()) {
                if (this.f622c0 == null) {
                    this.f622c0 = new Rect();
                    this.f623d0 = new Rect();
                }
                Rect rect2 = this.f622c0;
                Rect rect3 = this.f623d0;
                if (k0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(k0Var.i(), k0Var.k(), k0Var.j(), k0Var.h());
                }
                h1.a(this.A, rect2, rect3);
                int i10 = rect2.top;
                int i11 = rect2.left;
                int i12 = rect2.right;
                k0 G = a0.G(this.A);
                int i13 = G == null ? 0 : G.i();
                int j10 = G == null ? 0 : G.j();
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z11 = true;
                }
                if (i10 <= 0 || this.C != null) {
                    View view = this.C;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i14 = marginLayoutParams2.height;
                        int i15 = marginLayoutParams.topMargin;
                        if (i14 != i15 || marginLayoutParams2.leftMargin != i13 || marginLayoutParams2.rightMargin != j10) {
                            marginLayoutParams2.height = i15;
                            marginLayoutParams2.leftMargin = i13;
                            marginLayoutParams2.rightMargin = j10;
                            this.C.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f627j);
                    this.C = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i13;
                    layoutParams.rightMargin = j10;
                    this.A.addView(this.C, -1, layoutParams);
                }
                View view3 = this.C;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    M0(this.C);
                }
                if (!this.H && r5) {
                    k10 = 0;
                }
                z10 = r5;
                r5 = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                r5 = false;
            }
            if (r5) {
                this.f638u.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.C;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        return k10;
    }

    void N(int i10) {
        O(d0(i10, true), true);
    }

    void O(u uVar, boolean z10) {
        ViewGroup viewGroup;
        e0 e0Var;
        if (z10 && uVar.f669a == 0 && (e0Var = this.f634q) != null && e0Var.b()) {
            L(uVar.f678j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f627j.getSystemService("window");
        if (windowManager != null && uVar.f683o && (viewGroup = uVar.f675g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                K(uVar.f669a, uVar, null);
            }
        }
        uVar.f681m = false;
        uVar.f682n = false;
        uVar.f683o = false;
        uVar.f676h = null;
        uVar.f685q = true;
        if (this.M == uVar) {
            this.M = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View R(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        androidx.appcompat.app.i iVar;
        boolean z11 = false;
        if (this.f624e0 == null) {
            String string = this.f627j.obtainStyledAttributes(e.j.f9098v0).getString(e.j.f9118z0);
            if (string == null) {
                iVar = new androidx.appcompat.app.i();
            } else {
                try {
                    this.f624e0 = (androidx.appcompat.app.i) this.f627j.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to instantiate custom view inflater ");
                    sb2.append(string);
                    sb2.append(". Falling back to default.");
                    iVar = new androidx.appcompat.app.i();
                }
            }
            this.f624e0 = iVar;
        }
        boolean z12 = f615h0;
        if (z12) {
            if (this.f625f0 == null) {
                this.f625f0 = new androidx.appcompat.app.j();
            }
            if (this.f625f0.a(attributeSet)) {
                z10 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    z11 = E0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z11 = true;
                }
                z10 = z11;
            }
        } else {
            z10 = false;
        }
        return this.f624e0.createView(view, str, context, attributeSet, z10, z12, true, g1.c());
    }

    void S() {
        androidx.appcompat.view.menu.g gVar;
        e0 e0Var = this.f634q;
        if (e0Var != null) {
            e0Var.l();
        }
        if (this.f639v != null) {
            this.f628k.getDecorView().removeCallbacks(this.f640w);
            if (this.f639v.isShowing()) {
                try {
                    this.f639v.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f639v = null;
        }
        V();
        u d02 = d0(0, false);
        if (d02 == null || (gVar = d02.f678j) == null) {
            return;
        }
        gVar.close();
    }

    boolean T(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f626i;
        if (((obj instanceof f.a) || (obj instanceof androidx.appcompat.app.h)) && (decorView = this.f628k.getDecorView()) != null && androidx.core.view.f.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f629l.b(this.f628k.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? p0(keyCode, keyEvent) : s0(keyCode, keyEvent);
    }

    void U(int i10) {
        u d02;
        u d03 = d0(i10, true);
        if (d03.f678j != null) {
            Bundle bundle = new Bundle();
            d03.f678j.Q(bundle);
            if (bundle.size() > 0) {
                d03.f687s = bundle;
            }
            d03.f678j.d0();
            d03.f678j.clear();
        }
        d03.f686r = true;
        d03.f685q = true;
        if ((i10 != 108 && i10 != 0) || this.f634q == null || (d02 = d0(0, false)) == null) {
            return;
        }
        d02.f681m = false;
        A0(d02, null);
    }

    void V() {
        g0 g0Var = this.f641x;
        if (g0Var != null) {
            g0Var.c();
        }
    }

    u Y(Menu menu) {
        u[] uVarArr = this.L;
        int length = uVarArr != null ? uVarArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            u uVar = uVarArr[i10];
            if (uVar != null && uVar.f678j == menu) {
                return uVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        u Y;
        Window.Callback f02 = f0();
        if (f02 == null || this.Q || (Y = Y(gVar.D())) == null) {
            return false;
        }
        return f02.onMenuItemSelected(Y.f669a, menuItem);
    }

    final Context a0() {
        androidx.appcompat.app.a m10 = m();
        Context k10 = m10 != null ? m10.k() : null;
        return k10 == null ? this.f627j : k10;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        B0(true);
    }

    @Override // androidx.appcompat.app.e
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ((ViewGroup) this.A.findViewById(R.id.content)).addView(view, layoutParams);
        this.f629l.c(this.f628k.getCallback());
    }

    protected u d0(int i10, boolean z10) {
        u[] uVarArr = this.L;
        if (uVarArr == null || uVarArr.length <= i10) {
            u[] uVarArr2 = new u[i10 + 1];
            if (uVarArr != null) {
                System.arraycopy(uVarArr, 0, uVarArr2, 0, uVarArr.length);
            }
            this.L = uVarArr2;
            uVarArr = uVarArr2;
        }
        u uVar = uVarArr[i10];
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(i10);
        uVarArr[i10] = uVar2;
        return uVar2;
    }

    final CharSequence e0() {
        Object obj = this.f626i;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f633p;
    }

    @Override // androidx.appcompat.app.e
    public Context f(Context context) {
        this.O = true;
        int n02 = n0(context, J());
        Configuration configuration = null;
        boolean z10 = false;
        if (f618k0 && (context instanceof ContextThemeWrapper)) {
            try {
                s.a((ContextThemeWrapper) context, P(context, n02, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(P(context, n02, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f617j0) {
            return super.f(context);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = k.a(context, configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = Z(configuration3, configuration4);
            }
        }
        Configuration P = P(context, n02, configuration, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, e.i.f8990c);
        dVar.a(P);
        try {
            z10 = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z10) {
            h.g.a(dVar.getTheme());
        }
        return super.f(dVar);
    }

    final Window.Callback f0() {
        return this.f628k.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T i(int i10) {
        W();
        return (T) this.f628k.findViewById(i10);
    }

    @Override // androidx.appcompat.app.e
    public int k() {
        return this.S;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater l() {
        if (this.f632o == null) {
            g0();
            androidx.appcompat.app.a aVar = this.f631n;
            this.f632o = new androidx.appcompat.view.g(aVar != null ? aVar.k() : this.f627j);
        }
        return this.f632o;
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a m() {
        g0();
        return this.f631n;
    }

    public boolean m0() {
        return this.f642y;
    }

    @Override // androidx.appcompat.app.e
    public void n() {
        LayoutInflater from = LayoutInflater.from(this.f627j);
        if (from.getFactory() == null) {
            androidx.core.view.g.b(from, this);
        } else {
            boolean z10 = from.getFactory2() instanceof f;
        }
    }

    int n0(Context context, int i10) {
        q c02;
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 != 1 && i10 != 2) {
                    if (i10 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    c02 = b0(context);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                c02 = c0(context);
            }
            return c02.c();
        }
        return i10;
    }

    @Override // androidx.appcompat.app.e
    public void o() {
        if (y0() == null || m().l()) {
            return;
        }
        k0(0);
    }

    boolean o0() {
        androidx.appcompat.view.b bVar = this.f637t;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a m10 = m();
        return m10 != null && m10.h();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return R(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.e
    public void p(Configuration configuration) {
        androidx.appcompat.app.a m10;
        if (this.F && this.f643z && (m10 = m()) != null) {
            m10.m(configuration);
        }
        androidx.appcompat.widget.k.b().g(this.f627j);
        this.R = new Configuration(this.f627j.getResources().getConfiguration());
        G(false);
        configuration.updateFrom(this.f627j.getResources().getConfiguration());
    }

    boolean p0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.N = (keyEvent.getFlags() & 128) != 0;
        } else if (i10 == 82) {
            q0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void q(Bundle bundle) {
        this.O = true;
        G(false);
        X();
        Object obj = this.f626i;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.i.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a y02 = y0();
                if (y02 == null) {
                    this.f621b0 = true;
                } else {
                    y02.u(true);
                }
            }
            androidx.appcompat.app.e.c(this);
        }
        this.R = new Configuration(this.f627j.getResources().getConfiguration());
        this.P = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    @Override // androidx.appcompat.app.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f626i
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.e.x(r3)
        L9:
            boolean r0 = r3.Y
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f628k
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f620a0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.Q = r0
            int r0 = r3.S
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f626i
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            l.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.f.f614g0
            java.lang.Object r1 = r3.f626i
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.S
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            l.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.f.f614g0
            java.lang.Object r1 = r3.f626i
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.f631n
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.M()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.r():void");
    }

    boolean r0(int i10, KeyEvent keyEvent) {
        androidx.appcompat.app.a m10 = m();
        if (m10 != null && m10.o(i10, keyEvent)) {
            return true;
        }
        u uVar = this.M;
        if (uVar != null && z0(uVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            u uVar2 = this.M;
            if (uVar2 != null) {
                uVar2.f682n = true;
            }
            return true;
        }
        if (this.M == null) {
            u d02 = d0(0, true);
            A0(d02, keyEvent);
            boolean z02 = z0(d02, keyEvent.getKeyCode(), keyEvent, 1);
            d02.f681m = false;
            if (z02) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void s(Bundle bundle) {
        W();
    }

    boolean s0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            boolean z10 = this.N;
            this.N = false;
            u d02 = d0(0, false);
            if (d02 != null && d02.f683o) {
                if (!z10) {
                    O(d02, true);
                }
                return true;
            }
            if (o0()) {
                return true;
            }
        } else if (i10 == 82) {
            t0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void t() {
        androidx.appcompat.app.a m10 = m();
        if (m10 != null) {
            m10.y(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void u(Bundle bundle) {
    }

    void u0(int i10) {
        androidx.appcompat.app.a m10;
        if (i10 != 108 || (m10 = m()) == null) {
            return;
        }
        m10.i(true);
    }

    @Override // androidx.appcompat.app.e
    public void v() {
        F();
    }

    void v0(int i10) {
        if (i10 == 108) {
            androidx.appcompat.app.a m10 = m();
            if (m10 != null) {
                m10.i(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            u d02 = d0(i10, true);
            if (d02.f683o) {
                O(d02, false);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void w() {
        androidx.appcompat.app.a m10 = m();
        if (m10 != null) {
            m10.y(false);
        }
    }

    void w0(ViewGroup viewGroup) {
    }

    final androidx.appcompat.app.a y0() {
        return this.f631n;
    }

    @Override // androidx.appcompat.app.e
    public boolean z(int i10) {
        int C0 = C0(i10);
        if (this.J && C0 == 108) {
            return false;
        }
        if (this.F && C0 == 1) {
            this.F = false;
        }
        if (C0 == 1) {
            H0();
            this.J = true;
            return true;
        }
        if (C0 == 2) {
            H0();
            this.D = true;
            return true;
        }
        if (C0 == 5) {
            H0();
            this.E = true;
            return true;
        }
        if (C0 == 10) {
            H0();
            this.H = true;
            return true;
        }
        if (C0 == 108) {
            H0();
            this.F = true;
            return true;
        }
        if (C0 != 109) {
            return this.f628k.requestFeature(C0);
        }
        H0();
        this.G = true;
        return true;
    }
}
