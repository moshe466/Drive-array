package com.google.android.recaptcha.internal;

import N2.n;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import t2.AbstractC0708j;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public final class zzfk {
    private final List zza;

    public zzfk() {
        this(true);
    }

    public static final boolean zzc(Uri uri) {
        return zze(uri);
    }

    private final boolean zzd(String str) {
        List list = this.zza;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (n.M(str, (String) it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static final boolean zze(Uri uri) {
        if (!TextUtils.isEmpty(uri.toString()) && "https".equals(uri.getScheme()) && !TextUtils.isEmpty(uri.getHost())) {
            return true;
        }
        return false;
    }

    private static final List zzf(List list) {
        ArrayList arrayList = new ArrayList(AbstractC0709k.Y(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("https://" + ((String) it.next()) + RemoteSettings.FORWARD_SLASH_STRING);
        }
        return arrayList;
    }

    public final boolean zza(Uri uri) {
        if (zze(uri) && zzd(uri.toString())) {
            return true;
        }
        return false;
    }

    public final boolean zzb(String str) {
        Uri parse = Uri.parse(str);
        j.b(parse);
        if (zze(parse) && zzd(parse.toString())) {
            return true;
        }
        return false;
    }

    public zzfk(boolean z3) {
        this.zza = zzf(AbstractC0708j.W("www.recaptcha.net", "www.gstatic.com/recaptcha", "www.gstatic.cn/recaptcha"));
    }
}
