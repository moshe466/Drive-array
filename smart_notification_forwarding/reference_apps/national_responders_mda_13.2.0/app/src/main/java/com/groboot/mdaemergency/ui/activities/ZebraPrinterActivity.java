package com.groboot.mdaemergency.ui.activities;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.j;
import il.org.mda.health.R;
import java.util.Date;
import w6.l0;
import w6.n0;
import w6.z;

/* loaded from: classes.dex */
public class ZebraPrinterActivity extends j implements View.OnClickListener {
    boolean A;
    int B;
    String C;
    String D;
    View E;
    TextView F;
    CheckBox G;
    CheckBox H;
    View I;
    View J;
    View K;
    TextView L;
    TextView M;
    View N;
    View O;
    View P;
    View Q;
    View R;
    View S;
    View T;
    View U;
    BroadcastReceiver V;
    int W;

    /* renamed from: y, reason: collision with root package name */
    String f8110y;

    /* renamed from: z, reason: collision with root package name */
    BluetoothAdapter f8111z;

    /* loaded from: classes.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (z10) {
                ZebraPrinterActivity.this.v0(1);
            }
            ZebraPrinterActivity.this.y0();
        }
    }

    /* loaded from: classes.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (z10) {
                ZebraPrinterActivity zebraPrinterActivity = ZebraPrinterActivity.this;
                if (zebraPrinterActivity.W != 3) {
                    zebraPrinterActivity.v0(2);
                }
            }
            ZebraPrinterActivity.this.y0();
        }
    }

    /* loaded from: classes.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("com.motorolasolutions.emdk.datawedge.data_string");
            if (stringExtra == null || stringExtra.isEmpty()) {
                return;
            }
            ZebraPrinterActivity.this.r0(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n0.f(ZebraPrinterActivity.this.getApplicationContext()).w(4);
            l0.O0(6000);
            ZebraPrinterActivity zebraPrinterActivity = ZebraPrinterActivity.this;
            zebraPrinterActivity.B = 2;
            zebraPrinterActivity.z0();
            n0.f(ZebraPrinterActivity.this.getApplicationContext()).w(1);
            l0.O0(6000);
            ZebraPrinterActivity zebraPrinterActivity2 = ZebraPrinterActivity.this;
            zebraPrinterActivity2.B = 3;
            zebraPrinterActivity2.z0();
            n0.f(ZebraPrinterActivity.this.getApplicationContext()).w(6);
            l0.O0(6000);
            ZebraPrinterActivity zebraPrinterActivity3 = ZebraPrinterActivity.this;
            zebraPrinterActivity3.B = 4;
            zebraPrinterActivity3.z0();
            n0.f(ZebraPrinterActivity.this.getApplicationContext()).w(1);
            l0.O0(6000);
            ZebraPrinterActivity zebraPrinterActivity4 = ZebraPrinterActivity.this;
            zebraPrinterActivity4.B = 5;
            zebraPrinterActivity4.z0();
            n0.f(ZebraPrinterActivity.this.getApplicationContext()).w(6);
            l0.O0(6000);
            ZebraPrinterActivity zebraPrinterActivity5 = ZebraPrinterActivity.this;
            zebraPrinterActivity5.B = 0;
            zebraPrinterActivity5.z0();
            l0.M0("הפעולה הסתיימה. יש לנסות ולהדפיס דוגמא");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.O0(1000);
            ZebraPrinterActivity zebraPrinterActivity = ZebraPrinterActivity.this;
            zebraPrinterActivity.B = 2;
            zebraPrinterActivity.z0();
            n0.f(ZebraPrinterActivity.this.getApplicationContext()).w(6);
            l0.O0(3000);
            ZebraPrinterActivity zebraPrinterActivity2 = ZebraPrinterActivity.this;
            zebraPrinterActivity2.B = 3;
            zebraPrinterActivity2.z0();
            l0.O0(3000);
            ZebraPrinterActivity zebraPrinterActivity3 = ZebraPrinterActivity.this;
            zebraPrinterActivity3.B = 4;
            zebraPrinterActivity3.z0();
            l0.O0(3000);
            ZebraPrinterActivity zebraPrinterActivity4 = ZebraPrinterActivity.this;
            zebraPrinterActivity4.B = 0;
            zebraPrinterActivity4.z0();
            l0.M0("הפעולה הסתיימה. יש לנסות ולהדפיס דוגמא");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ZebraPrinterActivity.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements n0.d {
        g() {
        }

        @Override // w6.n0.d
        public void a(String str) {
            ZebraPrinterActivity.this.B = 0;
            l0.M0(str);
            ZebraPrinterActivity.this.z0();
        }

        @Override // w6.n0.d
        public void b() {
        }
    }

    private void p0() {
        if (z.b().d()) {
            this.A = true;
            return;
        }
        this.A = false;
        this.C = "";
        this.D = "";
        for (char c10 : l0.c0(new Date(), l0.f15196i).toCharArray()) {
            this.C = c10 + this.C;
        }
    }

    private n0.d q0() {
        return new g();
    }

    @SuppressLint({"MissingPermission"})
    private void s0() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!defaultAdapter.isEnabled()) {
            defaultAdapter.enable();
        }
        defaultAdapter.startDiscovery();
    }

    private void t0(String str) {
        g5.b i10;
        String str2;
        this.f8110y = str;
        if (str.length() > 12) {
            this.f8110y = this.f8110y.substring(0, 12);
        }
        if (this.f8110y.length() == 12) {
            i10 = g5.b.i(getApplicationContext());
            str2 = this.f8110y;
        } else {
            i10 = g5.b.i(getApplicationContext());
            str2 = "";
        }
        i10.n(str2);
        y0();
    }

    private void u0() {
        s0();
        this.B = 1;
        y0();
        new Thread(new e()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i10) {
        this.W = i10;
        g5.b.i(getApplicationContext()).o(this.W);
        y0();
    }

    private void w0() {
        s0();
        this.B = 1;
        y0();
        new Thread(new d()).start();
    }

    private void x0() {
        int[] iArr = {R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.tv_4, R.id.tv_5, R.id.tv_6, R.id.tv_7, R.id.tv_8, R.id.tv_9, R.id.tv_10, R.id.tv_11, R.id.tv_12};
        int i10 = 0;
        while (i10 < 12) {
            int i11 = i10 + 1;
            ((TextView) findViewById(iArr[i10])).setText(l0.S0(this.f8110y, i10, i11));
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        runOnUiThread(new f());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i10;
        if (this.f8110y.length() < 12) {
            l0.N0("יש להקליד כתובת מדפסת", true);
            return;
        }
        switch (view.getId()) {
            case R.id.btn_set /* 2131296471 */:
                u0();
                return;
            case R.id.btn_sync /* 2131296474 */:
                w0();
                return;
            case R.id.btn_test /* 2131296476 */:
                if (this.W == 0) {
                    y0();
                    return;
                } else {
                    n0.f(getApplicationContext()).s(this.W, q0());
                    return;
                }
            case R.id.cl_tv_macAddrees /* 2131296527 */:
                this.U.setVisibility(8);
                this.K.setVisibility(0);
                return;
            case R.id.ll_type_2 /* 2131296845 */:
                i10 = 2;
                break;
            case R.id.ll_type_3 /* 2131296847 */:
                i10 = 3;
                break;
            case R.id.rl_type_1 /* 2131297067 */:
                v0(1);
                return;
            default:
                return;
        }
        v0(i10);
    }

    public void onClickSettingsButton(View view) {
        int U = l0.U(view.getTag().toString());
        if (U == 0) {
            n0.f(getApplicationContext()).y();
        } else {
            n0.f(getApplicationContext()).w(U);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_printer);
        setTitle("הגדרות מדפסת");
        this.J = findViewById(R.id.ll_buttons);
        this.E = findViewById(R.id.rl_password);
        this.F = (TextView) findViewById(R.id.tv_password);
        this.G = (CheckBox) findViewById(R.id.tv_printer_type_1);
        this.H = (CheckBox) findViewById(R.id.tv_printer_type_2_3);
        this.K = findViewById(R.id.cl_keyboard);
        this.N = findViewById(R.id.ll_type_1_selected);
        this.O = findViewById(R.id.ll_type_2_selected);
        this.P = findViewById(R.id.ll_type_3_selected);
        this.Q = findViewById(R.id.tv_no_type);
        this.R = findViewById(R.id.rl_type_1);
        this.S = findViewById(R.id.ll_type_2);
        this.T = findViewById(R.id.ll_type_3);
        this.U = findViewById(R.id.ll_type);
        this.I = findViewById(R.id.rl_progress);
        this.L = (TextView) findViewById(R.id.tv_progress);
        this.M = (TextView) findViewById(R.id.btn_sync);
        if ((androidx.core.content.a.a(this, "android.permission.BLUETOOTH_CONNECT") == -1 || androidx.core.content.a.a(this, "android.permission.BLUETOOTH_SCAN") == -1) && Build.VERSION.SDK_INT >= 31) {
            androidx.core.app.b.n(this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"}, 2);
        }
        this.G.setOnCheckedChangeListener(new a());
        this.H.setOnCheckedChangeListener(new b());
        this.V = new c();
    }

    public void onKeyboardClick(View view) {
        if (!this.A) {
            this.D += ((Object) ((Button) view).getText());
            y0();
            return;
        }
        if (this.f8110y.length() >= 12) {
            y0();
            return;
        }
        String str = this.f8110y + ((Object) ((Button) view).getText());
        t0(str);
        if (str.length() == 12 && str.endsWith("AAAAAAAAAAAA")) {
            this.J.setVisibility(0);
        }
    }

    public void onKeyboardReturnClick(View view) {
        if (this.A) {
            t0(l0.t0(this.f8110y, 1));
        } else {
            this.D = l0.t0(this.D, 1);
            y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    @SuppressLint({"MissingPermission"})
    public void onPause() {
        super.onPause();
        BluetoothAdapter bluetoothAdapter = this.f8111z;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        unregisterReceiver(this.V);
    }

    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        for (int i11 : iArr) {
            if (i11 == -1) {
                Toast.makeText(this, "יש לאפשר לאפליקציה להתחבר להתקני בלוטוס לצורך חיבור למדפסת", 1).show();
                finish();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.W = g5.b.i(getApplicationContext()).j();
        this.f8110y = g5.b.i(getApplicationContext()).h();
        registerReceiver(this.V, new IntentFilter("ABC"));
        p0();
        y0();
    }

    boolean r0(String str) {
        if (str.length() != 12) {
            return false;
        }
        t0(str);
        return true;
    }

    protected void y0() {
        boolean z10 = true;
        if (l0.l(this.C, this.D)) {
            this.A = true;
        }
        if (!this.A) {
            this.E.setVisibility(0);
            this.F.setText(l0.l0(this.D) ? "סיסמא" : this.D);
            this.U.setVisibility(8);
            this.K.setVisibility(0);
            return;
        }
        this.E.setVisibility(8);
        if (this.B > 0) {
            this.I.setVisibility(0);
            this.L.setText("מגדיר מדפסת. שלב " + this.B);
            this.U.setVisibility(8);
            this.K.setVisibility(8);
            return;
        }
        this.I.setVisibility(8);
        this.U.setVisibility(this.f8110y.length() < 12 ? 8 : 0);
        this.K.setVisibility(this.f8110y.length() < 12 ? 0 : 8);
        this.Q.setVisibility(this.W > 0 ? 8 : 0);
        this.N.setVisibility(this.W == 1 ? 0 : 8);
        this.O.setVisibility(this.W == 2 ? 0 : 8);
        this.P.setVisibility(this.W == 3 ? 0 : 8);
        this.G.setChecked(this.W == 1);
        CheckBox checkBox = this.H;
        int i10 = this.W;
        if (i10 != 2 && i10 != 3) {
            z10 = false;
        }
        checkBox.setChecked(z10);
        x0();
    }
}
