package com.groboot.mdaemergency.app_authorization;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class ConfigurationAuthActivity extends c {
    String A = "";
    ImageView B;
    TextView C;
    TextView D;
    ImageView E;
    Button F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String packageName = ConfigurationAuthActivity.this.getPackageName();
            try {
                ConfigurationAuthActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
            } catch (ActivityNotFoundException unused) {
                ConfigurationAuthActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
            }
        }
    }

    private void y0() {
        this.C.setText(R.string.mock_location_message);
        this.D.setText(R.string.mock_location_todo);
        this.E.setImageResource(R.drawable.ic_baseline_wrong_location_24);
        this.F.setVisibility(4);
    }

    private void z0() {
        this.C.setText(R.string.side_load_message);
        this.D.setText(R.string.side_load_todo);
        this.E.setImageResource(R.drawable.ic_baseline_app_blocking_24);
        this.F.setText(R.string.side_load_settings);
        this.F.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r2) {
        /*
            r1 = this;
            super.onCreate(r2)
            r2 = 2131492895(0x7f0c001f, float:1.8609255E38)
            r1.setContentView(r2)
            r2 = 2131296731(0x7f0901db, float:1.8211387E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r1.B = r2
            r2 = 2131297401(0x7f090479, float:1.8212746E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r1.C = r2
            r2 = 2131297402(0x7f09047a, float:1.8212748E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r1.D = r2
            r2 = 2131296732(0x7f0901dc, float:1.8211389E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r1.E = r2
            r2 = 2131296475(0x7f0900db, float:1.8210868E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Button r2 = (android.widget.Button) r2
            r1.F = r2
            android.content.Intent r2 = r1.getIntent()
            android.os.Bundle r2 = r2.getExtras()
            if (r2 == 0) goto L52
            java.lang.String r0 = "failedConfig"
            java.lang.String r2 = r2.getString(r0)
            r1.A = r2
        L52:
            com.groboot.mdaemergency.enums.a r2 = com.groboot.mdaemergency.MdaEmergencyApplication.a()
            com.groboot.mdaemergency.enums.a r0 = com.groboot.mdaemergency.enums.a.MADA
            if (r2 != r0) goto L63
            android.widget.ImageView r2 = r1.B
            r0 = 2131231175(0x7f0801c7, float:1.8078424E38)
        L5f:
            r2.setImageResource(r0)
            goto L71
        L63:
            com.groboot.mdaemergency.enums.a r2 = com.groboot.mdaemergency.MdaEmergencyApplication.a()
            com.groboot.mdaemergency.enums.a r0 = com.groboot.mdaemergency.enums.a.CREW
            if (r2 != r0) goto L71
            android.widget.ImageView r2 = r1.B
            r0 = 2131231147(0x7f0801ab, float:1.8078367E38)
            goto L5f
        L71:
            java.lang.String r2 = r1.A
            java.lang.String r0 = "mockLocation"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7f
            r1.y0()
            goto L8c
        L7f:
            java.lang.String r2 = r1.A
            java.lang.String r0 = "sideLoad"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L8c
            r1.z0()
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.groboot.mdaemergency.app_authorization.ConfigurationAuthActivity.onCreate(android.os.Bundle):void");
    }
}
