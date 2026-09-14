package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.UserHandle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class GmsClientSupervisor {
    static HandlerThread zza = null;
    private static final Object zzb = new Object();
    private static int zzc = 9;
    private static zzq zzd = null;
    private static Executor zze = null;
    private static boolean zzf = false;

    public static int getDefaultBindFlags() {
        return 4225;
    }

    public static GmsClientSupervisor getInstance(Context context) {
        Looper mainLooper;
        synchronized (zzb) {
            try {
                if (zzd == null) {
                    if (!zzf) {
                        zzf = GmsClientFlags.isBindServiceOptimizationEnabled(context.getPackageName());
                    }
                    Context applicationContext = context.getApplicationContext();
                    if (zzf) {
                        mainLooper = getOrStartHandlerThread().getLooper();
                    } else {
                        mainLooper = context.getMainLooper();
                    }
                    zzd = new zzq(applicationContext, mainLooper, zze);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzd;
    }

    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null && handlerThread.isAlive()) {
                    return zza;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", zzc);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setDefaultBindExecutor(Executor executor) {
        synchronized (zzb) {
            try {
                zzq zzqVar = zzd;
                if (zzqVar != null) {
                    zzqVar.zze(executor);
                }
                zze = executor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean setGamHandlerThreadPriorityIfNotInitialized(int i) {
        synchronized (zzb) {
            try {
                if (zza == null) {
                    zzc = i;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setUseHandlerThreadForCallbacks() {
        synchronized (zzb) {
            try {
                zzq zzqVar = zzd;
                if (zzqVar != null && !zzf) {
                    zzqVar.zzd(getOrStartHandlerThread().getLooper());
                }
                zzf = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zzn(componentName, 4225, (UserHandle) null), serviceConnection, str, null).isSuccess();
    }

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzc(new zzn(componentName, 4225, (UserHandle) null), serviceConnection, str);
    }

    public abstract ConnectionResult zza(zzn zznVar, ServiceConnection serviceConnection, String str, Executor executor);

    public final void zzb(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z3, UserHandle userHandle) {
        zzc(new zzn(str, str2, 4225, z3, userHandle), serviceConnection, str3);
    }

    public abstract void zzc(zzn zznVar, ServiceConnection serviceConnection, String str);

    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zzc(new zzn(str, 4225, false), serviceConnection, str2);
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str, Executor executor) {
        return zza(new zzn(componentName, 4225, (UserHandle) null), serviceConnection, str, executor).isSuccess();
    }

    public static HandlerThread getOrStartHandlerThread(int i) {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null && handlerThread.isAlive()) {
                    return zza;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", i);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zzn(str, 4225, false), serviceConnection, str2, null).isSuccess();
    }
}
