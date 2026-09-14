package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2374a = aVar.p(iconCompat.f2374a, 1);
        iconCompat.f2376c = aVar.j(iconCompat.f2376c, 2);
        iconCompat.f2377d = aVar.r(iconCompat.f2377d, 3);
        iconCompat.f2378e = aVar.p(iconCompat.f2378e, 4);
        iconCompat.f2379f = aVar.p(iconCompat.f2379f, 5);
        iconCompat.f2380g = (ColorStateList) aVar.r(iconCompat.f2380g, 6);
        iconCompat.f2382i = aVar.t(iconCompat.f2382i, 7);
        iconCompat.f2383j = aVar.t(iconCompat.f2383j, 8);
        iconCompat.o();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.p(aVar.f());
        int i10 = iconCompat.f2374a;
        if (-1 != i10) {
            aVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f2376c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2377d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f2378e;
        if (i11 != 0) {
            aVar.F(i11, 4);
        }
        int i12 = iconCompat.f2379f;
        if (i12 != 0) {
            aVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f2380g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f2382i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f2383j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
