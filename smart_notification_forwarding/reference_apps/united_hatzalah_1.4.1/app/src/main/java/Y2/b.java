package Y2;

import F2.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import s2.C0684i;

/* loaded from: classes.dex */
public final class b extends k implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2707a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2708b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar, c cVar, int i) {
        super(1);
        this.f2707a = i;
        this.f2708b = dVar;
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        switch (this.f2707a) {
            case 0:
                this.f2708b.f(null);
                return C0684i.f6340a;
            default:
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f2711g;
                d dVar = this.f2708b;
                atomicReferenceFieldUpdater.set(dVar, null);
                dVar.f(null);
                return C0684i.f6340a;
        }
    }
}
