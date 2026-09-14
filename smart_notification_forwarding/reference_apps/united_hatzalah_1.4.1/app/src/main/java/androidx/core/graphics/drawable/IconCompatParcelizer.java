package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import org.apache.tika.metadata.TikaCoreProperties;
import s0.AbstractC0647a;
import s0.C0648b;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC0647a abstractC0647a) {
        IconCompat iconCompat = new IconCompat();
        int i = iconCompat.f3045a;
        if (abstractC0647a.e(1)) {
            i = ((C0648b) abstractC0647a).f6231e.readInt();
        }
        iconCompat.f3045a = i;
        byte[] bArr = iconCompat.f3047c;
        if (abstractC0647a.e(2)) {
            Parcel parcel = ((C0648b) abstractC0647a).f6231e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f3047c = bArr;
        iconCompat.f3048d = abstractC0647a.f(iconCompat.f3048d, 3);
        int i3 = iconCompat.f3049e;
        if (abstractC0647a.e(4)) {
            i3 = ((C0648b) abstractC0647a).f6231e.readInt();
        }
        iconCompat.f3049e = i3;
        int i4 = iconCompat.f3050f;
        if (abstractC0647a.e(5)) {
            i4 = ((C0648b) abstractC0647a).f6231e.readInt();
        }
        iconCompat.f3050f = i4;
        iconCompat.f3051g = (ColorStateList) abstractC0647a.f(iconCompat.f3051g, 6);
        String str = iconCompat.i;
        if (abstractC0647a.e(7)) {
            str = ((C0648b) abstractC0647a).f6231e.readString();
        }
        iconCompat.i = str;
        String str2 = iconCompat.f3053j;
        if (abstractC0647a.e(8)) {
            str2 = ((C0648b) abstractC0647a).f6231e.readString();
        }
        iconCompat.f3053j = str2;
        iconCompat.f3052h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.f3045a) {
            case -1:
                Parcelable parcelable = iconCompat.f3048d;
                if (parcelable != null) {
                    iconCompat.f3046b = parcelable;
                    return iconCompat;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f3048d;
                if (parcelable2 != null) {
                    iconCompat.f3046b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f3047c;
                iconCompat.f3046b = bArr3;
                iconCompat.f3045a = 3;
                iconCompat.f3049e = 0;
                iconCompat.f3050f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f3047c, Charset.forName("UTF-16"));
                iconCompat.f3046b = str3;
                if (iconCompat.f3045a == 2 && iconCompat.f3053j == null) {
                    iconCompat.f3053j = str3.split(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f3046b = iconCompat.f3047c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC0647a abstractC0647a) {
        abstractC0647a.getClass();
        iconCompat.i = iconCompat.f3052h.name();
        switch (iconCompat.f3045a) {
            case -1:
                iconCompat.f3048d = (Parcelable) iconCompat.f3046b;
                break;
            case 1:
            case 5:
                iconCompat.f3048d = (Parcelable) iconCompat.f3046b;
                break;
            case 2:
                iconCompat.f3047c = ((String) iconCompat.f3046b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f3047c = (byte[]) iconCompat.f3046b;
                break;
            case 4:
            case 6:
                iconCompat.f3047c = iconCompat.f3046b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f3045a;
        if (-1 != i) {
            abstractC0647a.h(1);
            ((C0648b) abstractC0647a).f6231e.writeInt(i);
        }
        byte[] bArr = iconCompat.f3047c;
        if (bArr != null) {
            abstractC0647a.h(2);
            Parcel parcel = ((C0648b) abstractC0647a).f6231e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f3048d;
        if (parcelable != null) {
            abstractC0647a.h(3);
            ((C0648b) abstractC0647a).f6231e.writeParcelable(parcelable, 0);
        }
        int i3 = iconCompat.f3049e;
        if (i3 != 0) {
            abstractC0647a.h(4);
            ((C0648b) abstractC0647a).f6231e.writeInt(i3);
        }
        int i4 = iconCompat.f3050f;
        if (i4 != 0) {
            abstractC0647a.h(5);
            ((C0648b) abstractC0647a).f6231e.writeInt(i4);
        }
        ColorStateList colorStateList = iconCompat.f3051g;
        if (colorStateList != null) {
            abstractC0647a.h(6);
            ((C0648b) abstractC0647a).f6231e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.i;
        if (str != null) {
            abstractC0647a.h(7);
            ((C0648b) abstractC0647a).f6231e.writeString(str);
        }
        String str2 = iconCompat.f3053j;
        if (str2 != null) {
            abstractC0647a.h(8);
            ((C0648b) abstractC0647a).f6231e.writeString(str2);
        }
    }
}
