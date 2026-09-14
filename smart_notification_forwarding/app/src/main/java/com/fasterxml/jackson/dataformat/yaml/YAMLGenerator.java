package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.StreamWriteCapability;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.emitter.Emitter;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes.dex */
public class YAMLGenerator extends GeneratorBase {
    private static final ImplicitTuple EXPLICIT_TAGS;
    protected static final long MAX_INT_AS_LONG = 2147483647L;
    protected static final long MIN_INT_AS_LONG = -2147483648L;
    private static final ImplicitTuple NO_TAGS;
    private static final DumperOptions.ScalarStyle STYLE_BASE64;
    private static final DumperOptions.ScalarStyle STYLE_LITERAL;
    private static final DumperOptions.ScalarStyle STYLE_PLAIN;
    protected final DumperOptions.Version _docVersion;
    protected Emitter _emitter;
    protected int _formatFeatures;
    protected final IOContext _ioContext;
    protected String _objectId;
    protected DumperOptions _outputOptions;
    protected final StringQuotingChecker _quotingChecker;
    protected int _rootValueCount;
    protected String _typeId;
    protected Writer _writer;
    protected static final Pattern PLAIN_NUMBER_P = Pattern.compile("-?[0-9]*(\\.[0-9]*)?");
    protected static final String TAG_BINARY = Tag.BINARY.toString();
    private static final DumperOptions.ScalarStyle STYLE_UNQUOTED_NAME = DumperOptions.ScalarStyle.PLAIN;
    private static final DumperOptions.ScalarStyle STYLE_SCALAR = DumperOptions.ScalarStyle.PLAIN;
    private static final DumperOptions.ScalarStyle STYLE_QUOTED = DumperOptions.ScalarStyle.DOUBLE_QUOTED;

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected void _releaseBuffers() {
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canUseSchema(FormatSchema formatSchema) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteFormattedNumbers() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return -1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public YAMLGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        return this;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public YAMLGenerator useDefaultPrettyPrinter() {
        return this;
    }

    /* loaded from: classes.dex */
    public enum Feature implements FormatFeature {
        WRITE_DOC_START_MARKER(true),
        USE_NATIVE_OBJECT_ID(true),
        USE_NATIVE_TYPE_ID(true),
        CANONICAL_OUTPUT(false),
        SPLIT_LINES(true),
        MINIMIZE_QUOTES(false),
        ALWAYS_QUOTE_NUMBERS_AS_STRINGS(false),
        LITERAL_BLOCK_STYLE(false),
        INDENT_ARRAYS(false),
        INDENT_ARRAYS_WITH_INDICATOR(false),
        USE_PLATFORM_LINE_BREAKS(false);

        protected final boolean _defaultState;
        protected final int _mask = 1 << ordinal();

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        Feature(boolean z) {
            this._defaultState = z;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledByDefault() {
            return this._defaultState;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledIn(int i) {
            return (i & this._mask) != 0;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public int getMask() {
            return this._mask;
        }
    }

    static {
        DumperOptions.ScalarStyle scalarStyle = DumperOptions.ScalarStyle.LITERAL;
        STYLE_LITERAL = scalarStyle;
        STYLE_BASE64 = scalarStyle;
        STYLE_PLAIN = DumperOptions.ScalarStyle.PLAIN;
        NO_TAGS = new ImplicitTuple(true, true);
        EXPLICIT_TAGS = new ImplicitTuple(false, false);
    }

    public YAMLGenerator(IOContext iOContext, int i, int i2, StringQuotingChecker stringQuotingChecker, ObjectCodec objectCodec, Writer writer, DumperOptions.Version version) throws IOException {
        super(i, objectCodec);
        this._ioContext = iOContext;
        this._formatFeatures = i2;
        this._quotingChecker = stringQuotingChecker == null ? StringQuotingChecker.Default.instance() : stringQuotingChecker;
        this._writer = writer;
        this._docVersion = version;
        this._outputOptions = buildDumperOptions(i, i2, version);
        this._emitter = new Emitter(this._writer, this._outputOptions);
        _emit(new StreamStartEvent(null, null));
        _emitStartDocument();
    }

    @Deprecated
    public YAMLGenerator(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, Writer writer, DumperOptions.Version version) throws IOException {
        this(iOContext, i, i2, null, objectCodec, writer, version);
    }

    protected DumperOptions buildDumperOptions(int i, int i2, DumperOptions.Version version) {
        DumperOptions dumperOptions = new DumperOptions();
        if (Feature.CANONICAL_OUTPUT.enabledIn(this._formatFeatures)) {
            dumperOptions.setCanonical(true);
        } else {
            dumperOptions.setCanonical(false);
            dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        }
        dumperOptions.setSplitLines(Feature.SPLIT_LINES.enabledIn(this._formatFeatures));
        if (Feature.INDENT_ARRAYS.enabledIn(this._formatFeatures)) {
            dumperOptions.setIndicatorIndent(1);
            dumperOptions.setIndent(2);
        }
        if (Feature.INDENT_ARRAYS_WITH_INDICATOR.enabledIn(this._formatFeatures)) {
            dumperOptions.setIndicatorIndent(2);
            dumperOptions.setIndentWithIndicator(true);
        }
        if (Feature.USE_PLATFORM_LINE_BREAKS.enabledIn(this._formatFeatures)) {
            dumperOptions.setLineBreak(DumperOptions.LineBreak.getPlatformLineBreak());
        }
        return dumperOptions;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._writer;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getFormatFeatures() {
        return this._formatFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideFormatFeatures(int i, int i2) {
        this._formatFeatures = (i & i2) | (this._formatFeatures & (~i2));
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return DEFAULT_TEXTUAL_WRITE_CAPABILITIES;
    }

    public YAMLGenerator enable(Feature feature) {
        this._formatFeatures = feature.getMask() | this._formatFeatures;
        return this;
    }

    public YAMLGenerator disable(Feature feature) {
        this._formatFeatures = (~feature.getMask()) & this._formatFeatures;
        return this;
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.getMask() & this._formatFeatures) != 0;
    }

    public YAMLGenerator configure(Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(String str) throws IOException {
        if (this._writeContext.writeFieldName(str) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(str);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(SerializableString serializableString) throws IOException {
        if (this._writeContext.writeFieldName(serializableString.getValue()) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializableString.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldId(long j) throws IOException {
        String l = Long.valueOf(j).toString();
        if (this._writeContext.writeFieldName(l) == 4) {
            _reportError("Can not write a field id, expecting a value");
        }
        _writeScalar(l, "int", STYLE_SCALAR);
    }

    private final void _writeFieldName(String str) throws IOException {
        _writeScalar(str, "string", this._quotingChecker.needToQuoteName(str) ? STYLE_QUOTED : STYLE_UNQUOTED_NAME);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() throws IOException {
        if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._writer.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isClosed()) {
            return;
        }
        _emitEndDocument();
        _emit(new StreamEndEvent(null, null));
        super.close();
        if (this._writer != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this._writer.close();
            } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this._writer.flush();
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        DumperOptions.FlowStyle defaultFlowStyle = this._outputOptions.getDefaultFlowStyle();
        String str = this._typeId;
        boolean z = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new SequenceStartEvent(str2, str, z, (Mark) null, (Mark) null, defaultFlowStyle));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not Array but " + this._writeContext.typeDesc());
        }
        this._typeId = null;
        this._writeContext = this._writeContext.getParent();
        _emit(new SequenceEndEvent(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        DumperOptions.FlowStyle defaultFlowStyle = this._outputOptions.getDefaultFlowStyle();
        String str = this._typeId;
        boolean z = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new MappingStartEvent(str2, str, z, (Mark) null, (Mark) null, defaultFlowStyle));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not Object but " + this._writeContext.typeDesc());
        }
        this._typeId = null;
        this._writeContext = this._writeContext.getParent();
        _emit(new MappingEndEvent(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException, JsonGenerationException {
        DumperOptions.ScalarStyle scalarStyle;
        if (str == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write String value");
        if (str.isEmpty()) {
            _writeScalar(str, "string", STYLE_QUOTED);
            return;
        }
        if (Feature.MINIMIZE_QUOTES.enabledIn(this._formatFeatures)) {
            if (str.indexOf(10) >= 0) {
                scalarStyle = STYLE_LITERAL;
            } else if (this._quotingChecker.needToQuoteValue(str) || (Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS.enabledIn(this._formatFeatures) && PLAIN_NUMBER_P.matcher(str).matches())) {
                scalarStyle = STYLE_QUOTED;
            } else {
                scalarStyle = STYLE_PLAIN;
            }
        } else if (Feature.LITERAL_BLOCK_STYLE.enabledIn(this._formatFeatures) && str.indexOf(10) >= 0) {
            scalarStyle = STYLE_LITERAL;
        } else {
            scalarStyle = STYLE_QUOTED;
        }
        _writeScalar(str, "string", scalarStyle);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) throws IOException {
        writeString(new String(cArr, i, i2));
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws IOException {
        writeString(serializableString.toString());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        writeString(new String(bArr, i, i2, "UTF-8"));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i2) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i, int i2) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i2) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write Binary value");
        if (i > 0 || i + i2 != bArr.length) {
            bArr = Arrays.copyOfRange(bArr, i, i2 + i);
        }
        _writeScalarBinary(base64Variant, bArr);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z) throws IOException {
        _verifyValueWrite("write boolean value");
        _writeScalar(z ? "true" : "false", "bool", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(i), "int", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j) throws IOException {
        if (j <= MAX_INT_AS_LONG && j >= MIN_INT_AS_LONG) {
            writeNumber((int) j);
        } else {
            _verifyValueWrite("write number");
            _writeScalar(String.valueOf(j), "long", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(String.valueOf(bigInteger.toString()), "java.math.BigInteger", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(d), "double", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(f), "float", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(isEnabled(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) ? bigDecimal.toPlainString() : bigDecimal.toString(), "java.math.BigDecimal", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException, JsonGenerationException, UnsupportedOperationException {
        if (str == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(str, "number", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write null value");
        _writeScalar("null", "object", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteObjectId() {
        return Feature.USE_NATIVE_OBJECT_ID.enabledIn(this._formatFeatures);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteTypeId() {
        return Feature.USE_NATIVE_TYPE_ID.enabledIn(this._formatFeatures);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) throws IOException {
        this._typeId = String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws IOException {
        _verifyValueWrite("write Object reference");
        _emit(new AliasEvent(String.valueOf(obj), null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) throws IOException {
        this._objectId = obj == null ? null : String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected final void _verifyValueWrite(String str) throws IOException {
        if (this._writeContext.writeValue() == 5) {
            _reportError("Can not " + str + ", expecting field name");
        }
        if (!this._writeContext.inRoot() || this._writeContext.getCurrentIndex() <= 0) {
            return;
        }
        _emitEndDocument();
        _emitStartDocument();
    }

    protected void _writeScalar(String str, String str2, DumperOptions.ScalarStyle scalarStyle) throws IOException {
        _emit(_scalarEvent(str, scalarStyle));
    }

    private void _writeScalarBinary(Base64Variant base64Variant, byte[] bArr) throws IOException {
        if (base64Variant == Base64Variants.getDefaultVariant()) {
            base64Variant = Base64Variants.MIME;
        }
        _emit(new ScalarEvent((String) null, TAG_BINARY, EXPLICIT_TAGS, _base64encode(base64Variant, bArr, _lf()), (Mark) null, (Mark) null, STYLE_BASE64));
    }

    protected ScalarEvent _scalarEvent(String str, DumperOptions.ScalarStyle scalarStyle) {
        String str2 = this._typeId;
        if (str2 != null) {
            this._typeId = null;
        }
        String str3 = this._objectId;
        if (str3 != null) {
            this._objectId = null;
        }
        return new ScalarEvent(str3, str2, NO_TAGS, str, (Mark) null, (Mark) null, scalarStyle);
    }

    private String _base64encode(Base64Variant base64Variant, byte[] bArr, String str) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i = length - 3;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i2] << 8) | (bArr[i3] & UByte.MAX_VALUE)) << 8;
            int i6 = i4 + 1;
            base64Variant.encodeBase64Chunk(sb, i5 | (bArr[i4] & UByte.MAX_VALUE));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append(str);
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            i2 = i6;
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i2 + 1;
            int i9 = bArr[i2] << 16;
            if (i7 == 2) {
                i9 |= (bArr[i8] & UByte.MAX_VALUE) << 8;
            }
            base64Variant.encodeBase64Partial(sb, i9, i7);
        }
        return sb.toString();
    }

    protected String _lf() {
        return this._outputOptions.getLineBreak().getString();
    }

    protected void _emitStartDocument() throws IOException {
        _emit(new DocumentStartEvent(null, null, Feature.WRITE_DOC_START_MARKER.enabledIn(this._formatFeatures), this._docVersion, Collections.emptyMap()));
    }

    protected void _emitEndDocument() throws IOException {
        _emit(new DocumentEndEvent(null, null, false));
    }

    protected final void _emit(Event event) throws IOException {
        this._emitter.emit(event);
    }
}
