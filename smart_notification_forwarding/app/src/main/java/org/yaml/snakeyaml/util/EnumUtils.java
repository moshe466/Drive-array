package org.yaml.snakeyaml.util;

/* loaded from: classes2.dex */
public class EnumUtils {
    public static <T extends Enum<T>> T findEnumInsensitiveCase(Class<T> cls, String str) {
        for (T t : cls.getEnumConstants()) {
            if (t.name().compareToIgnoreCase(str) == 0) {
                return t;
            }
        }
        throw new IllegalArgumentException("No enum constant " + cls.getCanonicalName() + "." + str);
    }
}
