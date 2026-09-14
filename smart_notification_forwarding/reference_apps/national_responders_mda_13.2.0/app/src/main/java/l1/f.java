package l1;

import android.content.Context;

/* loaded from: classes.dex */
public final class f implements m1.b<e> {

    /* renamed from: a, reason: collision with root package name */
    private final k8.a<Context> f11779a;

    /* renamed from: b, reason: collision with root package name */
    private final k8.a<c> f11780b;

    public f(k8.a<Context> aVar, k8.a<c> aVar2) {
        this.f11779a = aVar;
        this.f11780b = aVar2;
    }

    public static f a(k8.a<Context> aVar, k8.a<c> aVar2) {
        return new f(aVar, aVar2);
    }

    public static e c(Context context, Object obj) {
        return new e(context, (c) obj);
    }

    @Override // k8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c(this.f11779a.get(), this.f11780b.get());
    }
}
