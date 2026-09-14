package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes.dex */
final class u implements av {

    /* renamed from: a, reason: collision with root package name */
    private Context f4015a;

    private u() {
    }

    public final u a(Context context) {
        context.getClass();
        this.f4015a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.av
    public final aw b() {
        Context context = this.f4015a;
        if (context != null) {
            return new w(context, null);
        }
        throw new IllegalStateException(String.valueOf(Context.class.getCanonicalName()).concat(" must be set"));
    }

    public /* synthetic */ u(t tVar) {
    }
}
