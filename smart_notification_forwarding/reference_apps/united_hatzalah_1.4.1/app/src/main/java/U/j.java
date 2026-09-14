package U;

import F2.p;
import a.AbstractC0228a;
import java.util.LinkedHashMap;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class j extends AbstractC0793i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f2317a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2318b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0793i f2319c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j(p pVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f2319c = (AbstractC0793i) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        j jVar = new j(this.f2319c, interfaceC0763d);
        jVar.f2318b = obj;
        return jVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((h) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [y2.i, F2.p] */
    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f2317a;
        if (i != 0) {
            if (i == 1) {
                b bVar = (b) this.f2318b;
                AbstractC0228a.C(obj);
                return bVar;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0228a.C(obj);
        b bVar2 = new b(new LinkedHashMap(((h) this.f2318b).a()), false);
        this.f2318b = bVar2;
        this.f2317a = 1;
        if (this.f2319c.invoke(bVar2, this) == enumC0779a) {
            return enumC0779a;
        }
        return bVar2;
    }
}
