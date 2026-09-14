package com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RejectionSymbols.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/RejectionSymbols;", JsonProperty.USE_DEFAULT_NAME, "regex", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;ILjava/lang/String;)V", "getRegex", "()Ljava/lang/String;", "DIGIT", "PUNCTUATION", "SPACE", "CURRENCY", "TAMIL_SIGN_KAACU", "TAMIL_SIGN_PANAM", "TAMIL_SIGN_PON", "TAMIL_SIGN_VARAAKAN", "WANCHO_NGUN_SIGN", "INDIC_SIYAQ_RUPEE_MARK", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RejectionSymbols {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RejectionSymbols[] $VALUES;
    private final String regex;
    public static final RejectionSymbols DIGIT = new RejectionSymbols("DIGIT", 0, "[0-9]");
    public static final RejectionSymbols PUNCTUATION = new RejectionSymbols("PUNCTUATION", 1, "[!\\\"#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]");
    public static final RejectionSymbols SPACE = new RejectionSymbols("SPACE", 2, " ");
    public static final RejectionSymbols CURRENCY = new RejectionSymbols("CURRENCY", 3, "[¢£¤¥֏؋߾߿৲৳৻૱௹฿៛₠₡₢₣₤₥₦₧₨₩₪₫€₭₮₯₰₱₲₳₴₵₶₷₸₹₺₻₼₽₾₿\u20c0꠸﷼﹩＄￠￡￥￦]");
    public static final RejectionSymbols TAMIL_SIGN_KAACU = new RejectionSymbols("TAMIL_SIGN_KAACU", 4, "𑿝");
    public static final RejectionSymbols TAMIL_SIGN_PANAM = new RejectionSymbols("TAMIL_SIGN_PANAM", 5, "𑿞");
    public static final RejectionSymbols TAMIL_SIGN_PON = new RejectionSymbols("TAMIL_SIGN_PON", 6, "𑿟");
    public static final RejectionSymbols TAMIL_SIGN_VARAAKAN = new RejectionSymbols("TAMIL_SIGN_VARAAKAN", 7, "𑿠");
    public static final RejectionSymbols WANCHO_NGUN_SIGN = new RejectionSymbols("WANCHO_NGUN_SIGN", 8, "𞋿");
    public static final RejectionSymbols INDIC_SIYAQ_RUPEE_MARK = new RejectionSymbols("INDIC_SIYAQ_RUPEE_MARK", 9, "𞲰");

    private static final /* synthetic */ RejectionSymbols[] $values() {
        return new RejectionSymbols[]{DIGIT, PUNCTUATION, SPACE, CURRENCY, TAMIL_SIGN_KAACU, TAMIL_SIGN_PANAM, TAMIL_SIGN_PON, TAMIL_SIGN_VARAAKAN, WANCHO_NGUN_SIGN, INDIC_SIYAQ_RUPEE_MARK};
    }

    public static EnumEntries<RejectionSymbols> getEntries() {
        return $ENTRIES;
    }

    public static RejectionSymbols valueOf(String str) {
        return (RejectionSymbols) Enum.valueOf(RejectionSymbols.class, str);
    }

    public static RejectionSymbols[] values() {
        return (RejectionSymbols[]) $VALUES.clone();
    }

    private RejectionSymbols(String str, int i, String str2) {
        this.regex = str2;
    }

    public final String getRegex() {
        return this.regex;
    }

    static {
        RejectionSymbols[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
