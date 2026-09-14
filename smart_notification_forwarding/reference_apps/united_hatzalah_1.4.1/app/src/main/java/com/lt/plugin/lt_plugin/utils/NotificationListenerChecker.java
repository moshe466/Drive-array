package com.lt.plugin.lt_plugin.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import w.p;

/* loaded from: classes.dex */
public class NotificationListenerChecker {
    private static final String TAG = "NLChecker";
    private final Context context;
    private final Set<String> dynamicWhitelist = new HashSet();
    private static final String[] WHITELISTED_PREFIXES = {"com.google.android.gms", "com.google.android.wearable.", "com.google.android.apps.wear.", "com.samsung.", "com.huawei.", "com.xiaomi.", "com.miui.", "com.oppo.", "com.coloros.", "com.oneplus.", "com.realme.", "com.vivo.", "com.bbk.", "com.motorola.", "com.lenovo.", "com.sony.", "com.lge.", "com.asus.", "com.nothing.", "com.android."};
    private static final Set<String> WHITELISTED_PACKAGES = new HashSet(Arrays.asList("com.fitbit.FitbitMobile", "com.garmin.android.apps.connectmobile"));

    public NotificationListenerChecker(Context context) {
        this.context = context.getApplicationContext();
    }

    private boolean isSystemApp(String str) {
        return InstallSourceHelper.isSystemApp(this.context, str);
    }

    private boolean isWhitelisted(String str) {
        if (isSystemApp(str) || InstallSourceHelper.isAllowedPair(str, InstallSourceHelper.getInstallerPackage(this.context, str))) {
            return true;
        }
        if (!WHITELISTED_PACKAGES.contains(str) && !this.dynamicWhitelist.contains(str) && !matchesPrefix(str)) {
            return false;
        }
        return InstallSourceHelper.hasTrustedInstallSource(this.context, str);
    }

    private boolean matchesPrefix(String str) {
        for (String str2 : WHITELISTED_PREFIXES) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private List<String> resolveDisplayNames(Set<String> set) {
        CharSequence applicationLabel;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.context.getPackageManager();
        for (String str : set) {
            try {
                applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (applicationLabel != null) {
                String trim = applicationLabel.toString().trim();
                if (!trim.isEmpty()) {
                    arrayList.add(trim);
                }
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    public List<String> getSideloadedListenerNames() {
        return resolveDisplayNames(getSideloadedListeners());
    }

    public Set<String> getSideloadedListeners() {
        HashSet hashSet = new HashSet();
        try {
            Set a2 = p.a(this.context);
            String packageName = this.context.getPackageName();
            Iterator it = ((HashSet) a2).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!str.equals(packageName) && InstallSourceHelper.isSideloaded(this.context, str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Exception e4) {
            Log.e(TAG, "Error checking sideloaded listeners", e4);
            return hashSet;
        }
    }

    public List<String> getSuspiciousListenerNames() {
        return resolveDisplayNames(getSuspiciousListeners());
    }

    public Set<String> getSuspiciousListeners() {
        HashSet hashSet = new HashSet();
        try {
            Set a2 = p.a(this.context);
            String packageName = this.context.getPackageName();
            Iterator it = ((HashSet) a2).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!str.equals(packageName) && !isWhitelisted(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Exception e4) {
            Log.e(TAG, "Error checking listeners", e4);
            return hashSet;
        }
    }

    public boolean hasSideloadedListeners() {
        return !getSideloadedListeners().isEmpty();
    }

    public boolean hasSuspiciousListeners() {
        try {
            Set a2 = p.a(this.context);
            StringBuilder sb = new StringBuilder("Enabled listener packages (");
            HashSet hashSet = (HashSet) a2;
            sb.append(hashSet.size());
            sb.append("): ");
            sb.append(hashSet);
            LogHelper.d(TAG, sb.toString());
            String packageName = this.context.getPackageName();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.equals(packageName)) {
                    LogHelper.d(TAG, "Skipping own package: " + str);
                } else if (isWhitelisted(str)) {
                    LogHelper.d(TAG, "Whitelisted: " + str);
                } else {
                    return true;
                }
            }
        } catch (Exception e4) {
            Log.e(TAG, "Error checking listeners", e4);
        }
        LogHelper.d(TAG, "No suspicious listeners found");
        return false;
    }

    public void setDynamicWhitelist(Set<String> set) {
        this.dynamicWhitelist.clear();
        if (set != null) {
            this.dynamicWhitelist.addAll(set);
        }
    }
}
