package atlow.chemi.mymada;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import atlow.chemi.mymada.fragments.MainActivity1;
import atlow.chemi.mymada.fragments.MainActivity2;
import atlow.chemi.mymada.fragments.MainActivity3;
import atlow.chemi.mymada.helpers.LocalHelper;
import com.crashlytics.android.Crashlytics;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MokedPage extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private MenuItem Detect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;

        ViewPagerAdapter(MokedPage mokedPage, FragmentManager fragmentManager) {
            super(fragmentManager, 1);
            this.mFragmentList = new ArrayList();
            this.mFragmentTitleList = new ArrayList();
        }

        void a(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragmentList.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NonNull
        public Fragment getItem(int i) {
            return this.mFragmentList.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mFragmentTitleList.get(i);
        }
    }

    private boolean isCallable(Intent intent) {
        try {
            return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            Crashlytics.logException(e);
            return false;
        }
    }

    private static boolean isPI(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.groboot.mdaemergency");
        return launchIntentForPackage != null && packageManager.queryIntentActivities(launchIntentForPackage, 65536).size() > 0;
    }

    private void resetTitle() {
        try {
            int i = getPackageManager().getActivityInfo(getComponentName(), 128).labelRes;
            if (i != 0) {
                setTitle(i);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Crashlytics.logException(e);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager());
        viewPagerAdapter.a(new MainActivity1(), getString(R.string.button_a));
        viewPagerAdapter.a(new MainActivity2(), getString(R.string.button_b));
        viewPagerAdapter.a(new MainActivity3(), getString(R.string.button_i));
        viewPager.setAdapter(viewPagerAdapter);
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this, (Class<?>) SettingsPage.class);
        intent.putExtra("pickMoked", true);
        startActivity(intent);
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void a(AlertDialog alertDialog, Typeface typeface, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(typeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(typeface);
        }
        Button button = alertDialog.getButton(-2);
        alertDialog.getButton(-1).setTypeface(typeface);
        button.setTypeface(typeface);
        button.setTextColor(getResources().getColor(R.color.ColorPrimary));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    public /* synthetic */ void b(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public /* synthetic */ void c(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void d(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_moked_page);
        if (!getSharedPreferences("Settings", 0).getBoolean("realM", false) && !isPI(this)) {
            Intent intent = new Intent(this, (Class<?>) lockPage.class);
            intent.setFlags(268435456);
            finish();
            startActivity(intent);
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        if (SettingsPage.isRTL()) {
            viewPager.setRotationY(180.0f);
        }
        if (!getIntent().getBooleanExtra(NotificationCompat.CATEGORY_MESSAGE, false)) {
            viewPager.setCurrentItem(1);
        }
        ((TabLayout) findViewById(R.id.tabs)).setupWithViewPager(viewPager);
        if (getSharedPreferences("Settings", 0).getBoolean("pickedMoked", false)) {
            return;
        }
        final Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this, R.style.AlertDialogStyle).setTitle(getString(R.string.pickMokTtl)).setMessage(getString(R.string.pickMokTxt)).setPositiveButton(getString(R.string.goToSet), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MokedPage.this.a(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.skip), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog create = negativeButton.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.n
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                MokedPage.this.a(create, createFromAsset, dialogInterface);
            }
        });
        negativeButton.show();
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

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        if (r2.contains(r3) == false) goto L19;
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r12) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.MokedPage.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        if (this.Detect != null) {
            this.Detect.setIcon(sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
        }
    }
}
