package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbei;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbes;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.net.URISyntaxException;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzafr<T extends zzbei & zzbel & zzbep & zzbeq & zzbes> implements zzafn<T> {
    private final com.google.android.gms.ads.internal.zzc zzcxm;
    private final zzaoe zzcxn;

    public zzafr(com.google.android.gms.ads.internal.zzc zzcVar, zzaoe zzaoeVar) {
        this.zzcxm = zzcVar;
        this.zzcxn = zzaoeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Uri a(Context context, zzdq zzdqVar, Uri uri, View view, @Nullable Activity activity) {
        if (zzdqVar == null) {
            return uri;
        }
        try {
            return zzdqVar.zzc(uri) ? zzdqVar.zza(uri, context, view, activity) : uri;
        } catch (zzdt unused) {
            return uri;
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Uri a(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzayu.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    private final void zzab(boolean z) {
        zzaoe zzaoeVar = this.zzcxn;
        if (zzaoeVar != null) {
            zzaoeVar.zzac(z);
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            com.google.android.gms.ads.internal.zzq.zzks();
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            com.google.android.gms.ads.internal.zzq.zzks();
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return com.google.android.gms.ads.internal.zzq.zzks().zzwo();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbei zzbeiVar = (zzbei) obj;
        String zzb = zzauk.zzb((String) map.get("u"), zzbeiVar.getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            zzayu.zzez("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzc zzcVar = this.zzcxm;
        if (zzcVar != null && !zzcVar.zzjq()) {
            this.zzcxm.zzbq(zzb);
            return;
        }
        if ("expand".equalsIgnoreCase(str)) {
            if (((zzbel) zzbeiVar).zzaaf()) {
                zzayu.zzez("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzab(false);
                ((zzbep) zzbeiVar).zzc(zzc(map), zzd(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            zzab(false);
            zzbep zzbepVar = (zzbep) zzbeiVar;
            if (zzb != null) {
                zzbepVar.zza(zzc(map), zzd(map), zzb);
                return;
            } else {
                zzbepVar.zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
                return;
            }
        }
        if (SettingsJsonConstants.APP_KEY.equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzab(true);
            if (TextUtils.isEmpty(zzb)) {
                zzayu.zzez("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbep) zzbeiVar).zza(new com.google.android.gms.ads.internal.overlay.zzd(new zzafu(zzbeiVar.getContext(), ((zzbeq) zzbeiVar).zzaad(), ((zzbes) zzbeiVar).getView()).zze(map)));
                return;
            } catch (ActivityNotFoundException e) {
                zzayu.zzez(e.getMessage());
                return;
            }
        }
        zzab(true);
        String str2 = (String) map.get("intent_url");
        Intent intent = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                intent = Intent.parseUri(str2, 0);
            } catch (URISyntaxException e2) {
                String valueOf = String.valueOf(str2);
                zzayu.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (!Uri.EMPTY.equals(data)) {
                intent.setData(a(a(zzbeiVar.getContext(), ((zzbeq) zzbeiVar).zzaad(), data, ((zzbes) zzbeiVar).getView(), zzbeiVar.zzyn())));
            }
        }
        if (intent != null) {
            ((zzbep) zzbeiVar).zza(new com.google.android.gms.ads.internal.overlay.zzd(intent));
            return;
        }
        if (!TextUtils.isEmpty(zzb)) {
            zzb = a(a(zzbeiVar.getContext(), ((zzbeq) zzbeiVar).zzaad(), Uri.parse(zzb), ((zzbes) zzbeiVar).getView(), zzbeiVar.zzyn())).toString();
        }
        ((zzbep) zzbeiVar).zza(new com.google.android.gms.ads.internal.overlay.zzd((String) map.get("i"), zzb, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
    }
}
