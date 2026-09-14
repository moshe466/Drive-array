package androidx.fragment.app;

import android.os.Build;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
class g0 {

    /* renamed from: a, reason: collision with root package name */
    static final i0 f3021a;

    /* renamed from: b, reason: collision with root package name */
    static final i0 f3022b;

    static {
        f3021a = Build.VERSION.SDK_INT >= 21 ? new h0() : null;
        f3022b = b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, Fragment fragment2, boolean z10, l.a<String, View> aVar, boolean z11) {
        if (z10) {
            fragment2.D();
        } else {
            fragment.D();
        }
    }

    private static i0 b() {
        try {
            return (i0) s0.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(l.a<String, String> aVar, l.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.n(size))) {
                aVar.k(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(ArrayList<View> arrayList, int i10) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i10);
        }
    }
}
