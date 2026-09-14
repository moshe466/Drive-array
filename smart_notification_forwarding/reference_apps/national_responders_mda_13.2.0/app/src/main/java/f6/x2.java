package f6;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.groboot.mdaemergency.ui.VideoActivity;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class x2 implements MediaPlayer.OnPreparedListener, View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    Activity f9627f;

    /* renamed from: g, reason: collision with root package name */
    View f9628g;

    /* renamed from: h, reason: collision with root package name */
    VideoView f9629h;

    /* renamed from: i, reason: collision with root package name */
    ProgressBar f9630i;

    /* renamed from: j, reason: collision with root package name */
    Button f9631j;

    /* renamed from: k, reason: collision with root package name */
    RelativeLayout f9632k;

    /* renamed from: l, reason: collision with root package name */
    ImageView f9633l;

    /* renamed from: m, reason: collision with root package name */
    TextView f9634m;

    /* renamed from: n, reason: collision with root package name */
    TextView f9635n;

    /* renamed from: o, reason: collision with root package name */
    boolean f9636o;

    /* renamed from: p, reason: collision with root package name */
    AnimationDrawable f9637p;

    /* renamed from: q, reason: collision with root package name */
    protected PowerManager.WakeLock f9638q;

    /* renamed from: r, reason: collision with root package name */
    String f9639r;

    /* renamed from: s, reason: collision with root package name */
    String f9640s;

    /* renamed from: t, reason: collision with root package name */
    int f9641t;

    /* renamed from: u, reason: collision with root package name */
    int f9642u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements MediaPlayer.OnErrorListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            x2 x2Var = x2.this;
            int i12 = x2Var.f9642u;
            if (i12 >= 3) {
                return false;
            }
            x2Var.f9641t = 15;
            x2Var.f9642u = i12 + 1;
            x2Var.d();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x2.this.f9635n.setText(x2.this.f9641t + " ");
            }
        }

        /* renamed from: f6.x2$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0165b implements Runnable {
            RunnableC0165b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x2.this.d();
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x2 x2Var;
            while (true) {
                x2Var = x2.this;
                if (!x2Var.f9636o || x2Var.f9641t <= 0) {
                    break;
                }
                x2Var.f9635n.post(new a());
                w6.d0.a(1000L);
                x2 x2Var2 = x2.this;
                x2Var2.f9641t--;
            }
            x2Var.f9637p.stop();
            x2 x2Var3 = x2.this;
            if (x2Var3.f9636o) {
                x2Var3.f9627f.runOnUiThread(new RunnableC0165b());
            }
        }
    }

    public x2(Activity activity, View view) {
        this.f9628g = view;
        this.f9627f = activity;
        this.f9629h = (VideoView) view.findViewById(R.id.vv1);
        this.f9630i = (ProgressBar) view.findViewById(R.id.pb1);
        this.f9631j = (Button) view.findViewById(R.id.btn_fullScreen);
        this.f9632k = (RelativeLayout) view.findViewById(R.id.rl_wait);
        this.f9633l = (ImageView) view.findViewById(R.id.iv_wait_anim);
        this.f9634m = (TextView) view.findViewById(R.id.tv_wait_text);
        this.f9635n = (TextView) view.findViewById(R.id.tv_wait_sec);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_wait_anim);
        this.f9633l = imageView;
        imageView.setBackgroundResource(R.drawable.camera_anim);
        this.f9637p = (AnimationDrawable) this.f9633l.getBackground();
        this.f9629h.setOnPreparedListener(this);
        this.f9631j.setOnClickListener(this);
    }

    private void b() {
        PowerManager.WakeLock newWakeLock = ((PowerManager) this.f9627f.getSystemService("power")).newWakeLock(6, "MADAVideoLayout");
        this.f9638q = newWakeLock;
        newWakeLock.acquire();
    }

    private void e() {
        new Thread(new b()).start();
    }

    public void a() {
        this.f9636o = false;
        this.f9629h.stopPlayback();
    }

    public void c(String str, String str2, int i10) {
        this.f9639r = str;
        this.f9640s = str2;
        this.f9641t = i10;
        this.f9642u = 0;
    }

    public void d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("url:");
        sb2.append(this.f9639r);
        this.f9630i.setVisibility(0);
        this.f9631j.setVisibility(8);
        b();
        if (this.f9641t > 0) {
            this.f9636o = true;
            this.f9632k.setVisibility(0);
            this.f9637p.start();
            e();
            return;
        }
        this.f9632k.setVisibility(8);
        MediaController mediaController = new MediaController(this.f9627f);
        mediaController.setAnchorView(this.f9629h);
        this.f9629h.setOnErrorListener(new a());
        this.f9629h.setMediaController(mediaController);
        this.f9629h.setVideoURI(Uri.parse(this.f9639r));
        this.f9629h.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoActivity.a(this.f9627f, this.f9639r, this.f9640s);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f9630i.setVisibility(8);
        this.f9631j.setVisibility(0);
    }
}
