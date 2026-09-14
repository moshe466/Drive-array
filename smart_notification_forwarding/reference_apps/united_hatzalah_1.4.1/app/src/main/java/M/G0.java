package m;

import android.widget.AbsListView;

/* loaded from: classes.dex */
public final class G0 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I0 f5528a;

    public G0(I0 i02) {
        this.f5528a = i02;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        I0 i02 = this.f5528a;
        F0 f02 = i02.f5549t;
        if (i == 1 && i02.f5533B.getInputMethodMode() != 2 && i02.f5533B.getContentView() != null) {
            i02.f5553x.removeCallbacks(f02);
            f02.run();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i3, int i4) {
    }
}
