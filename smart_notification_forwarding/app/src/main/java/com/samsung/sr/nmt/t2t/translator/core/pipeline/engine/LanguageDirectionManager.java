package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.RuleUtils;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LanguageDirectionManager.kt */
@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010 \u001a\u00020\tJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\"\u001a\u00020\tJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010$\u001a\u00020\bH\u0002J\u0018\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tJ\u0018\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tJ\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010$\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020)2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tJ\u0010\u0010+\u001a\u00020)2\u0006\u0010$\u001a\u00020\bH\u0002J\u0016\u0010,\u001a\u00020)2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tJ\u0006\u0010-\u001a\u00020\u001dJ\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u000e\u00100\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0003R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;", JsonProperty.USE_DEFAULT_NAME, "translatorSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;", "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "taggedSupportingInfo", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;Ljava/util/Map;)V", "availableLanguageDirectionList", JsonProperty.USE_DEFAULT_NAME, "getAvailableLanguageDirectionList", "()Ljava/util/List;", "languageDirectionStateMap", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirectionState;", "getLanguageDirectionStateMap", "()Ljava/util/Map;", "languageDirections", JsonProperty.USE_DEFAULT_NAME, "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "newTranslatorSpec", "getTranslatorSpec", "()Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;", "setTranslatorSpec", "(Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;)V", "clear", JsonProperty.USE_DEFAULT_NAME, "getAvailableSourceLanguageList", "getAvailableSourceLanguageListWithTargetLanguage", "targetLanguage", "getAvailableTargetLanguageList", "sourceLanguage", "getForcedPivotPath", "languageDirection", "getLanguageDirectionState", "getResourcePackPackageName", "getTranslationPath", "forcePivot", JsonProperty.USE_DEFAULT_NAME, "isAvailableDirection", "isPivotForceable", "isTaggedTranslationSupported", "refresh", "updateDirectDirection", "updatePivotDirection", "updateTranslatorSpec", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguageDirectionManager {
    private static final int EN_PIVOT_LENGTH = 2;
    private static final int SCS_VERSION_LENGTH = 4;
    private final FileLoader fileLoader;
    private final Map<LanguageDirection, List<LanguageDirection>> languageDirections;
    private final ReentrantLock lock;
    private final Map<LanguageDirection, String> taggedSupportingInfo;
    private TranslatorSpec translatorSpec;

    @Inject
    public LanguageDirectionManager(TranslatorSpec translatorSpec, FileLoader fileLoader, @Named("tagged-supporting-info") Map<LanguageDirection, String> taggedSupportingInfo) {
        Intrinsics.checkNotNullParameter(translatorSpec, "translatorSpec");
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(taggedSupportingInfo, "taggedSupportingInfo");
        this.fileLoader = fileLoader;
        this.taggedSupportingInfo = taggedSupportingInfo;
        this.translatorSpec = translatorSpec;
        this.lock = new ReentrantLock();
        this.languageDirections = new LinkedHashMap();
    }

    private final TranslatorSpec getTranslatorSpec() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.translatorSpec;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void setTranslatorSpec(TranslatorSpec translatorSpec) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.translatorSpec = translatorSpec;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Map<LanguageDirection, LanguageDirectionState> getLanguageDirectionStateMap() {
        LanguageDirectionState languageDirectionState;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Set<Map.Entry<LanguageDirection, List<LanguageDirection>>> entrySet = this.languageDirections.entrySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                List list = (List) entry.getValue();
                Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    languageDirectionState = LanguageDirectionState.DOWNLOADABLE;
                    arrayList.add(TuplesKt.to(key, languageDirectionState));
                }
                if (valueOf.intValue() == 1) {
                    languageDirectionState = LanguageDirectionState.AVAILABLE;
                    arrayList.add(TuplesKt.to(key, languageDirectionState));
                }
                if (valueOf == null) {
                    languageDirectionState = LanguageDirectionState.UNAUTHORIZED_RESOURCE;
                } else {
                    languageDirectionState = LanguageDirectionState.AVAILABLE_BY_PIVOT;
                }
                arrayList.add(TuplesKt.to(key, languageDirectionState));
            }
            return MapsKt.toMap(arrayList);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection> getAvailableLanguageDirectionList() {
        /*
            r7 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r7.lock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            java.util.Map r1 = r7.getLanguageDirectionStateMap()     // Catch: java.lang.Throwable -> L74
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L74
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L74
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L74
            r2.<init>()     // Catch: java.lang.Throwable -> L74
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L74
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L74
        L1c:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L74
            if (r3 == 0) goto L43
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L74
            r4 = r3
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> L74
            java.lang.Object r5 = r4.getValue()     // Catch: java.lang.Throwable -> L74
            com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState r6 = com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState.AVAILABLE     // Catch: java.lang.Throwable -> L74
            if (r5 == r6) goto L3c
            java.lang.Object r4 = r4.getValue()     // Catch: java.lang.Throwable -> L74
            com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState r5 = com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState.AVAILABLE_BY_PIVOT     // Catch: java.lang.Throwable -> L74
            if (r4 != r5) goto L3a
            goto L3c
        L3a:
            r4 = 0
            goto L3d
        L3c:
            r4 = 1
        L3d:
            if (r4 == 0) goto L1c
            r2.add(r3)     // Catch: java.lang.Throwable -> L74
            goto L1c
        L43:
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L74
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L74
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L74
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r3)     // Catch: java.lang.Throwable -> L74
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L74
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L74
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L74
        L58:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L74
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L74
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L74
            java.lang.Object r3 = r3.getKey()     // Catch: java.lang.Throwable -> L74
            com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection r3 = (com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection) r3     // Catch: java.lang.Throwable -> L74
            r1.add(r3)     // Catch: java.lang.Throwable -> L74
            goto L58
        L6e:
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L74
            r0.unlock()
            return r1
        L74:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager.getAvailableLanguageDirectionList():java.util.List");
    }

    public static /* synthetic */ List getTranslationPath$default(LanguageDirectionManager languageDirectionManager, LanguageDirection languageDirection, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return languageDirectionManager.getTranslationPath(languageDirection, z);
    }

    public final List<LanguageDirection> getTranslationPath(LanguageDirection languageDirection, boolean forcePivot) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        if (forcePivot) {
            try {
                if (isPivotForceable(languageDirection)) {
                    List<LanguageDirection> forcedPivotPath = getForcedPivotPath(languageDirection);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : forcedPivotPath) {
                        LanguageDirection languageDirection2 = (LanguageDirection) obj;
                        if (getLanguageDirectionState(languageDirection2.getSrcLang(), languageDirection2.getTgtLang()) == LanguageDirectionState.AVAILABLE) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2.size() == 2) {
                        return arrayList2;
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        List<LanguageDirection> list = this.languageDirections.get(languageDirection);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    private final boolean isPivotForceable(LanguageDirection languageDirection) {
        return (Intrinsics.areEqual(languageDirection.getSrcLang(), "en") || Intrinsics.areEqual(languageDirection.getTgtLang(), "en")) ? false : true;
    }

    private final List<LanguageDirection> getForcedPivotPath(LanguageDirection languageDirection) {
        return CollectionsKt.listOf((Object[]) new LanguageDirection[]{new LanguageDirection(languageDirection.getSrcLang(), "en"), new LanguageDirection("en", languageDirection.getTgtLang())});
    }

    public final LanguageDirectionState getLanguageDirectionState(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return getLanguageDirectionStateMap().get(new LanguageDirection(sourceLanguage, targetLanguage));
    }

    public final List<String> getAvailableSourceLanguageList() {
        List<LanguageDirection> availableLanguageDirectionList = getAvailableLanguageDirectionList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availableLanguageDirectionList, 10));
        Iterator<T> it = availableLanguageDirectionList.iterator();
        while (it.hasNext()) {
            arrayList.add(((LanguageDirection) it.next()).getSrcLang());
        }
        return CollectionsKt.toList(CollectionsKt.toSortedSet(arrayList));
    }

    public final List<String> getAvailableSourceLanguageListWithTargetLanguage(String targetLanguage) {
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        List<LanguageDirection> availableLanguageDirectionList = getAvailableLanguageDirectionList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : availableLanguageDirectionList) {
            LanguageDirection languageDirection = (LanguageDirection) obj;
            if (!Intrinsics.areEqual(languageDirection.getSrcLang(), targetLanguage) && Intrinsics.areEqual(languageDirection.getTgtLang(), targetLanguage)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((LanguageDirection) it.next()).getSrcLang());
        }
        return CollectionsKt.toList(CollectionsKt.toSortedSet(arrayList3));
    }

    public final List<String> getAvailableTargetLanguageList(String sourceLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        List<LanguageDirection> availableLanguageDirectionList = getAvailableLanguageDirectionList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : availableLanguageDirectionList) {
            LanguageDirection languageDirection = (LanguageDirection) obj;
            if (Intrinsics.areEqual(languageDirection.getSrcLang(), sourceLanguage) && !Intrinsics.areEqual(languageDirection.getTgtLang(), sourceLanguage)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((LanguageDirection) it.next()).getTgtLang());
        }
        return CollectionsKt.toList(CollectionsKt.toSortedSet(arrayList3));
    }

    public final void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.languageDirections.clear();
            this.fileLoader.clearCache();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isAvailableDirection(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        List<LanguageDirection> availableLanguageDirectionList = getAvailableLanguageDirectionList();
        if ((availableLanguageDirectionList instanceof Collection) && availableLanguageDirectionList.isEmpty()) {
            return false;
        }
        for (LanguageDirection languageDirection : availableLanguageDirectionList) {
            if (Intrinsics.areEqual(languageDirection.getSrcLang(), sourceLanguage) && Intrinsics.areEqual(languageDirection.getTgtLang(), targetLanguage)) {
                return true;
            }
        }
        return false;
    }

    public final void refresh() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            clear();
            updateDirectDirection();
            updatePivotDirection();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final String getResourcePackPackageName(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        if (getTranslatorSpec().getDirections().contains(new LanguageDirection(sourceLanguage, targetLanguage))) {
            return this.fileLoader.getResourcePackageName(sourceLanguage, targetLanguage);
        }
        return null;
    }

    public final void updateTranslatorSpec(TranslatorSpec newTranslatorSpec) {
        Intrinsics.checkNotNullParameter(newTranslatorSpec, "newTranslatorSpec");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            setTranslatorSpec(newTranslatorSpec);
            refresh();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isTaggedTranslationSupported(String sourceLanguage, String targetLanguage) {
        String version;
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        List<LanguageDirection> translationPath$default = getTranslationPath$default(this, new LanguageDirection(sourceLanguage, targetLanguage), false, 2, null);
        if (!(translationPath$default instanceof Collection) || !translationPath$default.isEmpty()) {
            for (LanguageDirection languageDirection : translationPath$default) {
                String str = this.taggedSupportingInfo.get(languageDirection);
                if (!(str == null || ((version = this.fileLoader.getVersion(languageDirection.getSrcLang(), languageDirection.getTgtLang())) != null && (StringsKt.split$default((CharSequence) version, new char[]{RuleUtils.DOT}, false, 0, 6, (Object) null).size() == 4 || version.length() > str.length() || version.compareTo(str) >= 0)))) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void updateDirectDirection() {
        List<LanguageDirection> emptyList;
        this.languageDirections.clear();
        for (LanguageDirection languageDirection : getTranslatorSpec().getDirections()) {
            Map<LanguageDirection, List<LanguageDirection>> map = this.languageDirections;
            if (this.fileLoader.existResource(languageDirection.getSrcLang(), languageDirection.getTgtLang())) {
                emptyList = this.fileLoader.isValidResourcePackage(languageDirection.getSrcLang(), languageDirection.getTgtLang()) ? CollectionsKt.listOf(languageDirection) : null;
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            map.put(languageDirection, emptyList);
        }
    }

    private final void updatePivotDirection() {
        ArrayList arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<Map.Entry<LanguageDirection, List<LanguageDirection>>> entrySet = this.languageDirections.entrySet();
        ArrayList<Map.Entry> arrayList2 = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            List list = (List) ((Map.Entry) next).getValue();
            if (list != null && list.size() == 1) {
                z = true;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        for (Map.Entry entry : arrayList2) {
            if (!linkedHashMap.containsKey(((LanguageDirection) entry.getKey()).getSrcLang())) {
                linkedHashMap.put(((LanguageDirection) entry.getKey()).getSrcLang(), new ArrayList());
            }
            List list2 = (List) linkedHashMap.get(((LanguageDirection) entry.getKey()).getSrcLang());
            if (list2 != null) {
                list2.add(((LanguageDirection) entry.getKey()).getTgtLang());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            List<String> list3 = (List) entry2.getValue();
            ArrayList arrayList3 = new ArrayList();
            for (String str2 : list3) {
                List list4 = (List) linkedHashMap.get(str2);
                if (list4 == null) {
                    arrayList = new ArrayList();
                } else {
                    List list5 = list4;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    Iterator it2 = list5.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new LanguageDirection(str2, (String) it2.next()));
                    }
                }
                CollectionsKt.addAll(arrayList3, arrayList);
            }
            ArrayList<LanguageDirection> arrayList4 = new ArrayList();
            for (Object obj : arrayList3) {
                if (!Intrinsics.areEqual(str, ((LanguageDirection) obj).getTgtLang())) {
                    arrayList4.add(obj);
                }
            }
            for (LanguageDirection languageDirection : arrayList4) {
                LanguageDirection languageDirection2 = new LanguageDirection(str, languageDirection.getTgtLang());
                List<LanguageDirection> list6 = this.languageDirections.get(languageDirection2);
                if (list6 == null || list6.isEmpty()) {
                    this.languageDirections.put(languageDirection2, CollectionsKt.listOf((Object[]) new LanguageDirection[]{new LanguageDirection(str, languageDirection.getSrcLang()), languageDirection}));
                }
            }
        }
    }
}
