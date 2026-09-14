package s3;

import android.util.Log;

/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    static final b f14070c = new b("FirebaseCrashlytics");

    /* renamed from: a, reason: collision with root package name */
    private final String f14071a;

    /* renamed from: b, reason: collision with root package name */
    private int f14072b = 4;

    public b(String str) {
        this.f14071a = str;
    }

    private boolean a(int i10) {
        return this.f14072b <= i10 || Log.isLoggable(this.f14071a, i10);
    }

    public static b f() {
        return f14070c;
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        a(3);
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        a(6);
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        a(4);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        a(5);
    }
}
