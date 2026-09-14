package atlow.chemi.mymada;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.adapters.homeBAdapter;
import atlow.chemi.mymada.classes.HomeB;
import atlow.chemi.mymada.helpers.LocalHelper;
import atlow.chemi.mymada.helpers.MyFirebaseMessagingService;
import atlow.chemi.mymada.helpers.rateUs;
import atlow.chemi.mymada.recieversAndServices.SMSMonitorService;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class HomePage extends AppCompatActivity {
    private MenuItem Detect;
    private homeBAdapter adapter;
    public NotificationManager manager;
    private Typeface myTypeface;
    private final int OVERLAY_PER_REQ = 345;
    private static final int LOCATION_PER_REQ = 555;
    public final String Grp2 = "grpOthers";
    public final String Grp3 = "grpTog";
    public final String CnlBg = "runInBg";
    public final String CnlWin = "notWithWin";

    // Dashboard UI
    private LinearLayout layoutHeroContent;
    private ImageView ivHeroStatusIcon;
    private TextView tvHeroStatusTitle;
    private TextView tvHeroStatusSubtitle;
    private SwitchCompat switchDetection;

    private LinearLayout pillOverlay;
    private TextView tvPillOverlayTitle;
    private TextView tvPillOverlayStatus;

    private LinearLayout pillNotif;
    private TextView tvPillNotifTitle;
    private TextView tvPillNotifStatus;

    private LinearLayout pillLocation;
    private TextView tvPillLocationTitle;
    private TextView tvPillLocationStatus;

    private boolean isSwitchUpdating = false;

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private boolean includeEdge;
        private int spacing;
        private int spanCount;

        GridSpacingItemDecoration(int i, int i2, boolean z) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
        }

        @Override
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.spanCount;
            int i2 = childAdapterPosition % i;
            if (this.includeEdge) {
                int i3 = this.spacing;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (childAdapterPosition < i) {
                    rect.top = i3;
                }
                rect.bottom = this.spacing;
                return;
            }
            int i4 = this.spacing;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition >= i) {
                rect.top = i4;
            }
        }
    }

    private void DialogOnShowListener(AlertDialog alertDialog) {
        if (alertDialog == null) return;
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null && this.myTypeface != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView2 != null && this.myTypeface != null) {
            textView2.setTypeface(this.myTypeface);
        }
    }

    private void ShowDialog(String str, String str2, Intent intent) {
        ShowDialog(str, null, str2, intent, false, 0);
    }

    private void ShowDialog(String str, String str2, String str3, final Intent intent, final boolean z, final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(str).setCancelable(false).setPositiveButton(str3, new DialogInterface.OnClickListener() {
            @Override
            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (z) {
                    HomePage.this.startActivityForResult(intent, i);
                } else {
                    HomePage.this.startActivity(intent);
                }
            }
        }).setNegativeButton(getResources().getString(R.string.dialog_no), new DialogInterface.OnClickListener() {
            @Override
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        if (str2 != null) {
            builder.setTitle(str2);
        }
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public final void onShow(DialogInterface dialogInterface) {
                HomePage.this.DialogOnShowListener(create);
            }
        });
        create.show();
    }

    private void setDetectionState(boolean newState) {
        SharedPreferences sp = getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("Mapp", newState);
        editor.apply();

        if (newState) {
            try {
                ContextCompat.startForegroundService(this, new Intent(this, SMSMonitorService.class));
                Applicatio.tryConnectService(getApplicationContext());
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
            try {
                String listeners = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
                if (listeners == null || !listeners.contains(getPackageName())) {
                    ShowDialog(getString(R.string.dialog_help), getString(R.string.dialog_yes), new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                }
            } catch (Exception ignored) {
            }
            Toast.makeText(this, getString(R.string.findT1_on) + " | " + getString(R.string.findT2_on), Toast.LENGTH_SHORT).show();
        } else {
            try {
                stopService(new Intent(this, SMSMonitorService.class));
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
            Toast.makeText(this, getString(R.string.APP_reco_off), Toast.LENGTH_SHORT).show();
        }

        updateDashboardState();
    }

    private void updateDashboardState() {
        SharedPreferences sp = getSharedPreferences("Settings", 0);
        boolean isEnabled = sp.getBoolean("Mapp", false);

        isSwitchUpdating = true;
        if (switchDetection != null) {
            switchDetection.setChecked(isEnabled);
        }
        isSwitchUpdating = false;

        if (layoutHeroContent != null) {
            if (isEnabled) {
                layoutHeroContent.setBackgroundResource(R.drawable.bg_hero_status_on);
                if (ivHeroStatusIcon != null) ivHeroStatusIcon.setImageResource(R.drawable.ic_detect_on);
                if (tvHeroStatusTitle != null) tvHeroStatusTitle.setText(R.string.home_status_active);
                if (tvHeroStatusSubtitle != null) tvHeroStatusSubtitle.setText(getString(R.string.findT1_on) + " | " + getString(R.string.findT2_on));
            } else {
                layoutHeroContent.setBackgroundResource(R.drawable.bg_hero_status_off);
                if (ivHeroStatusIcon != null) ivHeroStatusIcon.setImageResource(R.drawable.ic_detect_off);
                if (tvHeroStatusTitle != null) tvHeroStatusTitle.setText(R.string.home_status_inactive);
                if (tvHeroStatusSubtitle != null) tvHeroStatusSubtitle.setText(R.string.APP_reco_off);
            }
        }

        if (this.Detect != null) {
            this.Detect.setChecked(isEnabled);
            this.Detect.setIcon(isEnabled ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
        }
    }

    private void updatePermissionPills() {
        // 1. Overlay
        boolean hasOverlay = Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this);
        if (pillOverlay != null && tvPillOverlayStatus != null) {
            if (hasOverlay) {
                pillOverlay.setBackgroundResource(R.drawable.bg_pill_permission_ok);
                tvPillOverlayStatus.setText(R.string.home_perm_ok);
                tvPillOverlayStatus.setTextColor(Color.parseColor("#A7F3D0"));
            } else {
                pillOverlay.setBackgroundResource(R.drawable.bg_pill_permission_warn);
                tvPillOverlayStatus.setText(R.string.home_perm_missing);
                tvPillOverlayStatus.setTextColor(Color.parseColor("#FDE68A"));
            }
        }

        // 2. Notification Listener
        boolean hasNotifAccess = false;
        try {
            String listeners = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
            hasNotifAccess = listeners != null && listeners.contains(getPackageName());
        } catch (Exception ignored) {
        }
        if (pillNotif != null && tvPillNotifStatus != null) {
            if (hasNotifAccess) {
                pillNotif.setBackgroundResource(R.drawable.bg_pill_permission_ok);
                tvPillNotifStatus.setText(R.string.home_perm_ok);
                tvPillNotifStatus.setTextColor(Color.parseColor("#A7F3D0"));
            } else {
                pillNotif.setBackgroundResource(R.drawable.bg_pill_permission_warn);
                tvPillNotifStatus.setText(R.string.home_perm_missing);
                tvPillNotifStatus.setTextColor(Color.parseColor("#FDE68A"));
            }
        }

        // 3. Location
        boolean hasLocation = Build.VERSION.SDK_INT < 23 ||
                (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                 ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED);
        if (pillLocation != null && tvPillLocationStatus != null) {
            if (hasLocation) {
                pillLocation.setBackgroundResource(R.drawable.bg_pill_permission_ok);
                tvPillLocationStatus.setText(R.string.home_perm_ok);
                tvPillLocationStatus.setTextColor(Color.parseColor("#A7F3D0"));
            } else {
                pillLocation.setBackgroundResource(R.drawable.bg_pill_permission_warn);
                tvPillLocationStatus.setText(R.string.home_perm_missing);
                tvPillLocationStatus.setTextColor(Color.parseColor("#FDE68A"));
            }
        }
    }

    private int dpToPx() {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6.0f, getResources().getDisplayMetrics()));
    }

    private void resetTitle() {
        try {
            int i = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA).labelRes;
            if (i != 0) {
                setTitle(i);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Crashlytics.log(e.getMessage());
        }
    }

    private void setNotifChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup("grpTog", "התראות מקרים");
            NotificationChannelGroup notificationChannelGroup2 = new NotificationChannelGroup("grpOthers", "התראות שונות");
            NotificationChannel notificationChannel = new NotificationChannel("runInBg", "פעילות ברקע", NotificationManager.IMPORTANCE_LOW);
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setDescription("חיוני כדי לאפשר זיהוי מקרים");
            notificationChannel.setGroup("grpOthers");

            NotificationChannel notificationChannel2 = new NotificationChannel("Push", "הודעות פוש", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel2.enableVibration(true);
            notificationChannel2.setBypassDnd(true);
            notificationChannel2.setDescription("התראות להודעות פוש שישלחו כגון בקשות קוד וכדו'");
            notificationChannel2.enableLights(true);
            notificationChannel2.setShowBadge(true);
            notificationChannel2.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel2.setGroup("grpOthers");

            NotificationChannel notificationChannel3 = new NotificationChannel("notWithWin", "זיהוי הודעות", NotificationManager.IMPORTANCE_LOW);
            notificationChannel3.enableVibration(false);
            notificationChannel3.setBypassDnd(false);
            notificationChannel3.setDescription("התראות עבור הודעות כאשר מוגדר להקפיץ גם חלון");
            notificationChannel3.enableLights(false);
            notificationChannel3.setShowBadge(true);
            notificationChannel3.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel3.setGroup("grpTog");

            this.manager = (NotificationManager) getSystemService(NotificationManager.class);
            if (this.manager != null) {
                this.manager.createNotificationChannelGroup(notificationChannelGroup);
                this.manager.createNotificationChannelGroup(notificationChannelGroup2);
                this.manager.createNotificationChannel(notificationChannel);
                this.manager.createNotificationChannel(notificationChannel2);
                this.manager.createNotificationChannel(notificationChannel3);
            }
        }
    }

    private void checkLocationPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
                builder.setTitle("הרשאת מיקום");
                builder.setMessage("כדי לחשב מרחק וצפי זמן הגעה מדויקים לקריאות חירום, האפליקציה זקוקה לגישה למיקום המכשיר.");
                builder.setPositiveButton(getString(R.string.permYes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            ActivityCompat.requestPermissions(HomePage.this, new String[]{
                                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                            }, LOCATION_PER_REQ);
                        }
                    }
                });
                builder.setNegativeButton(getString(R.string.dialog_no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        DialogOnShowListener(dialog);
                    }
                });
                dialog.show();
            }
        }
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    @Override
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == OVERLAY_PER_REQ) {
            updatePermissionPills();
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
                ShowDialog(getString(R.string.permDesOverlay), getString(R.string.permTitle), getString(R.string.permYes), new Intent(getApplicationContext(), SettingsPage.class), true, OVERLAY_PER_REQ);
            }
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        setTheme(R.style.MyMaterialTheme);
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_home_page);
        setNotifChannels();
        rateUs.app_launched(this);
        MyFirebaseMessagingService.getToken(getApplicationContext());

        String string3 = getSharedPreferences("Settings", 0).getString("fcm", "empty");
        Crashlytics.setUserIdentifier(string3);
        try {
            this.myTypeface = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        } catch (Exception ignored) {
        }

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseAnalytics.getInstance(getApplicationContext());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }

        // Initialize Hero Card Views
        layoutHeroContent = (LinearLayout) findViewById(R.id.layoutHeroContent);
        ivHeroStatusIcon = (ImageView) findViewById(R.id.ivHeroStatusIcon);
        tvHeroStatusTitle = (TextView) findViewById(R.id.tvHeroStatusTitle);
        tvHeroStatusSubtitle = (TextView) findViewById(R.id.tvHeroStatusSubtitle);
        switchDetection = (SwitchCompat) findViewById(R.id.switchDetection);

        if (switchDetection != null) {
            switchDetection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (!isSwitchUpdating) {
                        setDetectionState(isChecked);
                    }
                }
            });
        }

        // Initialize Permission Pills
        pillOverlay = (LinearLayout) findViewById(R.id.pillOverlay);
        tvPillOverlayTitle = (TextView) findViewById(R.id.tvPillOverlayTitle);
        tvPillOverlayStatus = (TextView) findViewById(R.id.tvPillOverlayStatus);

        pillNotif = (LinearLayout) findViewById(R.id.pillNotif);
        tvPillNotifTitle = (TextView) findViewById(R.id.tvPillNotifTitle);
        tvPillNotifStatus = (TextView) findViewById(R.id.tvPillNotifStatus);

        pillLocation = (LinearLayout) findViewById(R.id.pillLocation);
        tvPillLocationTitle = (TextView) findViewById(R.id.tvPillLocationTitle);
        tvPillLocationStatus = (TextView) findViewById(R.id.tvPillLocationStatus);

        if (this.myTypeface != null) {
            if (tvHeroStatusTitle != null) tvHeroStatusTitle.setTypeface(this.myTypeface);
            if (tvHeroStatusSubtitle != null) tvHeroStatusSubtitle.setTypeface(this.myTypeface);
            if (tvPillOverlayTitle != null) tvPillOverlayTitle.setTypeface(this.myTypeface);
            if (tvPillOverlayStatus != null) tvPillOverlayStatus.setTypeface(this.myTypeface);
            if (tvPillNotifTitle != null) tvPillNotifTitle.setTypeface(this.myTypeface);
            if (tvPillNotifStatus != null) tvPillNotifStatus.setTypeface(this.myTypeface);
            if (tvPillLocationTitle != null) tvPillLocationTitle.setTypeface(this.myTypeface);
            if (tvPillLocationStatus != null) tvPillLocationStatus.setTypeface(this.myTypeface);
        }

        if (pillOverlay != null) {
            pillOverlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(HomePage.this)) {
                        try {
                            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                            startActivityForResult(intent, OVERLAY_PER_REQ);
                        } catch (Exception e) {
                            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION), OVERLAY_PER_REQ);
                        }
                    } else {
                        Toast.makeText(HomePage.this, "הרשאת מסך צף מופעלת ותקינה", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (pillNotif != null) {
            pillNotif.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                    } catch (Exception e) {
                        Toast.makeText(HomePage.this, "נא לגשת להגדרות התראות במכשיר", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (pillLocation != null) {
            pillLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkLocationPermission();
                }
            });
        }

        // Initialize RecyclerView with 5 Action Cards
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });
        ArrayList<HomeB> arrayList = new ArrayList<>();
        this.adapter = new homeBAdapter(this, arrayList);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(this.adapter);
        }

        try {
            arrayList.add(new HomeB("tol", R.drawable.new_tol));
            arrayList.add(new HomeB("mok", R.drawable.new_mok));
            arrayList.add(new HomeB("tes", R.drawable.new_tes));
            arrayList.add(new HomeB("gui", R.drawable.new_inf));
            arrayList.add(new HomeB("set", R.drawable.ic_settings));
            Crashlytics.log("HomeBtns Loaded properly!");
        } catch (Exception e3) {
            Crashlytics.log("HomeBtns caused crash!");
            Crashlytics.logException(e3);
        }
        this.adapter.notifyDataSetChanged();

        updateDashboardState();
        updatePermissionPills();

        boolean z2 = sharedPreferences.getBoolean("privacy", false);
        if (sharedPreferences.getBoolean("oldU", false)) {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
                ShowDialog(getString(R.string.permDesOverlay), getString(R.string.permTitle), getString(R.string.permYes), new Intent(getApplicationContext(), SettingsPage.class), true, OVERLAY_PER_REQ);
            } else if (!z2) {
                Intent intent = new Intent(this, PrivacyActivity.class);
                ShowDialog(getString(R.string.privacyMsg), getString(R.string.title_activity_privacy), intent);
            }
            checkLocationPermission();
        } else {
            Intent intent = new Intent(getApplicationContext(), SettingsPage.class);
            ShowDialog(getString(R.string.newSettings), getString(R.string.title_activity_settings), intent);
            checkLocationPermission();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        int i = sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off;
        this.Detect = menu.findItem(R.id.one);
        if (this.Detect != null) {
            this.Detect.setCheckable(true).setChecked(sharedPreferences.getBoolean("Mapp", false)).setIcon(i);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == android.R.id.home) {
            finish();
            return true;
        }
        if (itemId == R.id.action_settings) {
            startActivity(new Intent(this, SettingsPage.class));
            return true;
        }
        if (itemId == R.id.one) {
            boolean currentState = menuItem.isChecked();
            setDetectionState(!currentState);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        if (sharedPreferences.getBoolean("WasLangChanged", false)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("WasLangChanged", false);
            edit.apply();
            recreate();
            return;
        }
        updateDashboardState();
        updatePermissionPills();
    }
}
