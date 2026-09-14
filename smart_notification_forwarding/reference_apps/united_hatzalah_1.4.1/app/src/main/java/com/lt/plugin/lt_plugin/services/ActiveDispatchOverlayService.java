package com.lt.plugin.lt_plugin.services;

import F0.AbstractC0008a;
import F0.Q2;
import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.lt.plugin.lt_plugin.PushActionHelper;
import java.lang.Character;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import w.n;

/* loaded from: classes.dex */
public class ActiveDispatchOverlayService extends Service {
    static final int ALS_RED = -587768;
    private static final int BUBBLE_DP = 56;
    private static final String CHANNEL_ID = "ActiveDispatchOverlayChannel";
    private static final String EXTRA_PAYLOAD = "payload";
    private static final String EXTRA_SHOW_OVERLAY = "showOverlay";
    private static final String EXTRA_STOP = "stop";
    private static final String KEY_BUBBLE = "flutter.webview.activeDispatchBubble";
    private static final String KEY_DISMISSED = "flutter.webview.activeDispatchOverlayDismissed";
    private static final String KEY_PAYLOAD = "flutter.webview.activeDispatch";
    static final int NOTIFICATION_ID = 41;
    private static final int ORANGE = -36352;
    private static final String PREFS = "FlutterSharedPreferences";
    private static final String TAG = "ActiveDispatchOverlay";
    private static volatile boolean sCreated;
    private static volatile boolean sForegroundStarted;
    private static volatile boolean sPopupFromOverlay;
    private boolean dragged;
    private float lastX;
    private float lastY;
    private boolean overTrash;
    private WindowManager.LayoutParams overlayParams;
    private View overlayRoot;
    private boolean panelOpen;
    private View trashCircle;
    private View trashDock;
    private TextView trashLabel;
    private WindowManager windowManager;
    private boolean showOverlay = true;
    private int bubbleX = Integer.MIN_VALUE;
    private int bubbleY = Integer.MIN_VALUE;
    private final List<JSONObject> items = new ArrayList();

    private void addLine(LinearLayout linearLayout, String str, boolean z3) {
        float f4;
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextColor(-14540254);
        if (z3) {
            f4 = 16.0f;
        } else {
            f4 = 14.0f;
        }
        textView.setTextSize(2, f4);
        if (z3) {
            textView.setTypeface(textView.getTypeface(), 1);
        }
        textView.setPadding(0, dp(2), 0, dp(2));
        linearLayout.addView(textView);
    }

    private void attachOverlay(View view) {
        removeOverlay();
        this.overlayRoot = view;
        WindowManager.LayoutParams buildParams = buildParams(view);
        this.overlayParams = buildParams;
        try {
            this.windowManager.addView(this.overlayRoot, buildParams);
        } catch (Exception e4) {
            Log.e(TAG, "addView failed", e4);
            stopSelfSafely();
        }
    }

