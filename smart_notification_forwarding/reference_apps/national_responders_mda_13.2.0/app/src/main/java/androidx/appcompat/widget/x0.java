package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class x0 extends p0 {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f1544b;

    public x0(Context context, Resources resources) {
        super(resources);
        this.f1544b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) {
        Drawable a10 = a(i10);
        Context context = this.f1544b.get();
        if (a10 != null && context != null) {
            o0.h().x(context, i10, a10);
        }
        return a10;
    }
}
