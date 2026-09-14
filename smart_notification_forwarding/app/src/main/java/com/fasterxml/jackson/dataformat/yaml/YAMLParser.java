package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlinx.coroutines.DebugKt;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.MarkedYAMLException;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.ParserImpl;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes.dex */
public class YAMLParser extends ParserBase {
    protected boolean _cfgEmptyStringsToNull;
    protected String _cleanedTextValue;
    protected String _currentAnchor;
    protected String _currentFieldName;
    protected boolean _currentIsAlias;
    protected int _formatFeatures;
    protected Event _lastEvent;
    protected Event _lastTagEvent;
    protected ObjectCodec _objectCodec;
    protected final Reader _reader;
    protected String _textValue;
    protected final ParserImpl _yamlParser;
    protected final Resolver _yamlResolver;

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean canReadObjectId() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean canReadTypeId() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean requiresCustomCodec() {
        return false;
    }

    /* loaded from: classes.dex */
    public enum Feature implements FormatFeature {
        EMPTY_STRING_AS_NULL(true);

        final boolean _defaultState;
        final int _mask = 1 << ordinal();

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

    public YAMLParser(IOContext iOContext, BufferRecycler bufferRecycler, int i, int i2, ObjectCodec objectCodec, Reader reader) {
        super(iOContext, i);
        this._yamlResolver = new Resolver();
        this._objectCodec = objectCodec;
        this._formatFeatures = i2;
        this._reader = reader;
        this._yamlParser = new ParserImpl(new StreamReader(reader));
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(i2);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    public boolean isCurrentAlias() {
        return this._currentIsAlias;
    }

    @Deprecated
    public String getCurrentAnchor() {
        return this._currentAnchor;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return DEFAULT_READ_CAPABILITIES;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _closeInput() throws IOException {
        if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
            this._reader.close();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getFormatFeatures() {
        return this._formatFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser overrideFormatFeatures(int i, int i2) {
        this._formatFeatures = (i & i2) | (this._formatFeatures & (~i2));
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(this._formatFeatures);
        return this;
    }

    public JsonParser enable(Feature feature) {
        this._formatFeatures = feature.getMask() | this._formatFeatures;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(this._formatFeatures);
        return this;
    }

    public JsonParser disable(Feature feature) {
        this._formatFeatures = (~feature.getMask()) & this._formatFeatures;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(this._formatFeatures);
        return this;
    }

    public JsonParser configure(Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    public boolean isEnabled(Feature feature) {
        return (feature.getMask() & this._formatFeatures) != 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        Event event = this._lastEvent;
        if (event == null) {
            return JsonLocation.NA;
        }
        return _locationFor(event.getStartMark());
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        Event event = this._lastEvent;
        if (event == null) {
            return JsonLocation.NA;
        }
        return _locationFor(event.getEndMark());
    }

    protected JsonLocation _locationFor(Mark mark) {
        if (mark == null) {
            return new JsonLocation(this._ioContext.contentReference(), -1L, -1, -1);
        }
        return new JsonLocation(this._ioContext.contentReference(), mark.getIndex(), mark.getLine() + 1, mark.getColumn() + 1);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        this._currentIsAlias = false;
        this._binaryValue = null;
        if (this._closed) {
            return null;
        }
        while (true) {
            try {
                Event event = this._yamlParser.getEvent();
                if (event == null) {
                    this._currentAnchor = null;
                    this._lastTagEvent = null;
                    this._currToken = null;
                    return null;
                }
                this._lastEvent = event;
                if (this._parsingContext.inObject()) {
                    if (this._currToken != JsonToken.FIELD_NAME) {
                        if (!event.is(Event.ID.Scalar)) {
                            this._currentAnchor = null;
                            this._lastTagEvent = null;
                            if (event.is(Event.ID.MappingEnd)) {
                                if (!this._parsingContext.inObject()) {
                                    _reportMismatchedEndMarker(125, ']');
                                }
                                this._parsingContext = this._parsingContext.getParent();
                                JsonToken jsonToken = JsonToken.END_OBJECT;
                                this._currToken = jsonToken;
                                return jsonToken;
                            }
                            _reportError("Expected a field name (Scalar value in YAML), got this instead: " + event);
                        }
                        ScalarEvent scalarEvent = (ScalarEvent) event;
                        String anchor = scalarEvent.getAnchor();
                        boolean z = this._currToken == JsonToken.START_OBJECT;
                        if (anchor != null || !z) {
                            this._currentAnchor = scalarEvent.getAnchor();
                        }
                        if (!z) {
                            this._lastTagEvent = event;
                        }
                        String value = scalarEvent.getValue();
                        this._currentFieldName = value;
                        this._parsingContext.setCurrentName(value);
                        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
                        this._currToken = jsonToken2;
                        return jsonToken2;
                    }
                } else if (this._parsingContext.inArray()) {
                    this._parsingContext.expectComma();
                }
                this._currentAnchor = null;
                this._lastTagEvent = event;
                if (event.is(Event.ID.Scalar)) {
                    JsonToken _decodeScalar = _decodeScalar((ScalarEvent) event);
                    this._currToken = _decodeScalar;
                    return _decodeScalar;
                }
                if (event.is(Event.ID.MappingStart)) {
                    Mark startMark = event.getStartMark();
                    this._currentAnchor = ((MappingStartEvent) event).getAnchor();
                    this._parsingContext = this._parsingContext.createChildObjectContext(startMark.getLine(), startMark.getColumn());
                    JsonToken jsonToken3 = JsonToken.START_OBJECT;
                    this._currToken = jsonToken3;
                    return jsonToken3;
                }
                if (event.is(Event.ID.MappingEnd)) {
                    _reportError("Not expecting END_OBJECT but a value");
                }
                if (event.is(Event.ID.SequenceStart)) {
                    Mark startMark2 = event.getStartMark();
                    this._currentAnchor = ((NodeEvent) event).getAnchor();
                    this._parsingContext = this._parsingContext.createChildArrayContext(startMark2.getLine(), startMark2.getColumn());
                    JsonToken jsonToken4 = JsonToken.START_ARRAY;
                    this._currToken = jsonToken4;
                    return jsonToken4;
                }
                if (event.is(Event.ID.SequenceEnd)) {
                    if (!this._parsingContext.inArray()) {
                        _reportMismatchedEndMarker(93, '}');
                    }
                    this._parsingContext = this._parsingContext.getParent();
                    JsonToken jsonToken5 = JsonToken.END_ARRAY;
                    this._currToken = jsonToken5;
                    return jsonToken5;
                }
                if (!event.is(Event.ID.DocumentEnd) && !event.is(Event.ID.DocumentStart)) {
                    if (event.is(Event.ID.Alias)) {
                        this._currentIsAlias = true;
                        this._textValue = ((AliasEvent) event).getAnchor();
                        this._cleanedTextValue = null;
                        JsonToken jsonToken6 = JsonToken.VALUE_STRING;
                        this._currToken = jsonToken6;
                        return jsonToken6;
                    }
                    if (event.is(Event.ID.StreamEnd)) {
                        close();
                        this._currToken = null;
                        return null;
                    }
                    event.is(Event.ID.StreamStart);
                }
            } catch (YAMLException e) {
                if (e instanceof MarkedYAMLException) {
                    throw com.fasterxml.jackson.dataformat.yaml.snakeyaml.error.MarkedYAMLException.from((JsonParser) this, (MarkedYAMLException) e);
                }
                throw new JacksonYAMLParseException(this, e.getMessage(), e);
            }
        }
    }

    protected JsonToken _decodeScalar(ScalarEvent scalarEvent) throws IOException {
        String value = scalarEvent.getValue();
        this._textValue = value;
        this._cleanedTextValue = null;
        if (!this._cfgEmptyStringsToNull && value.isEmpty()) {
            return JsonToken.VALUE_STRING;
        }
        String tag = scalarEvent.getTag();
        int length = value.length();
        if (tag == null || tag.equals("!")) {
            Tag resolve = this._yamlResolver.resolve(NodeId.scalar, value, scalarEvent.getImplicit().canOmitTagInPlainScalar());
            if (resolve == Tag.STR) {
                return JsonToken.VALUE_STRING;
            }
            if (resolve == Tag.INT) {
                return _decodeNumberScalar(value, length);
            }
            if (resolve == Tag.FLOAT) {
                this._numTypesValid = 0;
                return _cleanYamlFloat(value);
            }
            if (resolve == Tag.BOOL) {
                Boolean _matchYAMLBoolean = _matchYAMLBoolean(value, length);
                if (_matchYAMLBoolean != null) {
                    return _matchYAMLBoolean.booleanValue() ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
                }
            } else {
                if (resolve == Tag.NULL) {
                    return JsonToken.VALUE_NULL;
                }
                return JsonToken.VALUE_STRING;
            }
        } else {
            if (tag.startsWith(Tag.PREFIX)) {
                tag = tag.substring(18);
                if (tag.contains(",")) {
                    tag = tag.split(",")[0];
                }
            }
            if ("binary".equals(tag)) {
                try {
                    this._binaryValue = Base64Variants.MIME.decode(value.trim());
                } catch (IllegalArgumentException e) {
                    _reportError(e.getMessage());
                }
                return JsonToken.VALUE_EMBEDDED_OBJECT;
            }
            if ("bool".equals(tag)) {
                Boolean _matchYAMLBoolean2 = _matchYAMLBoolean(value, length);
                if (_matchYAMLBoolean2 != null) {
                    return _matchYAMLBoolean2.booleanValue() ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
                }
            } else {
                if ("int".equals(tag)) {
                    return _decodeNumberScalar(value, length);
                }
                if ("float".equals(tag)) {
                    this._numTypesValid = 0;
                    return _cleanYamlFloat(value);
                }
                if ("null".equals(tag)) {
                    return JsonToken.VALUE_NULL;
                }
            }
        }
        return JsonToken.VALUE_STRING;
    }

    protected Boolean _matchYAMLBoolean(String str, int i) {
        if (i == 1) {
            char charAt = str.charAt(0);
            if (charAt != 'N') {
                if (charAt != 'Y') {
                    if (charAt != 'n') {
                        if (charAt != 'y') {
                            return null;
                        }
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        if (i == 2) {
            if ("no".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            if (DebugKt.DEBUG_PROPERTY_VALUE_ON.equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            return null;
        }
        if (i == 3) {
            if ("yes".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            return null;
        }
        if (i == 4) {
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            return null;
        }
        if (i == 5 && "false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.fasterxml.jackson.core.JsonToken _decodeNumberScalar(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            char r1 = r9.charAt(r0)
            r2 = 45
            r3 = 0
            r4 = 1
            if (r1 != r2) goto Lf
            r8._numberNegative = r4
        Ld:
            r1 = r4
            goto L1b
        Lf:
            r2 = 43
            if (r1 != r2) goto L18
            r8._numberNegative = r0
            if (r10 != r4) goto Ld
            return r3
        L18:
            r8._numberNegative = r0
            r1 = r0
        L1b:
            if (r10 != r1) goto L1e
            return r3
        L1e:
            char r2 = r9.charAt(r1)
            r3 = 95
            r5 = 48
            if (r2 != r5) goto L65
            int r1 = r1 + r4
            if (r1 != r10) goto L32
            r8._numberInt = r0
            r8._numTypesValid = r4
            com.fasterxml.jackson.core.JsonToken r9 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            return r9
        L32:
            char r0 = r9.charAt(r1)
            r2 = 66
            if (r0 == r2) goto L5d
            r2 = 88
            if (r0 == r2) goto L55
            if (r0 == r3) goto L4e
            r2 = 98
            if (r0 == r2) goto L5d
            r2 = 120(0x78, float:1.68E-43)
            if (r0 == r2) goto L55
            switch(r0) {
                case 48: goto L4e;
                case 49: goto L4e;
                case 50: goto L4e;
                case 51: goto L4e;
                case 52: goto L4e;
                case 53: goto L4e;
                case 54: goto L4e;
                case 55: goto L4e;
                case 56: goto L4e;
                case 57: goto L4e;
                default: goto L4b;
            }
        L4b:
            com.fasterxml.jackson.core.JsonToken r9 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            return r9
        L4e:
            boolean r0 = r8._numberNegative
            com.fasterxml.jackson.core.JsonToken r9 = r8._decodeNumberIntOctal(r9, r1, r10, r0)
            return r9
        L55:
            int r1 = r1 + r4
            boolean r0 = r8._numberNegative
            com.fasterxml.jackson.core.JsonToken r9 = r8._decodeNumberIntHex(r9, r1, r10, r0)
            return r9
        L5d:
            int r1 = r1 + r4
            boolean r0 = r8._numberNegative
            com.fasterxml.jackson.core.JsonToken r9 = r8._decodeNumberIntBinary(r9, r1, r10, r0)
            return r9
        L65:
            r2 = r0
        L66:
            char r6 = r9.charAt(r1)
            r7 = 57
            if (r6 > r7) goto L70
            if (r6 >= r5) goto L73
        L70:
            if (r6 != r3) goto L87
            r2 = r4
        L73:
            int r1 = r1 + 1
            if (r1 != r10) goto L66
            r8._numTypesValid = r0
            if (r2 == 0) goto L80
            com.fasterxml.jackson.core.JsonToken r9 = r8._cleanYamlInt(r9)
            return r9
        L80:
            java.lang.String r9 = r8._textValue
            r8._cleanedTextValue = r9
            com.fasterxml.jackson.core.JsonToken r9 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            return r9
        L87:
            com.fasterxml.jackson.core.JsonToken r9 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.YAMLParser._decodeNumberScalar(java.lang.String, int):com.fasterxml.jackson.core.JsonToken");
    }

    protected JsonToken _decodeNumberIntBinary(String str, int i, int i2, boolean z) {
        String _cleanUnderscores = _cleanUnderscores(str, i, i2);
        int length = _cleanUnderscores.length();
        if (length > 31) {
            if (length <= 63) {
                return _decodeFromLong(Long.parseLong(_cleanUnderscores, 2), z, length == 32);
            }
            return _decodeFromBigInteger(new BigInteger(_cleanUnderscores, 2), z);
        }
        int parseInt = Integer.parseInt(_cleanUnderscores, 2);
        if (z) {
            parseInt = -parseInt;
        }
        this._numberInt = parseInt;
        this._numTypesValid = 1;
        return JsonToken.VALUE_NUMBER_INT;
    }

    protected JsonToken _decodeNumberIntOctal(String str, int i, int i2, boolean z) {
        String _cleanUnderscores = _cleanUnderscores(str, i, i2);
        int length = _cleanUnderscores.length();
        if (length > 10) {
            if (length <= 21) {
                return _decodeFromLong(Long.parseLong(_cleanUnderscores, 8), z, false);
            }
            return _decodeFromBigInteger(new BigInteger(_cleanUnderscores, 8), z);
        }
        int parseInt = Integer.parseInt(_cleanUnderscores, 8);
        if (z) {
            parseInt = -parseInt;
        }
        this._numberInt = parseInt;
        this._numTypesValid = 1;
        return JsonToken.VALUE_NUMBER_INT;
    }

    protected JsonToken _decodeNumberIntHex(String str, int i, int i2, boolean z) {
        String _cleanUnderscores = _cleanUnderscores(str, i, i2);
        int length = _cleanUnderscores.length();
        if (length > 7) {
            if (length <= 15) {
                return _decodeFromLong(Long.parseLong(_cleanUnderscores, 16), z, length == 8);
            }
            return _decodeFromBigInteger(new BigInteger(_cleanUnderscores, 16), z);
        }
        int parseInt = Integer.parseInt(_cleanUnderscores, 16);
        if (z) {
            parseInt = -parseInt;
        }
        this._numberInt = parseInt;
        this._numTypesValid = 1;
        return JsonToken.VALUE_NUMBER_INT;
    }

    private JsonToken _decodeFromLong(long j, boolean z, boolean z2) {
        if (z) {
            j = -j;
            if (z2 && j >= -2147483648L) {
                this._numberInt = (int) j;
                this._numTypesValid = 1;
                return JsonToken.VALUE_NUMBER_INT;
            }
        } else if (z2 && j < 2147483647L) {
            this._numberInt = (int) j;
            this._numTypesValid = 1;
            return JsonToken.VALUE_NUMBER_INT;
        }
        this._numberLong = j;
        this._numTypesValid = 2;
        return JsonToken.VALUE_NUMBER_INT;
    }

    private JsonToken _decodeFromBigInteger(BigInteger bigInteger, boolean z) {
        if (z) {
            this._numberBigInt = bigInteger.negate();
        } else {
            this._numberBigInt = bigInteger;
        }
        this._numTypesValid = 4;
        return JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            return this._textValue;
        }
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this._currentFieldName;
        }
        if (this._currToken == null) {
            return null;
        }
        if (this._currToken.isScalarValue()) {
            return this._textValue;
        }
        return this._currToken.asString();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getCurrentName() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this._currentFieldName;
        }
        return super.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        String text = getText();
        if (text == null) {
            return null;
        }
        return text.toCharArray();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        String text = getText();
        if (text == null) {
            return 0;
        }
        return text.length();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        String text = getText();
        if (text == null) {
            return 0;
        }
        writer.write(text);
        return text.length();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return this._binaryValue;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        byte[] binaryValue = getBinaryValue(base64Variant);
        outputStream.write(binaryValue);
        return binaryValue.length;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _parseNumericValue(int i) throws IOException {
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int length = this._cleanedTextValue.length();
            if (this._numberNegative) {
                length--;
            }
            if (length <= 9) {
                this._numberInt = Integer.parseInt(this._cleanedTextValue);
                this._numTypesValid = 1;
                return;
            }
            if (length <= 18) {
                long parseLong = Long.parseLong(this._cleanedTextValue);
                if (length == 10) {
                    if (this._numberNegative) {
                        if (parseLong >= -2147483648L) {
                            this._numberInt = (int) parseLong;
                            this._numTypesValid = 1;
                            return;
                        }
                    } else if (parseLong <= 2147483647L) {
                        this._numberInt = (int) parseLong;
                        this._numTypesValid = 1;
                        return;
                    }
                }
                this._numberLong = parseLong;
                this._numTypesValid = 2;
                return;
            }
            try {
                BigInteger bigInteger = new BigInteger(this._cleanedTextValue);
                if (length == 19 && bigInteger.bitLength() <= 63) {
                    this._numberLong = bigInteger.longValue();
                    this._numTypesValid = 2;
                    return;
                } else {
                    this._numberBigInt = bigInteger;
                    this._numTypesValid = 4;
                    return;
                }
            } catch (NumberFormatException e) {
                _wrapError("Malformed numeric value '" + this._textValue + "'", e);
            }
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_FLOAT) {
            String str = this._cleanedTextValue;
            try {
                if (i == 16) {
                    this._numberBigDecimal = new BigDecimal(str);
                    this._numTypesValid = 16;
                } else {
                    this._numberDouble = Double.parseDouble(str);
                    this._numTypesValid = 8;
                }
                return;
            } catch (NumberFormatException e2) {
                _wrapError("Malformed numeric value '" + this._textValue + "'", e2);
                return;
            }
        }
        _reportError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.base.ParserBase
    public int _parseIntValue() throws IOException {
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int length = this._cleanedTextValue.length();
            if (this._numberNegative) {
                length--;
            }
            if (length <= 9) {
                this._numTypesValid = 1;
                int parseInt = Integer.parseInt(this._cleanedTextValue);
                this._numberInt = parseInt;
                return parseInt;
            }
        }
        _parseNumericValue(1);
        if ((this._numTypesValid & 1) == 0) {
            convertNumberToInt();
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getObjectId() throws IOException {
        return this._currentAnchor;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getTypeId() throws IOException {
        String tag;
        Event event = this._lastTagEvent;
        if (event instanceof CollectionStartEvent) {
            tag = ((CollectionStartEvent) event).getTag();
        } else {
            if (event instanceof ScalarEvent) {
                tag = ((ScalarEvent) event).getTag();
            }
            return null;
        }
        if (tag != null) {
            while (tag.startsWith("!")) {
                tag = tag.substring(1);
            }
            return tag;
        }
        return null;
    }

    private JsonToken _cleanYamlInt(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = str.charAt(0) == '+' ? 1 : 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '_') {
                sb.append(charAt);
            }
        }
        this._cleanedTextValue = sb.toString();
        return JsonToken.VALUE_NUMBER_INT;
    }

    private String _cleanUnderscores(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '_') {
                sb.append(charAt);
            }
            i++;
        }
        return sb.length() == i2 ? str : sb.toString();
    }

    private JsonToken _cleanYamlFloat(String str) {
        int length = str.length();
        if (str.indexOf(95) < 0 || length == 0) {
            this._cleanedTextValue = str;
            return JsonToken.VALUE_NUMBER_FLOAT;
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = str.charAt(0) == '+' ? 1 : 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '_') {
                sb.append(charAt);
            }
        }
        this._cleanedTextValue = sb.toString();
        return JsonToken.VALUE_NUMBER_FLOAT;
    }
}
