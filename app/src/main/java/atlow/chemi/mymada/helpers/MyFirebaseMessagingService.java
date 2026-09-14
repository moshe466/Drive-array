package atlow.chemi.mymada.helpers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.codeC;
import atlow.chemi.mymada.contactChatActivity;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.primitives.Ints;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* loaded from: classes.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    private static String token;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, Task task) {
        try {
            if (task != null && task.isSuccessful() && task.getResult() != null) {
                Object res = task.getResult();
                String tokenStr = "";
                if (res instanceof InstanceIdResult) {
                    tokenStr = ((InstanceIdResult) res).getToken();
                } else if (res instanceof String) {
                    tokenStr = (String) res;
                }
                if (tokenStr != null && !tokenStr.isEmpty() && context != null) {
                    context.getSharedPreferences("Settings", 0).edit().putString("fcm", tokenStr).apply();
                }
            } else if (task != null && task.getException() != null) {
                Crashlytics.log("didn't succeed getting token: " + task.getException().getMessage());
            }
        } catch (Throwable t) {
            Crashlytics.log("Exception getting fcm token: " + t.getMessage());
        }
    }

    public static void getToken(final Context context) {
        try {
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener() { // from class: atlow.chemi.mymada.helpers.a
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    MyFirebaseMessagingService.a(context, task);
                }
            });
        } catch (Throwable t) {
            Crashlytics.log("Failed to start getToken: " + t.getMessage());
        }
    }

    private void sendNotification(int i, String str, String str2, String str3) {
        RingtoneManager.getDefaultUri(2);
        NotificationCompat.Builder style = new NotificationCompat.Builder(getApplicationContext(), "Push").setContentTitle("בקשת קוד חדשה!").setContentText(str2).setSmallIcon(R.drawable.ic_siren).setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.mipmap.ic_launcher)).setContentIntent(null).setAutoCancel(true).addAction(R.drawable.ic_edit, "אשר קוד", null).setTicker("בקשה חדשה לקוד הפעלה!").setStyle(new NotificationCompat.BigTextStyle().bigText(str));
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify((int) System.currentTimeMillis(), style.build());
        }
    }

    private void sendNotification(String str, String str2) {
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this, "Push").setSmallIcon(R.drawable.ic_siren).setContentTitle("הודעה חדשה!").setContentText(str2).setStyle(new NotificationCompat.BigTextStyle().bigText(str).setSummaryText("לחץ כאן להפעלת הקוד")).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(null);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify((int) System.currentTimeMillis(), contentIntent.build());
        }
    }

    private void sendNotification(String str, String str2, int i) {
        Intent intent = new Intent(this, (Class<?>) codeC.class);
        intent.putExtra("code", str);
        intent.putExtra("fireKey", str2);
        intent.putExtra("toCode", true);
        Log.d("KEYERR", "the key is: " + str2);
        intent.addFlags(268435456);
        intent.addFlags(Ints.MAX_POWER_OF_TWO);
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this, "Push").setSmallIcon(R.drawable.ic_siren).setContentTitle("קוד ההפעלה אושר").setContentText("קוד ההפעלה שלך הינו: " + str).setStyle(new NotificationCompat.BigTextStyle().bigText("קוד ההפעלה שלך הינו: " + str).setSummaryText("לחץ כאן להפעלת הקוד")).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE));
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        int parseInt = Integer.parseInt(str.replaceAll("[\\D]", ""));
        if (notificationManager != null) {
            notificationManager.notify(parseInt, contentIntent.build());
        }
    }

    private void sendToChat(String str, String str2) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) contactChatActivity.class);
        intent.addFlags(604012544);
        ((NotificationManager) getSystemService("notification")).notify((int) System.currentTimeMillis(), new NotificationCompat.Builder(getApplicationContext(), "Push").setContentTitle("הודעת צ'אט חדשה!").setContentText("הודעה חדשה מאת ההנהלה").setSmallIcon(R.drawable.ic_siren).setDefaults(-1).setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.mipmap.ic_launcher)).setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE)).setAutoCancel(true).setTicker("הודעה חדשה מאת ההנהלה").setStyle(new NotificationCompat.BigTextStyle().bigText(str)).build());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str = remoteMessage.getData().get("type");
        String str2 = remoteMessage.getData().get("code");
        String str3 = remoteMessage.getData().get("key");
        String str4 = remoteMessage.getData().get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        String str5 = remoteMessage.getData().get(NotificationCompat.CATEGORY_MESSAGE);
        String str6 = remoteMessage.getData().get(SettingsJsonConstants.PROMPT_TITLE_KEY);
        if (str != null && str.equals("newChat")) {
            sendToChat(str5, str4);
            return;
        }
        if (str != null && str.equals("newC")) {
            sendNotification(1, str5, str6, str2);
            return;
        }
        if (str2.length() > 0) {
            sendNotification(str2, str3, 5);
        } else {
            if (str5.length() <= 0 || str6.length() <= 0) {
                return;
            }
            sendNotification(str5, str6);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        getSharedPreferences("Settings", 0).edit().putString("fcm", str).apply();
    }
}
