package g2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final Method f9761a;

    /* renamed from: b, reason: collision with root package name */
    private static final Method f9762b;

    /* renamed from: c, reason: collision with root package name */
    private static final Method f9763c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f9764d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f9765e;

    /* JADX WARN: Can't wrap try/catch for region: R(22:1|(2:2|3)|4|(19:45|46|7|8|9|10|11|12|13|(10:37|38|16|(2:33|34)|18|(2:29|30)|20|(2:25|26)|22|23)|15|16|(0)|18|(0)|20|(0)|22|23)|6|7|8|9|10|11|12|13|(0)|15|16|(0)|18|(0)|20|(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003e, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            android.os.Process.myUid()
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L17
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L17
            r5[r4] = r6     // Catch: java.lang.Exception -> L17
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r5 = r6.getMethod(r1, r5)     // Catch: java.lang.Exception -> L17
            goto L18
        L17:
            r5 = r3
        L18:
            g2.p.f9761a = r5
            boolean r5 = g2.l.c()
            r6 = 2
            if (r5 == 0) goto L30
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L30
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L30
            r5[r4] = r7     // Catch: java.lang.Exception -> L30
            r5[r2] = r0     // Catch: java.lang.Exception -> L30
            java.lang.Class<android.os.WorkSource> r7 = android.os.WorkSource.class
            java.lang.reflect.Method r1 = r7.getMethod(r1, r5)     // Catch: java.lang.Exception -> L30
            goto L31
        L30:
            r1 = r3
        L31:
            g2.p.f9762b = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L3e
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch: java.lang.Exception -> L3e
            goto L3f
        L3e:
            r1 = r3
        L3f:
            g2.p.f9763c = r1
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L4f
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L4f
            r1[r4] = r5     // Catch: java.lang.Exception -> L4f
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "get"
            r5.getMethod(r7, r1)     // Catch: java.lang.Exception -> L4f
            goto L50
        L4f:
        L50:
            boolean r1 = g2.l.c()
            if (r1 == 0) goto L65
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L65
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L65
            r1[r4] = r5     // Catch: java.lang.Exception -> L65
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "getName"
            java.lang.reflect.Method r1 = r5.getMethod(r7, r1)     // Catch: java.lang.Exception -> L65
            goto L66
        L65:
            r1 = r3
        L66:
            g2.p.f9764d = r1
            boolean r1 = g2.l.i()
            if (r1 == 0) goto L79
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "createWorkChain"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L78
            r1.getMethod(r5, r7)     // Catch: java.lang.Exception -> L78
            goto L79
        L78:
        L79:
            boolean r1 = g2.l.i()
            if (r1 == 0) goto L94
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L93
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L93
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L93
            r5[r4] = r6     // Catch: java.lang.Exception -> L93
            r5[r2] = r0     // Catch: java.lang.Exception -> L93
            java.lang.String r0 = "addNode"
            r1.getMethod(r0, r5)     // Catch: java.lang.Exception -> L93
            goto L94
        L93:
        L94:
            boolean r0 = g2.l.i()
            if (r0 == 0) goto La7
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r1 = "isEmpty"
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> La7
            java.lang.reflect.Method r3 = r0.getMethod(r1, r4)     // Catch: java.lang.Exception -> La7
            r3.setAccessible(r2)     // Catch: java.lang.Exception -> La7
        La7:
            g2.p.f9765e = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.p.<clinit>():void");
    }

    public static void a(WorkSource workSource, int i10, String str) {
        Method method = f9762b;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i10), str);
                return;
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
                return;
            }
        }
        Method method2 = f9761a;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i10));
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        }
    }

    public static WorkSource b(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo c10 = i2.c.a(context).c(str, 0);
                if (c10 == null) {
                    "Could not get applicationInfo from package: ".concat(str);
                    return null;
                }
                int i10 = c10.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i10, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                "Could not find package: ".concat(str);
            }
        }
        return null;
    }

    public static String c(WorkSource workSource, int i10) {
        Method method = f9764d;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i10));
        } catch (Exception e10) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            return null;
        }
    }

    public static List<String> d(WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int g10 = workSource == null ? 0 : g(workSource);
        if (g10 != 0) {
            for (int i10 = 0; i10 < g10; i10++) {
                String c10 = c(workSource, i10);
                if (!n.a(c10)) {
                    b2.p.k(c10);
                    arrayList.add(c10);
                }
            }
        }
        return arrayList;
    }

    public static boolean e(Context context) {
        return (context == null || context.getPackageManager() == null || i2.c.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    public static boolean f(WorkSource workSource) {
        Method method = f9765e;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                b2.p.k(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception unused) {
            }
        }
        return g(workSource) == 0;
    }

    public static int g(WorkSource workSource) {
        Method method = f9763c;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                b2.p.k(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            }
        }
        return 0;
    }
}
