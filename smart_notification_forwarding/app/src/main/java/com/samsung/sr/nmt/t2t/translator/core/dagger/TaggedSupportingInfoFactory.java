package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaggedSupportingInfoFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TaggedSupportingInfoFactory;", JsonProperty.USE_DEFAULT_NAME, "assetLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;)V", "create", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, "Companion", "TaggedSupportingInfo", "TaggedSupportingInfoDetails", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TaggedSupportingInfoFactory {
    private static final String FILE_NAME = "tagged-supporting-info.yaml";
    private final AssetLoader assetLoader;

    @Inject
    public TaggedSupportingInfoFactory(AssetLoader assetLoader) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        this.assetLoader = assetLoader;
    }

    public final Map<LanguageDirection, String> create() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.registerModule(new KotlinModule.Builder().build());
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        InputStream open = this.assetLoader.open(FILE_NAME);
        try {
            for (TaggedSupportingInfoDetails taggedSupportingInfoDetails : ((TaggedSupportingInfo) objectMapper.readValue(open, TaggedSupportingInfo.class)).getLanguages()) {
                linkedHashMap.put(new LanguageDirection(taggedSupportingInfoDetails.getSrcLang(), taggedSupportingInfoDetails.getTgtLang()), taggedSupportingInfoDetails.getSupportsTaggedFrom());
                linkedHashMap.put(new LanguageDirection(taggedSupportingInfoDetails.getTgtLang(), taggedSupportingInfoDetails.getSrcLang()), taggedSupportingInfoDetails.getSupportsTaggedFrom());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(open, null);
            return linkedHashMap;
        } finally {
        }
    }

    /* compiled from: TaggedSupportingInfoFactory.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TaggedSupportingInfoFactory$TaggedSupportingInfoDetails;", JsonProperty.USE_DEFAULT_NAME, "srcLang", JsonProperty.USE_DEFAULT_NAME, "tgtLang", "supportsTaggedFrom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSrcLang", "()Ljava/lang/String;", "getSupportsTaggedFrom", "getTgtLang", "component1", "component2", "component3", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class TaggedSupportingInfoDetails {
        private final String srcLang;
        private final String supportsTaggedFrom;
        private final String tgtLang;

        public static /* synthetic */ TaggedSupportingInfoDetails copy$default(TaggedSupportingInfoDetails taggedSupportingInfoDetails, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taggedSupportingInfoDetails.srcLang;
            }
            if ((i & 2) != 0) {
                str2 = taggedSupportingInfoDetails.tgtLang;
            }
            if ((i & 4) != 0) {
                str3 = taggedSupportingInfoDetails.supportsTaggedFrom;
            }
            return taggedSupportingInfoDetails.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSrcLang() {
            return this.srcLang;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTgtLang() {
            return this.tgtLang;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSupportsTaggedFrom() {
            return this.supportsTaggedFrom;
        }

        public final TaggedSupportingInfoDetails copy(String srcLang, String tgtLang, String supportsTaggedFrom) {
            Intrinsics.checkNotNullParameter(srcLang, "srcLang");
            Intrinsics.checkNotNullParameter(tgtLang, "tgtLang");
            Intrinsics.checkNotNullParameter(supportsTaggedFrom, "supportsTaggedFrom");
            return new TaggedSupportingInfoDetails(srcLang, tgtLang, supportsTaggedFrom);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaggedSupportingInfoDetails)) {
                return false;
            }
            TaggedSupportingInfoDetails taggedSupportingInfoDetails = (TaggedSupportingInfoDetails) other;
            return Intrinsics.areEqual(this.srcLang, taggedSupportingInfoDetails.srcLang) && Intrinsics.areEqual(this.tgtLang, taggedSupportingInfoDetails.tgtLang) && Intrinsics.areEqual(this.supportsTaggedFrom, taggedSupportingInfoDetails.supportsTaggedFrom);
        }

        public int hashCode() {
            return (((this.srcLang.hashCode() * 31) + this.tgtLang.hashCode()) * 31) + this.supportsTaggedFrom.hashCode();
        }

        public String toString() {
            return "TaggedSupportingInfoDetails(srcLang=" + this.srcLang + ", tgtLang=" + this.tgtLang + ", supportsTaggedFrom=" + this.supportsTaggedFrom + ")";
        }

        public TaggedSupportingInfoDetails(String srcLang, String tgtLang, String supportsTaggedFrom) {
            Intrinsics.checkNotNullParameter(srcLang, "srcLang");
            Intrinsics.checkNotNullParameter(tgtLang, "tgtLang");
            Intrinsics.checkNotNullParameter(supportsTaggedFrom, "supportsTaggedFrom");
            this.srcLang = srcLang;
            this.tgtLang = tgtLang;
            this.supportsTaggedFrom = supportsTaggedFrom;
        }

        public final String getSrcLang() {
            return this.srcLang;
        }

        public final String getTgtLang() {
            return this.tgtLang;
        }

        public final String getSupportsTaggedFrom() {
            return this.supportsTaggedFrom;
        }
    }

    /* compiled from: TaggedSupportingInfoFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TaggedSupportingInfoFactory$TaggedSupportingInfo;", JsonProperty.USE_DEFAULT_NAME, "languages", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TaggedSupportingInfoFactory$TaggedSupportingInfoDetails;", "(Ljava/util/List;)V", "getLanguages", "()Ljava/util/List;", "component1", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class TaggedSupportingInfo {
        private final List<TaggedSupportingInfoDetails> languages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TaggedSupportingInfo copy$default(TaggedSupportingInfo taggedSupportingInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = taggedSupportingInfo.languages;
            }
            return taggedSupportingInfo.copy(list);
        }

        public final List<TaggedSupportingInfoDetails> component1() {
            return this.languages;
        }

        public final TaggedSupportingInfo copy(List<TaggedSupportingInfoDetails> languages) {
            Intrinsics.checkNotNullParameter(languages, "languages");
            return new TaggedSupportingInfo(languages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TaggedSupportingInfo) && Intrinsics.areEqual(this.languages, ((TaggedSupportingInfo) other).languages);
        }

        public int hashCode() {
            return this.languages.hashCode();
        }

        public String toString() {
            return "TaggedSupportingInfo(languages=" + this.languages + ")";
        }

        public TaggedSupportingInfo(List<TaggedSupportingInfoDetails> languages) {
            Intrinsics.checkNotNullParameter(languages, "languages");
            this.languages = languages;
        }

        public final List<TaggedSupportingInfoDetails> getLanguages() {
            return this.languages;
        }
    }
}
