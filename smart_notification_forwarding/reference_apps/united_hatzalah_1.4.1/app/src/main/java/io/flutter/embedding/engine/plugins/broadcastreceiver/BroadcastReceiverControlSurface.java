package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.lifecycle.AbstractC0305o;

/* loaded from: classes.dex */
public interface BroadcastReceiverControlSurface {
    void attachToBroadcastReceiver(BroadcastReceiver broadcastReceiver, AbstractC0305o abstractC0305o);

    void detachFromBroadcastReceiver();
}
