package org.yaml.snakeyaml.parser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CommentEvent;
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
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.util.ArrayStack;

/* loaded from: classes2.dex */
public class ParserImpl implements Parser {
    private static final Map<String, String> DEFAULT_TAGS;
    private Event currentEvent;
    private VersionTagsTuple directives;
    private final ArrayStack<Mark> marks;
    protected final Scanner scanner;
    private Production state;
    private final ArrayStack<Production> states;

    static {
        HashMap hashMap = new HashMap();
        DEFAULT_TAGS = hashMap;
        hashMap.put("!", "!");
        hashMap.put("!!", Tag.PREFIX);
    }

    public ParserImpl(StreamReader streamReader) {
        this(new ScannerImpl(streamReader));
    }

    public ParserImpl(StreamReader streamReader, boolean z) {
        this(new ScannerImpl(streamReader).setParseComments(z));
    }

    public ParserImpl(Scanner scanner) {
        this.scanner = scanner;
        this.currentEvent = null;
        this.directives = new VersionTagsTuple(null, new HashMap(DEFAULT_TAGS));
        this.states = new ArrayStack<>(100);
        this.marks = new ArrayStack<>(10);
        this.state = new ParseStreamStart();
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public boolean checkEvent(Event.ID id) {
        peekEvent();
        Event event = this.currentEvent;
        return event != null && event.is(id);
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public Event peekEvent() {
        Production production;
        if (this.currentEvent == null && (production = this.state) != null) {
            this.currentEvent = production.produce();
        }
        return this.currentEvent;
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public Event getEvent() {
        peekEvent();
        Event event = this.currentEvent;
        this.currentEvent = null;
        return event;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CommentEvent produceCommentEvent(CommentToken commentToken) {
        Mark startMark = commentToken.getStartMark();
        Mark endMark = commentToken.getEndMark();
        return new CommentEvent(commentToken.getCommentType(), commentToken.getValue(), startMark, endMark);
    }

    /* loaded from: classes2.dex */
    private class ParseStreamStart implements Production {
        private ParseStreamStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            StreamStartToken streamStartToken = (StreamStartToken) ParserImpl.this.scanner.getToken();
            StreamStartEvent streamStartEvent = new StreamStartEvent(streamStartToken.getStartMark(), streamStartToken.getEndMark());
            ParserImpl.this.state = new ParseImplicitDocumentStart();
            return streamStartEvent;
        }
    }

    /* loaded from: classes2.dex */
    private class ParseImplicitDocumentStart implements Production {
        private ParseImplicitDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseImplicitDocumentStart();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
                DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, startMark, false, null, null);
                ParserImpl.this.states.push(new ParseDocumentEnd());
                ParserImpl.this.state = new ParseBlockNode();
                return documentStartEvent;
            }
            return new ParseDocumentStart().produce();
        }
    }

