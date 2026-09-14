package org.apache.tika.metadata.filter;

import org.apache.tika.config.Field;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class GeoPointMetadataFilter extends MetadataFilter {
    String geoPointFieldName = "location";

    @Override // org.apache.tika.metadata.filter.MetadataFilter
    public void filter(Metadata metadata) {
        String str = metadata.get(TikaCoreProperties.LATITUDE);
        if (!StringUtils.isEmpty(str)) {
            String str2 = metadata.get(TikaCoreProperties.LONGITUDE);
            if (StringUtils.isEmpty(str2)) {
                return;
            }
            metadata.set(this.geoPointFieldName, str + "," + str2);
        }
    }

    public String getGeoPointFieldName() {
        return this.geoPointFieldName;
    }

    @Field
    public void setGeoPointFieldName(String str) {
        this.geoPointFieldName = str;
    }
}
