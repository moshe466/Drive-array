package j1;

/* loaded from: classes.dex */
final class h extends n {

    /* renamed from: a, reason: collision with root package name */
    private final long f10959a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(long j10) {
        this.f10959a = j10;
    }

    @Override // j1.n
    public long c() {
        return this.f10959a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f10959a == ((n) obj).c();
    }

    public int hashCode() {
        long j10 = this.f10959a;
        return 1000003 ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f10959a + "}";
    }
}
