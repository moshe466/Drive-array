package atlow.chemi.mymada;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
    public final String Grp2 = "grpOthers";
    public final String Grp3 = "grpTog";
    public final String CnlBg = "runInBg";
    public final String CnlWin = "notWithWin";

    /* loaded from: classes.dex */
    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private boolean includeEdge;
        private int spacing;
        private int spanCount;

        GridSpacingItemDecoration(int i, int i2, boolean z) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.spanCount;
            int i2 = childAdapterPosition % i;
            if (this.includeEdge) {
                int i3 = this.spacing;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (childAdapterPosition == 0) {
                    rect.top = i3;
                }
                rect.bottom = this.spacing;
                return;
            }
            int i4 = this.spacing;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition >= 1) {
                rect.top = i4;
            }
        }
    }

    private void DialogOnShowListener(AlertDialog alertDialog) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(this.myTypeface);
        }
        Button button = alertDialog.getButton(-2);
        alertDialog.getButton(-1).setTypeface(this.myTypeface);
        button.setTypeface(this.myTypeface);
        button.setTextColor(getResources().getColor(R.color.OldPrimary));
    }

    private void ShowDialog(String str, String str2, Intent intent) {
        ShowDialog(str, null, str2, intent, false, 0);
    }

    private void ShowDialog(String str, String str2, String str3, final Intent intent, final boolean z, final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(str).setCancelable(false).setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                HomePage.this.a(z, intent, i, dialogInterface, i2);
            }
        }).setNegativeButton(getResources().getString(R.string.dialog_no), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        if (str2 != null) {
            builder.setTitle(str2);
        }
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                HomePage.this.a(create, dialogInterface);
            }
        });
        create.show();
    }

    private void detectionBtn(android.view.MenuItem menuItem) {
        if (menuItem == null) return;
        SharedPreferences sp = getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor = sp.edit();
        boolean isCurrentlyEnabled = menuItem.isChecked();
        boolean newState = !isCurrentlyEnabled;
        menuItem.setChecked(newState);
        menuItem.setIcon(newState ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
        editor.putBoolean("Mapp", newState);
        editor.apply();

        if (newState) {
            try {
                ContextCompat.startForegroundService(this, new Intent(this, (Class<?>) atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class));
                Applicatio.tryConnectService(getApplicationContext());
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
            try {
                String listeners = android.provider.Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
                if (listeners == null || !listeners.contains(getPackageName())) {
                    ShowDialog(getString(R.string.dialog_help), getString(R.string.dialog_yes), new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                }
            } catch (Exception ignored) {
            }
            Toast.makeText(this, "זיהוי התראות מופעל", Toast.LENGTH_SHORT).show();
        } else {
            try {
                stopService(new Intent(this, (Class<?>) atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class));
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
            Toast.makeText(this, "זיהוי התראות כבוי", Toast.LENGTH_SHORT).show();
        }
    }

    private int dpToPx() {
        return Math.round(TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics()));
    }

    private boolean isCallable(Intent intent) {
        try {
            return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            Crashlytics.logException(e);
            return false;
        }
    }

    private void resetTitle() {
        try {
            int i = getPackageManager().getActivityInfo(getComponentName(), 128).labelRes;
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
            NotificationChannel notificationChannel = new NotificationChannel("runInBg", "פעילות ברקע", 1);
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setImportance(1);
            notificationChannel.setDescription("חיוני כדי לאפשר זיהוי מקרים");
            notificationChannel.setGroup("grpOthers");
            NotificationChannel notificationChannel2 = new NotificationChannel("Push", "הודעות פוש", 4);
            notificationChannel2.enableVibration(true);
            notificationChannel2.setBypassDnd(true);
            notificationChannel2.setDescription("התראות להודעות פוש שישלחו כגון בקשות קוד וכדו'");
            notificationChannel2.enableLights(true);
            notificationChannel2.setShowBadge(true);
            notificationChannel2.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel2.setGroup("grpOthers");
            NotificationChannel notificationChannel3 = new NotificationChannel("notWithWin", "זיהוי הודעות", 2);
            notificationChannel3.enableVibration(false);
            notificationChannel3.setBypassDnd(false);
            notificationChannel3.setDescription("התראות עבור הודעות כאשר מוגדר להקפיץ גם חלון");
            notificationChannel3.enableLights(false);
            notificationChannel3.setShowBadge(true);
            notificationChannel3.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel3.setGroup("grpTog");
            this.manager = (NotificationManager) getSystemService(NotificationManager.class);
            NotificationManager notificationManager = this.manager;
            if (notificationManager != null) {
                notificationManager.createNotificationChannelGroup(notificationChannelGroup);
                this.manager.createNotificationChannelGroup(notificationChannelGroup2);
                this.manager.createNotificationChannel(notificationChannel);
                this.manager.createNotificationChannel(notificationChannel2);
                this.manager.createNotificationChannel(notificationChannel3);
            }
        }
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        DialogOnShowListener(alertDialog);
    }

    public /* synthetic */ void a(boolean z, Intent intent, int i, DialogInterface dialogInterface, int i2) {
        if (z) {
            startActivityForResult(intent, i);
        } else {
            startActivity(intent);
        }
    }

    private static final int LOCATION_PER_REQ = 555;

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
                            requestPermissions(new String[]{
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

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 345 || i2 == -1 || Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
            return;
        }
        ShowDialog(getString(R.string.permDesOverlay), getString(R.string.permTitle), getString(R.string.permYes), new Intent(getApplicationContext(), (Class<?>) SettingsPage.class), true, 345);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String string;
        String string2;
        Intent intent;
        int i;
        setTheme(R.style.MyMaterialTheme);
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_home_page);
        setNotifChannels();
        rateUs.app_launched(this);
        MyFirebaseMessagingService.getToken(getApplicationContext());
        String string3 = getSharedPreferences("Settings", 0).getString("fcm", "empty");
        Crashlytics.setUserIdentifier(string3);
        this.myTypeface = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        boolean z = sharedPreferences.getBoolean("Mapp", false);
        try {
            Log.e("FCM token: ", string3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseAnalytics.getInstance(getApplicationContext());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        ArrayList arrayList = new ArrayList();
        this.adapter = new homeBAdapter(this, arrayList);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.adapter);
        try {
            arrayList.add(new HomeB("tol", R.drawable.new_tol));
            arrayList.add(new HomeB("mok", R.drawable.new_mok));
            arrayList.add(new HomeB("tes", R.drawable.new_tes));
            arrayList.add(new HomeB("inf", R.drawable.new_inf));
            Crashlytics.log("HomeBtns Loaded properly!");
        } catch (Exception e3) {
            Crashlytics.log("HomeBtns caused crash!");
            Crashlytics.logException(e3);
        }
        this.adapter.notifyDataSetChanged();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: atlow.chemi.mymada.HomePage.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView2, int i2) {
                if (i2 == 2) {
                    HomePage.this.adapter.setBtnsAlpha();
                }
                super.onScrollStateChanged(recyclerView2, i2);
            }
        });
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        boolean z2 = sharedPreferences.getBoolean("privacy", false);
        if (sharedPreferences.getBoolean("oldU", false)) {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
                ShowDialog(getString(R.string.permDesOverlay), getString(R.string.permTitle), getString(R.string.permYes), new Intent(getApplicationContext(), (Class<?>) SettingsPage.class), true, 345);
            } else if (!z2) {
                string = getString(R.string.privacyMsg);
                string2 = getString(R.string.title_activity_privacy);
                intent = new Intent(this, (Class<?>) PrivacyActivity.class);
            }
            if (z || Build.VERSION.SDK_INT < 26) {
            }
            this.manager = (NotificationManager) getSystemService(NotificationManager.class);
            if (this.manager != null) {
                Log.e("importance", "is" + this.manager.getNotificationChannel("runInBg").getImportance());
                i = this.manager.getNotificationChannel("runInBg").getImportance();
            } else {
                i = 1;
            }
            Log.d("importance", "is " + i);
            if (i != 1) {
                Intent intent2 = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent2.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                intent2.putExtra("android.provider.extra.CHANNEL_ID", "runInBg");
                ShowDialog(getString(R.string.importanceMsg), getString(R.string.importance), intent2);
                checkLocationPermission();
                return;
            }
            checkLocationPermission();
            return;
        }
        string = getString(R.string.newSettings);
        string2 = getString(R.string.title_activity_settings);
        intent = new Intent(getApplicationContext(), (Class<?>) SettingsPage.class);
        ShowDialog(string, string2, intent);
        checkLocationPermission();
        if (z) {
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        int i = sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off;
        this.Detect = menu.findItem(R.id.one);
        menu.findItem(R.id.one).setCheckable(true).setChecked(sharedPreferences.getBoolean("Mapp", false)).setIcon(i);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.action_settings) {
            startActivity(new Intent(this, (Class<?>) SettingsPage.class));
            return true;
        }
        if (itemId != R.id.one) {
            return super.onOptionsItemSelected(menuItem);
        }
        detectionBtn(menuItem);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        if (sharedPreferences.getBoolean("WasLangChanged", false)) {
            recreate();
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("WasLangChanged", false);
        edit.apply();
        if (this.Detect != null) {
            this.Detect.setIcon(sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
        }
    }
}
