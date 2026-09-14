package S2;

import kotlinx.coroutines.flow.internal.AbortFlowException;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class t implements e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2225a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.r f2226b;

    public /* synthetic */ t(kotlin.jvm.internal.r rVar, int i) {
        this.f2225a = i;
        this.f2226b = rVar;
    }

    @Override // S2.e
    public final Object emit(Object obj, InterfaceC0763d interfaceC0763d) {
        switch (this.f2225a) {
            case 0:
                this.f2226b.f5312a = obj;
                throw new AbortFlowException(this);
            default:
                this.f2226b.f5312a = obj;
                throw new AbortFlowException(this);
        }
    }
}
