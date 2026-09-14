package i7;

import b7.e;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class b {
    public static void a(b7.b bVar, d7.b bVar2, InputStream inputStream, int i10) {
        if (!bVar.a()) {
            throw new e("Connection is not open.");
        }
        int i11 = i10;
        while (i11 > 0) {
            try {
                byte[] bArr = new byte[4096 > i11 ? i11 : 4096];
                int read = inputStream.read(bArr);
                bVar.b(bArr, 0, read);
                i11 -= read;
                bVar2.a(i10 - i11, i10);
            } catch (IOException e10) {
                throw new e(e10.getMessage());
            }
        }
    }
}
