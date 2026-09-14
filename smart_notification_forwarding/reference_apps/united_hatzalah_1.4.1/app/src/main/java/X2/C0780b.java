package x2;

import F2.p;
import a.AbstractC0228a;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.u;
import w2.InterfaceC0763d;
import y2.AbstractC0791g;

/* renamed from: x2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0780b extends AbstractC0791g {

    /* renamed from: a, reason: collision with root package name */
    public int f6742a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f6743b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0763d f6744c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0780b(p pVar, InterfaceC0763d interfaceC0763d, InterfaceC0763d interfaceC0763d2) {
        super(interfaceC0763d);
        this.f6743b = pVar;
        this.f6744c = interfaceC0763d2;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        int i = this.f6742a;
        if (i != 0) {
            if (i == 1) {
                this.f6742a = 2;
                AbstractC0228a.C(obj);
                return obj;
            }
            throw new IllegalStateException("This coroutine had already completed");
        }
        this.f6742a = 1;
        AbstractC0228a.C(obj);
        p pVar = this.f6743b;
        j.c(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        u.a(2, pVar);
        return pVar.invoke(this.f6744c, this);
    }
}
