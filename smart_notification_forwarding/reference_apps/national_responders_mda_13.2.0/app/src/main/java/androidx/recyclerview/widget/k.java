package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class k extends androidx.core.view.a {

    /* renamed from: d, reason: collision with root package name */
    final RecyclerView f3639d;

    /* renamed from: e, reason: collision with root package name */
    final androidx.core.view.a f3640e = new a(this);

    /* loaded from: classes.dex */
    public static class a extends androidx.core.view.a {

        /* renamed from: d, reason: collision with root package name */
        final k f3641d;

        public a(k kVar) {
            this.f3641d = kVar;
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            super.g(view, dVar);
            if (this.f3641d.o() || this.f3641d.f3639d.getLayoutManager() == null) {
                return;
            }
            this.f3641d.f3639d.getLayoutManager().O0(view, dVar);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            if (this.f3641d.o() || this.f3641d.f3639d.getLayoutManager() == null) {
                return false;
            }
            return this.f3641d.f3639d.getLayoutManager().i1(view, i10, bundle);
        }
    }

    public k(RecyclerView recyclerView) {
        this.f3639d = recyclerView;
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().K0(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.a
    public void g(View view, androidx.core.view.accessibility.d dVar) {
        super.g(view, dVar);
        dVar.V(RecyclerView.class.getName());
        if (o() || this.f3639d.getLayoutManager() == null) {
            return;
        }
        this.f3639d.getLayoutManager().M0(dVar);
    }

    @Override // androidx.core.view.a
    public boolean j(View view, int i10, Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (o() || this.f3639d.getLayoutManager() == null) {
            return false;
        }
        return this.f3639d.getLayoutManager().g1(i10, bundle);
    }

    public androidx.core.view.a n() {
        return this.f3640e;
    }

    boolean o() {
        return this.f3639d.o0();
    }
}
