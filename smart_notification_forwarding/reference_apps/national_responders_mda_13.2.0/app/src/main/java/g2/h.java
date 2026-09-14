package g2;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class h implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final h f9752a = new h();

    private h() {
    }

    public static e d() {
        return f9752a;
    }

    @Override // g2.e
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // g2.e
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // g2.e
    public final long c() {
        return System.nanoTime();
    }
}
