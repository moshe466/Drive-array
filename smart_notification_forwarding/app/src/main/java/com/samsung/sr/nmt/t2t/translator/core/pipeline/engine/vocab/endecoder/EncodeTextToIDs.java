package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ComputationException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: EncodeTextToIDs.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b \u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0014J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0004J\u001e\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0013\u001a\u00020\u0006H$J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodeTextToIDs;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "unknownCharacterFilteredSequence", JsonProperty.USE_DEFAULT_NAME, "nextConvertStep", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;Ljava/lang/String;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "convertDetails", "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "previousResult", "convertToIds", JsonProperty.USE_DEFAULT_NAME, "token", "encodeDetails", JsonProperty.USE_DEFAULT_NAME, "text", "escapeToken", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class EncodeTextToIDs extends VocabIDsConvertStep<EncodingResult> {
    private static final int EOS = 1;
    private static final int MAX_SUBWORD_LEN = 19;
    private final WordPieceResource resource;
    private final String unknownCharacterFilteredSequence;

    protected abstract void encodeDetails(List<Integer> ids, String text);

    public /* synthetic */ EncodeTextToIDs(WordPieceResource wordPieceResource, String str, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wordPieceResource, str, (i & 4) != 0 ? null : vocabIDsConvertStep);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStep
    public /* bridge */ /* synthetic */ EncodingResult convertDetails(List list, EncodingResult encodingResult) {
        return convertDetails2((List<Integer>) list, encodingResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncodeTextToIDs(WordPieceResource wordPieceResource, String unknownCharacterFilteredSequence, VocabIDsConvertStep<EncodingResult> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(unknownCharacterFilteredSequence, "unknownCharacterFilteredSequence");
        this.resource = wordPieceResource;
        this.unknownCharacterFilteredSequence = unknownCharacterFilteredSequence;
    }

    /* renamed from: convertDetails, reason: avoid collision after fix types in other method */
    protected EncodingResult convertDetails2(List<Integer> ids, EncodingResult previousResult) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(previousResult, "previousResult");
        encodeDetails(ids, StringsKt.trim((CharSequence) this.unknownCharacterFilteredSequence).toString());
        ids.add(1);
        return EncodingResult.copy$default(previousResult, ids, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Integer> convertToIds(String token) {
        boolean z;
        Intrinsics.checkNotNullParameter(token, "token");
        WordPieceResource wordPieceResource = this.resource;
        if (wordPieceResource == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Map<String, Integer> subwordToIds = wordPieceResource.getSubwordToIds();
        int length = token.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < length) {
            int min = Math.min(length, i + 19);
            int i2 = i + 1;
            if (i2 <= min) {
                while (true) {
                    String substring = token.substring(i, min);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Integer num = subwordToIds.get(substring);
                    if (num == null) {
                        if (min == i2) {
                            break;
                        }
                        min--;
                    } else {
                        arrayList.add(num);
                        i = min;
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                throw new ComputationException("No candidate is found in vocab | " + token);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String escapeToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        WordPieceResource wordPieceResource = this.resource;
        if (wordPieceResource == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Set<Character> alphabets = wordPieceResource.getAlphabets();
        StringBuilder sb = new StringBuilder();
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(str, "\\", "\\\\", false, 4, (Object) null), "_", "\\u", false, 4, (Object) null);
        for (int i = 0; i < replace$default.length(); i++) {
            char charAt = replace$default.charAt(i);
            if (alphabets.contains(Character.valueOf(charAt))) {
                sb.append(charAt);
            } else {
                sb.append("\\");
                sb.append((int) charAt);
                sb.append(";");
            }
        }
        sb.append("_");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
