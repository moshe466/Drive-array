package com.lt.plugin.lt_plugin.services;

import android.R;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.lt.plugin.lt_plugin.PushActionHelper;
import com.lt.plugin.lt_plugin.PushEntityIntentHelper;
import com.lt.plugin.lt_plugin.config.PluginConfig;
import com.lt.plugin.lt_plugin.utils.LogHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import w.n;

/* loaded from: classes.dex */
public class FloatingWindowService extends Service {
    private static final String CHANNEL_ID = "FloatingServiceChannel";
    private static final int DEFAULT_ACCENT = -36352;
    public static final String EXTRA_ACCENT = "accent_color";
    public static final String EXTRA_ANCHOR_SIZE = "anchor_size";
    public static final String EXTRA_ANCHOR_X = "anchor_x";
    public static final String EXTRA_ANCHOR_Y = "anchor_y";
    public static final String EXTRA_DRAGGABLE = "draggable";
    public static final String EXTRA_SKIP_TIMEOUT = "skip_timeout";
    private static final int NOTIFICATION_ID = 1;
    private static final String TAG = "FloatingWindowService";
    public static volatile Runnable onClosed;
    private String appName;
    private LinearLayout bodyLayoutContainer;
    private LinearLayout bodyPartsContainer;
    private Button closeBtn;
    private float dragLastX;
    private float dragLastY;
    private ViewGroup floatView;
    private WindowManager.LayoutParams floatWindowLayoutParam;
    private Button navigateBtn;
    private NotificationManager notificationManager;
    private boolean overlayCard;
    private String pendingPushEntity;
    private String pendingPushEntityId;
    private PluginConfig pluginConfig;
    private Handler timeoutHandler;
    private TextView title;
    private TextView txt;
    private WebView webview;
    private boolean windowDragged;
    private WindowManager windowManager;
    private int cachedBodyBgColor = -1;
    private int cachedBodyTextColor = -16777216;
    private int cachedBodySizePx = 42;
    private int cachedContentInsetPx = 15;
    private int accentColor = DEFAULT_ACCENT;

