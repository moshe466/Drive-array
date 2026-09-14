package e3;

import F0.C0018c1;
import F0.C0110z2;
import android.content.Context;
import android.view.View;
import io.flutter.util.ViewUtils;
import java.io.IOException;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements d3.a, d3.b, ViewUtils.ViewVisitor, q1.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4461a;

    public /* synthetic */ c(int i) {
        this.f4461a = i;
    }

    @Override // q1.h
    public void a(Exception exc) {
    }

    @Override // d3.a
    public void accept(Object obj) {
        throw ((IOException) obj);
    }

    @Override // d3.b
    public Object b(f3.b bVar) {
        return f3.a.f4613a;
    }

    public C0018c1 c(Context context) {
        switch (this.f4461a) {
            case 2:
                return new C0018c1(context);
            default:
                return new C0018c1(context);
        }
    }

    public C0110z2 d(Context context, C0018c1 c0018c1) {
        switch (this.f4461a) {
            case 4:
                return new C0110z2(context, c0018c1);
            default:
                return new C0110z2(context, c0018c1);
        }
    }

    @Override // io.flutter.util.ViewUtils.ViewVisitor
    public boolean run(View view) {
        return ViewUtils.a(view);
    }
}
