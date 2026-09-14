package R2;

import F0.G1;
import org.apache.tika.pipes.PipesConfigBase;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final k f2036a = new k(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f2037b = U2.a.j("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 12);

    /* renamed from: c, reason: collision with root package name */
    public static final int f2038c = U2.a.j("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS, 12);

    /* renamed from: d, reason: collision with root package name */
    public static final G1 f2039d;

    /* renamed from: e, reason: collision with root package name */
    public static final G1 f2040e;

    /* renamed from: f, reason: collision with root package name */
    public static final G1 f2041f;

    /* renamed from: g, reason: collision with root package name */
    public static final G1 f2042g;

    /* renamed from: h, reason: collision with root package name */
    public static final G1 f2043h;
    public static final G1 i;

    /* renamed from: j, reason: collision with root package name */
    public static final G1 f2044j;

    /* renamed from: k, reason: collision with root package name */
    public static final G1 f2045k;

    /* renamed from: l, reason: collision with root package name */
    public static final G1 f2046l;

    /* renamed from: m, reason: collision with root package name */
    public static final G1 f2047m;

    /* renamed from: n, reason: collision with root package name */
    public static final G1 f2048n;

    /* renamed from: o, reason: collision with root package name */
    public static final G1 f2049o;
    public static final G1 p;

    /* renamed from: q, reason: collision with root package name */
    public static final G1 f2050q;

    /* renamed from: r, reason: collision with root package name */
    public static final G1 f2051r;

    /* renamed from: s, reason: collision with root package name */
    public static final G1 f2052s;

    static {
        int i3 = 8;
        f2039d = new G1("BUFFERED", i3);
        f2040e = new G1("SHOULD_BUFFER", i3);
        f2041f = new G1("S_RESUMING_BY_RCV", i3);
        f2042g = new G1("RESUMING_BY_EB", i3);
        f2043h = new G1("POISONED", i3);
        i = new G1("DONE_RCV", i3);
        f2044j = new G1("INTERRUPTED_SEND", i3);
        f2045k = new G1("INTERRUPTED_RCV", i3);
        f2046l = new G1("CHANNEL_CLOSED", i3);
        f2047m = new G1("SUSPEND", i3);
        f2048n = new G1("SUSPEND_NO_WAITER", i3);
        f2049o = new G1("FAILED", i3);
        p = new G1("NO_RECEIVE_RESULT", i3);
        f2050q = new G1("CLOSE_HANDLER_CLOSED", i3);
        f2051r = new G1("CLOSE_HANDLER_INVOKED", i3);
        f2052s = new G1("NO_CLOSE_CAUSE", i3);
    }
}
