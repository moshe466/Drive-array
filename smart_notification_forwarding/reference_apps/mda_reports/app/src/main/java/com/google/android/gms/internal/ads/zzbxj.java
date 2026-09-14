package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbxj {
    private final Executor executor;
    private final zzaby zzddz;
    private final zzavu zzdrk;
    private final Executor zzfci;
    private final zzczu zzfgl;
    private final zzbws zzfkc;
    private final zzbww zzfli;
    private final zzbwq zzflq;

    @Nullable
    private final zzbxr zzfnn;
    private final Context zzup;

    public zzbxj(Context context, zzavu zzavuVar, zzczu zzczuVar, zzbww zzbwwVar, zzbws zzbwsVar, @Nullable zzbxr zzbxrVar, Executor executor, Executor executor2, zzbwq zzbwqVar) {
        this.zzup = context;
        this.zzdrk = zzavuVar;
        this.zzfgl = zzczuVar;
        this.zzddz = zzczuVar.zzddz;
        this.zzfli = zzbwwVar;
        this.zzfkc = zzbwsVar;
        this.zzfnn = zzbxrVar;
        this.zzfci = executor;
        this.executor = executor2;
        this.zzflq = zzbwqVar;
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(zzbxz zzbxzVar, String[] strArr) {
        Map<String, WeakReference<View>> zzaka = zzbxzVar.zzaka();
        if (zzaka == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzaka.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzfkc.zzaje() != null) {
            if (2 == this.zzfkc.zzaja() || 1 == this.zzfkc.zzaja()) {
                this.zzdrk.zza(this.zzfgl.zzgmm, String.valueOf(this.zzfkc.zzaja()), z);
            } else if (6 == this.zzfkc.zzaja()) {
                this.zzdrk.zza(this.zzfgl.zzgmm, ExifInterface.GPS_MEASUREMENT_2D, z);
                this.zzdrk.zza(this.zzfgl.zzgmm, "1", z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbxz zzbxzVar) {
        ViewGroup viewGroup;
        View view;
        final ViewGroup viewGroup2;
        IObjectWrapper zzrc;
        Drawable drawable;
        int i = 0;
        if (this.zzfli.zzajo() || this.zzfli.zzajn()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            for (int i2 = 0; i2 < 2; i2++) {
                View zzgb = zzbxzVar.zzgb(strArr[i2]);
                if (zzgb != null && (zzgb instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzgb;
                    break;
                }
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzfkc.zzajb() != null) {
            view = this.zzfkc.zzajb();
            zzaby zzabyVar = this.zzddz;
            if (zzabyVar != null && !z) {
                zza(layoutParams, zzabyVar.zzbjz);
                view.setLayoutParams(layoutParams);
            }
        } else if (this.zzfkc.zzrh() instanceof zzabp) {
            zzabp zzabpVar = (zzabp) this.zzfkc.zzrh();
            if (!z) {
                zza(layoutParams, zzabpVar.zzra());
            }
            View zzabsVar = new zzabs(this.zzup, zzabpVar, layoutParams);
            zzabsVar.setContentDescription((CharSequence) zzve.zzoy().zzd(zzzn.zzcme));
            view = zzabsVar;
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzbxzVar.zzaga().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout zzakd = zzbxzVar.zzakd();
                if (zzakd != null) {
                    zzakd.addView(adChoicesView);
                }
            }
            zzbxzVar.zza(zzbxzVar.zzakc(), view, true);
        }
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcqc)).booleanValue()) {
            zzc(zzbxzVar);
        }
        String[] strArr2 = zzbxh.zzfna;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                viewGroup2 = null;
                break;
            }
            View zzgb2 = zzbxzVar.zzgb(strArr2[i]);
            if (zzgb2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzgb2;
                break;
            }
            i++;
        }
        this.executor.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.zzbxl
            private final zzbxj zzfnp;
            private final ViewGroup zzfnq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfnp = this;
                this.zzfnq = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfnp.a(this.zzfnq);
            }
        });
        if (viewGroup2 != null) {
            if (zza(viewGroup2)) {
                if (this.zzfkc.zzajf() != null) {
                    this.zzfkc.zzajf().zza(new zzbxo(this, zzbxzVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View zzaga = zzbxzVar.zzaga();
            Context context = zzaga != null ? zzaga.getContext() : null;
            if (context != null) {
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzcmd)).booleanValue()) {
                    zzacd zzrq = this.zzflq.zzrq();
                    if (zzrq == null) {
                        return;
                    }
                    try {
                        zzrc = zzrq.zzre();
                    } catch (RemoteException unused) {
                        zzayu.zzez("Could not get main image drawable");
                        return;
                    }
                } else {
                    zzaci zzajc = this.zzfkc.zzajc();
                    if (zzajc == null) {
                        return;
                    }
                    try {
                        zzrc = zzajc.zzrc();
                    } catch (RemoteException unused2) {
                        zzayu.zzez("Could not get drawable from image");
                        return;
                    }
                }
                if (zzrc == null || (drawable = (Drawable) ObjectWrapper.unwrap(zzrc)) == null) {
                    return;
                }
                ImageView imageView = new ImageView(context);
                imageView.setImageDrawable(drawable);
                IObjectWrapper zzakf = zzbxzVar != null ? zzbxzVar.zzakf() : null;
                imageView.setScaleType((zzakf == null || !((Boolean) zzve.zzoy().zzd(zzzn.zzcqe)).booleanValue()) ? ImageView.ScaleType.CENTER_INSIDE : (ImageView.ScaleType) ObjectWrapper.unwrap(zzakf));
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                viewGroup2.addView(imageView);
            }
        }
    }

    public final void zza(final zzbxz zzbxzVar) {
        this.zzfci.execute(new Runnable(this, zzbxzVar) { // from class: com.google.android.gms.internal.ads.zzbxm
            private final zzbxj zzfnp;
            private final zzbxz zzfnr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfnp = this;
                this.zzfnr = zzbxzVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfnp.a(this.zzfnr);
            }
        });
    }

    public final boolean zza(@NonNull ViewGroup viewGroup) {
        View zzaje = this.zzfkc.zzaje();
        if (zzaje == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzaje.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzaje.getParent()).removeView(zzaje);
        }
        viewGroup.addView(zzaje, ((Boolean) zzve.zzoy().zzd(zzzn.zzcmh)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    public final void zzc(@Nullable zzbxz zzbxzVar) {
        if (zzbxzVar == null || this.zzfnn == null || zzbxzVar.zzakd() == null) {
            return;
        }
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcqd)).booleanValue() || this.zzfli.zzajm()) {
            try {
                zzbxzVar.zzakd().addView(this.zzfnn.zzakj());
            } catch (zzbdv e) {
                zzavs.zza("web view can not be obtained", e);
            }
        }
    }
}
