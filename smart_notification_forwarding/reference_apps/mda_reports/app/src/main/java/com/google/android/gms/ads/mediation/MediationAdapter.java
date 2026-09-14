package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* loaded from: classes.dex */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* loaded from: classes.dex */
    public static class zza {
        private int zzeij;

        public final Bundle zzaby() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzeij);
            return bundle;
        }

        public final zza zzdf(int i) {
            this.zzeij = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
