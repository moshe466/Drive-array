package c;

import java.util.ListIterator;
import s2.C0684i;
import t2.C0704f;

/* loaded from: classes.dex */
public final /* synthetic */ class q implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3839a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f3840b;

    public /* synthetic */ q(x xVar, int i) {
        this.f3839a = i;
        this.f3840b = xVar;
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        Object obj2;
        Object obj3;
        C0325a backEvent = (C0325a) obj;
        switch (this.f3839a) {
            case 0:
                kotlin.jvm.internal.j.e(backEvent, "backEvent");
                x xVar = this.f3840b;
                C0704f c0704f = xVar.f3857b;
                ListIterator listIterator = c0704f.listIterator(c0704f.g());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj2 = listIterator.previous();
                        if (((p) obj2).isEnabled()) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                p pVar = (p) obj2;
                if (xVar.f3858c != null) {
                    xVar.b();
                }
                xVar.f3858c = pVar;
                if (pVar != null) {
                    pVar.handleOnBackStarted(backEvent);
                }
                return C0684i.f6340a;
            default:
                kotlin.jvm.internal.j.e(backEvent, "backEvent");
                x xVar2 = this.f3840b;
                p pVar2 = xVar2.f3858c;
                if (pVar2 == null) {
                    C0704f c0704f2 = xVar2.f3857b;
                    ListIterator listIterator2 = c0704f2.listIterator(c0704f2.g());
                    while (true) {
                        if (listIterator2.hasPrevious()) {
                            obj3 = listIterator2.previous();
                            if (((p) obj3).isEnabled()) {
                            }
                        } else {
                            obj3 = null;
                        }
                    }
                    pVar2 = (p) obj3;
                }
                if (pVar2 != null) {
                    pVar2.handleOnBackProgressed(backEvent);
                }
                return C0684i.f6340a;
        }
    }
}
