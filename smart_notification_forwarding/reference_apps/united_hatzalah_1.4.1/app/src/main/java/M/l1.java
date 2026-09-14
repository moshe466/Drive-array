package m;

import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final /* synthetic */ class l1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5718a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f5719b;

    public /* synthetic */ l1(Toolbar toolbar, int i) {
        this.f5718a = i;
        this.f5719b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.o oVar;
        switch (this.f5718a) {
            case 0:
                n1 n1Var = this.f5719b.f2978P;
                if (n1Var == null) {
                    oVar = null;
                } else {
                    oVar = n1Var.f5731b;
                }
                if (oVar != null) {
                    oVar.collapseActionView();
                    return;
                }
                return;
            default:
                this.f5719b.m();
                return;
        }
    }
}
