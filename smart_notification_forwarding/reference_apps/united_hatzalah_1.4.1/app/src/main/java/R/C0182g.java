package R;

import a.AbstractC0228a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* renamed from: R.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0182g extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f1875a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1876b;

    /* renamed from: c, reason: collision with root package name */
    public int f1877c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1878d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f1879e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1880f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0182g(List list, ArrayList arrayList, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f1879e = list;
        this.f1880f = arrayList;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        C0182g c0182g = new C0182g(this.f1879e, this.f1880f, interfaceC0763d);
        c0182g.f1878d = obj;
        return c0182g;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0182g) create(obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Iterator it;
        List list;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.f1877c;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    it = this.f1875a;
                    list = (List) this.f1878d;
                    AbstractC0228a.C(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                Object obj2 = this.f1876b;
                Iterator it2 = this.f1875a;
                List list2 = (List) this.f1878d;
                AbstractC0228a.C(obj);
                if (!((Boolean) obj).booleanValue()) {
                    obj = obj2;
                    it = it2;
                    list = list2;
                } else {
                    list2.add(new AbstractC0793i(1, null));
                    this.f1878d = list2;
                    this.f1875a = it2;
                    this.f1876b = null;
                    this.f1877c = 2;
                    throw null;
                }
            }
        } else {
            AbstractC0228a.C(obj);
            obj = this.f1878d;
            it = this.f1879e.iterator();
            list = this.f1880f;
        }
        if (!it.hasNext()) {
            return obj;
        }
        if (it.next() == null) {
            this.f1878d = list;
            this.f1875a = it;
            this.f1876b = obj;
            this.f1877c = 1;
            throw null;
        }
        throw new ClassCastException();
    }
}
