package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class NativeAdMapper {
    protected boolean a;
    protected boolean b;
    protected Bundle c = new Bundle();
    protected View d;
    private VideoController zzcel;
    private View zzeis;
    private boolean zzeit;

    public View getAdChoicesContent() {
        return this.d;
    }

    public final Bundle getExtras() {
        return this.c;
    }

    public final boolean getOverrideClickHandling() {
        return this.b;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.a;
    }

    public final VideoController getVideoController() {
        return this.zzcel;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.zzeit;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.d = view;
    }

    public final void setExtras(Bundle bundle) {
        this.c = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.zzeit = z;
    }

    public void setMediaView(View view) {
        this.zzeis = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.b = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.a = z;
    }

    @Deprecated
    public void trackView(View view) {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.zzcel = videoController;
    }

    public final View zzabz() {
        return this.zzeis;
    }
}
