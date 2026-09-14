package com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UnpairedTags.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/UnpairedTags;", JsonProperty.USE_DEFAULT_NAME, "tagName", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;ILjava/lang/String;)V", "getTagName", "()Ljava/lang/String;", "AREA", "BASE", "BR", "COL", "COMMAND", "EMBED", "HR", "IMG", "INPUT", "KEYGEN", "LINK", "META", "PARAM", "SOURCE", "TRACK", "WBR", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UnpairedTags {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UnpairedTags[] $VALUES;
    public static final UnpairedTags AREA = new UnpairedTags("AREA", 0, "area");
    public static final UnpairedTags BASE = new UnpairedTags("BASE", 1, "base");
    public static final UnpairedTags BR = new UnpairedTags("BR", 2, "br");
    public static final UnpairedTags COL = new UnpairedTags("COL", 3, "col");
    public static final UnpairedTags COMMAND = new UnpairedTags("COMMAND", 4, "command");
    public static final UnpairedTags EMBED = new UnpairedTags("EMBED", 5, "embed");
    public static final UnpairedTags HR = new UnpairedTags("HR", 6, "hr");
    public static final UnpairedTags IMG = new UnpairedTags("IMG", 7, "img");
    public static final UnpairedTags INPUT = new UnpairedTags("INPUT", 8, "input");
    public static final UnpairedTags KEYGEN = new UnpairedTags("KEYGEN", 9, "keygen");
    public static final UnpairedTags LINK = new UnpairedTags("LINK", 10, "link");
    public static final UnpairedTags META = new UnpairedTags("META", 11, "meta");
    public static final UnpairedTags PARAM = new UnpairedTags("PARAM", 12, "param");
    public static final UnpairedTags SOURCE = new UnpairedTags("SOURCE", 13, "source");
    public static final UnpairedTags TRACK = new UnpairedTags("TRACK", 14, "track");
    public static final UnpairedTags WBR = new UnpairedTags("WBR", 15, "wbr");
    private final String tagName;

    private static final /* synthetic */ UnpairedTags[] $values() {
        return new UnpairedTags[]{AREA, BASE, BR, COL, COMMAND, EMBED, HR, IMG, INPUT, KEYGEN, LINK, META, PARAM, SOURCE, TRACK, WBR};
    }

    public static EnumEntries<UnpairedTags> getEntries() {
        return $ENTRIES;
    }

    public static UnpairedTags valueOf(String str) {
        return (UnpairedTags) Enum.valueOf(UnpairedTags.class, str);
    }

    public static UnpairedTags[] values() {
        return (UnpairedTags[]) $VALUES.clone();
    }

    private UnpairedTags(String str, int i, String str2) {
        this.tagName = str2;
    }

    public final String getTagName() {
        return this.tagName;
    }

    static {
        UnpairedTags[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