    /* loaded from: classes2.dex */
    private class ParseDocumentStart implements Production {
        private ParseDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            while (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                ParserImpl.this.scanner.getToken();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
                VersionTagsTuple processDirectives = ParserImpl.this.processDirectives();
                while (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                    ParserImpl.this.scanner.getToken();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.DocumentStart)) {
                        throw new ParserException(null, null, "expected '<document start>', but found '" + ParserImpl.this.scanner.peekToken().getTokenId() + "'", ParserImpl.this.scanner.peekToken().getStartMark());
                    }
                    DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, ParserImpl.this.scanner.getToken().getEndMark(), true, processDirectives.getVersion(), processDirectives.getTags());
                    ParserImpl.this.states.push(new ParseDocumentEnd());
                    ParserImpl.this.state = new ParseDocumentContent();
                    return documentStartEvent;
                }
            }
            StreamEndToken streamEndToken = (StreamEndToken) ParserImpl.this.scanner.getToken();
            StreamEndEvent streamEndEvent = new StreamEndEvent(streamEndToken.getStartMark(), streamEndToken.getEndMark());
            if (ParserImpl.this.states.isEmpty()) {
                if (ParserImpl.this.marks.isEmpty()) {
                    ParserImpl.this.state = null;
                    return streamEndEvent;
                }
                throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.this.marks);
            }
            throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.this.states);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseDocumentEnd implements Production {
        private ParseDocumentEnd() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            Mark mark;
            Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
            boolean z = true;
            if (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                mark = ParserImpl.this.scanner.getToken().getEndMark();
            } else {
                mark = startMark;
                z = false;
            }
            DocumentEndEvent documentEndEvent = new DocumentEndEvent(startMark, mark, z);
            ParserImpl.this.state = new ParseDocumentStart();
            return documentEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseDocumentContent implements Production {
        private ParseDocumentContent() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseDocumentContent();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                ParserImpl parserImpl3 = ParserImpl.this;
                Event processEmptyScalar = parserImpl3.processEmptyScalar(parserImpl3.scanner.peekToken().getStartMark());
                ParserImpl parserImpl4 = ParserImpl.this;
                parserImpl4.state = (Production) parserImpl4.states.pop();
                return processEmptyScalar;
            }
            return new ParseBlockNode().produce();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VersionTagsTuple processDirectives() {
        HashMap hashMap = new HashMap(this.directives.getTags());
        Iterator<String> it = DEFAULT_TAGS.keySet().iterator();
        while (it.hasNext()) {
            hashMap.remove(it.next());
        }
        this.directives = new VersionTagsTuple(null, hashMap);
        while (this.scanner.checkToken(Token.ID.Directive)) {
            DirectiveToken directiveToken = (DirectiveToken) this.scanner.getToken();
            if (directiveToken.getName().equals(YAMLFactory.FORMAT_NAME_YAML)) {
                if (this.directives.getVersion() != null) {
                    throw new ParserException(null, null, "found duplicate YAML directive", directiveToken.getStartMark());
                }
                List value = directiveToken.getValue();
                if (((Integer) value.get(0)).intValue() != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", directiveToken.getStartMark());
                }
                if (((Integer) value.get(1)).intValue() == 0) {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_0, hashMap);
                } else {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_1, hashMap);
                }
            } else if (directiveToken.getName().equals("TAG")) {
                List value2 = directiveToken.getValue();
                String str = (String) value2.get(0);
                String str2 = (String) value2.get(1);
                if (hashMap.containsKey(str)) {
                    throw new ParserException(null, null, "duplicate tag handle " + str, directiveToken.getStartMark());
                }
                hashMap.put(str, str2);
            } else {
                continue;
            }
        }
        HashMap hashMap2 = new HashMap();
        if (!hashMap.isEmpty()) {
            hashMap2 = new HashMap(hashMap);
        }
        for (String str3 : DEFAULT_TAGS.keySet()) {
            if (!hashMap.containsKey(str3)) {
                hashMap.put(str3, DEFAULT_TAGS.get(str3));
            }
        }
        return new VersionTagsTuple(this.directives.getVersion(), hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseBlockNode implements Production {
        private ParseBlockNode() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            return ParserImpl.this.parseNode(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseFlowNode() {
        return parseNode(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseBlockNodeOrIndentlessSequence() {
        return parseNode(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseNode(boolean z, boolean z2) {
        Mark mark;
        TagTuple tagTuple;
        Mark mark2;
        Mark mark3;
        String str;
        String str2;
        Mark mark4;
        Mark mark5;
        ImplicitTuple implicitTuple;
        if (this.scanner.checkToken(Token.ID.Alias)) {
            AliasToken aliasToken = (AliasToken) this.scanner.getToken();
            AliasEvent aliasEvent = new AliasEvent(aliasToken.getValue(), aliasToken.getStartMark(), aliasToken.getEndMark());
            this.state = this.states.pop();
            return aliasEvent;
        }
        if (this.scanner.checkToken(Token.ID.Anchor)) {
            AnchorToken anchorToken = (AnchorToken) this.scanner.getToken();
            mark = anchorToken.getStartMark();
            Mark endMark = anchorToken.getEndMark();
            String value = anchorToken.getValue();
            if (this.scanner.checkToken(Token.ID.Tag)) {
                TagToken tagToken = (TagToken) this.scanner.getToken();
                mark2 = tagToken.getStartMark();
                mark3 = tagToken.getEndMark();
                tagTuple = tagToken.getValue();
            } else {
                mark2 = null;
                mark3 = endMark;
                tagTuple = null;
            }
            str = value;
        } else if (this.scanner.checkToken(Token.ID.Tag)) {
            TagToken tagToken2 = (TagToken) this.scanner.getToken();
            mark = tagToken2.getStartMark();
            mark3 = tagToken2.getEndMark();
            tagTuple = tagToken2.getValue();
            if (this.scanner.checkToken(Token.ID.Anchor)) {
                AnchorToken anchorToken2 = (AnchorToken) this.scanner.getToken();
                mark3 = anchorToken2.getEndMark();
                str = anchorToken2.getValue();
            } else {
                str = null;
            }
            mark2 = mark;
        } else {
            mark = null;
            tagTuple = null;
            mark2 = null;
            mark3 = null;
            str = null;
        }
        if (tagTuple != null) {
            String handle = tagTuple.getHandle();
            String suffix = tagTuple.getSuffix();
            if (handle == null) {
                str2 = suffix;
            } else {
                if (!this.directives.getTags().containsKey(handle)) {
                    throw new ParserException("while parsing a node", mark, "found undefined tag handle " + handle, mark2);
                }
                str2 = this.directives.getTags().get(handle) + suffix;
            }
        } else {
            str2 = null;
        }
        if (mark == null) {
            mark4 = this.scanner.peekToken().getStartMark();
            mark5 = mark4;
        } else {
            mark4 = mark;
            mark5 = mark3;
        }
        boolean z3 = str2 == null || str2.equals("!");
        if (z2 && this.scanner.checkToken(Token.ID.BlockEntry)) {
            SequenceStartEvent sequenceStartEvent = new SequenceStartEvent(str, str2, z3, mark4, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.BLOCK);
            this.state = new ParseIndentlessSequenceEntryKey();
            return sequenceStartEvent;
        }
        if (this.scanner.checkToken(Token.ID.Scalar)) {
            ScalarToken scalarToken = (ScalarToken) this.scanner.getToken();
            Mark endMark2 = scalarToken.getEndMark();
            if ((scalarToken.getPlain() && str2 == null) || "!".equals(str2)) {
                implicitTuple = new ImplicitTuple(true, false);
            } else if (str2 == null) {
                implicitTuple = new ImplicitTuple(false, true);
            } else {
                implicitTuple = new ImplicitTuple(false, false);
            }
            ScalarEvent scalarEvent = new ScalarEvent(str, str2, implicitTuple, scalarToken.getValue(), mark4, endMark2, scalarToken.getStyle());
            this.state = this.states.pop();
            return scalarEvent;
        }
        if (this.scanner.checkToken(Token.ID.FlowSequenceStart)) {
            SequenceStartEvent sequenceStartEvent2 = new SequenceStartEvent(str, str2, z3, mark4, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.FLOW);
            this.state = new ParseFlowSequenceFirstEntry();
            return sequenceStartEvent2;
        }
        if (this.scanner.checkToken(Token.ID.FlowMappingStart)) {
            MappingStartEvent mappingStartEvent = new MappingStartEvent(str, str2, z3, mark4, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.FLOW);
            this.state = new ParseFlowMappingFirstKey();
            return mappingStartEvent;
        }
        if (z && this.scanner.checkToken(Token.ID.BlockSequenceStart)) {
            SequenceStartEvent sequenceStartEvent3 = new SequenceStartEvent(str, str2, z3, mark4, this.scanner.peekToken().getStartMark(), DumperOptions.FlowStyle.BLOCK);
            this.state = new ParseBlockSequenceFirstEntry();
            return sequenceStartEvent3;
        }
        if (z && this.scanner.checkToken(Token.ID.BlockMappingStart)) {
            MappingStartEvent mappingStartEvent2 = new MappingStartEvent(str, str2, z3, mark4, this.scanner.peekToken().getStartMark(), DumperOptions.FlowStyle.BLOCK);
            this.state = new ParseBlockMappingFirstKey();
            return mappingStartEvent2;
        }
        if (str != null || str2 != null) {
            ScalarEvent scalarEvent2 = new ScalarEvent(str, str2, new ImplicitTuple(z3, false), JsonProperty.USE_DEFAULT_NAME, mark4, mark5, DumperOptions.ScalarStyle.PLAIN);
            this.state = this.states.pop();
            return scalarEvent2;
        }
        Token peekToken = this.scanner.peekToken();
        throw new ParserException("while parsing a " + (z ? "block" : "flow") + " node", mark4, "expected the node content, but found '" + peekToken.getTokenId() + "'", peekToken.getStartMark());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseBlockSequenceFirstEntry implements Production {
        private ParseBlockSequenceFirstEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockSequenceEntryKey().produce();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseBlockSequenceEntryKey implements Production {
        private ParseBlockSequenceEntryKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseBlockSequenceEntryKey();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                return new ParseBlockSequenceEntryValue((BlockEntryToken) ParserImpl.this.scanner.getToken()).produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token peekToken = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block collection", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found '" + peekToken.getTokenId() + "'", peekToken.getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl parserImpl3 = ParserImpl.this;
            parserImpl3.state = (Production) parserImpl3.states.pop();
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseBlockSequenceEntryValue implements Production {
        BlockEntryToken token;

        public ParseBlockSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseBlockSequenceEntryValue(this.token);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseBlockSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseBlockSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseIndentlessSequenceEntryKey implements Production {
        private ParseIndentlessSequenceEntryKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseIndentlessSequenceEntryKey();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                return new ParseIndentlessSequenceEntryValue((BlockEntryToken) ParserImpl.this.scanner.getToken()).produce();
            }
            Token peekToken = ParserImpl.this.scanner.peekToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(peekToken.getStartMark(), peekToken.getEndMark());
            ParserImpl parserImpl3 = ParserImpl.this;
            parserImpl3.state = (Production) parserImpl3.states.pop();
            return sequenceEndEvent;
        }
    }

    /* loaded from: classes2.dex */
    private class ParseIndentlessSequenceEntryValue implements Production {
        BlockEntryToken token;

        public ParseIndentlessSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseIndentlessSequenceEntryValue(this.token);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseIndentlessSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseIndentlessSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseBlockMappingFirstKey implements Production {
        private ParseBlockMappingFirstKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockMappingKey().produce();
        }
    }

    /* loaded from: classes2.dex */
    private class ParseBlockMappingKey implements Production {
        private ParseBlockMappingKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseBlockMappingKey();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingValue());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingValue();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token peekToken = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block mapping", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found '" + peekToken.getTokenId() + "'", peekToken.getStartMark());
            }
            Token token2 = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl parserImpl3 = ParserImpl.this;
            parserImpl3.state = (Production) parserImpl3.states.pop();
            ParserImpl.this.marks.pop();
            return mappingEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseBlockMappingValue implements Production {
        private ParseBlockMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                if (ParserImpl.this.scanner.checkToken(Token.ID.Scalar)) {
                    ParserImpl.this.states.push(new ParseBlockMappingKey());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockMappingValueComment();
                return ParserImpl.this.state.produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseBlockMappingKey());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            ParserImpl.this.state = new ParseBlockMappingKey();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    /* loaded from: classes2.dex */
    private class ParseBlockMappingValueComment implements Production {
        List<CommentToken> tokens;

        private ParseBlockMappingValueComment() {
            this.tokens = new LinkedList();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                this.tokens.add((CommentToken) ParserImpl.this.scanner.getToken());
                return produce();
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.state = new ParseBlockMappingValueCommentList(this.tokens);
                ParserImpl parserImpl = ParserImpl.this;
                return parserImpl.processEmptyScalar(parserImpl.scanner.peekToken().getStartMark());
            }
            if (!this.tokens.isEmpty()) {
                return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
            }
            ParserImpl.this.states.push(new ParseBlockMappingKey());
            return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
        }
    }

    /* loaded from: classes2.dex */
    private class ParseBlockMappingValueCommentList implements Production {
        List<CommentToken> tokens;

        public ParseBlockMappingValueCommentList(List<CommentToken> list) {
            this.tokens = list;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!this.tokens.isEmpty()) {
                return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
            }
            return new ParseBlockMappingKey().produce();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseFlowSequenceFirstEntry implements Production {
        private ParseFlowSequenceFirstEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseFlowSequenceEntry(true).produce();
        }
    }

    /* loaded from: classes2.dex */
    private class ParseFlowSequenceEntry implements Production {
        private final boolean first;

        public ParseFlowSequenceEntry(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseFlowSequenceEntry(this.first);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl parserImpl3 = ParserImpl.this;
                            parserImpl3.state = new ParseFlowSequenceEntry(true);
                            ParserImpl parserImpl4 = ParserImpl.this;
                            return parserImpl4.produceCommentEvent((CommentToken) parserImpl4.scanner.getToken());
                        }
                    } else {
                        Token peekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow sequence", (Mark) ParserImpl.this.marks.pop(), "expected ',' or ']', but got " + peekToken.getTokenId(), peekToken.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token peekToken2 = ParserImpl.this.scanner.peekToken();
                    MappingStartEvent mappingStartEvent = new MappingStartEvent((String) null, (String) null, true, peekToken2.getStartMark(), peekToken2.getEndMark(), DumperOptions.FlowStyle.FLOW);
                    ParserImpl.this.state = new ParseFlowSequenceEntryMappingKey();
                    return mappingStartEvent;
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowEndComment();
            } else {
                ParserImpl parserImpl5 = ParserImpl.this;
                parserImpl5.state = (Production) parserImpl5.states.pop();
            }
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseFlowEndComment implements Production {
        private ParseFlowEndComment() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl parserImpl = ParserImpl.this;
            CommentEvent produceCommentEvent = parserImpl.produceCommentEvent((CommentToken) parserImpl.scanner.getToken());
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl2 = ParserImpl.this;
                parserImpl2.state = (Production) parserImpl2.states.pop();
            }
            return produceCommentEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseFlowSequenceEntryMappingKey implements Production {
        private ParseFlowSequenceEntryMappingKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingValue());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingValue();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    /* loaded from: classes2.dex */
    private class ParseFlowSequenceEntryMappingValue implements Production {
        private ParseFlowSequenceEntryMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingEnd());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    /* loaded from: classes2.dex */
    private class ParseFlowSequenceEntryMappingEnd implements Production {
        private ParseFlowSequenceEntryMappingEnd() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.state = new ParseFlowSequenceEntry(false);
            Token peekToken = ParserImpl.this.scanner.peekToken();
            return new MappingEndEvent(peekToken.getStartMark(), peekToken.getEndMark());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseFlowMappingFirstKey implements Production {
        private ParseFlowMappingFirstKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseFlowMappingKey(true).produce();
        }
    }

    /* loaded from: classes2.dex */
    private class ParseFlowMappingKey implements Production {
        private final boolean first;

        public ParseFlowMappingKey(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = new ParseFlowMappingKey(this.first);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl parserImpl3 = ParserImpl.this;
                            parserImpl3.state = new ParseFlowMappingKey(true);
                            ParserImpl parserImpl4 = ParserImpl.this;
                            return parserImpl4.produceCommentEvent((CommentToken) parserImpl4.scanner.getToken());
                        }
                    } else {
                        Token peekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow mapping", (Mark) ParserImpl.this.marks.pop(), "expected ',' or '}', but got " + peekToken.getTokenId(), peekToken.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token = ParserImpl.this.scanner.getToken();
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.states.push(new ParseFlowMappingValue());
                        return ParserImpl.this.parseFlowNode();
                    }
                    ParserImpl.this.state = new ParseFlowMappingValue();
                    return ParserImpl.this.processEmptyScalar(token.getEndMark());
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingEmptyValue());
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token2 = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl.this.marks.pop();
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowEndComment();
            } else {
                ParserImpl parserImpl5 = ParserImpl.this;
                parserImpl5.state = (Production) parserImpl5.states.pop();
            }
            return mappingEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseFlowMappingValue implements Production {
        private ParseFlowMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = new ParseFlowMappingKey(false);
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                ParserImpl.this.states.push(new ParseFlowMappingKey(false));
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ParseFlowMappingEmptyValue implements Production {
        private ParseFlowMappingEmptyValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            ParserImpl parserImpl = ParserImpl.this;
            return parserImpl.processEmptyScalar(parserImpl.scanner.peekToken().getStartMark());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event processEmptyScalar(Mark mark) {
        return new ScalarEvent((String) null, (String) null, new ImplicitTuple(true, false), JsonProperty.USE_DEFAULT_NAME, mark, mark, DumperOptions.ScalarStyle.PLAIN);
    }
}
