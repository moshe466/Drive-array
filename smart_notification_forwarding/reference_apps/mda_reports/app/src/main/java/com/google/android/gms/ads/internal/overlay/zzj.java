package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzawt;

@VisibleForTesting
/* loaded from: classes.dex */
final class zzj extends RelativeLayout {

    @VisibleForTesting
    boolean a;

    @VisibleForTesting
    private zzawt zzdhk;

    public zzj(Context context, String str, String str2) {
        super(context);
        this.zzdhk = new zzawt(context, str);
        this.zzdhk.zzx(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return false;
        }
        this.zzdhk.zzd(motionEvent);
        return false;
    }
}
