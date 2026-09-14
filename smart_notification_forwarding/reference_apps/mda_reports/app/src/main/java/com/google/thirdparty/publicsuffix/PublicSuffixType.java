package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c, char c2) {
        this.innerNodeCode = c;
        this.leafNodeCode = c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PublicSuffixType a(char c) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.a() == c || publicSuffixType.b() == c) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c);
    }

    char a() {
        return this.innerNodeCode;
    }

    char b() {
        return this.leafNodeCode;
    }
}
