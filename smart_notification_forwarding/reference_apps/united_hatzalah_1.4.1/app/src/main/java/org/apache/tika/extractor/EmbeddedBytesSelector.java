package org.apache.tika.extractor;

import org.apache.tika.metadata.Metadata;

/* loaded from: classes.dex */
public interface EmbeddedBytesSelector {
    public static final EmbeddedBytesSelector ACCEPT_ALL = new AcceptAll();

    /* loaded from: classes.dex */
    public static class AcceptAll implements EmbeddedBytesSelector {
        @Override // org.apache.tika.extractor.EmbeddedBytesSelector
        public boolean select(Metadata metadata) {
            return true;
        }
    }

    boolean select(Metadata metadata);
}
