package com.samsung.android.sbrowser.ext;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
        setContentView(R.layout.activity_main);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("samsunginternet://add_ons/?" + getApplicationContext().getPackageName())));
        } catch (Exception unused) {
            Log.d("MainActivity", "onCreate");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
