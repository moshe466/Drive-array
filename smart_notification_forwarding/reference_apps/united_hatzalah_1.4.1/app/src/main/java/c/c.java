package c;

import androidx.fragment.app.L;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3814a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ L f3815b;

    public /* synthetic */ c(L l3, int i) {
        this.f3814a = i;
        this.f3815b = l3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3814a) {
            case 0:
                this.f3815b.invalidateMenu();
                return;
            default:
                m.b(this.f3815b);
                return;
        }
    }
}
