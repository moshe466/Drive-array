package q0;

import android.view.View;

/* loaded from: classes.dex */
public final class g extends r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6084a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6085b;

    public /* synthetic */ g() {
        this.f6084a = 2;
    }

    @Override // q0.r, q0.p
    public void a(q qVar) {
        switch (this.f6084a) {
            case 2:
                v vVar = (v) this.f6085b;
                if (!vVar.f6130B) {
                    vVar.F();
                    vVar.f6130B = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // q0.p
    public final void e(q qVar) {
        switch (this.f6084a) {
            case 0:
                View view = (View) this.f6085b;
                z zVar = y.f6139a;
                zVar.O(view, 1.0f);
                zVar.getClass();
                qVar.w(this);
                return;
            case 1:
                ((q) this.f6085b).z();
                qVar.w(this);
                return;
            default:
                v vVar = (v) this.f6085b;
                int i = vVar.f6129A - 1;
                vVar.f6129A = i;
                if (i == 0) {
                    vVar.f6130B = false;
                    vVar.n();
                }
                qVar.w(this);
                return;
        }
    }

    public /* synthetic */ g(Object obj, int i) {
        this.f6084a = i;
        this.f6085b = obj;
    }
}
