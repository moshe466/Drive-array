package com.groboot.mdaemergency.ui.widget;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.f0;
import androidx.fragment.app.j;
import com.groboot.mdaemergency.ptt.PTTService;
import com.groboot.mdaemergency.ptt.b;
import com.groboot.mdaemergency.ptt.l;
import com.groboot.mdaemergency.ptt.p;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class PTTUserWidgetConfigureActivity extends j {

    /* renamed from: y, reason: collision with root package name */
    int f8472y = 0;

    /* loaded from: classes.dex */
    class a implements p.b0 {
        a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(p pVar) {
            f0 o10 = PTTUserWidgetConfigureActivity.this.d0().o();
            l lVar = new l();
            lVar.b2(PTTUserWidgetConfigureActivity.this.o0());
            lVar.c2(b.h.AllContacts);
            o10.b(R.id.ll_main, lVar);
            o10.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements b.g {
        b() {
        }

        @Override // com.groboot.mdaemergency.ptt.b.g
        public void a(w6.p pVar) {
            PTTUserWidgetConfigureActivity.this.p0(pVar);
            PTTUserWidgetConfigureActivity.this.finish();
        }

        @Override // com.groboot.mdaemergency.ptt.b.g
        public void b(String str) {
            Toast.makeText(PTTUserWidgetConfigureActivity.this.getApplicationContext(), str, 1).show();
            PTTUserWidgetConfigureActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.g o0() {
        return new b();
    }

    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        setContentView(R.layout.pttuser_widget_configure);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8472y = extras.getInt("appWidgetId", 0);
        }
        if (this.f8472y == 0) {
            finish();
        } else {
            PTTService.j(getApplicationContext());
            p.d0(getApplicationContext(), new a());
        }
    }

    void p0(w6.p pVar) {
        g5.b.i(this).m(this.f8472y, pVar);
        PTTUserWidget.a(this, AppWidgetManager.getInstance(this), this.f8472y);
        Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.f8472y);
        setResult(-1, intent);
    }
}
