package org.apache.tika.sax;

import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class StoppingEarlyException extends SAXException {
    public static final StoppingEarlyException INSTANCE = new StoppingEarlyException();
}
