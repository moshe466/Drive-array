package K;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f1053a;

    /* renamed from: b, reason: collision with root package name */
    public final f f1054b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1055c;

    public a(int i, f fVar, int i3) {
        this.f1053a = i;
        this.f1054b = fVar;
        this.f1055c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1053a);
        this.f1054b.f1063a.performAction(this.f1055c, bundle);
    }
}
