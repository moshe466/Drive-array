package W2;

import U2.u;
import java.util.concurrent.TimeUnit;
import org.apache.tika.pipes.PipesConfigBase;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2540a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f2541b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2542c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f2543d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f2544e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f2545f;

    /* renamed from: g, reason: collision with root package name */
    public static final j f2546g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f2547h;

    static {
        String str;
        int i = u.f2378a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f2540a = str;
        f2541b = U2.a.i(PipesConfigBase.DEFAULT_MAX_FOR_EMIT_BATCH, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        int i3 = u.f2378a;
        if (i3 < 2) {
            i3 = 2;
        }
        f2542c = U2.a.j("kotlinx.coroutines.scheduler.core.pool.size", i3, 8);
        f2543d = U2.a.j("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 4);
        f2544e = TimeUnit.SECONDS.toNanos(U2.a.i(60L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f2545f = g.f2534a;
        f2546g = new j(0);
        f2547h = new j(1);
    }
}
