package com.google.android.play.core.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends r {
    private final /* synthetic */ r a;
    private final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(t tVar, com.google.android.play.core.tasks.h hVar, r rVar) {
        super(hVar);
        this.b = tVar;
        this.a = rVar;
    }

    @Override // com.google.android.play.core.internal.r
    public final void a() {
        this.b.b(this.a);
    }
}
