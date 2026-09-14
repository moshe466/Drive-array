package G;

import F0.C0018c1;
import java.util.ArrayList;
import t.C0694j;

/* loaded from: classes.dex */
public final class f implements I.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f783a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f784b;

    public /* synthetic */ f(Object obj, int i) {
        this.f783a = i;
        this.f784b = obj;
    }

    @Override // I.a, androidx.window.extensions.core.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f783a) {
            case 0:
                g gVar = (g) obj;
                if (gVar == null) {
                    gVar = new g(-3);
                }
                ((C0018c1) this.f784b).i(gVar);
                return;
            default:
                g gVar2 = (g) obj;
                synchronized (h.f789c) {
                    try {
                        C0694j c0694j = h.f790d;
                        ArrayList arrayList = (ArrayList) c0694j.get((String) this.f784b);
                        if (arrayList != null) {
                            c0694j.remove((String) this.f784b);
                            for (int i = 0; i < arrayList.size(); i++) {
                                ((I.a) arrayList.get(i)).accept(gVar2);
                            }
                            return;
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
