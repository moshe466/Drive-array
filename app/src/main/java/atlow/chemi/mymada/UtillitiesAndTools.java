package atlow.chemi.mymada;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import atlow.chemi.mymada.fragments.ApgarCalc;
import atlow.chemi.mymada.fragments.BlsProtocoles;
import atlow.chemi.mymada.fragments.ContracTimer;
import atlow.chemi.mymada.fragments.DictionaryAdmin;
import atlow.chemi.mymada.fragments.GlazgoCalc;
import atlow.chemi.mymada.fragments.MetroActivity;
import atlow.chemi.mymada.fragments.OxyCalc;
import atlow.chemi.mymada.fragments.PulseCalc;
import atlow.chemi.mymada.fragments.VitalsChecker;
import atlow.chemi.mymada.helpers.LocalHelper;
import atlow.chemi.mymada.helpers.MyDrawerLayout;
import com.crashlytics.android.Crashlytics;
import com.google.android.material.navigation.NavigationView;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class UtillitiesAndTools extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private MenuItem Detect;
    private MyDrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private Typeface myTypeface;
    private NavigationView navigationView;
    private boolean isDrawerLocked = false;
    private Fragment contracTimer = new ContracTimer();
    private Fragment pulseCalc = new PulseCalc();
    private Fragment metroActivity = new MetroActivity();
    private Fragment vitalsChecker = new VitalsChecker();
    private Fragment oxyCalc = new OxyCalc();
    private Fragment apgarCalc = new ApgarCalc();
    private Fragment glazgoCalc = new GlazgoCalc();
    private Fragment dictionaryAdmin = new DictionaryAdmin();
    private Fragment blsProtocoles = new BlsProtocoles();

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r2.contains(r3) == false) goto L11;
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

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
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
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public /* synthetic */ void c(AlertDialog alertDialog, DialogInterface dialogInterface) {
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

    public boolean isDeviceTablet() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.heightPixels / displayMetrics.ydpi;
        float f2 = displayMetrics.widthPixels / displayMetrics.xdpi;
        return (getResources().getConfiguration().orientation == 2) && Math.sqrt((double) ((f2 * f2) + (f * f))) >= 6.5d;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.drawerLayout.isDrawerOpen(GravityCompat.START) || this.isDrawerLocked) {
            super.onBackPressed();
        } else {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        LocalHelper.applyLocale(this);
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_utillities_and_tools);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.myTypeface = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        this.drawerLayout = (MyDrawerLayout) findViewById(R.id.activity_Utils);
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
        this.navigationView = (NavigationView) findViewById(R.id.navigation);
        this.navigationView.setNavigationItemSelectedListener(this);
        this.navigationView.inflateMenu(R.menu.navigation_menu);
        Menu menu = this.navigationView.getMenu();
        ((FrameLayout) findViewById(R.id.frame)).setPaddingRelative(getApplicationContext().getResources().getDimensionPixelSize(R.dimen.fragment_space), 0, 0, 0);
        Set<String> stringSet = getSharedPreferences("Settings", 0).getStringSet("Tools", new LinkedHashSet(Arrays.asList("contrac", "pulse", "metro", "vital", "oxy", "apgar", "glaz", "prot", "dict")));
        Fragment fragment = this.metroActivity;
        if (!stringSet.contains("dict")) {
            menu.removeItem(R.id.dictionary);
        }
        if (!stringSet.contains("prot")) {
            menu.removeItem(R.id.protocoles);
        }
        if (!stringSet.contains("glaz")) {
            menu.removeItem(R.id.glazgowCalc);
        }
        if (!stringSet.contains("apgar")) {
            menu.removeItem(R.id.apgarCalc);
        }
        if (!stringSet.contains("oxy")) {
            menu.removeItem(R.id.oxygenCalc);
        }
        if (!stringSet.contains("vital")) {
            menu.removeItem(R.id.vitalCalc);
        }
        if (!stringSet.contains("pulse")) {
            menu.removeItem(R.id.pulseCalc);
        }
        if (!stringSet.contains("contrac")) {
            menu.removeItem(R.id.contractionCalc);
        }
        if (!stringSet.contains("metro")) {
            menu.removeItem(R.id.metronome);
        }
        if (!stringSet.contains("metro")) {
            this.navigationView.setCheckedItem(menu.getItem(1));
            switch (menu.getItem(1).getItemId()) {
                case R.id.apgarCalc /* 2131362033 */:
                    fragment = this.apgarCalc;
                    break;
                case R.id.contractionCalc /* 2131362122 */:
                    fragment = this.contracTimer;
                    break;
                case R.id.dictionary /* 2131362152 */:
                    fragment = this.dictionaryAdmin;
                    break;
                case R.id.glazgowCalc /* 2131362215 */:
                    fragment = this.glazgoCalc;
                    break;
                case R.id.oxygenCalc /* 2131362359 */:
                    fragment = this.oxyCalc;
                    break;
                case R.id.protocoles /* 2131362377 */:
                    fragment = this.blsProtocoles;
                    break;
                case R.id.pulseCalc /* 2131362381 */:
                    fragment = this.pulseCalc;
                    break;
                case R.id.vitalCalc /* 2131362558 */:
                    fragment = this.vitalsChecker;
                    break;
            }
        } else {
            this.navigationView.setCheckedItem(R.id.metronome);
            fragment = this.metroActivity;
        }
        if (bundle == null) {
            displayFragment(fragment, false);
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

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Fragment fragment = this.metroActivity;
        boolean z = false;
        switch (itemId) {
            case R.id.als /* 2131362028 */:
                fragment = this.blsProtocoles;
                ((BlsProtocoles) fragment).setCurrentPage(1);
                break;
            case R.id.apgarCalc /* 2131362033 */:
                fragment = this.apgarCalc;
                break;
            case R.id.bls /* 2131362055 */:
                fragment = this.blsProtocoles;
                ((BlsProtocoles) fragment).setCurrentPage(0);
                break;
            case R.id.contractionCalc /* 2131362122 */:
                fragment = this.contracTimer;
                break;
            case R.id.dictionary /* 2131362152 */:
                fragment = this.dictionaryAdmin;
                break;
            case R.id.glazgowCalc /* 2131362215 */:
                fragment = this.glazgoCalc;
                break;
            case R.id.homeDrawer /* 2131362225 */:
                z = true;
                break;
            case R.id.oxygenCalc /* 2131362359 */:
                fragment = this.oxyCalc;
                break;
            case R.id.pulseCalc /* 2131362381 */:
                fragment = this.pulseCalc;
                break;
            case R.id.vitalCalc /* 2131362558 */:
                fragment = this.vitalsChecker;
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

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.drawerToggle.syncState();
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
