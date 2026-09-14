package s2;

import android.location.Location;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final int f14043a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14044b;

    /* renamed from: c, reason: collision with root package name */
    private final List f14045c;

    private l(int i10, int i11, List list, Location location) {
        this.f14043a = i10;
        this.f14044b = i11;
        this.f14045c = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s2.l a(android.content.Intent r12) {
        /*
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "gms_error_code"
            r2 = -1
            int r1 = r12.getIntExtra(r1, r2)
            java.lang.String r3 = "com.google.android.location.intent.extra.transition"
            int r3 = r12.getIntExtra(r3, r2)
            r4 = 4
            if (r3 != r2) goto L16
        L14:
            r3 = -1
            goto L1f
        L16:
            r5 = 1
            if (r3 == r5) goto L1f
            r5 = 2
            if (r3 == r5) goto L1f
            if (r3 != r4) goto L14
            r3 = 4
        L1f:
            java.lang.String r4 = "com.google.android.location.intent.extra.geofence_list"
            java.io.Serializable r4 = r12.getSerializableExtra(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 != 0) goto L2b
            r5 = r0
            goto L5e
        L2b:
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = r4.size()
            r5.<init>(r6)
            int r6 = r4.size()
            r7 = 0
            r8 = 0
        L3a:
            if (r8 >= r6) goto L5e
            java.lang.Object r9 = r4.get(r8)
            byte[] r9 = (byte[]) r9
            android.os.Parcel r10 = android.os.Parcel.obtain()
            int r11 = r9.length
            r10.unmarshall(r9, r7, r11)
            r10.setDataPosition(r7)
            android.os.Parcelable$Creator<q2.u0> r9 = q2.u0.CREATOR
            java.lang.Object r9 = r9.createFromParcel(r10)
            q2.u0 r9 = (q2.u0) r9
            r10.recycle()
            r5.add(r9)
            int r8 = r8 + 1
            goto L3a
        L5e:
            java.lang.String r4 = "com.google.android.location.intent.extra.triggering_location"
            android.os.Parcelable r12 = r12.getParcelableExtra(r4)
            android.location.Location r12 = (android.location.Location) r12
            if (r5 != 0) goto L6b
            if (r1 != r2) goto L6b
            return r0
        L6b:
            s2.l r0 = new s2.l
            r0.<init>(r1, r3, r5, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.l.a(android.content.Intent):s2.l");
    }

    public int b() {
        return this.f14043a;
    }

    public int c() {
        return this.f14044b;
    }

    public List<i> d() {
        return this.f14045c;
    }

    public boolean e() {
        return this.f14043a != -1;
    }
}
