package i2;

import android.content.Context;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static c f10725b = new c();

    /* renamed from: a, reason: collision with root package name */
    private b f10726a = null;

    public static b a(Context context) {
        return f10725b.b(context);
    }

    public final synchronized b b(Context context) {
        if (this.f10726a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f10726a = new b(context);
        }
        return this.f10726a;
    }
}
