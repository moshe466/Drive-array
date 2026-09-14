package T2;

import F0.AbstractC0008a;
import P2.G;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import s2.C0684i;
import t2.AbstractC0707i;
import w2.C0769j;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public abstract class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0768i f2281a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2282b;

    /* renamed from: c, reason: collision with root package name */
    public final R2.a f2283c;

    public d(InterfaceC0768i interfaceC0768i, int i, R2.a aVar) {
        this.f2281a = interfaceC0768i;
        this.f2282b = i;
        this.f2283c = aVar;
    }

    @Override // T2.h
    public final S2.d a(InterfaceC0768i interfaceC0768i, int i, R2.a aVar) {
        InterfaceC0768i interfaceC0768i2 = this.f2281a;
        InterfaceC0768i plus = interfaceC0768i.plus(interfaceC0768i2);
        R2.a aVar2 = R2.a.f2018a;
        R2.a aVar3 = this.f2283c;
        int i3 = this.f2282b;
        if (aVar == aVar2) {
            if (i3 != -3) {
                if (i != -3) {
                    if (i3 != -2) {
                        if (i != -2) {
                            i += i3;
                            if (i < 0) {
                                i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                            }
                        }
                    }
                }
                i = i3;
            }
            aVar = aVar3;
        }
        if (kotlin.jvm.internal.j.a(plus, interfaceC0768i2) && i == i3 && aVar == aVar3) {
            return this;
        }
        return c(plus, i, aVar);
    }

    public abstract Object b(R2.p pVar, InterfaceC0763d interfaceC0763d);

    public abstract d c(InterfaceC0768i interfaceC0768i, int i, R2.a aVar);

    @Override // S2.d
    public Object collect(S2.e eVar, InterfaceC0763d interfaceC0763d) {
        Object g3 = G.g(new b(eVar, this, null), interfaceC0763d);
        if (g3 == EnumC0779a.f6740a) {
            return g3;
        }
        return C0684i.f6340a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        C0769j c0769j = C0769j.f6733a;
        InterfaceC0768i interfaceC0768i = this.f2281a;
        if (interfaceC0768i != c0769j) {
            arrayList.add("context=" + interfaceC0768i);
        }
        int i = this.f2282b;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        R2.a aVar = R2.a.f2018a;
        R2.a aVar2 = this.f2283c;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return AbstractC0008a.s(sb, AbstractC0707i.h0(arrayList, ", ", null, null, null, 62), ']');
    }
}
