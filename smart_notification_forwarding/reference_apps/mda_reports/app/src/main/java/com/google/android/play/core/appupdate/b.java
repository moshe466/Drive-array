package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;

/* loaded from: classes.dex */
final class b implements AppUpdateManager {
    private final c a;
    private final a b;
    private final Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, Context context) {
        this.a = cVar;
        this.b = new a(context);
        this.c = context;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Void> completeUpdate() {
        return this.a.b(this.c.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return this.a.a(this.c.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.b.a((StateUpdatedListener) installStateUpdatedListener);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, Activity activity, int i2) {
        return startUpdateFlowForResult(appUpdateInfo, i, new d(activity), i2);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        if (!appUpdateInfo.isUpdateTypeAllowed(i)) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult((i == 0 ? appUpdateInfo.e() : i == 1 ? appUpdateInfo.d() : null).getIntentSender(), i2, null, 0, 0, 0, null);
        return true;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.b.b(installStateUpdatedListener);
    }
}
