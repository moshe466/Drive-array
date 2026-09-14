package org.apache.tika.pipes.fetcher;

import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;

/* loaded from: classes.dex */
public interface RangeFetcher extends Fetcher {
    default InputStream fetch(String str, long j2, long j3, Metadata metadata) {
        return fetch(str, j2, j3, metadata, new ParseContext());
    }

    InputStream fetch(String str, long j2, long j3, Metadata metadata, ParseContext parseContext);
}
