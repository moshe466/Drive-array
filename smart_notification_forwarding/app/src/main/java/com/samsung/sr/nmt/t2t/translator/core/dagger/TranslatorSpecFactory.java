package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorSpecFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorSpecFactory;", JsonProperty.USE_DEFAULT_NAME, "assetLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "activeLanguageCodeChecker", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/ActiveLanguageCodeChecker;", "(Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;Lcom/samsung/sr/nmt/t2t/translator/core/utils/ActiveLanguageCodeChecker;)V", "create", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;", "convertToSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorSpecFactory$TranslatorSpecOrig;", "Companion", "DirectionsOrig", "TranslatorSpecOrig", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslatorSpecFactory {
    public static final String FILE_NAME = "translator-spec.yaml";
    private final ActiveLanguageCodeChecker activeLanguageCodeChecker;
    private final AssetLoader assetLoader;

    @Inject
    public TranslatorSpecFactory(AssetLoader assetLoader, ActiveLanguageCodeChecker activeLanguageCodeChecker) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        Intrinsics.checkNotNullParameter(activeLanguageCodeChecker, "activeLanguageCodeChecker");
        this.assetLoader = assetLoader;
        this.activeLanguageCodeChecker = activeLanguageCodeChecker;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007a A[EDGE_INSN: B:26:0x007a->B:8:0x007a BREAK  A[LOOP:0: B:16:0x0050->B:27:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:0: B:16:0x0050->B:27:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec create() throws java.io.IOException, java.lang.IllegalStateException {
        /*
            r9 = this;
            com.fasterxml.jackson.databind.ObjectMapper r0 = new com.fasterxml.jackson.databind.ObjectMapper
            com.fasterxml.jackson.dataformat.yaml.YAMLFactory r1 = new com.fasterxml.jackson.dataformat.yaml.YAMLFactory
            r1.<init>()
            com.fasterxml.jackson.core.JsonFactory r1 = (com.fasterxml.jackson.core.JsonFactory) r1
            r0.<init>(r1)
            com.fasterxml.jackson.module.kotlin.KotlinModule$Builder r1 = new com.fasterxml.jackson.module.kotlin.KotlinModule$Builder
            r1.<init>()
            com.fasterxml.jackson.module.kotlin.KotlinModule r1 = r1.build()
            com.fasterxml.jackson.databind.Module r1 = (com.fasterxml.jackson.databind.Module) r1
            r0.registerModule(r1)
            com.fasterxml.jackson.core.JsonParser$Feature r1 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES
            r2 = 1
            r0.configure(r1, r2)
            com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader r1 = r9.assetLoader
            java.lang.String r3 = "translator-spec.yaml"
            java.io.InputStream r1 = r1.open(r3)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r3 = r1
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch: java.lang.Throwable -> Lad
            java.lang.Class<com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory$TranslatorSpecOrig> r4 = com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory.TranslatorSpecOrig.class
            java.lang.Object r0 = r0.readValue(r3, r4)     // Catch: java.lang.Throwable -> Lad
            r3 = r0
            com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory$TranslatorSpecOrig r3 = (com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory.TranslatorSpecOrig) r3     // Catch: java.lang.Throwable -> Lad
            java.util.List r4 = r3.getDirections()     // Catch: java.lang.Throwable -> Lad
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> Lad
            boolean r5 = r4 instanceof java.util.Collection     // Catch: java.lang.Throwable -> Lad
            r6 = 0
            if (r5 == 0) goto L4c
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5     // Catch: java.lang.Throwable -> Lad
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> Lad
            if (r5 == 0) goto L4c
        L4a:
            r2 = r6
            goto L7a
        L4c:
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> Lad
        L50:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lad
            if (r5 == 0) goto L4a
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lad
            com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory$DirectionsOrig r5 = (com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory.DirectionsOrig) r5     // Catch: java.lang.Throwable -> Lad
            com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker r7 = r9.activeLanguageCodeChecker     // Catch: java.lang.Throwable -> Lad
            java.lang.String r8 = r5.getSrcLang()     // Catch: java.lang.Throwable -> Lad
            boolean r7 = r7.isValid(r8)     // Catch: java.lang.Throwable -> Lad
            if (r7 == 0) goto L77
            com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker r7 = r9.activeLanguageCodeChecker     // Catch: java.lang.Throwable -> Lad
            java.lang.String r5 = r5.getTgtLang()     // Catch: java.lang.Throwable -> Lad
            boolean r5 = r7.isValid(r5)     // Catch: java.lang.Throwable -> Lad
            if (r5 != 0) goto L75
            goto L77
        L75:
            r5 = r6
            goto L78
        L77:
            r5 = r2
        L78:
            if (r5 == 0) goto L50
        L7a:
            if (r2 != 0) goto L8c
            java.lang.String r2 = "also(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch: java.lang.Throwable -> Lad
            com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory$TranslatorSpecOrig r0 = (com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory.TranslatorSpecOrig) r0     // Catch: java.lang.Throwable -> Lad
            com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec r0 = r9.convertToSpec(r0)     // Catch: java.lang.Throwable -> Lad
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            return r0
        L8c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lad
            java.util.List r2 = r3.getDirections()     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r3.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r4 = "Language format is not valid "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lad
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lad
            throw r0     // Catch: java.lang.Throwable -> Lad
        Lad:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> Laf
        Laf:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorSpecFactory.create():com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec");
    }

    private final TranslatorSpec convertToSpec(TranslatorSpecOrig translatorSpecOrig) {
        ArrayList arrayList = new ArrayList();
        for (DirectionsOrig directionsOrig : translatorSpecOrig.getDirections()) {
            String srcLang = directionsOrig.getSrcLang();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = srcLang.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String tgtLang = directionsOrig.getTgtLang();
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase2 = tgtLang.toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            arrayList.add(new LanguageDirection(lowerCase, lowerCase2));
            if (directionsOrig.getBiDirection()) {
                String tgtLang2 = directionsOrig.getTgtLang();
                Locale US3 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US3, "US");
                String lowerCase3 = tgtLang2.toLowerCase(US3);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                String srcLang2 = directionsOrig.getSrcLang();
                Locale US4 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US4, "US");
                String lowerCase4 = srcLang2.toLowerCase(US4);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                arrayList.add(new LanguageDirection(lowerCase3, lowerCase4));
            }
        }
        return new TranslatorSpec(translatorSpecOrig.getVersion(), arrayList);
    }

    /* compiled from: TranslatorSpecFactory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorSpecFactory$TranslatorSpecOrig;", JsonProperty.USE_DEFAULT_NAME, "version", JsonProperty.USE_DEFAULT_NAME, "directions", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorSpecFactory$DirectionsOrig;", "(Ljava/lang/String;Ljava/util/List;)V", "getDirections", "()Ljava/util/List;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class TranslatorSpecOrig {
        private final List<DirectionsOrig> directions;
        private final String version;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TranslatorSpecOrig copy$default(TranslatorSpecOrig translatorSpecOrig, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = translatorSpecOrig.version;
            }
            if ((i & 2) != 0) {
                list = translatorSpecOrig.directions;
            }
            return translatorSpecOrig.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        public final List<DirectionsOrig> component2() {
            return this.directions;
        }

        public final TranslatorSpecOrig copy(String version, List<DirectionsOrig> directions) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(directions, "directions");
            return new TranslatorSpecOrig(version, directions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TranslatorSpecOrig)) {
                return false;
            }
            TranslatorSpecOrig translatorSpecOrig = (TranslatorSpecOrig) other;
            return Intrinsics.areEqual(this.version, translatorSpecOrig.version) && Intrinsics.areEqual(this.directions, translatorSpecOrig.directions);
        }

        public int hashCode() {
            return (this.version.hashCode() * 31) + this.directions.hashCode();
        }

        public String toString() {
            return "TranslatorSpecOrig(version=" + this.version + ", directions=" + this.directions + ")";
        }

        public TranslatorSpecOrig(String version, List<DirectionsOrig> directions) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(directions, "directions");
            this.version = version;
            this.directions = directions;
        }

        public final List<DirectionsOrig> getDirections() {
            return this.directions;
        }

        public final String getVersion() {
            return this.version;
        }
    }

    /* compiled from: TranslatorSpecFactory.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorSpecFactory$DirectionsOrig;", JsonProperty.USE_DEFAULT_NAME, "srcLang", JsonProperty.USE_DEFAULT_NAME, "tgtLang", "biDirection", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBiDirection", "()Z", "getSrcLang", "()Ljava/lang/String;", "getTgtLang", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class DirectionsOrig {
        private final boolean biDirection;
        private final String srcLang;
        private final String tgtLang;

        public static /* synthetic */ DirectionsOrig copy$default(DirectionsOrig directionsOrig, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = directionsOrig.srcLang;
            }
            if ((i & 2) != 0) {
                str2 = directionsOrig.tgtLang;
            }
            if ((i & 4) != 0) {
                z = directionsOrig.biDirection;
            }
            return directionsOrig.copy(str, str2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSrcLang() {
            return this.srcLang;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTgtLang() {
            return this.tgtLang;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getBiDirection() {
            return this.biDirection;
        }

        public final DirectionsOrig copy(String srcLang, String tgtLang, boolean biDirection) {
            Intrinsics.checkNotNullParameter(srcLang, "srcLang");
            Intrinsics.checkNotNullParameter(tgtLang, "tgtLang");
            return new DirectionsOrig(srcLang, tgtLang, biDirection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DirectionsOrig)) {
                return false;
            }
            DirectionsOrig directionsOrig = (DirectionsOrig) other;
            return Intrinsics.areEqual(this.srcLang, directionsOrig.srcLang) && Intrinsics.areEqual(this.tgtLang, directionsOrig.tgtLang) && this.biDirection == directionsOrig.biDirection;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.srcLang.hashCode() * 31) + this.tgtLang.hashCode()) * 31;
            boolean z = this.biDirection;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "DirectionsOrig(srcLang=" + this.srcLang + ", tgtLang=" + this.tgtLang + ", biDirection=" + this.biDirection + ")";
        }

        public DirectionsOrig(String srcLang, String tgtLang, boolean z) {
            Intrinsics.checkNotNullParameter(srcLang, "srcLang");
            Intrinsics.checkNotNullParameter(tgtLang, "tgtLang");
            this.srcLang = srcLang;
            this.tgtLang = tgtLang;
            this.biDirection = z;
        }

        public /* synthetic */ DirectionsOrig(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z);
        }

        public final String getSrcLang() {
            return this.srcLang;
        }

        public final String getTgtLang() {
            return this.tgtLang;
        }

        public final boolean getBiDirection() {
            return this.biDirection;
        }
    }
}
