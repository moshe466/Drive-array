package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class g1 extends p0 {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f1337c;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f1338b;

    public g1(Context context, Resources resources) {
        super(resources);
        this.f1338b = new WeakReference<>(context);
    }

    public static boolean b() {
        return f1337c;
    }

    public static boolean c() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) {
        Context context = this.f1338b.get();
        return context != null ? o0.h().t(context, this, i10) : a(i10);
    }
}
