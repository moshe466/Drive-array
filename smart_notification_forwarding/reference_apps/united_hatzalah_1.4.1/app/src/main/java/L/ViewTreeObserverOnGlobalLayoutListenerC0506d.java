package l;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.AbstractC0529H;
import m.AbstractC0530I;
import m.O;
import m.O0;
import m.S;

/* renamed from: l.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0506d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5356b;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0506d(Object obj, int i) {
        this.f5355a = i;
        this.f5356b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i = this.f5355a;
        Object obj = this.f5356b;
        switch (i) {
            case 0:
                ViewOnKeyListenerC0509g viewOnKeyListenerC0509g = (ViewOnKeyListenerC0509g) obj;
                ArrayList arrayList = viewOnKeyListenerC0509g.f5371k;
                if (viewOnKeyListenerC0509g.a() && arrayList.size() > 0) {
                    int i3 = 0;
                    if (!((C0508f) arrayList.get(0)).f5359a.f5532A) {
                        View view = viewOnKeyListenerC0509g.f5377r;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i3 < size) {
                                Object obj2 = arrayList.get(i3);
                                i3++;
                                ((C0508f) obj2).f5359a.show();
                            }
                            return;
                        }
                        viewOnKeyListenerC0509g.dismiss();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                ViewOnKeyListenerC0501E viewOnKeyListenerC0501E = (ViewOnKeyListenerC0501E) obj;
                O0 o02 = viewOnKeyListenerC0501E.f5325k;
                if (viewOnKeyListenerC0501E.a() && !o02.f5532A) {
                    View view2 = viewOnKeyListenerC0501E.p;
                    if (view2 != null && view2.isShown()) {
                        o02.show();
                        return;
                    } else {
                        viewOnKeyListenerC0501E.dismiss();
                        return;
                    }
                }
                return;
            case 2:
                S s3 = (S) obj;
                if (!s3.getInternalPopup().a()) {
                    s3.f5590f.l(AbstractC0530I.b(s3), AbstractC0530I.a(s3));
                }
                ViewTreeObserver viewTreeObserver = s3.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    AbstractC0529H.a(viewTreeObserver, this);
                    return;
                }
                return;
            default:
                O o2 = (O) obj;
                S s4 = o2.f5572I;
                o2.getClass();
                WeakHashMap weakHashMap = J.S.f954a;
                if (s4.isAttachedToWindow() && s4.getGlobalVisibleRect(o2.f5570G)) {
                    o2.r();
                    o2.show();
                    return;
                } else {
                    o2.dismiss();
                    return;
                }
        }
    }
}
