package f1;

import java.util.List;
import s2.C0680e;
import t2.C0716r;

/* renamed from: f1.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0419z extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0378A f4595b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0419z(C0378A c0378a, int i) {
        super(0);
        this.f4594a = i;
        this.f4595b = c0378a;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f4594a) {
            case 0:
                Object G3 = T.b.G(3000L, new g1.l(this.f4595b.f4524j, 1));
                if (G3 instanceof C0680e) {
                    G3 = C0716r.f6476a;
                }
                return new U((List) G3);
            case 1:
                return new V(this.f4595b.f4525k.c("auto_punctuate"));
            case 2:
                return new W(this.f4595b.f4525k.c("auto_replace"));
            case 3:
                return new X(this.f4595b.f4525k.c("time_12_24"));
            case 4:
                Object G4 = T.b.G(1000L, new g1.j(this.f4595b.f4517b, 0));
                if (G4 instanceof C0680e) {
                    G4 = 0L;
                }
                return new Z(((Number) G4).longValue());
            case 5:
                Object G5 = T.b.G(1000L, new g1.j(this.f4595b.f4517b, 1));
                if (G5 instanceof C0680e) {
                    G5 = 0L;
                }
                return new a0(((Number) G5).longValue());
            case 6:
                return new b0(this.f4595b.f4525k.b("touch_exploration_enabled"));
            case 7:
                return new c0(this.f4595b.f4525k.a("transition_animation_scale"));
            default:
                return new d0(this.f4595b.f4525k.a("window_animation_scale"));
        }
    }
}
