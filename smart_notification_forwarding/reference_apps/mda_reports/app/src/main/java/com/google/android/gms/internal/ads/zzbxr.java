package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbxr {
    private final zzbxa zzflg;
    private final zzcaj zzfnx;
    private final zzcbn zzfod;
    private final zzbjq zzfoe;
    private final Context zzup;

    public zzbxr(Context context, zzcbn zzcbnVar, zzcaj zzcajVar, zzbjq zzbjqVar, zzbxa zzbxaVar) {
        this.zzup = context;
        this.zzfod = zzcbnVar;
        this.zzfnx = zzcajVar;
        this.zzfoe = zzbjqVar;
        this.zzflg = zzbxaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbdi zzbdiVar, Map map) {
        zzayu.zzey("Hiding native ads overlay.");
        zzbdiVar.getView().setVisibility(8);
        this.zzfoe.zzbf(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzfnx.zza("sendMessageToNativeJs", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzbdi zzbdiVar, Map map) {
        zzayu.zzey("Showing native ads overlay.");
        zzbdiVar.getView().setVisibility(0);
        this.zzfoe.zzbf(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(zzbdi zzbdiVar, Map map) {
        this.zzflg.zzaip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(zzbdi zzbdiVar, Map map) {
        this.zzfnx.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }

    public final View zzakj() {
        zzbdi zza = this.zzfod.zza(zzuj.zzg(this.zzup), false);
        zza.getView().setVisibility(8);
        zza.zza("/sendMessageToSdk", new zzafn(this) { // from class: com.google.android.gms.internal.ads.zzbxu
            private final zzbxr zzfof;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfof = this;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                this.zzfof.d((zzbdi) obj, map);
            }
        });
        zza.zza("/adMuted", new zzafn(this) { // from class: com.google.android.gms.internal.ads.zzbxt
            private final zzbxr zzfof;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfof = this;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                this.zzfof.c((zzbdi) obj, map);
            }
        });
        this.zzfnx.zza(new WeakReference(zza), "/loadHtml", new zzafn(this) { // from class: com.google.android.gms.internal.ads.zzbxw
            private final zzbxr zzfof;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfof = this;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, final Map map) {
                final zzbxr zzbxrVar = this.zzfof;
                zzbdi zzbdiVar = (zzbdi) obj;
                zzbdiVar.zzaaa().zza(new zzbeu(zzbxrVar, map) { // from class: com.google.android.gms.internal.ads.zzbxx
                    private final Map zzdvw;
                    private final zzbxr zzfof;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfof = zzbxrVar;
                        this.zzdvw = map;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbeu
                    public final void zzak(boolean z) {
                        this.zzfof.a(this.zzdvw, z);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzbdiVar.loadData(str, "text/html", HttpRequest.CHARSET_UTF8);
                } else {
                    zzbdiVar.loadDataWithBaseURL(str2, str, "text/html", HttpRequest.CHARSET_UTF8, null);
                }
            }
        });
        this.zzfnx.zza(new WeakReference(zza), "/showOverlay", new zzafn(this) { // from class: com.google.android.gms.internal.ads.zzbxv
            private final zzbxr zzfof;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfof = this;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                this.zzfof.b((zzbdi) obj, map);
            }
        });
        this.zzfnx.zza(new WeakReference(zza), "/hideOverlay", new zzafn(this) { // from class: com.google.android.gms.internal.ads.zzbxy
            private final zzbxr zzfof;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfof = this;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                this.zzfof.a((zzbdi) obj, map);
            }
        });
        return zza.getView();
    }
}
