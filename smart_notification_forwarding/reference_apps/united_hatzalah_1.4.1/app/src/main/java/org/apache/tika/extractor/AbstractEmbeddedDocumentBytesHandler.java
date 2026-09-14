package org.apache.tika.extractor;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.tika.io.FilenameUtils;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.pipes.extractor.EmbeddedDocumentBytesConfig;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public abstract class AbstractEmbeddedDocumentBytesHandler implements EmbeddedDocumentBytesHandler {
    List<Integer> ids = new ArrayList();

    @Override // org.apache.tika.extractor.EmbeddedDocumentBytesHandler
    public void add(int i, Metadata metadata, InputStream inputStream) {
        this.ids.add(Integer.valueOf(i));
    }

    public String getEmitKey(String str, int i, EmbeddedDocumentBytesConfig embeddedDocumentBytesConfig, Metadata metadata) {
        String num;
        if (embeddedDocumentBytesConfig.getZeroPadName() > 0) {
            num = StringUtils.leftPad(Integer.toString(i), embeddedDocumentBytesConfig.getZeroPadName(), "0");
        } else {
            num = Integer.toString(i);
        }
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isBlank(embeddedDocumentBytesConfig.getEmitKeyBase())) {
            sb.append(str);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(FilenameUtils.getName(str));
        } else {
            sb.append(embeddedDocumentBytesConfig.getEmitKeyBase());
        }
        sb.append(embeddedDocumentBytesConfig.getEmbeddedIdPrefix());
        sb.append(num);
        if (embeddedDocumentBytesConfig.getSuffixStrategy().equals(EmbeddedDocumentBytesConfig.SUFFIX_STRATEGY.EXISTING)) {
            sb.append(FilenameUtils.getSuffixFromPath(metadata.get(TikaCoreProperties.RESOURCE_NAME_KEY)).toLowerCase(Locale.US));
        }
        return sb.toString();
    }

    @Override // org.apache.tika.extractor.EmbeddedDocumentBytesHandler
    public List<Integer> getIds() {
        return this.ids;
    }
}
