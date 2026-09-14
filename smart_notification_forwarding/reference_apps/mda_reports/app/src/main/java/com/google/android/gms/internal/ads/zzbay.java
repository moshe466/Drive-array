package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzbay {
    private final zzazb zzdij;
    private final String zzdiy;

    @Nullable
    private final zzaae zzdxw;
    private boolean zzdya;

    @Nullable
    private final zzaac zzeao;
    private final long[] zzeaq;
    private final String[] zzear;
    private zzbag zzeaw;
    private boolean zzeax;
    private boolean zzeay;
    private final Context zzup;
    private final zzaxg zzeap = new zzaxl().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzxa();
    private boolean zzeas = false;
    private boolean zzeat = false;
    private boolean zzeau = false;
    private boolean zzeav = false;
    private long zzeaz = -1;

    public zzbay(Context context, zzazb zzazbVar, String str, @Nullable zzaae zzaaeVar, @Nullable zzaac zzaacVar) {
        this.zzup = context;
        this.zzdij = zzazbVar;
        this.zzdiy = str;
        this.zzdxw = zzaaeVar;
        this.zzeao = zzaacVar;
        String str2 = (String) zzve.zzoy().zzd(zzzn.zzcha);
        if (str2 == null) {
            this.zzear = new String[0];
            this.zzeaq = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzear = new String[split.length];
        this.zzeaq = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzeaq[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzayu.zzd("Unable to parse frame hash target time number.", e);
                this.zzeaq[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (!zzabm.zzcux.get().booleanValue() || this.zzeax) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.zzdiy);
        bundle.putString("player", this.zzeaw.zzxo());
        for (zzaxi zzaxiVar : this.zzeap.zzwz()) {
            String valueOf = String.valueOf(zzaxiVar.name);
            bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(zzaxiVar.count));
            String valueOf2 = String.valueOf(zzaxiVar.name);
            bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(zzaxiVar.zzdtz));
        }
        int i = 0;
        while (true) {
            long[] jArr = this.zzeaq;
            if (i >= jArr.length) {
                com.google.android.gms.ads.internal.zzq.zzkq().zza(this.zzup, this.zzdij.zzbma, "gmob-apps", bundle, true);
                this.zzeax = true;
                return;
            }
            String str = this.zzear[i];
            if (str != null) {
                String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                sb.append("fh_");
                sb.append(valueOf3);
                bundle.putString(sb.toString(), str);
            }
            i++;
        }
    }

    public final void zzb(zzbag zzbagVar) {
        zzzv.zza(this.zzdxw, this.zzeao, "vpc2");
        this.zzeas = true;
        zzaae zzaaeVar = this.zzdxw;
        if (zzaaeVar != null) {
            zzaaeVar.zzh("vpn", zzbagVar.zzxo());
        }
        this.zzeaw = zzbagVar;
    }

    public final void zzc(zzbag zzbagVar) {
        if (this.zzeau && !this.zzeav) {
            if (zzavs.zzvs() && !this.zzeav) {
                zzavs.zzed("VideoMetricsMixin first frame");
            }
            zzzv.zza(this.zzdxw, this.zzeao, "vff2");
            this.zzeav = true;
        }
        long nanoTime = com.google.android.gms.ads.internal.zzq.zzkx().nanoTime();
        if (this.zzdya && this.zzeay && this.zzeaz != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d = nanoTime - this.zzeaz;
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.zzeap.zza(nanos / d);
        }
        this.zzeay = this.zzdya;
        this.zzeaz = nanoTime;
        long longValue = ((Long) zzve.zzoy().zzd(zzzn.zzchb)).longValue();
        long currentPosition = zzbagVar.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzear;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(currentPosition - this.zzeaq[i])) {
                String[] strArr2 = this.zzear;
                int i2 = 8;
                Bitmap bitmap = zzbagVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
            i++;
        }
    }

    public final void zzer() {
        if (!this.zzeas || this.zzeat) {
            return;
        }
        zzzv.zza(this.zzdxw, this.zzeao, "vfr2");
        this.zzeat = true;
    }

    public final void zzyi() {
        this.zzdya = true;
        if (!this.zzeat || this.zzeau) {
            return;
        }
        zzzv.zza(this.zzdxw, this.zzeao, "vfp2");
        this.zzeau = true;
    }

    public final void zzyj() {
        this.zzdya = false;
    }
}
