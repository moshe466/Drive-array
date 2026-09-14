package P2;

import w2.InterfaceC0766g;
import w2.InterfaceC0768i;

/* renamed from: P2.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0173x extends kotlin.jvm.internal.k implements F2.p {

    /* renamed from: b, reason: collision with root package name */
    public static final C0173x f1711b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0173x f1712c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1713a;

    static {
        int i = 2;
        f1711b = new C0173x(i, 0);
        f1712c = new C0173x(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0173x(int i, int i3) {
        super(i);
        this.f1713a = i3;
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1713a) {
            case 0:
                return ((InterfaceC0768i) obj).plus((InterfaceC0766g) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            default:
                return ((InterfaceC0768i) obj).plus((InterfaceC0766g) obj2);
        }
    }
}
