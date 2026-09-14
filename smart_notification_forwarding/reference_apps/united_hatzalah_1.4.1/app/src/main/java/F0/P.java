package F0;

import a.AbstractC0228a;
import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class P extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f349a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f350b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(Q q3, Context context, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f349a = q3;
        this.f350b = context;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new P(this.f349a, this.f350b, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        P p = (P) create((P2.E) obj, (InterfaceC0763d) obj2);
        C0684i c0684i = C0684i.f6340a;
        p.invokeSuspend(c0684i);
        return c0684i;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new RunnableC0091v(0, (r3) this.f349a.f364e, this.f350b), 60L, 60L, TimeUnit.SECONDS);
        return C0684i.f6340a;
    }
}
