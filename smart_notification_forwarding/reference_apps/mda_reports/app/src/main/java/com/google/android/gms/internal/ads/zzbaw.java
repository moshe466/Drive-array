package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbaw {
    public final boolean zzdze;
    public final int zzdzf;
    public final int zzdzg;
    public final int zzdzh;
    private final String zzdzi;
    public final int zzdzj;
    public final int zzdzk;
    public final int zzdzl;
    public final int zzdzm;
    public final boolean zzdzn;
    public final int zzdzo;

    public zzbaw(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzdze = zza(jSONObject, "aggressive_media_codec_release", zzzn.zzchh);
        this.zzdzf = zzb(jSONObject, "byte_buffer_precache_limit", zzzn.zzcgq);
        this.zzdzg = zzb(jSONObject, "exo_cache_buffer_size", zzzn.zzcgw);
        this.zzdzh = zzb(jSONObject, "exo_connect_timeout_millis", zzzn.zzcgm);
        this.zzdzi = zzc(jSONObject, "exo_player_version", zzzn.zzcgl);
        this.zzdzj = zzb(jSONObject, "exo_read_timeout_millis", zzzn.zzcgn);
        this.zzdzk = zzb(jSONObject, "load_check_interval_bytes", zzzn.zzcgo);
        this.zzdzl = zzb(jSONObject, "player_precache_limit", zzzn.zzcgp);
        this.zzdzm = zzb(jSONObject, "socket_receive_buffer_size", zzzn.zzcgr);
        this.zzdzn = zza(jSONObject, "use_cache_data_source", zzzn.zzcnc);
        this.zzdzo = zzb(jSONObject, "min_retry_count", zzzn.zzcgt);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzzc<Boolean> zzzcVar) {
        return zza(jSONObject, str, ((Boolean) zzve.zzoy().zzd(zzzcVar)).booleanValue());
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int zzb(JSONObject jSONObject, String str, zzzc<Integer> zzzcVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzve.zzoy().zzd(zzzcVar)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzzc<String> zzzcVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzve.zzoy().zzd(zzzcVar);
    }
}
