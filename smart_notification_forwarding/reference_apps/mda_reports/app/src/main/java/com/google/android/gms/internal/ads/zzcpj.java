package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class zzcpj {
    private String zzgeb;

    /* loaded from: classes.dex */
    public static class zza {
        private String zzgeb;

        public final zza zzgj(String str) {
            this.zzgeb = str;
            return this;
        }
    }

    private zzcpj(zza zzaVar) {
        this.zzgeb = zzaVar.zzgeb;
    }

    public final Set<String> zzamz() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zzgeb.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzana() {
        return this.zzgeb.toLowerCase(Locale.ROOT);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int zzanb() {
        char c;
        String str = this.zzgeb;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1) {
            return 3;
        }
        if (c != 2) {
            return c != 3 ? 0 : 7;
        }
        return 6;
    }
}
