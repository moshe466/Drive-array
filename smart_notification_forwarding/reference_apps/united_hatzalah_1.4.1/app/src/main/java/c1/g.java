package c1;

import R1.n;
import androidx.lifecycle.N;
import com.google.firebase.remoteconfig.internal.Code;
import f1.C0378A;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import kotlin.jvm.internal.j;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final C0378A f3879a;

    /* renamed from: b, reason: collision with root package name */
    public final n f3880b;

    public g(C0378A c0378a, n nVar) {
        this.f3879a = c0378a;
        this.f3880b = nVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x00a4. Please report as an issue. */
    public static String a(N n4, ArrayList arrayList) {
        char c4;
        long j2;
        long j3;
        byte b4;
        long j4;
        String data = AbstractC0707i.h0(arrayList, "", null, null, f.f3878a, 30);
        j.e(data, "data");
        byte[] bytes = data.getBytes(N2.a.f1509b);
        j.d(bytes, "getBytes(...)");
        int length = data.length();
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        long j5 = 0;
        long j6 = 0;
        while (wrap.remaining() >= 16) {
            long j7 = wrap.getLong();
            long j8 = wrap.getLong();
            long rotateLeft = Long.rotateLeft((Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ j5, 27) + j6;
            long j9 = 5;
            long j10 = (rotateLeft * j9) + 1390208809;
            j6 = ((Long.rotateLeft(j6 ^ (Long.rotateLeft(j8 * 5545529020109919103L, 33) * (-8663945395140668459L)), 31) + j10) * j9) + 944331445;
            j5 = j10;
        }
        wrap.compact();
        wrap.flip();
        if (wrap.remaining() > 0) {
            switch (wrap.remaining()) {
                case 1:
                    j2 = wrap.get(0) & 255;
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 2:
                    j3 = (wrap.get(1) & 255) << 8;
                    b4 = wrap.get(0);
                    j2 = (b4 & 255) ^ j3;
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 3:
                    j2 = (((wrap.get(2) & 255) << 16) ^ ((wrap.get(1) & 255) << 8)) ^ (wrap.get(0) & 255);
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 4:
                    j3 = (((wrap.get(3) & 255) << 24) ^ ((wrap.get(2) & 255) << 16)) ^ ((wrap.get(1) & 255) << 8);
                    b4 = wrap.get(0);
                    j2 = (b4 & 255) ^ j3;
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 5:
                    j3 = ((((wrap.get(4) & 255) << 32) ^ ((wrap.get(3) & 255) << 24)) ^ ((wrap.get(2) & 255) << 16)) ^ ((wrap.get(1) & 255) << 8);
                    b4 = wrap.get(0);
                    j2 = (b4 & 255) ^ j3;
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 6:
                    j3 = (((((wrap.get(4) & 255) << 32) ^ ((wrap.get(5) & 255) << 40)) ^ ((wrap.get(3) & 255) << 24)) ^ ((wrap.get(2) & 255) << 16)) ^ ((wrap.get(1) & 255) << 8);
                    b4 = wrap.get(0);
                    j2 = (b4 & 255) ^ j3;
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 7:
                    j3 = (((((wrap.get(4) & 255) << 32) ^ (((wrap.get(6) & 255) << 48) ^ ((wrap.get(5) & 255) << 40))) ^ ((wrap.get(3) & 255) << 24)) ^ ((wrap.get(2) & 255) << 16)) ^ ((wrap.get(1) & 255) << 8);
                    b4 = wrap.get(0);
                    j2 = (b4 & 255) ^ j3;
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 8:
                    j2 = wrap.getLong();
                    j4 = 0;
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 9:
                    j4 = wrap.get(8) & 255;
                    j2 = wrap.getLong();
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 10:
                    j4 = ((wrap.get(9) & 255) << 8) ^ (wrap.get(8) & 255);
                    j2 = wrap.getLong();
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 11:
                    j4 = (((wrap.get(10) & 255) << 16) ^ ((wrap.get(9) & 255) << 8)) ^ (wrap.get(8) & 255);
                    j2 = wrap.getLong();
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case Code.UNIMPLEMENTED /* 12 */:
                    j4 = ((((wrap.get(11) & 255) << 24) ^ ((wrap.get(10) & 255) << 16)) ^ ((wrap.get(9) & 255) << 8)) ^ (wrap.get(8) & 255);
                    j2 = wrap.getLong();
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 13:
                    j4 = (((((wrap.get(12) & 255) << 32) ^ ((wrap.get(11) & 255) << 24)) ^ ((wrap.get(10) & 255) << 16)) ^ ((wrap.get(9) & 255) << 8)) ^ (wrap.get(8) & 255);
                    j2 = wrap.getLong();
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 14:
                    j4 = ((((((wrap.get(13) & 255) << 40) ^ ((wrap.get(12) & 255) << 32)) ^ ((wrap.get(11) & 255) << 24)) ^ ((wrap.get(10) & 255) << 16)) ^ ((wrap.get(9) & 255) << 8)) ^ (wrap.get(8) & 255);
                    j2 = wrap.getLong();
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                case 15:
                    j4 = (((((((wrap.get(14) & 255) << 48) ^ ((wrap.get(13) & 255) << 40)) ^ ((wrap.get(12) & 255) << 32)) ^ ((wrap.get(11) & 255) << 24)) ^ ((wrap.get(10) & 255) << 16)) ^ ((wrap.get(9) & 255) << 8)) ^ (wrap.get(8) & 255);
                    j2 = wrap.getLong();
                    j5 ^= Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    c4 = '!';
                    j6 ^= Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    break;
                default:
                    throw new AssertionError("Code should not reach here!");
            }
        } else {
            c4 = '!';
        }
        long j11 = length;
        long j12 = j5 ^ j11;
        long j13 = j11 ^ j6;
        long j14 = j12 + j13;
        long j15 = j13 + j14;
        long j16 = (j14 ^ (j14 >>> c4)) * (-49064778989728563L);
        long j17 = (j16 ^ (j16 >>> c4)) * (-4265267296055464877L);
        long j18 = (j15 ^ (j15 >>> c4)) * (-49064778989728563L);
        long j19 = (j18 ^ (j18 >>> c4)) * (-4265267296055464877L);
        long j20 = (j19 >>> c4) ^ j19;
        long j21 = (j17 ^ (j17 >>> c4)) + j20;
        long[] jArr = {j21, j20 + j21};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(Long.toHexString(jArr[i]));
        }
        String sb2 = sb.toString();
        j.d(sb2, "toString(...)");
        return sb2;
    }
}
