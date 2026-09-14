package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* loaded from: classes.dex */
class InstallerPackageNameProvider {
    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private String installerPackageName;

    private static String loadInstallerPackageName(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName == null) {
            return "";
        }
        return installerPackageName;
    }

    public synchronized String getInstallerPackageName(Context context) {
        String str;
        try {
            if (this.installerPackageName == null) {
                this.installerPackageName = loadInstallerPackageName(context);
            }
            if ("".equals(this.installerPackageName)) {
                str = null;
            } else {
                str = this.installerPackageName;
            }
        } finally {
        }
        return str;
    }
}
