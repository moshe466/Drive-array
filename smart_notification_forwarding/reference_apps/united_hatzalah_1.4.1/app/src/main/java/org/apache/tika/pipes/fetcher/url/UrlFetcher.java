package org.apache.tika.pipes.fetcher.url;

import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.pipes.fetcher.AbstractFetcher;

/* loaded from: classes.dex */
public class UrlFetcher extends AbstractFetcher {
    @Override // org.apache.tika.pipes.fetcher.Fetcher
    public InputStream fetch(String str, Metadata metadata, ParseContext parseContext) {
        if (!str.contains("\u0000")) {
            if (!str.toLowerCase(Locale.US).trim().startsWith("file:")) {
                return TikaInputStream.get(new URL(str), metadata);
            }
            throw new IllegalArgumentException("The UrlFetcher does not fetch from file shares; please use the FileSystemFetcher");
        }
        throw new IllegalArgumentException("URL must not contain \u0000. Please review the life decisions that led you to requesting a URL with this character in it.");
    }
}
