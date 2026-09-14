package h;

import F0.C0021d0;
import J.S;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class r extends m3.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4845d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f4846e;

    public /* synthetic */ r(Object obj, int i) {
        this.f4845d = i;
        this.f4846e = obj;
    }

    @Override // m3.b, J.Y
    public void b() {
        int i = this.f4845d;
        Object obj = this.f4846e;
        switch (i) {
            case 0:
                ((p) obj).f4843b.y.setVisibility(0);
                return;
            case 1:
                y yVar = (y) obj;
                yVar.y.setVisibility(0);
                if (yVar.y.getParent() instanceof View) {
                    View view = (View) yVar.y.getParent();
                    WeakHashMap weakHashMap = S.f954a;
                    J.H.c(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // J.Y
    public final void c() {
        int i = this.f4845d;
        Object obj = this.f4846e;
        switch (i) {
            case 0:
                y yVar = ((p) obj).f4843b;
                yVar.y.setAlpha(1.0f);
                yVar.f4876B.d(null);
                yVar.f4876B = null;
                return;
            case 1:
                y yVar2 = (y) obj;
                yVar2.y.setAlpha(1.0f);
                yVar2.f4876B.d(null);
                yVar2.f4876B = null;
                return;
            default:
                y yVar3 = (y) ((C0021d0) obj).f480b;
                yVar3.y.setVisibility(8);
                PopupWindow popupWindow = yVar3.f4922z;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (yVar3.y.getParent() instanceof View) {
                    View view = (View) yVar3.y.getParent();
                    WeakHashMap weakHashMap = S.f954a;
                    J.H.c(view);
                }
                yVar3.y.e();
                yVar3.f4876B.d(null);
                yVar3.f4876B = null;
                ViewGroup viewGroup = yVar3.f4878D;
                WeakHashMap weakHashMap2 = S.f954a;
                J.H.c(viewGroup);
                return;
        }
    }
}
