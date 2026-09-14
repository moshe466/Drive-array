package com.lt.plugin.lt_plugin.utils;

import android.content.Context;
import android.content.Intent;
import com.lt.plugin.lt_plugin.services.ActiveDispatchAppWidget;
import com.lt.plugin.lt_plugin.services.ActiveDispatchOverlayService;
import com.lt.plugin.lt_plugin.services.BackgroundService;
import com.lt.plugin.lt_plugin.services.FloatingWindowService;
import com.lt.plugin.lt_plugin.services.LocationService;

/* loaded from: classes.dex */
public final class PluginServicesHelper {
    private PluginServicesHelper() {
    }

    public static void stopAllSessionRelatedServices(Context context) {
        Context applicationContext = context.getApplicationContext();
        applicationContext.stopService(new Intent(applicationContext, (Class<?>) LocationService.class));
        applicationContext.stopService(new Intent(applicationContext, (Class<?>) FloatingWindowService.class));
        applicationContext.stopService(new Intent(applicationContext, (Class<?>) BackgroundService.class));
        ActiveDispatchOverlayService.hide(applicationContext);
        ActiveDispatchAppWidget.refresh(applicationContext, "");
    }
}
