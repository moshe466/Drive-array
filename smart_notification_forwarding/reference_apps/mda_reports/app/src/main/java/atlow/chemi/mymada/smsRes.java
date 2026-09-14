package atlow.chemi.mymada;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import atlow.chemi.mymada.helpers.LocalHelper;
import com.crashlytics.android.Crashlytics;
import java.io.IOException;

/* loaded from: classes.dex */
public class smsRes extends AppCompatActivity {
    private static String Stxt = "מקרה חדש";
    private static PendingIntent pi;
    public static float vo;
    private AudioManager am;
    public Context context;
    private boolean isMove1 = false;
    int k;
    private MediaPlayer mMediaPlayer;
    private float oldX1;
    private float oldY1;
    private String string;
    private Vibrator vibe;

    /* loaded from: classes.dex */
    private class MyTouchListener implements View.OnTouchListener {
        private MyTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                smsRes.this.oldY1 = motionEvent.getY();
                smsRes.this.oldX1 = motionEvent.getX();
                smsRes.this.isMove1 = false;
                view.setAlpha(0.4f);
                return true;
            }
            if (action == 1) {
                view.setAlpha(1.0f);
                if (!smsRes.this.isMove1) {
                    view.performClick();
                }
                return true;
            }
            if (action != 2) {
                return false;
            }
            boolean z = smsRes.this.oldX1 - motionEvent.getX() > 140.0f || motionEvent.getX() - smsRes.this.oldX1 > 140.0f;
            boolean z2 = smsRes.this.oldY1 - motionEvent.getY() > 50.0f || motionEvent.getY() - smsRes.this.oldY1 > 50.0f;
            if (z || z2) {
                smsRes.this.isMove1 = true;
                view.setAlpha(1.0f);
            }
            return true;
        }
    }

    public static void alerT(PendingIntent pendingIntent) {
        pi = pendingIntent;
    }

    public static String getBetweenStrings(String str, String str2, String str3) {
        String substring = str.substring(str.indexOf(str2) + str2.length());
        return substring.substring(0, substring.indexOf(str3));
    }

    public static String getEndStrings(String str, String str2) {
        return str.substring(str.indexOf(str2) + str2.length());
    }

    public static String getStartStrings(String str, String str2) {
        return str.substring(0, str.indexOf(str2));
    }

    public static void newC(String str) {
        Stxt = str;
    }

    private void playSound(Context context, Uri uri, boolean z) {
        String str;
        try {
            int streamMaxVolume = this.am.getStreamMaxVolume(4);
            this.k = this.am.getStreamVolume(4);
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

    public /* synthetic */ void a(View view) {
        finish();
    }

    public /* synthetic */ void a(boolean z) {
        this.vibe.cancel();
        getWindow().clearFlags(128);
        if (z) {
            try {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.setVolume(vo, vo);
                    this.mMediaPlayer.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    @TargetApi(16)
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public /* synthetic */ void b(View view) {
        PendingIntent pendingIntent = pi;
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x01d2, code lost:
    
        if (r3 != 8) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0224 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0220 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0236 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04b9  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r21) {
        /*
            Method dump skipped, instructions count: 1398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.smsRes.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        boolean z = getSharedPreferences("settings", 0).getBoolean("Nsou" + this.string, true);
        this.vibe = (Vibrator) getSystemService("vibrator");
        Vibrator vibrator = this.vibe;
        if (vibrator != null) {
            vibrator.cancel();
        }
        getWindow().clearFlags(128);
        try {
            boolean isPlaying = this.mMediaPlayer.isPlaying();
            if (z && isPlaying) {
                this.am.setStreamVolume(4, this.k, 0);
                this.mMediaPlayer.setVolume(vo, vo);
                this.mMediaPlayer.release();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
