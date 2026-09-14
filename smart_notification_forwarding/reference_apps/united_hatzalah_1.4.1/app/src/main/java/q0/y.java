package q0;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import m.g1;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final z f6139a;

    /* renamed from: b, reason: collision with root package name */
    public static final g1 f6140b;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, q0.z] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, q0.z] */
    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f6139a = new Object();
        } else {
            f6139a = new Object();
        }
        f6140b = new g1("translationAlpha", 6, Float.class);
        new g1("clipBounds", 7, Rect.class);
    }

    public static void a(View view, int i, int i3, int i4, int i5) {
        f6139a.Y(view, i, i3, i4, i5);
    }
}
