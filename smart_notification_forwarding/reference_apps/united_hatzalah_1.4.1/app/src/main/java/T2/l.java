package T2;

import F0.AbstractC0008a;
import P2.G;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s2.C0681f;
import s2.C0684i;
import t2.AbstractC0707i;
import t2.AbstractC0708j;
import t2.AbstractC0709k;
import w2.C0769j;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;
import y2.AbstractC0787c;
import y2.InterfaceC0788d;

/* loaded from: classes.dex */
public final class l extends AbstractC0787c implements S2.e {

    /* renamed from: a, reason: collision with root package name */
    public final S2.e f2293a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0768i f2294b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2295c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0768i f2296d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0763d f2297e;

    public l(S2.e eVar, InterfaceC0768i interfaceC0768i) {
        super(i.f2290a, C0769j.f6733a);
        this.f2293a = eVar;
        this.f2294b = interfaceC0768i;
        this.f2295c = ((Number) interfaceC0768i.fold(0, k.f2292a)).intValue();
    }

    public final Object a(InterfaceC0763d interfaceC0763d, Object obj) {
        Comparable comparable;
        int i;
        String str;
        InterfaceC0768i context = interfaceC0763d.getContext();
        G.i(context);
        InterfaceC0768i interfaceC0768i = this.f2296d;
        if (interfaceC0768i != context) {
            int i3 = 0;
            if (interfaceC0768i instanceof g) {
                String str2 = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((g) interfaceC0768i).f2288a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                kotlin.jvm.internal.j.e(str2, "<this>");
                List B3 = M2.f.B(new D2.c(str2, 3));
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : B3) {
                    if (!N2.f.U((String) obj2)) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(arrayList, 10));
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj3 = arrayList.get(i4);
                    i4++;
                    String str3 = (String) obj3;
                    int length = str3.length();
                    int i5 = 0;
                    while (true) {
                        if (i5 < length) {
                            if (!T.b.z(str3.charAt(i5))) {
                                break;
                            }
                            i5++;
                        } else {
                            i5 = -1;
                            break;
                        }
                    }
                    if (i5 == -1) {
                        i5 = str3.length();
                    }
                    arrayList2.add(Integer.valueOf(i5));
                }
                Iterator it = arrayList2.iterator();
                if (!it.hasNext()) {
                    comparable = null;
                } else {
                    comparable = (Comparable) it.next();
                    while (it.hasNext()) {
                        Comparable comparable2 = (Comparable) it.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                }
                Integer num = (Integer) comparable;
                if (num != null) {
                    i = num.intValue();
                } else {
                    i = 0;
                }
                int length2 = str2.length();
                B3.size();
                int size2 = B3.size() - 1;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj4 : B3) {
                    int i6 = i3 + 1;
                    if (i3 >= 0) {
                        String str4 = (String) obj4;
                        if ((i3 == 0 || i3 == size2) && N2.f.U(str4)) {
                            str = null;
                        } else {
                            kotlin.jvm.internal.j.e(str4, "<this>");
                            if (i >= 0) {
                                int length3 = str4.length();
                                if (i <= length3) {
                                    length3 = i;
                                }
                                str = str4.substring(length3);
                                kotlin.jvm.internal.j.d(str, "substring(...)");
                            } else {
                                throw new IllegalArgumentException(AbstractC0008a.j(i, "Requested character count ", " is less than zero.").toString());
                            }
                        }
                        if (str != null) {
                            arrayList3.add(str);
                        }
                        i3 = i6;
                    } else {
                        AbstractC0708j.X();
                        throw null;
                    }
                }
                StringBuilder sb = new StringBuilder(length2);
                AbstractC0707i.g0(arrayList3, sb, "\n", "", "", "...", null);
                throw new IllegalStateException(sb.toString().toString());
            }
            if (((Number) context.fold(0, new o(this))).intValue() == this.f2295c) {
                this.f2296d = context;
            } else {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f2294b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
        }
        this.f2297e = interfaceC0763d;
        F2.q qVar = n.f2299a;
        S2.e eVar = this.f2293a;
        kotlin.jvm.internal.j.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object invoke = qVar.invoke(eVar, obj, this);
        if (!kotlin.jvm.internal.j.a(invoke, EnumC0779a.f6740a)) {
            this.f2297e = null;
        }
        return invoke;
    }

    @Override // S2.e
    public final Object emit(Object obj, InterfaceC0763d interfaceC0763d) {
        try {
            Object a2 = a(interfaceC0763d, obj);
            if (a2 == EnumC0779a.f6740a) {
                return a2;
            }
            return C0684i.f6340a;
        } catch (Throwable th) {
            this.f2296d = new g(th, interfaceC0763d.getContext());
            throw th;
        }
    }

    @Override // y2.AbstractC0785a, y2.InterfaceC0788d
    public final InterfaceC0788d getCallerFrame() {
        InterfaceC0763d interfaceC0763d = this.f2297e;
        if (interfaceC0763d instanceof InterfaceC0788d) {
            return (InterfaceC0788d) interfaceC0763d;
        }
        return null;
    }

    @Override // y2.AbstractC0787c, w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        InterfaceC0768i interfaceC0768i = this.f2296d;
        if (interfaceC0768i == null) {
            return C0769j.f6733a;
        }
        return interfaceC0768i;
    }

    @Override // y2.AbstractC0785a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Throwable a2 = C0681f.a(obj);
        if (a2 != null) {
            this.f2296d = new g(a2, getContext());
        }
        InterfaceC0763d interfaceC0763d = this.f2297e;
        if (interfaceC0763d != null) {
            interfaceC0763d.resumeWith(obj);
        }
        return EnumC0779a.f6740a;
    }
}
