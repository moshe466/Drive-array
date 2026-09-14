package com.google.android.play.core.missingsplits;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class b implements MissingSplitsManager {
    private static final com.google.android.play.core.splitcompat.a a = new com.google.android.play.core.splitcompat.a("MissingSplitsManagerImpl");
    private final Context b;
    private final Runtime c;
    private final a d;
    private final AtomicReference<Boolean> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Runtime runtime, a aVar, AtomicReference<Boolean> atomicReference) {
        this.b = context;
        this.c = runtime;
        this.d = aVar;
        this.e = atomicReference;
    }

    @TargetApi(21)
    private final boolean a() {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                if (Boolean.TRUE.equals(applicationInfo.metaData.get("com.android.vending.splits.required"))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            a.c("App '%s' is not found in the PackageManager", this.b.getPackageName());
            return false;
        }
    }

    private final boolean a(ComponentName componentName) {
        String className = componentName.getClassName();
        try {
            Class<?> cls = Class.forName(className);
            while (cls != null) {
                if (cls.equals(Activity.class)) {
                    return true;
                }
                Class<? super Object> superclass = cls.getSuperclass();
                cls = superclass != cls ? superclass : null;
            }
            return false;
        } catch (ClassNotFoundException unused) {
            a.c("ClassNotFoundException when scanning class hierarchy of '%s'", className);
            return this.b.getPackageManager().getActivityInfo(componentName, 0) != null;
        }
    }

    @TargetApi(21)
    private final Set<String> b() {
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
            HashSet hashSet = new HashSet();
            if (packageInfo != null && packageInfo.splitNames != null) {
                Collections.addAll(hashSet, packageInfo.splitNames);
            }
            return hashSet;
        } catch (PackageManager.NameNotFoundException unused) {
            a.c("App '%s' is not found in PackageManager", this.b.getPackageName());
            return Collections.emptySet();
        }
    }

    @TargetApi(21)
    private final List<ActivityManager.AppTask> c() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.b.getSystemService("activity")).getAppTasks();
        return appTasks != null ? appTasks : Collections.emptyList();
    }

    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    public final boolean disableAppIfMissingRequiredSplits() {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (!isMissingRequiredSplits()) {
            if (this.d.a()) {
                this.d.c();
                this.c.exit(0);
            }
            return false;
        }
        Iterator<ActivityManager.AppTask> it = c().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityManager.AppTask next = it.next();
            if (next.getTaskInfo() != null && next.getTaskInfo().baseIntent != null && next.getTaskInfo().baseIntent.getComponent() != null) {
                if (PlayCoreMissingSplitsActivity.class.getName().equals(next.getTaskInfo().baseIntent.getComponent().getClassName())) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            Iterator<ActivityManager.AppTask> it2 = c().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                ActivityManager.RecentTaskInfo taskInfo = it2.next().getTaskInfo();
                if ((taskInfo == null || taskInfo.baseIntent == null || taskInfo.baseIntent.getComponent() == null || !a(taskInfo.baseIntent.getComponent())) ? false : true) {
                    z2 = true;
                    break;
                }
            }
            this.d.b();
            Iterator<ActivityManager.AppTask> it3 = c().iterator();
            while (it3.hasNext()) {
                it3.next().finishAndRemoveTask();
            }
            if (z2) {
                this.b.getPackageManager().setComponentEnabledSetting(new ComponentName(this.b, (Class<?>) PlayCoreMissingSplitsActivity.class), 1, 1);
                this.b.startActivity(new Intent(this.b, (Class<?>) PlayCoreMissingSplitsActivity.class).addFlags(884998144));
            }
            this.c.exit(0);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isMissingRequiredSplits() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r6.e
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.e     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L5a
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L5a
            if (r1 != 0) goto L4c
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.e     // Catch: java.lang.Throwable -> L5a
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5a
            r3 = 0
            r4 = 21
            r5 = 1
            if (r2 < r4) goto L45
            boolean r2 = r6.a()     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L45
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5a
            if (r2 >= r4) goto L26
            java.util.Set r2 = java.util.Collections.emptySet()     // Catch: java.lang.Throwable -> L5a
            goto L2a
        L26:
            java.util.Set r2 = r6.b()     // Catch: java.lang.Throwable -> L5a
        L2a:
            boolean r4 = r2.isEmpty()     // Catch: java.lang.Throwable -> L5a
            if (r4 != 0) goto L41
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L5a
            if (r4 != r5) goto L3f
            java.lang.String r4 = ""
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L3f
            goto L41
        L3f:
            r2 = 0
            goto L42
        L41:
            r2 = 1
        L42:
            if (r2 == 0) goto L45
            r3 = 1
        L45:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L5a
            r1.set(r2)     // Catch: java.lang.Throwable -> L5a
        L4c:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r6.e     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L5a
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L5a
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            return r1
        L5a:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.missingsplits.b.isMissingRequiredSplits():boolean");
    }
}
