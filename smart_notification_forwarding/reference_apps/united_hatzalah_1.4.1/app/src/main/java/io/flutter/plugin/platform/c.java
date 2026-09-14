package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewCreationRequest;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5041a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f5042b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PlatformViewCreationRequest f5043c;

    public /* synthetic */ c(PlatformViewsController platformViewsController, PlatformViewCreationRequest platformViewCreationRequest, int i) {
        this.f5041a = i;
        this.f5042b = platformViewsController;
        this.f5043c = platformViewCreationRequest;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z3) {
        switch (this.f5041a) {
            case 0:
                PlatformViewsController.a(this.f5042b, this.f5043c, view, z3);
                return;
            default:
                PlatformViewsController.c(this.f5042b, this.f5043c, view, z3);
                return;
        }
    }
}