    /* renamed from: com.lt.plugin.lt_plugin.services.FloatingWindowService$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends WebViewClient {
        public AnonymousClass1() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl().toString();
            if (!uri.startsWith("tel:") && !uri.startsWith("mailto:") && !uri.startsWith("geo:0,0?q=") && !uri.startsWith("geo:") && !uri.startsWith("waze://")) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uri));
            intent.addFlags(268435456);
            FloatingWindowService.this.startActivity(intent);
            return true;
        }
    }

    private void applyBodyText(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        textView.setSingleLine(false);
        textView.setMaxLines(30);
        textView.setEllipsize(null);
        textView.setHorizontallyScrolling(false);
        applyHebrewRtl(textView);
        textView.setText(normalizeNewlines(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        if (r9.equals("left") != false) goto L115;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void applyCellAlignDir(android.widget.TextView r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lt.plugin.lt_plugin.services.FloatingWindowService.applyCellAlignDir(android.widget.TextView, java.lang.String, java.lang.String):void");
    }

    private void applyCellText(TextView textView, String str, boolean z3) {
        String normalizeNewlines = normalizeNewlines(str);
        if (z3) {
            textView.setText(Html.fromHtml(normalizeNewlines, 0));
        } else {
            textView.setText(normalizeNewlines);
        }
    }

    private static void applyHebrewRtl(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setTextDirection(4);
        textView.setLayoutDirection(1);
    }

    private void applyPlacement(Intent intent, int i, DisplayMetrics displayMetrics) {
        int i3;
        boolean booleanExtra = intent.getBooleanExtra(EXTRA_DRAGGABLE, false);
        boolean hasExtra = intent.hasExtra(EXTRA_ANCHOR_X);
        if (!booleanExtra && !hasExtra) {
            WindowManager.LayoutParams layoutParams = this.floatWindowLayoutParam;
            layoutParams.gravity = 17;
            layoutParams.x = 0;
            layoutParams.y = 0;
            return;
        }
        this.floatWindowLayoutParam.gravity = 51;
        int dpToPx = dpToPx(8);
        if (hasExtra) {
            int intExtra = intent.getIntExtra(EXTRA_ANCHOR_X, 0);
            int intExtra2 = intent.getIntExtra(EXTRA_ANCHOR_Y, 0);
            int intExtra3 = intent.getIntExtra(EXTRA_ANCHOR_SIZE, dpToPx(56));
            float f4 = (intExtra3 / 2.0f) + intExtra;
            int i4 = displayMetrics.widthPixels;
            if (f4 >= i4 / 2.0f) {
                i3 = (intExtra - i) - dpToPx;
            } else {
                i3 = intExtra + intExtra3 + dpToPx;
            }
            this.floatWindowLayoutParam.x = Math.max(dpToPx, Math.min(i3, (i4 - i) - dpToPx));
            this.floatWindowLayoutParam.y = Math.max(dpToPx, intExtra2);
            return;
        }
        this.floatWindowLayoutParam.x = Math.max(dpToPx, (displayMetrics.widthPixels - i) / 2);
        this.floatWindowLayoutParam.y = Math.max(dpToPx, (int) (displayMetrics.heightPixels * 0.18f));
    }

    private void bindOverlayCardTouches(View.OnClickListener onClickListener) {
        if (this.bodyLayoutContainer != null) {
            for (int i = 0; i < this.bodyLayoutContainer.getChildCount(); i++) {
                View childAt = this.bodyLayoutContainer.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    if ("drag".equals(childAt.getTag())) {
                        enableDragOn(childAt);
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                            enableDragOn(viewGroup.getChildAt(i3));
                        }
                    } else {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        for (int i4 = 0; i4 < viewGroup2.getChildCount(); i4++) {
                            View childAt2 = viewGroup2.getChildAt(i4);
                            if (!"navigate".equals(childAt2.getTag()) && !(childAt2 instanceof Button)) {
                                childAt2.setOnClickListener(onClickListener);
                            }
                        }
                        if (viewGroup2.getChildCount() == 0) {
                            childAt.setOnClickListener(onClickListener);
                        }
                    }
                }
            }
        }
    }

    private Notification buildForegroundNotification() {
        PendingIntent activity = PendingIntent.getActivity(this, 1, buildMainTapIntent(), 201326592);
        int identifier = getResources().getIdentifier("ic_launcher", "mipmap", getPackageName());
        if (identifier == 0) {
            identifier = R.drawable.ic_menu_view;
        }
        n nVar = new n(this, CHANNEL_ID);
        nVar.f6651e = n.b(this.appName);
        nVar.f6652f = n.b(PluginConfig.getLocalized(this, "lt_online", "Online"));
        nVar.f6666v.icon = identifier;
        nVar.f6653g = activity;
        nVar.d(2, true);
        nVar.p = "service";
        nVar.f6655j = -2;
        return nVar.a();
    }

    private Intent buildMainTapIntent() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
        }
        PushEntityIntentHelper.addTapLaunchActivityFlags(launchIntentForPackage);
        PushEntityIntentHelper.putEntityExtras(launchIntentForPackage, this.pendingPushEntity, this.pendingPushEntityId);
        return launchIntentForPackage;
    }

    private static String cellAction(JSONObject jSONObject) {
        String optString = jSONObject.optString("action", "");
        if (optString == null || optString.trim().isEmpty()) {
            optString = jSONObject.optString("x", "");
        }
        if (optString == null) {
            return "";
        }
        return optString.trim().toLowerCase();
    }

    private static int cellRadiusPx(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            if (jSONObject.has("radius")) {
                return Math.max(0, jSONObject.optInt("radius", i));
            }
            if (jSONObject.has("r")) {
                return Math.max(0, jSONObject.optInt("r", i));
            }
        }
        return i;
    }

    private static int cellSize(JSONObject jSONObject, int i) {
        int optInt = jSONObject.optInt("size", 0);
        if (optInt <= 0) {
            optInt = jSONObject.optInt("s", 0);
        }
        if (optInt <= 0) {
            return i;
        }
        return optInt;
    }

    private static String cellText(JSONObject jSONObject) {
        String optString = jSONObject.optString("text", "");
        if (optString == null || optString.trim().isEmpty()) {
            optString = jSONObject.optString("t", "");
        }
        if (optString == null) {
            return "";
        }
        return optString.trim();
    }

    public void clampToScreen() {
        int i;
        int dpToPx;
        if (this.floatView != null && this.floatWindowLayoutParam != null && this.windowManager != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int dpToPx2 = dpToPx(8);
            if (this.floatView.getWidth() > 0) {
                i = this.floatView.getWidth();
            } else {
                i = this.floatWindowLayoutParam.width;
            }
            if (this.floatView.getHeight() > 0) {
                dpToPx = this.floatView.getHeight();
            } else {
                dpToPx = dpToPx(180);
            }
            WindowManager.LayoutParams layoutParams = this.floatWindowLayoutParam;
            layoutParams.x = Math.max(dpToPx2, Math.min(layoutParams.x, (displayMetrics.widthPixels - i) - dpToPx2));
            WindowManager.LayoutParams layoutParams2 = this.floatWindowLayoutParam;
            layoutParams2.y = Math.max(dpToPx2, Math.min(layoutParams2.y, (displayMetrics.heightPixels - dpToPx) - dpToPx2));
            try {
                this.windowManager.updateViewLayout(this.floatView, this.floatWindowLayoutParam);
            } catch (Exception unused) {
            }
        }
    }

    private ViewGroup createFloatingView() {
        int i = this.accentColor;
        int parseColorSafe = parseColorSafe(this.pluginConfig.getFloatingWindowBgColor(), -1);
        int parseColorSafe2 = parseColorSafe(this.pluginConfig.getFloatingWindowHeaderBgColor(), parseColorSafe);
        int parseColorSafe3 = parseColorSafe(this.pluginConfig.getFloatingWindowTitleTextColor(), -15066598);
        int parseColorSafe4 = parseColorSafe(this.pluginConfig.getFloatingWindowCloseBgColor(), 0);
        int parseColorSafe5 = parseColorSafe(this.pluginConfig.getFloatingWindowCloseTextColor(), -10066330);
        this.cachedBodyBgColor = parseColorSafe(this.pluginConfig.getFloatingWindowBodyBgColor(), -1);
        this.cachedBodyTextColor = parseColorSafe(this.pluginConfig.getFloatingWindowBodyTextColor(), -16777216);
        int dpToPx = dpToPx(Math.max(this.pluginConfig.getFloatingWindowHeaderHeightDp(), 48));
        int max = Math.max(this.pluginConfig.getFloatingWindowTitleTextSizePx(), 42);
        int max2 = Math.max(this.pluginConfig.getFloatingWindowCloseTextSizePx(), 32);
        this.cachedBodySizePx = Math.max(this.pluginConfig.getFloatingWindowBodyTextSizePx(), 40);
        String floatingWindowCloseText = this.pluginConfig.getFloatingWindowCloseText();
        int dpToPx2 = dpToPx(12);
        int dpToPx3 = dpToPx(7);
        int dpToPx4 = dpToPx(15);
        this.cachedContentInsetPx = dpToPx4;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutDirection(0);
        linearLayout.setBackground(roundedRect(parseColorSafe, dpToPx2));
        linearLayout.setClipToOutline(true);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        linearLayout.setElevation(dpToPx(8));
        linearLayout.setClipChildren(true);
        linearLayout.setImportantForAccessibility(4);
        View view = new View(this);
        view.setBackgroundColor(i);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, dpToPx3));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutDirection(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundColor(parseColorSafe2);
        linearLayout2.setPadding(dpToPx4, 0, dpToPx4, 0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, dpToPx));
        Button button = new Button(this);
        this.closeBtn = button;
        button.setId(R.id.button1);
        int max3 = Math.max(dpToPx - dpToPx(8), dpToPx(36));
        this.closeBtn.setLayoutParams(new LinearLayout.LayoutParams(max3, max3));
        this.closeBtn.setMinWidth(0);
        this.closeBtn.setMinimumWidth(0);
        this.closeBtn.setMinHeight(0);
        this.closeBtn.setMinimumHeight(0);
        this.closeBtn.setPadding(0, 0, 0, 0);
        if (parseColorSafe4 != 0 && parseColorSafe4 != parseColorSafe && parseColorSafe4 != parseColorSafe2) {
            this.closeBtn.setBackgroundColor(parseColorSafe4);
        } else {
            this.closeBtn.setBackground(null);
        }
        this.closeBtn.setText(floatingWindowCloseText);
        this.closeBtn.setTextColor(parseColorSafe5);
        this.closeBtn.setTextSize(0, max2);
        this.closeBtn.setAllCaps(false);
        linearLayout2.addView(this.closeBtn);
        TextView textView = new TextView(this);
        this.title = textView;
        textView.setId(R.id.text1);
        this.title.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.title.setBackgroundColor(0);
        this.title.setTextColor(parseColorSafe3);
        this.title.setGravity(8388627);
        this.title.setTextAlignment(5);
        applyHebrewRtl(this.title);
        TextView textView2 = this.title;
        textView2.setTypeface(textView2.getTypeface(), 1);
        this.title.setTextSize(0, max);
        this.title.setMaxLines(2);
        this.title.setEllipsize(TextUtils.TruncateAt.END);
        this.title.setHorizontallyScrolling(false);
        this.title.setPadding(dpToPx(8), 0, 0, 0);
        linearLayout2.addView(this.title);
        linearLayout.addView(linearLayout2);
        WebView webView = new WebView(this);
        this.webview = webView;
        webView.setId(com.lt.plugin.lt_plugin.R.id.webview);
        this.webview.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.webview.setVisibility(8);
        linearLayout.addView(this.webview);
        TextView textView3 = new TextView(this);
        this.txt = textView3;
        textView3.setId(R.id.text2);
        this.txt.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.txt.setBackgroundColor(this.cachedBodyBgColor);
        this.txt.setTextColor(this.cachedBodyTextColor);
        this.txt.setGravity(8388659);
        this.txt.setTextAlignment(5);
        applyHebrewRtl(this.txt);
        this.txt.setPadding(dpToPx4, dpToPx(8), dpToPx4, dpToPx(8));
        this.txt.setTextSize(0, this.cachedBodySizePx);
        this.txt.setSingleLine(false);
        this.txt.setMaxLines(30);
        this.txt.setHorizontallyScrolling(false);
        this.txt.setLineSpacing(0.0f, 1.15f);
        linearLayout.addView(this.txt);
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.bodyPartsContainer = linearLayout3;
        linearLayout3.setOrientation(1);
        this.bodyPartsContainer.setLayoutDirection(1);
        this.bodyPartsContainer.setBackgroundColor(this.cachedBodyBgColor);
        this.bodyPartsContainer.setPadding(dpToPx4, dpToPx(4), dpToPx4, dpToPx(4));
        this.bodyPartsContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bodyPartsContainer.setVisibility(8);
        linearLayout.addView(this.bodyPartsContainer);
        LinearLayout linearLayout4 = new LinearLayout(this);
        this.bodyLayoutContainer = linearLayout4;
        linearLayout4.setOrientation(1);
        this.bodyLayoutContainer.setLayoutDirection(1);
        this.bodyLayoutContainer.setBackgroundColor(this.cachedBodyBgColor);
        this.bodyLayoutContainer.setPadding(dpToPx4, dpToPx(2), dpToPx4, dpToPx(2));
        this.bodyLayoutContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.bodyLayoutContainer.setVisibility(8);
        linearLayout.addView(this.bodyLayoutContainer);
        Button button2 = new Button(this);
        this.navigateBtn = button2;
        button2.setId(R.id.button2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dpToPx4, dpToPx4, dpToPx4, dpToPx4);
        this.navigateBtn.setLayoutParams(layoutParams);
        this.navigateBtn.setBackground(roundedRect(i, dpToPx(10)));
        this.navigateBtn.setTextColor(-1);
        this.navigateBtn.setTextSize(0, Math.max(this.cachedBodySizePx, Math.min(max, dpToPx(22))));
        this.navigateBtn.setAllCaps(false);
        this.navigateBtn.setVisibility(8);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setOrientation(1);
        linearLayout5.setBackgroundColor(this.cachedBodyBgColor);
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout5.addView(this.navigateBtn);
        linearLayout.addView(linearLayout5);
        return linearLayout;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.notificationManager == null) {
                this.notificationManager = (NotificationManager) getSystemService("notification");
            }
            if (this.notificationManager != null) {
                com.google.android.gms.common.wrappers.a.s();
                NotificationChannel x3 = a.x(this.appName);
                x3.enableLights(false);
                x3.enableVibration(false);
                x3.setSound(null, null);
                x3.setShowBadge(false);
                this.notificationManager.createNotificationChannel(x3);
            }
        }
    }

    private int dpToPx(int i) {
        return Math.round(i * getResources().getDisplayMetrics().density);
    }

    private void enableDragOn(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.lt.plugin.lt_plugin.services.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean lambda$enableDragOn$5;
                lambda$enableDragOn$5 = FloatingWindowService.this.lambda$enableDragOn$5(view2, motionEvent);
                return lambda$enableDragOn$5;
            }
        });
    }

    private void enforceFloatingWindowSecureFlag() {
        ViewGroup viewGroup;
        if (this.pluginConfig.isFloatingWindowSecureEnabled() && this.windowManager != null && (viewGroup = this.floatView) != null && this.floatWindowLayoutParam != null && viewGroup.isAttachedToWindow()) {
            WindowManager.LayoutParams layoutParams = this.floatWindowLayoutParam;
            int i = layoutParams.flags;
            if ((i & UserMetadata.MAX_INTERNAL_KEY_SIZE) == 0) {
                layoutParams.flags = i | UserMetadata.MAX_INTERNAL_KEY_SIZE;
                try {
                    this.windowManager.updateViewLayout(this.floatView, layoutParams);
                } catch (Exception e4) {
                    Log.e(TAG, "Failed to re-apply FLAG_SECURE on floating window", e4);
                }
            }
        }
    }

    private static String firstNonEmpty(String str, String str2) {
        if (str != null && !str.trim().isEmpty()) {
            return str.trim();
        }
        if (str2 != null && !str2.trim().isEmpty()) {
            return str2.trim();
        }
        return "";
    }

    private boolean hasOverlayPermission() {
        return Settings.canDrawOverlays(this);
    }

    public /* synthetic */ boolean lambda$enableDragOn$5(View view, MotionEvent motionEvent) {
        if (this.floatWindowLayoutParam == null || this.windowManager == null || this.floatView == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else {
                    float rawX = motionEvent.getRawX() - this.dragLastX;
                    float rawY = motionEvent.getRawY() - this.dragLastY;
                    if (Math.hypot(rawX, rawY) > dpToPx(8)) {
                        this.windowDragged = true;
                    }
                    if (this.windowDragged) {
                        WindowManager.LayoutParams layoutParams = this.floatWindowLayoutParam;
                        layoutParams.x = Math.round(rawX) + layoutParams.x;
                        WindowManager.LayoutParams layoutParams2 = this.floatWindowLayoutParam;
                        layoutParams2.y = Math.round(rawY) + layoutParams2.y;
                        this.dragLastX = motionEvent.getRawX();
                        this.dragLastY = motionEvent.getRawY();
                        try {
                            this.windowManager.updateViewLayout(this.floatView, this.floatWindowLayoutParam);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            return true;
        }
        this.windowDragged = false;
        this.dragLastX = motionEvent.getRawX();
        this.dragLastY = motionEvent.getRawY();
        return true;
    }

    public /* synthetic */ void lambda$populateBodyLayout$3(View view) {
        LogHelper.d(TAG, "layout close clicked");
        stopSelfSafely();
    }

    public /* synthetic */ void lambda$populateBodyLayout$4(Intent intent, View view) {
        LogHelper.d(TAG, "layout navigate clicked");
        PushActionHelper.launchNavigate(this, intent);
        stopSelfSafely();
    }

    public /* synthetic */ void lambda$showFloatingWindow$0(Intent intent, View view) {
        LogHelper.d(TAG, "navigateBtn clicked");
        PushActionHelper.launchNavigate(this, intent);
        stopSelfSafely();
    }

    public /* synthetic */ void lambda$showFloatingWindow$1(View view) {
        LogHelper.d(TAG, "content clicked: go back to MainActivity & close");
        startActivity(buildMainTapIntent());
        stopSelfSafely();
    }

    public /* synthetic */ void lambda$showFloatingWindow$2(View view) {
        LogHelper.d(TAG, "closeBtn clicked");
        stopSelfSafely();
    }

    public static String normalizeNewlines(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("\\r\\n", "\n").replace("\\n", "\n").replace("\r\n", "\n").replace('\r', '\n');
    }

    private boolean onFloatingViewTouched(View view, MotionEvent motionEvent) {
        return false;
    }

    private static int[] parseBodyPartSizes(String str, int i) {
        if (str != null && !str.trim().isEmpty() && i > 0) {
            try {
                JSONArray jSONArray = new JSONArray(str.trim());
                int[] iArr = new int[i];
                for (int i3 = 0; i3 < i; i3++) {
                    if (i3 < jSONArray.length()) {
                        int optInt = jSONArray.optInt(i3, 0);
                        if (optInt <= 0) {
                            optInt = 0;
                        }
                        iArr[i3] = optInt;
                    } else {
                        iArr[i3] = 0;
                    }
                }
                return iArr;
            } catch (Exception e4) {
                e4.getMessage();
            }
        }
        return null;
    }

    private static List<String> parseBodyParts(String str) {
        if (str != null && !str.trim().isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(str.trim());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String trim = normalizeNewlines(jSONArray.optString(i, "")).trim();
                    if (!trim.isEmpty()) {
                        arrayList.add(trim);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            } catch (Exception e4) {
                e4.getMessage();
            }
        }
        return null;
    }

    private static int parseColorSafe(String str, int i) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i;
        }
    }

    private static int parseLayoutDirection(String str, int i) {
        if (str != null) {
            String lowerCase = str.trim().toLowerCase();
            if (!lowerCase.isEmpty()) {
                if (!"rtl".equals(lowerCase) && !"r".equals(lowerCase)) {
                    if ("ltr".equals(lowerCase) || "l".equals(lowerCase)) {
                        return 0;
                    }
                } else {
                    return 1;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0339 A[Catch: Exception -> 0x0094, TryCatch #1 {Exception -> 0x0094, blocks: (B:7:0x001e, B:9:0x002f, B:12:0x0036, B:13:0x0062, B:15:0x0068, B:19:0x0381, B:20:0x0083, B:23:0x008d, B:27:0x009d, B:31:0x00a9, B:34:0x00b5, B:38:0x00d6, B:39:0x00bc, B:42:0x00ca, B:48:0x00db, B:52:0x011d, B:57:0x012b, B:142:0x0144, B:62:0x0151, B:64:0x0157, B:68:0x0310, B:69:0x0174, B:72:0x017f, B:75:0x01f4, B:78:0x020d, B:81:0x021b, B:84:0x0224, B:88:0x0232, B:89:0x023b, B:90:0x030d, B:92:0x0234, B:97:0x0268, B:100:0x028c, B:103:0x029a, B:106:0x02a3, B:109:0x02ba, B:110:0x02f2, B:112:0x02fb, B:115:0x02c9, B:116:0x02e6, B:119:0x028a, B:121:0x0325, B:123:0x0339, B:126:0x0343, B:127:0x0363, B:131:0x036b, B:133:0x0374, B:134:0x0379, B:60:0x014c, B:150:0x0097, B:152:0x0395), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5 A[Catch: Exception -> 0x0094, TRY_ENTER, TryCatch #1 {Exception -> 0x0094, blocks: (B:7:0x001e, B:9:0x002f, B:12:0x0036, B:13:0x0062, B:15:0x0068, B:19:0x0381, B:20:0x0083, B:23:0x008d, B:27:0x009d, B:31:0x00a9, B:34:0x00b5, B:38:0x00d6, B:39:0x00bc, B:42:0x00ca, B:48:0x00db, B:52:0x011d, B:57:0x012b, B:142:0x0144, B:62:0x0151, B:64:0x0157, B:68:0x0310, B:69:0x0174, B:72:0x017f, B:75:0x01f4, B:78:0x020d, B:81:0x021b, B:84:0x0224, B:88:0x0232, B:89:0x023b, B:90:0x030d, B:92:0x0234, B:97:0x0268, B:100:0x028c, B:103:0x029a, B:106:0x02a3, B:109:0x02ba, B:110:0x02f2, B:112:0x02fb, B:115:0x02c9, B:116:0x02e6, B:119:0x028a, B:121:0x0325, B:123:0x0339, B:126:0x0343, B:127:0x0363, B:131:0x036b, B:133:0x0374, B:134:0x0379, B:60:0x014c, B:150:0x0097, B:152:0x0395), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db A[EDGE_INSN: B:47:0x00db->B:48:0x00db BREAK  A[LOOP:1: B:31:0x00a9->B:38:0x00d6], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014c A[Catch: Exception -> 0x0094, TryCatch #1 {Exception -> 0x0094, blocks: (B:7:0x001e, B:9:0x002f, B:12:0x0036, B:13:0x0062, B:15:0x0068, B:19:0x0381, B:20:0x0083, B:23:0x008d, B:27:0x009d, B:31:0x00a9, B:34:0x00b5, B:38:0x00d6, B:39:0x00bc, B:42:0x00ca, B:48:0x00db, B:52:0x011d, B:57:0x012b, B:142:0x0144, B:62:0x0151, B:64:0x0157, B:68:0x0310, B:69:0x0174, B:72:0x017f, B:75:0x01f4, B:78:0x020d, B:81:0x021b, B:84:0x0224, B:88:0x0232, B:89:0x023b, B:90:0x030d, B:92:0x0234, B:97:0x0268, B:100:0x028c, B:103:0x029a, B:106:0x02a3, B:109:0x02ba, B:110:0x02f2, B:112:0x02fb, B:115:0x02c9, B:116:0x02e6, B:119:0x028a, B:121:0x0325, B:123:0x0339, B:126:0x0343, B:127:0x0363, B:131:0x036b, B:133:0x0374, B:134:0x0379, B:60:0x014c, B:150:0x0097, B:152:0x0395), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157 A[Catch: Exception -> 0x0094, TryCatch #1 {Exception -> 0x0094, blocks: (B:7:0x001e, B:9:0x002f, B:12:0x0036, B:13:0x0062, B:15:0x0068, B:19:0x0381, B:20:0x0083, B:23:0x008d, B:27:0x009d, B:31:0x00a9, B:34:0x00b5, B:38:0x00d6, B:39:0x00bc, B:42:0x00ca, B:48:0x00db, B:52:0x011d, B:57:0x012b, B:142:0x0144, B:62:0x0151, B:64:0x0157, B:68:0x0310, B:69:0x0174, B:72:0x017f, B:75:0x01f4, B:78:0x020d, B:81:0x021b, B:84:0x0224, B:88:0x0232, B:89:0x023b, B:90:0x030d, B:92:0x0234, B:97:0x0268, B:100:0x028c, B:103:0x029a, B:106:0x02a3, B:109:0x02ba, B:110:0x02f2, B:112:0x02fb, B:115:0x02c9, B:116:0x02e6, B:119:0x028a, B:121:0x0325, B:123:0x0339, B:126:0x0343, B:127:0x0363, B:131:0x036b, B:133:0x0374, B:134:0x0379, B:60:0x014c, B:150:0x0097, B:152:0x0395), top: B:6:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean populateBodyLayout(java.lang.String r36, android.content.Intent r37) {
        /*
            Method dump skipped, instructions count: 938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lt.plugin.lt_plugin.services.FloatingWindowService.populateBodyLayout(java.lang.String, android.content.Intent):boolean");
    }

    private void populateBodyParts(List<String> list, int[] iArr) {
        int i;
        LinearLayout linearLayout = this.bodyPartsContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            int max = Math.max(1, dpToPx(1));
            for (int i3 = 0; i3 < list.size(); i3++) {
                int i4 = this.cachedBodySizePx;
                if (iArr != null && i3 < iArr.length && (i = iArr[i3]) > 0) {
                    i4 = i;
                }
                TextView textView = new TextView(this);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView.setTextColor(this.cachedBodyTextColor);
                textView.setGravity(8388659);
                textView.setTextAlignment(5);
                applyHebrewRtl(textView);
                textView.setTextSize(0, i4);
                textView.setSingleLine(false);
                textView.setMaxLines(20);
                textView.setHorizontallyScrolling(false);
                textView.setPadding(0, dpToPx(10), 0, dpToPx(10));
                textView.setLineSpacing(0.0f, 1.15f);
                applyBodyText(textView, list.get(i3));
                this.bodyPartsContainer.addView(textView);
                if (i3 < list.size() - 1) {
                    View view = new View(this);
                    view.setBackgroundColor(-2039584);
                    this.bodyPartsContainer.addView(view, new LinearLayout.LayoutParams(-1, max));
                }
            }
        }
    }

    private void readPushEntityFromIntent(Intent intent) {
        this.pendingPushEntity = null;
        this.pendingPushEntityId = null;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(PushEntityIntentHelper.EXTRA_ENTITY);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("entity");
            }
            String stringExtra2 = intent.getStringExtra(PushEntityIntentHelper.EXTRA_ENTITY_ID);
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = intent.getStringExtra("entityID");
            }
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = intent.getStringExtra("entityId");
            }
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.pendingPushEntity = stringExtra;
                this.pendingPushEntityId = stringExtra2;
            }
        }
    }

    private void removeFloatingViewIfNeeded() {
        ViewGroup viewGroup;
        if (this.windowManager != null && (viewGroup = this.floatView) != null) {
            try {
                if (viewGroup.isAttachedToWindow()) {
                    this.windowManager.removeView(this.floatView);
                }
            } catch (Exception e4) {
                e4.getMessage();
            }
        }
        this.floatView = null;
        this.bodyPartsContainer = null;
        this.bodyLayoutContainer = null;
    }

    private int resId(String str, String str2) {
        return getResources().getIdentifier(str, str2, getPackageName());
    }

    private static GradientDrawable roundedRect(int i, float f4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f4);
        return gradientDrawable;
    }

    private void setupWebView() {
        WebView webView = this.webview;
        if (webView == null) {
            return;
        }
        webView.setInitialScale(1);
        WebSettings settings = this.webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(false);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setGeolocationEnabled(true);
        this.webview.setWebViewClient(new WebViewClient() { // from class: com.lt.plugin.lt_plugin.services.FloatingWindowService.1
            public AnonymousClass1() {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                String uri = webResourceRequest.getUrl().toString();
                if (!uri.startsWith("tel:") && !uri.startsWith("mailto:") && !uri.startsWith("geo:0,0?q=") && !uri.startsWith("geo:") && !uri.startsWith("waze://")) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uri));
                intent.addFlags(268435456);
                FloatingWindowService.this.startActivity(intent);
                return true;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x033f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showFloatingWindow(android.content.Intent r22) {
        /*
            Method dump skipped, instructions count: 944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lt.plugin.lt_plugin.services.FloatingWindowService.showFloatingWindow(android.content.Intent):void");
    }

    public static boolean showPrepared(Context context, Intent intent) {
        if (context != null && intent != null) {
            intent.setClass(context, FloatingWindowService.class);
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                    return true;
                }
                context.startService(intent);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public void stopSelfSafely() {
        LogHelper.d(TAG, "stopSelfSafely called");
        removeFloatingViewIfNeeded();
        Handler handler = this.timeoutHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        try {
            stopForeground(true);
        } catch (Exception e4) {
            e4.getMessage();
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
        LogHelper.d(TAG, "onCreate");
        PluginConfig pluginConfig = PluginConfig.getInstance(getApplicationContext());
        this.pluginConfig = pluginConfig;
        if (!pluginConfig.isFloatingWindowEnabled()) {
            stopSelf();
            return;
        }
        try {
            PackageManager packageManager = getPackageManager();
            this.appName = packageManager.getApplicationLabel(packageManager.getApplicationInfo(getPackageName(), 0)).toString();
        } catch (Exception unused) {
            this.appName = "Floating Window";
        }
        this.notificationManager = (NotificationManager) getSystemService("notification");
        this.windowManager = (WindowManager) getSystemService("window");
        this.timeoutHandler = new Handler(Looper.getMainLooper());
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogHelper.d(TAG, "onDestroy");
        removeFloatingViewIfNeeded();
        Handler handler = this.timeoutHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        try {
            stopForeground(true);
        } catch (Exception e4) {
            e4.getMessage();
        }
        sendBroadcast(new Intent("finish"));
        Runnable runnable = onClosed;
        onClosed = null;
        if (runnable != null) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        int i4;
        LogHelper.i(TAG, "onStartCommand: startId=" + i3 + " intent=" + intent);
        if (!this.pluginConfig.isFloatingWindowEnabled()) {
            stopSelf();
            return 2;
        }
        if (intent != null && intent.hasExtra("title")) {
            readPushEntityFromIntent(intent);
            createNotificationChannel();
            Notification buildForegroundNotification = buildForegroundNotification();
            try {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 34) {
                    i4 = 2048;
                } else {
                    i4 = 1;
                }
                if (i5 >= 31) {
                    try {
                        startForeground(1, buildForegroundNotification, i4);
                    } catch (ForegroundServiceStartNotAllowedException unused) {
                        stopSelfSafely();
                        return 2;
                    }
                } else {
                    startForeground(1, buildForegroundNotification, i4);
                }
                showFloatingWindow(intent);
                return 2;
            } catch (Exception e4) {
                Log.e(TAG, "Failed to start foreground service", e4);
                stopSelfSafely();
                return 2;
            }
        }
        stopSelfSafely();
        return 2;
    }
}
