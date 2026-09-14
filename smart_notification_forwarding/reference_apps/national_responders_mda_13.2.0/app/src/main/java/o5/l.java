package o5;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/* loaded from: classes.dex */
public class l extends Service implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {

    /* renamed from: g, reason: collision with root package name */
    static boolean f12507g;

    /* renamed from: h, reason: collision with root package name */
    static boolean f12508h;

    /* renamed from: i, reason: collision with root package name */
    static int f12509i;

    /* renamed from: f, reason: collision with root package name */
    MediaPlayer f12510f;

    private String a(int i10) {
        return getResources().getResourceEntryName(i10);
    }

    public static void c(Context context) {
        if (f12508h) {
            context.stopService(new Intent(context, (Class<?>) l.class));
        }
    }

    public void b() {
        int i10 = f12509i;
        if (i10 < 1) {
            return;
        }
        MediaPlayer create = MediaPlayer.create(this, i10);
        this.f12510f = create;
        create.setOnCompletionListener(this);
        this.f12510f.setOnErrorListener(this);
        this.f12510f.setOnPreparedListener(this);
        this.f12510f.setLooping(f12507g);
        this.f12510f.start();
        f12508h = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("play :");
        sb2.append(a(f12509i));
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f12510f;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f12510f.release();
            this.f12510f = null;
            f12508h = false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Notification a10 = v5.a.a(getApplicationContext());
        if (a10 != null) {
            startForeground(v5.a.f14661a, a10);
        }
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 1;
    }
}
