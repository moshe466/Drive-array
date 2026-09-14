package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzduo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(zzdqk zzdqkVar) {
        String str;
        zzdun zzdunVar = new zzdun(zzdqkVar);
        StringBuilder sb = new StringBuilder(zzdunVar.size());
        for (int i = 0; i < zzdunVar.size(); i++) {
            int zzfe = zzdunVar.zzfe(i);
            if (zzfe == 34) {
                str = "\\\"";
            } else if (zzfe == 39) {
                str = "\\'";
            } else if (zzfe != 92) {
                switch (zzfe) {
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
                        if (zzfe < 32 || zzfe > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzfe >>> 6) & 3) + 48));
                            sb.append((char) (((zzfe >>> 3) & 7) + 48));
                            zzfe = (zzfe & 7) + 48;
                        }
                        sb.append((char) zzfe);
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
