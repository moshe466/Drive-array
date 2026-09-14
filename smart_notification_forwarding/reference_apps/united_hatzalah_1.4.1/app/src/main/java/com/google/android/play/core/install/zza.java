package com.google.android.play.core.install;

/* loaded from: classes.dex */
public final class zza {

    /* renamed from: a, reason: collision with root package name */
    public final int f3889a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3890b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3891c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3892d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3893e;

    public zza(int i, long j2, long j3, int i3, String str) {
        this.f3889a = i;
        this.f3890b = j2;
        this.f3891c = j3;
        this.f3892d = i3;
        if (str != null) {
            this.f3893e = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zza) {
            zza zzaVar = (zza) obj;
            if (this.f3889a == zzaVar.f3889a && this.f3890b == zzaVar.f3890b && this.f3891c == zzaVar.f3891c && this.f3892d == zzaVar.f3892d && this.f3893e.equals(zzaVar.f3893e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f3889a ^ 1000003;
        long j2 = this.f3890b;
        long j3 = this.f3891c;
        return (((((((i * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f3892d) * 1000003) ^ this.f3893e.hashCode();
    }

    public final String toString() {
        return "InstallState{installStatus=" + this.f3889a + ", bytesDownloaded=" + this.f3890b + ", totalBytesToDownload=" + this.f3891c + ", installErrorCode=" + this.f3892d + ", packageName=" + this.f3893e + "}";
    }
}
