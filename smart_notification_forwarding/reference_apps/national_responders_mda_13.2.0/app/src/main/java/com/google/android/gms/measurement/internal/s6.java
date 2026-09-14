package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* loaded from: classes.dex */
public final class s6 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ w5 f6449f;

    private s6(w5 w5Var) {
        this.f6449f = w5Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s6(w5 w5Var, x5 x5Var) {
        this(w5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009d A[Catch: Exception -> 0x01d2, TRY_ENTER, TryCatch #0 {Exception -> 0x01d2, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x009d, B:16:0x00ab, B:18:0x00be, B:21:0x00c6, B:23:0x00cc, B:24:0x00df, B:26:0x00f2, B:27:0x00fb, B:30:0x010b, B:33:0x011b, B:36:0x0123, B:38:0x0129, B:39:0x0134, B:43:0x013b, B:47:0x015c, B:49:0x016f, B:50:0x0186, B:52:0x0177, B:53:0x018d, B:55:0x0193, B:57:0x0199, B:59:0x019f, B:61:0x01a5, B:63:0x01ad, B:67:0x01b8, B:69:0x01c6, B:71:0x01cc, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x007d, B:90:0x0088, B:92:0x0092, B:93:0x0082), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010b A[Catch: Exception -> 0x01d2, TRY_ENTER, TryCatch #0 {Exception -> 0x01d2, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x009d, B:16:0x00ab, B:18:0x00be, B:21:0x00c6, B:23:0x00cc, B:24:0x00df, B:26:0x00f2, B:27:0x00fb, B:30:0x010b, B:33:0x011b, B:36:0x0123, B:38:0x0129, B:39:0x0134, B:43:0x013b, B:47:0x015c, B:49:0x016f, B:50:0x0186, B:52:0x0177, B:53:0x018d, B:55:0x0193, B:57:0x0199, B:59:0x019f, B:61:0x01a5, B:63:0x01ad, B:67:0x01b8, B:69:0x01c6, B:71:0x01cc, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x007d, B:90:0x0088, B:92:0x0092, B:93:0x0082), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013b A[Catch: Exception -> 0x01d2, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d2, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x009d, B:16:0x00ab, B:18:0x00be, B:21:0x00c6, B:23:0x00cc, B:24:0x00df, B:26:0x00f2, B:27:0x00fb, B:30:0x010b, B:33:0x011b, B:36:0x0123, B:38:0x0129, B:39:0x0134, B:43:0x013b, B:47:0x015c, B:49:0x016f, B:50:0x0186, B:52:0x0177, B:53:0x018d, B:55:0x0193, B:57:0x0199, B:59:0x019f, B:61:0x01a5, B:63:0x01ad, B:67:0x01b8, B:69:0x01c6, B:71:0x01cc, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x007d, B:90:0x0088, B:92:0x0092, B:93:0x0082), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.s6.b(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        try {
            try {
                this.f6449f.h().N().a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                    this.f6449f.k();
                    this.f6449f.e().z(new v6(this, bundle == null, data, o9.a0(intent) ? "gs" : "auto", data.getQueryParameter("referrer")));
                }
            } catch (Exception e10) {
                this.f6449f.h().F().b("Throwable caught in onActivityCreated", e10);
            }
        } finally {
            this.f6449f.s().G(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f6449f.s().V(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f6449f.s().T(activity);
        p8 u10 = this.f6449f.u();
        u10.e().z(new r8(u10, u10.f().b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        p8 u10 = this.f6449f.u();
        u10.e().z(new o8(u10, u10.f().b()));
        this.f6449f.s().F(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f6449f.s().U(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
