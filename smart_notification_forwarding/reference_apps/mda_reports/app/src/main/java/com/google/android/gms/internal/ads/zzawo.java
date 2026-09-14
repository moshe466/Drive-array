package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@TargetApi(28)
/* loaded from: classes.dex */
public final class zzawo extends zzawp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets a(Activity activity, View view, WindowInsets windowInsets) {
        if (com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzwg() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String str = "";
            if (displayCutout != null) {
                zzavu zzvf = com.google.android.gms.ads.internal.zzq.zzku().zzvf();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                zzvf.zzeh(str);
            } else {
                com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzeh("");
            }
        }
        zza(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static void zza(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = attributes.layoutInDisplayCutoutMode;
        int i2 = z ? 1 : 2;
        if (i2 != i) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawh
    public final void zzg(final Activity activity) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcjk)).booleanValue() && com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzwg() == null && !activity.isInMultiWindowMode()) {
            zza(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this, activity) { // from class: com.google.android.gms.internal.ads.zzawr
                private final zzawo zzdsy;
                private final Activity zzdsz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdsy = this;
                    this.zzdsz = activity;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzawo.a(this.zzdsz, view, windowInsets);
                }
            });
        }
    }
}
