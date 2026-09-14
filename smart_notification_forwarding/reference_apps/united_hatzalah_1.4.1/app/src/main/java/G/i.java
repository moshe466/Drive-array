package G;

import android.net.Uri;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f791a;

    /* renamed from: b, reason: collision with root package name */
    public final int f792b;

    /* renamed from: c, reason: collision with root package name */
    public final int f793c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f794d;

    /* renamed from: e, reason: collision with root package name */
    public final String f795e;

    /* renamed from: f, reason: collision with root package name */
    public final int f796f;

    public i(Uri uri, int i, int i3, boolean z3, int i4) {
        uri.getClass();
        this.f791a = uri;
        this.f792b = i;
        this.f793c = i3;
        this.f794d = z3;
        this.f795e = null;
        this.f796f = i4;
    }

    public i(String str, String str2) {
        this.f791a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f792b = 0;
        this.f793c = 400;
        this.f794d = false;
        this.f795e = str2;
        this.f796f = 0;
    }
}
