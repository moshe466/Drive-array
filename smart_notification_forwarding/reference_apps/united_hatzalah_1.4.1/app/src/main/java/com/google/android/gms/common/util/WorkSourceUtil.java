package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import x.AbstractC0773d;

/* loaded from: classes.dex */
public class WorkSourceUtil {
    private static final int zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static Boolean zzj;

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            java.lang.Class r2 = java.lang.Integer.TYPE
            java.lang.Class<android.os.WorkSource> r3 = android.os.WorkSource.class
            int r4 = android.os.Process.myUid()
            com.google.android.gms.common.util.WorkSourceUtil.zza = r4
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[]{r2}     // Catch: java.lang.Exception -> L18
            java.lang.reflect.Method r5 = r3.getMethod(r1, r5)     // Catch: java.lang.Exception -> L18
            goto L19
        L18:
            r5 = r4
        L19:
            com.google.android.gms.common.util.WorkSourceUtil.zzb = r5
            java.lang.Class[] r5 = new java.lang.Class[]{r2, r0}     // Catch: java.lang.Exception -> L24
            java.lang.reflect.Method r1 = r3.getMethod(r1, r5)     // Catch: java.lang.Exception -> L24
            goto L25
        L24:
            r1 = r4
        L25:
            com.google.android.gms.common.util.WorkSourceUtil.zzc = r1
            java.lang.String r1 = "size"
            java.lang.reflect.Method r1 = r3.getMethod(r1, r4)     // Catch: java.lang.Exception -> L2e
            goto L2f
        L2e:
            r1 = r4
        L2f:
            com.google.android.gms.common.util.WorkSourceUtil.zzd = r1
            java.lang.String r1 = "get"
            java.lang.Class[] r5 = new java.lang.Class[]{r2}     // Catch: java.lang.Exception -> L3c
            java.lang.reflect.Method r1 = r3.getMethod(r1, r5)     // Catch: java.lang.Exception -> L3c
            goto L3d
        L3c:
            r1 = r4
        L3d:
            com.google.android.gms.common.util.WorkSourceUtil.zze = r1
            java.lang.String r1 = "getName"
            java.lang.Class[] r5 = new java.lang.Class[]{r2}     // Catch: java.lang.Exception -> L4a
            java.lang.reflect.Method r1 = r3.getMethod(r1, r5)     // Catch: java.lang.Exception -> L4a
            goto L4b
        L4a:
            r1 = r4
        L4b:
            com.google.android.gms.common.util.WorkSourceUtil.zzf = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L5a
            java.lang.String r1 = "createWorkChain"
            java.lang.reflect.Method r1 = r3.getMethod(r1, r4)     // Catch: java.lang.Exception -> L5a
            goto L5b
        L5a:
            r1 = r4
        L5b:
            com.google.android.gms.common.util.WorkSourceUtil.zzg = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L74
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = "addNode"
            java.lang.Class[] r0 = new java.lang.Class[]{r2, r0}     // Catch: java.lang.Exception -> L74
            java.lang.reflect.Method r0 = r1.getMethod(r5, r0)     // Catch: java.lang.Exception -> L74
            goto L75
        L74:
            r0 = r4
        L75:
            com.google.android.gms.common.util.WorkSourceUtil.zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L88
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r3.getMethod(r0, r4)     // Catch: java.lang.Exception -> L88
            r1 = 1
            r0.setAccessible(r1)     // Catch: java.lang.Exception -> L89
            goto L89
        L88:
            r0 = r4
        L89:
            com.google.android.gms.common.util.WorkSourceUtil.zzi = r0
            com.google.android.gms.common.util.WorkSourceUtil.zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    public static void add(WorkSource workSource, int i, String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i), str);
                return;
            } catch (Exception e4) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
                return;
            }
        }
        Method method2 = zzb;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            }
        }
    }

    public static WorkSource fromPackage(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 != null && (method = zzh) != null) {
            try {
                Object invoke = method2.invoke(workSource, null);
                int i3 = zza;
                if (i != i3) {
                    method.invoke(invoke, Integer.valueOf(i), str);
                }
                method.invoke(invoke, Integer.valueOf(i3), str2);
            } catch (Exception unused2) {
            }
        } else {
            add(workSource, i, str);
        }
        return workSource;
    }

    public static int get(WorkSource workSource, int i) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, Integer.valueOf(i));
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e4) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
                return 0;
            }
        }
        return 0;
    }

    public static String getName(WorkSource workSource, int i) {
        Method method = zzf;
        if (method != null) {
            try {
                return (String) method.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e4) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
                return null;
            }
        }
        return null;
    }

    public static List<String> getNames(WorkSource workSource) {
        int size;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            size = 0;
        } else {
            size = size(workSource);
        }
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                String name = getName(workSource, i);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    public static synchronized boolean hasWorkSourcePermission(Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                return bool.booleanValue();
            }
            boolean z3 = false;
            if (context == null) {
                return false;
            }
            if (AbstractC0773d.a(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z3 = true;
            }
            zzj = Boolean.valueOf(z3);
            return z3;
        }
    }

    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, null);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e4) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e4);
            }
        }
        if (size(workSource) == 0) {
            return true;
        }
        return false;
    }

    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, null);
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e4) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
                return 0;
            }
        }
        return 0;
    }
}
