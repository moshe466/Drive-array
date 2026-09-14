package atlow.chemi.mymada.recieversAndServices;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.gass.AdShield2Logger;

/* loaded from: classes.dex */
public class GrobootRec extends BroadcastReceiver {
    protected static String k = "T1";
    protected static PendingIntent l;
    protected String a;
    protected Context c;
    protected int d;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    public static Boolean testAp = false;
    private static int NOTIF_ID = AdShield2Logger.EVENTID_CLICK_SIGNALS;
    public static float vo = 0.0f;
    protected String b = "notWithWin";
    public long[] lng = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    protected int e = 0;

    private boolean isCallable(Intent intent) {
        try {
            return this.c.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void madasApp(PendingIntent pendingIntent) {
        l = pendingIntent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x02b3, code lost:
    
        if (r14 != 8) goto L67;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r23, android.content.Intent r24) {
        /*
            Method dump skipped, instructions count: 1196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.recieversAndServices.GrobootRec.onReceive(android.content.Context, android.content.Intent):void");
    }
}
