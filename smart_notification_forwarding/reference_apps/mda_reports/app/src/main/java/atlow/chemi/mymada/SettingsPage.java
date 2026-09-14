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
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
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
    private SplitInstallManager splitInstallManager;
    private int mySessionId = 0;
    private boolean isDrawerLocked = false;
    private String[] Langs = {"עברית", "English"};
    private String[] Mokdim = {"ירושלים", "איילון", "אשר", "גלבוע", "דן", "ירדן", "ירקון", "כרמל", "לכיש", "נגב", "שרון", "מוקד 4"};
    private Fragment settingsNotifications = new SettingsNotifications();
    private Fragment settingsNotifSou = new SettingsNotificationsSounds();
    private Fragment settingsAdvanced = new SettingsAdvanced();
    private Fragment settingsAmPm = new SettingsAmpm();
    private Fragment settingsTools = new SettingsTools();

    private void CreateLangDialog() {
        final int i = !LocalHelper.getLanguage(this).equals("iw") ? 1 : 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle(getString(R.string.pref_title_lang));
        builder.setNegativeButton(getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.n0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.setSingleChoiceItems(this.Langs, i, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.f0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SettingsPage.this.a(i, dialogInterface, i2);
            }
        });
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.s0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
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

    private void PickMokedDialog() {
        int i = this.sp.getInt("merhav", 0);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle(getString(R.string.pref_title_region));
        builder.setNegativeButton(getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.k0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.setSingleChoiceItems(this.Mokdim, i, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SettingsPage.this.b(dialogInterface, i2);
            }
        });
        builder.create().show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r2.contains(r3) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void detectionBtn(android.view.MenuItem r12) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.SettingsPage.detectionBtn(android.view.MenuItem):void");
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

    public /* synthetic */ void a(int i, DialogInterface dialogInterface, int i2) {
        final String str = i2 == 0 ? "iw" : "en";
        if (i != i2) {
            if (Build.VERSION.SDK_INT >= 21) {
                SplitInstallStateUpdatedListener splitInstallStateUpdatedListener = new SplitInstallStateUpdatedListener() { // from class: atlow.chemi.mymada.t0
                    @Override // com.google.android.play.core.listener.StateUpdatedListener
                    public final void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
                        SettingsPage.this.a(str, splitInstallSessionState);
                    }
                };
                this.splitInstallManager = SplitInstallManagerFactory.create(getApplicationContext());
                Set<String> installedLanguages = this.splitInstallManager.getInstalledLanguages();
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = installedLanguages.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(", ");
                }
                Log.e("SPLIT MANAGER", "available lang " + ((Object) sb));
                Log.e("SPLIT MANAGER", "requested lang " + str);
                this.splitInstallManager.registerListener(splitInstallStateUpdatedListener);
                SplitInstallRequest build = SplitInstallRequest.newBuilder().addLanguage(Locale.forLanguageTag(str)).build();
                ShowProgressDialog();
                this.splitInstallManager.startInstall(build).addOnSuccessListener(new OnSuccessListener() { // from class: atlow.chemi.mymada.g0
                    @Override // com.google.android.play.core.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        SettingsPage.this.a((Integer) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: atlow.chemi.mymada.e0
                    @Override // com.google.android.play.core.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        SettingsPage.this.a(exc);
                    }
                });
            } else {
                LocalHelper.setLocale(getApplicationContext(), str);
                recreate();
            }
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
            ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
            make.show();
        } catch (IllegalArgumentException e) {
            Crashlytics.logException(e);
        }
    }

    public /* synthetic */ void a(Integer num) {
        this.mySessionId = num.intValue();
    }

    public /* synthetic */ void a(String str, SplitInstallSessionState splitInstallSessionState) {
        Log.e("SPLIT MANAGER", "error code is: " + splitInstallSessionState.errorCode());
        Log.e("SPLIT MANAGER", "status code is: " + splitInstallSessionState.status());
        if (splitInstallSessionState.status() == 6 && (splitInstallSessionState.errorCode() == -9 || splitInstallSessionState.errorCode() == -6)) {
            HideProgressDialog(1);
            return;
        }
        if (splitInstallSessionState.sessionId() == this.mySessionId) {
            Log.e("SPLIT MANAGER", "status session is: " + splitInstallSessionState.sessionId());
            int i = (int) splitInstallSessionState.totalBytesToDownload();
            int bytesDownloaded = (int) splitInstallSessionState.bytesDownloaded();
            long bytesDownloaded2 = (splitInstallSessionState.totalBytesToDownload() / 100) * splitInstallSessionState.bytesDownloaded();
            switch (splitInstallSessionState.status()) {
                case 0:
                case 1:
                case 3:
                case 4:
                case 6:
                case 7:
                case 8:
                case 9:
                    HideProgressDialog(1);
                    return;
                case 2:
                    Log.e("SPLIT MANAGER", "downloading");
                    this.progressBar.setMax(i);
                    this.progressBar.setProgress(bytesDownloaded);
                    this.progressText.setText(getString(R.string.langLoad, new Object[]{bytesDownloaded2 + "%"}));
                    return;
                case 5:
                    this.progressBar.setMax(1);
                    this.progressBar.setProgress(1);
                    HideProgressDialog(0);
                    LocalHelper.setLocale(getApplicationContext(), str);
                    return;
                default:
                    return;
            }
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
        SplitInstallManager splitInstallManager = this.splitInstallManager;
        if (splitInstallManager != null) {
            splitInstallManager.cancelInstall(this.mySessionId);
        }
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
            displayFragment(this.settingsNotifications, false);
            this.navigationView.setCheckedItem(R.id.notification);
        }
        CreateOverlayPermissionDialog();
        if (getIntent().getBooleanExtra("pickMoked", false)) {
            PickMokedDialog();
        }
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Fragment fragment = this.settingsNotifications;
        boolean z = false;
        switch (itemId) {
            case R.id.advanced /* 2131362025 */:
                fragment = this.settingsAdvanced;
                break;
            case R.id.ampm /* 2131362030 */:
                fragment = this.settingsAmPm;
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
            case R.id.mokedPick /* 2131362312 */:
                PickMokedDialog();
                return true;
            case R.id.soundAndVib /* 2131362458 */:
                fragment = this.settingsNotifSou;
                break;
            case R.id.tools /* 2131362525 */:
                fragment = this.settingsTools;
                break;
        }
        if (z) {
            finish();
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
