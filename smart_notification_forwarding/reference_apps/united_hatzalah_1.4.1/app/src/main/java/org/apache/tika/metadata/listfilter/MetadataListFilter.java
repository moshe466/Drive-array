package org.apache.tika.metadata.listfilter;

import java.io.Serializable;
import java.util.List;
import org.apache.tika.config.ConfigBase;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.metadata.Metadata;
import org.w3c.dom.Element;

/* loaded from: classes.dex */
public abstract class MetadataListFilter extends ConfigBase implements Serializable {
    public static MetadataListFilter load(Element element, boolean z3) {
        try {
            return (MetadataListFilter) ConfigBase.buildComposite("metadataListFilters", CompositeMetadataListFilter.class, "metadataListFilter", MetadataListFilter.class, element);
        } catch (TikaConfigException e4) {
            if (z3 && e4.getMessage().contains("could not find metadataListFilters")) {
                return new NoOpListFilter();
            }
            throw e4;
        }
    }

    public abstract List<Metadata> filter(List<Metadata> list);
}
