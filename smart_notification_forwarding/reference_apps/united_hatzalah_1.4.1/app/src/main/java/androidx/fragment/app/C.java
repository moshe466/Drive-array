package androidx.fragment.app;

import f.AbstractC0365a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class C extends E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f3262a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3263b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0365a f3264c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e.b f3265d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ G f3266e;

    public C(G g3, B b4, AtomicReference atomicReference, AbstractC0365a abstractC0365a, e.b bVar) {
        this.f3266e = g3;
        this.f3262a = b4;
        this.f3263b = atomicReference;
        this.f3264c = abstractC0365a;
        this.f3265d = bVar;
    }

    @Override // androidx.fragment.app.E
    public final void a() {
        e.h activityResultRegistry;
        G g3 = this.f3266e;
        String generateActivityResultKey = g3.generateActivityResultKey();
        B b4 = this.f3262a;
        switch (b4.f3259a) {
            case 0:
                G g4 = (G) b4.f3260b;
                Object obj = g4.mHost;
                if (obj instanceof e.i) {
                    activityResultRegistry = ((e.i) obj).getActivityResultRegistry();
                    break;
                } else {
                    activityResultRegistry = g4.requireActivity().getActivityResultRegistry();
                    break;
                }
            default:
                activityResultRegistry = (e.h) b4.f3260b;
                break;
        }
        this.f3263b.set(activityResultRegistry.c(generateActivityResultKey, g3, this.f3264c, this.f3265d));
    }
}
