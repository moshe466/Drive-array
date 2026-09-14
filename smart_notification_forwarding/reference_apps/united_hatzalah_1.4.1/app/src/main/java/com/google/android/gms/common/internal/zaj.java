package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.G;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* loaded from: classes.dex */
public abstract class zaj implements DialogInterface.OnClickListener {
    public static zaj zab(Activity activity, Intent intent, int i) {
        return new zag(intent, activity, i);
    }

    public static zaj zac(G g3, Intent intent, int i) {
        return new zah(intent, g3, i);
    }

    public static zaj zad(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new zai(intent, lifecycleFragment, 2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                zaa();
            } catch (ActivityNotFoundException e4) {
                String str = "Failed to start resolution intent.";
                if (true == Build.FINGERPRINT.contains("generic")) {
                    str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
                }
                Log.e("DialogRedirect", str, e4);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void zaa();
}
