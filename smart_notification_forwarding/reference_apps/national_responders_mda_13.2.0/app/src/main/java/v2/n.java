package v2;

import android.content.Context;
import android.content.res.Resources;
import b2.p;
import b2.s;

/* loaded from: classes.dex */
public final class n {
    public static String a(Context context, String str) {
        try {
            return new s(context).a(str);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String b(String str, String[] strArr, String[] strArr2) {
        p.k(strArr);
        p.k(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i10 = 0; i10 < min; i10++) {
            String str2 = strArr[i10];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i10];
            }
        }
        return null;
    }
}
