package L;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final InputContentInfo f1129a;

    public g(Object obj) {
        this.f1129a = (InputContentInfo) obj;
    }

    @Override // L.h
    public final Uri a() {
        return this.f1129a.getContentUri();
    }

    @Override // L.h
    public final void b() {
        this.f1129a.requestPermission();
    }

    @Override // L.h
    public final Uri c() {
        return this.f1129a.getLinkUri();
    }

    @Override // L.h
    public final Object e() {
        return this.f1129a;
    }

    @Override // L.h
    public final ClipDescription getDescription() {
        return this.f1129a.getDescription();
    }

    public g(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f1129a = new InputContentInfo(uri, clipDescription, uri2);
    }
}
