package atlow.chemi.mymada;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import atlow.chemi.mymada.helpers.LocalHelper;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0015J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0012H\u0014J\u001c\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u000bH\u0016J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020#J\b\u0010*\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Latlow/chemi/mymada/InfoActivityKt;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnTouchListener;", "()V", "_requestPermissionSetting", "", "detect", "Landroid/view/MenuItem;", "goToPriv", "Lcom/google/android/gms/ads/InterstitialAd;", "isMove1", "", "oldX1", "", "oldY1", "privBtn", "Landroid/widget/Button;", "attachBaseContext", "", "base", "Landroid/content/Context;", "isCallable", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "onResume", "onTouch", "p0", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onWindowFocusChanged", "hasFocus", "privacy", "_view", "resetTitle", "app_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class InfoActivityKt extends AppCompatActivity implements View.OnTouchListener {
    private HashMap _$_findViewCache;
    private final int _requestPermissionSetting = 101;
    private MenuItem detect;
    private InterstitialAd goToPriv;
    private boolean isMove1;
    private float oldX1;
    private float oldY1;
    private Button privBtn;

    public static final /* synthetic */ MenuItem access$getDetect$p(InfoActivityKt infoActivityKt) {
        MenuItem menuItem = infoActivityKt.detect;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detect");
        }
        return menuItem;
    }

    public static final /* synthetic */ InterstitialAd access$getGoToPriv$p(InfoActivityKt infoActivityKt) {
        InterstitialAd interstitialAd = infoActivityKt.goToPriv;
        if (interstitialAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToPriv");
        }
        return interstitialAd;
    }

    private final boolean isCallable(Intent intent) {
        try {
            return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            Crashlytics.logException(e);
            return false;
        }
    }

    private final void resetTitle() {
        try {
            int i = getPackageManager().getActivityInfo(getComponentName(), 128).labelRes;
            if (i != 0) {
                setTitle(i);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Crashlytics.logException(e);
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(@NotNull Context base) {
        Intrinsics.checkParameterIsNotNull(base, "base");
        super.attachBaseContext(LocalHelper.onAttach(base));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resetTitle();
        setContentView(R.layout.activity_info);
        setSupportActionBar((Toolbar) _$_findCachedViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        TextView textView10 = (TextView) _$_findCachedViewById(R.id.textView10);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "textView10");
        textView10.setTypeface(createFromAsset);
        TextView textView102 = (TextView) _$_findCachedViewById(R.id.textView10);
        Intrinsics.checkExpressionValueIsNotNull(textView102, "textView10");
        textView102.setMovementMethod(new ScrollingMovementMethod());
        TextView textView103 = (TextView) _$_findCachedViewById(R.id.textView10);
        Intrinsics.checkExpressionValueIsNotNull(textView103, "textView10");
        textView103.setText(getResources().getString(R.string.TversionNumber, BuildConfig.VERSION_NAME));
        Button privB = (Button) _$_findCachedViewById(R.id.privB);
        Intrinsics.checkExpressionValueIsNotNull(privB, "privB");
        this.privBtn = privB;
        Button button = this.privBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privBtn");
        }
        button.setOnTouchListener(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        int i = sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off;
        MenuItem findItem = menu.findItem(R.id.one);
        Intrinsics.checkExpressionValueIsNotNull(findItem, "menu.findItem(R.id.one)");
        this.detect = findItem;
        menu.findItem(R.id.one).setCheckable(true).setChecked(sharedPreferences.getBoolean("Mapp", false)).setIcon(i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        if (r13 == false) goto L19;
     */
    @Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.action_settings) {
            startActivity(new Intent(this, (Class<?>) SettingsPage.class));
            return true;
        }
        if (itemId == R.id.one) {
            SharedPreferences sp = getSharedPreferences("Settings", 0);
            boolean newState = !sp.getBoolean("Mapp", false);
            sp.edit().putBoolean("Mapp", newState).apply();
            item.setChecked(newState);
            item.setIcon(newState ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int i = getSharedPreferences("Settings", 0).getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off;
        MenuItem menuItem = this.detect;
        if (menuItem != null) {
            if (menuItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detect");
            }
            menuItem.setIcon(i);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View p0, @Nullable MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            float f = 140;
            boolean z = this.oldX1 - event.getX() > f || event.getX() - this.oldX1 > f;
            float f2 = 50;
            boolean z2 = this.oldY1 - event.getY() > f2 || event.getY() - this.oldY1 > f2;
            if (z || z2) {
                this.isMove1 = true;
                Button button = this.privBtn;
                if (button == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privBtn");
                }
                button.setAlpha(1.0f);
            }
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 0) {
            this.oldY1 = event.getY();
            this.oldX1 = event.getX();
            this.isMove1 = false;
            Button button2 = this.privBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privBtn");
            }
            button2.setAlpha(0.4f);
            return true;
        }
        if (valueOf == null || valueOf.intValue() != 1) {
            return false;
        }
        Button button3 = this.privBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privBtn");
        }
        button3.setAlpha(1.0f);
        if (!this.isMove1) {
            Button button4 = this.privBtn;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privBtn");
            }
            button4.performClick();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Window window = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "window.decorView");
        double measuredWidth = decorView.getMeasuredWidth();
        Button button = this.privBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privBtn");
        }
        double height = button.getHeight();
        Double.isNaN(height);
        if (measuredWidth > height * 4.5d) {
            Log.e("window width", "do change");
            Button button2 = this.privBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privBtn");
            }
            ViewGroup.LayoutParams layoutParams = button2.getLayoutParams();
            Button button3 = this.privBtn;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privBtn");
            }
            layoutParams.width = button3.getHeight() * 4;
            Button button4 = this.privBtn;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privBtn");
            }
            button4.setLayoutParams(layoutParams);
        }
    }

    public final void privacy(@NotNull View _view) {
        Intrinsics.checkParameterIsNotNull(_view, "_view");
        Intent intent = new Intent(getApplicationContext(), (Class<?>) PrivacyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
