package com.lt.plugin.lt_plugin.services;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.lt.plugin.lt_plugin.R;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActiveDispatchAppWidget extends AppWidgetProvider {
    public static final String ACTION_NAVIGATE = "com.lt.plugin.lt_plugin.ACTIVE_DISPATCH_NAVIGATE";
    public static final String ACTION_REFRESH = "com.lt.plugin.lt_plugin.ACTIVE_DISPATCH_REFRESH";
    private static final float BODY_PX = 50.0f;
    private static final String EXTRA_LAT = "lat";
    private static final String EXTRA_LNG = "lng";
    private static final String KEY_PAYLOAD = "flutter.webview.activeDispatch";
    private static final String PREFS = "FlutterSharedPreferences";
    private static final float TITLE_PX = 42.0f;

    private static void applyAlsAccent(RemoteViews remoteViews, boolean z3) {
        int i;
        if (z3) {
            i = R.drawable.active_dispatch_nav_btn_red;
        } else {
            i = R.drawable.active_dispatch_nav_btn;
        }
        remoteViews.setImageViewResource(R.id.ad_accent, i);
        remoteViews.setInt(R.id.ad_refresh_active, "setBackgroundResource", i);
    }

    private static void applyPopupTextSizes(RemoteViews remoteViews) {
        remoteViews.setTextViewTextSize(R.id.ad_title, 0, TITLE_PX);
        remoteViews.setTextViewTextSize(R.id.ad_empty, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_refresh, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_refresh_active, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_1221, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_when, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_type, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_urgency, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_location, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_navigate, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_status, 0, BODY_PX);
        remoteViews.setTextViewTextSize(R.id.ad_referring, 0, BODY_PX);
    }

    private static void bindRefreshButtons(RemoteViews remoteViews, Context context, Class<?> cls, boolean z3) {
        String str;
        int i;
        boolean isRefreshing = ActiveDispatchRefresh.isRefreshing();
        if (isRefreshing) {
            str = "מרענן...";
        } else {
            str = "רענון";
        }
        remoteViews.setTextViewText(R.id.ad_refresh, str);
        remoteViews.setTextViewText(R.id.ad_refresh_active, str);
        remoteViews.setBoolean(R.id.ad_refresh, "setEnabled", !isRefreshing);
        remoteViews.setBoolean(R.id.ad_refresh_active, "setEnabled", !isRefreshing);
        Intent intent = new Intent(context, cls);
        intent.setAction(ACTION_REFRESH);
        if (z3) {
            i = 13;
        } else {
            i = 3;
        }
        PendingIntent pending = pending(context, i, intent);
        if (!isRefreshing) {
            remoteViews.setOnClickPendingIntent(R.id.ad_refresh, pending);
            remoteViews.setOnClickPendingIntent(R.id.ad_refresh_active, pending);
        }
    }

    private static RemoteViews buildCardViews(Context context, String str, boolean z3, Class<?> cls, int i) {
        int i3;
        int i4;
        String displayTitle;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i);
        List<JSONObject> parseItems = ActiveDispatchOverlayService.parseItems(str);
        bindRefreshButtons(remoteViews, context, cls, z3);
        if (!z3) {
            applyPopupTextSizes(remoteViews);
        }
        PendingIntent openAppPending = openAppPending(context);
        remoteViews.setOnClickPendingIntent(R.id.ad_widget_root, openAppPending);
        remoteViews.setOnClickPendingIntent(R.id.ad_empty_block, openAppPending);
        remoteViews.setOnClickPendingIntent(R.id.ad_empty, openAppPending);
        if (parseItems.isEmpty()) {
            remoteViews.setViewVisibility(R.id.ad_empty_block, 0);
            remoteViews.setViewVisibility(R.id.ad_content, 8);
            return remoteViews;
        }
        JSONObject jSONObject = parseItems.get(0);
        String displayTitle2 = ActiveDispatchOverlayService.displayTitle(jSONObject);
        String displayLocation = ActiveDispatchOverlayService.displayLocation(jSONObject);
        boolean optBoolean = jSONObject.optBoolean("call1221__c");
        remoteViews.setViewVisibility(R.id.ad_empty_block, 8);
        remoteViews.setViewVisibility(R.id.ad_content, 0);
        remoteViews.setTextViewText(R.id.ad_type, displayTitle2);
        remoteViews.setTextViewText(R.id.ad_location, displayLocation);
        int i13 = R.id.ad_location;
        if (TextUtils.isEmpty(displayLocation)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        remoteViews.setViewVisibility(i13, i3);
        remoteViews.setOnClickPendingIntent(R.id.ad_content, openAppPending);
        remoteViews.setOnClickPendingIntent(R.id.ad_body, openAppPending);
        remoteViews.setOnClickPendingIntent(R.id.ad_type, openAppPending);
        remoteViews.setOnClickPendingIntent(R.id.ad_location, openAppPending);
        if (z3) {
            String floatingWhen = ActiveDispatchOverlayService.floatingWhen(jSONObject);
            String floatingUrgency = ActiveDispatchOverlayService.floatingUrgency(jSONObject);
            String floatingReferring = ActiveDispatchOverlayService.floatingReferring(jSONObject);
            int i14 = R.id.ad_1221;
            if (optBoolean) {
                i9 = 0;
            } else {
                i9 = 8;
            }
            remoteViews.setViewVisibility(i14, i9);
            remoteViews.setTextViewText(R.id.ad_when, floatingWhen);
            int i15 = R.id.ad_when;
            if (TextUtils.isEmpty(floatingWhen)) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            remoteViews.setViewVisibility(i15, i10);
            remoteViews.setTextViewText(R.id.ad_urgency, floatingUrgency);
            int i16 = R.id.ad_urgency;
            if (TextUtils.isEmpty(floatingUrgency)) {
                i11 = 8;
            } else {
                i11 = 0;
            }
            remoteViews.setViewVisibility(i16, i11);
            remoteViews.setTextViewText(R.id.ad_referring, floatingReferring);
            int i17 = R.id.ad_referring;
            if (TextUtils.isEmpty(floatingReferring)) {
                i12 = 8;
            } else {
                i12 = 0;
            }
            remoteViews.setViewVisibility(i17, i12);
            remoteViews.setOnClickPendingIntent(R.id.ad_urgency, openAppPending);
            remoteViews.setOnClickPendingIntent(R.id.ad_referring, openAppPending);
        } else {
            int i18 = R.id.ad_1221;
            if (optBoolean) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            remoteViews.setViewVisibility(i18, i4);
            if (parseItems.size() > 1) {
                displayTitle = "הזנקות פעילות (" + parseItems.size() + ")";
            } else {
                displayTitle = ActiveDispatchOverlayService.displayTitle(jSONObject);
            }
            String floatingWhen2 = ActiveDispatchOverlayService.floatingWhen(jSONObject);
            String str2 = "דחיפות: " + ActiveDispatchOverlayService.floatingUrgency(jSONObject);
            String floatingReferring2 = ActiveDispatchOverlayService.floatingReferring(jSONObject);
            String floatingStatus = ActiveDispatchOverlayService.floatingStatus(jSONObject);
            remoteViews.setTextViewText(R.id.ad_title, displayTitle);
            remoteViews.setTextViewText(R.id.ad_when, floatingWhen2);
            int i19 = R.id.ad_when;
            if (TextUtils.isEmpty(floatingWhen2)) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            remoteViews.setViewVisibility(i19, i5);
            remoteViews.setTextViewText(R.id.ad_urgency, str2);
            remoteViews.setTextViewText(R.id.ad_status, floatingStatus);
            int i20 = R.id.ad_status;
            if (TextUtils.isEmpty(floatingStatus)) {
                i6 = 8;
            } else {
                i6 = 0;
            }
            remoteViews.setViewVisibility(i20, i6);
            remoteViews.setTextViewText(R.id.ad_referring, floatingReferring2);
            int i21 = R.id.ad_referring;
            if (TextUtils.isEmpty(floatingReferring2)) {
                i7 = 8;
            } else {
                i7 = 0;
            }
            remoteViews.setViewVisibility(i21, i7);
            remoteViews.setOnClickPendingIntent(R.id.ad_title, openAppPending);
            remoteViews.setOnClickPendingIntent(R.id.ad_urgency, openAppPending);
            remoteViews.setOnClickPendingIntent(R.id.ad_referring, openAppPending);
            remoteViews.setOnClickPendingIntent(R.id.ad_status, openAppPending);
        }
        double optDouble = jSONObject.optDouble("LongtitudeLatitude__Latitude__s", Double.NaN);
        double optDouble2 = jSONObject.optDouble("LongtitudeLatitude__Longitude__s", Double.NaN);
        if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2)) {
            remoteViews.setViewVisibility(R.id.ad_navigate, 0);
            Intent intent = new Intent(context, cls);
            intent.setAction(ACTION_NAVIGATE);
            intent.setData(Uri.parse("adnav:" + optDouble + "," + optDouble2));
            intent.putExtra(EXTRA_LAT, optDouble);
            intent.putExtra(EXTRA_LNG, optDouble2);
            int i22 = R.id.ad_navigate;
            if (z3) {
                i8 = 12;
            } else {
                i8 = 2;
            }
            remoteViews.setOnClickPendingIntent(i22, pending(context, i8, intent));
        } else {
            remoteViews.setViewVisibility(R.id.ad_navigate, 8);
        }
        applyAlsAccent(remoteViews, ActiveDispatchOverlayService.isAls(jSONObject));
        return remoteViews;
    }

    private static RemoteViews buildViews(Context context, String str, boolean z3, Class<?> cls) {
        int i;
        if (z3) {
            i = R.layout.active_dispatch_widget_small;
        } else {
            i = R.layout.active_dispatch_widget;
        }
        try {
            return buildCardViews(context, str, z3, cls, i);
        } catch (Exception unused) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i);
            remoteViews.setViewVisibility(R.id.ad_empty_block, 0);
            remoteViews.setViewVisibility(R.id.ad_content, 8);
            remoteViews.setTextViewText(R.id.ad_empty, "אין הזנקה פעילה");
            return remoteViews;
        }
    }

    private static PendingIntent openAppPending(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent("android.intent.action.MAIN");
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            launchIntentForPackage.setPackage(context.getPackageName());
        }
        launchIntentForPackage.addFlags(805437440);
        return pending(context, 1, launchIntentForPackage);
    }

    private static void openNavigate(Context context, double d2, double d4) {
        if (!Double.isNaN(d2) && !Double.isNaN(d4)) {
            try {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("waze://?ll=" + d2 + "," + d4 + "&navigate=yes"));
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                } catch (Exception unused) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + d2 + "," + d4 + "?q=" + d2 + "," + d4));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                }
            } catch (Exception unused2) {
            }
        }
    }

    private static PendingIntent pending(Context context, int i, Intent intent) {
        String action = intent.getAction();
        if (!ACTION_NAVIGATE.equals(action) && !ACTION_REFRESH.equals(action)) {
            return PendingIntent.getActivity(context, i, intent, 201326592);
        }
        return PendingIntent.getBroadcast(context, i, intent, 201326592);
    }

    public static void refresh(Context context, String str) {
        if (str == null) {
            str = context.getSharedPreferences("FlutterSharedPreferences", 0).getString(KEY_PAYLOAD, null);
        }
        updateProvider(context, str, ActiveDispatchAppWidget.class, false);
        updateProvider(context, str, ActiveDispatchAppWidgetSmall.class, true);
    }

    private static void updateProvider(Context context, String str, Class<?> cls, boolean z3) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, cls));
        if (appWidgetIds != null && appWidgetIds.length != 0) {
            RemoteViews buildViews = buildViews(context, str, z3, cls);
            for (int i : appWidgetIds) {
                appWidgetManager.updateAppWidget(i, buildViews);
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && ACTION_NAVIGATE.equals(intent.getAction())) {
            openNavigate(context, intent.getDoubleExtra(EXTRA_LAT, Double.NaN), intent.getDoubleExtra(EXTRA_LNG, Double.NaN));
        } else if (intent != null && ACTION_REFRESH.equals(intent.getAction())) {
            ActiveDispatchRefresh.start(context);
        } else {
            super.onReceive(context, intent);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        Class cls;
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSharedPreferences", 0);
        boolean z3 = this instanceof ActiveDispatchAppWidgetSmall;
        if (z3) {
            cls = ActiveDispatchAppWidgetSmall.class;
        } else {
            cls = ActiveDispatchAppWidget.class;
        }
        RemoteViews buildViews = buildViews(context, sharedPreferences.getString(KEY_PAYLOAD, null), z3, cls);
        for (int i : iArr) {
            appWidgetManager.updateAppWidget(i, buildViews);
        }
    }
}
