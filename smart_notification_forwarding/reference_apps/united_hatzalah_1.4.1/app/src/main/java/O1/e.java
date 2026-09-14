package o1;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5923a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f5924b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f5925c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f5926d;

    public /* synthetic */ e(Activity activity, View view, j jVar) {
        this.f5925c = activity;
        this.f5924b = view;
        this.f5926d = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        View view;
        switch (this.f5923a) {
            case 0:
                View view2 = new View(this.f5925c);
                j jVar = this.f5926d;
                view2.setBackgroundColor(jVar.f5946t);
                view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                View view3 = this.f5924b;
                if (view3 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view3;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.addView(view2);
                }
                jVar.f5944r = view2;
                return;
            default:
                int i = Build.VERSION.SDK_INT;
                View view4 = this.f5924b;
                if (i >= 31) {
                    Window window = this.f5925c.getWindow();
                    if (window != null) {
                        view = window.getDecorView();
                    } else {
                        view = null;
                    }
                    if (view4 == view) {
                        view4.setRenderEffect(null);
                        this.f5926d.f5943q = null;
                        return;
                    }
                }
                ViewParent parent = view4.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) parent;
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 != null) {
                    viewGroup2.removeView(view4);
                }
                this.f5926d.f5943q = null;
                return;
        }
    }

    public /* synthetic */ e(View view, Activity activity, j jVar) {
        this.f5924b = view;
        this.f5925c = activity;
        this.f5926d = jVar;
    }
}
