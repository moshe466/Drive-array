package m;

import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class F0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5524a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f5525b;

    public /* synthetic */ F0(I0 i02, int i) {
        this.f5524a = i;
        this.f5525b = i02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f5524a;
        I0 i02 = this.f5525b;
        switch (i) {
            case 0:
                C0576w0 c0576w0 = i02.f5536c;
                if (c0576w0 != null) {
                    c0576w0.setListSelectionHidden(true);
                    c0576w0.requestLayout();
                    return;
                }
                return;
            default:
                C0576w0 c0576w02 = i02.f5536c;
                if (c0576w02 != null) {
                    WeakHashMap weakHashMap = J.S.f954a;
                    if (c0576w02.isAttachedToWindow() && i02.f5536c.getCount() > i02.f5536c.getChildCount() && i02.f5536c.getChildCount() <= i02.p) {
                        i02.f5533B.setInputMethodMode(2);
                        i02.show();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
