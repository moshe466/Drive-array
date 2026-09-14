package atlow.chemi.mymada.recieversAndServices;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.graphics.Color;
import android.media.AudioManager;
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
    private Metronome metronome;
    private Thread metroThread;
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

    private void ensureNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null && notificationManager.getNotificationChannel("runInBg") == null) {
                NotificationChannel notificationChannel = new NotificationChannel("runInBg", "פעילות ברקע", NotificationManager.IMPORTANCE_LOW);
                notificationChannel.enableVibration(false);
                notificationChannel.enableLights(false);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private synchronized void metro(Context context) {
        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (this.audioManager != null) {
            try {
                int streamMaxVolume = this.audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                this.currentVolume = this.audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                vo = this.currentVolume;
                this.audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, streamMaxVolume, 0);
            } catch (Exception ignored) {
            }
        }

        if (this.metronome != null) {
            this.metronome.stop();
        }
        if (this.metroThread != null && this.metroThread.isAlive()) {
            this.metroThread.interrupt();
        }

        this.metronome = new Metronome();
        this.metroThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (MetroService.this.metronome != null) {
                        MetroService.this.metronome.play();
                    }
                } catch (Exception e) {
                    Crashlytics.logException(e);
                }
            }
        }, "MetroPlayThread");
        this.metroThread.start();
    }

    public synchronized void metroStop() {
        Iterator<MetronomeEventCallback> it = this.MetronomeStopEvent.listeners().iterator();
        while (it.hasNext()) {
            it.next().metronomeEventHandler(0L);
        }
        running = false;
        if (this.metronome != null) {
            try {
                this.metronome.stop();
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
            this.metronome = null;
        }
        if (this.metroThread != null) {
            this.metroThread.interrupt();
            this.metroThread = null;
        }
        if (this.audioManager != null) {
            try {
                this.audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, this.currentVolume, 0);
            } catch (Exception ignored) {
            }
        }
        MyTileService.updateTileState(this);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.serviceBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ensureNotificationChannel();
    }

    @Override // android.app.Service
    public void onDestroy() {
        metroStop();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ensureNotificationChannel();
        Intent intent2 = new Intent(this, (Class<?>) UtillitiesAndTools.class);
        intent2.putExtra("running", true);
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent activity = PendingIntent.getActivity(this, 7, intent2, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        
        Intent intent3 = new Intent(this, (Class<?>) ActionReceiver.class);
        intent3.putExtra("action", "stopM");
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 9, intent3, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        
        String string = getResources().getString(R.string.MetroStop);
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(this, "runInBg")
                .setContentTitle(getResources().getString(R.string.MetroServiceTtl))
                .setContentText(getResources().getString(R.string.MetroServiceTxt))
                .setContentIntent(activity)
                .setSmallIcon(R.drawable.ic_tile_heart_metronome)
                .setShowWhen(false)
                .setColor(Color.argb(50, 255, 57, 50))
                .addAction(R.drawable.ic_close, string, broadcast)
                .setSound(null)
                .setVibrate(null)
                .setOngoing(true);

        if (Build.VERSION.SDK_INT >= 24) {
            ongoing.setPriority(NotificationCompat.PRIORITY_LOW);
        }
        Notification build = ongoing.build();

        try {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(13, build, ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK);
            } else {
                startForeground(13, build);
            }
        } catch (Exception e) {
            Crashlytics.logException(e);
        }

        this.timestamp = System.currentTimeMillis();
        Iterator<MetronomeEventCallback> it = this.MetronomeStartEvent.listeners().iterator();
        while (it.hasNext()) {
            it.next().metronomeEventHandler(this.timestamp);
        }
        metro(this);
        running = true;
        MyTileService.updateTileState(this);
        return START_STICKY;
    }
}
