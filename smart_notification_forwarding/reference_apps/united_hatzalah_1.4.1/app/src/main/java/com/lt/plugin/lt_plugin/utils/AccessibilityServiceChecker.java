package com.lt.plugin.lt_plugin.utils;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class AccessibilityServiceChecker {
    private static final String TAG = "A11yChecker";
    private static final Set<String> WHITELISTED_PACKAGES = new HashSet(Arrays.asList("com.google.android.marvin.talkback", "com.google.android.apps.switchaccess", "com.google.android.accessibility.menu", "com.google.android.apps.accessibility.voiceaccess", "com.google.android.apps.accessibility.auditor", "com.google.android.apps.accessibility.vision.scanner", "com.envisionai.envisionai", "com.bemyeyes.bemyeyes", "com.google.android.apps.accessibility.maui.actionblocks", "com.samsung.accessibility", "com.samsung.android.app.accessibility", "com.samsung.android.accessibility.talkback"));
    private static final String[] WHITELISTED_PREFIXES = {"com.google.android.marvin.", "com.google.android.accessibility.", "com.google.android.apps.accessibility.", "com.samsung.accessibility.", "com.samsung.android.accessibility.", "com.android.systemui"};
    private final Context context;
    private final Set<String> dynamicWhitelist = new HashSet();

    public AccessibilityServiceChecker(Context context) {
        this.context = context.getApplicationContext();
    }

    private static String extractPackage(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
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

    private static String resolveDisplayLabel(AccessibilityServiceInfo accessibilityServiceInfo, String str, PackageManager packageManager) {
        CharSequence loadLabel;
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
            if (applicationLabel != null) {
                String trim = applicationLabel.toString().trim();
                if (!trim.isEmpty()) {
                    return trim;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        ResolveInfo resolveInfo = accessibilityServiceInfo.getResolveInfo();
        if (resolveInfo != null && (loadLabel = resolveInfo.loadLabel(packageManager)) != null) {
            String trim2 = loadLabel.toString().trim();
            if (!trim2.isEmpty()) {
                return trim2;
            }
        }
        return str;
    }

    public List<String> getSideloadedServiceNames() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.context.getPackageManager();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
            if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null) {
                String packageName = this.context.getPackageName();
                HashSet hashSet = new HashSet();
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    String extractPackage = extractPackage(accessibilityServiceInfo.getId());
                    if (extractPackage != null && !extractPackage.isEmpty() && !extractPackage.equals(packageName) && InstallSourceHelper.isSideloaded(this.context, extractPackage) && hashSet.add(extractPackage)) {
                        arrayList.add(resolveDisplayLabel(accessibilityServiceInfo, extractPackage, packageManager));
                    }
                }
            }
            return arrayList;
        } catch (Exception e4) {
            Log.e(TAG, "Error resolving sideloaded accessibility labels", e4);
            return arrayList;
        }
    }

    public Set<String> getSideloadedServices() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        HashSet hashSet = new HashSet();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
            if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null) {
                String packageName = this.context.getPackageName();
                Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                while (it.hasNext()) {
                    String extractPackage = extractPackage(it.next().getId());
                    if (extractPackage != null && !extractPackage.isEmpty() && !extractPackage.equals(packageName) && InstallSourceHelper.isSideloaded(this.context, extractPackage)) {
                        hashSet.add(extractPackage);
                    }
                }
            }
            return hashSet;
        } catch (Exception e4) {
            Log.e(TAG, "Error checking sideloaded accessibility services", e4);
            return hashSet;
        }
    }

    public List<String> getSuspiciousServiceNames() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.context.getPackageManager();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
            if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null) {
                String packageName = this.context.getPackageName();
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    String extractPackage = extractPackage(accessibilityServiceInfo.getId());
                    if (extractPackage != null && !extractPackage.isEmpty() && !extractPackage.equals(packageName) && !isWhitelisted(extractPackage)) {
                        arrayList.add(resolveDisplayLabel(accessibilityServiceInfo, extractPackage, packageManager));
                    }
                }
            }
            return arrayList;
        } catch (Exception e4) {
            Log.e(TAG, "Error resolving suspicious accessibility labels", e4);
            return arrayList;
        }
    }

    public Set<String> getSuspiciousServices() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        HashSet hashSet = new HashSet();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
            if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null) {
                String packageName = this.context.getPackageName();
                Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                while (it.hasNext()) {
                    String extractPackage = extractPackage(it.next().getId());
                    if (extractPackage != null && !extractPackage.isEmpty() && !extractPackage.equals(packageName) && !isWhitelisted(extractPackage)) {
                        hashSet.add(extractPackage);
                    }
                }
            }
            return hashSet;
        } catch (Exception e4) {
            Log.e(TAG, "Error checking accessibility services", e4);
            return hashSet;
        }
    }

    public boolean hasSideloadedServices() {
        return !getSideloadedServices().isEmpty();
    }

    public boolean hasSuspiciousServices() {
        AccessibilityManager accessibilityManager;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        try {
            accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        } catch (Exception e4) {
            Log.e(TAG, "Error checking accessibility services", e4);
        }
        if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null && !enabledAccessibilityServiceList.isEmpty()) {
            LogHelper.d(TAG, "Enabled accessibility services (" + enabledAccessibilityServiceList.size() + ")");
            String packageName = this.context.getPackageName();
            Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
            while (it.hasNext()) {
                String extractPackage = extractPackage(it.next().getId());
                if (extractPackage != null && !extractPackage.isEmpty()) {
                    if (extractPackage.equals(packageName)) {
                        LogHelper.d(TAG, "Skipping own package: " + extractPackage);
                    } else if (isWhitelisted(extractPackage)) {
                        LogHelper.d(TAG, "Whitelisted: " + extractPackage);
                    } else {
                        return true;
                    }
                }
            }
            LogHelper.d(TAG, "No suspicious accessibility services found");
            return false;
        }
        return false;
    }

    public void setDynamicWhitelist(Set<String> set) {
        this.dynamicWhitelist.clear();
        if (set != null) {
            this.dynamicWhitelist.addAll(set);
        }
    }
}
