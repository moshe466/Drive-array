package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class da {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(d6 d6Var) {
        String str;
        ca caVar = new ca(d6Var);
        StringBuilder sb2 = new StringBuilder(caVar.zza());
        for (int i10 = 0; i10 < caVar.zza(); i10++) {
            int b10 = caVar.b(i10);
            if (b10 == 34) {
                str = "\\\"";
            } else if (b10 == 39) {
                str = "\\'";
            } else if (b10 != 92) {
                switch (b10) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (b10 < 32 || b10 > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((b10 >>> 6) & 3) + 48));
                            sb2.append((char) (((b10 >>> 3) & 7) + 48));
                            b10 = (b10 & 7) + 48;
                        }
                        sb2.append((char) b10);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb2.append(str);
        }
        return sb2.toString();
    }
}
