package Y;

import com.google.android.gms.common.api.Api;
import java.io.BufferedInputStream;

/* loaded from: classes.dex */
public final class g extends b {
    public g(byte[] bArr) {
        super(bArr);
        this.f2632a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final void b(long j2) {
        int i = this.f2633b;
        if (i > j2) {
            this.f2633b = 0;
            this.f2632a.reset();
        } else {
            j2 -= i;
        }
        a((int) j2);
    }

    public g(BufferedInputStream bufferedInputStream) {
        super(bufferedInputStream);
        if (bufferedInputStream.markSupported()) {
            this.f2632a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
