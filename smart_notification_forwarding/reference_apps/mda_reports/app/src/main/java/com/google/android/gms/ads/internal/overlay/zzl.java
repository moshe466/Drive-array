package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ads.zzavo;
import com.google.android.gms.internal.ads.zzawb;
import com.google.android.gms.internal.ads.zzawh;

/* loaded from: classes.dex */
final class zzl extends zzavo {
    final /* synthetic */ zzc a;

    private zzl(zzc zzcVar) {
        this.a = zzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavo
    public final void zztu() {
        Bitmap zza = com.google.android.gms.ads.internal.zzq.zzlj().zza(Integer.valueOf(this.a.b.zzdhx.zzblc));
        if (zza != null) {
            zzawh zzks = com.google.android.gms.ads.internal.zzq.zzks();
            zzc zzcVar = this.a;
            Activity activity = zzcVar.a;
            com.google.android.gms.ads.internal.zzg zzgVar = zzcVar.b.zzdhx;
            final Drawable zza2 = zzks.zza(activity, zza, zzgVar.zzbla, zzgVar.zzblb);
            zzawb.zzdsr.post(new Runnable(this, zza2) { // from class: com.google.android.gms.ads.internal.overlay.zzk
                private final zzl zzdhm;
                private final Drawable zzdhn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdhm = this;
                    this.zzdhn = zza2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzl zzlVar = this.zzdhm;
                    zzlVar.a.a.getWindow().setBackgroundDrawable(this.zzdhn);
                }
            });
        }
    }
}
