package org.apache.tika.pipes.emitter;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.util.List;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;

/* loaded from: classes.dex */
public class EmitData implements Serializable {
    private static final long serialVersionUID = -3861669115439125268L;
    private final String containerStackTrace;
    private final EmitKey emitKey;
    private final List<Metadata> metadataList;
    private ParseContext parseContext;

    public EmitData(EmitKey emitKey, List<Metadata> list) {
        this(emitKey, list, "");
    }

    private static long estimateSizeInBytes(String str, List<Metadata> list, String str2) {
        long length = (str.length() * 2) + 36 + (str2.length() * 2) + 36;
        for (Metadata metadata : list) {
            for (String str3 : metadata.names()) {
                length += (r5.length() * 2) + 36;
                for (int i = 0; i < metadata.getValues(str3).length; i++) {
                    length += (r5[i].length() * 2) + 36;
                }
            }
        }
        return length;
    }

    public String getContainerStackTrace() {
        return this.containerStackTrace;
    }

    public EmitKey getEmitKey() {
        return this.emitKey;
    }

    public long getEstimatedSizeBytes() {
        return estimateSizeInBytes(getEmitKey().getEmitKey(), getMetadataList(), this.containerStackTrace);
    }

    public List<Metadata> getMetadataList() {
        return this.metadataList;
    }

    public ParseContext getParseContext() {
        return this.parseContext;
    }

    public void setParseContext(ParseContext parseContext) {
        this.parseContext = parseContext;
    }

    public String toString() {
        EmitKey emitKey = this.emitKey;
        List<Metadata> list = this.metadataList;
        String str = this.containerStackTrace;
        StringBuilder sb = new StringBuilder("EmitData{emitKey=");
        sb.append(emitKey);
        sb.append(", metadataList=");
        sb.append(list);
        sb.append(", containerStackTrace='");
        return AbstractC0008a.u(sb, str, "'}");
    }

    public EmitData(EmitKey emitKey, List<Metadata> list, String str) {
        this(emitKey, list, str, new ParseContext());
    }

    public EmitData(EmitKey emitKey, List<Metadata> list, String str, ParseContext parseContext) {
        this.parseContext = null;
        this.emitKey = emitKey;
        this.metadataList = list;
        this.containerStackTrace = str == null ? "" : str;
        this.parseContext = parseContext;
    }
}
