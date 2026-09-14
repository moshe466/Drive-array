package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.content.Context;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* loaded from: classes.dex */
public class FakeAppUpdateManager implements AppUpdateManager {
    private final a a;
    private final Context b;

    @InstallStatus
    private int c = 0;

    @InstallErrorCode
    private int d = 0;
    private boolean e = false;
    private int f = 0;
    private int g = -1;
    private long h = 0;
    private long i = 0;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    @AppUpdateType
    private Integer m;

    @AppUpdateType
    private Integer n;

    public FakeAppUpdateManager(Context context) {
        this.a = new a(context);
        this.b = context;
    }

    @UpdateAvailability
    private final int a() {
        if (!this.e) {
            return 1;
        }
        int i = this.c;
        return (i == 0 || i == 4 || i == 5 || i == 6) ? 2 : 3;
    }

    private final boolean a(AppUpdateInfo appUpdateInfo, @AppUpdateType int i) {
        int i2;
        if (!appUpdateInfo.isUpdateTypeAllowed(i)) {
            return false;
        }
        if (i == 1) {
            this.k = true;
            i2 = 1;
        } else {
            this.j = true;
            i2 = 0;
        }
        this.n = i2;
        return true;
    }

    private final void b() {
        this.a.a((a) InstallState.a(this.c, 0L, 0L, this.d, this.b.getPackageName()));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task<Void> completeUpdate() {
        int i = this.d;
        if (i != 0 && i != 1) {
            return Tasks.a((Exception) new InstallException(i));
        }
        int i2 = this.c;
        if (i2 != 11) {
            return i2 == 3 ? Tasks.a((Exception) new InstallException(-8)) : Tasks.a((Exception) new InstallException(-7));
        }
        this.c = 3;
        this.l = true;
        Integer num = 0;
        if (num.equals(this.n)) {
            b();
        }
        return Tasks.a((Object) null);
    }

    public void downloadCompletes() {
        int i = this.c;
        if (i == 2 || i == 1) {
            this.c = 11;
            this.h = 0L;
            this.i = 0L;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.n)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i = this.c;
        if (i == 1 || i == 2) {
            this.c = 5;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.k = false;
            this.c = 0;
        }
    }

    public void downloadStarts() {
        if (this.c == 1) {
            this.c = 2;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r1.equals(r17.m) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r1.equals(r17.m) != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.play.core.tasks.Task<com.google.android.play.core.appupdate.AppUpdateInfo> getAppUpdateInfo() {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.d
            r2 = 1
            if (r1 == 0) goto L13
            if (r1 == r2) goto L13
            com.google.android.play.core.install.InstallException r2 = new com.google.android.play.core.install.InstallException
            r2.<init>(r1)
            com.google.android.play.core.tasks.Task r1 = com.google.android.play.core.tasks.Tasks.a(r2)
            return r1
        L13:
            int r1 = r17.a()
            r3 = 2
            r4 = 0
            r5 = 0
            if (r1 != r3) goto L3c
            int r1 = r0.d
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L3c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r6 = r0.m
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L3c
        L2e:
            android.content.Context r1 = r0.b
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.app.PendingIntent r1 = android.app.PendingIntent.getBroadcast(r1, r5, r6, r5)
            r16 = r1
            goto L3e
        L3c:
            r16 = r4
        L3e:
            int r1 = r17.a()
            if (r1 != r3) goto L61
            int r1 = r0.d
            if (r1 == 0) goto L56
            if (r1 != r2) goto L61
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r2 = r0.m
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L61
        L56:
            android.content.Context r1 = r0.b
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            android.app.PendingIntent r4 = android.app.PendingIntent.getBroadcast(r1, r5, r2, r5)
        L61:
            r15 = r4
            android.content.Context r1 = r0.b
            java.lang.String r6 = r1.getPackageName()
            int r7 = r0.f
            int r8 = r17.a()
            int r9 = r0.c
            int r10 = r0.g
            r11 = 0
            r13 = 0
            com.google.android.play.core.appupdate.AppUpdateInfo r1 = com.google.android.play.core.appupdate.AppUpdateInfo.a(r6, r7, r8, r9, r10, r11, r13, r15, r16)
            com.google.android.play.core.tasks.Task r1 = com.google.android.play.core.tasks.Tasks.a(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.appupdate.testing.FakeAppUpdateManager.getAppUpdateInfo():com.google.android.play.core.tasks.Task");
    }

    @AppUpdateType
    public Integer getPartiallyAllowedUpdateType() {
        return this.m;
    }

    @AppUpdateType
    public Integer getTypeForUpdateInProgress() {
        return this.n;
    }

    public void installCompletes() {
        if (this.c == 3) {
            this.c = 4;
            this.e = false;
            this.f = 0;
            this.g = -1;
            this.h = 0L;
            this.i = 0L;
            this.k = false;
            this.l = false;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.c = 0;
        }
    }

    public void installFails() {
        if (this.c == 3) {
            this.c = 5;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.l = false;
            this.k = false;
            this.c = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.j;
    }

    public boolean isImmediateFlowVisible() {
        return this.k;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.l;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.a.a((StateUpdatedListener) installStateUpdatedListener);
    }

    public void setInstallErrorCode(@InstallErrorCode int i) {
        this.d = i;
    }

    public void setPartiallyAllowedUpdateType(@AppUpdateType Integer num) {
        this.m = num;
        this.d = 1;
    }

    public void setUpdateAvailable(int i) {
        this.e = true;
        this.f = i;
    }

    public void setUpdateNotAvailable() {
        this.e = false;
        this.g = -1;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, Activity activity, int i2) {
        return a(appUpdateInfo, i);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        return a(appUpdateInfo, i);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.a.b(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.j || this.k) {
            this.j = false;
            this.c = 1;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
        }
    }

    public void userCancelsDownload() {
        int i = this.c;
        if (i == 1 || i == 2) {
            this.c = 6;
            Integer num = 0;
            if (num.equals(this.n)) {
                b();
            }
            this.n = null;
            this.k = false;
            this.c = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.j || this.k) {
            this.j = false;
            this.k = false;
            this.n = null;
            this.c = 0;
        }
    }
}
