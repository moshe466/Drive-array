package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: f, reason: collision with root package name */
    private final int f2528f;

    /* renamed from: g, reason: collision with root package name */
    private final d f2529g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2530h;

    public a(int i10, d dVar, int i11) {
        this.f2528f = i10;
        this.f2529g = dVar;
        this.f2530h = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2528f);
        this.f2529g.L(this.f2530h, bundle);
    }
}
