package org.apache.tika.extractor;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.tika.config.ServiceLoader;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.utils.ServiceLoaderUtils;

/* loaded from: classes.dex */
public class DefaultEmbeddedStreamTranslator implements EmbeddedStreamTranslator {
    final List<EmbeddedStreamTranslator> translators;

    public DefaultEmbeddedStreamTranslator() {
        this(getDefaultFilters(new ServiceLoader()));
    }

    private static List<EmbeddedStreamTranslator> getDefaultFilters(ServiceLoader serviceLoader) {
        List<EmbeddedStreamTranslator> loadServiceProviders = serviceLoader.loadServiceProviders(EmbeddedStreamTranslator.class);
        ServiceLoaderUtils.sortLoadedClasses(loadServiceProviders);
        return loadServiceProviders;
    }

    @Override // org.apache.tika.extractor.EmbeddedStreamTranslator
    public boolean shouldTranslate(InputStream inputStream, Metadata metadata) {
        Iterator<EmbeddedStreamTranslator> it = this.translators.iterator();
        while (it.hasNext()) {
            if (it.next().shouldTranslate(inputStream, metadata)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.tika.extractor.EmbeddedStreamTranslator
    public InputStream translate(InputStream inputStream, Metadata metadata) {
        Iterator<EmbeddedStreamTranslator> it = this.translators.iterator();
        while (it.hasNext()) {
            InputStream translate = it.next().translate(inputStream, metadata);
            if (translate != null) {
                return translate;
            }
        }
        return inputStream;
    }

    private DefaultEmbeddedStreamTranslator(List<EmbeddedStreamTranslator> list) {
        this.translators = list;
    }
}
