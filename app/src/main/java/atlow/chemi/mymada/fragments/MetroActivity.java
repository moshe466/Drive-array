package atlow.chemi.mymada.fragments;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.helpers.Event;
import atlow.chemi.mymada.helpers.MetronomeEventCallback;
import atlow.chemi.mymada.recieversAndServices.MetroService;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class MetroActivity extends Fragment {
    private static final int START_TIMER = 0;
    private static final int STOP_TIMER = 1;
    public static boolean bound = false;

    @SuppressLint({"StaticFieldLeak"})
    private static TextView clock;

    @SuppressLint({"StaticFieldLeak"})
    private static ProgressBar pb;

    @SuppressLint({"StaticFieldLeak"})
    private static View v;
    private Animation anim;
    private Animation big;
    private FirebaseAnalytics mFirebaseAnalytics;
    private Intent notifyMeIntent;
    private static StopWatch stopWatch = new StopWatch();
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: atlow.chemi.mymada.fragments.MetroActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 0) {
                MetroActivity.stopWatch.start();
                MetroActivity.mHandler.sendEmptyMessage(2);
            } else if (i == 1) {
                MetroActivity.mHandler.removeMessages(2);
                MetroActivity.stopWatch.stop();
                try {
                    MetroActivity.clock.setText(MetroActivity.stopWatch.toString());
                    MetroActivity.pb.setProgress(0);
                } catch (Exception e) {
                    Crashlytics.log("Text box does not exist");
                    Crashlytics.logException(e);
                }
            } else if (i == 2) {
                try {
                    String stopWatch2 = MetroActivity.stopWatch.toString();
                    if (MetroActivity.stopWatch.toString().contains("\n")) {
                        int indexOf = stopWatch2.indexOf("\n");
                        SpannableString spannableString = new SpannableString(stopWatch2);
                        spannableString.setSpan(new RelativeSizeSpan(0.6f), indexOf, stopWatch2.length(), 33);
                        MetroActivity.clock.setText(spannableString);
                    } else {
                        MetroActivity.clock.setText(MetroActivity.stopWatch.toString());
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        MetroActivity.pb.setProgress(MetroActivity.stopWatch.a(), true);
                    } else {
                        MetroActivity.pb.setProgress(MetroActivity.stopWatch.a());
                    }
                } catch (Exception e2) {
                    Crashlytics.log("Text box does not exist");
                    Crashlytics.logException(e2);
                }
                MetroActivity.mHandler.sendEmptyMessageDelayed(2, 500L);
            }
            return false;
        }
    });
    private boolean MetroRun = false;
    private long timestamp = 0;
    private ServiceConnection serviceConnection = new AnonymousClass4();

    /* renamed from: atlow.chemi.mymada.fragments.MetroActivity$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements ServiceConnection {
        AnonymousClass4() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MetroService service = ((MetroService.MetroBinder) iBinder).getService();
            MetroActivity.bound = true;
            Event<MetronomeEventCallback> event = service.MetronomeStartEvent;
            final MetroActivity metroActivity = MetroActivity.this;
            event.addListener(new MetronomeEventCallback() { // from class: atlow.chemi.mymada.fragments.s0
                @Override // atlow.chemi.mymada.helpers.MetronomeEventCallback
                public final void metronomeEventHandler(long j) {
                    MetroActivity.this.MetronomeStartedInBackground(j);
                }
            });
            Event<MetronomeEventCallback> event2 = service.MetronomeStopEvent;
            final MetroActivity metroActivity2 = MetroActivity.this;
            event2.addListener(new MetronomeEventCallback() { // from class: atlow.chemi.mymada.fragments.r0
                @Override // atlow.chemi.mymada.helpers.MetronomeEventCallback
                public final void metronomeEventHandler(long j) {
                    MetroActivity.this.MetronomeStoppedInBackground(j);
                }
            });
            MetroActivity.this.MetroRun = MetroService.running;
            if (MetroActivity.this.MetroRun) {
                MetroActivity.this.timestamp = service.timestamp;
                MetroActivity.this.clocketise(0);
                MetroActivity.this.startAnim();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MetroActivity.bound = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class StopWatch {
        private long startTime = 0;
        private boolean isOn = false;

        StopWatch() {
        }

        private String getElapsedTimeHours() {
            StringBuilder sb;
            long currentTimeMillis = this.isOn ? (((System.currentTimeMillis() - this.startTime) / 1000) / 60) / 60 : 0L;
            if (currentTimeMillis <= 9) {
                sb = new StringBuilder();
                sb.append("0");
                sb.append(currentTimeMillis);
            } else {
                sb = new StringBuilder();
                sb.append(currentTimeMillis);
                sb.append("");
            }
            return sb.toString();
        }

        private String getElapsedTimeMinutes() {
            StringBuilder sb;
            long currentTimeMillis = this.isOn ? (((System.currentTimeMillis() - this.startTime) / 1000) / 60) % 60 : 0L;
            if (currentTimeMillis <= 9) {
                sb = new StringBuilder();
                sb.append("0");
                sb.append(currentTimeMillis);
            } else {
                sb = new StringBuilder();
                sb.append(currentTimeMillis);
                sb.append("");
            }
            return sb.toString();
        }

        private String getElapsedTimeSeconds() {
            StringBuilder sb;
            long currentTimeMillis = this.isOn ? ((System.currentTimeMillis() - this.startTime) / 1000) % 60 : 0L;
            if (currentTimeMillis <= 9) {
                sb = new StringBuilder();
                sb.append("0");
                sb.append(currentTimeMillis);
            } else {
                sb = new StringBuilder();
                sb.append(currentTimeMillis);
                sb.append("");
            }
            return sb.toString();
        }

        int a() {
            return (int) (((System.currentTimeMillis() - this.startTime) / 1000) % 120);
        }

        void a(long j) {
            this.startTime = j;
        }

        public void start() {
            if (this.startTime == 0) {
                this.startTime = System.currentTimeMillis();
            }
            this.isOn = true;
        }

        public void stop() {
            this.startTime = 0L;
            this.isOn = false;
        }

        @NonNull
        public String toString() {
            StringBuilder sb;
            if (getElapsedTimeHours().equals("00")) {
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
                sb.append(getElapsedTimeHours());
                sb.append("\n");
            }
            sb.append(getElapsedTimeMinutes());
            sb.append(":");
            sb.append(getElapsedTimeSeconds());
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MetronomeStartedInBackground(long j) {
        StartMetronome(true);
        this.timestamp = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MetronomeStoppedInBackground(long j) {
        StopMetronome();
        this.timestamp = j;
    }

    private void StartMetronome(boolean z) {
        this.MetroRun = true;
        if (!z) {
            startMetroService();
        }
        clocketise(0);
        startAnim();
    }

    private void StopMetronome() {
        this.MetroRun = false;
        this.timestamp = 0L;
        clocketise(1);
        stopAnim();
        if (getActivity() != null) {
            getActivity().stopService(this.notifyMeIntent);
            unbindService();
            bindService();
        }
    }

    private void bindService() {
        if (getActivity() == null || this.notifyMeIntent == null) {
            return;
        }
        getActivity().bindService(this.notifyMeIntent, this.serviceConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clocketise(int i) {
        if (this.timestamp == 0 || System.currentTimeMillis() < this.timestamp) {
            this.timestamp = System.currentTimeMillis();
        }
        stopWatch.a(this.timestamp);
        mHandler.sendEmptyMessage(i);
    }

    private void scaleView(final View view) {
        this.anim = new ScaleAnimation(1.05f, 1.0f, 1.05f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.big = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, 1, 0.5f, 1, 0.5f);
        this.anim.setFillAfter(true);
        this.anim.setDuration(650L);
        this.big.setDuration(350L);
        this.anim.setAnimationListener(new Animation.AnimationListener() { // from class: atlow.chemi.mymada.fragments.MetroActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MetroActivity.this.big);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.big.setAnimationListener(new Animation.AnimationListener() { // from class: atlow.chemi.mymada.fragments.MetroActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MetroActivity.this.anim);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(this.anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim() {
        View view = v;
        if (view != null) {
            try {
                scaleView(view);
                this.anim.setDuration(650L);
                this.big.setDuration(350L);
            } catch (Exception e) {
                Crashlytics.log(e.getMessage());
            }
        }
    }

    private void startMetroService() {
        NotificationManager notificationManager;
        this.timestamp = 0L;
        if (Build.VERSION.SDK_INT >= 26 && getActivity() != null && (notificationManager = (NotificationManager) getActivity().getSystemService(NotificationManager.class)) != null && notificationManager.getNotificationChannel("runInBg") == null) {
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup("grpOthers", "התראות שונות");
            NotificationChannel notificationChannel = new NotificationChannel("runInBg", "פעילות ברקע", 1);
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setImportance(1);
            notificationChannel.setDescription("חיוני כדי לאפשר זיהוי מקרים");
            notificationChannel.setGroup("grpOthers");
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        if (getActivity() != null) {
            try {
                ContextCompat.startForegroundService(getActivity(), this.notifyMeIntent);
            } catch (Exception e) {
                Crashlytics.log("failed starting metronome");
                Crashlytics.logException(e);
            }
        }
    }

    private void stopAnim() {
        View view = v;
        if (view == null || this.anim == null || this.big == null) {
            return;
        }
        try {
            view.getAnimation().cancel();
            v.clearAnimation();
            this.anim.setAnimationListener(null);
            this.big.setAnimationListener(null);
            v.setAnimation(null);
        } catch (Exception e) {
            Crashlytics.log(e.getMessage());
        }
    }

    private void unbindService() {
        if (!bound || getActivity() == null) {
            return;
        }
        getActivity().unbindService(this.serviceConnection);
        bound = false;
    }

    public /* synthetic */ void b(View view) {
        if (this.MetroRun) {
            StopMetronome();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "metro");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "metronome");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "CPR");
        this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        StartMetronome(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.notifyMeIntent = new Intent(getActivity(), (Class<?>) MetroService.class);
        if (getActivity() != null) {
            this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
            getActivity().setTitle(R.string.button_d);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_metro, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        bindService();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        unbindService();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean z = false;
        if (getActivity() != null) {
            z = getActivity().getIntent().getBooleanExtra("start", false);
            ((TextView) view.findViewById(R.id.metroExp)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf"));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.bpmW);
        clock = (TextView) view.findViewById(R.id.metro_Clock);
        pb = (ProgressBar) view.findViewById(R.id.metro_progressBar);
        v = view.findViewById(R.id.startstop);
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MetroActivity.this.b(view2);
            }
        });
        if (z) {
            constraintLayout.performClick();
        }
    }
}
