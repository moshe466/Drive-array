package E1;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* loaded from: classes.dex */
public final class i extends h {
    @Override // E1.h, F1.i
    public final void g(Bundle bundle) {
        super.g(bundle);
        int i = bundle.getInt("error.code", -2);
        TaskCompletionSource taskCompletionSource = this.f141b;
        if (i != 0) {
            taskCompletionSource.trySetException(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            taskCompletionSource.trySetResult(null);
        }
    }
}
