package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzhr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(zzdu zzduVar) {
        String str;
        zzhu zzhuVar = new zzhu(zzduVar);
        StringBuilder sb = new StringBuilder(zzhuVar.zza());
        for (int i = 0; i < zzhuVar.zza(); i++) {
            int zza = zzhuVar.zza(i);
            if (zza == 34) {
                str = "\\\"";
            } else if (zza == 39) {
                str = "\\'";
            } else if (zza != 92) {
                switch (zza) {
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
                        if (zza < 32 || zza > 126) {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            zza = (zza & 7) + 48;
                        }
                        sb.append((char) zza);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
