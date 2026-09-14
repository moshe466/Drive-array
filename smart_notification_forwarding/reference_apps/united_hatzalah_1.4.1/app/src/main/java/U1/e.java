package u1;

import A.n;
import android.content.Context;

/* loaded from: classes.dex */
public final class e implements v1.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6594a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6595b;

    public /* synthetic */ e(Object obj, int i) {
        this.f6594a = i;
        this.f6595b = obj;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        switch (this.f6594a) {
            case 0:
                return new d((Context) ((e) this.f6595b).f6595b, new n(2), new n(1));
            default:
                return this.f6595b;
        }
    }
}
