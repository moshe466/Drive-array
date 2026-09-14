package com.fasterxml.jackson.dataformat.yaml.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes.dex */
public abstract class StringQuotingChecker implements Serializable {
    private static final Set<String> RESERVED_KEYWORDS = new HashSet(Arrays.asList("false", "False", "FALSE", "n", "N", "no", "No", "NO", "null", "Null", "NULL", DebugKt.DEBUG_PROPERTY_VALUE_ON, "On", "ON", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "Off", "OFF", "true", "True", "TRUE", "y", "Y", "yes", "Yes", "YES"));
    private static final long serialVersionUID = 1;

    protected boolean _looksLikeYAMLNumber(int i, String str) {
        switch (i) {
            case 43:
            case 45:
            case 46:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return true;
            case 44:
            case 47:
            default:
                return false;
        }
    }

    public abstract boolean needToQuoteName(String str);

    public abstract boolean needToQuoteValue(String str);

    protected boolean isReservedKeyword(String str) {
        if (str.length() == 0) {
            return true;
        }
        return _isReservedKeyword(str.charAt(0), str);
    }

    protected boolean _isReservedKeyword(int i, String str) {
        if (i != 70 && i != 84 && i != 89 && i != 102 && i != 116 && i != 121) {
            if (i == 126) {
                return true;
            }
            if (i != 78 && i != 79 && i != 110 && i != 111) {
                return false;
            }
        }
        return RESERVED_KEYWORDS.contains(str);
    }

    protected boolean looksLikeYAMLNumber(String str) {
        if (str.length() > 0) {
            return _looksLikeYAMLNumber(str.charAt(0), str);
        }
        return false;
    }

    protected boolean valueHasQuotableChar(String str) {
        char charAt;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt2 = str.charAt(i);
            if (charAt2 != '#') {
                if (charAt2 != ',') {
                    if (charAt2 != ':') {
                        if (charAt2 != '[' && charAt2 != ']' && charAt2 != '{' && charAt2 != '}') {
                        }
                    } else if (i >= length - 1) {
                        continue;
                    } else {
                        char charAt3 = str.charAt(i + 1);
                        if (' ' != charAt3 && '\t' != charAt3) {
                        }
                    }
                }
                return true;
            }
            if (i > 0 && (' ' == (charAt = str.charAt(i - 1)) || '\t' == charAt)) {
                return true;
            }
        }
        return false;
    }

    protected boolean nameHasQuotableChar(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) < ' ') {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class Default extends StringQuotingChecker implements Serializable {
        private static final Default INSTANCE = new Default();
        private static final long serialVersionUID = 1;

        public static Default instance() {
            return INSTANCE;
        }

        @Override // com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker
        public boolean needToQuoteName(String str) {
            return isReservedKeyword(str) || looksLikeYAMLNumber(str) || nameHasQuotableChar(str);
        }

        @Override // com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker
        public boolean needToQuoteValue(String str) {
            return isReservedKeyword(str) || valueHasQuotableChar(str);
        }
    }
}
