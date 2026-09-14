package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k extends q5 {

    /* renamed from: c, reason: collision with root package name */
    private long f6146c;

    /* renamed from: d, reason: collision with root package name */
    private String f6147d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f6148e;

    /* renamed from: f, reason: collision with root package name */
    private AccountManager f6149f;

    /* renamed from: g, reason: collision with root package name */
    private Boolean f6150g;

    /* renamed from: h, reason: collision with root package name */
    private long f6151h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(t4 t4Var) {
        super(t4Var);
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final boolean t() {
        Calendar calendar = Calendar.getInstance();
        this.f6146c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb2.append(lowerCase);
        sb2.append("-");
        sb2.append(lowerCase2);
        this.f6147d = sb2.toString();
        return false;
    }

    public final boolean u(Context context) {
        if (this.f6148e == null) {
            this.f6148e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f6148e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f6148e.booleanValue();
    }

    public final long v() {
        q();
        return this.f6146c;
    }

    public final String w() {
        q();
        return this.f6147d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long x() {
        c();
        return this.f6151h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y() {
        c();
        this.f6150g = null;
        this.f6151h = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean z() {
        c();
        long a10 = f().a();
        if (a10 - this.f6151h > 86400000) {
            this.f6150g = null;
        }
        Boolean bool = this.f6150g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (androidx.core.content.a.a(i(), "android.permission.GET_ACCOUNTS") != 0) {
            h().J().a("Permission error checking for dasher/unicorn accounts");
        } else {
            if (this.f6149f == null) {
                this.f6149f = AccountManager.get(i());
            }
            try {
                Account[] result = this.f6149f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
                if (result != null && result.length > 0) {
                    this.f6150g = Boolean.TRUE;
                    this.f6151h = a10;
                    return true;
                }
                Account[] result2 = this.f6149f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.f6150g = Boolean.TRUE;
                    this.f6151h = a10;
                    return true;
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e10) {
                h().G().b("Exception checking account types", e10);
            }
        }
        this.f6151h = a10;
        this.f6150g = Boolean.FALSE;
        return false;
    }
}
