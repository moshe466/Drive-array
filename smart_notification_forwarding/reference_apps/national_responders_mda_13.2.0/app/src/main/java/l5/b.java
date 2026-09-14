package l5;

import android.app.Application;
import w6.m;
import w6.z;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f11786a;

    private b() {
    }

    public static b a() {
        if (f11786a == null) {
            f11786a = new b();
        }
        return f11786a;
    }

    private boolean b(int i10) {
        return i10 != 2;
    }

    public void c(Application application) {
        try {
            try {
                if (b(m.Q()) && z.b().d()) {
                    z.b().a();
                    new c(application).c();
                }
            } catch (Exception e10) {
                e10.getMessage();
            }
        } finally {
            m.H0(2);
        }
    }
}
