package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;
import l0.C0514d;

/* renamed from: androidx.lifecycle.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0296f implements r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3603a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3604b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3605c;

    public C0296f(DefaultLifecycleObserver defaultLifecycleObserver, r rVar) {
        kotlin.jvm.internal.j.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f3604b = defaultLifecycleObserver;
        this.f3605c = rVar;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        switch (this.f3603a) {
            case 0:
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) this.f3604b;
                switch (AbstractC0295e.f3602a[enumC0303m.ordinal()]) {
                    case 1:
                        defaultLifecycleObserver.onCreate(interfaceC0309t);
                        break;
                    case 2:
                        defaultLifecycleObserver.onStart(interfaceC0309t);
                        break;
                    case 3:
                        defaultLifecycleObserver.onResume(interfaceC0309t);
                        break;
                    case 4:
                        defaultLifecycleObserver.onPause(interfaceC0309t);
                        break;
                    case 5:
                        defaultLifecycleObserver.onStop(interfaceC0309t);
                        break;
                    case 6:
                        defaultLifecycleObserver.onDestroy(interfaceC0309t);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                r rVar = (r) this.f3605c;
                if (rVar != null) {
                    rVar.a(interfaceC0309t, enumC0303m);
                    return;
                }
                return;
            case 1:
                if (enumC0303m == EnumC0303m.ON_START) {
                    ((AbstractC0305o) this.f3604b).b(this);
                    ((C0514d) this.f3605c).d();
                    return;
                }
                return;
            default:
                HashMap hashMap = ((C0292b) this.f3605c).f3595a;
                List list = (List) hashMap.get(enumC0303m);
                Object obj = this.f3604b;
                C0292b.a(list, interfaceC0309t, enumC0303m, obj);
                C0292b.a((List) hashMap.get(EnumC0303m.ON_ANY), interfaceC0309t, enumC0303m, obj);
                return;
        }
    }

    public C0296f(InterfaceC0308s interfaceC0308s) {
        this.f3604b = interfaceC0308s;
        C0294d c0294d = C0294d.f3599c;
        Class<?> cls = interfaceC0308s.getClass();
        C0292b c0292b = (C0292b) c0294d.f3600a.get(cls);
        this.f3605c = c0292b == null ? c0294d.a(cls, null) : c0292b;
    }

    public C0296f(AbstractC0305o abstractC0305o, C0514d c0514d) {
        this.f3604b = abstractC0305o;
        this.f3605c = c0514d;
    }
}
