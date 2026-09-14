package w6;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: c, reason: collision with root package name */
    private static a0 f15111c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f15112a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f15113b;

    private a0(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("prefs", 0);
        this.f15112a = sharedPreferences;
        this.f15113b = sharedPreferences.edit();
    }

    public static a0 a() {
        return f15111c;
    }

    public static a0 b(Context context) {
        if (f15111c == null) {
            f15111c = new a0(context);
        }
        return f15111c;
    }

    public static void g(Context context) {
        f15111c = new a0(context);
    }

    public boolean c(String str, boolean z10) {
        return this.f15112a.getBoolean(str, z10);
    }

    public int d(String str, int i10) {
        return this.f15112a.getInt(str, i10);
    }

    public long e(String str, Long l10) {
        return this.f15112a.getLong(str, l10.longValue());
    }

    public String f(String str, String str2) {
        return this.f15112a.getString(str, str2);
    }

    public void h(String str, boolean z10) {
        this.f15113b.putBoolean(str, z10);
        this.f15113b.apply();
    }

    public void i(String str, int i10) {
        this.f15113b.putInt(str, i10);
        this.f15113b.apply();
    }

    public void j(String str, long j10) {
        this.f15113b.putLong(str, j10);
        this.f15113b.apply();
    }

    public void k(String str, String str2) {
        this.f15113b.putString(str, str2);
        this.f15113b.apply();
    }

    public void l(String str, Object obj) {
        this.f15113b.putString(str, b0.a().r(obj));
        this.f15113b.apply();
    }
}
