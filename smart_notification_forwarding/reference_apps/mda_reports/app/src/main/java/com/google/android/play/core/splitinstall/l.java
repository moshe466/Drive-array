package com.google.android.play.core.splitinstall;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class l {
    private static final com.google.android.play.core.splitcompat.a a = new com.google.android.play.core.splitcompat.a("SplitInstallInfoProvider");
    private final Context b;
    private final String c;
    private k d = null;
    private f e = null;

    public l(Context context, String str) {
        this.b = context;
        this.c = str;
    }

    public static boolean a(String str) {
        return str.startsWith("config.");
    }

    public static boolean b(String str) {
        return str.startsWith("config.") || str.contains(".config.");
    }

    public static String c(String str) {
        return str.startsWith("config.") ? "" : str.split("\\.config\\.", 2)[0];
    }

    private final Set<String> d() {
        HashSet hashSet = new HashSet();
        Bundle f = f();
        if (f != null) {
            String string = f.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                a.b("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            return hashSet;
        }
        String[] e = e();
        if (e != null) {
            a.b("Adding splits from package manager: %s", Arrays.toString(e));
            Collections.addAll(hashSet, e);
        } else {
            a.b("No splits are found or app cannot be found in package manager.", new Object[0]);
        }
        k a2 = i.a();
        if (a2 != null) {
            hashSet.addAll(a2.a());
        }
        return hashSet;
    }

    @TargetApi(21)
    private final String[] e() {
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.c, 0);
            if (packageInfo != null) {
                return packageInfo.splitNames;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            a.c("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    private final Bundle f() {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.c, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            a.b("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            a.c("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        for (String str : d()) {
            if (!b(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<String> b() {
        f c = c();
        if (c == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> d = d();
        d.add("");
        Set<String> a2 = a();
        a2.add("");
        for (Map.Entry<String, Set<String>> entry : c.a(a2).entrySet()) {
            if (d.containsAll(entry.getValue())) {
                hashSet.add(entry.getKey());
            }
        }
        return hashSet;
    }

    public final f c() {
        Bundle f = f();
        if (f == null) {
            return null;
        }
        int i = f.getInt("com.android.vending.splits");
        if (i == 0) {
            a.c("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            f a2 = new ak(this.b.getResources().getXml(i)).a();
            if (a2 == null) {
                a.c("Can't parse languages metadata.", new Object[0]);
            }
            return a2;
        } catch (Resources.NotFoundException unused) {
            a.c("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }
}
