package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.lifecycle.AbstractC0305o;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* loaded from: classes.dex */
public class FlutterLifecycleAdapter {
    public static AbstractC0305o getActivityLifecycle(ActivityPluginBinding activityPluginBinding) {
        return ((HiddenLifecycleReference) activityPluginBinding.getLifecycle()).getLifecycle();
    }
}
