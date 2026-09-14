package z0;

import F2.p;
import a.AbstractC0228a;
import android.app.Activity;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class i extends AbstractC0793i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f6830a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6831b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f6832c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Activity f6833d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b bVar, Activity activity, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f6832c = bVar;
        this.f6833d = activity;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        i iVar = new i(this.f6832c, this.f6833d, interfaceC0763d);
        iVar.f6831b = obj;
        return iVar;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((R2.p) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, i0.c] */
    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f6830a;
        if (i != 0) {
            if (i == 1) {
                AbstractC0228a.C(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC0228a.C(obj);
            R2.p pVar = (R2.p) this.f6831b;
            io.flutter.embedding.android.a aVar = new io.flutter.embedding.android.a(pVar, 1);
            b bVar = this.f6832c;
            ((A0.a) bVar.f6816c).a(this.f6833d, new Object(), aVar);
            T.c cVar = new T.c(1, bVar, aVar);
            this.f6830a = 1;
            if (AbstractC0228a.c(pVar, cVar, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
