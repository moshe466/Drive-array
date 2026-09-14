package n;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.loader.content.f;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: n.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0591b extends E1.b {

    /* renamed from: b, reason: collision with root package name */
    public final Object f5876b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f5877c = Executors.newFixedThreadPool(4, new f(1));

    /* renamed from: d, reason: collision with root package name */
    public volatile Handler f5878d;

    public static Handler B(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return B.b.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
