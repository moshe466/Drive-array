package q2;

import android.widget.Toast$Callback;

/* renamed from: q2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0624b extends Toast$Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0625c f6155a;

    public C0624b(C0625c c0625c) {
        this.f6155a = c0625c;
    }

    public final void onToastHidden() {
        super.onToastHidden();
        this.f6155a.f6157b = null;
    }
}
