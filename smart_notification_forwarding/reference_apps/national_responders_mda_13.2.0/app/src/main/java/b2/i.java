package b2;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static int f4000a = 4225;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f4001b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static m1 f4002c;

    /* renamed from: d, reason: collision with root package name */
    static HandlerThread f4003d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f4004e;

    public static int a() {
        return f4000a;
    }

    public static i b(Context context) {
        synchronized (f4001b) {
            if (f4002c == null) {
                f4002c = new m1(context.getApplicationContext(), f4004e ? c().getLooper() : context.getMainLooper());
            }
        }
        return f4002c;
    }

    public static HandlerThread c() {
        synchronized (f4001b) {
            HandlerThread handlerThread = f4003d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f4003d = handlerThread2;
            handlerThread2.start();
            return f4003d;
        }
    }

    protected abstract void d(i1 i1Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i10, ServiceConnection serviceConnection, String str3, boolean z10) {
        d(new i1(str, str2, i10, z10), serviceConnection, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean f(i1 i1Var, ServiceConnection serviceConnection, String str, Executor executor);
}
