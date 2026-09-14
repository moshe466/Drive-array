package org.apache.tika.parser.external;

import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.parser.CompositeParser;

/* loaded from: classes.dex */
public class CompositeExternalParser extends CompositeParser {
    private static final long serialVersionUID = 6962436916649024024L;

    public CompositeExternalParser() {
        this(new MediaTypeRegistry());
    }

    public CompositeExternalParser(MediaTypeRegistry mediaTypeRegistry) {
        super(mediaTypeRegistry, ExternalParsersFactory.create());
    }
}
