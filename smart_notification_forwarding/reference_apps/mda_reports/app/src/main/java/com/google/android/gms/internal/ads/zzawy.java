package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzawy {
    private final Object lock = new Object();

    @GuardedBy("lock")
    private String zzdtj = "";

    @GuardedBy("lock")
    private String zzdtk = "";

    @GuardedBy("lock")
    private boolean zzdtl = false;

    @VisibleForTesting
    private String zzdtm = "";

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzawb.zzdsr.post(new zzaxb(this, context, str, z, z2));
        } else {
            zzayu.zzey("Can not create dialog without Activity Context");
        }
    }

    private final String zzbf(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzdtj)) {
                com.google.android.gms.ads.internal.zzq.zzkq();
                this.zzdtj = zzawb.zzs(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzdtj)) {
                    com.google.android.gms.ads.internal.zzq.zzkq();
                    this.zzdtj = zzawb.zzwk();
                    com.google.android.gms.ads.internal.zzq.zzkq();
                    zzawb.zzc(context, "debug_signals_id.txt", this.zzdtj);
                }
            }
            str = this.zzdtj;
        }
        return str;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzd(context, (String) zzve.zzoy().zzd(zzzn.zzcnp), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzq.zzkq();
        zzawb.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbf(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    @VisibleForTesting
    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzve.zzoy().zzd(zzzn.zzcnn), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzayu.zzea("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzdtm = jSONObject.optString("status");
            synchronized (this.lock) {
                this.zzdtk = optString;
            }
            return true;
        } catch (JSONException e) {
            zzayu.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzve.zzoy().zzd(zzzn.zzcno), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzayu.zzea("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzdtl = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzayu.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzh(Context context, String str, String str2) {
        String str3;
        String valueOf;
        String str4;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzq.zzkq().zzr(context, str2));
        zzdhe<String> zzc = new zzaxk(context).zzc(str, hashMap);
        try {
            return zzc.get(((Integer) zzve.zzoy().zzd(zzzn.zzcnq)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            str3 = "Interrupted while retriving a response from: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
                str4 = new String("Interrupted while retriving a response from: ");
                zzayu.zzc(str4, e);
                zzc.cancel(true);
                return null;
            }
            str4 = str3.concat(valueOf);
            zzayu.zzc(str4, e);
            zzc.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            e = e2;
            str3 = "Timeout while retriving a response from: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
                str4 = new String("Timeout while retriving a response from: ");
                zzayu.zzc(str4, e);
                zzc.cancel(true);
                return null;
            }
            str4 = str3.concat(valueOf);
            zzayu.zzc(str4, e);
            zzc.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf2 = String.valueOf(str);
            zzayu.zzc(valueOf2.length() != 0 ? "Error retriving a response from: ".concat(valueOf2) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzq.zzkq();
        zzawb.zza(context, zzd(context, (String) zzve.zzoy().zzd(zzzn.zzcnm), str, str2));
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzwy = zzwy();
        if (!zzg(context, str, str2)) {
            zzi(context, str, str2);
            return;
        }
        if (!zzwy && !TextUtils.isEmpty(str3)) {
            zzc(context, str2, str3, str);
        }
        zzayu.zzea("Device is linked for debug signals.");
        zza(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !com.google.android.gms.ads.internal.zzq.zzla().zzwy()) {
            return false;
        }
        zzayu.zzea("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if (ExifInterface.GPS_MEASUREMENT_2D.equals(this.zzdtm)) {
            zzayu.zzea("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzdtm)) {
            zzayu.zzea("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if ("0".equals(this.zzdtm)) {
            zzayu.zzea("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String zzwx() {
        String str;
        synchronized (this.lock) {
            str = this.zzdtk;
        }
        return str;
    }

    public final boolean zzwy() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdtl;
        }
        return z;
    }
}
