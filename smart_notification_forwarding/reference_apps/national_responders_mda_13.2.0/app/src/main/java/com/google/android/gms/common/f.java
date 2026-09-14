package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private static f f5100c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5101a;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f5102b;

    public f(Context context) {
        this.f5101a = context.getApplicationContext();
    }

    public static f a(Context context) {
        b2.p.k(context);
        synchronized (f.class) {
            if (f5100c == null) {
                r.d(context);
                f5100c = new f(context);
            }
        }
        return f5100c;
    }

    static final n d(PackageInfo packageInfo, n... nVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        o oVar = new o(packageInfo.signatures[0].toByteArray());
        for (int i10 = 0; i10 < nVarArr.length; i10++) {
            if (nVarArr[i10].equals(oVar)) {
                return nVarArr[i10];
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z10) {
        if (z10 && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z10 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z10 ? d(packageInfo, q.f5112a) : d(packageInfo, q.f5112a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final x f(String str, boolean z10, boolean z11) {
        x xVar;
        ApplicationInfo applicationInfo;
        String str2 = "null pkg";
        if (str == null) {
            return x.c("null pkg");
        }
        if (str.equals(this.f5102b)) {
            return x.b();
        }
        if (r.e()) {
            xVar = r.b(str, e.f(this.f5101a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f5101a.getPackageManager().getPackageInfo(str, 64);
                boolean f10 = e.f(this.f5101a);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        str2 = "single cert required";
                    } else {
                        o oVar = new o(packageInfo.signatures[0].toByteArray());
                        String str3 = packageInfo.packageName;
                        x a10 = r.a(str3, oVar, f10, false);
                        if (!a10.f5129a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !r.a(str3, oVar, false, true).f5129a) {
                            xVar = a10;
                        } else {
                            str2 = "debuggable release cert app rejected";
                        }
                    }
                }
                xVar = x.c(str2);
            } catch (PackageManager.NameNotFoundException e10) {
                return x.d("no pkg ".concat(str), e10);
            }
        }
        if (xVar.f5129a) {
            this.f5102b = str;
        }
        return xVar;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        return e(packageInfo, true) && e.f(this.f5101a);
    }

    public boolean c(int i10) {
        x c10;
        int length;
        String[] packagesForUid = this.f5101a.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c10 = null;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    b2.p.k(c10);
                    break;
                }
                c10 = f(packagesForUid[i11], false, false);
                if (c10.f5129a) {
                    break;
                }
                i11++;
            }
        } else {
            c10 = x.c("no pkgs");
        }
        c10.e();
        return c10.f5129a;
    }
}
