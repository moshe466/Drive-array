package g5;

import android.content.Context;
import android.content.SharedPreferences;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import w6.l0;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f9815a;

    /* renamed from: b, reason: collision with root package name */
    private Context f9816b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f9817c = null;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f9818d = null;

    public g(Context context, String str) {
        this.f9816b = context;
        this.f9815a = str;
    }

    private SharedPreferences d() {
        if (this.f9817c == null) {
            this.f9817c = this.f9816b.getSharedPreferences(this.f9815a, 0);
        }
        return this.f9817c;
    }

    public String a(String str, String str2) {
        return d().getString(str, str2);
    }

    public SharedPreferences.Editor b() {
        if (this.f9818d == null) {
            this.f9818d = d().edit();
        }
        return this.f9818d;
    }

    public int c(String str) {
        return l0.U(a(str, ""));
    }

    public void e(String str, String str2) {
        b().putString(str, str2);
        b().commit();
    }

    public void f(String str, String str2) {
        e(str, str2);
        v5.a.b(MdaEmergencyApplication.b());
    }
}
