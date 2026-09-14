package com.google.android.play.core.integrity;

/* loaded from: classes.dex */
final class a extends ap {

    /* renamed from: a, reason: collision with root package name */
    private String f3896a;

    /* renamed from: b, reason: collision with root package name */
    private y f3897b;

    @Override // com.google.android.play.core.integrity.ap
    public final ap a(y yVar) {
        this.f3897b = yVar;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    public final ap b(String str) {
        this.f3896a = str;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    public final aq c() {
        y yVar;
        String str = this.f3896a;
        if (str != null && (yVar = this.f3897b) != null) {
            return new aq(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3896a == null) {
            sb.append(" token");
        }
        if (this.f3897b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
