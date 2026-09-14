package b2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class e0 implements DialogInterface.OnClickListener {
    public static e0 b(Activity activity, Intent intent, int i10) {
        return new c0(intent, activity, i10);
    }

    public static e0 c(com.google.android.gms.common.api.internal.k kVar, Intent intent, int i10) {
        return new d0(intent, kVar, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        try {
            a();
        } catch (ActivityNotFoundException unused) {
            Build.FINGERPRINT.contains("generic");
        } finally {
            dialogInterface.dismiss();
        }
    }
}
