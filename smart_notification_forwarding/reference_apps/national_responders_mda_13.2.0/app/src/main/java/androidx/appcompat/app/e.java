package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: f, reason: collision with root package name */
    private static int f611f = -100;

    /* renamed from: g, reason: collision with root package name */
    private static final l.b<WeakReference<e>> f612g = new l.b<>();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f613h = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(e eVar) {
        synchronized (f613h) {
            y(eVar);
            f612g.add(new WeakReference<>(eVar));
        }
    }

    public static e g(Activity activity, d dVar) {
        return new f(activity, dVar);
    }

    public static e h(Dialog dialog, d dVar) {
        return new f(dialog, dVar);
    }

    public static int j() {
        return f611f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void x(e eVar) {
        synchronized (f613h) {
            y(eVar);
        }
    }

    private static void y(e eVar) {
        synchronized (f613h) {
            Iterator<WeakReference<e>> it = f612g.iterator();
            while (it.hasNext()) {
                e eVar2 = it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void A(int i10);

    public abstract void B(View view);

    public abstract void C(View view, ViewGroup.LayoutParams layoutParams);

    public void D(int i10) {
    }

    public abstract void E(CharSequence charSequence);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public abstract <T extends View> T i(int i10);

    public int k() {
        return -100;
    }

    public abstract MenuInflater l();

    public abstract a m();

    public abstract void n();

    public abstract void o();

    public abstract void p(Configuration configuration);

    public abstract void q(Bundle bundle);

    public abstract void r();

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract void w();

    public abstract boolean z(int i10);
}
