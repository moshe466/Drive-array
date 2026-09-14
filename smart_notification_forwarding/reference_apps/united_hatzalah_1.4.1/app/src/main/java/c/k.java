package c;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import i0.C0447a;
import r.InterfaceC0641p;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3827a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3828b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3829c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3830d;

    public /* synthetic */ k(Activity activity, o1.j jVar, int i) {
        this.f3827a = 3;
        this.f3828b = activity;
        this.f3830d = jVar;
        this.f3829c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.b bVar;
        ViewGroup viewGroup;
        switch (this.f3827a) {
            case 0:
                l lVar = (l) this.f3828b;
                Object obj = ((I1.h) this.f3830d).f923a;
                String str = (String) lVar.f4429a.get(Integer.valueOf(this.f3829c));
                if (str != null) {
                    e.e eVar = (e.e) lVar.f4433e.get(str);
                    if (eVar != null) {
                        bVar = eVar.f4421a;
                    } else {
                        bVar = null;
                    }
                    if (bVar == null) {
                        lVar.f4435g.remove(str);
                        lVar.f4434f.put(str, obj);
                        return;
                    }
                    e.b bVar2 = eVar.f4421a;
                    kotlin.jvm.internal.j.c(bVar2, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
                    if (lVar.f4432d.remove(str)) {
                        bVar2.a(obj);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                ((l) this.f3828b).a(this.f3829c, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f3830d));
                return;
            case 2:
                C0447a c0447a = (C0447a) this.f3828b;
                c0447a.f4936b.g(this.f3829c, this.f3830d);
                return;
            case 3:
                Activity activity = (Activity) this.f3828b;
                o1.j jVar = (o1.j) this.f3830d;
                ImageView imageView = new ImageView(activity);
                imageView.setImageResource(this.f3829c);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                View decorView = activity.getWindow().getDecorView();
                if (decorView instanceof ViewGroup) {
                    viewGroup = (ViewGroup) decorView;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.addView(imageView);
                }
                jVar.p = imageView;
                return;
            default:
                ((InterfaceC0641p) this.f3828b).onGreatestScrollPercentageIncreased(this.f3829c, (Bundle) this.f3830d);
                return;
        }
    }

    public /* synthetic */ k(Object obj, int i, int i3, Object obj2) {
        this.f3827a = i3;
        this.f3828b = obj;
        this.f3829c = i;
        this.f3830d = obj2;
    }
}
