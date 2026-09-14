package org.apache.tika.metadata.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.tika.config.Field;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

/* loaded from: classes.dex */
public class ClearByMimeMetadataFilter extends MetadataFilter {
    private final Set<String> mimes;

    public ClearByMimeMetadataFilter() {
        this(new HashSet());
    }

    @Override // org.apache.tika.metadata.filter.MetadataFilter
    public void filter(Metadata metadata) {
        String str = metadata.get(HttpHeaders.CONTENT_TYPE);
        if (str != null) {
            MediaType parse = MediaType.parse(str);
            if (parse != null) {
                str = parse.getBaseType().toString();
            }
            if (this.mimes.contains(str)) {
                for (String str2 : metadata.names()) {
                    metadata.remove(str2);
                }
            }
        }
    }

    public List<String> getMimes() {
        return new ArrayList(this.mimes);
    }

    @Field
    public void setMimes(List<String> list) {
        this.mimes.addAll(list);
    }

    public ClearByMimeMetadataFilter(Set<String> set) {
        this.mimes = set;
    }
}
