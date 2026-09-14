package r;

import J.A;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import q.C0602B;

/* renamed from: r.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0634i {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f6185a;

    /* renamed from: b, reason: collision with root package name */
    public final C0602B f6186b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f6187c;

    /* renamed from: d, reason: collision with root package name */
    public ActivityOptions f6188d;

    /* renamed from: e, reason: collision with root package name */
    public Bundle f6189e;

    /* renamed from: f, reason: collision with root package name */
    public int f6190f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6191g;

    /* JADX WARN: Type inference failed for: r0v1, types: [q.B, java.lang.Object] */
    public C0634i() {
        this.f6185a = new Intent("android.intent.action.VIEW");
        this.f6186b = new Object();
        this.f6190f = 0;
        this.f6191g = true;
    }

    public final C0635j a() {
        String str;
        Bundle bundle;
        Intent intent = this.f6185a;
        Bundle bundle2 = null;
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle3 = new Bundle();
            bundle3.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle3);
        }
        ArrayList<? extends Parcelable> arrayList = this.f6187c;
        if (arrayList != null) {
            intent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f6191g);
        this.f6186b.getClass();
        intent.putExtras(new Bundle());
        Bundle bundle4 = this.f6189e;
        if (bundle4 != null) {
            intent.putExtras(bundle4);
        }
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f6190f);
        int i = Build.VERSION.SDK_INT;
        LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
        if (adjustedDefault.size() > 0) {
            str = adjustedDefault.get(0).toLanguageTag();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (intent.hasExtra("com.android.browser.headers")) {
                bundle = intent.getBundleExtra("com.android.browser.headers");
            } else {
                bundle = new Bundle();
            }
            if (!bundle.containsKey("Accept-Language")) {
                bundle.putString("Accept-Language", str);
                intent.putExtra("com.android.browser.headers", bundle);
            }
        }
        if (i >= 34) {
            if (this.f6188d == null) {
                this.f6188d = ActivityOptions.makeBasic();
            }
            A.i(this.f6188d);
        }
        if (i >= 36) {
            if (this.f6188d == null) {
                this.f6188d = ActivityOptions.makeBasic();
            }
            K.e.f(this.f6188d, !intent.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
        }
        ActivityOptions activityOptions = this.f6188d;
        if (activityOptions != null) {
            bundle2 = activityOptions.toBundle();
        }
        return new C0635j(intent, bundle2);
    }

    public final void b(int i) {
        if (i >= 0 && i <= 2) {
            this.f6190f = i;
            Intent intent = this.f6185a;
            if (i == 1) {
                intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
                return;
            } else if (i == 2) {
                intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
                return;
            } else {
                intent.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid value for the shareState argument");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [q.B, java.lang.Object] */
    public C0634i(C0640o c0640o) {
        Intent intent = new Intent("android.intent.action.VIEW");
        this.f6185a = intent;
        this.f6186b = new Object();
        this.f6190f = 0;
        this.f6191g = true;
        if (c0640o != null) {
            intent.setPackage(c0640o.f6203d.getPackageName());
            BinderC0632g binderC0632g = c0640o.f6202c;
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", binderC0632g);
            intent.putExtras(bundle);
        }
    }
}
