package com.groboot.mdaemergency.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.groboot.mdaemergency.enums.d;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.LockPatternActivity;

/* loaded from: classes.dex */
public class SplashActivity extends Activity {

    /* renamed from: f, reason: collision with root package name */
    private Intent f8300f;

    /* loaded from: classes.dex */
    class a implements p.b0 {
        a(SplashActivity splashActivity) {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(p pVar) {
            pVar.z0(null);
        }
    }

    private void a(Intent intent, Intent intent2, String str, boolean z10) {
        if (intent2 == null || !intent2.hasExtra(str)) {
            return;
        }
        if (z10) {
            LockPatternActivity.B();
        }
        intent.putExtra(str, (d) intent2.getSerializableExtra(str));
        intent2.removeExtra(str);
    }

    private void b(Intent intent, Intent intent2, String str, boolean z10) {
        if (intent2 != null) {
            if (!intent2.hasExtra(str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("copyExtraToIntent no extra found - ");
                sb2.append(str);
                return;
            }
            if (z10) {
                LockPatternActivity.B();
            }
            String stringExtra = intent2.getStringExtra(str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("copyExtraToIntent extra:");
            sb3.append(str);
            sb3.append(" value:");
            sb3.append(stringExtra);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("copyExtraToIntent extra:");
            sb4.append(str);
            sb4.append(" value:");
            sb4.append(stringExtra);
            intent.putExtra(str, stringExtra);
            intent2.removeExtra(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0121  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r6) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.groboot.mdaemergency.ui.main.SplashActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        b(getIntent(), intent, p5.d.f13069e, false);
        b(getIntent(), intent, p.f7897w, true);
        b(getIntent(), intent, p.f7896v, true);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 101) {
            if (iArr[0] == 0) {
                v5.a.a(this);
            } else {
                Toast.makeText(this, "יש לאפשר הרשאת התראות לצורך קבלת אירועים", 1).show();
            }
        }
        startActivity(this.f8300f);
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
