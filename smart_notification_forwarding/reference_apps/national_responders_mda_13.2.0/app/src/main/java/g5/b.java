package g5;

import android.content.Context;
import com.groboot.mdaemergency.async.d;
import w6.p;

/* loaded from: classes.dex */
public class b extends g {

    /* renamed from: e, reason: collision with root package name */
    static String f9801e = "WidgetContact";

    /* renamed from: f, reason: collision with root package name */
    private static b f9802f;

    private b(Context context) {
        super(context, "MADA_P");
    }

    public static b i(Context context) {
        if (f9802f == null) {
            f9802f = new b(context);
        }
        return f9802f;
    }

    public d.q g() {
        String a10 = a("BarcodePatientObject", "");
        d.q qVar = (a10 == null || a10.length() <= 0) ? null : (d.q) w6.j.a(a10, d.q.class);
        return qVar == null ? new d.q() : qVar;
    }

    public String h() {
        return a("BluetoothMacAddress", "");
    }

    public int j() {
        return c("PrinterType1");
    }

    public p k(int i10) {
        return (p) new com.google.gson.e().i(a(f9801e + i10, ""), p.class);
    }

    public void l(d.q qVar) {
        e("BarcodePatientObject", w6.j.b(qVar));
    }

    public void m(int i10, p pVar) {
        e(f9801e + i10, new com.google.gson.e().r(pVar));
    }

    public void n(String str) {
        e("BluetoothMacAddress", str);
    }

    public void o(int i10) {
        e("PrinterType1", i10 + "");
    }
}
