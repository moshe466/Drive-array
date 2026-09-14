package com.lt.plugin.lt_plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.lt.plugin.lt_plugin.services.ActiveDispatchOverlayService;

/* loaded from: classes.dex */
public class ActiveDispatchPopupActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent launchIntentForPackage;
        super.onCreate(bundle);
        if (!ActiveDispatchOverlayService.showIncidentCard(this, null) && (launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName())) != null) {
            launchIntentForPackage.addFlags(805306368);
            startActivity(launchIntentForPackage);
        }
        finish();
    }
}
