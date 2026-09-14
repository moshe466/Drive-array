package Y;

import android.media.MediaDataSource;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* renamed from: a, reason: collision with root package name */
    public long f2630a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f2631b;

    public a(g gVar) {
        this.f2631b = gVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j2, byte[] bArr, int i, int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (j2 < 0) {
            return -1;
        }
        try {
            long j3 = this.f2630a;
            g gVar = this.f2631b;
            if (j3 != j2) {
                if (j3 >= 0 && j2 >= j3 + gVar.f2632a.available()) {
                    return -1;
                }
                gVar.b(j2);
                this.f2630a = j2;
            }
            if (i3 > gVar.f2632a.available()) {
                i3 = gVar.f2632a.available();
            }
            int read = gVar.read(bArr, i, i3);
            if (read >= 0) {
                this.f2630a += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f2630a = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
