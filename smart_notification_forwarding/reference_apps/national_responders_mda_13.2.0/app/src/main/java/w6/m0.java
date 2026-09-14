package w6;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class m0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    MediaPlayer f15220f;

    /* renamed from: g, reason: collision with root package name */
    int f15221g;

    /* renamed from: h, reason: collision with root package name */
    Context f15222h;

    /* renamed from: i, reason: collision with root package name */
    boolean f15223i;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m0.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            m0.this.f15223i = true;
            mediaPlayer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15226a;

        static {
            int[] iArr = new int[d.values().length];
            f15226a = iArr;
            try {
                iArr[d.ptt_out.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15226a[d.ptt_in.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15226a[d.batteryChange.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15226a[d.ptt_out_end.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15226a[d.ptt_error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15226a[d.buzzer.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15226a[d.success.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15226a[d.error.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15226a[d.report_dispatch.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15226a[d.report_not_dispatch.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15226a[d.report_arrive_to_place.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15226a[d.report_available.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f15226a[d.create_drive_data.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f15226a[d.messades_deleted.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f15226a[d.report_status_shabat.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f15226a[d.report_status_available.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f15226a[d.report_status_not_available.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f15226a[d.report_status_natan.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f15226a[d.battery_low.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f15226a[d.bip.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f15226a[d.tweet.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        ptt_out,
        ptt_out_end,
        ptt_in,
        ptt_error,
        buzzer,
        report_not_dispatch,
        report_arrive_to_place,
        report_available,
        create_drive_data,
        messades_deleted,
        report_dispatch,
        report_status_shabat,
        report_status_available,
        report_status_not_available,
        battery_low,
        report_status_natan,
        success,
        error,
        bip,
        batteryChange,
        tweet
    }

    public m0(Context context, int i10) {
        this.f15222h = context;
        this.f15221g = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.f15220f = MediaPlayer.create(this.f15222h, this.f15221g);
            this.f15220f.start();
            this.f15220f.setOnCompletionListener(new b());
            this.f15220f.setLooping(false);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, d dVar) {
        d(context, dVar, null);
    }

    public static void d(Context context, d dVar, MediaPlayer.OnCompletionListener onCompletionListener) {
        int i10 = c.f15226a[dVar.ordinal()];
        int i11 = R.raw.report_status_natan;
        switch (i10) {
            case 1:
                i11 = R.raw.ptt3;
                break;
            case 2:
                i11 = R.raw.ptt1;
                break;
            case 3:
            case 4:
            case 20:
                i11 = R.raw.ptt4;
                break;
            case 5:
                i11 = R.raw.ptt_error;
                break;
            case 6:
                i11 = R.raw.buzzer;
                break;
            case 7:
                i11 = R.raw.success;
                break;
            case 8:
                i11 = R.raw.error;
                break;
            case 9:
                i11 = R.raw.report_dispatch;
                break;
            case 10:
                i11 = R.raw.report_not_dispatch;
                break;
            case 11:
                i11 = R.raw.report_arrive_to_place;
                break;
            case 12:
                i11 = R.raw.report_available;
                break;
            case 13:
                i11 = R.raw.create_drive_data;
                break;
            case 14:
                i11 = R.raw.messades_deleted;
                break;
            case 15:
                i11 = R.raw.report_status_shabat;
                break;
            case 16:
                i11 = R.raw.report_status_available;
                break;
            case 17:
                i11 = R.raw.report_status_not_available;
                break;
            case 18:
            case 19:
                break;
            case 21:
                i11 = R.raw.bip;
                break;
            default:
                i11 = 0;
                break;
        }
        e(context, i11, onCompletionListener);
    }

    public static void e(Context context, int i10, MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer create = MediaPlayer.create(context, i10);
        try {
            create.start();
            if (onCompletionListener != null) {
                create.setOnCompletionListener(onCompletionListener);
            }
        } catch (Exception e10) {
            e10.getMessage();
            e10.printStackTrace();
        }
    }

    public void f() {
        new Thread(this).start();
    }

    @Override // java.lang.Runnable
    public void run() {
        new Handler(Looper.getMainLooper()).post(new a());
    }
}
