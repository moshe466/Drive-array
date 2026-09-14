package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbs;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class zzei {
    private static final String TAG = "zzei";
    protected Context a;
    private ExecutorService zzxk;
    private DexClassLoader zzxl;
    private zzds zzxm;
    private byte[] zzxn;
    private boolean zzxq;
    private zzde zzxt;
    private Map<Pair<String, String>, zzfu> zzxw;
    private volatile AdvertisingIdClient zzxo = null;
    private volatile boolean zzvh = false;
    private Future zzxp = null;
    private volatile zzbs.zza zzxr = null;
    private Future zzxs = null;
    private boolean zzxu = false;
    private boolean zzxv = false;
    private boolean zzxx = false;
    private boolean zzxy = true;
    private boolean zzxz = false;

    /* loaded from: classes.dex */
    final class zza extends BroadcastReceiver {
        private zza() {
        }

        /* synthetic */ zza(zzei zzeiVar, zzel zzelVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzei.this.zzxy = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzei.this.zzxy = false;
            }
        }
    }

    private zzei(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzxq = applicationContext != null;
        this.a = this.zzxq ? applicationContext : context;
        this.zzxw = new HashMap();
    }

    public static zzei zza(Context context, String str, String str2, boolean z) {
        zzel zzelVar;
        zzei zzeiVar = new zzei(context);
        try {
            zzeiVar.zzxk = Executors.newCachedThreadPool(new zzel());
            zzeiVar.zzvh = z;
            if (z) {
                zzeiVar.zzxp = zzeiVar.zzxk.submit(new zzek(zzeiVar));
            }
            zzeiVar.zzxk.execute(new zzem(zzeiVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                zzeiVar.zzxu = googleApiAvailabilityLight.getApkVersion(zzeiVar.a) > 0;
                zzeiVar.zzxv = googleApiAvailabilityLight.isGooglePlayServicesAvailable(zzeiVar.a) == 0;
            } catch (Throwable unused) {
            }
            zzeiVar.a(0, true);
            if (zzep.isMainThread() && ((Boolean) zzve.zzoy().zzd(zzzn.zzclk)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            zzelVar = null;
            zzeiVar.zzxm = new zzds(null);
            try {
                zzeiVar.zzxn = zzeiVar.zzxm.zzar(str);
            } catch (zzdv e) {
                throw new zzeh(e);
            }
        } catch (zzeh unused2) {
        }
        try {
            try {
                try {
                    try {
                        File cacheDir = zzeiVar.a.getCacheDir();
                        if (cacheDir == null && (cacheDir = zzeiVar.a.getDir("dex", 0)) == null) {
                            throw new zzeh();
                        }
                        File file = new File(String.format("%s/%s.jar", cacheDir, "1570054248636"));
                        if (!file.exists()) {
                            byte[] zza2 = zzeiVar.zzxm.zza(zzeiVar.zzxn, str2);
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(zza2, 0, zza2.length);
                            fileOutputStream.close();
                        }
                        zzeiVar.zzb(cacheDir, "1570054248636");
                        try {
                            zzeiVar.zzxl = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzeiVar.a.getClassLoader());
                            zzb(file);
                            zzeiVar.zza(cacheDir, "1570054248636");
                            zzas(String.format("%s/%s.dex", cacheDir, "1570054248636"));
                            if (!zzeiVar.zzxz) {
                                IntentFilter intentFilter = new IntentFilter();
                                intentFilter.addAction("android.intent.action.USER_PRESENT");
                                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                                zzeiVar.a.registerReceiver(new zza(zzeiVar, zzelVar), intentFilter);
                                zzeiVar.zzxz = true;
                            }
                            zzeiVar.zzxt = new zzde(zzeiVar);
                            zzeiVar.zzxx = true;
                            return zzeiVar;
                        } catch (Throwable th) {
                            zzb(file);
                            zzeiVar.zza(cacheDir, "1570054248636");
                            zzas(String.format("%s/%s.dex", cacheDir, "1570054248636"));
                            throw th;
                        }
                    } catch (FileNotFoundException e2) {
                        throw new zzeh(e2);
                    }
                } catch (IOException e3) {
                    throw new zzeh(e3);
                }
            } catch (NullPointerException e4) {
                throw new zzeh(e4);
            }
        } catch (zzdv e5) {
            throw new zzeh(e5);
        }
    }

    private final void zza(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file3);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        zzb(file3);
                        return;
                    }
                    System.out.print("test");
                    System.out.print("test");
                    System.out.print("test");
                    zzbs.zzc.zza zzg = zzbs.zzc.zzbb().zzh(zzdqk.zzu(Build.VERSION.SDK.getBytes())).zzg(zzdqk.zzu(str.getBytes()));
                    byte[] bytes = this.zzxm.zzb(this.zzxn, bArr).getBytes();
                    zzg.zze(zzdqk.zzu(bytes)).zzf(zzdqk.zzu(zzck.zzb(bytes)));
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] byteArray = ((zzbs.zzc) ((zzdrt) zzg.zzbaf())).toByteArray();
                        fileOutputStream2.write(byteArray, 0, byteArray.length);
                        fileOutputStream2.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                        zzb(file3);
                    } catch (zzdv | IOException | NoSuchAlgorithmException unused4) {
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        zzb(file3);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        zzb(file3);
                        throw th;
                    }
                } catch (zzdv | IOException | NoSuchAlgorithmException unused9) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (zzdv | IOException | NoSuchAlgorithmException unused10) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(int i, zzbs.zza zzaVar) {
        if (i < 4) {
            return zzaVar == null || !zzaVar.zzaj() || zzaVar.zzag().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaVar.zzal() || !zzaVar.zzam().zzbd() || zzaVar.zzam().zzbe() == -2;
        }
        return false;
    }

    private static void zzas(String str) {
        zzb(new File(str));
    }

    private static void zzb(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        }
    }

    private final boolean zzb(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                zzb(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            fileInputStream = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        Log.d(TAG, "Cannot read the cache data.");
                        zzb(file2);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    zzbs.zzc zzb = zzbs.zzc.zzb(bArr, zzdrg.zzazi());
                    if (str.equals(new String(zzb.zzaz().toByteArray())) && Arrays.equals(zzb.zzay().toByteArray(), zzck.zzb(zzb.zzax().toByteArray())) && Arrays.equals(zzb.zzba().toByteArray(), Build.VERSION.SDK.getBytes())) {
                        byte[] zza2 = this.zzxm.zza(this.zzxn, new String(zzb.zzax().toByteArray()));
                        file3.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        try {
                            fileOutputStream2.write(zza2, 0, zza2.length);
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                            return true;
                        } catch (zzdv | IOException | NoSuchAlgorithmException unused4) {
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileOutputStream == null) {
                                throw th;
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException unused8) {
                                throw th;
                            }
                        }
                    }
                    zzb(file2);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                    }
                    return false;
                } catch (zzdv | IOException | NoSuchAlgorithmException unused10) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (zzdv | IOException | NoSuchAlgorithmException unused11) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzch() {
        try {
            if (this.zzxo == null && this.zzxq) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.a);
                advertisingIdClient.start();
                this.zzxo = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzxo = null;
        }
    }

    @VisibleForTesting
    private final zzbs.zza zzci() {
        try {
            return com.google.android.gms.gass.zzc.zzj(this.a, this.a.getPackageName(), Integer.toString(this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(int i, boolean z) {
        if (this.zzxv) {
            Future<?> submit = this.zzxk.submit(new zzen(this, i, z));
            if (i == 0) {
                this.zzxs = submit;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbs.zza b(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return zzci();
    }

    public final Context getContext() {
        return this.a;
    }

    public final boolean isInitialized() {
        return this.zzxx;
    }

    public final Method zza(String str, String str2) {
        zzfu zzfuVar = this.zzxw.get(new Pair(str, str2));
        if (zzfuVar == null) {
            return null;
        }
        return zzfuVar.zzcs();
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzxw.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzxw.put(new Pair<>(str, str2), new zzfu(this, str, str2, clsArr));
        return true;
    }

    public final int zzbr() {
        if (this.zzxt != null) {
            return zzde.zzbr();
        }
        return Integer.MIN_VALUE;
    }

    public final ExecutorService zzbx() {
        return this.zzxk;
    }

    public final DexClassLoader zzby() {
        return this.zzxl;
    }

    public final zzds zzbz() {
        return this.zzxm;
    }

    public final byte[] zzca() {
        return this.zzxn;
    }

    public final boolean zzcb() {
        return this.zzxu;
    }

    public final zzde zzcc() {
        return this.zzxt;
    }

    public final boolean zzcd() {
        return this.zzxv;
    }

    public final boolean zzce() {
        return this.zzxy;
    }

    public final zzbs.zza zzcf() {
        return this.zzxr;
    }

    public final Future zzcg() {
        return this.zzxs;
    }

    public final AdvertisingIdClient zzcj() {
        if (!this.zzvh) {
            return null;
        }
        if (this.zzxo != null) {
            return this.zzxo;
        }
        Future future = this.zzxp;
        if (future != null) {
            try {
                future.get(2000L, TimeUnit.MILLISECONDS);
                this.zzxp = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzxp.cancel(true);
            }
        }
        return this.zzxo;
    }
}
