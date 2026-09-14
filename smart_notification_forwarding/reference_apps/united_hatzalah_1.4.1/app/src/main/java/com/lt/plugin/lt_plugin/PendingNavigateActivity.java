package com.lt.plugin.lt_plugin;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager$KeyguardDismissCallback;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class PendingNavigateActivity extends Activity {
    public static final String EXTRA_NAV_LAT = "nav_lat";
    public static final String EXTRA_NAV_LNG = "nav_lng";
    private static final String TAG = "PendingNavigateActivity";
    private String lat;
    private boolean launched;
    private String lng;

    /* JADX INFO: Access modifiers changed from: private */
    public void openMapsAndFinish() {
        if (this.launched) {
            return;
        }
        this.launched = true;
        PushActionHelper.launchNavigateNow(this, this.lat, this.lng);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        int i = Build.VERSION.SDK_INT;
        if (i >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        } else {
            getWindow().addFlags(6815872);
        }
        Intent intent = getIntent();
        String str2 = null;
        if (intent != null) {
            str = intent.getStringExtra("nav_lat");
        } else {
            str = null;
        }
        this.lat = str;
        if (intent != null) {
            str2 = intent.getStringExtra("nav_lng");
        }
        this.lng = str2;
        if (!PushActionHelper.hasNavigate("true", this.lat, str2)) {
            finish();
            return;
        }
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
            if (i >= 26) {
                keyguardManager.requestDismissKeyguard(this, new KeyguardManager$KeyguardDismissCallback() { // from class: com.lt.plugin.lt_plugin.PendingNavigateActivity.1
                    public void onDismissCancelled() {
                        PushActionHelper.deferNavigateUntilUnlock(PendingNavigateActivity.this.getApplicationContext(), PendingNavigateActivity.this.lat, PendingNavigateActivity.this.lng);
                        PendingNavigateActivity.this.finish();
                    }

                    public void onDismissError() {
                        PushActionHelper.deferNavigateUntilUnlock(PendingNavigateActivity.this.getApplicationContext(), PendingNavigateActivity.this.lat, PendingNavigateActivity.this.lng);
                        PendingNavigateActivity.this.finish();
                    }

                    public void onDismissSucceeded() {
                        PendingNavigateActivity.this.openMapsAndFinish();
                    }
                });
                return;
            } else {
                PushActionHelper.deferNavigateUntilUnlock(getApplicationContext(), this.lat, this.lng);
                finish();
                return;
            }
        }
        openMapsAndFinish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        if (!this.launched) {
            if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
                openMapsAndFinish();
            }
        }
    }
}
