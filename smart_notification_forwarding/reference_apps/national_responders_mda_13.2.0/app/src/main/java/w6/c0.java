package w6;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<MediaPlayer> f15119a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    static Context f15120b;

    /* renamed from: c, reason: collision with root package name */
    private static MediaPlayer f15121c;

    /* renamed from: d, reason: collision with root package name */
    private static g f15122d;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15123f;

        a(String str) {
            this.f15123f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.e(this.f15123f);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AsyncTask<String, String, String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f15124f;

            /* renamed from: w6.c0$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0324a implements MediaPlayer.OnCompletionListener {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ AudioManager f15125f;

                C0324a(a aVar, AudioManager audioManager) {
                    this.f15125f = audioManager;
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    c0.f15119a.remove(mediaPlayer);
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    this.f15125f.setStreamMute(3, false);
                    if (c0.f15122d != null) {
                        c0.f15122d.b();
                    }
                }
            }

            a(b bVar, String str) {
                this.f15124f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AudioManager audioManager = (AudioManager) c0.f15120b.getSystemService("audio");
                    MediaPlayer unused = c0.f15121c = new MediaPlayer();
                    c0.f15121c.setDataSource(this.f15124f);
                    c0.f15121c.setAudioStreamType(5);
                    c0.f15121c.prepare();
                    c0.f15121c.setOnCompletionListener(new C0324a(this, audioManager));
                    audioManager.setStreamMute(3, true);
                    c0.f15119a.add(c0.f15121c);
                    c0.f15121c.start();
                } catch (Exception unused2) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            new Thread(new a(this, strArr[0])).start();
            return "";
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static void e(String str) {
        String str2 = "https://m.mda.org.il:20888/synth?key=2BAEE1F3-4C96-4515-9516-4EA7AA2602D2&cid=3587362041478071&voice=Kolfix+Sivan%2022kHz&sampling=8000&encoding=u-law&rate=0&text=" + str.replace(" ", "%20");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("play : ");
        sb2.append(str2);
        g(str2);
    }

    public static void f(Context context, String str, String str2, g gVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("play text : ");
        sb2.append(str);
        f15120b = context;
        f15122d = gVar;
        if (str2 == null || str2.isEmpty()) {
            e(str);
            return;
        }
        if (f15120b.getResources().getIdentifier(str2, "raw", f15120b.getPackageName()) == 0) {
            e(str);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new a(str), MediaPlayer.create(f15120b, r2).getDuration() + TimeUnit.SECONDS.toMillis(1L));
        }
    }

    public static void g(String str) {
        new b().doInBackground(str);
    }
}
