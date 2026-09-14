package b3;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f4089a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f4090b = new f0.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f4091c = new f0.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f4092d = new f0.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f4093e = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }
}
