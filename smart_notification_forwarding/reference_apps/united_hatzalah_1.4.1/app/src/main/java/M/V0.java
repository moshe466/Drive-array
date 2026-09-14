package m;

import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class V0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5606a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f5607b;

    public /* synthetic */ V0(SearchView searchView, int i) {
        this.f5606a = i;
        this.f5607b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5606a) {
            case 0:
                this.f5607b.r();
                return;
            default:
                P.c cVar = this.f5607b.f2894R;
                if (cVar instanceof f1) {
                    cVar.b(null);
                    return;
                }
                return;
        }
    }
}
