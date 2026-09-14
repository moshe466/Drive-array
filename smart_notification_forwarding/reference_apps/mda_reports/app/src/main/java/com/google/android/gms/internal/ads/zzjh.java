package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class zzjh {
    private static final zzlm zzana = new zzjk();
    private static final Pattern zzanb = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzafr = -1;
    public int zzafs = -1;

    private final boolean zzb(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzanb.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzafr = parseInt;
                    this.zzafs = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzb(zzle zzleVar) {
        for (int i = 0; i < zzleVar.length(); i++) {
            zzle.zza zzas = zzleVar.zzas(i);
            if (zzas instanceof zzlk) {
                zzlk zzlkVar = (zzlk) zzas;
                if (zzb(zzlkVar.description, zzlkVar.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzgk() {
        return (this.zzafr == -1 || this.zzafs == -1) ? false : true;
    }
}
