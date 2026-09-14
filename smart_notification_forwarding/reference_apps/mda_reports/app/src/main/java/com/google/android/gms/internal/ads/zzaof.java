package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaof extends zzaoo {
    private final Map<String, String> zzcsd;
    private final Context zzup;

    public zzaof(zzbdi zzbdiVar, Map<String, String> map) {
        super(zzbdiVar, "storePicture");
        this.zzcsd = map;
        this.zzup = zzbdiVar.zzyn();
    }

    public final void execute() {
        if (this.zzup == null) {
            zzds("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzkq();
        if (!zzawb.zzas(this.zzup).zzqd()) {
            zzds("Feature is not supported by the device.");
            return;
        }
        String str = this.zzcsd.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzds("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzds(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzq.zzkq();
        if (!zzawb.zzej(lastPathSegment)) {
            String valueOf2 = String.valueOf(lastPathSegment);
            zzds(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources resources = com.google.android.gms.ads.internal.zzq.zzku().getResources();
        com.google.android.gms.ads.internal.zzq.zzkq();
        AlertDialog.Builder zzar = zzawb.zzar(this.zzup);
        zzar.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
        zzar.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        zzar.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzaoi(this, str, lastPathSegment));
        zzar.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzaoh(this));
        zzar.create().show();
    }
}
