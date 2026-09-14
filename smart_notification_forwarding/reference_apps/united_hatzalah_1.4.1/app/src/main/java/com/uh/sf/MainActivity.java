package com.uh.sf;

import android.content.Intent;
import android.os.Bundle;
import com.lt.plugin.lt_plugin.AppLinkIntentHelper;
import com.lt.plugin.lt_plugin.PushEntityIntentHelper;
import com.lt.plugin.lt_plugin.utils.SessionPreferencesHelper;
import io.flutter.embedding.android.FlutterFragmentActivity;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class MainActivity extends FlutterFragmentActivity {
    @Override // io.flutter.embedding.android.FlutterFragmentActivity, androidx.fragment.app.L, c.m, w.f, android.app.Activity
    public final void onCreate(Bundle bundle) {
        boolean consumeIntentToFlutterPrefs = PushEntityIntentHelper.consumeIntentToFlutterPrefs(this, getIntent());
        if (AppLinkIntentHelper.consumeIntentToFlutterPrefs(this, getIntent(), "uh-salesforce.herokuapp.com")) {
            consumeIntentToFlutterPrefs = true;
        }
        if (consumeIntentToFlutterPrefs) {
            SessionPreferencesHelper.notifyReloadSharedPreferences();
        }
        super.onCreate(bundle);
    }

    @Override // io.flutter.embedding.android.FlutterFragmentActivity, c.m, android.app.Activity
    public final void onNewIntent(Intent intent) {
        boolean z3;
        j.e(intent, "intent");
        setIntent(intent);
        boolean z4 = true;
        if (PushEntityIntentHelper.consumeIntentToFlutterPrefs(this, intent)) {
            SessionPreferencesHelper.notifyReloadWebViewForPendingEntity();
            z3 = true;
        } else {
            z3 = false;
        }
        if (AppLinkIntentHelper.consumeIntentToFlutterPrefs(this, intent, "uh-salesforce.herokuapp.com")) {
            SessionPreferencesHelper.notifyReloadWebViewForPendingAppLink();
        } else {
            z4 = z3;
        }
        if (z4) {
            SessionPreferencesHelper.notifyReloadSharedPreferences();
        }
        super.onNewIntent(intent);
    }
}
