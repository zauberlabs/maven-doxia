package org.apache.maven.doxia.parser;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Iterator;

import org.apache.maven.doxia.logging.Log;
import org.apache.maven.doxia.sink.SinkEventAttributeSet;
import org.apache.maven.doxia.sink.SinkEventElement;
import org.apache.maven.doxia.sink.SinkEventTestingSink;

import org.codehaus.plexus.PlexusTestCase;

/**
 * Test for XhtmlBaseParser.
 *
 * @author ltheussl
 * @version $Id$
 * @since 1.1
 */
public class XhtmlBaseParserTest
    extends PlexusTestCase
{
    private XhtmlBaseParser parser;
    private final SinkEventTestingSink sink = new SinkEventTestingSink();

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        parser = new XhtmlBaseParser();
        parser.getLog().setLogLevel( Log.LEVEL_ERROR );
        sink.reset();
    }

    /** Test Doxia version. */
    public void testDoxiaVersion()
    {
        assertNotNull( XhtmlBaseParser.doxiaVersion() );
        assertFalse( "unknown".equals( XhtmlBaseParser.doxiaVersion() ) );
    }

    /** @throws Exception  */
    public void testHeadingEventsList()
        throws Exception
    {
        String text = "<p><h2></h2><h3></h3><h4></h4><h5></h5><h6></h6><h2></h2></p>";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "paragraph", ( it.next() ).getName() );
        assertEquals( "section1", ( it.next() ).getName() );
        assertEquals( "sectionTitle1", ( it.next() ).getName() );
        assertEquals( "sectionTitle1_", ( it.next() ).getName() );
        assertEquals( "section2", ( it.next() ).getName() );
        assertEquals( "sectionTitle2", ( it.next() ).getName() );
        assertEquals( "sectionTitle2_", ( it.next() ).getName() );
        assertEquals( "section3", ( it.next() ).getName() );
        assertEquals( "sectionTitle3", ( it.next() ).getName() );
        assertEquals( "sectionTitle3_", ( it.next() ).getName() );
        assertEquals( "section4", ( it.next() ).getName() );
        assertEquals( "sectionTitle4", ( it.next() ).getName() );
        assertEquals( "sectionTitle4_", ( it.next() ).getName() );
        assertEquals( "section5", ( it.next() ).getName() );
        assertEquals( "sectionTitle5", ( it.next() ).getName() );
        assertEquals( "sectionTitle5_", ( it.next() ).getName() );
        assertEquals( "section5_", ( it.next() ).getName() );
        assertEquals( "section4_", ( it.next() ).getName() );
        assertEquals( "section3_", ( it.next() ).getName() );
        assertEquals( "section2_", ( it.next() ).getName() );
        assertEquals( "section1_", ( it.next() ).getName() );
        assertEquals( "section1", ( it.next() ).getName() );
        assertEquals( "sectionTitle1", ( it.next() ).getName() );
        assertEquals( "sectionTitle1_", ( it.next() ).getName() );
        // this one is missing because we enclose everything in <p> which is not valid xhtml,
        // needs to be tested in overriding parser, eg XhtmlParser, XdocParser.
        //assertEquals( "section1_", ( it.next() ).getName() );
        assertEquals( "paragraph_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );
    }

    /** @throws Exception  */
    public void testNestedHeadingEventsList()
        throws Exception
    {
        // DOXIA-241
        String text = "<p><h2></h2><h6></h6><h3></h3></p>";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "paragraph", ( it.next() ).getName() );
        assertEquals( "section1", ( it.next() ).getName() );
        assertEquals( "sectionTitle1", ( it.next() ).getName() );
        assertEquals( "sectionTitle1_", ( it.next() ).getName() );

        assertEquals( "section2", ( it.next() ).getName() );
        assertEquals( "section3", ( it.next() ).getName() );
        assertEquals( "section4", ( it.next() ).getName() );

        assertEquals( "section5", ( it.next() ).getName() );
        assertEquals( "sectionTitle5", ( it.next() ).getName() );
        assertEquals( "sectionTitle5_", ( it.next() ).getName() );
        assertEquals( "section5_", ( it.next() ).getName() );

        assertEquals( "section4_", ( it.next() ).getName() );
        assertEquals( "section3_", ( it.next() ).getName() );
        assertEquals( "section2_", ( it.next() ).getName() );

        assertEquals( "section2", ( it.next() ).getName() );
        assertEquals( "sectionTitle2", ( it.next() ).getName() );
        assertEquals( "sectionTitle2_", ( it.next() ).getName() );
        // these two are missing because we enclose everything in <p> which is not valid xhtml,
        // needs to be tested in overriding parser, eg XhtmlParser, XdocParser.
        //assertEquals( "section2_", ( it.next() ).getName() );
        //assertEquals( "section1_", ( it.next() ).getName() );
        assertEquals( "paragraph_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );
    }

    /** @throws Exception  */
    public void testFigureEventsList()
        throws Exception
    {
        String text = "<img src=\"source\" title=\"caption\" />";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "figureGraphics", ( it.next() ).getName() );
        assertFalse( it.hasNext() );
    }

    /** @throws Exception  */
    public void testTableEventsList()
        throws Exception
    {
        // TODO: table caption, see DOXIA-177

        String text = "<table align=\"center\"><tr><th>Header</th></tr><tr><td>cell</td></tr></table>";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "table", ( it.next() ).getName() );
        assertEquals( "tableRows", ( it.next() ).getName() );
        assertEquals( "tableRow", ( it.next() ).getName() );
        assertEquals( "tableHeaderCell", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "tableHeaderCell_", ( it.next() ).getName() );
        assertEquals( "tableRow_", ( it.next() ).getName() );
        assertEquals( "tableRow", ( it.next() ).getName() );
        assertEquals( "tableCell", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "tableCell_", ( it.next() ).getName() );
        assertEquals( "tableRow_", ( it.next() ).getName() );
        assertEquals( "tableRows_", ( it.next() ).getName() );
        assertEquals( "table_", ( it.next() ).getName() );

        assertFalse( it.hasNext() );
    }

    /** @throws Exception  */
    public void testSignificantWhiteSpace()
        throws Exception
    {
        // NOTE significant white space
        String text = "<p><b>word</b> <i>word</i></p>";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "paragraph", ( it.next() ).getName() );
        assertEquals( "bold", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "bold_", ( it.next() ).getName() );

        SinkEventElement el = it.next();
        assertEquals( "text", el.getName() );
        assertEquals( " ",  (String) el.getArgs()[0] );

        assertEquals( "italic", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "italic_", ( it.next() ).getName() );
        assertEquals( "paragraph_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );


        // same test with EOL
        String eol = System.getProperty( "line.separator" );
        text = "<p><b>word</b>" + eol + "<i>word</i></p>";

        sink.reset();
        parser.parse( text, sink );
        it = sink.getEventList().iterator();

        assertEquals( "paragraph", ( it.next() ).getName() );
        assertEquals( "bold", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "bold_", ( it.next() ).getName() );

        el = it.next();
        assertEquals( "text", el.getName() );
        // according to section 2.11 of the XML spec, parsers must normalize line breaks to "\n"
        assertEquals( "\n",  (String) el.getArgs()[0] );

        assertEquals( "italic", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "italic_", ( it.next() ).getName() );
        assertEquals( "paragraph_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );


        // DOXIA-189: there should be no EOL after closing tag
        text = "<p>There should be no space after the last <i>word</i>.</p>";

        sink.reset();
        parser.parse( text, sink );
        it = sink.getEventList().iterator();

        assertEquals( "paragraph", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "italic", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "italic_", ( it.next() ).getName() );

        el = it.next();
        assertEquals( "text", el.getName() );
        assertEquals( ".",  (String) el.getArgs()[0] );

        assertEquals( "paragraph_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );
    }

    /** @throws Exception  */
    public void testPreFormattedText()
        throws Exception
    {
        String text = "<pre><a href=\"what.html\">what</a></pre>";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();
        assertEquals( "verbatim", ( it.next() ).getName() );
        assertEquals( "link", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "link_", ( it.next() ).getName() );
        assertEquals( "verbatim_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );

        text = "<pre><![CDATA[<a href=\"what.html\">what</a>]]></pre>";
        sink.reset();
        parser.parse( text, sink );

        it = sink.getEventList().iterator();
        assertEquals( "verbatim", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "verbatim_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );

        text = "<pre><![CDATA[<pre>what</pre>]]></pre>";
        sink.reset();
        parser.parse( text, sink );

        it = sink.getEventList().iterator();
        assertEquals( "verbatim", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "verbatim_", ( it.next() ).getName() );
        assertFalse( it.hasNext() );
    }

    /** @throws Exception  */
    public void testPreEOL()
        throws Exception
    {
        // test EOLs within <pre>: the sink MUST receive a text event for the EOL
        String text = "<pre><a href=\"what.html\">what</a>" + XhtmlBaseParser.EOL
                + "<a href=\"what.html\">what</a></pre>";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "verbatim", ( it.next() ).getName() );
        assertEquals( "link", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "link_", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "link", ( it.next() ).getName() );
        assertEquals( "text", ( it.next() ).getName() );
        assertEquals( "link_", ( it.next() ).getName() );
        assertEquals( "verbatim_", ( it.next() ).getName() );
    }

    /** @throws Exception  */
    public void testDoxia250()
        throws Exception
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "<!DOCTYPE test [" ).append( XhtmlBaseParser.EOL );
        sb.append( "<!ENTITY foo \"&#x159;\">" ).append( XhtmlBaseParser.EOL );
        sb.append( "<!ENTITY foo1 \"&nbsp;\">" ).append( XhtmlBaseParser.EOL );
        sb.append( "<!ENTITY foo2 \"&#x161;\">" ).append( XhtmlBaseParser.EOL );
        sb.append( "<!ENTITY tritPos \"&#x1d7ed;\">" ).append( XhtmlBaseParser.EOL );
        sb.append( "]>" ).append( XhtmlBaseParser.EOL );
        sb.append( "<b>&foo;&foo1;&foo2;&tritPos;</b>" );

        parser.setValidate( false );
        parser.parse( sb.toString(), sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        SinkEventElement event = it.next();
        assertEquals( "bold", event.getName() );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "\u0159",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "\u00A0",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "\u0161",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "\uD835\uDFED",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "bold_", event.getName() );
    }

    /** @throws Exception  */
    public void testEntities()
        throws Exception
    {
        final String text = "<!DOCTYPE test [<!ENTITY flo \"&#x159;\"><!ENTITY tritPos \"&#x1d7ed;\"><!ENTITY fo \"&#65;\"><!ENTITY myCustom \"&fo;\">]>"
                + "<body><h2>&amp;&flo;&#x159;&tritPos;&#x1d7ed;</h2><p>&amp;&flo;&#x159;&tritPos;&#x1d7ed;&myCustom;</p></body>";

        parser.setValidate( false );
        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "section1", ( it.next() ).getName() );
        assertEquals( "sectionTitle1", ( it.next() ).getName() );

        SinkEventElement textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "&", textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\u0159", textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\u0159", textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\uD835\uDFED",  (String) textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\uD835\uDFED", textEvt.getArgs()[0] );

        assertEquals( "sectionTitle1_", ( it.next() ).getName() );
        assertEquals( "paragraph", ( it.next() ).getName() );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "&", textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\u0159", textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\u0159", textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\uD835\uDFED",  (String) textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "\uD835\uDFED", textEvt.getArgs()[0] );

        textEvt = it.next();
        assertEquals( "text", textEvt.getName() );
        assertEquals( "A", textEvt.getArgs()[0] );

        assertEquals( "paragraph_", ( it.next() ).getName() );

        assertFalse( it.hasNext() );
    }

    /** @throws Exception  */
    public void testDecoration()
        throws Exception
    {
        String text = "<div><u>u</u><s>s</s><del>del</del><strike>strike</strike><sub>sub</sub><sup>sup</sup></div>";
        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        SinkEventElement event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "u",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "s",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "del",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "strike",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "sub",  (String) event.getArgs()[0] );

        event = it.next();
        assertEquals( "text", event.getName() );
        assertEquals( "sup",  (String) event.getArgs()[0] );
