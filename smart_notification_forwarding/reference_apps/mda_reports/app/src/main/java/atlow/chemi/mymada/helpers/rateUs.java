package atlow.chemi.mymada.helpers;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import atlow.chemi.mymada.R;
import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class rateUs {
    private static final String APP_PACKAGE_NAME = "atlow.chemi.mymada";
    private static final int DAYS_UNTIL_PROMPT = 3;
    private static final int LAUNCH_UNTIL_PROMPT = 5;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SharedPreferences.Editor editor, Context context, DialogInterface dialogInterface, int i) {
        editor.putBoolean("dontshowagain", true);
        editor.commit();
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=atlow.chemi.mymada")));
        } catch (ActivityNotFoundException e) {
            Crashlytics.logException(e);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SharedPreferences.Editor editor, DialogInterface dialogInterface, int i) {
        if (editor != null) {
            editor.putBoolean("dontshowagain", true);
            editor.commit();
        }
        dialogInterface.dismiss();
    }

    public static void app_launched(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rate_app", 0);
        if (sharedPreferences.getBoolean("dontshowagain", false)) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        long j = sharedPreferences.getLong("launch_count", 0L) + 1;
        edit.putLong("launch_count", j);
        long j2 = sharedPreferences.getLong("date_first_launch", 0L);
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
            edit.putLong("date_first_launch", j2);
        }
        if (j >= 5) {
            Log.e("Launch:", "number: " + j);
            if (System.currentTimeMillis() >= j2 + 259200000) {
                showRateDialog(context, edit);
            }
        }
        edit.apply();
    }

    private static void showRateDialog(final Context context, final SharedPreferences.Editor editor) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogStyle);
        String string = context.getResources().getString(R.string.app_name);
        AlertDialog.Builder message = builder.setMessage("אם אתם נהנים מ" + string + ", נשמח שתקחו רגע אחד ותדרגו אותה בחנות. תודה לכם על תמיכתכם, היא חשובה לנו מאוד!");
        StringBuilder sb = new StringBuilder();
        sb.append("דרג את ");
        sb.append(string);
        message.setTitle(sb.toString()).setIcon(context.getApplicationInfo().icon).setCancelable(false).setPositiveButton(context.getResources().getString(R.string.dialog_rate_yes), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.helpers.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                rateUs.a(editor, context, dialogInterface, i);
            }
        }).setNeutralButton(context.getResources().getString(R.string.dialog_no), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.helpers.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setNegativeButton(context.getResources().getString(R.string.dialog_never), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.helpers.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                rateUs.a(editor, dialogInterface, i);
            }
        });
        builder.create().show();
    }
}
