package org.apache.tika.detect;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public class TextStatistics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int[] counts = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
    private int total = 0;

    private int countSafeControl() {
        return count(27) + count(12) + count(13) + count(10) + count(9);
    }

    public void addData(byte[] bArr, int i, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int[] iArr = this.counts;
            int i5 = bArr[i + i4] & ForkServer.ERROR;
            iArr[i5] = iArr[i5] + 1;
            this.total++;
        }
    }

    public int count() {
        return this.total;
    }

    public int countControl() {
        return count(0, 32) - countSafeControl();
    }

    public int countEightBit() {
        return count(128, UserVerificationMethods.USER_VERIFY_HANDPRINT);
    }

    public int countSafeAscii() {
        return count(32, 128) + countSafeControl();
    }

    public boolean isMostlyAscii() {
        int count = count(0, 32);
        int count2 = count(32, 128);
        int countSafeControl = countSafeControl();
        int i = this.total;
        if (i <= 0 || (count - countSafeControl) * 100 >= i * 2 || (count2 + countSafeControl) * 100 <= i * 90) {
            return false;
        }
        return true;
    }

    public boolean looksLikeUTF8() {
        int count = count(0, 32);
        int count2 = count(32, 128);
        int countSafeControl = countSafeControl();
        int[] iArr = {count(192, 224), count(224, 240), count(240, 248)};
        int i = 0;
        int i3 = 0;
        while (i < 3) {
            int i4 = iArr[i];
            count2 += i4;
            i++;
            i3 += i4 * i;
        }
        int count3 = count(128, 192);
        if (count2 <= 0 || count3 > i3 || count3 < i3 - 3 || count(248, UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 || (count - countSafeControl) * 100 >= count2 * 2) {
            return false;
        }
        return true;
    }

    public int count(int i) {
        return this.counts[i & 255];
    }

    private int count(int i, int i3) {
        int i4 = 0;
        while (i < i3) {
            i4 += this.counts[i];
            i++;
        }
        return i4;
    }
}
