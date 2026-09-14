package F0;

import a.AbstractC0228a;
import android.content.Context;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: F0.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0069p0 extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f604a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0069p0(Context context, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f604a = context;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new C0069p0(this.f604a, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return new C0069p0(this.f604a, (InterfaceC0763d) obj2).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        Context context = this.f604a;
        return new C0073q0(new C0026e1(context, new C0084t0(context, 0)), new C0109z1(context));
    }
}