//        assertTrue( ( (SinkEventAttributeSet) event.getArgs()[1] )
//                .containsAttribute( SinkEventAttributeSet.VALIGN, "sup" ) ); // TODO
    }

    /** @throws Exception  */
    public void testLists()
        throws Exception
    {
        String text = "<div><ul><li></li></ul><ol><li></li></ol><dl><dt></dt><dd></dd></dl></div>";
        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "list", ( it.next() ).getName() );
        assertEquals( "listItem", ( it.next() ).getName() );
        assertEquals( "listItem_", ( it.next() ).getName() );
        assertEquals( "list_", ( it.next() ).getName() );

        assertEquals( "numberedList", ( it.next() ).getName() );
        assertEquals( "numberedListItem", ( it.next() ).getName() );
        assertEquals( "numberedListItem_", ( it.next() ).getName() );
        assertEquals( "numberedList_", ( it.next() ).getName() );

        assertEquals( "definitionList", ( it.next() ).getName() );
        assertEquals( "definitionListItem", ( it.next() ).getName() );
        assertEquals( "definedTerm", ( it.next() ).getName() );
        assertEquals( "definedTerm_", ( it.next() ).getName() );
        assertEquals( "definition", ( it.next() ).getName() );
        assertEquals( "definition_", ( it.next() ).getName() );
        assertEquals( "definitionListItem_", ( it.next() ).getName() );
        assertEquals( "definitionList_", ( it.next() ).getName() );
    }

    /** @throws Exception  */
    public void testStyles()
        throws Exception
    {
        String text = "<div><b></b><strong></strong><i></i><em></em><code></code><samp></samp><tt></tt></div>";
        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "bold", ( it.next() ).getName() );
        assertEquals( "bold_", ( it.next() ).getName() );
        assertEquals( "bold", ( it.next() ).getName() );
        assertEquals( "bold_", ( it.next() ).getName() );

        assertEquals( "italic", ( it.next() ).getName() );
        assertEquals( "italic_", ( it.next() ).getName() );
        assertEquals( "italic", ( it.next() ).getName() );
        assertEquals( "italic_", ( it.next() ).getName() );

        assertEquals( "monospaced", ( it.next() ).getName() );
        assertEquals( "monospaced_", ( it.next() ).getName() );
        assertEquals( "monospaced", ( it.next() ).getName() );
        assertEquals( "monospaced_", ( it.next() ).getName() );
        assertEquals( "monospaced", ( it.next() ).getName() );
        assertEquals( "monospaced_", ( it.next() ).getName() );
    }

    /** @throws Exception  */
    public void testSimpleTags()
        throws Exception
    {
        String text = "<div><br/><hr/><img src=\"img.src\"/></div>";
        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "lineBreak", ( it.next() ).getName() );
        assertEquals( "horizontalRule", ( it.next() ).getName() );
        assertEquals( "figureGraphics", ( it.next() ).getName() );
    }

    /** @throws Exception  */
    public void testSpecial()
        throws Exception
    {
        String text = "<p><!-- a pagebreak: --><!-- PB -->&nbsp;&#160;<unknown /></p>";
        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "paragraph", ( it.next() ).getName() );
        assertEquals( "comment", ( it.next() ).getName() );
        assertEquals( "pageBreak", ( it.next() ).getName() );
        assertEquals( "nonBreakingSpace", ( it.next() ).getName() );
        assertEquals( "nonBreakingSpace", ( it.next() ).getName() );
        // unknown events are not reported by the base parser
        assertEquals( "paragraph_", ( it.next() ).getName() );
    }

    /** @throws Exception  */
    public void testTable()
        throws Exception
    {
        String text = "<table><caption></caption><tr><th></th></tr><tr><td></td></tr></table>";
        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "table", ( it.next() ).getName() );

        // DOXIA-374
        SinkEventElement el = it.next();
        assertEquals( "tableRows", el.getName() );
        assertFalse( ( (Boolean) el.getArgs()[1] ).booleanValue() );

        assertEquals( "tableCaption", ( it.next() ).getName() );
        assertEquals( "tableCaption_", ( it.next() ).getName() );
        assertEquals( "tableRow", ( it.next() ).getName() );
        assertEquals( "tableHeaderCell", ( it.next() ).getName() );
        assertEquals( "tableHeaderCell_", ( it.next() ).getName() );
        assertEquals( "tableRow_", ( it.next() ).getName() );
        assertEquals( "tableRow", ( it.next() ).getName() );
        assertEquals( "tableCell", ( it.next() ).getName() );
        assertEquals( "tableCell_", ( it.next() ).getName() );
        assertEquals( "tableRow_", ( it.next() ).getName() );
        assertEquals( "tableRows_", ( it.next() ).getName() );
        assertEquals( "table_", ( it.next() ).getName() );
    }

    /** @throws Exception  */
    public void testFigure()
        throws Exception
    {
        String text = "<div class=\"figure\"><p><img src=\"src.jpg\"/></p><p><i></i></p></div>";
        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        assertEquals( "figure", ( it.next() ).getName() );
        assertEquals( "figureGraphics", ( it.next() ).getName() );
        assertEquals( "figureCaption", ( it.next() ).getName() );
        assertEquals( "figureCaption_", ( it.next() ).getName() );
        assertEquals( "figure_", ( it.next() ).getName() );
    }

    /** @throws Exception  */
    public void testAnchorLink()
        throws Exception
    {
        String text = "<div><a href=\"\"></a>" +
                "<a href=\"valid\"></a>" +
                "<a href=\"#1invalid\"></a>" +
                "<a href=\"http://www.fo.com/index.html#1invalid\"></a>" +
                "<a name=\"valid\"></a>" +
                "<a name=\"1invalid\"></a>" +
                "<a id=\"1invalid\"></a></div>";

        parser.parse( text, sink );
        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        SinkEventElement element = it.next();
        assertEquals( "link", element.getName() );
        assertEquals( "", element.getArgs()[0] );
        assertEquals( "link_", ( it.next() ).getName() );

        element = it.next();
        assertEquals( "link", element.getName() );
        assertEquals( "valid", element.getArgs()[0] );
        assertEquals( "link_", ( it.next() ).getName() );

        element = it.next();
        assertEquals( "link", element.getName() );
        assertEquals( "#a1invalid", element.getArgs()[0] );
        assertEquals( "link_", ( it.next() ).getName() );

        element = it.next();
        assertEquals( "link", element.getName() );
        assertEquals( "http://www.fo.com/index.html#1invalid", element.getArgs()[0] );
        assertEquals( "link_", ( it.next() ).getName() );

        element = it.next();
        assertEquals( "anchor", element.getName() );
        assertEquals( "valid", element.getArgs()[0] );
        assertEquals( "anchor_", ( it.next() ).getName() );

        element = it.next();
        assertEquals( "anchor", element.getName() );
        assertEquals( "a1invalid", element.getArgs()[0] );
        assertEquals( "anchor_", ( it.next() ).getName() );

        element = it.next();
        assertEquals( "anchor", element.getName() );
        assertEquals( "a1invalid", element.getArgs()[0] );
        assertEquals( "anchor_", ( it.next() ).getName() );
    }

    /**
     * Test entities in attributes.
     *
     * @throws java.lang.Exception if any.
     */
    public void testAttributeEntities()
        throws Exception
    {
        String text = "<script type=\"text/javascript\" src=\"http://ex.com/ex.js?v=l&amp;l=e\"></script>";

        parser.parse( text, sink );

        Iterator<SinkEventElement> it = sink.getEventList().iterator();

        SinkEventElement event = it.next();

        assertEquals( "unknown", event.getName() );
        assertEquals( "script", event.getArgs()[0] );
        SinkEventAttributeSet attribs = (SinkEventAttributeSet) event.getArgs()[2];
        // ampersand should be un-escaped
        assertEquals( "http://ex.com/ex.js?v=l&l=e", attribs.getAttribute( "src" ) );
        assertEquals( "unknown", ( it.next() ).getName() );
        assertFalse( it.hasNext() );

        sink.reset();
        text = "<img src=\"http://ex.com/ex.jpg?v=l&amp;l=e\" alt=\"image\"/>";
        parser.parse( text, sink );

        it = sink.getEventList().iterator();
        event = it.next();
        assertEquals( "figureGraphics", event.getName() );
        attribs = (SinkEventAttributeSet) event.getArgs()[1];
        // ampersand should be un-escaped
        assertEquals( "http://ex.com/ex.jpg?v=l&l=e", attribs.getAttribute( "src" ) );
    }
}
