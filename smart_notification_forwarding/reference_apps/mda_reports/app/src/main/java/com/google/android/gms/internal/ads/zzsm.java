package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzso;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzsm {
    private final zzsr zzbsb;

    @GuardedBy("this")
    private final zztu zzbsc;
    private final boolean zzbsd;

    private zzsm() {
        this.zzbsd = false;
        this.zzbsb = new zzsr();
        this.zzbsc = new zztu();
        zzmu();
    }

    public zzsm(zzsr zzsrVar) {
        this.zzbsb = zzsrVar;
        this.zzbsd = ((Boolean) zzve.zzoy().zzd(zzzn.zzcnw)).booleanValue();
        this.zzbsc = new zztu();
        zzmu();
    }

    private final synchronized void zzb(zzso.zza.EnumC0023zza enumC0023zza) {
        this.zzbsc.zzcau = zzmv();
        this.zzbsb.zzf(zzdvt.zza(this.zzbsc)).zzbr(enumC0023zza.zzae()).zzdn();
        String valueOf = String.valueOf(Integer.toString(enumC0023zza.zzae(), 10));
        zzavs.zzed(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zzso.zza.EnumC0023zza enumC0023zza) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(zzd(enumC0023zza).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzavs.zzed("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzavs.zzed("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzavs.zzed("Could not close Clearcut output stream.");
                    }
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    zzavs.zzed("Could not close Clearcut output stream.");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            zzavs.zzed("Could not find file for Clearcut");
        }
    }

    private final synchronized String zzd(zzso.zza.EnumC0023zza enumC0023zza) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzbsc.zzcaq, Long.valueOf(com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime()), Integer.valueOf(enumC0023zza.zzae()), Base64.encodeToString(zzdvt.zza(this.zzbsc), 3));
    }

    public static zzsm zzmt() {
        return new zzsm();
    }

    private final synchronized void zzmu() {
        this.zzbsc.zzcay = new zztq();
        this.zzbsc.zzcay.zzbzw = new zztp();
        this.zzbsc.zzcav = new zzts();
    }

    private static long[] zzmv() {
        int i;
        List<String> zzqh = zzzn.zzqh();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = zzqh.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] split = it.next().split(",");
            int length = split.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(split[i]));
                } catch (NumberFormatException unused) {
                    zzavs.zzed("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        int size = arrayList.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }

    public final synchronized void zza(zzso.zza.EnumC0023zza enumC0023zza) {
        if (this.zzbsd) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnx)).booleanValue()) {
                zzc(enumC0023zza);
            } else {
                zzb(enumC0023zza);
            }
        }
    }

    public final synchronized void zza(zzsp zzspVar) {
        if (this.zzbsd) {
            try {
                zzspVar.zza(this.zzbsc);
            } catch (NullPointerException e) {
                com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }
}
