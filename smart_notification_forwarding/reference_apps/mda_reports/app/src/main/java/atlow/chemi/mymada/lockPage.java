package atlow.chemi.mymada;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import atlow.chemi.mymada.helpers.LocalHelper;
import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class lockPage extends AppCompatActivity implements View.OnTouchListener {
    private boolean isMove = false;
    private float oldX;
    private float oldY;

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

    public void TZ_app(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=com.groboot.mdaemergency"));
        try {
            startActivity(intent);
        } catch (Exception unused) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.groboot.mdaemergency"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public void cod(View view) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) codeC.class);
        intent.setFlags(268435456);
        finish();
        startActivity(intent);
    }

    public void cond(View view) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) codeRequest.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_not_mada);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.b9).setOnTouchListener(this);
        findViewById(R.id.b6).setOnTouchListener(this);
        findViewById(R.id.b4).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldX = motionEvent.getX();
            this.oldY = motionEvent.getY();
            this.isMove = false;
            view.setAlpha(0.4f);
            return true;
        }
        if (action == 1) {
            view.setAlpha(1.0f);
            if (!this.isMove) {
                view.performClick();
            }
        } else if (action == 2) {
            boolean z = this.oldX - motionEvent.getX() > 30.0f || motionEvent.getX() - this.oldX > 30.0f;
            boolean z2 = this.oldY - motionEvent.getY() > 30.0f || motionEvent.getY() - this.oldY > 30.0f;
            if (z || z2) {
                this.isMove = true;
            }
            return true;
        }
        return false;
    }
}
