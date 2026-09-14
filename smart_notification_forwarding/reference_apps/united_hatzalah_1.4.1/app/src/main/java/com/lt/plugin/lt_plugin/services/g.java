package com.lt.plugin.lt_plugin.services;

import android.app.Service;
import android.content.Intent;
import android.view.View;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4388a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Service f4389b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4390c;

    public /* synthetic */ g(Service service, Object obj, int i) {
        this.f4388a = i;
        this.f4389b = service;
        this.f4390c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4388a) {
            case 0:
                FloatingWindowService.f((FloatingWindowService) this.f4389b, (Intent) this.f4390c, view);
                return;
            case 1:
                FloatingWindowService.h((FloatingWindowService) this.f4389b, (Intent) this.f4390c, view);
                return;
            default:
                ActiveDispatchOverlayService.b((ActiveDispatchOverlayService) this.f4389b, (JSONObject) this.f4390c, view);
                return;
        }
    }
}
