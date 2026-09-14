package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;

/* loaded from: classes.dex */
public class PlayCoreDialogWrapperActivity extends Activity {
    private ResultReceiver a;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        ResultReceiver resultReceiver;
        int i3;
        Bundle bundle;
        super.onActivityResult(i, i2, intent);
        if (i == 0 && (resultReceiver = this.a) != null) {
            if (i2 == -1) {
                i3 = 1;
                bundle = new Bundle();
            } else if (i2 == 0) {
                i3 = 2;
                bundle = new Bundle();
            }
            resultReceiver.send(i3, bundle);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = (ResultReceiver) bundle.getParcelable("result_receiver");
            return;
        }
        this.a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
        try {
            startIntentSenderForResult(((PendingIntent) getIntent().getExtras().get("confirmation_intent")).getIntentSender(), 0, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException unused) {
            ResultReceiver resultReceiver = this.a;
            if (resultReceiver != null) {
                resultReceiver.send(3, new Bundle());
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.a);
    }
}
