package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzayk;
import com.google.android.gms.internal.ads.zzve;

/* loaded from: classes.dex */
public final class zzq extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdhy;
    private final zzy zzdhz;

    public zzq(Context context, zzp zzpVar, @Nullable zzy zzyVar) {
        super(context);
        this.zzdhz = zzyVar;
        setOnClickListener(this);
        this.zzdhy = new ImageButton(context);
        this.zzdhy.setImageResource(R.drawable.btn_dialog);
        this.zzdhy.setBackgroundColor(0);
        this.zzdhy.setOnClickListener(this);
        ImageButton imageButton = this.zzdhy;
        zzve.zzou();
        int zza = zzayk.zza(context, zzpVar.paddingLeft);
        zzve.zzou();
        int zza2 = zzayk.zza(context, 0);
        zzve.zzou();
        int zza3 = zzayk.zza(context, zzpVar.paddingRight);
        zzve.zzou();
        imageButton.setPadding(zza, zza2, zza3, zzayk.zza(context, zzpVar.paddingBottom));
        this.zzdhy.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.zzdhy;
        zzve.zzou();
        int zza4 = zzayk.zza(context, zzpVar.size + zzpVar.paddingLeft + zzpVar.paddingRight);
        zzve.zzou();
        addView(imageButton2, new FrameLayout.LayoutParams(zza4, zzayk.zza(context, zzpVar.size + zzpVar.paddingBottom), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzy zzyVar = this.zzdhz;
        if (zzyVar != null) {
            zzyVar.zztl();
        }
    }

    public final void zzal(boolean z) {
        ImageButton imageButton;
        int i;
        if (z) {
            imageButton = this.zzdhy;
            i = 8;
        } else {
            imageButton = this.zzdhy;
            i = 0;
        }
        imageButton.setVisibility(i);
    }
}
