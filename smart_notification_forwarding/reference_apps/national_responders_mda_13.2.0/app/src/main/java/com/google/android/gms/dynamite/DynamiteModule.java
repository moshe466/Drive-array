package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import b2.o;
import b2.p;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: b, reason: collision with root package name */
    public static final b f5132b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f5133c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f5134d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f5135e = null;

    /* renamed from: f, reason: collision with root package name */
    private static String f5136f = null;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f5137g = false;

    /* renamed from: h, reason: collision with root package name */
    private static int f5138h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static Boolean f5139i;

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal f5140j = new ThreadLocal();

    /* renamed from: k, reason: collision with root package name */
    private static final ThreadLocal f5141k = new com.google.android.gms.dynamite.b();

    /* renamed from: l, reason: collision with root package name */
    private static final b.a f5142l = new c();

    /* renamed from: m, reason: collision with root package name */
    private static m f5143m;

    /* renamed from: n, reason: collision with root package name */
    private static n f5144n;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5145a;

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public static class a extends Exception {
        /* synthetic */ a(String str, Throwable th, k2.d dVar) {
            super(str, th);
        }

        /* synthetic */ a(String str, k2.d dVar) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public interface b {

        /* loaded from: classes.dex */
        public interface a {
            int a(Context context, String str);

            int b(Context context, String str, boolean z10);
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0084b {

            /* renamed from: a, reason: collision with root package name */
            public int f5146a = 0;

            /* renamed from: b, reason: collision with root package name */
            public int f5147b = 0;

            /* renamed from: c, reason: collision with root package name */
            public int f5148c = 0;
        }

        C0084b a(Context context, String str, a aVar);
    }

    static {
        new d();
        f5132b = new e();
        new f();
        new g();
        f5133c = new h();
        f5134d = new i();
        new j();
    }

    private DynamiteModule(Context context) {
        p.k(context);
        this.f5145a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (o.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            return 0;
        } catch (Exception e10) {
            "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage()));
            return 0;
        }
    }

    public static int b(Context context, String str) {
        return e(context, str, false);
    }

    public static DynamiteModule d(Context context, b bVar, String str) {
        Boolean bool;
        j2.a B0;
        DynamiteModule dynamiteModule;
        n nVar;
        Boolean valueOf;
        ThreadLocal threadLocal = f5140j;
        k kVar = (k) threadLocal.get();
        k kVar2 = new k(null);
        threadLocal.set(kVar2);
        ThreadLocal threadLocal2 = f5141k;
        long longValue = ((Long) threadLocal2.get()).longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            b.C0084b a10 = bVar.a(context, str, f5142l);
            int i10 = a10.f5146a;
            int i11 = a10.f5147b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Considering local module ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i10);
            sb2.append(" and remote module ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i11);
            int i12 = a10.f5148c;
            if (i12 != 0) {
                if (i12 == -1) {
                    if (a10.f5146a != 0) {
                        i12 = -1;
                    }
                }
                if (i12 != 1 || a10.f5147b != 0) {
                    if (i12 == -1) {
                        DynamiteModule g10 = g(context, str);
                        if (longValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = kVar2.f5149a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(kVar);
                        return g10;
                    }
                    if (i12 != 1) {
                        throw new a("VersionPolicy returned invalid code:" + i12, null);
                    }
                    try {
                        int i13 = a10.f5147b;
                        try {
                            synchronized (DynamiteModule.class) {
                                if (!j(context)) {
                                    throw new a("Remote loading disabled", null);
                                }
                                bool = f5135e;
                            }
                            if (bool == null) {
                                throw new a("Failed to determine which loading route to use.", null);
                            }
                            if (bool.booleanValue()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Selected remote version of ");
                                sb3.append(str);
                                sb3.append(", version >= ");
                                sb3.append(i13);
                                synchronized (DynamiteModule.class) {
                                    nVar = f5144n;
                                }
                                if (nVar == null) {
                                    throw new a("DynamiteLoaderV2 was not cached.", null);
                                }
                                k kVar3 = (k) threadLocal.get();
                                if (kVar3 == null || kVar3.f5149a == null) {
                                    throw new a("No result cursor", null);
                                }
                                Context applicationContext = context.getApplicationContext();
                                Cursor cursor2 = kVar3.f5149a;
                                j2.b.z(null);
                                synchronized (DynamiteModule.class) {
                                    valueOf = Boolean.valueOf(f5138h >= 2);
                                }
                                Context context2 = (Context) j2.b.p(valueOf.booleanValue() ? nVar.x0(j2.b.z(applicationContext), str, i13, j2.b.z(cursor2)) : nVar.z(j2.b.z(applicationContext), str, i13, j2.b.z(cursor2)));
                                if (context2 == null) {
                                    throw new a("Failed to get module context", null);
                                }
                                dynamiteModule = new DynamiteModule(context2);
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Selected remote version of ");
                                sb4.append(str);
                                sb4.append(", version >= ");
                                sb4.append(i13);
                                m k10 = k(context);
                                if (k10 == null) {
                                    throw new a("Failed to create IDynamiteLoader.", null);
                                }
                                int z10 = k10.z();
                                if (z10 >= 3) {
                                    k kVar4 = (k) threadLocal.get();
                                    if (kVar4 == null) {
                                        throw new a("No cached result cursor holder", null);
                                    }
                                    B0 = k10.A0(j2.b.z(context), str, i13, j2.b.z(kVar4.f5149a));
                                } else {
                                    B0 = z10 == 2 ? k10.B0(j2.b.z(context), str, i13) : k10.z0(j2.b.z(context), str, i13);
                                }
                                Object p10 = j2.b.p(B0);
                                if (p10 == null) {
                                    throw new a("Failed to load remote module.", null);
                                }
                                dynamiteModule = new DynamiteModule((Context) p10);
                            }
                            if (longValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(longValue));
                            }
                            Cursor cursor3 = kVar2.f5149a;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            threadLocal.set(kVar);
                            return dynamiteModule;
                        } catch (RemoteException e10) {
                            throw new a("Failed to load remote module.", e10, null);
                        } catch (a e11) {
                            throw e11;
                        } catch (Throwable th) {
                            g2.g.a(context, th);
                            throw new a("Failed to load remote module.", th, null);
                        }
                    } catch (a e12) {
                        String message = e12.getMessage();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Failed to load remote module: ");
                        sb5.append(message);
                        int i14 = a10.f5146a;
                        if (i14 == 0 || bVar.a(context, str, new l(i14, 0)).f5148c != -1) {
                            throw new a("Remote load failed. No local fallback found.", e12, null);
                        }
                        DynamiteModule g11 = g(context, str);
                        ThreadLocal threadLocal3 = f5141k;
                        if (longValue == 0) {
                            threadLocal3.remove();
                        } else {
                            threadLocal3.set(Long.valueOf(longValue));
                        }
                        Cursor cursor4 = kVar2.f5149a;
                        if (cursor4 != null) {
                            cursor4.close();
                        }
                        f5140j.set(kVar);
                        return g11;
                    }
                }
            }
            throw new a("No acceptable module " + str + " found. Local version is " + a10.f5146a + " and remote version is " + a10.f5147b + ".", null);
        } catch (Throwable th2) {
            ThreadLocal threadLocal4 = f5141k;
            if (longValue == 0) {
                threadLocal4.remove();
            } else {
                threadLocal4.set(Long.valueOf(longValue));
            }
            Cursor cursor5 = kVar2.f5149a;
            if (cursor5 != null) {
                cursor5.close();
            }
            f5140j.set(kVar);
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x013d, code lost:
    
        if (i(r11) != false) goto L89;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x017e -> B:24:0x0183). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0180 -> B:24:0x0183). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x009f, code lost:
    
        r10.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c2  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int f(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = com.google.android.gms.dynamite.DynamiteModule.f5141k     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            long r1 = r1.longValue()     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L19
            r10 = r4
        L19:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            r12.<init>()     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            android.net.Uri r4 = r10.build()     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lab java.lang.Exception -> Lae
            if (r10 == 0) goto La3
            boolean r11 = r10.moveToFirst()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            if (r11 == 0) goto La3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            if (r12 <= 0) goto L8e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.dynamite.DynamiteModule.f5136f = r2     // Catch: java.lang.Throwable -> L8b
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8b
            if (r2 < 0) goto L6f
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.dynamite.DynamiteModule.f5138h = r2     // Catch: java.lang.Throwable -> L8b
        L6f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L8b
            if (r2 < 0) goto L82
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> L8b
            if (r2 == 0) goto L7e
            goto L7f
        L7e:
            r9 = 0
        L7f:
            com.google.android.gms.dynamite.DynamiteModule.f5137g = r9     // Catch: java.lang.Throwable -> L8b
            r11 = r9
        L82:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L8b
            boolean r1 = i(r10)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            if (r1 == 0) goto L8e
            r10 = r0
            goto L8e
        L8b:
            r11 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L8b
            throw r11     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
        L8e:
            if (r13 == 0) goto L9d
            if (r11 != 0) goto L93
            goto L9d
        L93:
            com.google.android.gms.dynamite.DynamiteModule$a r11 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            throw r11     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
        L9b:
            r11 = move-exception
            goto Lb1
        L9d:
            if (r10 == 0) goto La2
            r10.close()
        La2:
            return r12
        La3:
            com.google.android.gms.dynamite.DynamiteModule$a r11 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
            throw r11     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Lbe
        Lab:
            r10 = move-exception
            r11 = r10
            goto Lc0
        Lae:
            r10 = move-exception
            r11 = r10
            r10 = r0
        Lb1:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch: java.lang.Throwable -> Lbe
            if (r12 == 0) goto Lb6
            throw r11     // Catch: java.lang.Throwable -> Lbe
        Lb6:
            com.google.android.gms.dynamite.DynamiteModule$a r12 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r13 = "V2 version check failed"
            r12.<init>(r13, r11, r0)     // Catch: java.lang.Throwable -> Lbe
            throw r12     // Catch: java.lang.Throwable -> Lbe
        Lbe:
            r11 = move-exception
            r0 = r10
        Lc0:
            if (r0 == 0) goto Lc5
            r0.close()
        Lc5:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule g(Context context, String str) {
        "Selected local version of ".concat(String.valueOf(str));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void h(ClassLoader classLoader) {
        n nVar;
        k2.d dVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                nVar = queryLocalInterface instanceof n ? (n) queryLocalInterface : new n(iBinder);
            }
            f5144n = nVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new a("Failed to instantiate dynamite loader", e10, dVar);
        }
    }

    private static boolean i(Cursor cursor) {
        k kVar = (k) f5140j.get();
        if (kVar == null || kVar.f5149a != null) {
            return false;
        }
        kVar.f5149a = cursor;
        return true;
    }

    private static boolean j(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f5139i)) {
            return true;
        }
        boolean z10 = false;
        if (f5139i == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (com.google.android.gms.common.c.h().j(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z10 = true;
            }
            Boolean valueOf = Boolean.valueOf(z10);
            f5139i = valueOf;
            z10 = valueOf.booleanValue();
            if (z10 && resolveContentProvider != null && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                f5137g = true;
            }
        }
        return z10;
    }

    private static m k(Context context) {
        m mVar;
        synchronized (DynamiteModule.class) {
            m mVar2 = f5143m;
            if (mVar2 != null) {
                return mVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    mVar = queryLocalInterface instanceof m ? (m) queryLocalInterface : new m(iBinder);
                }
                if (mVar != null) {
                    f5143m = mVar;
                    return mVar;
                }
            } catch (Exception e10) {
                String message = e10.getMessage();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb2.append(message);
            }
            return null;
        }
    }

    public IBinder c(String str) {
        try {
            return (IBinder) this.f5145a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new a("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, null);
        }
    }
}
