package org.apache.tika.metadata.writefilter;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.tika.metadata.AccessPermissions;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class StandardWriteFilter implements MetadataWriteFilter, Serializable {
    public static final Set<String> ALWAYS_ADD_FIELDS;
    public static final Set<String> ALWAYS_SET_FIELDS;
    private static final String METADATA_TRUNCATED_KEY;
    private static final String TIKA_CONTENT_KEY;
    private static final String[] TRUE;
    private final Set<String> excludeFields;
    private final boolean includeEmpty;
    private final Set<String> includeFields;
    private final int maxFieldSize;
    private final int maxKeySize;
    private final int maxTotalEstimatedSize;
    private final int maxValuesPerField;
    private final int minimumMaxFieldSizeInAlwaysFields = 300;
    private Map<String, Integer> fieldSizes = new HashMap();
    int estimatedSize = 0;

    /* loaded from: classes.dex */
    public static class StringSizePair {
        final int size;
        final String string;
        final boolean truncated;

        public StringSizePair(String str, int i, boolean z3) {
            this.string = str;
            this.size = i;
            this.truncated = z3;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        ALWAYS_SET_FIELDS = hashSet;
        HashSet hashSet2 = new HashSet();
        ALWAYS_ADD_FIELDS = hashSet2;
        hashSet.add(HttpHeaders.CONTENT_LENGTH);
        hashSet.add(HttpHeaders.CONTENT_TYPE);
        hashSet.add(HttpHeaders.CONTENT_ENCODING);
        hashSet.add(TikaCoreProperties.CONTENT_TYPE_USER_OVERRIDE.getName());
        hashSet.add(TikaCoreProperties.CONTENT_TYPE_PARSER_OVERRIDE.getName());
        hashSet.add(TikaCoreProperties.CONTENT_TYPE_HINT.getName());
        Property property = TikaCoreProperties.TIKA_CONTENT;
        hashSet.add(property.getName());
        hashSet.add(TikaCoreProperties.RESOURCE_NAME_KEY);
        hashSet.add(AccessPermissions.EXTRACT_CONTENT.getName());
        hashSet.add(AccessPermissions.EXTRACT_FOR_ACCESSIBILITY.getName());
        hashSet.add(HttpHeaders.CONTENT_DISPOSITION);
        hashSet.add(TikaCoreProperties.CONTAINER_EXCEPTION.getName());
        hashSet.add(TikaCoreProperties.EMBEDDED_EXCEPTION.getName());
        hashSet2.add(TikaCoreProperties.TIKA_PARSED_BY.getName());
        METADATA_TRUNCATED_KEY = TikaCoreProperties.TRUNCATED_METADATA.getName();
        TIKA_CONTENT_KEY = property.getName();
        TRUE = new String[]{"true"};
    }

    public StandardWriteFilter(int i, int i3, int i4, int i5, Set<String> set, Set<String> set2, boolean z3) {
        this.maxKeySize = i;
        this.maxFieldSize = i3;
        this.maxTotalEstimatedSize = i4;
        this.maxValuesPerField = i5;
        this.includeFields = set;
        this.excludeFields = set2;
        this.includeEmpty = z3;
    }

    private void addAlwaysInclude(String str, String str2, Map<String, String[]> map) {
        int estimateSize;
        if (TIKA_CONTENT_KEY.equals(str)) {
            map.put(str, new String[]{str2});
            return;
        }
        if (!map.containsKey(str)) {
            setAlwaysInclude(str, str2, map);
            return;
        }
        int estimateSize2 = estimateSize(str2);
        int max = Math.max(300, this.maxFieldSize);
        if (estimateSize2 > max) {
            str2 = truncate(str2, max, map);
            estimateSize2 = estimateSize(str2);
        }
        if (map.containsKey(str)) {
            estimateSize = 0;
        } else {
            estimateSize = estimateSize(str);
        }
        this.estimatedSize += estimateSize + estimateSize2;
        map.put(str, appendValue(map.get(str), str2));
    }

    private String[] appendValue(String[] strArr, String str) {
        if (str == null) {
            return strArr;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static int estimateSize(String str) {
        return str.length() * 2;
    }

    private StringSizePair filterKey(String str, String str2, Map<String, String[]> map) {
        int estimateSize = estimateSize(str);
        int i = this.maxKeySize;
        if (estimateSize <= i) {
            return new StringSizePair(str, estimateSize, false);
        }
        String truncate = truncate(str, i, map);
        return new StringSizePair(truncate, estimateSize(truncate), true);
    }

    private boolean include(String str, String str2) {
        if (includeField(str) && includeValue(str2)) {
            return true;
        }
        return false;
    }

    private boolean includeField(String str) {
        if (ALWAYS_SET_FIELDS.contains(str)) {
            return true;
        }
        if (this.excludeFields.contains(str)) {
            return false;
        }
        if (this.includeFields.isEmpty() || this.includeFields.contains(str)) {
            return true;
        }
        return false;
    }

    private boolean includeValue(String str) {
        if (this.includeEmpty || !StringUtils.isBlank(str)) {
            return true;
        }
        return false;
    }

    private int maxAllowedToAdd(StringSizePair stringSizePair) {
        int intValue;
        Integer num = this.fieldSizes.get(stringSizePair.string);
        int i = 0;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        int i3 = this.maxFieldSize - intValue;
        int i4 = (this.maxTotalEstimatedSize - this.estimatedSize) - 1;
        if (num == null) {
            i = stringSizePair.size;
        }
        return Math.min(i3, i4 - i);
    }

    private int maxAllowedToSet(StringSizePair stringSizePair) {
        int intValue;
        Integer num = this.fieldSizes.get(stringSizePair.string);
        int i = 0;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        int i3 = (this.maxTotalEstimatedSize - this.estimatedSize) + intValue;
        if (num == null) {
            i = stringSizePair.size;
        }
        return Math.min(this.maxFieldSize, i3 - i);
    }

    private void setAlwaysInclude(String str, String str2, Map<String, String[]> map) {
        int estimateSize;
        if (TIKA_CONTENT_KEY.equals(str)) {
            map.put(str, new String[]{str2});
            return;
        }
        int estimateSize2 = estimateSize(str2);
        int max = Math.max(300, this.maxFieldSize);
        if (estimateSize2 > max) {
            str2 = truncate(str2, max, map);
            estimateSize2 = estimateSize(str2);
        }
        if (map.containsKey(str)) {
            estimateSize = 0;
        } else {
            estimateSize = estimateSize(str);
        }
        int i = estimateSize + estimateSize2;
        if (map.containsKey(str)) {
            String[] strArr = map.get(str);
            if (strArr.length > 0) {
                i -= estimateSize(strArr[0]);
            }
        }
        this.estimatedSize += i;
        map.put(str, new String[]{str2});
    }

    private void setFilterKey(StringSizePair stringSizePair, String str, Map<String, String[]> map) {
        int intValue;
        if (!map.containsKey(stringSizePair.string) && stringSizePair.size + this.estimatedSize > this.maxTotalEstimatedSize) {
            setTruncated(map);
            return;
        }
        Integer num = this.fieldSizes.get(stringSizePair.string);
        int i = 0;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        int maxAllowedToSet = maxAllowedToSet(stringSizePair);
        if (maxAllowedToSet <= 0) {
            setTruncated(map);
            return;
        }
        int estimateSize = estimateSize(str);
        if (estimateSize > maxAllowedToSet && (estimateSize = estimateSize((str = truncate(str, maxAllowedToSet, map)))) == 0) {
            return;
        }
        if (num == null) {
            i = stringSizePair.size;
        }
        this.estimatedSize += (estimateSize - intValue) + i;
        this.fieldSizes.put(stringSizePair.string, Integer.valueOf(estimateSize));
        map.put(stringSizePair.string, new String[]{str});
    }

    private void setTruncated(Map<String, String[]> map) {
        map.put(METADATA_TRUNCATED_KEY, TRUE);
    }

    private String truncate(String str, int i, Map<String, String[]> map) {
        setTruncated(map);
        Charset charset = StandardCharsets.UTF_16BE;
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(charset), 0, i);
        CharBuffer allocate = CharBuffer.allocate(i);
        CharsetDecoder newDecoder = charset.newDecoder();
        newDecoder.onMalformedInput(CodingErrorAction.IGNORE);
        newDecoder.decode(wrap, allocate, true);
        newDecoder.flush(allocate);
        return new String(allocate.array(), 0, allocate.position());
    }

    @Override // org.apache.tika.metadata.writefilter.MetadataWriteFilter
    public void add(String str, String str2, Map<String, String[]> map) {
        int intValue;
        int i;
        if (include(str, str2)) {
            if (ALWAYS_SET_FIELDS.contains(str)) {
                setAlwaysInclude(str, str2, map);
                return;
            }
            if (ALWAYS_ADD_FIELDS.contains(str)) {
                addAlwaysInclude(str, str2, map);
                return;
            }
            StringSizePair filterKey = filterKey(str, str2, map);
            if (!map.containsKey(filterKey.string)) {
                setFilterKey(filterKey, str2, map);
                return;
            }
            String[] strArr = map.get(filterKey.string);
            if (strArr != null && strArr.length >= this.maxValuesPerField) {
                setTruncated(map);
                return;
            }
            Integer num = this.fieldSizes.get(filterKey.string);
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            int maxAllowedToAdd = maxAllowedToAdd(filterKey);
            if (maxAllowedToAdd <= 0) {
                setTruncated(map);
                return;
            }
            int estimateSize = estimateSize(str2);
            if (estimateSize > maxAllowedToAdd && (estimateSize = estimateSize((str2 = truncate(str2, maxAllowedToAdd, map)))) == 0) {
                return;
            }
            if (num == null) {
                i = filterKey.size + estimateSize;
            } else {
                i = estimateSize;
            }
            this.estimatedSize += i;
            this.fieldSizes.put(filterKey.string, Integer.valueOf(estimateSize + intValue));
            String str3 = filterKey.string;
            map.put(str3, appendValue(map.get(str3), str2));
        }
    }

    @Override // org.apache.tika.metadata.writefilter.MetadataWriteFilter
    public void filterExisting(Map<String, String[]> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (includeField(key)) {
                for (String str : value) {
                    if (include(key, str)) {
                        add(key, str, hashMap);
                    }
                }
            }
        }
        map.clear();
        map.putAll(hashMap);
    }

    @Override // org.apache.tika.metadata.writefilter.MetadataWriteFilter
    public void set(String str, String str2, Map<String, String[]> map) {
        if (!include(str, str2)) {
            return;
        }
        if (!ALWAYS_SET_FIELDS.contains(str) && !ALWAYS_ADD_FIELDS.contains(str)) {
            setFilterKey(filterKey(str, str2, map), str2, map);
        } else {
            setAlwaysInclude(str, str2, map);
        }
    }
}
