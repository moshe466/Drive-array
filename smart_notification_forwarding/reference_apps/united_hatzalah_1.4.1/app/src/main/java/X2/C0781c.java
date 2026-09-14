package x2;

import F2.p;
import a.AbstractC0228a;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.u;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import y2.AbstractC0787c;

/* renamed from: x2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0781c extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public int f6745a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f6746b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0763d f6747c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0781c(InterfaceC0763d interfaceC0763d, InterfaceC0768i interfaceC0768i, p pVar, InterfaceC0763d interfaceC0763d2) {
        super(interfaceC0763d, interfaceC0768i);
        this.f6746b = pVar;
        this.f6747c = interfaceC0763d2;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        int i = this.f6745a;
        if (i != 0) {
            if (i == 1) {
                this.f6745a = 2;
                AbstractC0228a.C(obj);
                return obj;
            }
            throw new IllegalStateException("This coroutine had already completed");
        }
        this.f6745a = 1;
        AbstractC0228a.C(obj);
        p pVar = this.f6746b;
        j.c(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        u.a(2, pVar);
        return pVar.invoke(this.f6747c, this);
    }
}
