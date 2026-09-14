package q0;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f6133a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f6134b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f6135c;

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z3 = true;
        f6133a = true;
        f6134b = true;
        if (i < 28) {
            z3 = false;
        }
        f6135c = z3;
    }
}
