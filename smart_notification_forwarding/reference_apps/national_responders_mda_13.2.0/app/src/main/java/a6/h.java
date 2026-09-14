package a6;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.groboot.mdaemergency.ui.main.RegistrationActivity;
import il.org.mda.health.R;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    static Dialog f318a;

    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f319f;

        a(Context context) {
            this.f319f = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", this.f319f.getPackageName(), null));
            intent.addFlags(268435456);
            this.f319f.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f320f;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f320f = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            this.f320f.onClick(dialogInterface, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    public static String a(Activity activity) {
        TelephonyManager telephonyManager;
        if (!com.groboot.mdaemergency.a.o(activity) || (telephonyManager = (TelephonyManager) activity.getSystemService("phone")) == null) {
            return "";
        }
        try {
            return telephonyManager.getDeviceId();
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error permission :");
            sb2.append(e10);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void c() {
        Dialog dialog = f318a;
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Activity activity, int i10) {
        c();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(i10);
        builder.setTitle("");
        builder.setPositiveButton(R.string.accept, new c());
        AlertDialog create = builder.create();
        f318a = create;
        try {
            create.show();
        } catch (Exception unused) {
        }
    }

    public static void e(Activity activity, int i10, DialogInterface.OnClickListener onClickListener) {
        f(activity, i10, null, onClickListener);
    }

    public static void f(Activity activity, int i10, String str, DialogInterface.OnClickListener onClickListener) {
        h(activity, null, i10, str, onClickListener);
    }

    public static void g(Activity activity, String str) {
        c();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(str);
        builder.setTitle("");
        builder.setPositiveButton(R.string.accept, new b());
        AlertDialog create = builder.create();
        f318a = create;
        try {
            create.show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void h(Activity activity, String str, int i10, String str2, DialogInterface.OnClickListener onClickListener) {
        c();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (str2 != null) {
            builder.setMessage(str2);
        } else if (i10 != -1) {
            builder.setMessage(i10);
        }
        if (str == null) {
            str = "";
        }
        builder.setTitle(str);
        builder.setPositiveButton(R.string.accept, new d(onClickListener));
        builder.setNegativeButton(R.string.cancel, new e());
        AlertDialog create = builder.create();
        f318a = create;
        try {
            create.show();
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public static void i(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        h(activity, str, -1, str2, onClickListener);
    }

    public static void j(Context context, String str, boolean z10, Integer num) {
        if (context == null && (context = l0.v()) == null) {
            return;
        }
        try {
            try {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                if (Build.VERSION.SDK_INT >= 16) {
                    linearLayout.setBackground(context.getResources().getDrawable(R.drawable.toast_background));
                } else {
                    linearLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.toast_background));
                }
                TextView textView = new TextView(context);
                textView.setTextColor(context.getResources().getColor(R.color.white));
                textView.setTextSize(20.0f);
                textView.setGravity(17);
                textView.setText(str);
                if (num != null && num.intValue() != 0) {
                    Drawable drawable = context.getResources().getDrawable(num.intValue());
                    drawable.setBounds(100, 100, 100, 100);
                    textView.setCompoundDrawables(null, null, null, drawable);
                }
                linearLayout.addView(textView);
                Toast toast = new Toast(context);
                toast.setView(linearLayout);
                toast.setGravity(80, 0, 100);
                toast.setDuration(z10 ? 1 : 0);
                toast.show();
            } catch (Exception unused) {
                Toast.makeText(context, str, 1).show();
            }
        } catch (Exception unused2) {
        }
    }

    public static Dialog k(Activity activity, View view) {
        Dialog dialog = new Dialog(activity, R.style.CustomDialog);
        dialog.setContentView(view);
        return dialog;
    }

    public static void l(Context context, int i10) {
        l0.F0(context, R.string.permission, i10, R.string.app_settings, R.string.cancel, new a(context), null);
    }

    public static void m(Context context) {
        c();
        ProgressDialog progressDialog = new ProgressDialog(context);
        f318a = progressDialog;
        progressDialog.setTitle("");
        f318a.setCancelable(false);
        ((ProgressDialog) f318a).setMessage(context.getString(R.string.loading));
        try {
            f318a.show();
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public static void n(Activity activity) {
        m.m();
        com.groboot.mdaemergency.enums.a aVar = com.groboot.mdaemergency.enums.a.POC;
        Intent intent = new Intent(activity.getBaseContext(), (Class<?>) RegistrationActivity.class);
        intent.addFlags(603979776);
        activity.startActivity(intent);
    }

    public static void o(Activity activity, String str) {
        j(activity, str, true, null);
    }
}
