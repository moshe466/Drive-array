package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbvr implements zzbxa {
    private final zzazb zzbll;
    private final Clock zzbmq;
    private final zzdq zzefv;
    private final zzdda zzfbm;
    private final zzbwz zzfea;
    private final zzczl zzffc;
    private final zzczu zzfgl;
    private final JSONObject zzfka;
    private final zzcaj zzfkb;
    private final zzbws zzfkc;
    private final zzbpd zzfkd;
    private final zzboq zzfke;
    private final zzbjd zzfkf;
    private final zzbxq zzfkg;
    private final zzbst zzfkh;
    private boolean zzfkj;
    private zzwn zzfkq;
    private final Context zzup;
    private boolean zzfki = false;
    private boolean zzfkk = false;
    private boolean zzfkl = false;
    private Point zzfkm = new Point();
    private Point zzfkn = new Point();
    private long zzfko = 0;
    private long zzfkp = 0;

    public zzbvr(Context context, zzbwz zzbwzVar, JSONObject jSONObject, zzcaj zzcajVar, zzbws zzbwsVar, zzdq zzdqVar, zzbpd zzbpdVar, zzboq zzboqVar, zzczl zzczlVar, zzazb zzazbVar, zzczu zzczuVar, zzbjd zzbjdVar, zzbxq zzbxqVar, Clock clock, zzbst zzbstVar, zzdda zzddaVar) {
        this.zzup = context;
        this.zzfea = zzbwzVar;
        this.zzfka = jSONObject;
        this.zzfkb = zzcajVar;
        this.zzfkc = zzbwsVar;
        this.zzefv = zzdqVar;
        this.zzfkd = zzbpdVar;
        this.zzfke = zzboqVar;
        this.zzffc = zzczlVar;
        this.zzbll = zzazbVar;
        this.zzfgl = zzczuVar;
        this.zzfkf = zzbjdVar;
        this.zzfkg = zzbxqVar;
        this.zzbmq = clock;
        this.zzfkh = zzbstVar;
        this.zzfbm = zzddaVar;
    }

    private final JSONObject zza(@Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, @Nullable View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int[] zzx = zzx(view);
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, WeakReference<View>> next = it.next();
                View view2 = next.getValue().get();
                if (view2 != null) {
                    int[] zzx2 = zzx(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator<Map.Entry<String, WeakReference<View>>> it2 = it;
                    try {
                        jSONObject4.put(SettingsJsonConstants.ICON_WIDTH_KEY, zzdi(view2.getMeasuredWidth()));
                        jSONObject4.put(SettingsJsonConstants.ICON_HEIGHT_KEY, zzdi(view2.getMeasuredHeight()));
                        jSONObject4.put("x", zzdi(zzx2[0] - zzx[0]));
                        jSONObject4.put("y", zzdi(zzx2[1] - zzx[1]));
                        jSONObject4.put(str4, str3);
                        jSONObject3.put("frame", jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = zzb(rect);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put(SettingsJsonConstants.ICON_WIDTH_KEY, 0);
                            jSONObject.put(SettingsJsonConstants.ICON_HEIGHT_KEY, 0);
                            jSONObject.put("x", zzdi(zzx2[0] - zzx[0]));
                            jSONObject.put("y", zzdi(zzx2[1] - zzx[1]));
                            jSONObject.put(str4, str3);
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            str = str3;
                            str2 = str4;
                            try {
                                jSONObject3.put("font_size", textView.getTextSize());
                                jSONObject3.put("text", textView.getText());
                            } catch (JSONException unused) {
                                zzayu.zzez("Unable to get asset views information");
                                it = it2;
                                str3 = str;
                                str4 = str2;
                            }
                        } else {
                            str = str3;
                            str2 = str4;
                        }
                        jSONObject3.put("is_clickable", map2 != null && map2.containsKey(next.getKey()) && view2.isClickable());
                        jSONObject2.put(next.getKey(), jSONObject3);
                    } catch (JSONException unused2) {
                        str = str3;
                        str2 = str4;
                    }
                    it = it2;
                    str3 = str;
                    str4 = str2;
                }
            }
        }
        return jSONObject2;
    }

    private final void zza(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzfka);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.zzfea.zzga(this.zzfkc.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzfkc.zzaja());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfgl.zzddz != null && this.zzfgl.zzddz.zzbkb);
            jSONObject8.put("custom_mute_enabled", (this.zzfkc.getMuteThisAdReasons().isEmpty() || this.zzfkc.zzajd() == null) ? false : true);
            if (this.zzfkg.zzakh() != null && this.zzfka.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbmq.currentTimeMillis());
            if (this.zzfkl && zzain()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.zzfea.zzga(this.zzfkc.getCustomTemplateId()) != null);
            jSONObject8.put("click_signals", zzv(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbmq.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzfko);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzfkp);
            jSONObject7.put("touch_signal", jSONObject9);
            zzazh.zza(this.zzfkb.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzayu.zzc("Unable to create click JSON.", e);
        }
    }

    private final boolean zza(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzfka);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcls)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            this.zzfkb.zza("/logScionEvent", new zzbvt(this));
            this.zzfkb.zza("/nativeImpression", new zzbvw(this));
            zzazh.zza(this.zzfkb.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            boolean z = this.zzfki;
            if (z || this.zzffc.zzglt == null) {
                return true;
            }
            this.zzfki = z | com.google.android.gms.ads.internal.zzq.zzla().zzb(this.zzup, this.zzbll.zzbma, this.zzffc.zzglt.toString(), this.zzfgl.zzgmm);
            return true;
        } catch (JSONException e) {
            zzayu.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final boolean zzain() {
        return this.zzfka.optBoolean("allow_custom_click_gesture", false);
    }

    @Nullable
    private final JSONObject zzair() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", zzdi(this.zzfkm.x));
            jSONObject.put("y", zzdi(this.zzfkm.y));
            jSONObject.put("start_x", zzdi(this.zzfkn.x));
            jSONObject.put("start_y", zzdi(this.zzfkn.y));
            return jSONObject;
        } catch (JSONException e) {
            zzayu.zzc("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    @Nullable
    private final String zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (map != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int zzaja = this.zzfkc.zzaja();
        if (zzaja == 1) {
            return "1099";
        }
        if (zzaja == 2) {
            return "2099";
        }
        if (zzaja == 3 || zzaja != 6) {
            return null;
        }
        return "3099";
    }

    private final JSONObject zzb(Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SettingsJsonConstants.ICON_WIDTH_KEY, zzdi(rect.right - rect.left));
        jSONObject.put(SettingsJsonConstants.ICON_HEIGHT_KEY, zzdi(rect.bottom - rect.top));
        jSONObject.put("x", zzdi(rect.left));
        jSONObject.put("y", zzdi(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private final int zzdi(int i) {
        return zzve.zzou().zzb(this.zzup, i);
    }

    private final boolean zzft(String str) {
        JSONObject optJSONObject = this.zzfka.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    private final JSONObject zzfv(@Nullable String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put("click_point", zzair());
            jSONObject.put("asset_id", str);
        } catch (Exception e2) {
            e = e2;
            zzayu.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6 A[Catch: JSONException -> 0x00fa, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00fa, blocks: (B:18:0x00c5, B:26:0x00ed, B:27:0x00f1, B:28:0x00f6, B:29:0x00d4, B:32:0x00de), top: B:17:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00de A[Catch: JSONException -> 0x00fa, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00fa, blocks: (B:18:0x00c5, B:26:0x00ed, B:27:0x00f1, B:28:0x00f6, B:29:0x00d4, B:32:0x00de), top: B:17:0x00c5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final org.json.JSONObject zzs(@androidx.annotation.Nullable android.view.View r14) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvr.zzs(android.view.View):org.json.JSONObject");
    }

    private static JSONObject zzt(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.zzq.zzkq();
            jSONObject.put("contained_in_scroll_view", zzawb.zzp(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private final JSONObject zzu(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.zzq.zzkq();
            jSONObject.put("can_show_on_lock_screen", zzawb.zzo(view));
            com.google.android.gms.ads.internal.zzq.zzkq();
            jSONObject.put("is_keyguard_locked", zzawb.zzax(this.zzup));
        } catch (JSONException unused) {
            zzayu.zzez("Unable to get lock screen information");
        }
        return jSONObject;
    }

    private final String zzv(View view) {
        try {
            JSONObject optJSONObject = this.zzfka.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzefv.zzbw().zza(this.zzup, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzayu.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    private final String zzw(View view) {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcls)).booleanValue()) {
            return null;
        }
        try {
            return this.zzefv.zzbw().zza(this.zzup, view, (Activity) null);
        } catch (Exception unused) {
            zzayu.zzex("Exception getting data.");
            return null;
        }
    }

    private static int[] zzx(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void cancelUnconfirmedClick() {
        if (this.zzfka.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzfkg.cancelUnconfirmedClick();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void destroy() {
        this.zzfkb.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final boolean isCustomClickGestureEnabled() {
        return zzain();
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void setClickConfirmingView(View view) {
        if (!this.zzfka.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzayu.zzez("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzbxq zzbxqVar = this.zzfkg;
        if (view != null) {
            view.setOnClickListener(zzbxqVar);
            view.setClickable(true);
            zzbxqVar.c = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        int[] zzx = zzx(view2);
        this.zzfkm = new Point(((int) motionEvent.getRawX()) - zzx[0], ((int) motionEvent.getRawY()) - zzx[1]);
        long currentTimeMillis = this.zzbmq.currentTimeMillis();
        this.zzfkp = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzfko = currentTimeMillis;
            this.zzfkn = this.zzfkm;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzfkm;
        obtain.setLocation(point.x, point.y);
        this.zzefv.zza(obtain);
        obtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject zza = zza(map, map2, view2);
        JSONObject zzs = zzs(view2);
        JSONObject zzt = zzt(view2);
        JSONObject zzu = zzu(view2);
        String zzb = zzb(view, map);
        zza(view, zzs, zza, zzt, zzu, zzb, zzfv(zzb), null, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        this.zzfkm = new Point();
        this.zzfkn = new Point();
        this.zzfkh.zzr(view);
        this.zzfkj = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        zza(zzs(view), zza(map, map2, view), zzt(view), zzu(view), zzw(view), null);
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzfkm = new Point();
        this.zzfkn = new Point();
        if (!this.zzfkj) {
            this.zzfkh.zzq(view);
            this.zzfkj = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzfkf.zzo(this);
        boolean zzcs = zzaxy.zzcs(this.zzbll.zzdwa);
        if (map != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = it.next().getValue().get();
                if (view2 != null) {
                    if (zzcs) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = it2.next().getValue().get();
                if (view3 != null) {
                    if (zzcs) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfkl) {
            zzayu.zzea("Custom click reporting failed. enableCustomClickGesture is not set.");
            return;
        }
        if (!zzain()) {
            zzayu.zzea("Custom click reporting failed. Ad unit id not whitelisted.");
            return;
        }
        JSONObject zza = zza(map, map2, view);
        JSONObject zzs = zzs(view);
        JSONObject zzt = zzt(view);
        JSONObject zzu = zzu(view);
        String zzb = zzb(null, map);
        zza(view, zzs, zza, zzt, zzu, zzb, zzfv(zzb), null, z, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(zzaeb zzaebVar) {
        if (this.zzfka.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzfkg.zza(zzaebVar);
        } else {
            zzayu.zzez("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(zzwn zzwnVar) {
        this.zzfkq = zzwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(@Nullable zzwr zzwrVar) {
        try {
            if (this.zzfkk) {
                return;
            }
            if (zzwrVar != null || this.zzfkc.zzajd() == null) {
                this.zzfkk = true;
                this.zzfbm.zzen(zzwrVar.zzph());
                zzaip();
            } else {
                this.zzfkk = true;
                this.zzfbm.zzen(this.zzfkc.zzajd().zzph());
                zzaip();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzaio() {
        zza(null, null, null, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzaip() {
        try {
            if (this.zzfkq != null) {
                this.zzfkq.onAdMuted();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzaiq() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzfka);
            zzazh.zza(this.zzfkb.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzf(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzayu.zzea("Click data is null. No click is reported.");
        } else if (!zzft("click_reporting")) {
            zzayu.zzex("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, com.google.android.gms.ads.internal.zzq.zzkq().zza(bundle, (JSONObject) null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzfu(String str) {
        zza(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzg(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzayu.zzea("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!zzft("touch_reporting")) {
            zzayu.zzex("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
            return;
        }
        this.zzefv.zzbw().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final boolean zzh(Bundle bundle) {
        if (zzft("impression_reporting")) {
            return zza(null, null, null, null, null, com.google.android.gms.ads.internal.zzq.zzkq().zza(bundle, (JSONObject) null));
        }
        zzayu.zzex("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzrp() {
        this.zzfkl = true;
    }
}
