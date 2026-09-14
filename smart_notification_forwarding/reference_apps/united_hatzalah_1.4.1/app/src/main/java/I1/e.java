package I1;

import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final y f919a = new y("PhoneskyVerificationUtils");

    public static boolean a(Signature[] signatureArr) {
        String str;
        if (signatureArr != null && (signatureArr.length) != 0) {
            for (Signature signature : signatureArr) {
                byte[] byteArray = signature.toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(byteArray);
                    str = Base64.encodeToString(messageDigest.digest(), 11);
                } catch (NoSuchAlgorithmException unused) {
                    str = "";
                }
                if (!"8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(str)) {
                    String str2 = Build.TAGS;
                    if ((str2.contains("dev-keys") || str2.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(str)) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        } else {
            Object[] objArr = new Object[0];
            y yVar = f919a;
            yVar.getClass();
            if (Log.isLoggable("PlayCore", 5)) {
                y.c(yVar.f929a, "Phonesky package is not signed -- possibly self-built package. Could not verify.", objArr);
            }
        }
        return false;
    }
}
