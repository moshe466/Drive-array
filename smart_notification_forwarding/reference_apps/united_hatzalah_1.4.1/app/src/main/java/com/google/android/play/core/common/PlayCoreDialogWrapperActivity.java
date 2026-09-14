package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;

/* loaded from: classes.dex */
public class PlayCoreDialogWrapperActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public ResultReceiver f3888a;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i3, Intent intent) {
        ResultReceiver resultReceiver;
        super.onActivityResult(i, i3, intent);
        if (i == 0 && (resultReceiver = this.f3888a) != null) {
            if (i3 == -1) {
                resultReceiver.send(1, new Bundle());
            } else if (i3 == 0) {
                resultReceiver.send(2, new Bundle());
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Intent intent;
        PlayCoreDialogWrapperActivity playCoreDialogWrapperActivity;
        int intExtra = getIntent().getIntExtra("window_flags", 0);
        if (intExtra != 0) {
            getWindow().getDecorView().setSystemUiVisibility(intExtra);
            intent = new Intent();
            intent.putExtra("window_flags", intExtra);
        } else {
            intent = null;
        }
        Intent intent2 = intent;
        super.onCreate(bundle);
        if (bundle == null) {
            this.f3888a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                ResultReceiver resultReceiver = this.f3888a;
                if (resultReceiver != null) {
                    resultReceiver.send(3, new Bundle());
                }
                finish();
                return;
            }
            try {
                playCoreDialogWrapperActivity = this;
            } catch (IntentSender.SendIntentException unused) {
                playCoreDialogWrapperActivity = this;
            }
            try {
                playCoreDialogWrapperActivity.startIntentSenderForResult(((PendingIntent) extras.get("confirmation_intent")).getIntentSender(), 0, intent2, 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException unused2) {
                ResultReceiver resultReceiver2 = playCoreDialogWrapperActivity.f3888a;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(3, new Bundle());
                }
                finish();
                return;
            }
        }
        this.f3888a = (ResultReceiver) bundle.getParcelable("result_receiver");
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.f3888a);
    }
}
