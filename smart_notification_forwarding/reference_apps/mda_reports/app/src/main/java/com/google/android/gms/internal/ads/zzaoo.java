package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzaoo {
    private final zzbdi zzcza;
    private final String zzdgj;

    public zzaoo(zzbdi zzbdiVar) {
        this(zzbdiVar, "");
    }

    public zzaoo(zzbdi zzbdiVar, String str) {
        this.zzcza = zzbdiVar;
        this.zzdgj = str;
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzcza.zzb("onScreenInfoChanged", new JSONObject().put(SettingsJsonConstants.ICON_WIDTH_KEY, i).put(SettingsJsonConstants.ICON_HEIGHT_KEY, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzayu.zzc("Error occurred while obtaining screen information.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzcza.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(SettingsJsonConstants.ICON_WIDTH_KEY, i3).put(SettingsJsonConstants.ICON_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzayu.zzc("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzcza.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(SettingsJsonConstants.ICON_WIDTH_KEY, i3).put(SettingsJsonConstants.ICON_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzayu.zzc("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzds(String str) {
        try {
            JSONObject put = new JSONObject().put(SettingsJsonConstants.PROMPT_MESSAGE_KEY, str).put("action", this.zzdgj);
            if (this.zzcza != null) {
                this.zzcza.zzb("onError", put);
            }
        } catch (JSONException e) {
            zzayu.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdt(String str) {
        try {
            this.zzcza.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzayu.zzc("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzdu(String str) {
        try {
            this.zzcza.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzayu.zzc("Error occurred while dispatching state change.", e);
        }
    }
}
