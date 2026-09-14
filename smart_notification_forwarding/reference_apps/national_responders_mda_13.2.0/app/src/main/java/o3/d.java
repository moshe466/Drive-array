package o3;

import b2.p;

/* loaded from: classes.dex */
public class d extends Exception {
    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public d() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str) {
        super(str);
        p.h(str, "Detail message must not be empty");
    }
}
