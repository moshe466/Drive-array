package com.pichillilorenzo.flutter_inappwebview_android.tracing;

import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import t0.d;
import t0.k;
import t0.l;
import t0.m;

/* loaded from: classes.dex */
public class TracingControllerManager implements Disposable {
    protected static final String LOG_TAG = "TracingControllerMan";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_tracingcontroller";
    public static m tracingController;
    public TracingControllerChannelDelegate channelDelegate;
    public InAppWebViewFlutterPlugin plugin;

    public TracingControllerManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        this.channelDelegate = new TracingControllerChannelDelegate(this, new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
    }

    public static k buildTracingConfig(TracingSettings tracingSettings) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : tracingSettings.categories) {
            if (obj instanceof String) {
                arrayList.addAll(Arrays.asList((String) obj));
            }
            if (obj instanceof Integer) {
                i3 |= new int[]{((Integer) obj).intValue()}[0];
            }
        }
        Integer num = tracingSettings.tracingMode;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 1;
        }
        return new k(arrayList, i3, i);
    }

    public static void init() {
        if (tracingController == null && d.a("TRACING_CONTROLLER_BASIC_USAGE")) {
            tracingController = l.f6377a;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        TracingControllerChannelDelegate tracingControllerChannelDelegate = this.channelDelegate;
        if (tracingControllerChannelDelegate != null) {
            tracingControllerChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.plugin = null;
    }
}
