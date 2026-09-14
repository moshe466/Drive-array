package q2;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class o0 extends c2.a {
    public static final Parcelable.Creator<o0> CREATOR = new p0();

    /* renamed from: f, reason: collision with root package name */
    private final int f13517f;

    /* renamed from: g, reason: collision with root package name */
    private final IBinder f13518g;

    /* renamed from: h, reason: collision with root package name */
    private final IBinder f13519h;

    /* renamed from: i, reason: collision with root package name */
    private final PendingIntent f13520i;

    /* renamed from: j, reason: collision with root package name */
    private final String f13521j;

    /* renamed from: k, reason: collision with root package name */
    private final String f13522k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(int i10, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str, String str2) {
        this.f13517f = i10;
        this.f13518g = iBinder;
        this.f13519h = iBinder2;
        this.f13520i = pendingIntent;
        this.f13521j = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.f13522k = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [s2.e0, android.os.IBinder] */
    public static o0 g(IInterface iInterface, s2.e0 e0Var, String str, String str2) {
        if (iInterface == null) {
            iInterface = null;
        }
        return new o0(2, iInterface, e0Var, null, null, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f13517f);
        c2.c.j(parcel, 2, this.f13518g, false);
        c2.c.j(parcel, 3, this.f13519h, false);
        c2.c.o(parcel, 4, this.f13520i, i10, false);
        c2.c.q(parcel, 5, this.f13521j, false);
        c2.c.q(parcel, 6, this.f13522k, false);
        c2.c.b(parcel, a10);
    }
}
