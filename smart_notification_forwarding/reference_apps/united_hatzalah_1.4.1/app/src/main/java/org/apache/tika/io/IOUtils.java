package org.apache.tika.io;

import F0.AbstractC0008a;
import java.io.InputStream;

/* loaded from: classes.dex */
public class IOUtils {
    public static long skip(InputStream inputStream, long j2, byte[] bArr) {
        if (j2 >= 0) {
            long j3 = j2;
            while (j3 > 0) {
                long read = inputStream.read(bArr, 0, (int) Math.min(j3, bArr.length));
                if (read < 0) {
                    break;
                }
                j3 -= read;
            }
            return j2 - j3;
        }
        throw new IllegalArgumentException(AbstractC0008a.l("Skip count must be non-negative, actual: ", j2));
    }
}
