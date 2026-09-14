package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;

@TargetApi(18)
/* loaded from: classes.dex */
public class zzawl extends zzawi {
    @Override // com.google.android.gms.internal.ads.zzawh
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzawh
    public final int zzwo() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzawh
    public final long zzws() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzclt)).booleanValue()) {
            return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return -1L;
    }
}
