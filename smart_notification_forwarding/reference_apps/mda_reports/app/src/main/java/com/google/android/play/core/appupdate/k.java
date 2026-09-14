package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends AppUpdateInfo {
    private final String a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final long f;
    private final long g;
    private final PendingIntent h;
    private final PendingIntent i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, int i, int i2, int i3, int i4, long j, long j2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = j;
        this.g = j2;
        this.h = pendingIntent;
        this.i = pendingIntent2;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final int a() {
        return this.e;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final int availableVersionCode() {
        return this.b;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long b() {
        return this.f;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final long c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final PendingIntent d() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final PendingIntent e() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateInfo) {
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (this.a.equals(appUpdateInfo.packageName()) && this.b == appUpdateInfo.availableVersionCode() && this.c == appUpdateInfo.updateAvailability() && this.d == appUpdateInfo.installStatus() && this.e == appUpdateInfo.a() && this.f == appUpdateInfo.b() && this.g == appUpdateInfo.c() && ((pendingIntent = this.h) != null ? pendingIntent.equals(appUpdateInfo.d()) : appUpdateInfo.d() == null)) {
                PendingIntent pendingIntent2 = this.i;
                PendingIntent e = appUpdateInfo.e();
                if (pendingIntent2 != null ? pendingIntent2.equals(e) : e == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003;
        long j = this.f;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        PendingIntent pendingIntent = this.h;
        int hashCode2 = (i2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        PendingIntent pendingIntent2 = this.i;
        return hashCode2 ^ (pendingIntent2 != null ? pendingIntent2.hashCode() : 0);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @InstallStatus
    public final int installStatus() {
        return this.d;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    public final String packageName() {
        return this.a;
    }

    public final String toString() {
        String str = this.a;
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        int i4 = this.e;
        long j = this.f;
        long j2 = this.g;
        String valueOf = String.valueOf(this.h);
        String valueOf2 = String.valueOf(this.i);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 288 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i);
        sb.append(", updateAvailability=");
        sb.append(i2);
        sb.append(", installStatus=");
        sb.append(i3);
        sb.append(", clientVersionStalenessDays=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf);
        sb.append(", flexibleUpdateIntent=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateInfo
    @UpdateAvailability
    public final int updateAvailability() {
        return this.c;
    }
}
