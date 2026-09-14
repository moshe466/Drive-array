package c3;

import android.os.Build;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4375a;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f4375a = i10 >= 21 ? 2 : i10 >= 18 ? 1 : 0;
    }
}
