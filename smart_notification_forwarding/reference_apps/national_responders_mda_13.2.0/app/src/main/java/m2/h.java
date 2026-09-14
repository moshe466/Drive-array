package m2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public final class h extends androidx.core.content.a {
    @Deprecated
    public static Intent j(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (g.a()) {
            return context.registerReceiver(broadcastReceiver, intentFilter, true != g.a() ? 0 : 2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
