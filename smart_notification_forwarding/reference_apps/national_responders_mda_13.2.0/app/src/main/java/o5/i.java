package o5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class i extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static int f12502a;

    /* renamed from: b, reason: collision with root package name */
    private static Date f12503b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f12504c;

    /* renamed from: d, reason: collision with root package name */
    private static String f12505d;

    public void a(Context context, int i10, String str) {
        int i11 = f12502a;
        if (i11 == i10) {
            return;
        }
        if (i10 != 0) {
            if (i10 == 1) {
                f12504c = true;
                Date date = new Date();
                f12503b = date;
                f12505d = str;
                d(context, str, date);
            } else if (i10 == 2) {
                if (i11 != 1) {
                    f12504c = false;
                    Date date2 = new Date();
                    f12503b = date2;
                    g(context, f12505d, date2);
                } else {
                    Date date3 = new Date();
                    f12503b = date3;
                    b(context, f12505d, date3);
                }
            }
        } else if (i11 == 1) {
            e(context, f12505d, f12503b);
        } else if (f12504c) {
            c(context, f12505d, f12503b, new Date());
        } else {
            f(context, f12505d, f12503b, new Date());
        }
        f12502a = i10;
    }

    protected abstract void b(Context context, String str, Date date);

    protected abstract void c(Context context, String str, Date date, Date date2);

    protected abstract void d(Context context, String str, Date date);

    protected abstract void e(Context context, String str, Date date);

    protected abstract void f(Context context, String str, Date date, Date date2);

    protected abstract void g(Context context, String str, Date date);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                f12505d = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
                return;
            }
            String string = intent.getExtras().getString("state");
            String string2 = intent.getExtras().getString("incoming_number");
            int i10 = 0;
            if (!string.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                if (string.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                    i10 = 2;
                } else if (string.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    i10 = 1;
                }
            }
            a(context, i10, string2);
        } catch (Exception unused) {
        }
    }
}
