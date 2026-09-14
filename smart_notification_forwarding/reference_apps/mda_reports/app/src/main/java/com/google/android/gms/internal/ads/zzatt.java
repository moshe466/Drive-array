package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@TargetApi(21)
/* loaded from: classes.dex */
final class zzatt {
    private static final Map<String, String> zzdpb;
    private final List<String> zzdpc;
    private final zzatf zzdpd;
    private final Context zzup;

    static {
        HashMap hashMap = new HashMap();
        if (PlatformVersion.isAtLeastLollipop()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        zzdpb = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatt(Context context, List<String> list, zzatf zzatfVar) {
        this.zzup = context;
        this.zzdpc = list;
        this.zzdpd = zzatfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> a(String[] strArr) {
        boolean z;
        boolean z2;
        String valueOf;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator<String> it = this.zzdpc.iterator();
            do {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    break;
                }
                valueOf = String.valueOf(next);
            } while (!(valueOf.length() != 0 ? "android.webkit.resource.".concat(valueOf) : new String("android.webkit.resource.")).equals(str));
            z2 = true;
            if (z2) {
                if (zzdpb.containsKey(str)) {
                    com.google.android.gms.ads.internal.zzq.zzkq();
                    if (!zzawb.zzq(this.zzup, zzdpb.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.zzdpd.b(str);
                }
            } else {
                this.zzdpd.a(str);
            }
        }
        return arrayList;
    }
}
