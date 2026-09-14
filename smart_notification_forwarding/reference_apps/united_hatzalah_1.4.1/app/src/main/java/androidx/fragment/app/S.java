package androidx.fragment.app;

import android.os.Handler;

/* loaded from: classes.dex */
public abstract class S extends O {

    /* renamed from: a, reason: collision with root package name */
    public final L f3320a;

    /* renamed from: b, reason: collision with root package name */
    public final L f3321b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f3322c;

    /* renamed from: d, reason: collision with root package name */
    public final h0 f3323d;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.fragment.app.g0, androidx.fragment.app.h0] */
    public S(L l3) {
        Handler handler = new Handler();
        this.f3320a = l3;
        this.f3321b = l3;
        this.f3322c = handler;
        this.f3323d = new AbstractC0272g0();
    }
}
