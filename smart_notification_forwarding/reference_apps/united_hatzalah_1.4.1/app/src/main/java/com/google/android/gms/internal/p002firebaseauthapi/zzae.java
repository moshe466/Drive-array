package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import e0.a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class zzae {
    public static String zza(String str) {
        return zzr.zzb(str);
    }

    public static String zzb(String str) {
        return zzr.zzc(str);
    }

    public static boolean zzc(String str) {
        return zzr.zzd(str);
    }

    public static String zza(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i3 = 0; i3 < objArr.length; i3++) {
                objArr[i3] = zza(objArr[i3]);
            }
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + valueOf.length());
        int i4 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i4)) != -1) {
            sb.append((CharSequence) valueOf, i4, indexOf);
            sb.append(objArr[i]);
            i4 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i4, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i5 = i + 1; i5 < objArr.length; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String zza(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e4) {
            String o2 = AbstractC0008a.o(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", a.d("Exception during lenientFormat for ", o2), (Throwable) e4);
            return AbstractC0008a.p("<", o2, " threw ", e4.getClass().getName(), ">");
        }
    }
}
