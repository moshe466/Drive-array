package com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PlaceholderSymbols.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/PlaceholderSymbols;", JsonProperty.USE_DEFAULT_NAME, "regex", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;ILjava/lang/String;)V", "getRegex", "()Ljava/lang/String;", "EMAIL", "URL", "PHONE", "PHONE2", "TAG", "KEYBOARD", "FILE_NAME", "WINDOW_PATH", "MATH", "EMPTY_TAGS", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlaceholderSymbols {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlaceholderSymbols[] $VALUES;
    private final String regex;
    public static final PlaceholderSymbols EMAIL = new PlaceholderSymbols("EMAIL", 0, "[a-zA-Z0-9][a-zA-Z0-9_\\-.]+@(?:[a-zA-Z0-9]+\\.)+[a-zA-Z0-9]+");
    public static final PlaceholderSymbols URL = new PlaceholderSymbols("URL", 1, "(?![0-9]{0,2}a\\.m|[0-9]{0,2}p\\.m|[0-9]{2,4}\\.[01]?[0-9]\\.[0123]?[0-9]|[01]?[0-9]\\.[0123]?[0-9]\\.[0-9]{2,4}|[0123]?[0-9]\\.[01]?[0-9]\\.[0-9]{2,4})(((?:https?://)?(?:www\\.)?[-a-zA-Z0-9@:%_+~#=]{1,256}\\.[-a-zA-Z0-9@:%_+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}(?:[-a-zA-Z0-9()@:;%_+.~#?&/=]*[-a-zA-Z0-9@:;%_+~#?&/=]))|((?:https?://)?(?:www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.(?:com|net|org|me)(\\/(?:[-a-zA-Z0-9()@:;%_+.~#?&/=]*[-a-zA-Z0-9@:;%_+~#?&/=]))*)|((?:https?://)(?:www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}(?:[-a-zA-Z0-9()@:;%_+.~#?&/=]*[-a-zA-Z0-9@:;%_+~#?&/=]))|((?:www\\.)[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}(?:[-a-zA-Z0-9()@:;%_+.~#?&/=]*[-a-zA-Z0-9@:;%_+~#?&/=])))");
    public static final PlaceholderSymbols PHONE = new PlaceholderSymbols("PHONE", 2, "(?![0-9]{2,4}\\-[0123]?[0-9]\\-[01]?[0-9]|[01]?[0-9]\\-[0123]?[0-9]\\-[0-9]{2,4}|[0123]?[0-9]\\-[01]?[0-9]\\-[0-9]{2,4})((?:\\+[0-9]{1,3}\\-)?(?:(?:[0-9]+\\-){2,}[0-9]+|(?:(?:[0-9]{3,}\\-)+[0-9]+)))");
    public static final PlaceholderSymbols PHONE2 = new PlaceholderSymbols("PHONE2", 3, "\\(\\+?[0-9]{1,3}\\)\\s(?:[0-9]+\\-)+[0-9]+");
    public static final PlaceholderSymbols TAG = new PlaceholderSymbols("TAG", 4, "@([A-Za-z0-9_\\-](?:(?:[A-Za-z0-9_\\-]|(?:\\.(?!\\.))){0,28}(?:[A-Za-z0-9_\\-]))?)");
    public static final PlaceholderSymbols KEYBOARD = new PlaceholderSymbols("KEYBOARD", 5, "keyboard_arrow_(up|down|left|right)");
    public static final PlaceholderSymbols FILE_NAME = new PlaceholderSymbols("FILE_NAME", 6, "(?i)(/*[^\\s\\/<>\"\\?\\*:|]+/)*[^\\s\\/<>\"\\?\\*:|]+\\.(jpg|jpeg|png|gif|pdf|doc|docx|html|txt|xls|xlsx|ppt|pptx|mp3|mp4|zip|rar|tar|csv|xml|exe|mpeg|mpg)");
    public static final PlaceholderSymbols WINDOW_PATH = new PlaceholderSymbols("WINDOW_PATH", 7, "(?i)[CD]\\:(\\\\[^\\s\\/<>\\\\\"\\?\\*:|]+)+");
    public static final PlaceholderSymbols MATH = new PlaceholderSymbols("MATH", 8, "(?i)(sin|cos|tan|cot|sec|csc)\\([a-zA-Z0-9\\+\\-\\s]+\\)");
    public static final PlaceholderSymbols EMPTY_TAGS = new PlaceholderSymbols("EMPTY_TAGS", 9, "(<a_[0-9]{1,2}></a_[0-9]{1,2}>)+");

    private static final /* synthetic */ PlaceholderSymbols[] $values() {
        return new PlaceholderSymbols[]{EMAIL, URL, PHONE, PHONE2, TAG, KEYBOARD, FILE_NAME, WINDOW_PATH, MATH, EMPTY_TAGS};
    }

    public static EnumEntries<PlaceholderSymbols> getEntries() {
        return $ENTRIES;
    }

    public static PlaceholderSymbols valueOf(String str) {
        return (PlaceholderSymbols) Enum.valueOf(PlaceholderSymbols.class, str);
    }

    public static PlaceholderSymbols[] values() {
        return (PlaceholderSymbols[]) $VALUES.clone();
    }

    private PlaceholderSymbols(String str, int i, String str2) {
        this.regex = str2;
    }

    public final String getRegex() {
        return this.regex;
    }

    static {
        PlaceholderSymbols[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
