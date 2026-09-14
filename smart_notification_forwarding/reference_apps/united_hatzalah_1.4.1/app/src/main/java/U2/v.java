package U2;

import P2.E0;
import w2.InterfaceC0766g;

/* loaded from: classes.dex */
public final class v extends kotlin.jvm.internal.k implements F2.p {

    /* renamed from: b, reason: collision with root package name */
    public static final v f2379b;

    /* renamed from: c, reason: collision with root package name */
    public static final v f2380c;

    /* renamed from: d, reason: collision with root package name */
    public static final v f2381d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2382a;

    static {
        int i = 2;
        f2379b = new v(i, 0);
        f2380c = new v(i, 1);
        f2381d = new v(i, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(int i, int i3) {
        super(i);
        this.f2382a = i3;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        Integer num;
        int i;
        switch (this.f2382a) {
            case 0:
                InterfaceC0766g interfaceC0766g = (InterfaceC0766g) obj2;
                if (interfaceC0766g instanceof E0) {
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        return interfaceC0766g;
                    }
                    return Integer.valueOf(i + 1);
                }
                return obj;
            case 1:
                E0 e02 = (E0) obj;
                InterfaceC0766g interfaceC0766g2 = (InterfaceC0766g) obj2;
                if (e02 == null) {
                    if (interfaceC0766g2 instanceof E0) {
                        return (E0) interfaceC0766g2;
                    }
                    return null;
                }
                return e02;
            default:
                return (x) obj;
        }
    }
}
