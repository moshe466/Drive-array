package q1;

import s1.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final h f13433a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.e f13434b;

    /* renamed from: c, reason: collision with root package name */
    private final Iterable f13435c;

    /* renamed from: d, reason: collision with root package name */
    private final k1.m f13436d;

    /* renamed from: e, reason: collision with root package name */
    private final int f13437e;

    private e(h hVar, com.google.android.datatransport.runtime.backends.e eVar, Iterable iterable, k1.m mVar, int i10) {
        this.f13433a = hVar;
        this.f13434b = eVar;
        this.f13435c = iterable;
        this.f13436d = mVar;
        this.f13437e = i10;
    }

    public static b.a a(h hVar, com.google.android.datatransport.runtime.backends.e eVar, Iterable iterable, k1.m mVar, int i10) {
        return new e(hVar, eVar, iterable, mVar, i10);
    }

    @Override // s1.b.a
    public Object f() {
        return h.c(this.f13433a, this.f13434b, this.f13435c, this.f13436d, this.f13437e);
    }
}
