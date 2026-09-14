package org.apache.tika.utils;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements EntityResolver {
    @Override // org.xml.sax.EntityResolver
    public final InputSource resolveEntity(String str, String str2) {
        InputSource lambda$static$0;
        lambda$static$0 = XMLReaderUtils.lambda$static$0(str, str2);
        return lambda$static$0;
    }
}
