package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.e0;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11699a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f11700b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f11701c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f11702d;

    /* renamed from: e, reason: collision with root package name */
    public static g f11703e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f11704f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f11705g;

    static {
        long e10;
        int a10;
        int d10;
        int d11;
        long e11;
        e10 = e0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f11699a = e10;
        a10 = d9.f.a(c0.a(), 2);
        d10 = e0.d("kotlinx.coroutines.scheduler.core.pool.size", a10, 1, 0, 8, null);
        f11700b = d10;
        d11 = e0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f11701c = d11;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e11 = e0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f11702d = timeUnit.toNanos(e11);
        f11703e = e.f11689a;
        f11704f = new j(0);
        f11705g = new j(1);
    }
}
