package w;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f6636a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f6637b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6638c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6639d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6640e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f6641f;

    /* renamed from: g, reason: collision with root package name */
    public final PendingIntent f6642g;

    public h(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat b4;
        if (i == 0) {
            b4 = null;
        } else {
            b4 = IconCompat.b(i);
        }
        Bundle bundle = new Bundle();
        this.f6639d = true;
        this.f6637b = b4;
        if (b4 != null && b4.d() == 2) {
            this.f6640e = b4.c();
        }
        this.f6641f = n.b(charSequence);
        this.f6642g = pendingIntent;
        this.f6636a = bundle;
        this.f6638c = true;
        this.f6639d = true;
    }
}
