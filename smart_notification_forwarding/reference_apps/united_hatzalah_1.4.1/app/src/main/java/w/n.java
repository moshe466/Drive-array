package w;

import F0.AbstractC0083t;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.uh.sf.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6647a;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f6651e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f6652f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f6653g;

    /* renamed from: h, reason: collision with root package name */
    public IconCompat f6654h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f6655j;

    /* renamed from: l, reason: collision with root package name */
    public AbstractC0083t f6657l;

    /* renamed from: m, reason: collision with root package name */
    public String f6658m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6659n;
    public String p;

    /* renamed from: q, reason: collision with root package name */
    public Bundle f6661q;

    /* renamed from: t, reason: collision with root package name */
    public String f6664t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f6665u;

    /* renamed from: v, reason: collision with root package name */
    public final Notification f6666v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6667w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f6668x;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f6648b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f6649c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f6650d = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public boolean f6656k = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6660o = false;

    /* renamed from: r, reason: collision with root package name */
    public int f6662r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f6663s = 0;

    public n(Context context, String str) {
        Notification notification = new Notification();
        this.f6666v = notification;
        this.f6647a = context;
        this.f6664t = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f6655j = 0;
        this.f6668x = new ArrayList();
        this.f6665u = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        if (charSequence == null) {
            return charSequence;
        }
        if (charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }

    public final Notification a() {
        Notification notification;
        Bundle bundle;
        o oVar = new o(this);
        n nVar = oVar.f6671c;
        AbstractC0083t abstractC0083t = nVar.f6657l;
        if (abstractC0083t != null) {
            abstractC0083t.a(oVar);
        }
        int i = Build.VERSION.SDK_INT;
        Notification.Builder builder = oVar.f6670b;
        if (i >= 26) {
            notification = builder.build();
        } else {
            Notification build = builder.build();
            int i3 = oVar.f6673e;
            if (i3 != 0) {
                if (build.getGroup() != null && (build.flags & UserVerificationMethods.USER_VERIFY_NONE) != 0 && i3 == 2) {
                    build.sound = null;
                    build.vibrate = null;
                    build.defaults &= -4;
                }
                if (build.getGroup() != null && (build.flags & UserVerificationMethods.USER_VERIFY_NONE) == 0 && i3 == 1) {
                    build.sound = null;
                    build.vibrate = null;
                    build.defaults &= -4;
                }
            }
            notification = build;
        }
        if (abstractC0083t != null) {
            nVar.f6657l.getClass();
        }
        if (abstractC0083t != null && (bundle = notification.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", abstractC0083t.g());
        }
        return notification;
    }

    public final void c(PendingIntent pendingIntent) {
        this.f6653g = pendingIntent;
    }

    public final void d(int i, boolean z3) {
        Notification notification = this.f6666v;
        if (z3) {
            notification.flags = i | notification.flags;
        } else {
            notification.flags = (~i) & notification.flags;
        }
    }

    public final void e(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f6647a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.f3044k;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.f3046b = bitmap;
            iconCompat = iconCompat2;
        }
        this.f6654h = iconCompat;
    }

    public final void f() {
        this.f6666v.icon = android.R.drawable.stat_sys_download_done;
    }

    public final void g(AbstractC0083t abstractC0083t) {
        if (this.f6657l != abstractC0083t) {
            this.f6657l = abstractC0083t;
            if (((n) abstractC0083t.f662a) != this) {
                abstractC0083t.f662a = this;
                g(abstractC0083t);
            }
        }
    }
}
