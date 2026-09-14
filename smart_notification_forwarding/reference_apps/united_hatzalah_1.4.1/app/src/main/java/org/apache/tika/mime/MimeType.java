package org.apache.tika.mime;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class MimeType implements Comparable<MimeType>, Serializable {
    private static final long serialVersionUID = 4357830439860729201L;
    private final MediaType type;
    private final int minLength = 0;
    private String acronym = "";
    private String uti = "";
    private List<URI> links = Collections.EMPTY_LIST;
    private String description = "";
    private List<Magic> magics = null;
    private List<RootXML> rootXML = null;
    private List<String> extensions = null;
    private boolean isInterpreted = false;

    /* loaded from: classes.dex */
    public static class RootXML implements Serializable {
        private static final long serialVersionUID = 5140496601491000730L;
        private String localName;
        private String namespaceURI;
        private MimeType type;

        public RootXML(MimeType mimeType, String str, String str2) {
            this.type = null;
            this.namespaceURI = null;
            this.localName = null;
            if (isEmpty(str) && isEmpty(str2)) {
                throw new IllegalArgumentException("Both namespaceURI and localName cannot be empty");
            }
            this.type = mimeType;
            this.namespaceURI = str;
            this.localName = str2;
        }

        private boolean isEmpty(String str) {
            if (str != null && !str.equals("")) {
                return false;
            }
            return true;
        }

        public String getLocalName() {
            return this.localName;
        }

        public String getNameSpaceURI() {
            return this.namespaceURI;
        }

        public MimeType getType() {
            return this.type;
        }

        public boolean matches(String str, String str2) {
            if (!isEmpty(this.namespaceURI)) {
                if (!this.namespaceURI.equals(str)) {
                    return false;
                }
            } else if (!isEmpty(str)) {
                return false;
            }
            if (!isEmpty(this.localName)) {
                return this.localName.equals(str2);
            }
            return isEmpty(str2);
        }

        public String toString() {
            return this.type + ", " + this.namespaceURI + ", " + this.localName;
        }
    }

    public MimeType(MediaType mediaType) {
        if (mediaType != null) {
            this.type = mediaType;
            return;
        }
        throw new IllegalArgumentException("Media type name is missing");
    }

    public static boolean isValid(String str) {
        if (str != null) {
            boolean z3 = false;
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127 || charAt == '(' || charAt == ')' || charAt == '<' || charAt == '>' || charAt == '@' || charAt == ',' || charAt == ';' || charAt == ':' || charAt == '\\' || charAt == '\"' || charAt == '[' || charAt == ']' || charAt == '?' || charAt == '=') {
                    return false;
                }
                if (charAt == '/') {
                    if (z3 || i == 0 || i + 1 == str.length()) {
                        return false;
                    }
                    z3 = true;
                }
            }
            return z3;
        }
        throw new IllegalArgumentException("Name is missing");
    }

    public void addExtension(String str) {
        List<String> list = this.extensions;
        if (list == null) {
            this.extensions = Collections.singletonList(str);
        } else if (list.size() == 1) {
            this.extensions = new ArrayList(this.extensions);
        }
        if (!this.extensions.contains(str)) {
            this.extensions.add(str);
        }
    }

    public void addLink(URI uri) {
        if (uri != null) {
            ArrayList arrayList = new ArrayList(this.links.size() + 1);
            arrayList.addAll(this.links);
            arrayList.add(uri);
            this.links = Collections.unmodifiableList(arrayList);
            return;
        }
        throw new IllegalArgumentException("Missing Link");
    }

    public void addMagic(Magic magic) {
        if (magic == null) {
            return;
        }
        if (this.magics == null) {
            this.magics = new ArrayList();
        }
        this.magics.add(magic);
    }

    public void addRootXML(String str, String str2) {
        if (this.rootXML == null) {
            this.rootXML = new ArrayList();
        }
        this.rootXML.add(new RootXML(this, str, str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MimeType) {
            return this.type.equals(((MimeType) obj).type);
        }
        return false;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExtension() {
        List<String> list = this.extensions;
        if (list == null) {
            return "";
        }
        return list.get(0);
    }

    public List<String> getExtensions() {
        List<String> list = this.extensions;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.EMPTY_LIST;
    }

    public List<URI> getLinks() {
        return this.links;
    }

    public List<Magic> getMagics() {
        List<Magic> list = this.magics;
        if (list != null) {
            return list;
        }
        return Collections.EMPTY_LIST;
    }

    public int getMinLength() {
        return 0;
    }

    public String getName() {
        return this.type.toString();
    }

    public MediaType getType() {
        return this.type;
    }

    public String getUniformTypeIdentifier() {
        return this.uti;
    }

    public boolean hasMagic() {
        if (this.magics != null) {
            return true;
        }
        return false;
    }

    public boolean hasRootXML() {
        if (this.rootXML != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public boolean isInterpreted() {
        return this.isInterpreted;
    }

    public boolean matches(byte[] bArr) {
        return matchesMagic(bArr);
    }

    public boolean matchesMagic(byte[] bArr) {
        int i = 0;
        while (true) {
            List<Magic> list = this.magics;
            if (list == null || i >= list.size()) {
                break;
            }
            if (this.magics.get(i).eval(bArr)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean matchesXML(String str, String str2) {
        List<RootXML> list = this.rootXML;
        if (list != null) {
            Iterator<RootXML> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().matches(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void setAcronym(String str) {
        if (str != null) {
            this.acronym = str;
            return;
        }
        throw new IllegalArgumentException("Acronym is missing");
    }

    public void setDescription(String str) {
        if (str != null) {
            this.description = str;
            return;
        }
        throw new IllegalArgumentException("Description is missing");
    }

    public void setInterpreted(boolean z3) {
        this.isInterpreted = z3;
    }

    public void setUniformTypeIdentifier(String str) {
        if (str != null) {
            this.uti = str;
            return;
        }
        throw new IllegalArgumentException("Uniform Type Identifier is missing");
    }

    public String toString() {
        return this.type.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(MimeType mimeType) {
        return this.type.compareTo(mimeType.type);
    }
}
