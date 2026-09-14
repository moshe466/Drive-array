package com.google.android.gms.gass.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzfz;
import java.io.File;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Program {
    public static final long PROGRAM_ALMOST_EXPIRED_TIME_SECS = 3600;
    private final zzfz zzgte;
    private final File zzgtf;
    private final File zzgtg;
    private final File zzgth;
    private byte[] zzgti;
    private byte[] zzgtj;

    public Program(@NonNull zzfz zzfzVar, @NonNull File file, @NonNull File file2, @NonNull File file3) {
        this.zzgte = zzfzVar;
        this.zzgtf = file;
        this.zzgtg = file3;
        this.zzgth = file2;
    }

    public File getBytecodeFile() {
        return this.zzgth;
    }

    public byte[] getBytecodeFileContents() {
        if (this.zzgtj == null) {
            this.zzgtj = zzj.zze(this.zzgth);
        }
        byte[] bArr = this.zzgtj;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public File getOptFile() {
        return this.zzgtg;
    }

    public zzfz getProgramMetadata() {
        return this.zzgte;
    }

    public File getVmFile() {
        return this.zzgtf;
    }

    public byte[] getVmFileContents() {
        if (this.zzgti == null) {
            this.zzgti = zzj.zze(this.zzgtf);
        }
        byte[] bArr = this.zzgti;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean isAlmostExpired() {
        return isAlmostExpired(PROGRAM_ALMOST_EXPIRED_TIME_SECS);
    }

    public boolean isAlmostExpired(long j) {
        return this.zzgte.zzcz() - (System.currentTimeMillis() / 1000) < j;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() / 1000 > this.zzgte.zzcz();
    }
}
