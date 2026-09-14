package r5;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import w6.a0;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f13781a;

    private b() {
    }

    private String a() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.UK).format(new Date());
    }

    public static b b() {
        if (f13781a == null) {
            f13781a = new b();
        }
        return f13781a;
    }

    private void e(Context context, String str, String str2) {
        a0.a().k(str, str2);
        v5.a.b(context);
    }

    public String c() {
        return a0.a().f("LastLocSent", "");
    }

    public String d() {
        return a0.a().f("LastLocUpdated", "");
    }

    public void f(Context context) {
        e(context, "LastLocSent", a());
    }

    public void g(Context context) {
        e(context, "LastLocUpdated", a());
    }
}
