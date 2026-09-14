package S0;

import java.util.Comparator;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class e implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final e f2088a = new Object();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            int i3 = (bArr[i] & ForkServer.ERROR) - (bArr2[i] & ForkServer.ERROR);
            if (i3 != 0) {
                return i3;
            }
        }
        return bArr.length - bArr2.length;
    }
}
