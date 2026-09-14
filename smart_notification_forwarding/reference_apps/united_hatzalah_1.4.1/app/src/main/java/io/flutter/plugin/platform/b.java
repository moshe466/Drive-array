package io.flutter.plugin.platform;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5038a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5039b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PlatformViewsAccessibilityDelegate f5040c;

    public /* synthetic */ b(PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate, int i, int i3) {
        this.f5038a = i3;
        this.f5040c = platformViewsAccessibilityDelegate;
        this.f5039b = i;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z3) {
        switch (this.f5038a) {
            case 0:
                ((PlatformViewsController) this.f5040c).lambda$initializePlatformViewIfNeeded$2(this.f5039b, view, z3);
                return;
            default:
                ((PlatformViewsController2) this.f5040c).lambda$initializePlatformViewIfNeeded$0(this.f5039b, view, z3);
                return;
        }
    }
}
