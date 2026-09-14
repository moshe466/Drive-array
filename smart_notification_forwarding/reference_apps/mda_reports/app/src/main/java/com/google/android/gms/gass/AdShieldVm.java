package com.google.android.gms.gass;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.gass.internal.Program;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AdShieldVm implements AdShieldHandle {
    private Program zzgrz;
    private Object zzgsa;
    private final Context zzup;
    private final AdShield2Logger zzus;

    public AdShieldVm(@NonNull Context context, @NonNull AdShield2Logger adShield2Logger) {
        this.zzup = context;
        this.zzus = adShield2Logger;
    }

    private final Object zza(Class<?> cls, Program program) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return cls.getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzup, "msa-r", program.getBytecodeFileContents(), null, new Bundle(), 2);
        } catch (IllegalAccessException e) {
            zza(AdShield2Logger.EVENTID_VM_CREATE_EXCEPTION, currentTimeMillis, e);
            return null;
        } catch (InstantiationException e2) {
            zza(AdShield2Logger.EVENTID_VM_CREATE_EXCEPTION, currentTimeMillis, e2);
            return null;
        } catch (NoSuchMethodException e3) {
            zza(AdShield2Logger.EVENTID_VM_CREATE_EXCEPTION, currentTimeMillis, e3);
            return null;
        } catch (InvocationTargetException e4) {
            zza(AdShield2Logger.EVENTID_VM_CREATE_EXCEPTION, currentTimeMillis, e4);
            return null;
        }
    }

    private final void zza(int i, long j, Exception exc) {
        zza(i, exc, j);
    }

    private final void zza(int i, Exception exc, long j) {
        this.zzus.logException(i, System.currentTimeMillis() - j, exc);
    }

    private final byte[] zzb(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = this.zzgsa;
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zzgsa, null, map2);
        } catch (IllegalAccessException e) {
            zza(AdShield2Logger.EVENTID_VM_SNAP_EXCEPTION, currentTimeMillis, e);
            return null;
        } catch (NoSuchMethodException e2) {
            zza(AdShield2Logger.EVENTID_VM_SNAP_EXCEPTION, currentTimeMillis, e2);
            return null;
        } catch (InvocationTargetException e3) {
            zza(AdShield2Logger.EVENTID_VM_SNAP_EXCEPTION, currentTimeMillis, e3);
            return null;
        }
    }

    private static String zzj(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }

    private final synchronized void zzx(Object obj) {
        if (this.zzgsa != null) {
            close();
        }
        this.zzgsa = obj;
    }

    private final synchronized int zzy(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            zza(AdShield2Logger.EVENTID_VM_LAST_CRASH_EXCEPTION, currentTimeMillis, e);
            return 0;
        }
        return ((Integer) obj.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(obj, new Object[0])).intValue();
    }

    @Override // com.google.android.gms.gass.AdShieldHandle
    public synchronized void close() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.zzgsa.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zzgsa, new Object[0]);
            zza(AdShield2Logger.EVENTID_LATENCY_CLOSE, (Exception) null, currentTimeMillis);
        } catch (Exception e) {
            zza(AdShield2Logger.EVENTID_VM_CLOSE_EXCEPTION, currentTimeMillis, e);
        }
    }

    @Override // com.google.android.gms.gass.AdShieldHandle
    public synchronized String getClickSignals(Context context, String str, String str2, View view, Activity activity) {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put("ctx", context);
        hashMap.put("clickString", str2);
        hashMap.put("aid", str);
        hashMap.put("view", view);
        hashMap.put("act", activity);
        return zzj(zzb(null, hashMap));
    }

    @Override // com.google.android.gms.gass.AdShieldHandle
    public synchronized String getImpressionSignals(Context context, String str, View view, Activity activity) {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put("ctx", context);
        hashMap.put("aid", str);
        hashMap.put("view", view);
        hashMap.put("act", activity);
        return zzj(zzb(null, hashMap));
    }

    @Override // com.google.android.gms.gass.AdShieldHandle
    public int getLastCrashInformation() {
        Object obj = this.zzgsa;
        if (obj != null) {
            return zzy(obj);
        }
        return 0;
    }

    public Program getProgram() {
        return this.zzgrz;
    }

    @Override // com.google.android.gms.gass.AdShieldHandle
    public synchronized String getQuerySignals(Context context, String str) {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put("ctx", context);
        hashMap.put("aid", str);
        return zzj(zzb(null, hashMap));
    }

    public AdShieldError initializedVmAndProgram(@NonNull Program program) {
        long currentTimeMillis = System.currentTimeMillis();
        Class<?> loadVmClass = loadVmClass(program);
        if (loadVmClass == null) {
            return new AdShieldError(2, "lc");
        }
        Object zza = zza(loadVmClass, program);
        if (zza == null) {
            return new AdShieldError(3, "it");
        }
        if (!runVmInit(zza)) {
            zza(AdShield2Logger.EVENTID_ERROR_RUN_VM_INIT, (Exception) null, currentTimeMillis);
            return new AdShieldError(4, "ri");
        }
        int zzy = zzy(zza);
        if (zzy == 0) {
            zzx(zza);
            this.zzgrz = program;
            zza(3000, (Exception) null, currentTimeMillis);
            return null;
        }
        this.zzus.logSignals(AdShield2Logger.EVENTID_ERROR_LAST_CRASH, System.currentTimeMillis() - currentTimeMillis, Integer.toString(zzy), null);
        StringBuilder sb = new StringBuilder(13);
        sb.append("ci");
        sb.append(zzy);
        return new AdShieldError(5, sb.toString());
    }

    public Class<?> loadVmClass(Program program) {
        File optFile = program.getOptFile();
        File vmFile = program.getVmFile();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return new DexClassLoader(vmFile.getAbsolutePath(), optFile.getAbsolutePath(), null, this.zzup.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
        } catch (ClassNotFoundException e) {
            zza(AdShield2Logger.EVENTID_LOAD_CLASS_EXCEPTION, currentTimeMillis, e);
            return null;
        }
    }

    @Override // com.google.android.gms.gass.AdShieldHandle
    public synchronized void reportTouchEvent(String str, MotionEvent motionEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("aid", str);
            hashMap.put("evt", motionEvent);
            this.zzgsa.getClass().getDeclaredMethod("he", Map.class).invoke(this.zzgsa, hashMap);
            zza(AdShield2Logger.EVENTID_LATENCY_REPORT_TOUCH, (Exception) null, currentTimeMillis);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            zza(AdShield2Logger.EVENTID_VM_TOUCH_EXCEPTION, currentTimeMillis, e);
        }
    }

    public boolean runVmInit(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return ((Boolean) obj.getClass().getDeclaredMethod("init", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            zza(AdShield2Logger.EVENTID_VM_INIT_EXCEPTION, currentTimeMillis, e);
            return false;
        }
    }
}
