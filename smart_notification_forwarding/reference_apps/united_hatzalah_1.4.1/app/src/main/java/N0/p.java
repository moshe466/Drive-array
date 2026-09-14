package N0;

import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.Asn1EncodingException;
import com.android.apksig.internal.x509.RSAPublicKey;
import com.android.apksig.internal.x509.SubjectPublicKeyInfo;
import io.flutter.embedding.android.KeyboardMap;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final s[] f1481a = {s.CHUNKED_SHA512, s.VERITY_CHUNKED_SHA256, s.CHUNKED_SHA256};

    public static void a(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) ((i >> 16) & 255);
        bArr[4] = (byte) ((i >> 24) & 255);
    }

    public static HashMap b(HashSet hashSet, Y0.b bVar, Y0.b bVar2, W0.a aVar) {
        int i = Y0.c.f2705h;
        HashMap hashMap = new HashMap();
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar == s.CHUNKED_SHA256 || sVar == s.CHUNKED_SHA512) {
                hashSet2.add(sVar);
            }
        }
        int i3 = 0;
        Y0.b[] bVarArr = {bVar, bVar2, aVar};
        long j2 = 0;
        for (int i4 = 0; i4 < 3; i4++) {
            j2 += (bVarArr[i4].size() + 1048575) / 1048576;
        }
        if (j2 <= 2147483647L) {
            int i5 = (int) j2;
            ArrayList arrayList = new ArrayList(hashSet2.size());
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new g((s) it2.next(), i5));
            }
            new f(new i(bVarArr), arrayList).run();
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                g gVar = (g) obj;
                hashMap.put(gVar.f1456a, MessageDigest.getInstance(gVar.f1456a.f1491b).digest(gVar.f1458c));
            }
            s sVar2 = s.VERITY_CHUNKED_SHA256;
            if (hashSet.contains(sVar2)) {
                ByteBuffer allocate = ByteBuffer.allocate(40);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                W0.i iVar = new W0.i(new byte[8]);
                try {
                    allocate.put(iVar.b(bVar, bVar2, aVar));
                    allocate.putLong(bVar.size() + bVar2.size() + aVar.f2447b);
                    hashMap.put(sVar2, allocate.array());
                    iVar.close();
                    return hashMap;
                } catch (Throwable th) {
                    try {
                        iVar.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            return hashMap;
        }
        throw new DigestException("Input too long: " + j2 + " chunks");
    }

    public static byte[] c(PublicKey publicKey) {
        byte[] bArr = null;
        if ("X.509".equals(publicKey.getFormat())) {
            byte[] encoded = publicKey.getEncoded();
            String algorithm = publicKey.getAlgorithm();
            if ("RSA".equals(algorithm) || "1.2.840.113549.1.1.1".equals(algorithm)) {
                try {
                    SubjectPublicKeyInfo subjectPublicKeyInfo = (SubjectPublicKeyInfo) S0.c.g(ByteBuffer.wrap(encoded), SubjectPublicKeyInfo.class);
                    ByteBuffer byteBuffer = subjectPublicKeyInfo.subjectPublicKey;
                    byte b4 = byteBuffer.get();
                    RSAPublicKey rSAPublicKey = (RSAPublicKey) S0.c.g(byteBuffer, RSAPublicKey.class);
                    if (rSAPublicKey.modulus.compareTo(BigInteger.ZERO) < 0) {
                        byte[] byteArray = rSAPublicKey.modulus.toByteArray();
                        byte[] bArr2 = new byte[byteArray.length + 1];
                        bArr2[0] = 0;
                        System.arraycopy(byteArray, 0, bArr2, 1, byteArray.length);
                        rSAPublicKey.modulus = new BigInteger(bArr2);
                        byte[] b5 = S0.f.b(rSAPublicKey);
                        byte[] bArr3 = new byte[b5.length + 1];
                        bArr3[0] = b4;
                        System.arraycopy(b5, 0, bArr3, 1, b5.length);
                        subjectPublicKeyInfo.subjectPublicKey = ByteBuffer.wrap(bArr3);
                        encoded = S0.f.b(subjectPublicKeyInfo);
                    }
                } catch (Asn1DecodingException | Asn1EncodingException e4) {
                    System.out.println("Caught a exception encoding the public key: " + e4);
                    e4.printStackTrace();
                }
            }
            bArr = encoded;
        }
        if (bArr == null) {
            try {
                bArr = ((X509EncodedKeySpec) KeyFactory.getInstance(publicKey.getAlgorithm()).getKeySpec(publicKey, X509EncodedKeySpec.class)).getEncoded();
            } catch (InvalidKeySpecException e5) {
                throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName(), e5);
            }
        }
        if (bArr != null && bArr.length != 0) {
            return bArr;
        }
        throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName());
    }

    public static void d(Y0.b bVar, Y0.b bVar2, ByteBuffer byteBuffer, HashSet hashSet, n nVar) {
        int i = Y0.c.f2705h;
        if (!hashSet.isEmpty()) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            int position = byteBuffer.position();
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.put(byteBuffer);
            allocate.flip();
            byteBuffer.position(position);
            p3.h.E(allocate, bVar.size());
            try {
                HashMap b4 = b(hashSet, bVar, bVar2, new W0.a(allocate, true));
                if (b4.containsKey(s.VERITY_CHUNKED_SHA256)) {
                    if (bVar.size() % 4096 == 0) {
                        p3.h.d(byteBuffer);
                        long j2 = (byteBuffer.getInt(byteBuffer.position() + 16) & KeyboardMap.kValueMask) - bVar.size();
                        if (j2 % 4096 != 0) {
                            throw new RuntimeException("APK Signing Block size is not multiple of page size: " + j2);
                        }
                    } else {
                        throw new RuntimeException("APK Signing Block is not aligned on 4k boundary: " + bVar.size());
                    }
                }
                if (hashSet.equals(b4.keySet())) {
                    ArrayList arrayList = nVar.f1479g;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        m mVar = (m) obj;
                        ArrayList arrayList2 = mVar.f1470g;
                        int size2 = arrayList2.size();
                        int i4 = 0;
                        while (i4 < size2) {
                            Object obj2 = arrayList2.get(i4);
                            i4++;
                            k kVar = (k) obj2;
                            t a2 = t.a(kVar.f1467a);
                            if (a2 != null) {
                                s sVar = a2.f1496c;
                                if (hashSet.contains(sVar)) {
                                    byte[] bArr = kVar.f1468b;
                                    byte[] bArr2 = (byte[]) b4.get(sVar);
                                    if (!Arrays.equals(bArr, bArr2)) {
                                        int i5 = nVar.f1430a;
                                        if (i5 == 2) {
                                            mVar.f(L0.e.V2_SIG_APK_DIGEST_DID_NOT_VERIFY, sVar, q.f(bArr), q.f(bArr2));
                                        } else if (i5 == 3) {
                                            mVar.f(L0.e.V3_SIG_APK_DIGEST_DID_NOT_VERIFY, sVar, q.f(bArr), q.f(bArr2));
                                        }
                                    } else {
                                        mVar.f1471h.put(sVar, bArr2);
                                    }
                                }
                            }
                        }
                    }
                    return;
                }
                throw new RuntimeException("Mismatch between sets of requested and computed content digests . Requested: " + hashSet + ", computed: " + b4.keySet());
            } catch (DigestException e4) {
                throw new RuntimeException("Failed to compute content digests", e4);
            }
        }
        throw new RuntimeException("No content digests found");
    }
}
