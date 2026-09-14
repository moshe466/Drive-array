package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import org.yaml.snakeyaml.DumperOptions;

/* loaded from: classes.dex */
public class YAMLFactory extends JsonFactory {
    public static final String FORMAT_NAME_YAML = "YAML";
    private static final byte UTF8_BOM_1 = -17;
    private static final byte UTF8_BOM_2 = -69;
    private static final byte UTF8_BOM_3 = -65;
    private static final long serialVersionUID = 1;
    protected final StringQuotingChecker _quotingChecker;
    protected final DumperOptions.Version _version;
    protected int _yamlGeneratorFeatures;
    protected int _yamlParserFeatures;
    protected static final Charset UTF8 = Charset.forName("UTF-8");
    protected static final int DEFAULT_YAML_PARSER_FEATURE_FLAGS = YAMLParser.Feature.collectDefaults();
    protected static final int DEFAULT_YAML_GENERATOR_FEATURE_FLAGS = YAMLGenerator.Feature.collectDefaults();

    @Override // com.fasterxml.jackson.core.JsonFactory
    public boolean canUseCharArrays() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public String getFormatName() {
        return FORMAT_NAME_YAML;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YAMLFactory() {
        this((ObjectCodec) null);
    }

    public YAMLFactory(ObjectCodec objectCodec) {
        super(objectCodec);
        int i = DEFAULT_YAML_PARSER_FEATURE_FLAGS;
        int i2 = DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
        this._yamlParserFeatures = i;
        this._yamlGeneratorFeatures = i2;
        this._version = null;
        this._quotingChecker = StringQuotingChecker.Default.instance();
    }

    public YAMLFactory(YAMLFactory yAMLFactory, ObjectCodec objectCodec) {
        super(yAMLFactory, objectCodec);
        this._yamlParserFeatures = DEFAULT_YAML_PARSER_FEATURE_FLAGS;
        this._yamlGeneratorFeatures = DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
        this._yamlParserFeatures = yAMLFactory._yamlParserFeatures;
        this._yamlGeneratorFeatures = yAMLFactory._yamlGeneratorFeatures;
        this._version = yAMLFactory._version;
        this._quotingChecker = yAMLFactory._quotingChecker;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public YAMLFactory(YAMLFactoryBuilder yAMLFactoryBuilder) {
        super((TSFBuilder<?, ?>) yAMLFactoryBuilder, false);
        this._yamlParserFeatures = DEFAULT_YAML_PARSER_FEATURE_FLAGS;
        this._yamlGeneratorFeatures = DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
        this._yamlGeneratorFeatures = yAMLFactoryBuilder.formatGeneratorFeaturesMask();
        this._version = yAMLFactoryBuilder.yamlVersionToWrite();
        this._quotingChecker = yAMLFactoryBuilder.stringQuotingChecker();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLFactoryBuilder rebuild() {
        return new YAMLFactoryBuilder(this);
    }

    public static YAMLFactoryBuilder builder() {
        return new YAMLFactoryBuilder();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLFactory copy() {
        _checkInvalidCopy(YAMLFactory.class);
        return new YAMLFactory(this, null);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    protected Object readResolve() {
        return new YAMLFactory(this, this._objectCodec);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public Class<YAMLParser.Feature> getFormatReadFeatureType() {
        return YAMLParser.Feature.class;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public Class<YAMLGenerator.Feature> getFormatWriteFeatureType() {
        return YAMLGenerator.Feature.class;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public MatchStrength hasFormat(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte nextByte = inputAccessor.nextByte();
        if (nextByte == -17) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            nextByte = inputAccessor.nextByte();
        }
        if (nextByte == 45 && inputAccessor.hasMoreBytes() && inputAccessor.nextByte() == 45 && inputAccessor.hasMoreBytes() && inputAccessor.nextByte() == 45) {
            return MatchStrength.FULL_MATCH;
        }
        return MatchStrength.INCONCLUSIVE;
    }

    public final YAMLFactory configure(YAMLParser.Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    public YAMLFactory enable(YAMLParser.Feature feature) {
        this._yamlParserFeatures = feature.getMask() | this._yamlParserFeatures;
        return this;
    }

    public YAMLFactory disable(YAMLParser.Feature feature) {
        this._yamlParserFeatures = (~feature.getMask()) & this._yamlParserFeatures;
        return this;
    }

    public final boolean isEnabled(YAMLParser.Feature feature) {
        return (feature.getMask() & this._yamlParserFeatures) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatParserFeatures() {
        return this._yamlParserFeatures;
    }

    public final YAMLFactory configure(YAMLGenerator.Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    public YAMLFactory enable(YAMLGenerator.Feature feature) {
        this._yamlGeneratorFeatures = feature.getMask() | this._yamlGeneratorFeatures;
        return this;
    }

    public YAMLFactory disable(YAMLGenerator.Feature feature) {
        this._yamlGeneratorFeatures = (~feature.getMask()) & this._yamlGeneratorFeatures;
        return this;
    }

    public final boolean isEnabled(YAMLGenerator.Feature feature) {
        return (feature.getMask() & this._yamlGeneratorFeatures) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatGeneratorFeatures() {
        return this._yamlGeneratorFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(String str) throws IOException {
        return createParser((Reader) new StringReader(str));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(File file) throws IOException {
        IOContext _createContext = _createContext(_createContentReference(file), true);
        return _createParser(_decorate(new FileInputStream(file), _createContext), _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(URL url) throws IOException {
        IOContext _createContext = _createContext(_createContentReference(url), true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), _createContext), _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(InputStream inputStream) throws IOException {
        IOContext _createContext = _createContext(_createContentReference(inputStream), false);
        return _createParser(_decorate(inputStream, _createContext), _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(Reader reader) throws IOException {
        IOContext _createContext = _createContext(_createContentReference(reader), false);
        return _createParser(_decorate(reader, _createContext), _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(char[] cArr) throws IOException {
        return createParser(cArr, 0, cArr.length);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(char[] cArr, int i, int i2) throws IOException {
        return createParser((Reader) new CharArrayReader(cArr, i, i2));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(byte[] bArr) throws IOException {
        InputStream decorate;
        IOContext _createContext = _createContext(_createContentReference(bArr), true);
        if (this._inputDecorator != null && (decorate = this._inputDecorator.decorate(_createContext, bArr, 0, bArr.length)) != null) {
            return _createParser(decorate, _createContext);
        }
        return _createParser(bArr, 0, bArr.length, _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(byte[] bArr, int i, int i2) throws IOException {
        InputStream decorate;
        IOContext _createContext = _createContext(_createContentReference(bArr, i, i2), true);
        if (this._inputDecorator != null && (decorate = this._inputDecorator.decorate(_createContext, bArr, i, i2)) != null) {
            return _createParser(decorate, _createContext);
        }
        return _createParser(bArr, i, i2, _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        IOContext _createContext = _createContext(_createContentReference(outputStream), false);
        _createContext.setEncoding(jsonEncoding);
        return _createGenerator(_createWriter(_decorate(outputStream, _createContext), jsonEncoding, _createContext), _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(OutputStream outputStream) throws IOException {
        IOContext _createContext = _createContext(_createContentReference(outputStream), false);
        return _createGenerator(_createWriter(_decorate(outputStream, _createContext), JsonEncoding.UTF8, _createContext), _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(Writer writer) throws IOException {
        IOContext _createContext = _createContext(_createContentReference(writer), false);
        return _createGenerator(_decorate(writer, _createContext), _createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOContext _createContext = _createContext(_createContentReference(file), true);
        _createContext.setEncoding(jsonEncoding);
        return _createGenerator(_createWriter(_decorate(fileOutputStream, _createContext), jsonEncoding, _createContext), _createContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(InputStream inputStream, IOContext iOContext) throws IOException {
        return new YAMLParser(iOContext, _getBufferRecycler(), this._parserFeatures, this._yamlParserFeatures, this._objectCodec, _createReader(inputStream, null, iOContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(Reader reader, IOContext iOContext) throws IOException {
        return new YAMLParser(iOContext, _getBufferRecycler(), this._parserFeatures, this._yamlParserFeatures, this._objectCodec, reader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(char[] cArr, int i, int i2, IOContext iOContext, boolean z) throws IOException {
        return new YAMLParser(iOContext, _getBufferRecycler(), this._parserFeatures, this._yamlParserFeatures, this._objectCodec, new CharArrayReader(cArr, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(byte[] bArr, int i, int i2, IOContext iOContext) throws IOException {
        return new YAMLParser(iOContext, _getBufferRecycler(), this._parserFeatures, this._yamlParserFeatures, this._objectCodec, _createReader(bArr, i, i2, null, iOContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLGenerator _createGenerator(Writer writer, IOContext iOContext) throws IOException {
        return new YAMLGenerator(iOContext, this._generatorFeatures, this._yamlGeneratorFeatures, this._quotingChecker, this._objectCodec, writer, this._version);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLGenerator _createUTF8Generator(OutputStream outputStream, IOContext iOContext) throws IOException {
        throw new IllegalStateException();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    protected Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Writer(outputStream);
        }
        return new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    protected Reader _createReader(InputStream inputStream, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        if (jsonEncoding == null) {
            jsonEncoding = JsonEncoding.UTF8;
        }
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Reader(inputStream, iOContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE));
        }
        return new InputStreamReader(inputStream, jsonEncoding.getJavaName());
    }

    protected Reader _createReader(byte[] bArr, int i, int i2, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        if (jsonEncoding == null) {
            jsonEncoding = JsonEncoding.UTF8;
        }
        if (jsonEncoding == null || jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Reader(bArr, i, i2, true);
        }
        return new InputStreamReader(new ByteArrayInputStream(bArr, i, i2), jsonEncoding.getJavaName());
    }
}
