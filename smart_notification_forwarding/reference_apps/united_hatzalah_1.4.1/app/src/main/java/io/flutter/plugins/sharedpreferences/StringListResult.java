package io.flutter.plugins.sharedpreferences;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import t2.AbstractC0708j;

/* loaded from: classes.dex */
public final class StringListResult {
    public static final Companion Companion = new Companion(null);
    private final String jsonEncodedValue;
    private final StringListLookupResultType type;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final StringListResult fromList(List<? extends Object> pigeonVar_list) {
            j.e(pigeonVar_list, "pigeonVar_list");
            String str = (String) pigeonVar_list.get(0);
            Object obj = pigeonVar_list.get(1);
            j.c(obj, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
            return new StringListResult(str, (StringListLookupResultType) obj);
        }

        private Companion() {
        }
    }

    public StringListResult(String str, StringListLookupResultType type) {
        j.e(type, "type");
        this.jsonEncodedValue = str;
        this.type = type;
    }

    public static /* synthetic */ StringListResult copy$default(StringListResult stringListResult, String str, StringListLookupResultType stringListLookupResultType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stringListResult.jsonEncodedValue;
        }
        if ((i & 2) != 0) {
            stringListLookupResultType = stringListResult.type;
        }
        return stringListResult.copy(str, stringListLookupResultType);
    }

    public final String component1() {
        return this.jsonEncodedValue;
    }

    public final StringListLookupResultType component2() {
        return this.type;
    }

    public final StringListResult copy(String str, StringListLookupResultType type) {
        j.e(type, "type");
        return new StringListResult(str, type);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StringListResult)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return MessagesAsyncPigeonUtils.INSTANCE.deepEquals(toList(), ((StringListResult) obj).toList());
    }

    public final String getJsonEncodedValue() {
        return this.jsonEncodedValue;
    }

    public final StringListLookupResultType getType() {
        return this.type;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return AbstractC0708j.W(this.jsonEncodedValue, this.type);
    }

    public String toString() {
        return "StringListResult(jsonEncodedValue=" + this.jsonEncodedValue + ", type=" + this.type + ")";
    }

    public /* synthetic */ StringListResult(String str, StringListLookupResultType stringListLookupResultType, int i, f fVar) {
        this((i & 1) != 0 ? null : str, stringListLookupResultType);
    }
}
