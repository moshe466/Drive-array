package v1;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f14618a;

    public c(Context context) {
        try {
            Context d10 = e.d(context);
            this.f14618a = d10 == null ? null : d10.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable unused) {
            this.f14618a = null;
        }
    }

    public final boolean a(String str, boolean z10) {
        try {
            SharedPreferences sharedPreferences = this.f14618a;
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b(String str, float f10) {
        try {
            SharedPreferences sharedPreferences = this.f14618a;
            if (sharedPreferences == null) {
                return 0.0f;
            }
            return sharedPreferences.getFloat(str, 0.0f);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.f14618a;
            return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
