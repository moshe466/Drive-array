package org.apache.tika.mime;

import com.google.android.gms.common.api.Api;
import e0.a;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Patterns implements Serializable {
    private static final long serialVersionUID = -5778015347278111140L;
    private final MediaTypeRegistry registry;
    private final Map<String, MimeType> names = new HashMap();
    private final Map<String, MimeType> extensions = new HashMap();
    private final SortedMap<String, MimeType> globs = new TreeMap(new LengthComparator(0));
    private int minExtensionLength = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    private int maxExtensionLength = 0;

    /* loaded from: classes.dex */
    public static final class LengthComparator implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 8468289702915532359L;

        public /* synthetic */ LengthComparator(int i) {
            this();
        }

        private LengthComparator() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            int length = str2.length() - str.length();
            return length == 0 ? str.compareTo(str2) : length;
        }
    }

    public Patterns(MediaTypeRegistry mediaTypeRegistry) {
        this.registry = mediaTypeRegistry;
    }

    private void addExtension(String str, MimeType mimeType) {
        MimeType mimeType2 = this.extensions.get(str);
        if (mimeType2 != null && !this.registry.isSpecializationOf(mimeType2.getType(), mimeType.getType())) {
            if (mimeType2 != mimeType && !this.registry.isSpecializationOf(mimeType.getType(), mimeType2.getType())) {
                throw new MimeTypeException(a.d("Conflicting extension pattern: ", str));
            }
        } else {
            this.extensions.put(str, mimeType);
            int length = str.length();
            this.minExtensionLength = Math.min(this.minExtensionLength, length);
            this.maxExtensionLength = Math.max(this.maxExtensionLength, length);
        }
    }

    private void addGlob(String str, MimeType mimeType) {
        MimeType mimeType2 = this.globs.get(str);
        if (mimeType2 != null && !this.registry.isSpecializationOf(mimeType2.getType(), mimeType.getType())) {
            if (mimeType2 != mimeType && !this.registry.isSpecializationOf(mimeType.getType(), mimeType2.getType())) {
                throw new MimeTypeException(a.d("Conflicting glob pattern: ", str));
            }
            return;
        }
        this.globs.put(str, mimeType);
    }

    private void addName(String str, MimeType mimeType) {
        MimeType mimeType2 = this.names.get(str);
        if (mimeType2 != null && !this.registry.isSpecializationOf(mimeType2.getType(), mimeType.getType())) {
            if (mimeType2 != mimeType && !this.registry.isSpecializationOf(mimeType.getType(), mimeType2.getType())) {
                throw new MimeTypeException(a.d("Conflicting name pattern: ", str));
            }
            return;
        }
        this.names.put(str, mimeType);
    }

    private String compile(String str) {
        StringBuilder sb = new StringBuilder("\\A");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '?') {
                sb.append('.');
            } else if (charAt == '*') {
                sb.append(".*");
            } else if ("\\[]^.-$+(){}|".indexOf(charAt) != -1) {
                sb.append('\\');
                sb.append(charAt);
            } else {
                sb.append(charAt);
            }
        }
        sb.append("\\z");
        return sb.toString();
    }

    public void add(String str, MimeType mimeType) {
        add(str, false, mimeType);
    }

    public MimeType matches(String str) {
        if (str != null) {
            if (this.names.containsKey(str)) {
                return this.names.get(str);
            }
            for (int min = Math.min(this.maxExtensionLength, str.length()); min >= this.minExtensionLength; min--) {
                String substring = str.substring(str.length() - min);
                if (this.extensions.containsKey(substring)) {
                    return this.extensions.get(substring);
                }
            }
            for (Map.Entry<String, MimeType> entry : this.globs.entrySet()) {
                if (str.matches(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Name is missing");
    }

    public void add(String str, boolean z3, MimeType mimeType) {
        if (str == null || mimeType == null) {
            throw new IllegalArgumentException("Pattern and/or mime type is missing");
        }
        if (z3) {
            addGlob(str, mimeType);
            return;
        }
        if (str.indexOf(42) == -1 && str.indexOf(63) == -1 && str.indexOf(91) == -1) {
            addName(str, mimeType);
            return;
        }
        if (str.startsWith("*") && str.indexOf(42, 1) == -1 && str.indexOf(63) == -1 && str.indexOf(91) == -1) {
            String substring = str.substring(1);
            addExtension(substring, mimeType);
            mimeType.addExtension(substring);
            return;
        }
        addGlob(compile(str), mimeType);
    }
}
