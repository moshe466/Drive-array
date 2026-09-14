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
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RemoteViews;
import android.widget.TextView;

@TargetApi(14)
/* loaded from: classes.dex */
public class NotificationServiceOld extends AccessibilityService {
    private static final String TAG = "MADA_APP";
    private final AccessibilityServiceInfo info = new AccessibilityServiceInfo();

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

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Resources resources;
        String exc;
        if (accessibilityEvent.getEventType() != 64) {
            Log.v(TAG, "Got un-handled Event");
            return;
        }
        String str = (String) accessibilityEvent.getPackageName();
        if (accessibilityEvent.getParcelableData() instanceof Notification) {
            Notification notification = (Notification) accessibilityEvent.getParcelableData();
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
            if (resources == null) {
                return;
            }
            int identifier = resources.getIdentifier("android:id/title", null, null);
            int identifier2 = resources.getIdentifier("android:id/big_text", null, null);
            String charSequence2 = ((TextView) viewGroup.findViewById(identifier)).getText().toString();
            String charSequence3 = ((TextView) viewGroup.findViewById(identifier2)).getText().toString();
            if (Boolean.valueOf(getSharedPreferences("Settings", 0).getBoolean("Mapp", false)).booleanValue()) {
                try {
                    Intent intent = new Intent(TAG);
                    intent.putExtra("pack", str);
                    intent.putExtra("text", charSequence3);
                    intent.putExtra("tick", charSequence);
                    if (charSequence2.contains("אירוע")) {
                        if (!charSequence3.contains("אירוע חדש")) {
                            if (charSequence3.contains("הודעת קבוצת")) {
                                intent.putExtra("callT", 2);
                            } else if (charSequence3.contains("הודעת צוות")) {
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

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        AccessibilityServiceInfo accessibilityServiceInfo = this.info;
        accessibilityServiceInfo.eventTypes = 64;
        accessibilityServiceInfo.packageNames = new String[]{"com.groboot.mdaemergency"};
        accessibilityServiceInfo.feedbackType = Build.VERSION.SDK_INT >= 14 ? -1 : 16;
        AccessibilityServiceInfo accessibilityServiceInfo2 = this.info;
        accessibilityServiceInfo2.notificationTimeout = 100L;
        setServiceInfo(accessibilityServiceInfo2);
    }
}
