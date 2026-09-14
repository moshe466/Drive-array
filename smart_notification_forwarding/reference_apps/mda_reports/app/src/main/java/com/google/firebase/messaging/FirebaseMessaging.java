package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";

    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    static TransportFactory a;
    private static final Pattern zzb = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private final Context zzc;
    private final FirebaseInstanceId zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, TransportFactory transportFactory) {
        this.zzc = firebaseApp.getApplicationContext();
        a = transportFactory;
        this.zzd = firebaseInstanceId;
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(FirebaseApp.getInstance());
        }
        return firebaseMessaging;
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
        }
        return firebaseMessaging;
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return zzo.a();
    }

    public boolean isAutoInitEnabled() {
        return this.zzd.zzh();
    }

    public void send(@NonNull RemoteMessage remoteMessage) {
        if (TextUtils.isEmpty(remoteMessage.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra(SettingsJsonConstants.APP_KEY, PendingIntent.getBroadcast(this.zzc, 0, intent2, 0));
        intent.setPackage("com.google.android.gms");
        intent.putExtras(remoteMessage.a);
        this.zzc.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void setAutoInitEnabled(boolean z) {
        this.zzd.zzb(z);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        zzo.a(z);
    }

    @NonNull
    public Task<Void> subscribeToTopic(@NonNull String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            str = str.substring(8);
        }
        if (str != null && zzb.matcher(str).matches()) {
            FirebaseInstanceId firebaseInstanceId = this.zzd;
            String valueOf = String.valueOf(str);
            return firebaseInstanceId.zza(valueOf.length() != 0 ? "S!".concat(valueOf) : new String("S!"));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
        sb.append("Invalid topic name: ");
        sb.append(str);
        sb.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
        throw new IllegalArgumentException(sb.toString());
    }

    @NonNull
    public Task<Void> unsubscribeFromTopic(@NonNull String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in unsubscribeFromTopic.");
            str = str.substring(8);
        }
        if (str != null && zzb.matcher(str).matches()) {
            FirebaseInstanceId firebaseInstanceId = this.zzd;
            String valueOf = String.valueOf(str);
            return firebaseInstanceId.zza(valueOf.length() != 0 ? "U!".concat(valueOf) : new String("U!"));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
        sb.append("Invalid topic name: ");
        sb.append(str);
        sb.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
        throw new IllegalArgumentException(sb.toString());
    }
}
