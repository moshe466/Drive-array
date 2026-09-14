package T;

import android.content.Context;
import s2.C0684i;

/* loaded from: classes.dex */
public final class c extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2256a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2257b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2258c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i, Object obj, Object obj2) {
        super(0);
        this.f2256a = i;
        this.f2257b = obj;
        this.f2258c = obj2;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f2256a) {
            case 0:
                Context applicationContext = (Context) this.f2257b;
                kotlin.jvm.internal.j.d(applicationContext, "applicationContext");
                return m3.b.G(applicationContext, ((d) this.f2258c).f2259a);
            default:
                ((A0.a) ((z0.b) this.f2257b).f6816c).b((io.flutter.embedding.android.a) this.f2258c);
                return C0684i.f6340a;
        }
    }
}
