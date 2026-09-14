package atlow.chemi.mymada;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import atlow.chemi.mymada.helpers.LocalHelper;
import com.crashlytics.android.Crashlytics;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
    private String string = "";
    private Vibrator vibe;
    private Typeface myTypeface;
    private TextView tvDistanceEta;

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
        if (str == null || !str.contains(str2) || !str.contains(str3)) return "";
        String substring = str.substring(str.indexOf(str2) + str2.length());
        return substring.substring(0, substring.indexOf(str3));
    }

    public static String getEndStrings(String str, String str2) {
        if (str == null || !str.contains(str2)) return "";
        return str.substring(str.indexOf(str2) + str2.length());
    }

    public static String getStartStrings(String str, String str2) {
        if (str == null || !str.contains(str2)) return "";
        return str.substring(0, str.indexOf(str2));
    }

    public static void newC(String str) {
        Stxt = str;
    }

    private void stopSoundAndVibe() {
        if (this.vibe != null) {
            try {
                this.vibe.cancel();
            } catch (Exception ignored) {
            }
        }
        if (this.mMediaPlayer != null) {
            try {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.stop();
                }
                this.mMediaPlayer.release();
            } catch (Exception ignored) {
            }
            this.mMediaPlayer = null;
        }
    }

    private void playSound(Context context, Uri uri, final int maxCycles) {
        if (uri == null) return;
        try {
            this.am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            if (this.am != null) {
                int streamMaxVolume = this.am.getStreamMaxVolume(AudioManager.STREAM_ALARM);
                this.k = this.am.getStreamVolume(AudioManager.STREAM_ALARM);
                vo = this.k;
                SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
                if (sharedPreferences.getBoolean("volumeApp", true)) {
                    int i = sharedPreferences.getInt("volumeAppNum", streamMaxVolume);
                    this.am.setStreamVolume(AudioManager.STREAM_ALARM, i, 0);
                    float f = i;
                    if (this.mMediaPlayer != null) {
                        this.mMediaPlayer.setVolume(f, f);
                    }
                }
            }
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.release();
            }
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setDataSource(context, uri);
            this.mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);

            if (maxCycles == 0) {
                // 0 = Continuous loop
                this.mMediaPlayer.setLooping(true);
            } else {
                final int[] cycleCounter = new int[]{0};
                this.mMediaPlayer.setLooping(false);
                this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        cycleCounter[0]++;
                        if (cycleCounter[0] < maxCycles) {
                            try {
                                mp.seekTo(0);
                                mp.start();
                            } catch (Exception e) {
                                stopSoundAndVibe();
                            }
                        } else {
                            stopSoundAndVibe();
                        }
                    }
                });
            }

            this.mMediaPlayer.prepare();
            this.mMediaPlayer.start();
        } catch (IOException e) {
            Crashlytics.log("error with play number 1");
            Crashlytics.logException(e);
        } catch (RuntimeException e2) {
            Crashlytics.log("error with play number 2");
            Crashlytics.logException(e2);
        }
    }

    public void dismissAndFinishAlert() {
        stopSoundAndVibe();
        try {
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (nm != null) {
                nm.cancelAll();
            }
        } catch (Exception ignored) {
        }
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }

    public void a(View view) {
        dismissAndFinishAlert();
    }

    public void b(View view) {
        stopSoundAndVibe();
        PendingIntent pendingIntent = pi;
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
        Intent intent = getIntent();
        String pack = intent != null ? intent.getStringExtra("pack") : null;
        if (pack != null && !pack.isEmpty()) {
            try {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(pack);
                if (launchIntent != null) {
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    startActivity(launchIntent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("T1".equals(this.string)) {
            // callT=1 = Hatzalah → open com.uh.sf
            try {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.uh.sf");
                if (launchIntent != null) {
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    startActivity(launchIntent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("T2".equals(this.string)) {
            // callT=2 = MDA → open il.org.mda.health or com.groboot.mdaemergency
            try {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("il.org.mda.health");
                if (launchIntent == null) {
                    launchIntent = getPackageManager().getLaunchIntentForPackage("com.groboot.mdaemergency");
                }
                if (launchIntent != null) {
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    startActivity(launchIntent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        dismissAndFinishAlert();
    }

    @Override
    @TargetApi(16)
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initViewsAndData(intent);
    }

    @Override
    @SuppressLint({"ClickableViewAccessibility"})
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            android.app.KeyguardManager km = (android.app.KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
            if (km != null) {
                km.requestDismissKeyguard(this, null);
            }
        }

        setContentView(R.layout.activity_sms_res);
        this.context = this;

        try {
            this.myTypeface = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        } catch (Exception ignored) {
        }

        initViewsAndData(getIntent());
    }

    private void initViewsAndData(Intent intent) {
        stopSoundAndVibe();

        TextView newCTV = (TextView) findViewById(R.id.newC);
        TextView msgTypeTV = (TextView) findViewById(R.id.msgType);
        TextView addressTV = (TextView) findViewById(R.id.Address);
        this.tvDistanceEta = (TextView) findViewById(R.id.tvDistanceEta);
        TextView kodRTV = (TextView) findViewById(R.id.KodR);
        ImageView bgIV = (ImageView) findViewById(R.id.bg);
        TextView nameTV = (TextView) findViewById(R.id.name);
        Button buttonI = (Button) findViewById(R.id.buttonI);
        Button button = (Button) findViewById(R.id.button);

        if (this.myTypeface != null) {
            if (newCTV != null) newCTV.setTypeface(this.myTypeface);
            if (msgTypeTV != null) msgTypeTV.setTypeface(this.myTypeface);
            if (addressTV != null) addressTV.setTypeface(this.myTypeface);
            if (this.tvDistanceEta != null) this.tvDistanceEta.setTypeface(this.myTypeface);
            if (kodRTV != null) kodRTV.setTypeface(this.myTypeface);
            if (nameTV != null) nameTV.setTypeface(this.myTypeface);
            if (buttonI != null) buttonI.setTypeface(this.myTypeface);
            if (button != null) button.setTypeface(this.myTypeface);
        }

        int callT = 0;
        String timeStr = "";
        String addressStr = "";
        String smsStr = "";
        String kodStr = "";
        String orgTitle = Stxt;

        if (intent != null) {
            callT = intent.getIntExtra("callT", 0);
            timeStr = intent.getStringExtra("time");
            addressStr = intent.getStringExtra("address");
            smsStr = intent.getStringExtra("sms");
            kodStr = intent.getStringExtra("kod");
            if (addressStr == null || addressStr.isEmpty()) {
                addressStr = intent.getStringExtra("text");
            }
            if (smsStr == null || smsStr.isEmpty()) {
                smsStr = intent.getStringExtra("text");
            }
            if (intent.hasExtra("org_title")) {
                orgTitle = intent.getStringExtra("org_title");
            }
        }

        String packName = intent != null ? intent.getStringExtra("pack") : "";
        boolean isUh = "com.uh.sf".equals(packName) || (orgTitle != null && orgTitle.contains("איחוד הצלה"));

        if (callT == 1) {
            // Hatzalah (איחוד הצלה) — orange
            this.string = "T1";
            if (newCTV != null) {
                newCTV.setBackgroundColor(android.graphics.Color.parseColor("#EA580C"));
            }
            if (bgIV != null) bgIV.setImageResource(R.drawable.ic_hatzalah_logo);
            if (msgTypeTV != null) {
                msgTypeTV.setText("איחוד הצלה - קריאת חירום");
                msgTypeTV.setTextColor(android.graphics.Color.parseColor("#EA580C"));
            }
            if (buttonI != null) {
                buttonI.setBackgroundResource(R.drawable.bg_btn_hatzalah);
            }
            if (button != null) {
                button.setBackgroundResource(R.drawable.bg_btn_hatzalah);
            }
        } else if (callT == 2) {
            // MDA (מגן דוד אדום) — red
            this.string = "T2";
            if (newCTV != null) {
                newCTV.setBackgroundColor(android.graphics.Color.parseColor("#DC2626"));
            }
            if (bgIV != null) bgIV.setImageResource(R.drawable.ic_mda);
            if (msgTypeTV != null) {
                msgTypeTV.setText("מגן דוד אדום - קריאת חירום");
                msgTypeTV.setTextColor(android.graphics.Color.parseColor("#DC2626"));
            }
        } else if (callT == 7 || callT == 3) {
            // Team / Group message — purple
            this.string = "T3";
            if (newCTV != null) {
                newCTV.setBackgroundColor(android.graphics.Color.parseColor("#7C3AED"));
            }
            if (bgIV != null) {
                bgIV.setImageResource(isUh ? R.drawable.ic_hatzalah_logo : R.drawable.ic_mda);
            }
            if (msgTypeTV != null) {
                msgTypeTV.setText(orgTitle != null && !orgTitle.isEmpty() ? orgTitle : "הודעת צוות וסניף");
                msgTypeTV.setTextColor(android.graphics.Color.parseColor("#7C3AED"));
            }
        } else if (callT == 4) {
            // Administrative & Forms — blue
            this.string = "T4";
            if (newCTV != null) {
                newCTV.setBackgroundColor(android.graphics.Color.parseColor("#0284C7"));
            }
            if (bgIV != null) {
                bgIV.setImageResource(isUh ? R.drawable.ic_hatzalah_logo : R.drawable.ic_mda);
            }
            if (msgTypeTV != null) {
                msgTypeTV.setText(orgTitle != null && !orgTitle.isEmpty() ? orgTitle : "הודעה מנהלתית וטפסים");
                msgTypeTV.setTextColor(android.graphics.Color.parseColor("#0284C7"));
            }
        } else if (callT == 6) {
            this.string = "T6";
            if (newCTV != null) {
                newCTV.setBackgroundColor(android.graphics.Color.parseColor("#0D9488"));
            }
            if (bgIV != null) {
                bgIV.setImageResource(isUh ? R.drawable.ic_hatzalah_logo : R.drawable.ic_mda);
            }
            if (msgTypeTV != null) {
                msgTypeTV.setText(orgTitle != null && !orgTitle.isEmpty() ? orgTitle : "הודעת שירות");
                msgTypeTV.setTextColor(android.graphics.Color.parseColor("#0D9488"));
            }
        }

        if (newCTV != null && orgTitle != null) {
            newCTV.setText(orgTitle);
        }

        if (addressTV != null && addressStr != null) {
            addressTV.setText(addressStr);
        }
        if (kodRTV != null && kodStr != null) {
            kodRTV.setText(kodStr);
        }

        // Calculate and display distance and ETA from current GPS location (only for emergency calls)
        if (callT == 1 || callT == 2) {
            calculateDistanceAndEta(addressStr != null && !addressStr.isEmpty() ? addressStr : smsStr);
        } else {
            if (this.tvDistanceEta != null) {
                this.tvDistanceEta.setVisibility(View.GONE);
            }
        }

        if (buttonI != null) {
            buttonI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    smsRes.this.b(v);
                }
            });
            buttonI.setOnTouchListener(new MyTouchListener());
        }

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    smsRes.this.a(v);
                }
            });
            button.setOnTouchListener(new MyTouchListener());
        }

        SharedPreferences sp = getSharedPreferences("Settings", 0);
        int maxCycles = sp.getInt("sound_repeat_cycles", 1); // Default to 1 cycle

        boolean isSoundEnabled = sp.getBoolean("Nsou" + this.string, true);
        if (isSoundEnabled) {
            String soundUriStr = sp.getString("NuRi" + this.string, null);
            if (soundUriStr == null || soundUriStr.isEmpty()) {
                soundUriStr = sp.getString("NuRi", null);
            }
            android.net.Uri soundUri = null;
            if (soundUriStr != null && !soundUriStr.isEmpty()) {
                try {
                    soundUri = android.net.Uri.parse(soundUriStr);
                } catch (Exception ignored) {
                }
            }
            if (soundUri == null) {
                soundUri = android.media.RingtoneManager.getDefaultUri(android.media.RingtoneManager.TYPE_ALARM);
                if (soundUri == null) {
                    soundUri = android.media.RingtoneManager.getDefaultUri(android.media.RingtoneManager.TYPE_NOTIFICATION);
                }
            }
            playSound(this, soundUri, maxCycles);
        }

        boolean isVibrate = sp.getBoolean("vibDev" + this.string, true);
        if (isVibrate) {
            this.vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (this.vibe != null) {
                // If limited cycles, vibrate once (repeat = -1), else repeat continuously (repeat = 0)
                int vibRepeat = maxCycles == 0 ? 0 : -1;
                this.vibe.vibrate(new long[]{0, 600, 300, 600, 300, 600}, vibRepeat);
            }
        }

        // Auto-dismiss on Shabbat (killS) if enabled
        if (sp.getBoolean("killS", false)) {
            try {
                int seconds = Integer.parseInt(sp.getString("timeK", "6"));
                if (seconds > 0) {
                    new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (!isFinishing()) {
                                dismissAndFinishAlert();
                            }
                        }
                    }, seconds * 1000L);
                }
            } catch (Exception ignored) {
            }
        }
    }

    private void calculateDistanceAndEta(final String rawAddress) {
        if (this.tvDistanceEta == null) {
            return;
        }

        final String cleanAddress = extractCityAndStreet(rawAddress);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cleanAddress.isEmpty()) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (tvDistanceEta != null) {
                                    tvDistanceEta.setText("📍 לא ניתן לחשב זמן הגעה");
                                    tvDistanceEta.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                        return;
                    }

                    Location myLocation = getBestCurrentLocation();
                    Geocoder geocoder = new Geocoder(smsRes.this, new Locale("he", "IL"));
                    List<Address> addresses = null;
                    try {
                        addresses = geocoder.getFromLocationName(cleanAddress, 1);
                        if (addresses == null || addresses.isEmpty()) {
                            addresses = geocoder.getFromLocationName(cleanAddress + ", ישראל", 1);
                        }
                    } catch (Exception ignored) {
                    }

                    if (addresses != null && !addresses.isEmpty() && myLocation != null) {
                        Address dest = addresses.get(0);
                        float[] distResults = new float[1];
                        Location.distanceBetween(myLocation.getLatitude(), myLocation.getLongitude(),
                                dest.getLatitude(), dest.getLongitude(), distResults);

                        float straightKm = distResults[0] / 1000f;
                        float drivingKm = straightKm * 1.25f; // Estimated urban road factor
                        int minutes = Math.max(1, Math.round((drivingKm / 35.0f) * 60.0f));

                        final String resultText = String.format(Locale.getDefault(),
                                "📍 %.1f ק\"מ  •  ⏱️ כ-%d דק'", drivingKm, minutes);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (tvDistanceEta != null) {
                                    tvDistanceEta.setText(resultText);
                                    tvDistanceEta.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (tvDistanceEta != null) {
                                    tvDistanceEta.setText("📍 לא ניתן לחשב זמן הגעה");
                                    tvDistanceEta.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (tvDistanceEta != null) {
                                tvDistanceEta.setText("📍 לא ניתן לחשב זמן הגעה");
                                tvDistanceEta.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }
        }).start();
    }

    private String extractCityAndStreet(String raw) {
        if (raw == null) return "";
        String s = raw.replaceAll("[*#\\r]", " ");
        
        // Remove known system headers
        s = s.replaceAll("(?i)(אירוע חדש|הודעת צוות|הודעת קבוצה|איחוד הצלה|מד\"א|מגן דוד אדום|בדיקה!+|בדיקה|הודעה מנהלתית|הודעת שירות)", " ");
        
        // Extract substring after "כתובת:" if present
        if (s.contains("כתובת:")) {
            s = s.substring(s.indexOf("כתובת:") + 6);
        }
        
        // Cut off metadata sections
        String[] stopWords = {
            "מונה:", "קוד הזנקה:", "קוד רפואי:", "קוד:", "הזנקה:", "פרטים:", "שם:", "טלפון:",
            "הערות:", "גיל:", "מין:", "ת.ד", "נפגע", "חולה", "טראומה", "החייאה", "דום לב",
            "קומה:", "דירה:", "כניסה:"
        };
        for (String stop : stopWords) {
            if (s.contains(stop)) {
                s = s.substring(0, s.indexOf(stop));
            }
        }
        
        // Take first line if multiple
        if (s.contains("\n")) {
            s = s.substring(0, s.indexOf("\n"));
        }
        
        // Remove time stamps like 14:18 or 02:34 at start
        s = s.replaceAll("^\\s*\\d{1,2}:\\d{2}\\s*", " ");
        
        // Replace multiple spaces
        s = s.replaceAll("\\s+", " ").trim();
        
        // Strip trailing/leading non-letter symbols
        s = s.replaceAll("^[,.:;\\-_\\s]+|[,.:;\\-_\\s]+$", "").trim();
        
        if (s.length() < 3 || !s.matches(".*[\\u0590-\\u05FF].*")) {
            return "";
        }
        return s;
    }

    private Location getBestCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        try {
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (lm == null) return null;
            Location best = null;
            List<String> providers = lm.getProviders(true);
            for (String provider : providers) {
                @SuppressLint("MissingPermission")
                Location l = lm.getLastKnownLocation(provider);
                if (l != null) {
                    if (best == null || l.getTime() > best.getTime() || (l.getAccuracy() < best.getAccuracy() && (System.currentTimeMillis() - l.getTime() < 120000))) {
                        best = l;
                    }
                }
            }
            return best;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    protected void onPause() {
        stopSoundAndVibe();
        super.onPause();
    }

    @Override
    protected void onStop() {
        stopSoundAndVibe();
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        dismissAndFinishAlert();
    }

    @Override
    public void onDestroy() {
        stopSoundAndVibe();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            dismissAndFinishAlert();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
