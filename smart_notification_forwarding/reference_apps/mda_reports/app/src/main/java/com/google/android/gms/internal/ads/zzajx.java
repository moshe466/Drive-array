package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzajx {
    private static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);
    public static final zzajy<JSONObject> zzdaq = new zzajz();
    public static final zzajw<InputStream> zzdar = zzaka.a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ InputStream a(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
