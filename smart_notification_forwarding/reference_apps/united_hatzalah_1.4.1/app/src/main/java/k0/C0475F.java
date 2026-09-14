package k0;

import J.C0114b;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: k0.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0475F extends C0114b {

    /* renamed from: d, reason: collision with root package name */
    public final C0476G f5176d;

    public C0475F(C0476G c0476g) {
        this.f5176d = c0476g;
    }

    @Override // J.C0114b
    public final void b(View view, K.f fVar) {
        this.f974a.onInitializeAccessibilityNodeInfo(view, fVar.f1063a);
        C0476G c0476g = this.f5176d;
        RecyclerView recyclerView = c0476g.f5177d;
        RecyclerView recyclerView2 = c0476g.f5177d;
        if (!recyclerView.l() && recyclerView2.getLayoutManager() != null) {
            recyclerView2.getLayoutManager().getClass();
            RecyclerView.j(view);
        }
    }

    @Override // J.C0114b
    public final boolean c(View view, int i, Bundle bundle) {
        if (super.c(view, i, bundle)) {
            return true;
        }
        C0476G c0476g = this.f5176d;
        RecyclerView recyclerView = c0476g.f5177d;
        RecyclerView recyclerView2 = c0476g.f5177d;
        if (!recyclerView.l() && recyclerView2.getLayoutManager() != null) {
            z zVar = recyclerView2.getLayoutManager().f5269b.f3698a;
        }
        return false;
    }
}
