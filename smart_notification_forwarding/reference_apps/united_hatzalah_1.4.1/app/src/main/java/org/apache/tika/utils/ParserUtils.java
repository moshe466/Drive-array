package org.apache.tika.utils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParserDecorator;

/* loaded from: classes.dex */
public class ParserUtils {
    public static final Property EMBEDDED_PARSER = Property.internalText("X-TIKA:EXCEPTION:embedded_parser");

    public static Metadata cloneMetadata(Metadata metadata) {
        Metadata metadata2 = new Metadata();
        for (String str : metadata.names()) {
            if (!metadata.isMultiValued(str)) {
                metadata2.set(str, metadata.get(str));
            } else {
                for (String str2 : metadata.getValues(str)) {
                    metadata2.add(str, str2);
                }
            }
        }
        return metadata2;
    }

    public static InputStream ensureStreamReReadable(InputStream inputStream, TemporaryResources temporaryResources, Metadata metadata) {
        if (inputStream instanceof RereadableInputStream) {
            return inputStream;
        }
        TikaInputStream cast = TikaInputStream.cast(inputStream);
        if (cast == null) {
            cast = TikaInputStream.get(inputStream, temporaryResources, metadata);
        }
        if (cast.getInputStreamFactory() != null) {
            return cast;
        }
        cast.getFile();
        cast.mark(-1);
        return cast;
    }

    public static String getParserClassname(Parser parser) {
        if (parser instanceof ParserDecorator) {
            return ((ParserDecorator) parser).getWrappedParser().getClass().getName();
        }
        return parser.getClass().getName();
    }

    public static void recordParserDetails(Parser parser, Metadata metadata) {
        recordParserDetails(getParserClassname(parser), metadata);
    }

    public static void recordParserFailure(Parser parser, Throwable th, Metadata metadata) {
        metadata.add(TikaCoreProperties.EMBEDDED_EXCEPTION, ExceptionUtils.getStackTrace(th));
        metadata.add(EMBEDDED_PARSER, getParserClassname(parser));
    }

    public static InputStream streamResetForReRead(InputStream inputStream, TemporaryResources temporaryResources) {
        if (inputStream instanceof RereadableInputStream) {
            ((RereadableInputStream) inputStream).rewind();
            return inputStream;
        }
        TikaInputStream tikaInputStream = (TikaInputStream) inputStream;
        if (tikaInputStream.getInputStreamFactory() != null) {
            return TikaInputStream.get(tikaInputStream.getInputStreamFactory(), temporaryResources);
        }
        tikaInputStream.reset();
        tikaInputStream.mark(-1);
        return tikaInputStream;
    }

    public static void recordParserDetails(final String str, Metadata metadata) {
        Property property = TikaCoreProperties.TIKA_PARSED_BY;
        String[] values = metadata.getValues(property);
        if (values != null && values.length != 0) {
            Stream stream = Arrays.stream(values);
            Objects.requireNonNull(str);
            if (stream.noneMatch(new Predicate() { // from class: org.apache.tika.utils.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return str.equals((String) obj);
                }
            })) {
                metadata.add(property, str);
                return;
            }
            return;
        }
        metadata.add(property, str);
    }
}
