package atlow.chemi.mymada.recieversAndServices;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.List;

@TargetApi(14)
public class NotificationServiceOld extends AccessibilityService {
    private static final String TAG = "MADA_APP";
    private static final String UH_SF = "com.uh.sf";
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private static final String[] SECURITY_KEYWORDS = {
        "גישה להתראות זוהתה", "אפליקציה אחרת קוראת התראות", "אזהרת אבטחה",
        "notification listener detected", "accessibility service detected"
    };

    private static final String[] EMERGENCY_KEYWORDS = {
        "אירוע", "הזנקה", "כתובת", "החייאה", "קריאה", "נפגע", "חולה", "פינוי",
        "incident", "emergency", "dispatch", "address", "call"
    };

    private static final String[] DISMISS_LABELS = {
        "אישור", "OK", "הבנתי", "Got it", "סגור", "Close"
    };

    public static boolean isAccessibilitySettingsOn(Context context) {
        int i;
        String string;
        String str = context.getPackageName() + "/" + NotificationServiceOld.class.getCanonicalName();
        try {
            i = Settings.Secure.getInt(context.getApplicationContext().getContentResolver(), "accessibility_enabled");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            i = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i == 1 && (string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        String pkg = (String) event.getPackageName();
        if (pkg == null) return;
        if (UH_SF.equals(pkg)) {
            handleHatzalahEvent(event);
            return;
        }
        Resources resources;
        String exc;
        if (event.getEventType() != 64) {
            Log.v(TAG, "Got un-handled Event");
            return;
        }
        if (event.getParcelableData() instanceof Notification) {
            Notification notification = (Notification) event.getParcelableData();
            CharSequence charSequence = notification.tickerText;
            PendingIntent pendingIntent = notification.contentIntent;
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
            RemoteViews remoteViews = notification.bigContentView;
            ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(remoteViews.getLayoutId(), (ViewGroup) null);
            remoteViews.reapply(getApplicationContext(), viewGroup);
            try {
                resources = getPackageManager().getResourcesForApplication("com.groboot.mdaemergency");
            } catch (Exception e) {
                e.printStackTrace();
                resources = null;
            }
            if (resources == null) return;
            int identifier = resources.getIdentifier("android:id/title", null, null);
            int identifier2 = resources.getIdentifier("android:id/big_text", null, null);
            String charSequence2 = ((TextView) viewGroup.findViewById(identifier)).getText().toString();
            String charSequence3 = ((TextView) viewGroup.findViewById(identifier2)).getText().toString();
            if (Boolean.valueOf(getSharedPreferences("Settings", 0).getBoolean("Mapp", false)).booleanValue()) {
                try {
                    Intent intent = new Intent(TAG);
                    intent.putExtra("pack", pkg);
                    intent.putExtra("text", charSequence3);
                    intent.putExtra("tick", charSequence);
                    if (charSequence2.contains("\u05d0\u05d9\u05e8\u05d5\u05e2")) {
                        if (!charSequence3.contains("\u05d0\u05d9\u05e8\u05d5\u05e2 \u05d7\u05d3\u05e9")) {
                            if (charSequence3.contains("\u05d4\u05d5\u05d3\u05e2\u05ea \u05e7\u05d1\u05d5\u05e6\u05ea")) {
                                intent.putExtra("callT", 2);
                            } else if (charSequence3.contains("\u05d4\u05d5\u05d3\u05e2\u05ea \u05e6\u05d5\u05d5\u05ea")) {
                                intent.putExtra("callT", 3);
                            }
                        }
                        intent.putExtra("callT", 1);
                    }
                    GrobootRec.madasApp(pendingIntent);
                    getApplicationContext().sendBroadcast(intent);
                    return;
                } catch (Exception e2) {
                    exc = e2.toString();
                }
            } else {
                exc = "not reco is off!";
            }
            Log.e(TAG, exc);
        }
    }

    private void handleHatzalahEvent(AccessibilityEvent event) {
        int type = event.getEventType();
        if (type != AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED &&
            type != AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) return;
        String eventText = event.getText() != null ? event.getText().toString() : "";
        boolean isSecurityDialog = containsSecurityKeyword(eventText);
        if (!isSecurityDialog) {
            AccessibilityNodeInfo source = event.getSource();
            if (source != null) {
                CharSequence sourceText = source.getText();
                source.recycle();
                if (sourceText != null) isSecurityDialog = containsSecurityKeyword(sourceText.toString());
            }
        }
        if (isSecurityDialog) {
            Log.i(TAG, "Hatzalah security dialog detected auto-dismissing");
            mHandler.postDelayed(this::tryDismissHatzalahDialog, 250);
        }
    }

    private boolean containsSecurityKeyword(String text) {
        if (text == null || text.isEmpty()) return false;
        String lower = text.toLowerCase();
        // If it looks like an emergency call / incident, NEVER consider it a security dialog
        for (String ek : EMERGENCY_KEYWORDS) {
            if (lower.contains(ek.toLowerCase())) return false;
        }
        for (String kw : SECURITY_KEYWORDS) {
            if (lower.contains(kw.toLowerCase())) return true;
        }
        return false;
    }

    private void tryDismissHatzalahDialog() {
        try {
            AccessibilityNodeInfo root = getRootInActiveWindow();
            if (root != null) {
                if (tryClickDismissButton(root)) { root.recycle(); return; }
                root.recycle();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                List<AccessibilityWindowInfo> windows = getWindows();
                if (windows != null) {
                    for (AccessibilityWindowInfo w : windows) {
                        AccessibilityNodeInfo wRoot = w.getRoot();
                        if (wRoot != null) {
                            String wPkg = wRoot.getPackageName() != null ? wRoot.getPackageName().toString() : "";
                            if (UH_SF.equals(wPkg) && tryClickDismissButton(wRoot)) { wRoot.recycle(); return; }
                            wRoot.recycle();
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "tryDismissHatzalahDialog: " + e.getMessage());
        }
    }

    private boolean tryClickDismissButton(AccessibilityNodeInfo node) {
        if (node == null) return false;
        try {
            for (String label : DISMISS_LABELS) {
                List<AccessibilityNodeInfo> results = node.findAccessibilityNodeInfosByText(label);
                if (results != null) {
                    for (AccessibilityNodeInfo n : results) {
                        if (n.isClickable() || n.isEnabled()) {
                            n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            n.recycle();
                            return true;
                        }
                        n.recycle();
                    }
                }
            }
            return false;
        } catch (Exception e) { return false; }
    }

    @Override
    public void onInterrupt() {}

    @Override
    public void onServiceConnected() {
        AccessibilityServiceInfo serviceInfo = new AccessibilityServiceInfo();
        serviceInfo.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        serviceInfo.packageNames = new String[]{"com.groboot.mdaemergency", "il.org.mda.health", UH_SF};
        serviceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        serviceInfo.notificationTimeout = 50L;
        serviceInfo.flags = AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS
                | AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS;
        setServiceInfo(serviceInfo);
        Log.i(TAG, "NotificationServiceOld connected MDA + Hatzalah auto-dismiss");
    }
}