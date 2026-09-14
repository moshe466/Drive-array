package com.samsung.android.sbrowser.ext.clientservice.translator;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface Translator {
    void clear() throws Exception;

    void delete() throws Exception;

    ArrayList<String> getAvailableLangpackListWithLocale(String str) throws Exception;

    ArrayList<String> getAvailableLanguageDirectionList() throws Exception;

    ArrayList<String> getAvailableLanguageDirectionListWithLocale(String str) throws Exception;

    ArrayList<String> getDownloadableLanguageDirectionList() throws Exception;

    ArrayList<String> getSourceLanguageList() throws Exception;

    String identifyLanguage(String str) throws Exception;

    void init(Context context, TranslatorClient translatorClient) throws Exception;

    boolean isPivot() throws Exception;

    void refresh() throws Exception;

    void setPivot(String str) throws Exception;

    void translate(String str, int i, String str2, String str3, boolean z) throws Exception;
}
