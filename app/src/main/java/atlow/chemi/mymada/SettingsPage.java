package atlow.chemi.mymada;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import atlow.chemi.mymada.fragments.SettingsAdvanced;
import atlow.chemi.mymada.fragments.SettingsAmpm;
import atlow.chemi.mymada.fragments.SettingsNotifications;
import atlow.chemi.mymada.fragments.SettingsNotificationsSounds;
import atlow.chemi.mymada.fragments.SettingsTools;
import atlow.chemi.mymada.helpers.LocalHelper;
import atlow.chemi.mymada.helpers.MyDrawerLayout;
import com.crashlytics.android.Crashlytics;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class SettingsPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int OVERLAY_PER_REQ = 345;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private MenuItem Detect;
    private MyDrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private Typeface myTypeface;
    private NavigationView navigationView;
    private Button negBtn;
    private Button posBtn;
    private ProgressBar progressBar;
    private TextView progressText;
    private SharedPreferences sp;

    private int mySessionId = 0;
    private boolean isDrawerLocked = false;
    private String[] Langs = {"עברית", "English", "العربية"};
    private String[] Mokdim = {"ירושלים", "איילון", "אשר", "גלבוע", "דן", "ירדן", "ירקון", "כרמל", "לכיש", "נגב", "שרון", "מוקד 4"};
    private Fragment settingsNotifications = new SettingsNotifications();
    private Fragment settingsNotifSou = new SettingsNotificationsSounds();
    private Fragment settingsAdvanced = new SettingsAdvanced();
    private Fragment settingsAmPm = new SettingsAmpm();
    private Fragment settingsTools = new SettingsTools();

    private void CreateLangDialog() {
        String curLang = LocalHelper.getLanguage(this);
        int curIndex = 0;
        if ("en".equalsIgnoreCase(curLang)) {
            curIndex = 1;
        } else if ("ar".equalsIgnoreCase(curLang)) {
            curIndex = 2;
        } else {
            curIndex = 0;
        }
        final int initialIndex = curIndex;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle(getString(R.string.pref_title_lang));
        builder.setNegativeButton(getString(R.string.ret), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.setSingleChoiceItems(this.Langs, initialIndex, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i2) {
                SettingsPage.this.a(initialIndex, dialogInterface, i2);
            }
        });
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                SettingsPage.this.a(create, dialogInterface);
            }
        });
        create.show();
    }

    private void CreateOverlayPermissionDialog() {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(getResources().getString(R.string.permDesOverlay)).setCancelable(false).setTitle(getString(R.string.permTitle)).setPositiveButton(getResources().getString(R.string.permYes), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.c0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsPage.this.a(dialogInterface, i);
            }
        }).setNegativeButton(getResources().getString(R.string.dialog_no), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.q0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.b0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SettingsPage.this.b(create, dialogInterface);
            }
        });
        create.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r2.contains(r3) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void ShowDialog(String msg, String btnText, final Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(msg).setCancelable(false)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            startActivity(intent);
                        } catch (Exception ignored) {
                        }
                    }
                })
                .setNegativeButton(R.string.dialog_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.show();
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
                androidx.core.content.ContextCompat.startForegroundService(this, new Intent(this, (Class<?>) atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class));
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
            android.widget.Toast.makeText(this, "זיהוי התראות מופעל", android.widget.Toast.LENGTH_SHORT).show();
        } else {
            try {
                stopService(new Intent(this, (Class<?>) atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class));
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
            android.widget.Toast.makeText(this, "זיהוי התראות כבוי", android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private void displayFragment(Fragment fragment, boolean z) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (z) {
            beginTransaction.setCustomAnimations(R.anim.enter_from_top, R.anim.exit_to_top);
        }
        beginTransaction.replace(R.id.frame, fragment);
        beginTransaction.commit();
    }

    private boolean isCallable(Intent intent) {
        try {
            return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isRTL() {
        return isRTL(Locale.getDefault());
    }

    public static boolean isRTL(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == 1 || directionality == 2;
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

    public void HideProgressDialog(int i) {
        if (i != 0) {
            if (i == 1) {
                this.progressBar.setVisibility(8);
                this.progressText.setText(R.string.langBad);
                return;
            }
            return;
        }
        this.progressText.setText(getString(R.string.langLoad, new Object[]{"100%"}));
        Button button = this.posBtn;
        if (button != null) {
            button.setVisibility(0);
        }
        Button button2 = this.negBtn;
        if (button2 != null) {
            button2.setVisibility(8);
        }
    }

    public void ShowProgressDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.progress_bar_layout, (ViewGroup) null);
        builder.setView(inflate).setTitle("מוריד שפה").setCancelable(false).setNegativeButton(R.string.ret, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.o0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsPage.this.c(dialogInterface, i);
            }
        }).setPositiveButton(R.string.apply, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsPage.this.d(dialogInterface, i);
            }
        });
        this.progressBar = (ProgressBar) inflate.findViewById(R.id.progressBar2);
        this.progressText = (TextView) inflate.findViewById(R.id.loadTxt);
        this.progressText.setText(getString(R.string.langLoad, new Object[]{"0%"}));
        AlertDialog create = builder.create();
        create.show();
        this.posBtn = create.getButton(-1);
        this.posBtn.setVisibility(8);
        this.negBtn = create.getButton(-2);
    }

    public void a(int i, DialogInterface dialogInterface, int i2) {
        String str = "iw";
        if (i2 == 1) {
            str = "en";
        } else if (i2 == 2) {
            str = "ar";
        }
        if (i != i2) {
            LocalHelper.setLocale(getApplicationContext(), str);
            LocalHelper.setLocale(this, str);
            LocalHelper.applyLocale(this);
            SharedPreferences.Editor edit = getSharedPreferences("Settings", 0).edit();
            edit.putBoolean("WasLangChanged", true);
            edit.apply();

            Intent intent = new Intent(this, SettingsPage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        }
        dialogInterface.dismiss();
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), OVERLAY_PER_REQ);
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        alertDialog.getButton(-2).setTypeface(this.myTypeface);
    }

    public /* synthetic */ void a(Exception exc) {
        HideProgressDialog(0);
        Log.e("SPLIT MANAGER", "error");
        try {
            Snackbar make = Snackbar.make(findViewById(android.R.id.content), R.string.langBad, 0);
            ((TextView) make.getView().findViewById(com.google.android.material.R.id.snackbar_text)).setTextColor(-1);
            make.show();
        } catch (IllegalArgumentException e) {
            Crashlytics.logException(e);
        }
    }



    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putBoolean("pickedMoked", true);
        edit.putInt("merhav", i);
        edit.apply();
        dialogInterface.dismiss();
    }

    public /* synthetic */ void b(AlertDialog alertDialog, DialogInterface dialogInterface) {
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
        button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.OldPrimary));
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public /* synthetic */ void c(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void d(DialogInterface dialogInterface, int i) {
        recreate();
    }

    public /* synthetic */ void d(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(this.myTypeface);
        }
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public void displayFragment(Fragment fragment, int i) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.enter_from_top, R.anim.exit_to_top);
        beginTransaction.replace(R.id.frame, fragment);
        beginTransaction.commit();
        this.navigationView.setCheckedItem(i);
    }

    public /* synthetic */ void e(DialogInterface dialogInterface, int i) {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    public /* synthetic */ void e(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(this.myTypeface);
        }
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void f(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public /* synthetic */ void g(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public boolean isDeviceTablet() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.heightPixels / displayMetrics.ydpi;
        float f2 = displayMetrics.widthPixels / displayMetrics.xdpi;
        return (getResources().getConfiguration().orientation == 2) && Math.sqrt((double) ((f2 * f2) + (f * f))) >= 6.5d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.e("result", "activity result");
        if (i == OVERLAY_PER_REQ && i2 != -1) {
            CreateOverlayPermissionDialog();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.drawerLayout.isDrawerOpen(GravityCompat.START) || this.isDrawerLocked) {
            super.onBackPressed();
        } else {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LocalHelper.applyLocale(this);
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_utillities_and_tools);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.myTypeface = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        this.sp = getSharedPreferences("Settings", 0);
        boolean z = this.sp.getBoolean("Mapp", false);
        this.drawerLayout = (MyDrawerLayout) findViewById(R.id.activity_Utils);
        this.navigationView = (NavigationView) findViewById(R.id.navigation);
        this.navigationView.setNavigationItemSelectedListener(this);
        this.navigationView.inflateMenu(R.menu.settings_menu);
        if (isDeviceTablet()) {
            this.drawerLayout.setDrawerLockMode(2);
            this.drawerLayout.setScrimColor(0);
            this.isDrawerLocked = true;
        } else {
            this.drawerLayout.setDrawerLockMode(0);
            this.drawerLayout.setScrimColor(-1728053248);
            this.isDrawerLocked = false;
        }
        this.drawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawerLayout.addDrawerListener(this.drawerToggle);
        this.drawerToggle.syncState();
        this.Detect = this.navigationView.getMenu().findItem(R.id.detect);
        this.Detect.setIcon(z ? R.drawable.ic_detect_on : R.drawable.ic_detect_off).setChecked(z);
        if (bundle == null) {
            displayFragment(new SettingsNotifications(), false);
            this.navigationView.setCheckedItem(R.id.notification);
        }
        CreateOverlayPermissionDialog();
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Fragment fragment = new SettingsNotifications();
        boolean z = false;
        switch (itemId) {
            case R.id.advanced /* 2131362025 */:
                fragment = new SettingsAdvanced();
                break;
            case R.id.ampm /* 2131362030 */:
                fragment = new SettingsAmpm();
                break;
            case R.id.detect /* 2131362148 */:
                detectionBtn(menuItem);
                return true;
            case R.id.homeDrawer /* 2131362225 */:
                z = true;
                break;
            case R.id.language /* 2131362243 */:
                CreateLangDialog();
                return true;
            case R.id.soundAndVib /* 2131362458 */:
                fragment = new SettingsNotificationsSounds();
                break;
            case R.id.tools /* 2131362525 */:
                fragment = new SettingsTools();
                break;
            case R.id.notification:
            default:
                fragment = new SettingsNotifications();
                break;
        }
        if (z) {
            finish();
            return true;
        }
        if (!this.isDrawerLocked) {
            this.drawerLayout.closeDrawer(GravityCompat.START, true);
        }
        displayFragment(fragment, true);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        ActionBarDrawerToggle actionBarDrawerToggle = this.drawerToggle;
        if (actionBarDrawerToggle != null && actionBarDrawerToggle.onOptionsItemSelected(menuItem) && !this.isDrawerLocked) {
            return true;
        }
        if (!this.isDrawerLocked || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ActionBarDrawerToggle actionBarDrawerToggle = this.drawerToggle;
        if (actionBarDrawerToggle != null) {
            actionBarDrawerToggle.syncState();
        }
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putBoolean("oldU", true);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.drawerLayout == null || isDeviceTablet()) {
            MyDrawerLayout myDrawerLayout = this.drawerLayout;
            if (myDrawerLayout != null) {
                myDrawerLayout.setDrawerLockMode(2);
                this.drawerLayout.setScrimColor(0);
                this.isDrawerLocked = true;
            }
        } else {
            this.drawerLayout.setDrawerLockMode(0);
            this.drawerLayout.setScrimColor(-1728053248);
            this.isDrawerLocked = false;
            this.drawerLayout.closeDrawer(this.navigationView);
            this.drawerToggle.syncState();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        boolean z = sharedPreferences.getBoolean("WasLangChanged", false);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("WasLangChanged", false);
        edit.apply();
        if (z) {
            recreate();
        }
        if (this.Detect != null) {
            this.Detect.setIcon(sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
        }
    }
}
