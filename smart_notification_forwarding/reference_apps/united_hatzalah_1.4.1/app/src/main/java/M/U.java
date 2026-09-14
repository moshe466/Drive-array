package m;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import r.BinderC0632g;

/* loaded from: classes.dex */
public final class U implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5601a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5602b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5603c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5604d;

    public U(TextView textView, Typeface typeface, int i) {
        this.f5603c = textView;
        this.f5604d = typeface;
        this.f5602b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5601a) {
            case 0:
                ((TextView) this.f5603c).setTypeface((Typeface) this.f5604d, this.f5602b);
                return;
            default:
                ((BinderC0632g) this.f5604d).f6182b.onNavigationEvent(this.f5602b, (Bundle) this.f5603c);
                return;
        }
    }

    public U(int i, Bundle bundle, BinderC0632g binderC0632g) {
        this.f5604d = binderC0632g;
        this.f5602b = i;
        this.f5603c = bundle;
    }
}
