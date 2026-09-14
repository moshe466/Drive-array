package Y2;

import F0.G1;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    public static final G1 f2722b;

    /* renamed from: c, reason: collision with root package name */
    public static final G1 f2723c;

    /* renamed from: d, reason: collision with root package name */
    public static final G1 f2724d;

    /* renamed from: e, reason: collision with root package name */
    public static final G1 f2725e;

    /* renamed from: a, reason: collision with root package name */
    public static final int f2721a = U2.a.j("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 12);

    /* renamed from: f, reason: collision with root package name */
    public static final int f2726f = U2.a.j("kotlinx.coroutines.semaphore.segmentSize", 16, 12);

    static {
        int i = 8;
        f2722b = new G1("PERMIT", i);
        f2723c = new G1("TAKEN", i);
        f2724d = new G1("BROKEN", i);
        f2725e = new G1("CANCELLED", i);
    }
}
