package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b2.o;

/* loaded from: classes.dex */
public final class a extends c2.a {

    /* renamed from: f, reason: collision with root package name */
    final int f4740f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4741g;

    /* renamed from: h, reason: collision with root package name */
    private final PendingIntent f4742h;

    /* renamed from: i, reason: collision with root package name */
    private final String f4743i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f4739j = new a(0);
    public static final Parcelable.Creator<a> CREATOR = new h();

    public a(int i10) {
        this(i10, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i10, int i11, PendingIntent pendingIntent, String str) {
        this.f4740f = i10;
        this.f4741g = i11;
        this.f4742h = pendingIntent;
        this.f4743i = str;
    }

    public a(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    public a(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String u(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i10 + ")";
                }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4741g == aVar.f4741g && b2.o.a(this.f4742h, aVar.f4742h) && b2.o.a(this.f4743i, aVar.f4743i);
    }

    public int g() {
        return this.f4741g;
    }

    public int hashCode() {
        return b2.o.b(Integer.valueOf(this.f4741g), this.f4742h, this.f4743i);
    }

    public String j() {
        return this.f4743i;
    }

    public PendingIntent l() {
        return this.f4742h;
    }

    public boolean s() {
        return (this.f4741g == 0 || this.f4742h == null) ? false : true;
    }

    public boolean t() {
        return this.f4741g == 0;
    }

    public String toString() {
        o.a c10 = b2.o.c(this);
        c10.a("statusCode", u(this.f4741g));
        c10.a("resolution", this.f4742h);
        c10.a("message", this.f4743i);
        return c10.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f4740f);
        c2.c.k(parcel, 2, g());
        c2.c.o(parcel, 3, l(), i10, false);
        c2.c.q(parcel, 4, j(), false);
        c2.c.b(parcel, a10);
    }
}
