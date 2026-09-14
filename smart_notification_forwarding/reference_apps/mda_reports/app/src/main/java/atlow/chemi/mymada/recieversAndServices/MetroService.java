package atlow.chemi.mymada.recieversAndServices;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.UtillitiesAndTools;
import atlow.chemi.mymada.classes.Metronome;
import atlow.chemi.mymada.helpers.Event;
import atlow.chemi.mymada.helpers.MetronomeEventCallback;
import com.crashlytics.android.Crashlytics;
import java.util.Iterator;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class MetroService extends Service {
    public static boolean running = false;
    public static float vo;
    private AudioManager audioManager;
    private int currentVolume;
    private MetronomeAsyncTask metroTask;
    public long timestamp;
    public Event<MetronomeEventCallback> MetronomeStartEvent = new Event<>();
    public Event<MetronomeEventCallback> MetronomeStopEvent = new Event<>();
    private IBinder serviceBinder = new MetroBinder();

    /* loaded from: classes.dex */
    public class MetroBinder extends Binder {
        public MetroBinder() {
        }

        public MetroService getService() {
            return MetroService.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MetronomeAsyncTask extends AsyncTask<Void, Void, String> {
        Metronome a = new Metronome();

        MetronomeAsyncTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            try {
                this.a.play();
                return null;
            } catch (Exception e) {
                Crashlytics.logException(e);
                e.printStackTrace();
                return null;
            }
        }

        void a() {
            this.a.stop();
            this.a = null;
        }
    }

    private void metro(Context context) {
        this.audioManager = (AudioManager) context.getSystemService("audio");
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(4);
            this.currentVolume = this.audioManager.getStreamVolume(4);
            vo = this.audioManager.getStreamVolume(4);
            this.audioManager.setStreamVolume(4, streamMaxVolume, 0);
        }
        try {
            this.metroTask = new MetronomeAsyncTask();
            this.metroTask.execute(new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void metroStop() {
        Iterator<MetronomeEventCallback> it = this.MetronomeStopEvent.listeners().iterator();
        while (it.hasNext()) {
            it.next().metronomeEventHandler(0L);
        }
        running = false;
        try {
            this.metroTask.a();
        } catch (NullPointerException e) {
            Crashlytics.log("failed stopping metronome");
            Crashlytics.logException(e);
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.setStreamVolume(4, this.currentVolume, 0);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.serviceBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        metroStop();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Intent intent2 = new Intent(this, (Class<?>) UtillitiesAndTools.class);
        intent2.putExtra("running", true);
        intent2.setFlags(268468224);
        PendingIntent activity = PendingIntent.getActivity(this, 7, intent2, 0);
        Intent intent3 = new Intent(this, (Class<?>) ActionReceiver.class);
        intent3.putExtra("action", "stopM");
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 9, intent3, 134217728);
        String string = getResources().getString(R.string.MetroStop);
        Crashlytics.log("Starting Metro Notification");
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(this, "runInBg").setContentTitle(getResources().getString(R.string.MetroServiceTtl)).setContentText(getResources().getString(R.string.MetroServiceTxt)).setContentIntent(activity).setSmallIcon(R.drawable.ic_metronome_tile).setShowWhen(false).setColor(Color.argb(50, 255, 57, 50)).addAction(R.drawable.ic_close, string, broadcast).setSound(null).setVibrate(null).setOngoing(true);
        if (Build.VERSION.SDK_INT >= 24) {
            ongoing.setPriority(1);
        }
        Notification build = ongoing.build();
        Crashlytics.log("built Metro Notification.");
        startForeground(13, build);
        Crashlytics.log("started Metro service foreground.");
        this.timestamp = System.currentTimeMillis();
        Iterator<MetronomeEventCallback> it = this.MetronomeStartEvent.listeners().iterator();
        while (it.hasNext()) {
            it.next().metronomeEventHandler(this.timestamp);
        }
        metro(this);
        running = true;
        return 1;
    }
}
