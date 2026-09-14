package org.apache.tika.language.detect;

import F0.C0019c2;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.tika.config.ServiceLoader;

/* loaded from: classes.dex */
public abstract class LanguageDetector {
    private static final int BUFFER_LENGTH = 4096;
    private static final ServiceLoader DEFAULT_SERVICE_LOADER = new ServiceLoader();
    protected boolean mixedLanguages = false;
    protected boolean shortText = false;

    public static LanguageDetector getDefaultLanguageDetector() {
        List<LanguageDetector> languageDetectors = getLanguageDetectors();
        if (!languageDetectors.isEmpty()) {
            return languageDetectors.get(0);
        }
        throw new IllegalStateException("No language detectors available");
    }

    public static List<LanguageDetector> getLanguageDetectors() {
        return getLanguageDetectors(DEFAULT_SERVICE_LOADER);
    }

    public void addText(CharSequence charSequence) {
        int length = charSequence.length();
        if (length < BUFFER_LENGTH) {
            char[] charArray = charSequence.toString().toCharArray();
            addText(charArray, 0, charArray.length);
            return;
        }
        int i = 0;
        while (!hasEnoughText() && i < length) {
            int i3 = i + BUFFER_LENGTH;
            char[] charArray2 = charSequence.subSequence(i, Math.min(i3, length)).toString().toCharArray();
            addText(charArray2, 0, charArray2.length);
            i = i3;
        }
    }

    public abstract void addText(char[] cArr, int i, int i3);

    public LanguageResult detect() {
        return detectAll().get(0);
    }

    public abstract List<LanguageResult> detectAll();

    public List<LanguageResult> detectAll(String str) {
        reset();
        addText(str);
        return detectAll();
    }

    public boolean hasEnoughText() {
        return false;
    }

    public abstract boolean hasModel(String str);

    public boolean isMixedLanguages() {
        return this.mixedLanguages;
    }

    public boolean isShortText() {
        return this.shortText;
    }

    public abstract LanguageDetector loadModels();

    public abstract LanguageDetector loadModels(Set<String> set);

    public abstract void reset();

    public LanguageDetector setMixedLanguages(boolean z3) {
        this.mixedLanguages = z3;
        return this;
    }

    public abstract LanguageDetector setPriors(Map<String, Float> map);

    public LanguageDetector setShortText(boolean z3) {
        this.shortText = z3;
        return this;
    }

    public static List<LanguageDetector> getLanguageDetectors(ServiceLoader serviceLoader) {
        List<LanguageDetector> loadStaticServiceProviders = serviceLoader.loadStaticServiceProviders(LanguageDetector.class);
        loadStaticServiceProviders.sort(new C0019c2(8));
        return loadStaticServiceProviders;
    }

    public LanguageResult detect(CharSequence charSequence) {
        reset();
        addText(charSequence);
        return detect();
    }
}