    private View buildBubbleView() {
        int i;
        int dp = dp(BUBBLE_DP);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(0);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(dp, dp));
        ImageView imageView = new ImageView(this);
        int identifier = getResources().getIdentifier("ic_active_dispatch_bell", "drawable", getPackageName());
        if (identifier != 0) {
            imageView.setImageResource(identifier);
        } else {
            imageView.setImageResource(R.drawable.ic_popup_reminder);
            imageView.setColorFilter(-1);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(dp(12), dp(12), dp(12), dp(12));
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (!this.items.isEmpty() && isAls(this.items.get(0))) {
            i = ALS_RED;
        } else {
            i = ORANGE;
        }
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(1);
        gradientDrawable.setSize(dp, dp);
        imageView.setBackground(gradientDrawable);
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(dp, dp));
        if (this.items.size() > 1) {
            TextView textView = new TextView(this);
            textView.setText(String.valueOf(this.items.size()));
            textView.setTextColor(-1);
            textView.setTextSize(2, 11.0f);
            textView.setGravity(17);
            textView.setIncludeFontPadding(false);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(-1754827);
            gradientDrawable2.setShape(1);
            textView.setBackground(gradientDrawable2);
            int dp2 = dp(18);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2, dp2);
            layoutParams.gravity = 8388661;
            frameLayout.addView(textView, layoutParams);
        }
        enableDrag(imageView, true);
        return frameLayout;
    }

    private static String buildIncidentBodyLayout(JSONObject jSONObject) {
        String str;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("v", 1);
            jSONObject2.put("d", "ltr");
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            if (jSONObject.optBoolean("call1221__c")) {
                jSONArray2.put(layoutCell("1221", 50, "left", "ltr", null, null, null, null));
            }
            String floatingWhen = floatingWhen(jSONObject);
            if (!TextUtils.isEmpty(floatingWhen)) {
                jSONArray2.put(layoutCell(floatingWhen, 50, "right", "ltr", null, null, null, null));
            }
            if (jSONArray2.length() > 0) {
                jSONArray.put(layoutRow(jSONArray2, "ltr", null));
            }
            JSONArray jSONArray3 = new JSONArray();
            String firstReadable = firstReadable(jSONObject.optString("typeevent__c", ""), jSONObject.optString("typeevent", ""));
            if (!TextUtils.isEmpty(firstReadable)) {
                jSONArray3.put(layoutCell("<b>" + firstReadable + "</b>", 50, "left", "rtl", null, null, null, null));
            }
            String floatingUrgency = floatingUrgency(jSONObject);
            if (!TextUtils.isEmpty(floatingUrgency)) {
                jSONArray3.put(layoutCell("דחיפות: <b>" + floatingUrgency + "</b>", 50, "right", "rtl", null, null, null, null));
            }
            if (jSONArray3.length() > 0) {
                jSONArray.put(layoutRow(jSONArray3, "ltr", null));
            }
            String displayLocation = displayLocation(jSONObject);
            if (!TextUtils.isEmpty(displayLocation)) {
                JSONArray jSONArray4 = new JSONArray();
                jSONArray4.put(layoutCell(displayLocation, 50, "right", "rtl", null, null, null, null));
                jSONArray.put(layoutRow(jSONArray4, null, "#FFE8D6"));
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(layoutCell("לניווט בוויז", 50, "center", "rtl", "navigate", "#b3bfd9", "#FFFFFF", 0));
            String floatingStatus = floatingStatus(jSONObject);
            if (!TextUtils.isEmpty(floatingStatus)) {
                jSONArray5.put(layoutCell(floatingStatus, 50, "center", "rtl", null, null, null, null));
            }
            jSONArray.put(layoutRow(jSONArray5, "ltr", null));
            String floatingReferring = floatingReferring(jSONObject);
            if (!TextUtils.isEmpty(floatingReferring)) {
                JSONArray jSONArray6 = new JSONArray();
                jSONArray6.put(layoutCell(floatingReferring, 50, "right", "rtl", null, null, null, null));
                jSONArray.put(layoutRow(jSONArray6, null, null));
            }
            JSONArray jSONArray7 = new JSONArray();
            if (isAls(jSONObject)) {
                str = "#F70808";
            } else {
                str = "#FF7200";
            }
            jSONArray7.put(layoutCell("סגירה", 50, "center", "rtl", "close", str, "#FFFFFF", null));
            jSONArray.put(layoutRow(jSONArray7, null, null));
            jSONObject2.put("rows", jSONArray);
            return jSONObject2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private View buildItemBlock(JSONObject jSONObject, boolean z3) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, dp(8), 0, dp(8));
        if (z3) {
            addLine(linearLayout, displayTitle(jSONObject), true);
        }
        String displayLocation = displayLocation(jSONObject);
        if (!TextUtils.isEmpty(displayLocation)) {
            addLine(linearLayout, displayLocation, false);
        }
        String join = join(" · ", statusLabel(jSONObject.optString("StatusLogis__c", "")), jSONObject.optString("time", ""));
        if (!TextUtils.isEmpty(join)) {
            addLine(linearLayout, join, false);
        }
        return linearLayout;
    }

    private Notification buildNotification() {
        String str;
        String str2;
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
        }
        launchIntentForPackage.addFlags(805306368);
        PendingIntent activity = PendingIntent.getActivity(this, 0, launchIntentForPackage, 201326592);
        if (!this.items.isEmpty()) {
            if (this.items.size() > 1) {
                str = "הזנקות פעילות";
            } else {
                str = displayTitle(this.items.get(0));
            }
            str2 = displayLocation(this.items.get(0));
        } else {
            str = "הזנקה פעילה";
            str2 = "";
        }
        n nVar = new n(this, CHANNEL_ID);
        nVar.f6651e = n.b(str);
        nVar.f6652f = n.b(str2);
        nVar.f6666v.icon = R.drawable.ic_dialog_info;
        nVar.f6653g = activity;
        nVar.d(2, true);
        nVar.f6667w = true;
        nVar.f6655j = -1;
        return nVar.a();
    }

    private View buildPanelView() {
        String displayTitle;
        int i;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutDirection(1);
        linearLayout.setPadding(dp(14), dp(12), dp(14), dp(12));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(dp(14));
        gradientDrawable.setStroke(dp(1), 570425344);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setElevation(dp(8));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(this);
        if (this.items.size() > 1) {
            displayTitle = "הזנקות פעילות";
        } else {
            displayTitle = displayTitle(this.items.get(0));
        }
        textView.setText(displayTitle);
        if (!this.items.isEmpty() && isAls(this.items.get(0))) {
            i = ALS_RED;
        } else {
            i = ORANGE;
        }
        textView.setTextColor(i);
        textView.setTextSize(2, 18.0f);
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(textView);
        TextView circleButton = circleButton("×", 285212672, -13421773, 16);
        circleButton.setOnClickListener(new f(this, 3));
        linearLayout2.addView(circleButton);
        linearLayout.addView(linearLayout2);
        int min = Math.min(this.items.size(), 4);
        for (int i3 = 0; i3 < min; i3++) {
            linearLayout.addView(divider());
            JSONObject jSONObject = this.items.get(i3);
            View buildItemBlock = buildItemBlock(jSONObject, true);
            buildItemBlock.setOnClickListener(new g(this, jSONObject, 2));
            linearLayout.addView(buildItemBlock);
        }
        return linearLayout;
    }

    private WindowManager.LayoutParams buildParams(View view) {
        int i;
        int i3;
        if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        } else {
            i = 2002;
        }
        int i4 = i;
        ensureBubblePos(getResources().getDisplayMetrics());
        if (this.panelOpen) {
            i3 = (int) (r7.widthPixels * 0.92f);
        } else {
            i3 = -2;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i3, -2, i4, 8232, -3);
        if (this.panelOpen) {
            layoutParams.gravity = 81;
            layoutParams.x = 0;
            layoutParams.y = dp(96);
            return layoutParams;
        }
        layoutParams.gravity = 51;
        layoutParams.x = this.bubbleX;
        layoutParams.y = this.bubbleY;
        return layoutParams;
    }

    private TextView circleButton(String str, int i, int i3, int i4) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextColor(i3);
        textView.setTextSize(2, i4);
        textView.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(1);
        textView.setBackground(gradientDrawable);
        textView.setMinWidth(dp(22));
        textView.setMinHeight(dp(22));
        return textView;
    }

    private void createChannel() {
        NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT < 26 || (notificationManager = (NotificationManager) getSystemService("notification")) == null) {
            return;
        }
        NotificationChannel d2 = a.d();
        d2.setShowBadge(false);
        d2.setSound(null, null);
        notificationManager.createNotificationChannel(d2);
    }

    private void dismissForSession() {
        hideTrashDock();
        getSharedPreferences("FlutterSharedPreferences", 0).edit().putBoolean(KEY_DISMISSED, true).apply();
        stopSelfSafely();
    }

    private static void dismissOverlayPopup(Context context) {
        if (sPopupFromOverlay) {
            sPopupFromOverlay = false;
            FloatingWindowService.onClosed = null;
            try {
                context.stopService(new Intent(context, (Class<?>) FloatingWindowService.class));
            } catch (Exception unused) {
            }
        }
    }

    public static String displayLocation(JSONObject jSONObject) {
        return firstReadable(jSONObject.optString("orignal_incident_location__c", ""), jSONObject.optString("referringAddress", ""), jSONObject.optString("polygonName", ""), jSONObject.optString("incident_location__c", ""));
    }

    public static String displayTitle(JSONObject jSONObject) {
        String firstReadable = firstReadable(jSONObject.optString("typeevent__c", ""), jSONObject.optString("typeevent", ""));
        if (!TextUtils.isEmpty(firstReadable)) {
            return firstReadable;
        }
        String optString = jSONObject.optString("statusevent__c", "");
        if (isReadable(optString)) {
            return optString;
        }
        return "הזנקה פעילה";
    }

    private View divider() {
        View view = new View(this);
        view.setBackgroundColor(570425344);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(1)));
        return view;
    }

    private int dp(int i) {
        return Math.round(i * getResources().getDisplayMetrics().density);
    }

    private void enableDrag(View view, final boolean z3) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.lt.plugin.lt_plugin.services.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean lambda$enableDrag$2;
                lambda$enableDrag$2 = ActiveDispatchOverlayService.this.lambda$enableDrag$2(z3, view2, motionEvent);
                return lambda$enableDrag$2;
            }
        });
    }

    private void ensureBubblePos(DisplayMetrics displayMetrics) {
        int dp = dp(BUBBLE_DP);
        if (this.bubbleX != Integer.MIN_VALUE && this.bubbleY != Integer.MIN_VALUE) {
            return;
        }
        this.bubbleX = Math.max(dp(8), (displayMetrics.widthPixels - dp) - dp(16));
        this.bubbleY = Math.max(dp(8), (displayMetrics.heightPixels - dp) / 2);
    }

    private static String firstReadable(String... strArr) {
        for (String str : strArr) {
            if (isReadable(str)) {
                return str;
            }
        }
        return "";
    }

    public static String floatingDate(JSONObject jSONObject) {
        String trim = jSONObject.optString("onlyDate", "").trim();
        if (!TextUtils.isEmpty(trim)) {
            return trim;
        }
        for (String str : floatingWhen(jSONObject).split("\\s+")) {
            if (str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                return str;
            }
        }
        return "";
    }

    public static String floatingReferring(JSONObject jSONObject) {
        Object opt;
        if (jSONObject == null || jSONObject.isNull("referringAddress") || (opt = jSONObject.opt("referringAddress")) == null) {
            return "";
        }
        String trim = String.valueOf(opt).trim();
        if (!trim.isEmpty() && !"null".equalsIgnoreCase(trim)) {
            if (trim.startsWith("הכוונה")) {
                return trim;
            }
            return "הכוונה לכתובת: ".concat(trim);
        }
        return "";
    }

    public static String floatingStatus(JSONObject jSONObject) {
        String trim = jSONObject.optString("StatusLogis__c", "").trim();
        trim.getClass();
        char c4 = 65535;
        switch (trim.hashCode()) {
            case -776859390:
                if (trim.equals("ReadyForDispatching")) {
                    c4 = 0;
                    break;
                }
                break;
            case 41602816:
                if (trim.equals("EnRoute")) {
                    c4 = 1;
                    break;
                }
                break;
            case 958880761:
                if (trim.equals("AtScene")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "מאתר כוננים";
            case 1:
                return "כונן בדרך";
            case 2:
                return "כונן במקום";
            default:
                return trim;
        }
    }

    public static String floatingTime(JSONObject jSONObject) {
        String trim = jSONObject.optString("time", "").trim();
        if (!TextUtils.isEmpty(trim)) {
            return trim;
        }
        for (String str : floatingWhen(jSONObject).split("\\s+")) {
            if (str.contains(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER) && !str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                return str;
            }
        }
        return "";
    }

    public static String floatingUrgency(JSONObject jSONObject) {
        if (isAls(jSONObject)) {
            return "נטן";
        }
        return "לבן";
    }

    public static String floatingWhen(JSONObject jSONObject) {
        String trim = jSONObject.optString("time", "").trim();
        String trim2 = jSONObject.optString("onlyDate", "").trim();
        if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2)) {
            return AbstractC0008a.o(trim2, StringUtils.SPACE, trim);
        }
        if (!TextUtils.isEmpty(trim)) {
            return trim;
        }
        String trim3 = jSONObject.optString("openmissiontime__c", "").trim();
        if (TextUtils.isEmpty(trim3) || "null".equals(trim3)) {
            return "";
        }
        String[] split = trim3.split("\\s+");
        if (split.length >= 2) {
            String str = split[0];
            int indexOf = str.indexOf(58, str.indexOf(58) + 1);
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
            }
            return AbstractC0008a.v(new StringBuilder(), split[1], StringUtils.SPACE, str);
        }
        return trim3;
    }

    private static boolean hasCoords(JSONObject jSONObject) {
        if (jSONObject.has("LongtitudeLatitude__Latitude__s") && jSONObject.has("LongtitudeLatitude__Longitude__s") && !jSONObject.isNull("LongtitudeLatitude__Latitude__s") && !jSONObject.isNull("LongtitudeLatitude__Longitude__s")) {
            return true;
        }
        return false;
    }

    private boolean hasOverlayPermission() {
        if (Settings.canDrawOverlays(this)) {
            return true;
        }
        return false;
    }

    public static void hide(Context context) {
        dismissOverlayPopup(context);
        context.getSharedPreferences("FlutterSharedPreferences", 0).edit().remove(KEY_DISMISSED).apply();
        if (!sCreated) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ActiveDispatchOverlayService.class);
        intent.putExtra(EXTRA_STOP, true);
        start(context, intent);
    }

    private void hideTrashDock() {
        WindowManager windowManager;
        this.overTrash = false;
        View view = this.trashDock;
        if (view != null && (windowManager = this.windowManager) != null) {
            try {
                windowManager.removeView(view);
            } catch (Exception unused) {
            }
        }
        this.trashDock = null;
        this.trashCircle = null;
        this.trashLabel = null;
    }

    public static Intent incidentIntent(JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.putExtra("title", displayTitle(jSONObject));
        String buildIncidentBodyLayout = buildIncidentBodyLayout(jSONObject);
        if (!TextUtils.isEmpty(buildIncidentBodyLayout)) {
            intent.putExtra("body_layout", buildIncidentBodyLayout);
        } else {
            intent.putExtra("body", displayLocation(jSONObject));
        }
        if (hasCoords(jSONObject)) {
            PushActionHelper.putNavExtras(intent, "true", String.valueOf(jSONObject.optDouble("LongtitudeLatitude__Latitude__s")), String.valueOf(jSONObject.optDouble("LongtitudeLatitude__Longitude__s")));
        }
        return intent;
    }

    public static boolean isAls(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("ResponsePlanId__c", "");
        if (!"RPALS".equals(optString) && !"RPALS+AMB".equals(optString)) {
            return false;
        }
        return true;
    }

    public static boolean isBubbleEnabled(Context context) {
        String string = context.getSharedPreferences("FlutterSharedPreferences", 0).getString(KEY_BUBBLE, null);
        if (string != null && "false".equals(string)) {
            return false;
        }
        return true;
    }

    private boolean isOverTrash(float f4, float f5) {
        float f6 = r0.widthPixels / 2.0f;
        int i = 72;
        float dp = getResources().getDisplayMetrics().heightPixels - dp(72);
        if (!this.overTrash) {
            i = BUBBLE_DP;
        }
        if (Math.hypot(f4 - f6, f5 - dp) < dp(i)) {
            return true;
        }
        return false;
    }

    private static boolean isReadable(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (!trim.isEmpty() && !"null".equals(trim)) {
            for (int i = 0; i < trim.length(); i++) {
                char charAt = trim.charAt(i);
                if (Character.isLetter(charAt) && Character.UnicodeBlock.of(charAt) == Character.UnicodeBlock.HEBREW) {
                    return true;
                }
            }
            if (trim.length() < 48 && trim.matches("[\\p{L}\\p{N}\\s,./\\-]+")) {
                return true;
            }
        }
        return false;
    }

    private static String join(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append(str);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public /* synthetic */ void lambda$buildPanelView$0(View view) {
        showBubble();
    }

    public /* synthetic */ void lambda$buildPanelView$1(JSONObject jSONObject, View view) {
        openIncidentWindow(jSONObject);
    }

    public /* synthetic */ boolean lambda$enableDrag$2(boolean z3, View view, MotionEvent motionEvent) {
        boolean z4;
        WindowManager.LayoutParams layoutParams;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else {
                    if (Math.hypot(motionEvent.getRawX() - this.lastX, motionEvent.getRawY() - this.lastY) > dp(8)) {
                        this.dragged = true;
                    }
                    if (this.dragged && (layoutParams = this.overlayParams) != null && this.overlayRoot != null && !this.panelOpen) {
                        layoutParams.x = Math.round(motionEvent.getRawX() - this.lastX) + layoutParams.x;
                        WindowManager.LayoutParams layoutParams2 = this.overlayParams;
                        layoutParams2.y = Math.round(motionEvent.getRawY() - this.lastY) + layoutParams2.y;
                        this.lastX = motionEvent.getRawX();
                        this.lastY = motionEvent.getRawY();
                        WindowManager.LayoutParams layoutParams3 = this.overlayParams;
                        this.bubbleX = layoutParams3.x;
                        this.bubbleY = layoutParams3.y;
                        try {
                            this.windowManager.updateViewLayout(this.overlayRoot, layoutParams3);
                        } catch (Exception unused) {
                        }
                        showTrashDock();
                        setTrashArmed(isOverTrash(motionEvent.getRawX(), motionEvent.getRawY()));
                    }
                    return true;
                }
            }
            if (z3 && this.dragged && this.overTrash) {
                z4 = true;
            } else {
                z4 = false;
            }
            hideTrashDock();
            if (z4) {
                dismissForSession();
                return true;
            }
            if (!this.dragged && z3) {
                if (this.items.size() == 1) {
                    openIncidentWindow(this.items.get(0));
                } else {
                    showPanel();
                }
            }
            return true;
        }
        this.dragged = false;
        this.lastX = motionEvent.getRawX();
        this.lastY = motionEvent.getRawY();
        return true;
    }

    private static JSONObject layoutCell(String str, int i, String str2, String str3, String str4, String str5, String str6, Integer num) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", str);
        jSONObject.put("s", i);
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("a", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("d", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("x", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            jSONObject.put("bg", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            jSONObject.put("c", str6);
        }
        if (num != null) {
            jSONObject.put("r", num);
        }
        return jSONObject;
    }

    private static JSONObject layoutRow(JSONArray jSONArray, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cells", jSONArray);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("d", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("bg", str2);
        }
        return jSONObject;
    }

    private void openIncidentWindow(JSONObject jSONObject) {
        if (jSONObject != null) {
            ensureBubblePos(getResources().getDisplayMetrics());
            sPopupFromOverlay = true;
            FloatingWindowService.onClosed = new Q2(this, 6);
            this.panelOpen = false;
            removeOverlay();
            if (!showIncidentCard(this, jSONObject, this.bubbleX, this.bubbleY, dp(BUBBLE_DP))) {
                sPopupFromOverlay = false;
                FloatingWindowService.onClosed = null;
                showBubble();
            }
        }
    }

    private void openNavigate(JSONObject jSONObject) {
        double optDouble = jSONObject.optDouble("LongtitudeLatitude__Latitude__s", Double.NaN);
        double optDouble2 = jSONObject.optDouble("LongtitudeLatitude__Longitude__s", Double.NaN);
        if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("waze://?ll=" + optDouble + "," + optDouble2 + "&navigate=yes"));
            intent.addFlags(268435456);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return;
            }
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + optDouble + "," + optDouble2));
                intent2.addFlags(268435456);
                if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                    return;
                }
            } catch (Exception unused) {
            }
            try {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + optDouble + "," + optDouble2 + "?q=" + optDouble + "," + optDouble2));
                intent3.addFlags(268435456);
                startActivity(intent3);
            } catch (Exception unused2) {
            }
        }
    }

    public static List<JSONObject> parseItems(String str) {
        Object jSONObject;
        JSONArray put;
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.trim().isEmpty()) {
            try {
                if (str.trim().startsWith("[")) {
                    jSONObject = new JSONArray(str);
                } else {
                    jSONObject = new JSONObject(str);
                }
                if (jSONObject instanceof JSONArray) {
                    put = (JSONArray) jSONObject;
                } else {
                    JSONObject jSONObject2 = (JSONObject) jSONObject;
                    if (!jSONObject2.isNull("activeLaunch")) {
                        Object opt = jSONObject2.opt("activeLaunch");
                        if (opt instanceof JSONArray) {
                            put = (JSONArray) opt;
                        } else if (opt instanceof JSONObject) {
                            put = new JSONArray().put(opt);
                        }
                    }
                }
                for (int i = 0; i < put.length(); i++) {
                    JSONObject optJSONObject = put.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(optJSONObject);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private void removeOverlay() {
        WindowManager windowManager;
        View view = this.overlayRoot;
        if (view != null && (windowManager = this.windowManager) != null) {
            try {
                windowManager.removeView(view);
            } catch (Exception unused) {
            }
        }
        this.overlayRoot = null;
    }

    public void restoreBubbleIfNeeded() {
        sPopupFromOverlay = false;
        if (this.showOverlay && !getSharedPreferences("FlutterSharedPreferences", 0).getBoolean(KEY_DISMISSED, false) && !this.items.isEmpty()) {
            showBubble();
        }
    }

    public static void setOverlayVisible(Context context, boolean z3) {
        if (!z3) {
            dismissOverlayPopup(context);
        }
        if (z3 || sCreated) {
            if (z3 && !isBubbleEnabled(context)) {
                z3 = false;
            }
            if (z3 && context.getSharedPreferences("FlutterSharedPreferences", 0).getBoolean(KEY_DISMISSED, false)) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) ActiveDispatchOverlayService.class);
            intent.putExtra(EXTRA_SHOW_OVERLAY, z3);
            start(context, intent);
        }
    }

    private void setTrashArmed(boolean z3) {
        String str;
        int i;
        if (this.overTrash != z3) {
            this.overTrash = z3;
            if (this.trashCircle != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                if (z3) {
                    i = -1754827;
                } else {
                    i = -12303292;
                }
                gradientDrawable.setColor(i);
                this.trashCircle.setBackground(gradientDrawable);
            }
            TextView textView = this.trashLabel;
            if (textView != null) {
                if (z3) {
                    str = "שחרר להסרה";
                } else {
                    str = "הסר";
                }
                textView.setText(str);
            }
        }
    }

    public static void show(Context context, String str) {
        show(context, str, true);
    }

    private void showBubble() {
        this.panelOpen = false;
        attachOverlay(buildBubbleView());
    }

    public static boolean showIncidentCard(Context context, String str) {
        List<JSONObject> parseItems = parseItems(str);
        if (parseItems.isEmpty()) {
            parseItems = parseItems(context.getSharedPreferences("FlutterSharedPreferences", 0).getString(KEY_PAYLOAD, null));
        }
        if (parseItems.isEmpty()) {
            return false;
        }
        return showIncidentCard(context, parseItems.get(0), Integer.MIN_VALUE, Integer.MIN_VALUE, 0);
    }

    private void showPanel() {
        this.panelOpen = true;
        attachOverlay(buildPanelView());
    }

    private void showTrashDock() {
        int i;
        if (this.trashDock == null && this.windowManager != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.setPadding(dp(16), dp(18), dp(16), dp(28));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-300279270);
            gradientDrawable.setCornerRadii(new float[]{dp(28), dp(28), dp(28), dp(28), 0.0f, 0.0f, 0.0f, 0.0f});
            linearLayout.setBackground(gradientDrawable);
            FrameLayout frameLayout = new FrameLayout(this);
            int dp = dp(64);
            this.trashCircle = new View(this);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(-12303292);
            this.trashCircle.setBackground(gradientDrawable2);
            frameLayout.addView(this.trashCircle, new FrameLayout.LayoutParams(dp, dp));
            TextView textView = new TextView(this);
            textView.setText("×");
            textView.setTextColor(-1);
            textView.setTextSize(2, 28.0f);
            textView.setGravity(17);
            textView.setIncludeFontPadding(false);
            frameLayout.addView(textView, new FrameLayout.LayoutParams(dp, dp));
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(dp, dp));
            TextView textView2 = new TextView(this);
            this.trashLabel = textView2;
            textView2.setText("הסר");
            this.trashLabel.setTextColor(-1);
            this.trashLabel.setTextSize(2, 16.0f);
            this.trashLabel.setGravity(17);
            this.trashLabel.setPadding(0, dp(8), 0, 0);
            linearLayout.addView(this.trashLabel);
            if (Build.VERSION.SDK_INT >= 26) {
                i = 2038;
            } else {
                i = 2002;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(displayMetrics.widthPixels, -2, i, BUBBLE_DP, -3);
            layoutParams.gravity = 81;
            layoutParams.y = 0;
            try {
                this.windowManager.addView(linearLayout, layoutParams);
                this.trashDock = linearLayout;
                this.overTrash = false;
            } catch (Exception e4) {
                Log.e(TAG, "trash dock addView failed", e4);
            }
        }
    }

    private static void start(Context context, Intent intent) {
        try {
            if (!sForegroundStarted && Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
                return;
            }
            context.startService(intent);
        } catch (Exception unused) {
        }
    }

    private boolean startAsForeground() {
        createChannel();
        Notification buildNotification = buildNotification();
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                startForeground(41, buildNotification, 1073741824);
            } else if (i >= 29) {
                startForeground(41, buildNotification, 1);
            } else {
                startForeground(NOTIFICATION_ID, buildNotification);
            }
            sForegroundStarted = true;
            return true;
        } catch (Exception e4) {
            if (Build.VERSION.SDK_INT < 31 || !A.f.B(e4)) {
                Log.e(TAG, "startForeground failed", e4);
            }
            stopSelfSafely();
            return false;
        }
    }

    public static String statusLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1514000851:
                if (str.equals("Waiting")) {
                    c4 = 0;
                    break;
                }
                break;
            case -776859390:
                if (str.equals("ReadyForDispatching")) {
                    c4 = 1;
                    break;
                }
                break;
            case 41602816:
                if (str.equals("EnRoute")) {
                    c4 = 2;
                    break;
                }
                break;
            case 958880761:
                if (str.equals("AtScene")) {
                    c4 = 3;
                    break;
                }
                break;
            case 2021313932:
                if (str.equals("Closed")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "ממתין";
            case 1:
                return "זמין";
            case 2:
                return "בדרך";
            case 3:
                return "במקום";
            case 4:
                return "סגור";
            default:
                return str;
        }
    }

    private void stopSelfSafely() {
        hideTrashDock();
        removeOverlay();
        try {
            stopForeground(true);
        } catch (Exception unused) {
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        sCreated = true;
        this.windowManager = (WindowManager) getSystemService("window");
    }

    @Override // android.app.Service
    public void onDestroy() {
        hideTrashDock();
        removeOverlay();
        try {
            stopForeground(true);
        } catch (Exception unused) {
        }
        sForegroundStarted = false;
        sCreated = false;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        String str;
        SharedPreferences sharedPreferences = getSharedPreferences("FlutterSharedPreferences", 0);
        if (intent != null && intent.hasExtra(EXTRA_PAYLOAD)) {
            str = intent.getStringExtra(EXTRA_PAYLOAD);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = sharedPreferences.getString(KEY_PAYLOAD, null);
        }
        if (!TextUtils.isEmpty(str)) {
            this.items.clear();
            this.items.addAll(parseItems(str));
        }
        if (!startAsForeground()) {
            return 2;
        }
        if ((intent == null || !intent.getBooleanExtra(EXTRA_STOP, false)) && !sharedPreferences.getBoolean(KEY_DISMISSED, false) && !this.items.isEmpty()) {
            if (!hasOverlayPermission()) {
                stopSelfSafely();
                return 2;
            }
            if (intent != null && intent.hasExtra(EXTRA_SHOW_OVERLAY)) {
                this.showOverlay = intent.getBooleanExtra(EXTRA_SHOW_OVERLAY, true);
            }
            if (this.showOverlay) {
                if (this.overlayRoot != null && !this.panelOpen) {
                    return 1;
                }
                showBubble();
            } else {
                this.panelOpen = false;
                hideTrashDock();
                removeOverlay();
            }
            return 1;
        }
        stopSelfSafely();
        return 2;
    }

    public static void show(Context context, String str, boolean z3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSharedPreferences", 0);
        if (z3 && !isBubbleEnabled(context)) {
            z3 = false;
        }
        if (!z3) {
            sharedPreferences.edit().remove(KEY_DISMISSED).apply();
        } else if (sharedPreferences.getBoolean(KEY_DISMISSED, false)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ActiveDispatchOverlayService.class);
        if (str != null) {
            intent.putExtra(EXTRA_PAYLOAD, str);
        }
        intent.putExtra(EXTRA_SHOW_OVERLAY, z3);
        start(context, intent);
    }

    public static boolean showIncidentCard(Context context, JSONObject jSONObject, int i, int i3, int i4) {
        if (jSONObject == null) {
            return false;
        }
        Intent incidentIntent = incidentIntent(jSONObject);
        incidentIntent.putExtra(FloatingWindowService.EXTRA_SKIP_TIMEOUT, true);
        incidentIntent.putExtra(FloatingWindowService.EXTRA_DRAGGABLE, true);
        if (i != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE) {
            incidentIntent.putExtra(FloatingWindowService.EXTRA_ANCHOR_X, i);
            incidentIntent.putExtra(FloatingWindowService.EXTRA_ANCHOR_Y, i3);
            incidentIntent.putExtra(FloatingWindowService.EXTRA_ANCHOR_SIZE, i4);
        }
        if (isAls(jSONObject)) {
            incidentIntent.putExtra(FloatingWindowService.EXTRA_ACCENT, ALS_RED);
        }
        sPopupFromOverlay = true;
        return FloatingWindowService.showPrepared(context, incidentIntent);
    }
}
