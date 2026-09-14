package io.opencensus.tags;

import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class TagMetadata {

    /* loaded from: classes2.dex */
    public enum TagTtl {
        NO_PROPAGATION(0),
        UNLIMITED_PROPAGATION(-1);

        private final int hops;

        TagTtl(int i) {
            this.hops = i;
        }
    }

    public static TagMetadata create(TagTtl tagTtl) {
        return new AutoValue_TagMetadata(tagTtl);
    }

    public abstract TagTtl getTagTtl();
}
