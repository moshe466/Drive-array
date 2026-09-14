package org.apache.tika.parser.external;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.parser.CompositeParser;
import org.apache.tika.parser.Parser;

/* loaded from: classes.dex */
public class ExternalParsersFactory {
    public static void attachExternalParsers(TikaConfig tikaConfig) {
        attachExternalParsers(create(), tikaConfig);
    }

    public static List<ExternalParser> create() {
        return create(new ServiceLoader());
    }

    public static void attachExternalParsers(List<ExternalParser> list, TikaConfig tikaConfig) {
        Parser parser = tikaConfig.getParser();
        if (parser instanceof CompositeParser) {
            ((CompositeParser) parser).getParsers();
        }
    }

    public static List<ExternalParser> create(ServiceLoader serviceLoader) {
        return create("tika-external-parsers.xml", serviceLoader);
    }

    public static List<ExternalParser> create(String str, ServiceLoader serviceLoader) {
        return create((URL[]) Collections.list(serviceLoader.findServiceResources(ExternalParsersFactory.class.getPackage().getName().replace('.', '/') + RemoteSettings.FORWARD_SLASH_STRING + str)).toArray(new URL[0]));
    }

    public static List<ExternalParser> create(URL... urlArr) {
        ArrayList arrayList = new ArrayList();
        for (URL url : urlArr) {
            InputStream openStream = url.openStream();
            try {
                arrayList.addAll(ExternalParsersConfigReader.read(openStream));
                if (openStream != null) {
                    openStream.close();
                }
            } catch (Throwable th) {
                if (openStream != null) {
                    try {
                        openStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return arrayList;
    }
}
