package org.apache.tika.metadata.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;
import n3.b;
import n3.d;
import org.apache.tika.config.Field;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;

/* loaded from: classes.dex */
public class DateNormalizingMetadataFilter extends MetadataFilter {
    private TimeZone defaultTimeZone = UTC;
    private static TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final b LOGGER = d.b(DateNormalizingMetadataFilter.class);

    @Override // org.apache.tika.metadata.filter.MetadataFilter
    public void filter(Metadata metadata) {
        SimpleDateFormat simpleDateFormat = null;
        SimpleDateFormat simpleDateFormat2 = null;
        for (String str : metadata.names()) {
            Property property = Property.get(str);
            if (property != null && property.getValueType().equals(Property.ValueType.DATE)) {
                String str2 = metadata.get(property);
                if (!str2.endsWith("Z")) {
                    if (simpleDateFormat == null) {
                        Locale locale = Locale.US;
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale);
                        simpleDateFormat.setTimeZone(this.defaultTimeZone);
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", locale);
                        simpleDateFormat3.setTimeZone(UTC);
                        simpleDateFormat2 = simpleDateFormat3;
                    }
                    try {
                        metadata.set(property, simpleDateFormat2.format(simpleDateFormat.parse(str2)));
                    } catch (ParseException unused) {
                        LOGGER.u("Couldn't convert date to default time zone: >" + str2 + "<");
                    }
                }
            }
        }
    }

    public String getDefaultTimeZone() {
        ZoneId zoneId;
        String zoneId2;
        zoneId = this.defaultTimeZone.toZoneId();
        zoneId2 = zoneId.toString();
        return zoneId2;
    }

    @Field
    public void setDefaultTimeZone(String str) {
        ZoneId of;
        TimeZone timeZone;
        of = ZoneId.of(str);
        timeZone = TimeZone.getTimeZone(of);
        this.defaultTimeZone = timeZone;
    }
}
