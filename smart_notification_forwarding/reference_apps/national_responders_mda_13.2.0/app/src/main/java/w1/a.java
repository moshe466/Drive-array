package w1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b2.p;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final Lock f14887c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    private static a f14888d;

    /* renamed from: a, reason: collision with root package name */
    private final Lock f14889a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f14890b;

    a(Context context) {
        this.f14890b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        p.k(context);
        Lock lock = f14887c;
        lock.lock();
        try {
            if (f14888d == null) {
                f14888d = new a(context.getApplicationContext());
            }
            a aVar = f14888d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            f14887c.unlock();
            throw th;
        }
    }

    private static final String d(String str, String str2) {
        return str + ":" + str2;
    }

    public GoogleSignInAccount b() {
        String c10;
        String c11 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(c11) || (c10 = c(d("googleSignInAccount", c11))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.A(c10);
        } catch (JSONException unused) {
            return null;
        }
    }

    protected final String c(String str) {
        this.f14889a.lock();
        try {
            return this.f14890b.getString(str, null);
        } finally {
            this.f14889a.unlock();
        }
    }
}
