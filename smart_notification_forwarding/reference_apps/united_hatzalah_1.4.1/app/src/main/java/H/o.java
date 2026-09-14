package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import k.AbstractC0458b;
import k.InterfaceC0457a;
import t.C0685a;
import t.C0690f;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final E f4833a = new E(new Object());

    /* renamed from: b, reason: collision with root package name */
    public static final int f4834b = -100;

    /* renamed from: c, reason: collision with root package name */
    public static F.f f4835c = null;

    /* renamed from: d, reason: collision with root package name */
    public static F.f f4836d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f4837e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f4838f = false;

    /* renamed from: j, reason: collision with root package name */
    public static final C0690f f4839j = new C0690f(0);

    /* renamed from: k, reason: collision with root package name */
    public static final Object f4840k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final Object f4841l = new Object();

    public static boolean b(Context context) {
        if (f4837e == null) {
            try {
                int i = D.f4727a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) D.class), C.a() | 128).metaData;
                if (bundle != null) {
                    f4837e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f4837e = Boolean.FALSE;
            }
        }
        return f4837e.booleanValue();
    }

    public static void e(y yVar) {
        synchronized (f4840k) {
            try {
                C0690f c0690f = f4839j;
                c0690f.getClass();
                C0685a c0685a = new C0685a(c0690f);
                while (c0685a.hasNext()) {
                    o oVar = (o) ((WeakReference) c0685a.next()).get();
                    if (oVar == yVar || oVar == null) {
                        c0685a.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void c();

    public abstract void d();

    public abstract boolean g(int i);

    public abstract void h(int i);

    public abstract void j(View view);

    public abstract void k(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void l(CharSequence charSequence);

    public abstract AbstractC0458b m(InterfaceC0457a interfaceC0457a);
}
