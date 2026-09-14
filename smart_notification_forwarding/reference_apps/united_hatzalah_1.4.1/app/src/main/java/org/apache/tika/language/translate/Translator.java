package org.apache.tika.language.translate;

/* loaded from: classes.dex */
public interface Translator {
    boolean isAvailable();

    String translate(String str, String str2);

    String translate(String str, String str2, String str3);
}
