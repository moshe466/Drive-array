package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzc = null;
    private static String zzd = null;
    private static boolean zze = false;
    private static int zzf = -1;
    private static Boolean zzg;
    private static zzp zzl;
    private static zzq zzm;
    private final Context zzk;
    private static final ThreadLocal zzh = new ThreadLocal();
    private static final ThreadLocal zzi = new zze();
    private static final VersionPolicy.IVersions zzj = new zzf();
    public static final VersionPolicy PREFER_REMOTE = new zzg();
    public static final VersionPolicy PREFER_LOCAL = new zzh();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzk();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzl();
    public static final VersionPolicy zza = new zzm();
    public static final VersionPolicy zzb = new zzc();

    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, Throwable th, byte[] bArr) {
            super(str, th);
        }

        public /* synthetic */ LoadingException(String str, byte[] bArr) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public interface VersionPolicy {

        /* loaded from: classes.dex */
        public interface IVersions {
            int zza(Context context, String str, boolean z3);

            int zzb(Context context, String str);
        }

        /* loaded from: classes.dex */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions);
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzk = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.equal(declaredField.get(null), str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 50 + String.valueOf(str).length() + 1);
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            new StringBuilder(String.valueOf(str).length() + 45);
            return 0;
        } catch (Exception e4) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e4.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) {
        long j2;
        DynamiteModule zze2;
        int i;
        Boolean bool;
        IObjectWrapper zze3;
        zzq zzqVar;
        boolean z3;
        IObjectWrapper zze4;
        Context applicationContext = context.getApplicationContext();
        byte[] bArr = null;
        if (applicationContext != null) {
            ThreadLocal threadLocal = zzh;
            zzn zznVar = (zzn) threadLocal.get();
            zzn zznVar2 = new zzn(null);
            threadLocal.set(zznVar2);
            ThreadLocal threadLocal2 = zzi;
            Long l3 = (Long) threadLocal2.get();
            long longValue = l3.longValue();
            try {
                threadLocal2.set(Long.valueOf(SystemClock.uptimeMillis()));
                VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzj);
                j2 = longValue;
                try {
                    new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(selectModule.localVersion).length() + 19 + String.valueOf(str).length() + 1 + String.valueOf(selectModule.remoteVersion).length());
                    int i3 = selectModule.selection;
                    if (i3 != 0) {
                        if (i3 == -1) {
                            if (selectModule.localVersion != 0) {
                                i3 = -1;
                            }
                        }
                        if (i3 != 1 || selectModule.remoteVersion != 0) {
                            if (i3 == -1) {
                                DynamiteModule zze5 = zze(applicationContext, str);
                                if (j2 == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(l3);
                                }
                                Cursor cursor = zznVar2.zza;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                threadLocal.set(zznVar);
                                return zze5;
                            }
                            if (i3 == 1) {
                                try {
                                    i = selectModule.remoteVersion;
                                } catch (LoadingException e4) {
                                    new StringBuilder(String.valueOf(e4.getMessage()).length() + 30);
                                    int i4 = selectModule.localVersion;
                                    if (i4 != 0 && versionPolicy.selectModule(context, str, new zzo(i4, 0)).selection == -1) {
                                        zze2 = zze(applicationContext, str);
                                    } else {
                                        throw new LoadingException("Remote load failed. No local fallback found.", e4, null);
                                    }
                                }
                                try {
                                    synchronized (DynamiteModule.class) {
                                        if (zzb(context)) {
                                            bool = zzc;
                                        } else {
                                            throw new LoadingException("Remote loading disabled", null);
                                        }
                                    }
                                    if (bool != null) {
                                        if (bool.booleanValue()) {
                                            new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(i).length());
                                            synchronized (DynamiteModule.class) {
                                                zzqVar = zzm;
                                            }
                                            if (zzqVar != null) {
                                                zzn zznVar3 = (zzn) threadLocal.get();
                                                if (zznVar3 != null && zznVar3.zza != null) {
                                                    Context applicationContext2 = context.getApplicationContext();
                                                    Cursor cursor2 = zznVar3.zza;
                                                    ObjectWrapper.wrap(null);
                                                    synchronized (DynamiteModule.class) {
                                                        if (zzf >= 2) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                    }
                                                    if (z3) {
                                                        zze4 = zzqVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i, ObjectWrapper.wrap(cursor2));
                                                    } else {
                                                        zze4 = zzqVar.zze(ObjectWrapper.wrap(applicationContext2), str, i, ObjectWrapper.wrap(cursor2));
                                                    }
                                                    Context context2 = (Context) ObjectWrapper.unwrap(zze4);
                                                    if (context2 != null) {
                                                        zze2 = new DynamiteModule(context2);
                                                    } else {
                                                        throw new LoadingException("Failed to get module context", bArr);
                                                    }
                                                } else {
                                                    throw new LoadingException("No result cursor", null);
                                                }
                                            } else {
                                                throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                            }
                                        } else {
                                            new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(i).length());
                                            zzp zzg2 = zzg(context);
                                            if (zzg2 != null) {
                                                int zzi2 = zzg2.zzi();
                                                if (zzi2 >= 3) {
                                                    zzn zznVar4 = (zzn) threadLocal.get();
                                                    if (zznVar4 != null) {
                                                        zze3 = zzg2.zzk(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(zznVar4.zza));
                                                    } else {
                                                        throw new LoadingException("No cached result cursor holder", null);
                                                    }
                                                } else if (zzi2 == 2) {
                                                    zze3 = zzg2.zzg(ObjectWrapper.wrap(context), str, i);
                                                } else {
                                                    zze3 = zzg2.zze(ObjectWrapper.wrap(context), str, i);
                                                }
                                                Object unwrap = ObjectWrapper.unwrap(zze3);
                                                if (unwrap != null) {
                                                    zze2 = new DynamiteModule((Context) unwrap);
                                                } else {
                                                    throw new LoadingException("Failed to load remote module.", null);
                                                }
                                            } else {
                                                throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                            }
                                        }
                                        if (j2 == 0) {
                                            zzi.remove();
                                        } else {
                                            zzi.set(l3);
                                        }
                                        Cursor cursor3 = zznVar2.zza;
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        zzh.set(zznVar);
                                        return zze2;
                                    }
                                    throw new LoadingException("Failed to determine which loading route to use.", null);
                                } catch (RemoteException e5) {
                                    throw new LoadingException("Failed to load remote module.", e5, null);
                                } catch (LoadingException e6) {
                                    throw e6;
                                } catch (Throwable th) {
                                    CrashUtils.addDynamiteErrorToDropBox(context, th);
                                    throw new LoadingException("Failed to load remote module.", th, null);
                                }
                            }
                            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 36);
                            sb.append("VersionPolicy returned invalid code:");
                            sb.append(i3);
                            throw new LoadingException(sb.toString(), null);
                        }
                    }
                    int i5 = selectModule.localVersion;
                    int i6 = selectModule.remoteVersion;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(i5).length() + 23 + String.valueOf(i6).length() + 1);
                    sb2.append("No acceptable module ");
                    sb2.append(str);
                    sb2.append(" found. Local version is ");
                    sb2.append(i5);
                    sb2.append(" and remote version is ");
                    sb2.append(i6);
                    sb2.append(".");
                    throw new LoadingException(sb2.toString(), null);
                } catch (Throwable th2) {
                    th = th2;
                    if (j2 == 0) {
                        zzi.remove();
                    } else {
                        zzi.set(l3);
                    }
                    Cursor cursor4 = zznVar2.zza;
                    if (cursor4 != null) {
                        cursor4.close();
                    }
                    zzh.set(zznVar);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j2 = longValue;
            }
        } else {
            throw new LoadingException("null application Context", null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0151, code lost:
    
        if (zzd(r11) != false) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean zzb(Context context) {
        int i;
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzg)) {
            return true;
        }
        boolean z3 = false;
        if (zzg == null) {
            PackageManager packageManager = context.getPackageManager();
            if (true != PlatformVersion.isAtLeastQ()) {
                i = 0;
            } else {
                i = 268435456;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.chimera", i);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z3 = true;
            }
            zzg = Boolean.valueOf(z3);
            if (z3 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                zze = true;
            }
        }
        if (!z3) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x014b, code lost:
    
        r8.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0147: MOVE (r2 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:328), block:B:114:0x0147 */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015c A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:15:0x00ef, B:17:0x00f5, B:20:0x00fd, B:33:0x012a, B:40:0x0133, B:44:0x0139, B:45:0x0140, B:11:0x014f, B:12:0x0156, B:51:0x0158, B:53:0x015c, B:54:0x017e, B:55:0x017f), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017f A[Catch: all -> 0x0141, TRY_LEAVE, TryCatch #0 {all -> 0x0141, blocks: (B:15:0x00ef, B:17:0x00f5, B:20:0x00fd, B:33:0x012a, B:40:0x0133, B:44:0x0139, B:45:0x0140, B:11:0x014f, B:12:0x0156, B:51:0x0158, B:53:0x015c, B:54:0x017e, B:55:0x017f), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int zzc(android.content.Context r14, java.lang.String r15, boolean r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static boolean zzd(Cursor cursor) {
        zzn zznVar = (zzn) zzh.get();
        if (zznVar != null && zznVar.zza == null) {
            zznVar.zza = cursor;
            return true;
        }
        return false;
    }

    private static DynamiteModule zze(Context context, String str) {
        "Selected local version of ".concat(String.valueOf(str));
        return new DynamiteModule(context);
    }

    private static void zzf(ClassLoader classLoader) {
        zzq zzqVar;
        byte[] bArr = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                zzqVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzq) {
                    zzqVar = (zzq) queryLocalInterface;
                } else {
                    zzqVar = new zzq(iBinder);
                }
            }
            zzm = zzqVar;
        } catch (ClassNotFoundException e4) {
            e = e4;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (IllegalAccessException e5) {
            e = e5;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (InstantiationException e6) {
            e = e6;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (NoSuchMethodException e7) {
            e = e7;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        }
    }

    private static zzp zzg(Context context) {
        zzp zzpVar;
        synchronized (DynamiteModule.class) {
            zzp zzpVar2 = zzl;
            if (zzpVar2 != null) {
                return zzpVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzpVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzp) {
                        zzpVar = (zzp) queryLocalInterface;
                    } else {
                        zzpVar = new zzp(iBinder);
                    }
                }
                if (zzpVar != null) {
                    zzl = zzpVar;
                    return zzpVar;
                }
            } catch (Exception e4) {
                String message = e4.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 45);
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                Log.e("DynamiteModule", sb.toString());
            }
            return null;
        }
    }

    public Context getModuleContext() {
        return this.zzk;
    }

    public IBinder instantiate(String str) {
        try {
            return (IBinder) this.zzk.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e4) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e4, null);
        }
    }
}
