package com.lt.plugin.lt_plugin.services;

import android.app.Service;
import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4386a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Service f4387b;

    public /* synthetic */ f(Service service, int i) {
        this.f4386a = i;
        this.f4387b = service;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4386a) {
            case 0:
                FloatingWindowService.b((FloatingWindowService) this.f4387b, view);
                return;
            case 1:
                FloatingWindowService.a((FloatingWindowService) this.f4387b, view);
                return;
            case 2:
                FloatingWindowService.d((FloatingWindowService) this.f4387b, view);
                return;
            default:
                ActiveDispatchOverlayService.a((ActiveDispatchOverlayService) this.f4387b, view);
                return;
        }
    }
}
