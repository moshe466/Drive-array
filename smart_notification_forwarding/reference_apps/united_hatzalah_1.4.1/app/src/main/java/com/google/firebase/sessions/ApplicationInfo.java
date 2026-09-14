package com.google.firebase.sessions;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class ApplicationInfo {
    private final AndroidApplicationInfo androidAppInfo;
    private final String appId;
    private final String deviceModel;
    private final LogEnvironment logEnvironment;
    private final String osVersion;
    private final String sessionSdkVersion;

    public ApplicationInfo(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, AndroidApplicationInfo androidAppInfo) {
        j.e(appId, "appId");
        j.e(deviceModel, "deviceModel");
        j.e(sessionSdkVersion, "sessionSdkVersion");
        j.e(osVersion, "osVersion");
        j.e(logEnvironment, "logEnvironment");
        j.e(androidAppInfo, "androidAppInfo");
        this.appId = appId;
        this.deviceModel = deviceModel;
        this.sessionSdkVersion = sessionSdkVersion;
        this.osVersion = osVersion;
        this.logEnvironment = logEnvironment;
        this.androidAppInfo = androidAppInfo;
    }

    public static /* synthetic */ ApplicationInfo copy$default(ApplicationInfo applicationInfo, String str, String str2, String str3, String str4, LogEnvironment logEnvironment, AndroidApplicationInfo androidApplicationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = applicationInfo.appId;
        }
        if ((i & 2) != 0) {
            str2 = applicationInfo.deviceModel;
        }
        if ((i & 4) != 0) {
            str3 = applicationInfo.sessionSdkVersion;
        }
        if ((i & 8) != 0) {
            str4 = applicationInfo.osVersion;
        }
        if ((i & 16) != 0) {
            logEnvironment = applicationInfo.logEnvironment;
        }
        if ((i & 32) != 0) {
            androidApplicationInfo = applicationInfo.androidAppInfo;
        }
        LogEnvironment logEnvironment2 = logEnvironment;
        AndroidApplicationInfo androidApplicationInfo2 = androidApplicationInfo;
        return applicationInfo.copy(str, str2, str3, str4, logEnvironment2, androidApplicationInfo2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.deviceModel;
    }

    public final String component3() {
        return this.sessionSdkVersion;
    }

    public final String component4() {
        return this.osVersion;
    }

    public final LogEnvironment component5() {
        return this.logEnvironment;
    }

    public final AndroidApplicationInfo component6() {
        return this.androidAppInfo;
    }

    public final ApplicationInfo copy(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, AndroidApplicationInfo androidAppInfo) {
        j.e(appId, "appId");
        j.e(deviceModel, "deviceModel");
        j.e(sessionSdkVersion, "sessionSdkVersion");
        j.e(osVersion, "osVersion");
        j.e(logEnvironment, "logEnvironment");
        j.e(androidAppInfo, "androidAppInfo");
        return new ApplicationInfo(appId, deviceModel, sessionSdkVersion, osVersion, logEnvironment, androidAppInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        return j.a(this.appId, applicationInfo.appId) && j.a(this.deviceModel, applicationInfo.deviceModel) && j.a(this.sessionSdkVersion, applicationInfo.sessionSdkVersion) && j.a(this.osVersion, applicationInfo.osVersion) && this.logEnvironment == applicationInfo.logEnvironment && j.a(this.androidAppInfo, applicationInfo.androidAppInfo);
    }

    public final AndroidApplicationInfo getAndroidAppInfo() {
        return this.androidAppInfo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final LogEnvironment getLogEnvironment() {
        return this.logEnvironment;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getSessionSdkVersion() {
        return this.sessionSdkVersion;
    }

    public int hashCode() {
        return this.androidAppInfo.hashCode() + ((this.logEnvironment.hashCode() + AbstractC0008a.g(this.osVersion, AbstractC0008a.g(this.sessionSdkVersion, AbstractC0008a.g(this.deviceModel, this.appId.hashCode() * 31, 31), 31), 31)) * 31);
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", sessionSdkVersion=" + this.sessionSdkVersion + ", osVersion=" + this.osVersion + ", logEnvironment=" + this.logEnvironment + ", androidAppInfo=" + this.androidAppInfo + ')';
    }
}
