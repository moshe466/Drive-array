package U;

import F2.p;
import a.AbstractC0228a;
import java.util.concurrent.atomic.AtomicBoolean;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class c extends AbstractC0793i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f2310a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2311b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0793i f2312c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f2312c = (AbstractC0793i) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        c cVar = new c(this.f2312c, interfaceC0763d);
        cVar.f2311b = obj;
        return cVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((h) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f2310a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            h hVar = (h) this.f2311b;
            this.f2310a = 1;
            obj = this.f2312c.invoke(hVar, this);
            if (obj == enumC0779a) {
                return enumC0779a;
            }
        }
        h hVar2 = (h) obj;
        kotlin.jvm.internal.j.c(hVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
        ((AtomicBoolean) ((b) hVar2).f2309b.f546b).set(true);
        return hVar2;
    }
}
