package o3;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements r4.b {

    /* renamed from: a, reason: collision with root package name */
    private final c f12467a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f12468b;

    private b(c cVar, Context context) {
        this.f12467a = cVar;
        this.f12468b = context;
    }

    public static r4.b a(c cVar, Context context) {
        return new b(cVar, context);
    }

    @Override // r4.b
    public Object get() {
        return c.r(this.f12467a, this.f12468b);
    }
}
