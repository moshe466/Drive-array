package atlow.chemi.mymada.recieversAndServices;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import atlow.chemi.mymada.MokedPage;
import atlow.chemi.mymada.R;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.gass.AdShield2Logger;
import java.io.IOException;

/* loaded from: classes.dex */
public class FloatingWidgetService extends Service implements View.OnClickListener {
    public static float vo;
    private boolean ShabbatM;
    private AudioManager am;
    private View collapsedView;
    private int currentVolume;
    private View expandedView;
    private boolean loop;
    private View mFloatingWidgetView;
    private MediaPlayer mMediaPlayer;
    private WindowManager mWindowManager;
    private View removeFloatingWidgetView;
    private ImageView remove_image_view;
    private boolean sou;
    private Point szWindow = new Point();
    private String timeK;
    private Uri url;
    private boolean vib;
    private Vibrator vibe;
    private int x_init_cord;
    private int x_init_margin;
    private int y_init_cord;
    private int y_init_margin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: atlow.chemi.mymada.recieversAndServices.FloatingWidgetService$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements View.OnTouchListener {
        long a = 0;
        long b = 0;
        boolean c = false;
        boolean d = false;
        int e = 0;
        int f = 0;
        Handler g = new Handler();
        Runnable h = new Runnable() { // from class: atlow.chemi.mymada.recieversAndServices.FloatingWidgetService.1.1
            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                anonymousClass1.c = true;
                FloatingWidgetService.this.removeFloatingWidgetView.setVisibility(0);
                FloatingWidgetService.this.onFloatingWidgetLongClick();
            }
        };

        AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) FloatingWidgetService.this.removeFloatingWidgetView.getLayoutParams();
            int width = (FloatingWidgetService.this.szWindow.x - FloatingWidgetService.this.remove_image_view.getWidth()) / 2;
            int height = FloatingWidgetService.this.szWindow.y - (FloatingWidgetService.this.removeFloatingWidgetView.getHeight() + FloatingWidgetService.this.getStatusBarHeight());
            layoutParams.x = width;
            layoutParams.y = height;
            FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.removeFloatingWidgetView, layoutParams);
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) FloatingWidgetService.this.mFloatingWidgetView.getLayoutParams();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = System.currentTimeMillis();
                this.g.postDelayed(this.h, 600L);
                this.e = FloatingWidgetService.this.remove_image_view.getLayoutParams().width;
                this.f = FloatingWidgetService.this.remove_image_view.getLayoutParams().height;
                FloatingWidgetService.this.x_init_cord = rawX;
                FloatingWidgetService.this.y_init_cord = rawY;
                FloatingWidgetService.this.x_init_margin = layoutParams2.x;
                FloatingWidgetService.this.y_init_margin = layoutParams2.y;
                return true;
            }
            if (action == 1) {
                this.c = false;
                FloatingWidgetService.this.removeFloatingWidgetView.setVisibility(8);
                FloatingWidgetService.this.remove_image_view.getLayoutParams().height = this.f;
                FloatingWidgetService.this.remove_image_view.getLayoutParams().width = this.e;
                this.g.removeCallbacks(this.h);
                if (!this.d) {
                    int i = rawX - FloatingWidgetService.this.x_init_cord;
                    int i2 = rawY - FloatingWidgetService.this.y_init_cord;
                    if (Math.abs(i) < 20 && Math.abs(i2) < 20) {
                        this.b = System.currentTimeMillis();
                        if (this.b - this.a < 300) {
                            FloatingWidgetService.this.onFloatingWidgetClick();
                        }
                    }
                    int i3 = FloatingWidgetService.this.y_init_margin + i2;
                    int statusBarHeight = FloatingWidgetService.this.getStatusBarHeight();
                    if (i3 < 0) {
                        i3 = 0;
                    } else if (FloatingWidgetService.this.mFloatingWidgetView.getHeight() + statusBarHeight + i3 > FloatingWidgetService.this.szWindow.y) {
                        i3 = FloatingWidgetService.this.szWindow.y - (FloatingWidgetService.this.mFloatingWidgetView.getHeight() + statusBarHeight);
                    }
                    layoutParams2.y = i3;
                    this.d = false;
                    FloatingWidgetService.this.resetPosition(rawX);
                    return true;
                }
                FloatingWidgetService.this.stopSelf();
                this.d = false;
            } else if (action == 2) {
                int i4 = rawX - FloatingWidgetService.this.x_init_cord;
                int i5 = rawY - FloatingWidgetService.this.y_init_cord;
                int i6 = FloatingWidgetService.this.x_init_margin + i4;
                int i7 = FloatingWidgetService.this.y_init_margin + i5;
                if (this.c) {
                    int i8 = FloatingWidgetService.this.szWindow.x / 2;
                    double d = this.e;
                    Double.isNaN(d);
                    int i9 = i8 - ((int) (d * 1.5d));
                    int i10 = FloatingWidgetService.this.szWindow.x / 2;
                    double d2 = this.e;
                    Double.isNaN(d2);
                    int i11 = i10 + ((int) (d2 * 1.5d));
                    int i12 = FloatingWidgetService.this.szWindow.y;
                    double d3 = this.f;
                    Double.isNaN(d3);
                    int i13 = i12 - ((int) (d3 * 1.5d));
                    if (rawX < i9 || rawX > i11 || rawY < i13) {
                        this.d = false;
                        FloatingWidgetService.this.remove_image_view.getLayoutParams().height = this.f;
                        FloatingWidgetService.this.remove_image_view.getLayoutParams().width = this.e;
                    } else {
                        this.d = true;
                        double d4 = FloatingWidgetService.this.szWindow.x;
                        double d5 = this.f;
                        Double.isNaN(d5);
                        Double.isNaN(d4);
                        int i14 = (int) ((d4 - (d5 * 1.5d)) / 2.0d);
                        double d6 = FloatingWidgetService.this.szWindow.y;
                        double d7 = this.e;
                        Double.isNaN(d7);
                        double statusBarHeight2 = FloatingWidgetService.this.getStatusBarHeight();
                        Double.isNaN(statusBarHeight2);
                        Double.isNaN(d6);
                        int i15 = (int) (d6 - ((d7 * 1.5d) + statusBarHeight2));
                        if (FloatingWidgetService.this.remove_image_view.getLayoutParams().height == this.f) {
                            ViewGroup.LayoutParams layoutParams3 = FloatingWidgetService.this.remove_image_view.getLayoutParams();
                            double d8 = this.f;
                            Double.isNaN(d8);
                            layoutParams3.height = (int) (d8 * 1.5d);
                            ViewGroup.LayoutParams layoutParams4 = FloatingWidgetService.this.remove_image_view.getLayoutParams();
                            double d9 = this.e;
                            Double.isNaN(d9);
                            layoutParams4.width = (int) (d9 * 1.5d);
                            WindowManager.LayoutParams layoutParams5 = (WindowManager.LayoutParams) FloatingWidgetService.this.removeFloatingWidgetView.getLayoutParams();
                            layoutParams5.x = i14;
                            layoutParams5.y = i15;
                            FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.removeFloatingWidgetView, layoutParams5);
                        }
                        layoutParams2.x = i14 + (Math.abs(FloatingWidgetService.this.removeFloatingWidgetView.getWidth() - FloatingWidgetService.this.mFloatingWidgetView.getWidth()) / 2);
                        layoutParams2.y = i15 + (Math.abs(FloatingWidgetService.this.removeFloatingWidgetView.getHeight() - FloatingWidgetService.this.mFloatingWidgetView.getHeight()) / 2);
                        FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.mFloatingWidgetView, layoutParams2);
                    }
                }
                layoutParams2.x = i6;
                layoutParams2.y = i7;
                FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.mFloatingWidgetView, layoutParams2);
                return true;
            }
            return false;
        }
    }

    @SuppressLint({"InflateParams", "RtlHardcoded"})
    private void addFloatingWidgetView(LayoutInflater layoutInflater) {
        this.mFloatingWidgetView = layoutInflater.inflate(R.layout.floating_widget_layout, (ViewGroup) null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT >= 26 ? 2038 : AdShield2Logger.EVENTID_VM_INIT_PROGRAM_EXCEPTION, 8, -3);
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 100;
        this.mWindowManager.addView(this.mFloatingWidgetView, layoutParams);
        this.collapsedView = this.mFloatingWidgetView.findViewById(R.id.collapse_view);
        this.expandedView = this.mFloatingWidgetView.findViewById(R.id.expanded_container);
    }

    @SuppressLint({"InflateParams", "RtlHardcoded"})
    private void addRemoveView(LayoutInflater layoutInflater) {
        this.removeFloatingWidgetView = layoutInflater.inflate(R.layout.remove_floating_widget_layout, (ViewGroup) null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT >= 26 ? 2038 : AdShield2Logger.EVENTID_VM_INIT_PROGRAM_EXCEPTION, 262664, -3);
        layoutParams.gravity = 8388661;
        this.removeFloatingWidgetView.setVisibility(8);
        this.remove_image_view = (ImageView) this.removeFloatingWidgetView.findViewById(R.id.remove_img);
        this.mWindowManager.addView(this.removeFloatingWidgetView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double bounceValue(long j, long j2) {
        double d = j2;
        double d2 = j;
        Double.isNaN(d2);
        double exp = Math.exp((-0.055d) * d2);
        Double.isNaN(d);
        Double.isNaN(d2);
        return d * exp * Math.cos(d2 * 0.08d);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doNotification() {
        /*
            r5 = this;
            r0 = 11
            long[] r0 = new long[r0]
            r0 = {x0048: FILL_ARRAY_DATA , data: [0, 900, 200, 900, 200, 900, 200, 900, 200, 900, 200} // fill-array
            boolean r1 = r5.vib
            if (r1 == 0) goto L13
            boolean r1 = r5.loop
            if (r1 != 0) goto L13
            android.os.Vibrator r1 = r5.vibe
            r2 = -1
            goto L1a
        L13:
            boolean r1 = r5.vib
            if (r1 == 0) goto L1d
            android.os.Vibrator r1 = r5.vibe
            r2 = 0
        L1a:
            r1.vibrate(r0, r2)
        L1d:
            boolean r0 = r5.sou
            if (r0 == 0) goto L2c
            android.content.Context r0 = r5.getApplicationContext()
            android.net.Uri r1 = r5.url
            boolean r2 = r5.loop
            r5.playSound(r0, r1, r2)
        L2c:
            boolean r0 = r5.ShabbatM
            if (r0 == 0) goto L46
            java.lang.String r0 = r5.timeK
            int r0 = java.lang.Integer.parseInt(r0)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            atlow.chemi.mymada.recieversAndServices.a r2 = new atlow.chemi.mymada.recieversAndServices.a
            r2.<init>()
            int r0 = r0 * 1000
            long r3 = (long) r0
            r1.postDelayed(r2, r3)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.recieversAndServices.FloatingWidgetService.doNotification():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStatusBarHeight() {
        return (int) Math.ceil(getApplicationContext().getResources().getDisplayMetrics().density * 25.0f);
    }

    private void getWindowManagerDefaultDisplay() {
        this.mWindowManager.getDefaultDisplay().getSize(this.szWindow);
    }

    private void implementClickListeners() {
        this.mFloatingWidgetView.findViewById(R.id.close_floating_view).setOnClickListener(this);
        this.mFloatingWidgetView.findViewById(R.id.close_expanded_view).setOnClickListener(this);
        this.mFloatingWidgetView.findViewById(R.id.open_activity_button).setOnClickListener(this);
    }

    private void implementTouchListenerToFloatingWidgetView() {
        this.mFloatingWidgetView.findViewById(R.id.root_container).setOnTouchListener(new AnonymousClass1());
    }

    private boolean isViewCollapsed() {
        View view = this.mFloatingWidgetView;
        return view == null || view.findViewById(R.id.collapse_view).getVisibility() == 0;
    }

    private void moveToLeft(int i) {
        final int i2 = this.szWindow.x - i;
        new CountDownTimer(500L, 5L) { // from class: atlow.chemi.mymada.recieversAndServices.FloatingWidgetService.2
            WindowManager.LayoutParams a;

            {
                this.a = (WindowManager.LayoutParams) FloatingWidgetService.this.mFloatingWidgetView.getLayoutParams();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.a.x = 0;
                if (FloatingWidgetService.this.mWindowManager != null) {
                    try {
                        FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.mFloatingWidgetView, this.a);
                    } catch (Exception e) {
                        Crashlytics.log("probably the floating closed");
                        Crashlytics.logException(e);
                    }
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                this.a.x = 0 - ((int) FloatingWidgetService.this.bounceValue((500 - j) / 5, i2));
                if (FloatingWidgetService.this.mWindowManager != null) {
                    try {
                        FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.mFloatingWidgetView, this.a);
                    } catch (Exception e) {
                        Crashlytics.log("probably the floating closed");
                        Crashlytics.logException(e);
                    }
                }
            }
        }.start();
    }

    private void moveToRight(final int i) {
        new CountDownTimer(500L, 5L) { // from class: atlow.chemi.mymada.recieversAndServices.FloatingWidgetService.3
            WindowManager.LayoutParams a;

            {
                this.a = (WindowManager.LayoutParams) FloatingWidgetService.this.mFloatingWidgetView.getLayoutParams();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.a.x = FloatingWidgetService.this.szWindow.x - FloatingWidgetService.this.mFloatingWidgetView.getWidth();
                try {
                    FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.mFloatingWidgetView, this.a);
                } catch (Exception e) {
                    Crashlytics.log("probably the floating closed");
                    Crashlytics.logException(e);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                this.a.x = (FloatingWidgetService.this.szWindow.x + ((int) FloatingWidgetService.this.bounceValue((500 - j) / 5, i))) - FloatingWidgetService.this.mFloatingWidgetView.getWidth();
                try {
                    FloatingWidgetService.this.mWindowManager.updateViewLayout(FloatingWidgetService.this.mFloatingWidgetView, this.a);
                } catch (Exception e) {
                    Crashlytics.log("probably the floating closed");
                    Crashlytics.logException(e);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFloatingWidgetClick() {
        if (isViewCollapsed()) {
            this.collapsedView.setVisibility(8);
            this.expandedView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFloatingWidgetLongClick() {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.removeFloatingWidgetView.getLayoutParams();
        int width = (this.szWindow.x - this.remove_image_view.getWidth()) / 2;
        int height = this.szWindow.y - (this.removeFloatingWidgetView.getHeight() + getStatusBarHeight());
        layoutParams.x = width;
        layoutParams.y = height;
    }

    private void playSound(Context context, Uri uri, boolean z) {
        String str;
        try {
            int streamMaxVolume = this.am.getStreamMaxVolume(4);
            this.currentVolume = this.am.getStreamVolume(4);
            vo = this.am.getStreamVolume(4);
            SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
            if (sharedPreferences.getBoolean("volumeApp", true)) {
                int i = sharedPreferences.getInt("volumeAppNum", streamMaxVolume);
                this.am.setStreamVolume(4, i, 0);
                float f = i;
                this.mMediaPlayer.setVolume(f, f);
            }
            this.mMediaPlayer.setDataSource(context, uri);
            this.mMediaPlayer.setAudioStreamType(4);
            if (z) {
                this.mMediaPlayer.setLooping(true);
            }
            this.mMediaPlayer.prepare();
            this.mMediaPlayer.start();
        } catch (IOException e) {
            e = e;
            str = "error with play number 1";
            Crashlytics.log(str);
            Crashlytics.logException(e);
        } catch (RuntimeException e2) {
            e = e2;
            str = "error with play number 2";
            Crashlytics.log(str);
            Crashlytics.logException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPosition(int i) {
        if (i <= this.szWindow.x / 2) {
            moveToLeft(i);
        } else {
            moveToRight(i);
        }
    }

    public /* synthetic */ void a() {
        this.vibe.cancel();
        try {
            if (this.sou && this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.setVolume(vo, vo);
                this.mMediaPlayer.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        stopSelf();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_expanded_view /* 2131362097 */:
                this.collapsedView.setVisibility(0);
                this.expandedView.setVisibility(8);
                return;
            case R.id.close_floating_view /* 2131362098 */:
                break;
            case R.id.open_activity_button /* 2131362352 */:
                Intent intent = new Intent(this, (Class<?>) MokedPage.class);
                intent.addFlags(268435456);
                startActivity(intent);
                break;
            default:
                return;
        }
        stopSelf();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i;
        super.onConfigurationChanged(configuration);
        getWindowManagerDefaultDisplay();
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mFloatingWidgetView.getLayoutParams();
        int i2 = configuration.orientation;
        if (i2 == 2) {
            int height = layoutParams.y + this.mFloatingWidgetView.getHeight() + getStatusBarHeight();
            int i3 = this.szWindow.y;
            if (height > i3) {
                layoutParams.y = i3 - (this.mFloatingWidgetView.getHeight() + getStatusBarHeight());
                this.mWindowManager.updateViewLayout(this.mFloatingWidgetView, layoutParams);
            }
            int i4 = layoutParams.x;
            if (i4 == 0 || i4 >= (i = this.szWindow.x)) {
                return;
            }
        } else {
            if (i2 != 1) {
                return;
            }
            int i5 = layoutParams.x;
            i = this.szWindow.x;
            if (i5 <= i) {
                return;
            }
        }
        resetPosition(i);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            boolean isPlaying = this.mMediaPlayer.isPlaying();
            if (this.sou && isPlaying) {
                this.am.setStreamVolume(4, this.currentVolume, 0);
                this.mMediaPlayer.setVolume(vo, vo);
                this.mMediaPlayer.release();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.vibe.cancel();
        super.onDestroy();
        View view = this.mFloatingWidgetView;
        if (view != null) {
            this.mWindowManager.removeView(view);
        }
        View view2 = this.removeFloatingWidgetView;
        if (view2 != null) {
            this.mWindowManager.removeView(view2);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && this.vibe != null) {
            try {
                boolean isPlaying = mediaPlayer.isPlaying();
                if (this.sou && isPlaying) {
                    this.am.setStreamVolume(4, this.currentVolume, 0);
                    this.mMediaPlayer.setVolume(vo, vo);
                    this.mMediaPlayer.release();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            this.vibe.cancel();
        }
        View view = this.mFloatingWidgetView;
        if (view != null) {
            this.mWindowManager.removeView(view);
        }
        View view2 = this.removeFloatingWidgetView;
        if (view2 != null) {
            this.mWindowManager.removeView(view2);
        }
        if (intent.getExtras() != null) {
            this.vib = intent.getBooleanExtra("vib", true);
            this.sou = intent.getBooleanExtra("sou", true);
            this.loop = intent.getBooleanExtra("loop", false);
            this.url = Uri.parse(intent.getStringExtra("uri"));
            this.ShabbatM = intent.getBooleanExtra("ShabbatM", false);
            this.timeK = intent.getStringExtra("timeK");
        }
        this.mWindowManager = (WindowManager) getSystemService("window");
        getWindowManagerDefaultDisplay();
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.vibe = (Vibrator) getSystemService("vibrator");
        this.am = (AudioManager) getSystemService("audio");
        this.mMediaPlayer = new MediaPlayer();
        if (layoutInflater == null) {
            return 3;
        }
        addRemoveView(layoutInflater);
        addFloatingWidgetView(layoutInflater);
        implementClickListeners();
        implementTouchListenerToFloatingWidgetView();
        doNotification();
        return 3;
    }
}
