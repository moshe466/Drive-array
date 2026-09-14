package w6;

import android.net.Uri;
import java.util.UUID;

/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    public String f15171a;

    /* renamed from: b, reason: collision with root package name */
    public String f15172b;

    /* renamed from: c, reason: collision with root package name */
    public String f15173c;

    /* renamed from: d, reason: collision with root package name */
    public String f15174d;

    /* renamed from: e, reason: collision with root package name */
    public String f15175e;

    /* renamed from: f, reason: collision with root package name */
    public String f15176f;

    public h0(Uri uri) {
        uri.getQueryParameter("fileType");
        uri.getQueryParameter("maxSize");
        uri.getQueryParameter("fileCategory");
        this.f15171a = uri.getQueryParameter("application");
        this.f15172b = uri.getQueryParameter("module");
        this.f15173c = uri.getQueryParameter("function");
        this.f15174d = uri.getQueryParameter("token");
        this.f15175e = uri.getQueryParameter("requestData");
        UUID.randomUUID().toString();
    }
}
