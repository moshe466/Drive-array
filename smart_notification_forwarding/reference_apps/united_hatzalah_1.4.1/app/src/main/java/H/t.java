package h;

import F0.H2;
import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class t {
    public static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    public static OnBackInvokedCallback b(Object obj, y yVar) {
        Objects.requireNonNull(yVar);
        c.s sVar = new c.s(yVar, 1);
        H2.o(obj).registerOnBackInvokedCallback(1000000, sVar);
        return sVar;
    }

    public static void c(Object obj, Object obj2) {
        H2.o(obj).unregisterOnBackInvokedCallback(H2.k(obj2));
    }
}
