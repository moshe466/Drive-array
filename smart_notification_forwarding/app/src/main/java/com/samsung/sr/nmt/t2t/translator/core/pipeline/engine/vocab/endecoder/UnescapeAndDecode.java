package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: UnescapeAndDecode.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0010B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\f\u0010\u000e\u001a\u00020\n*\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnescapeAndDecode;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", JsonProperty.USE_DEFAULT_NAME, "idToSubword", JsonProperty.USE_DEFAULT_NAME, "nextConvertStep", "(Ljava/util/List;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "convertDetails", "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "previousResult", "unescapeToken", "token", "toInt", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UnescapeAndDecode extends VocabIDsConvertStep<String> {
    private static final int EOS = 1;
    private static final int PAD = 0;
    private final List<String> idToSubword;
    private static final Pattern UNESCAPE_PATTERN = Pattern.compile("\\\\([0-9]+);");
    private static final Regex UNDERSCORE_REGEX = new Regex("_");

    private final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    public /* synthetic */ UnescapeAndDecode(List list, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : vocabIDsConvertStep);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStep
    public /* bridge */ /* synthetic */ String convertDetails(List list, String str) {
        return convertDetails2((List<Integer>) list, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnescapeAndDecode(List<String> idToSubword, VocabIDsConvertStep<String> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(idToSubword, "idToSubword");
        this.idToSubword = idToSubword;
    }

    /* renamed from: convertDetails, reason: avoid collision after fix types in other method */
    protected String convertDetails2(List<Integer> ids, String previousResult) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = ids.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int intValue = ((Number) next).intValue();
            if (intValue != 0 && intValue != 1) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            sb.append(this.idToSubword.get(((Number) it2.next()).intValue()));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        List<String> split = UNDERSCORE_REGEX.split(sb2, 0);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : split) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(unescapeToken((String) it3.next()));
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (((String) obj2).length() > 0) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        StringsKt.clear(sb);
        int size = arrayList6.size();
        int i = -1;
        int i2 = 0;
        while (i2 < size) {
            String str = (String) arrayList6.get(i2);
            int i3 = toInt(Character.isLetterOrDigit(str.charAt(0)));
            if (i2 > 0 && i3 == 1 && i == 1) {
                sb.append(" ");
            }
            sb.append(str);
            i2++;
            i = i3;
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }

    private final String unescapeToken(String token) {
        String str = token;
        SimpleLogger logger = LoggerFactory.INSTANCE.getLogger(getClass());
        int i = 0;
        if (StringsKt.endsWith$default((CharSequence) str, '\n', false, 2, (Object) null)) {
            str = str.substring(1, token.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(str, "\\\\", "\\", false, 4, (Object) null), "\\u", "_", false, 4, (Object) null);
        Matcher matcher = UNESCAPE_PATTERN.matcher(replace$default);
        if (!matcher.find()) {
            return replace$default;
        }
        StringBuilder sb = new StringBuilder();
        logger.debug("Unescape pattern matched with: " + ((Object) replace$default));
        do {
            String substring = replace$default.substring(matcher.start() + 1, matcher.end() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            logger.debug("Matched part : " + substring);
            int start = matcher.start();
            while (i < start) {
                sb.append(replace$default.charAt(i));
                i++;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m107constructorimpl(sb.append(String.valueOf((char) Integer.parseInt(substring))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m107constructorimpl(ResultKt.createFailure(th));
            }
            i = matcher.end();
        } while (matcher.find());
        int length = replace$default.length();
        while (i < length) {
            sb.append(replace$default.charAt(i));
            i++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
