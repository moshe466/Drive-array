package com.samsung.sr.nmt.t2t.translator.core.pipeline.spec;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Modes.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/Modes;", JsonProperty.USE_DEFAULT_NAME, "mode", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;ILjava/lang/String;)V", "getMode", "()Ljava/lang/String;", "PLAIN", "TAGGED", "STREAM", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Modes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Modes[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<String> availableModes;
    private final String mode;
    public static final Modes PLAIN = new Modes("PLAIN", 0, "plain");
    public static final Modes TAGGED = new Modes("TAGGED", 1, "tagged");
    public static final Modes STREAM = new Modes("STREAM", 2, "stream");

    private static final /* synthetic */ Modes[] $values() {
        return new Modes[]{PLAIN, TAGGED, STREAM};
    }

    public static EnumEntries<Modes> getEntries() {
        return $ENTRIES;
    }

    public static Modes valueOf(String str) {
        return (Modes) Enum.valueOf(Modes.class, str);
    }

    public static Modes[] values() {
        return (Modes[]) $VALUES.clone();
    }

    private Modes(String str, int i, String str2) {
        this.mode = str2;
    }

    public final String getMode() {
        return this.mode;
    }

    static {
        Modes[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        Modes[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (Modes modes : values) {
            arrayList.add(modes.mode);
        }
        availableModes = CollectionsKt.toSet(arrayList);
    }

    /* compiled from: Modes.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/Modes$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "availableModes", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "testMode", "mode", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String testMode(String mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            return Modes.availableModes.contains(mode) ? mode : "plain";
        }
    }
}
