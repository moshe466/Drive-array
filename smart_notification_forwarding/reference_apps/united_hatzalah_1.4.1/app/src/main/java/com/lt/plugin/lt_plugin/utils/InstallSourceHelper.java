package com.lt.plugin.lt_plugin.utils;

import F0.AbstractC0008a;
import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class InstallSourceHelper {
    private static final Set<String> BUILTIN_ALLOWED_INSTALLERS = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.android.vending", "com.google.android.feedback")));
    private static final Set<String> remoteAllowedInstallers = new HashSet();
    private static final Set<String> remoteAllowedPairs = new HashSet();

    private InstallSourceHelper() {
    }

    public static String getInstallerPackage(Context context, String str) {
        InstallSourceInfo installSourceInfo;
        String installingPackageName;
        String initiatingPackageName;
        if (context != null && str != null && !str.isEmpty()) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (Build.VERSION.SDK_INT >= 30) {
                    installSourceInfo = packageManager.getInstallSourceInfo(str);
                    if (installSourceInfo != null) {
                        installingPackageName = installSourceInfo.getInstallingPackageName();
                        if (installingPackageName == null || installingPackageName.isEmpty()) {
                            initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                            if (initiatingPackageName != null && !initiatingPackageName.isEmpty()) {
                                return initiatingPackageName;
                            }
                            return null;
                        }
                        return installingPackageName;
                    }
                    return null;
                }
                return packageManager.getInstallerPackageName(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static boolean hasTrustedInstallSource(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            if (isFromAllowedStore(context, str)) {
                return true;
            }
            return isAllowedPair(str, getInstallerPackage(context, str));
        }
        return false;
    }

    public static synchronized boolean isAllowedPair(String str, String str2) {
        synchronized (InstallSourceHelper.class) {
            if (str != null) {
                if (!str.isEmpty()) {
                    return remoteAllowedPairs.contains(pairKey(str, str2));
                }
            }
            return false;
        }
    }

    public static boolean isFromAllowedStore(Context context, String str) {
        String installerPackage = getInstallerPackage(context, str);
        boolean z3 = false;
        if (installerPackage == null || installerPackage.isEmpty()) {
            return false;
        }
        synchronized (InstallSourceHelper.class) {
            try {
                if (!BUILTIN_ALLOWED_INSTALLERS.contains(installerPackage)) {
                    if (remoteAllowedInstallers.contains(installerPackage)) {
                    }
                }
                z3 = true;
            } finally {
            }
        }
        return z3;
    }

    public static boolean isSideloaded(Context context, String str) {
        if (isSystemApp(context, str) || isFromAllowedStore(context, str) || isAllowedPair(str, getInstallerPackage(context, str))) {
            return false;
        }
        return true;
    }

    public static boolean isSystemApp(Context context, String str) {
        if (context != null && str != null) {
            try {
                if ((context.getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private static String normalizePair(String str) {
        int indexOf;
        String trim = str.trim();
        String str2 = null;
        if (trim.isEmpty() || (indexOf = trim.indexOf(124)) <= 0 || indexOf >= trim.length() - 1) {
            return null;
        }
        String trim2 = trim.substring(0, indexOf).trim();
        String trim3 = trim.substring(indexOf + 1).trim();
        if (trim2.isEmpty()) {
            return null;
        }
        if (trim3.isEmpty()) {
            trim3 = "null";
        }
        if (!"null".equalsIgnoreCase(trim3)) {
            str2 = trim3;
        }
        return pairKey(trim2, str2);
    }

    public static String pairKey(String str, String str2) {
        String str3;
        String trim;
        if (str2 != null && !str2.trim().isEmpty()) {
            str3 = str2.trim();
        } else {
            str3 = "null";
        }
        if (str == null) {
            trim = "";
        } else {
            trim = str.trim();
        }
        return AbstractC0008a.o(trim, "|", str3);
    }

    public static String resolveAppLabel(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
                if (applicationLabel != null) {
                    return applicationLabel.toString().trim();
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return "";
    }

    public static synchronized void setRemoteAllowedInstallSources(Set<String> set) {
        synchronized (InstallSourceHelper.class) {
            remoteAllowedInstallers.clear();
            if (set != null) {
                for (String str : set) {
                    if (str != null && !str.trim().isEmpty()) {
                        remoteAllowedInstallers.add(str.trim());
                    }
                }
            }
        }
    }

    public static synchronized void setRemoteAllowedListenerInstallPairs(Set<String> set) {
        String normalizePair;
        synchronized (InstallSourceHelper.class) {
            remoteAllowedPairs.clear();
            if (set == null) {
                return;
            }
            for (String str : set) {
                if (str != null && (normalizePair = normalizePair(str)) != null) {
                    remoteAllowedPairs.add(normalizePair);
                }
            }
        }
    }
}
