package x4;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final String f15421a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15422b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.f15421a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f15422b = str2;
    }

    @Override // x4.f
    public String b() {
        return this.f15421a;
    }

    @Override // x4.f
    public String c() {
        return this.f15422b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f15421a.equals(fVar.b()) && this.f15422b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.f15421a.hashCode() ^ 1000003) * 1000003) ^ this.f15422b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f15421a + ", version=" + this.f15422b + "}";
    }
}
