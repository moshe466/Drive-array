package com.google.android.play.core.integrity;

/* loaded from: classes.dex */
final class b extends bq {

    /* renamed from: a, reason: collision with root package name */
    private String f3949a;

    /* renamed from: b, reason: collision with root package name */
    private y f3950b;

    @Override // com.google.android.play.core.integrity.bq
    public final bq a(y yVar) {
        this.f3950b = yVar;
        return this;
    }

    @Override // com.google.android.play.core.integrity.bq
    public final bq b(String str) {
        if (str != null) {
            this.f3949a = str;
            return this;
        }
        throw new NullPointerException("Null token");
    }

    @Override // com.google.android.play.core.integrity.bq
    public final br c() {
        y yVar;
        String str = this.f3949a;
        if (str != null && (yVar = this.f3950b) != null) {
            return new br(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3949a == null) {
            sb.append(" token");
        }
        if (this.f3950b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
