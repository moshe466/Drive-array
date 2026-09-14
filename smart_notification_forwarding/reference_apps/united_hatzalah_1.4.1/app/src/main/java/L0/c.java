package L0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f1134a;

    static {
        HashMap hashMap = new HashMap();
        f1134a = hashMap;
        hashMap.put(1, e.V2_SIG_MALFORMED_SIGNERS);
        hashMap.put(2, e.V2_SIG_NO_SIGNERS);
        hashMap.put(3, e.V2_SIG_MALFORMED_SIGNER);
        hashMap.put(4, e.V2_SIG_MALFORMED_SIGNATURE);
        hashMap.put(5, e.V2_SIG_NO_SIGNATURES);
        hashMap.put(6, e.V2_SIG_MALFORMED_CERTIFICATE);
        hashMap.put(7, e.V2_SIG_NO_CERTIFICATES);
        hashMap.put(8, e.V2_SIG_MALFORMED_DIGEST);
        hashMap.put(9, e.V3_SIG_MALFORMED_SIGNERS);
        hashMap.put(10, e.V3_SIG_NO_SIGNERS);
        hashMap.put(11, e.V3_SIG_MALFORMED_SIGNER);
        hashMap.put(12, e.V3_SIG_MALFORMED_SIGNATURE);
        hashMap.put(13, e.V3_SIG_NO_SIGNATURES);
        hashMap.put(14, e.V3_SIG_MALFORMED_CERTIFICATE);
        hashMap.put(15, e.V3_SIG_NO_CERTIFICATES);
        hashMap.put(16, e.V3_SIG_MALFORMED_DIGEST);
        hashMap.put(17, e.SOURCE_STAMP_NO_SIGNATURE);
        hashMap.put(18, e.SOURCE_STAMP_MALFORMED_CERTIFICATE);
        hashMap.put(19, e.SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM);
        hashMap.put(20, e.SOURCE_STAMP_MALFORMED_SIGNATURE);
        hashMap.put(21, e.SOURCE_STAMP_DID_NOT_VERIFY);
        hashMap.put(22, e.SOURCE_STAMP_VERIFY_EXCEPTION);
        hashMap.put(23, e.SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH);
        hashMap.put(24, e.SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST);
        hashMap.put(25, e.SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING);
        hashMap.put(26, e.SOURCE_STAMP_NO_SUPPORTED_SIGNATURE);
        hashMap.put(27, e.SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK);
        hashMap.put(28, e.MALFORMED_APK);
        hashMap.put(29, e.UNEXPECTED_EXCEPTION);
        hashMap.put(30, e.SOURCE_STAMP_SIG_MISSING);
        hashMap.put(31, e.SOURCE_STAMP_MALFORMED_ATTRIBUTE);
        hashMap.put(32, e.SOURCE_STAMP_UNKNOWN_ATTRIBUTE);
        hashMap.put(33, e.SOURCE_STAMP_MALFORMED_LINEAGE);
        hashMap.put(34, e.SOURCE_STAMP_POR_CERT_MISMATCH);
        hashMap.put(35, e.SOURCE_STAMP_POR_DID_NOT_VERIFY);
        hashMap.put(36, e.JAR_SIG_NO_SIGNATURES);
        hashMap.put(37, e.JAR_SIG_PARSE_EXCEPTION);
        hashMap.put(38, e.SOURCE_STAMP_INVALID_TIMESTAMP);
        hashMap.put(39, e.SOURCE_STAMP_SIGNATURE_SCHEME_NOT_AVAILABLE);
    }

    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar instanceof f) {
                arrayList.add((f) aVar);
            } else {
                arrayList.add(new f((e) f1134a.get(Integer.valueOf(aVar.f1130a)), aVar.a()));
            }
        }
        return arrayList;
    }
}
