package C0;

import android.content.Context;
import android.text.TextUtils;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import w0.C0752h;

/* loaded from: classes.dex */
public abstract class i {
    public static SidecarInterface a(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        return SidecarProvider.getSidecarImpl(context.getApplicationContext());
    }

    public static C0752h b() {
        try {
            String apiVersion = SidecarProvider.getApiVersion();
            if (!TextUtils.isEmpty(apiVersion)) {
                C0752h c0752h = C0752h.f6698f;
                return E1.b.t(apiVersion);
            }
            return null;
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return null;
        }
    }
}
