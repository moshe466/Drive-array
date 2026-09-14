package h;

import J.S;
import J.X;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4842a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f4843b;

    public /* synthetic */ p(y yVar, int i) {
        this.f4842a = i;
        this.f4843b = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        int i = this.f4842a;
        y yVar = this.f4843b;
        int i3 = 0;
        switch (i) {
            case 0:
                if ((yVar.f4903c0 & 1) != 0) {
                    yVar.v(0);
                }
                if ((yVar.f4903c0 & 4096) != 0) {
                    yVar.v(108);
                }
                yVar.f4902b0 = false;
                yVar.f4903c0 = 0;
                return;
            default:
                yVar.f4922z.showAtLocation(yVar.y, 55, 0, 0);
                X x3 = yVar.f4876B;
                if (x3 != null) {
                    x3.b();
                }
                if (yVar.f4877C && (viewGroup = yVar.f4878D) != null) {
                    WeakHashMap weakHashMap = S.f954a;
                    if (viewGroup.isLaidOut()) {
                        yVar.y.setAlpha(0.0f);
                        X a2 = S.a(yVar.y);
                        a2.a(1.0f);
                        yVar.f4876B = a2;
                        a2.d(new r(this, i3));
                        return;
                    }
                }
                yVar.y.setAlpha(1.0f);
                yVar.y.setVisibility(0);
                return;
        }
    }
}
