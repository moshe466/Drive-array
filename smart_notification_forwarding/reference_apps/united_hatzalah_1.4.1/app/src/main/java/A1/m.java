package A1;

import android.content.Context;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class m implements v1.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0645a f59b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0645a f60c;

    public /* synthetic */ m(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, int i) {
        this.f58a = i;
        this.f59b = interfaceC0645a;
        this.f60c = interfaceC0645a2;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        switch (this.f58a) {
            case 0:
                return new l(new A.n(2), new A.n(1), a.f27f, (o) this.f59b.get(), this.f60c);
            default:
                return new u1.f((Context) ((u1.e) this.f59b).f6595b, (u1.d) ((u1.e) this.f60c).get());
        }
    }
}
