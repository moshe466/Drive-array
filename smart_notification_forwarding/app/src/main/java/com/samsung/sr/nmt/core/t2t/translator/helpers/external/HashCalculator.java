package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import android.util.Base64;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HashCalculator.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/HashCalculator;", JsonProperty.USE_DEFAULT_NAME, "()V", "getHash", JsonProperty.USE_DEFAULT_NAME, "byteArray", JsonProperty.USE_DEFAULT_NAME, "algorithm", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class HashCalculator {
    public static /* synthetic */ String getHash$default(HashCalculator hashCalculator, byte[] bArr, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "SHA-256";
        }
        return hashCalculator.getHash(bArr, str);
    }

    public final String getHash(byte[] byteArray, String algorithm) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(byteArray);
        return Base64.encodeToString(messageDigest.digest(), 2).toString();
    }
}
