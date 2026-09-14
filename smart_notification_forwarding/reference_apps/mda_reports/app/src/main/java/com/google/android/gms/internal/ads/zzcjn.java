package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcjn implements zzcio<zzbtu> {
    private final zzczj zzfbj;
    private final Executor zzfci;
    private final zzbup zzfyt;
    private final Context zzup;

    public zzcjn(Context context, Executor executor, zzbup zzbupVar, zzczj zzczjVar) {
        this.zzup = context;
        this.zzfyt = zzbupVar;
        this.zzfci = executor;
        this.zzfbj = zzczjVar;
    }

    private static String zzc(zzczl zzczlVar) {
        try {
            return zzczlVar.zzglr.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(Uri uri, zzczt zzcztVar, zzczl zzczlVar, Object obj) {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzd zzdVar = new com.google.android.gms.ads.internal.overlay.zzd(build.intent);
            final zzazl zzazlVar = new zzazl();
            zzbtw zza = this.zzfyt.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzbtv(new zzbuv(zzazlVar) { // from class: com.google.android.gms.internal.ads.zzcjp
                private final zzazl zzbru;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbru = zzazlVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbuv
                public final void zza(boolean z, Context context) {
                    zzazl zzazlVar2 = this.zzbru;
                    try {
                        com.google.android.gms.ads.internal.zzq.zzkp();
                        com.google.android.gms.ads.internal.overlay.zzn.zza(context, (AdOverlayInfoParcel) zzazlVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzazlVar.set(new AdOverlayInfoParcel(zzdVar, null, zza.zzaen(), null, new zzazb(0, 0, false)));
            this.zzfbj.zzvb();
            return zzdgs.zzaj(zza.zzaem());
        } catch (Throwable th) {
            zzayu.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        return (this.zzup instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaao.zzk(this.zzup) && !TextUtils.isEmpty(zzc(zzczlVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<zzbtu> zzb(final zzczt zzcztVar, final zzczl zzczlVar) {
        String zzc = zzc(zzczlVar);
        final Uri parse = zzc != null ? Uri.parse(zzc) : null;
        return zzdgs.zzb(zzdgs.zzaj(null), new zzdgf(this, parse, zzcztVar, zzczlVar) { // from class: com.google.android.gms.internal.ads.zzcjq
            private final zzcjn zzfyu;
            private final Uri zzfyv;
            private final zzczt zzfyw;
            private final zzczl zzfyx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyu = this;
                this.zzfyv = parse;
                this.zzfyw = zzcztVar;
                this.zzfyx = zzczlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzfyu.a(this.zzfyv, this.zzfyw, this.zzfyx, obj);
            }
        }, this.zzfci);
    }
}
