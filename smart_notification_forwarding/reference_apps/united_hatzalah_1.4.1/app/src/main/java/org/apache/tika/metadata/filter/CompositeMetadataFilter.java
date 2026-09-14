package org.apache.tika.metadata.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.tika.metadata.Metadata;

/* loaded from: classes.dex */
public class CompositeMetadataFilter extends MetadataFilter {
    private List<MetadataFilter> filters;

    public CompositeMetadataFilter() {
        this.filters = new ArrayList();
    }

    @Override // org.apache.tika.metadata.filter.MetadataFilter
    public void filter(Metadata metadata) {
        Iterator<MetadataFilter> it = this.filters.iterator();
        while (it.hasNext()) {
            it.next().filter(metadata);
        }
    }

    public List<MetadataFilter> getFilters() {
        return this.filters;
    }

    public void setFilters(List<MetadataFilter> list) {
        this.filters.clear();
        this.filters.addAll(list);
    }

    public String toString() {
        return "CompositeMetadataFilter{filters=" + this.filters + "}";
    }

    public CompositeMetadataFilter(List<MetadataFilter> list) {
        this.filters = list;
    }
}
