package com.google.android.gms.internal.location;

import F0.AbstractC0008a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class zzes {
    public static String zza(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String sb;
        int i = 0;
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e4) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    String v2 = AbstractC0008a.v(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(v2), (Throwable) e4);
                    String name2 = e4.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(name2.length() + v2.length() + 8 + 1);
                    sb2.append("<");
                    sb2.append(v2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    sb = sb2.toString();
                }
            }
            objArr[i3] = sb;
            i3++;
        }
        StringBuilder sb3 = new StringBuilder(str.length() + (length * 16));
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i4, indexOf);
            sb3.append(objArr[i]);
            i++;
            i4 = indexOf + 2;
        }
        sb3.append((CharSequence) str, i4, str.length());
        if (i < length2) {
            sb3.append(" [");
            sb3.append(objArr[i]);
            for (int i5 = i + 1; i5 < objArr.length; i5++) {
                sb3.append(", ");
                sb3.append(objArr[i5]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }
}
