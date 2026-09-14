package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x0 f3512a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final z0 f3513b;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.x0, java.lang.Object] */
    static {
        z0 z0Var = null;
        try {
            z0Var = (z0) q0.m.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3513b = z0Var;
    }

    public static final void a(int i, ArrayList views) {
        kotlin.jvm.internal.j.e(views, "views");
        int size = views.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = views.get(i3);
            i3++;
            ((View) obj).setVisibility(i);
        }
    }
}
