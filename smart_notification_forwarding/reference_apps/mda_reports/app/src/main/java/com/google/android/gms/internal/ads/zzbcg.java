package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbcg implements zzafn<zzbaz> {
    private boolean zzecw;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzve.zzou();
            return zzayk.zza(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzayu.zzez(sb.toString());
            return i;
        }
    }

    private static void zza(zzbai zzbaiVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbaiVar.zzcv(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzayu.zzez(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbaiVar.zzcw(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbaiVar.zzcx(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbaiVar.zzcy(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbaiVar.zzcz(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbaz zzbazVar, Map map) {
        int i;
        zzbaz zzbazVar2 = zzbazVar;
        String str = (String) map.get("action");
        if (str == null) {
            zzayu.zzez("Action missing from video GMSG.");
            return;
        }
        if (zzayu.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzayu.zzea(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzayu.zzez("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbazVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzayu.zzez("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzayu.zzez("No MIME types specified for decoder properties inspection.");
                zzbai.zza(zzbazVar2, "missingMimeTypes");
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                zzayu.zzez("Video decoder properties available on API versions >= 16.");
                zzbai.zza(zzbazVar2, "deficientApiVersion");
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str4 : str3.split(",")) {
                hashMap.put(str4, zzayi.zzer(str4.trim()));
            }
            zzbai.zza(zzbazVar2, hashMap);
            return;
        }
        zzbao zzyk = zzbazVar2.zzyk();
        if (zzyk == null) {
            zzayu.zzez("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = AppSettingsData.STATUS_NEW.equals(str);
        boolean equals2 = "position".equals(str);
        if (equals || equals2) {
            Context context = zzbazVar2.getContext();
            int zza = zza(context, map, "x", 0);
            int zza2 = zza(context, map, "y", 0);
            int zza3 = zza(context, map, "w", -1);
            int zza4 = zza(context, map, "h", -1);
            int min = Math.min(zza3, zzbazVar2.zzyt() - zza);
            int min2 = Math.min(zza4, zzbazVar2.zzys() - zza2);
            try {
                i = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused2) {
                i = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (!equals || zzyk.zzye() != null) {
                zzyk.zze(zza, zza2, min, min2);
                return;
            }
            zzyk.zza(zza, zza2, min, min2, i, parseBoolean, new zzbaw((String) map.get("flags")));
            zzbai zzye = zzyk.zzye();
            if (zzye != null) {
                zza(zzye, (Map<String, String>) map);
                return;
            }
            return;
        }
        zzbed zzyl = zzbazVar2.zzyl();
        if (zzyl != null) {
            if ("timeupdate".equals(str)) {
                String str5 = (String) map.get("currentTime");
                if (str5 == null) {
                    zzayu.zzez("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzyl.zze(Float.parseFloat(str5));
                    return;
                } catch (NumberFormatException unused3) {
                    String valueOf = String.valueOf(str5);
                    zzayu.zzez(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                    return;
                }
            }
            if ("skip".equals(str)) {
                zzyl.zzabo();
                return;
            }
        }
        zzbai zzye2 = zzyk.zzye();
        if (zzye2 == null) {
            zzbai.zza(zzbazVar2);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zzbazVar2.getContext();
            int zza5 = zza(context2, map, "x", 0);
            int zza6 = zza(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zza5, zza6, 0);
            zzye2.zze(obtain);
            obtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str6 = (String) map.get("time");
            if (str6 == null) {
                zzayu.zzez("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzye2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                return;
            } catch (NumberFormatException unused4) {
                String valueOf2 = String.valueOf(str6);
                zzayu.zzez(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                return;
            }
        }
        if ("hide".equals(str)) {
            zzye2.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            zzye2.zzhq();
            return;
        }
        if ("loadControl".equals(str)) {
            zza(zzye2, (Map<String, String>) map);
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzye2.zzxy();
                return;
            } else {
                zzye2.zzxz();
                return;
            }
        }
        if ("pause".equals(str)) {
            zzye2.pause();
            return;
        }
        if ("play".equals(str)) {
            zzye2.play();
            return;
        }
        if ("show".equals(str)) {
            zzye2.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            String str7 = (String) map.get("src");
            String[] strArr = {str7};
            String str8 = (String) map.get("demuxed");
            if (str8 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str8);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr2[i2] = jSONArray.getString(i2);
                    }
                    strArr = strArr2;
                } catch (JSONException unused5) {
                    String valueOf3 = String.valueOf(str8);
                    zzayu.zzez(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                    strArr = new String[]{str7};
                }
            }
            zzye2.zzc(str7, strArr);
            return;
        }
        if ("touchMove".equals(str)) {
            Context context3 = zzbazVar2.getContext();
            zzye2.zza(zza(context3, map, "dx", 0), zza(context3, map, "dy", 0));
            if (this.zzecw) {
                return;
            }
            zzbazVar2.zzts();
            this.zzecw = true;
            return;
        }
        if (!"volume".equals(str)) {
            if ("watermark".equals(str)) {
                zzye2.zzya();
                return;
            } else {
                String valueOf4 = String.valueOf(str);
                zzayu.zzez(valueOf4.length() != 0 ? "Unknown video action: ".concat(valueOf4) : new String("Unknown video action: "));
                return;
            }
        }
        String str9 = (String) map.get("volume");
        if (str9 == null) {
            zzayu.zzez("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            zzye2.setVolume(Float.parseFloat(str9));
        } catch (NumberFormatException unused6) {
            String valueOf5 = String.valueOf(str9);
            zzayu.zzez(valueOf5.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf5) : new String("Could not parse volume parameter from volume video GMSG: "));
        }
    }
}
