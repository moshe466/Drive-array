package b8;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import y7.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final e f4143a = a8.a.d(new CallableC0069a());

    /* renamed from: b8.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class CallableC0069a implements Callable<e> {
        CallableC0069a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return b.f4144a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final e f4144a = new b8.b(new Handler(Looper.getMainLooper()));
    }

    public static e a() {
        return a8.a.e(f4143a);
    }
}
