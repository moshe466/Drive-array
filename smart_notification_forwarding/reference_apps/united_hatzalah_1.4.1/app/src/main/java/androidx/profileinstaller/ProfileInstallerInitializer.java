package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.lifecycle.N;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import n0.InterfaceC0593b;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements InterfaceC0593b {
    @Override // n0.InterfaceC0593b
    public final Object a(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: i0.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                Handler handler;
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = Handler.createAsync(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                int nextInt = new Random().nextInt(Math.max(1000, 1));
                handler.postDelayed(new com.lt.plugin.lt_plugin.services.c(applicationContext, 2), nextInt + 5000);
            }
        });
        return new N(14);
    }

    @Override // n0.InterfaceC0593b
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
