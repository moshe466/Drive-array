package org.apache.tika.mime;

import java.io.Serializable;

/* loaded from: classes.dex */
interface Clause extends Serializable {
    boolean eval(byte[] bArr);

    int size();
}
