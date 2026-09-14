package com.google.firebase.installations;

import i2.C0451b;
import io.flutter.plugin.common.EventChannel;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4302b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4303c;

    public /* synthetic */ a(Object obj, boolean z3, int i) {
        this.f4301a = i;
        this.f4302b = obj;
        this.f4303c = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4301a) {
            case 0:
                FirebaseInstallations.c((FirebaseInstallations) this.f4302b, this.f4303c);
                return;
            case 1:
                FirebaseInstallations.b((FirebaseInstallations) this.f4302b, this.f4303c);
                return;
            default:
                EventChannel.EventSink eventSink = ((C0451b) this.f4302b).f4986k;
                if (eventSink != null) {
                    eventSink.success(Boolean.valueOf(this.f4303c));
                    return;
                }
                return;
        }
    }
}
