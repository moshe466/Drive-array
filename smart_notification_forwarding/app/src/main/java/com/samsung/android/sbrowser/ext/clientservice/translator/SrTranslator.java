package com.samsung.android.sbrowser.ext.clientservice.translator;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.LanguageDirectionState;
import com.samsung.sr.nmt.core.t2t.translator.TranslatorBuilder;
import com.samsung.sr.nmt.core.t2t.translator.TranslatorInput;
import com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationTask;
import com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class SrTranslator implements Translator {
    static final String TAG = "SrTranslator";
    private TranslatorClient mClient;
    private Handler mClientHandler;
    private Context mContext;
    private Boolean mIsPivot = false;
    private com.samsung.sr.nmt.core.t2t.translator.Translator mTranslator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SrTranslator() {
        Log.i(TAG, "called");
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public void init(Context context, TranslatorClient translatorClient) throws Exception {
        Log.i(TAG, "init called");
        this.mClient = translatorClient;
        this.mContext = context;
        this.mClientHandler = new TranslateHandler(Looper.myLooper());
    }

    void createTranslator(Context context) throws Exception {
        if (this.mTranslator != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.samsung.sr.nmt.core.t2t.translator.Translator buildWithExternalLanguagePack = TranslatorBuilder.buildWithExternalLanguagePack(context, false, true);
        this.mTranslator = buildWithExternalLanguagePack;
        buildWithExternalLanguagePack.refresh();
        Log.i(TAG, "translator created elapsed time " + (System.currentTimeMillis() - currentTimeMillis));
    }

    void deleteTranslator() {
        com.samsung.sr.nmt.core.t2t.translator.Translator translator = this.mTranslator;
        if (translator == null) {
            return;
        }
        translator.clear();
        this.mTranslator.dispose();
        this.mTranslator = null;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public void delete() throws Exception {
        deleteTranslator();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public void translate(String str, int i, String str2, String str3, boolean z) throws Exception {
        createTranslator(this.mContext);
        this.mTranslator.translate(TranslatorInput.builder().sourceLanguageCode(str2).targetLanguageCode(str3).sourceText(str).verbose(false).id(String.valueOf(i)).forcePivot(z).build(), this.mClientHandler);
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public ArrayList<String> getDownloadableLanguageDirectionList() throws Exception {
        createTranslator(this.mContext);
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<LanguageDirection, LanguageDirectionState> entry : this.mTranslator.getLanguageDirectionStateMap().entrySet()) {
            if (entry.getValue() != null && Objects.equals(entry.getValue(), LanguageDirectionState.DOWNLOADABLE) && !arrayList.contains(entry.getKey().getTgtLang())) {
                arrayList.add(entry.getKey().getTgtLang());
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public ArrayList<String> getAvailableLanguageDirectionList() throws Exception {
        createTranslator(this.mContext);
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<LanguageDirection, LanguageDirectionState> entry : this.mTranslator.getLanguageDirectionStateMap().entrySet()) {
            if (entry.getValue() != null && Objects.equals(entry.getValue(), LanguageDirectionState.AVAILABLE) && !arrayList.contains(entry.getKey().getTgtLang())) {
                arrayList.add(entry.getKey().getTgtLang());
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public ArrayList<String> getSourceLanguageList() throws Exception {
        createTranslator(this.mContext);
        List<String> sourceLanguageList = this.mTranslator.getSourceLanguageList();
        ArrayList<String> arrayList = new ArrayList<>(sourceLanguageList.size());
        arrayList.addAll(sourceLanguageList);
        return arrayList;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public String identifyLanguage(String str) throws Exception {
        createTranslator(this.mContext);
        com.samsung.sr.nmt.core.t2t.translator.Translator translator = this.mTranslator;
        return translator != null ? translator.identifyLanguage(str) : JsonProperty.USE_DEFAULT_NAME;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public void refresh() throws Exception {
        createTranslator(this.mContext);
        com.samsung.sr.nmt.core.t2t.translator.Translator translator = this.mTranslator;
        if (translator != null) {
            translator.clear();
            this.mTranslator.refresh();
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public void clear() throws Exception {
        createTranslator(this.mContext);
        com.samsung.sr.nmt.core.t2t.translator.Translator translator = this.mTranslator;
        if (translator != null) {
            translator.clear();
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public ArrayList<String> getAvailableLanguageDirectionListWithLocale(String str) throws Exception {
        createTranslator(this.mContext);
        ArrayList<String> arrayList = new ArrayList<>();
        com.samsung.sr.nmt.core.t2t.translator.Translator translator = this.mTranslator;
        if (translator != null) {
            boolean z = false;
            for (Map.Entry<LanguageDirection, LanguageDirectionState> entry : translator.getLanguageDirectionStateMap().entrySet()) {
                if (entry.getValue() != null && Objects.equals(entry.getValue(), LanguageDirectionState.AVAILABLE)) {
                    if (entry.getKey().getSrcLang().equals("en")) {
                        if (!arrayList.contains(entry.getKey().getTgtLang())) {
                            arrayList.add(entry.getKey().getTgtLang());
                            z = true;
                        }
                    } else if (!entry.getKey().getTgtLang().equals("en") && entry.getKey().getSrcLang().equals(str) && entry.getKey().getSrcLang().compareTo(entry.getKey().getTgtLang()) != 0) {
                        if (!arrayList.contains(entry.getKey().getSrcLang())) {
                            arrayList.add(entry.getKey().getSrcLang());
                        }
                        if (!arrayList.contains(entry.getKey().getTgtLang())) {
                            arrayList.add(entry.getKey().getTgtLang());
                        }
                    }
                }
            }
            if (z && !arrayList.contains("en")) {
                arrayList.add("en");
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public ArrayList<String> getAvailableLangpackListWithLocale(String str) throws Exception {
        int compareTo;
        createTranslator(this.mContext);
        ArrayList<String> arrayList = new ArrayList<>();
        com.samsung.sr.nmt.core.t2t.translator.Translator translator = this.mTranslator;
        if (translator != null) {
            boolean z = false;
            for (Map.Entry<LanguageDirection, LanguageDirectionState> entry : translator.getLanguageDirectionStateMap().entrySet()) {
                if (entry.getValue() != null && Objects.equals(entry.getValue(), LanguageDirectionState.AVAILABLE)) {
                    if (entry.getKey().getSrcLang().equals("en")) {
                        if (!arrayList.contains(entry.getKey().getTgtLang())) {
                            arrayList.add(entry.getKey().getTgtLang());
                            z = true;
                        }
                    } else if (!entry.getKey().getTgtLang().equals("en") && entry.getKey().getSrcLang().equals(str) && (compareTo = entry.getKey().getSrcLang().compareTo(entry.getKey().getTgtLang())) != 0) {
                        String str2 = entry.getKey().getSrcLang() + "-" + entry.getKey().getTgtLang();
                        if (compareTo > 0) {
                            str2 = entry.getKey().getTgtLang() + "-" + entry.getKey().getSrcLang();
                        }
                        if (!arrayList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
            if (z && !arrayList.contains("en")) {
                arrayList.add("en");
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public boolean isPivot() throws Exception {
        return this.mIsPivot.booleanValue();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.Translator
    public void setPivot(String str) throws Exception {
        this.mIsPivot = Boolean.valueOf(!str.equals('0'));
    }

    /* loaded from: classes.dex */
    private final class TranslateHandler extends Handler {
        public TranslateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TranslationTask translationTask = (TranslationTask) message.obj;
            int i = message.what;
            String id = translationTask.getId();
            String targetText = translationTask.getTargetText();
            if (i == 0) {
                SrTranslator.this.mClient.onTranslated(targetText, Integer.parseInt(id));
            } else {
                SrTranslator.this.mClient.onTranslated(null, Integer.parseInt(id));
            }
            super.handleMessage(message);
        }
    }
}
