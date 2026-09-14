package com.groboot.mdaemergency.ui;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class VideoActivity extends Activity implements MediaPlayer.OnPreparedListener {

    /* renamed from: f, reason: collision with root package name */
    String f8083f;

    /* renamed from: g, reason: collision with root package name */
    String f8084g;

    /* renamed from: h, reason: collision with root package name */
    TextView f8085h;

    /* renamed from: i, reason: collision with root package name */
    VideoView f8086i;

    /* renamed from: j, reason: collision with root package name */
    ProgressBar f8087j;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoActivity.this.finish();
        }
    }

    public static void a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) VideoActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        activity.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_video);
        VideoView videoView = (VideoView) findViewById(R.id.vv1);
        this.f8086i = videoView;
        videoView.setOnPreparedListener(this);
        this.f8087j = (ProgressBar) findViewById(R.id.pb1);
        this.f8085h = (TextView) findViewById(R.id.title);
        findViewById(R.id.close).setOnClickListener(new a());
        this.f8083f = getIntent().getStringExtra("url");
        String stringExtra = getIntent().getStringExtra("title");
        this.f8084g = stringExtra;
        this.f8085h.setText(stringExtra);
        this.f8087j.setVisibility(0);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(this.f8086i);
        this.f8086i.setMediaController(mediaController);
        this.f8086i.setVideoURI(Uri.parse(this.f8083f));
        this.f8086i.requestFocus();
        this.f8086i.start();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f8086i.stopPlayback();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f8087j.setVisibility(8);
    }
}
