package org.apache.maven.doxia.module.markdown;


import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.BOLD_END_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.BOLD_START_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.FIGURE_END_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.FIGURE_MIDDLE_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.FIGURE_START_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.HORIZONTAL_RULE_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.ITALIC_END_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.ITALIC_START_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.LINK_END_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.LINK_MIDDLE_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.LINK_START_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.LIST_ITEM_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.MONOSPACED_END_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.MONOSPACED_START_MARKUP;
import static org.apache.maven.doxia.module.markdown.MarkdownMarkup.NUMBERING_LOWER_ROMAN_MARKUP;

import java.io.Writer;

import org.apache.maven.doxia.sink.AbstractSinkTest;
import org.apache.maven.doxia.sink.Sink;
import org.codehaus.plexus.util.StringUtils;


/**
 * Tests the Sink's Functionality
 * 
 * @author Cristian Pereyra
 * @since Dec 26, 2011
 */
public class MarkdownSinkTest extends AbstractSinkTest {

    /** {@inheritDoc} */
    @Override
    protected Sink createSink( Writer writer) {
        return new MarkdownSink(writer);
    }

    /** {@inheritDoc} */
    @Override
    protected boolean isXmlSink() {
        return false;
    }

    /** Not used.
     * {@inheritDoc} */
    protected String getTitleBlock( String title )
    {
        return null;
    }

    /** Not used
     * {@inheritDoc} */
    @Override
    protected String getAuthorBlock( String author) 
    {
        return null;
    }

    /** Not used
     * {@inheritDoc} */
    @Override
    protected String getDateBlock( String date) 
    {
        return null;
    }

    /** Not used
     * {@inheritDoc} */
    @Override
    protected String getHeadBlock() 
    {
        return null;
    }

    /** Not used 
     * {@inheritDoc} */
    @Override
    protected String getBodyBlock() 
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    protected String getSectionTitleBlock( String title) {
        return title;
    }

    /** {@inheritDoc} */
    @Override
    protected String getSection1Block( String title)
    {
        return StringUtils.repeat( "#", 1 ) + " " + title + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getSection2Block( String title) 
    {
        return StringUtils.repeat( "#", 2 ) + " " + title + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getSection3Block( String title)
    {
        return StringUtils.repeat( "#", 3 ) + " " + title + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getSection4Block(String title)
    {
        return StringUtils.repeat( "#", 4 ) + " " + title + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getSection5Block(String title)
    {
        return StringUtils.repeat( "#", 5 ) + " " + title + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getListBlock(String item) {
        return LIST_ITEM_MARKUP + item + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getNumberedListBlock(String item) {
        return MarkdownMarkup.NUMBERING_MARKUP + " " + item + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getDefinitionListBlock(String definum, String definition) {
        return "";
    }

    /** {@inheritDoc} */
    @Override
    protected String getFigureBlock(String source, String caption) {
        return FIGURE_START_MARKUP + caption + FIGURE_MIDDLE_MARKUP + source + FIGURE_END_MARKUP;
    }

    /** {@inheritDoc} */
    @Override
    protected String getTableBlock(String cell, String caption) {
        return "<table><tr><td>" + cell + "</td></tr><caption>" + caption + "</caption></table>";
    }

    /** {@inheritDoc} */
    @Override
    protected String getParagraphBlock(String text) {
        return EOL + text + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getVerbatimBlock(String text) {
        return EOL + MarkdownMarkup.VERBATIM_STYLE + text + EOL;
    }

    /** {@inheritDoc} */
    @Override
    protected String getHorizontalRuleBlock() {
        return HORIZONTAL_RULE_MARKUP;
    }

    /** {@inheritDoc} */
    @Override
    protected String getPageBreakBlock() {
        return "";
    }

    /** {@inheritDoc} */
    @Override
    protected String getAnchorBlock(String anchor) {
        return "";
    }

    /** {@inheritDoc} */
    @Override
    protected String getLinkBlock(String link, String text) {
        return LINK_START_MARKUP + text + LINK_MIDDLE_MARKUP + link + LINK_END_MARKUP;
    }

    /** {@inheritDoc} */
    @Override
    protected String getItalicBlock(String text) {
        return ITALIC_START_MARKUP + text + ITALIC_END_MARKUP;
    }

    /** {@inheritDoc} */
    @Override
    protected String getBoldBlock(String text) {
        return BOLD_START_MARKUP + text + BOLD_END_MARKUP;
    }

    /** {@inheritDoc} */
    @Override
    protected String getMonospacedBlock(String text) {
        return MONOSPACED_START_MARKUP + text + MONOSPACED_END_MARKUP;
    }

    /** {@inheritDoc} */
    @Override
    protected String getLineBreakBlock() {
        return "";
    }

    /** {@inheritDoc} */
    @Override
    protected String getNonBreakingSpaceBlock() {
        return "";
    }

    /** {@inheritDoc} */
    @Override
    protected String getTextBlock(String text) {
        return text;
    }

    /** {@inheritDoc} */
    @Override
    protected String getRawTextBlock(String text) {
        return text;
    }

    /** {@inheritDoc} */
    @Override
    protected String getCommentBlock(String text) {
        // TODO Auto-generated method stub
        return "";
    }

    /** {@inheritDoc} */
    @Override
    protected String outputExtension() {
        return "md";
    }

    // ----------------------------------------------------------------------
    // Override unused tests
    // ----------------------------------------------------------------------

    /** Not used.
     * {@inheritDoc} */
    public void testAuthor()
    {
        // nop
    }

    /** Not used.
     * {@inheritDoc} */
    public void testDate()
    {
        // nop
    }

    /** Not used.
     * {@inheritDoc} */
    public void testHead()
    {
        // nop
    }

    /** Not used.
     * {@inheritDoc} */
    public void testBody()
    {
        // nop
    }

    /** Not used.
     * {@inheritDoc} */
    public void testTitle()
    {
        // nop
    }
}
