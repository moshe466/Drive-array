package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbjb implements zzajv<zzbjf> {
    private final zzpn zzfcc;
    private final Context zzup;
    private final PowerManager zzyw;

    public zzbjb(Context context, zzpn zzpnVar) {
        this.zzup = context;
        this.zzfcc = zzpnVar;
        this.zzyw = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final JSONObject zzj(zzbjf zzbjfVar) {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzpt zzptVar = zzbjfVar.zzfcr;
        if (zzptVar == null) {
            jSONObject = new JSONObject();
        } else {
            if (this.zzfcc.zzkl() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzptVar.zzbnz;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("afmaVersion", this.zzfcc.zzkk()).put("activeViewJSON", this.zzfcc.zzkl()).put("timestamp", zzbjfVar.timestamp).put("adFormat", this.zzfcc.zzkj()).put("hashCode", this.zzfcc.zzkm()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbjfVar.zzfco).put("isNative", this.zzfcc.zzkn()).put("isScreenOn", Build.VERSION.SDK_INT >= 20 ? this.zzyw.isInteractive() : this.zzyw.isScreenOn()).put("appMuted", com.google.android.gms.ads.internal.zzq.zzkv().zzpf()).put("appVolume", com.google.android.gms.ads.internal.zzq.zzkv().zzpe()).put("deviceVolume", zzawq.zzbe(this.zzup.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zzup.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzptVar.zzzd).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzptVar.zzboa.top).put("bottom", zzptVar.zzboa.bottom).put("left", zzptVar.zzboa.left).put("right", zzptVar.zzboa.right)).put("adBox", new JSONObject().put("top", zzptVar.zzbob.top).put("bottom", zzptVar.zzbob.bottom).put("left", zzptVar.zzbob.left).put("right", zzptVar.zzbob.right)).put("globalVisibleBox", new JSONObject().put("top", zzptVar.zzboc.top).put("bottom", zzptVar.zzboc.bottom).put("left", zzptVar.zzboc.left).put("right", zzptVar.zzboc.right)).put("globalVisibleBoxVisible", zzptVar.zzbod).put("localVisibleBox", new JSONObject().put("top", zzptVar.zzboe.top).put("bottom", zzptVar.zzboe.bottom).put("left", zzptVar.zzboe.left).put("right", zzptVar.zzboe.right)).put("localVisibleBoxVisible", zzptVar.zzbof).put("hitBox", new JSONObject().put("top", zzptVar.zzbog.top).put("bottom", zzptVar.zzbog.bottom).put("left", zzptVar.zzbog.left).put("right", zzptVar.zzbog.right)).put("screenDensity", this.zzup.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbjfVar.zzbnq);
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzckk)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzptVar.zzboi;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbjfVar.zzfcq)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
