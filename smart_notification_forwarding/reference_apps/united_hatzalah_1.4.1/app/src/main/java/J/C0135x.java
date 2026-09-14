package J;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* renamed from: J.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0135x implements InterfaceC0136y {

    /* renamed from: a, reason: collision with root package name */
    public final ScrollFeedbackProvider f1036a;

    public C0135x(NestedScrollView nestedScrollView) {
        this.f1036a = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // J.InterfaceC0136y
    public final void onScrollLimit(int i, int i3, int i4, boolean z3) {
        this.f1036a.onScrollLimit(i, i3, i4, z3);
    }

    @Override // J.InterfaceC0136y
    public final void onScrollProgress(int i, int i3, int i4, int i5) {
        this.f1036a.onScrollProgress(i, i3, i4, i5);
    }
}
