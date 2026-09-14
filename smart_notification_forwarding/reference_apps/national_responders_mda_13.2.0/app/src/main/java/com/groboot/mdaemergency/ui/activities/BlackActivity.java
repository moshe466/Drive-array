package com.groboot.mdaemergency.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class BlackActivity extends Activity {

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(BlackActivity.this.getApplicationContext(), (Class<?>) SplashActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(p.f7896v, "Windows");
            intent.putExtra(p.f7897w, p.f7899y);
            BlackActivity.this.startActivity(intent);
            BlackActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_black);
        findViewById(R.id.btn_moveToApp).setOnClickListener(new a());
    }
}
