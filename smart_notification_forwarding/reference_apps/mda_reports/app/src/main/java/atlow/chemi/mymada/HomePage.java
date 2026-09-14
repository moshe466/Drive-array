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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
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

        GridSpacingItemDecoration(HomePage homePage, int i, int i2, boolean z) {
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

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (r2.contains(r3) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void detectionBtn(android.view.MenuItem r12) {
        /*
            r11 = this;
            r1 = 0
            java.lang.String r2 = "Settings"
            android.content.SharedPreferences r2 = r11.getSharedPreferences(r2, r1)
            android.content.SharedPreferences$Editor r7 = r2.edit()
            android.content.Context r2 = r11.getApplicationContext()
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.lang.String r3 = "enabled_notification_listeners"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)
            android.content.Context r3 = r11.getApplicationContext()
            java.lang.String r3 = r3.getPackageName()
            boolean r4 = r12.isChecked()
            java.lang.String r8 = "Mapp"
            if (r4 != 0) goto Le3
            r9 = 1
            r12.setChecked(r9)
            r1 = 2131230873(0x7f080099, float:1.8077811E38)
            r12.setIcon(r1)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.SMSMonitorService> r1 = atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class
            r0.<init>(r11, r1)
            androidx.core.content.ContextCompat.startForegroundService(r11, r0)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            r0.<init>(r1)
            boolean r0 = r11.isCallable(r0)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 18
            if (r4 < r5) goto Ldf
            r6 = 101(0x65, float:1.42E-43)
            java.lang.String r4 = "android.settings.ACCESSIBILITY_SETTINGS"
            r5 = 2131820698(0x7f11009a, float:1.9274118E38)
            r10 = 2131820694(0x7f110096, float:1.927411E38)
            if (r0 == 0) goto La9
            if (r2 == 0) goto L62
            boolean r0 = r2.contains(r3)     // Catch: android.content.ActivityNotFoundException -> L77
            if (r0 != 0) goto L72
        L62:
            java.lang.String r0 = r11.getString(r10)     // Catch: android.content.ActivityNotFoundException -> L77
            java.lang.String r2 = r11.getString(r5)     // Catch: android.content.ActivityNotFoundException -> L77
            android.content.Intent r3 = new android.content.Intent     // Catch: android.content.ActivityNotFoundException -> L77
            r3.<init>(r1)     // Catch: android.content.ActivityNotFoundException -> L77
            r11.ShowDialog(r0, r2, r3)     // Catch: android.content.ActivityNotFoundException -> L77
        L72:
            r7.putBoolean(r8, r9)     // Catch: android.content.ActivityNotFoundException -> L77
            goto Lf9
        L77:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.NotificationService> r1 = atlow.chemi.mymada.NotificationService.class
            r0.<init>(r11, r1)
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.NotificationServiceOld> r2 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.class
            r1.<init>(r11, r2)
            r11.stopService(r0)
            r11.startService(r1)
            android.content.Context r0 = r11.getApplicationContext()
            boolean r0 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.isAccessibilitySettingsOn(r0)
            if (r0 != 0) goto Ldf
            java.lang.String r1 = r11.getString(r10)
            r2 = 0
            java.lang.String r3 = r11.getString(r5)
            android.content.Intent r5 = new android.content.Intent
            r5.<init>(r4)
            r10 = 1
            r0 = r11
            r4 = r5
            r5 = r10
            goto Ldc
        La9:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.NotificationService> r1 = atlow.chemi.mymada.NotificationService.class
            r0.<init>(r11, r1)
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.NotificationServiceOld> r2 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.class
            r1.<init>(r11, r2)
            r11.stopService(r0)
            r11.startService(r1)
            android.content.Context r0 = r11.getApplicationContext()
            boolean r0 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.isAccessibilitySettingsOn(r0)
            if (r0 != 0) goto Ldf
            java.lang.String r1 = r11.getString(r10)
            r2 = 0
            java.lang.String r3 = r11.getString(r5)
            android.content.Intent r5 = new android.content.Intent
            r5.<init>(r4)
            r6 = 1
            r10 = 101(0x65, float:1.42E-43)
            r0 = r11
            r4 = r5
            r5 = r6
            r6 = r10
        Ldc:
            r0.ShowDialog(r1, r2, r3, r4, r5, r6)
        Ldf:
            r7.putBoolean(r8, r9)
            goto Lf9
        Le3:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.SMSMonitorService> r3 = atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class
            r2.<init>(r11, r3)
            r11.stopService(r2)
            r12.setChecked(r1)
            r7.putBoolean(r8, r1)
            r1 = 2131230872(0x7f080098, float:1.807781E38)
            r12.setIcon(r1)
        Lf9:
            r7.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.HomePage.detectionBtn(android.view.MenuItem):void");
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
        try {
            MobileAds.initialize(getApplicationContext(), "ca-app-pub-7600269766434003/5732229370");
            ((AdView) findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());
            Crashlytics.log("Ads Loaded");
        } catch (Exception e2) {
            Crashlytics.log("Ads Not Loaded");
            Crashlytics.logException(e2);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: atlow.chemi.mymada.HomePage.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i2) {
                return i2 == 0 ? 2 : 1;
            }
        });
        ArrayList arrayList = new ArrayList();
        this.adapter = new homeBAdapter(this, arrayList);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(this, 2, dpToPx(), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.adapter);
        try {
            arrayList.add(new HomeB("tol", R.drawable.new_tol));
            arrayList.add(new HomeB("mok", R.drawable.new_mok));
            arrayList.add(new HomeB("tes", R.drawable.new_tes));
            arrayList.add(new HomeB("con", R.drawable.new_con));
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
                return;
            }
            return;
        }
        string = getString(R.string.newSettings);
        string2 = getString(R.string.title_activity_settings);
        intent = new Intent(getApplicationContext(), (Class<?>) SettingsPage.class);
        ShowDialog(string, string2, intent);
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
