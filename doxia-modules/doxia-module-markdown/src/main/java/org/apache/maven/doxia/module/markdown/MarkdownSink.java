/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */
package org.apache.maven.doxia.module.markdown;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.NotImplementedException;
import org.apache.maven.doxia.sink.AbstractTextSink;
import org.apache.maven.doxia.sink.Sink;

/**
 * Provides a way to save doxia to Markdown
 * 
 * 
 * @author Cristian Pereyra
 * @since Dec 26, 2011
 */
public class MarkdownSink extends AbstractTextSink {
    
    private Writer  output;
    private boolean inVerbatim       = false;
    private boolean avoidText        = false;
    private String  auxString        = null;
    private int     bulletDepth      = 0;
    private boolean inNumberedList   = false;
    private int     currentBulletType = 0;
    
    /**
     * Creates the MarkdownSink.
     *
     */
    public MarkdownSink(final Writer writer) {
        this.output = writer;
    }
    
    /**
     * Writes to the output
     * @param s The string to write
     */
    private void outputWrite(final String s) {
        try {
            output.write(s);
        } catch (IOException e) {
            throw new NotImplementedException(e);
        }
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#bold() */
    @Override
    public final void bold() {
        outputWrite("__");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#bold_() */
    @Override
    public final void bold_() {
        this.bold();
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#title() */
    @Override
    public void title() {
        avoidText = true;
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#text(java.lang.String, 
     *  org.apache.maven.doxia.sink.SinkEventAttributes) */
    @Override
    public final void text(String text) {
        if (avoidText) {
            avoidText = false;
            return;
        }
        
        if (!inVerbatim) {
            outputWrite(text);
        } else {
            String[] lines = text.split("\n");
            for (int i = 0; i < lines.length; i++) {
                if (bulletDepth > 0) {
                    for (int j = 0; j < bulletDepth; j++) {
                        outputWrite("  ");
                    }
                }
                outputWrite("     " + lines[i]);
                outputWrite("\n");    
            }
        }
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#italic() */
    @Override
    public final void italic() {
        outputWrite("_");
    }
    /** @see org.apache.maven.doxia.sink.SinkAdapter#italic_() */
    @Override
    public final void italic_() {
        this.italic();
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#verbatim(boolean) */
    @Override
    public final void verbatim(final boolean boxed) {
        inVerbatim = true;
    }

    /** @see org.apache.maven.doxia.sink.SinkAdapter#verbatim_() */
    @Override
    public final void verbatim_() {
        inVerbatim = false;    
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#monospaced() */
    @Override
    public final void monospaced() {
        outputWrite("`");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#monospaced_() */
    @Override
    public final void monospaced_() {
        this.monospaced();
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle1() {
        outputWrite("# ");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle1_() {
        outputWrite(" #\n");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle2() {
        outputWrite("## ");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle2_() {
        outputWrite(" ##\n");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle3() {
        outputWrite("### ");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle3_() {
        outputWrite(" ###\n");
    }
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle4() {
        outputWrite("#### ");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle4_() {
        outputWrite(" ####\n");
    }
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle5() {
        outputWrite("##### ");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#sectionTitle1() */
    @Override
    public final void sectionTitle5_() {
        outputWrite(" #####\n");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#paragraph() */
    @Override
    public final void paragraph() {
        outputWrite("\n");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#paragraph_() */
    @Override
    public final void paragraph_() {
        outputWrite("\n");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#horizontalRule() */
    @Override
    public final void horizontalRule() {
        outputWrite("---");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#list() */
    @Override
    public void list() {
        if (bulletDepth == 0) {
            outputWrite("\n\n");
        }
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#list_() */
    @Override
    public void list_() {
        if (bulletDepth == 0) {
            outputWrite("\n\n");
        }
    }
    
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#list() */
    @Override
    public final void listItem() {
        if (inNumberedList) {
            numberedListItem();
            return;
        }
        
        
        if (bulletDepth > 0) {
            outputWrite("\n");
            for (int i = 0; i < bulletDepth; i++) {
                outputWrite("  ");
            }
        }
        
        outputWrite("* ");
        bulletDepth++;
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#listItem_() */
    @Override
    public final void listItem_() {
        if (inNumberedList) {
            numberedListItem_();
            return;
        }
        
        bulletDepth--;
        if (bulletDepth == 0) {
            outputWrite("\n");
        }
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#numberedList(int) */
    @Override
    public final void numberedList(final int numbering) {
        if (bulletDepth == 0) {
            outputWrite("\n\n");
        }
        currentBulletType = numbering;
        inNumberedList = true;
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#numberedList(int) */
    @Override
    public final void numberedList_() {
        if (bulletDepth == 0) {
            outputWrite("\n\n");
        }
        inNumberedList = false;
    }
  

    /** @see org.apache.maven.doxia.sink.SinkAdapter#numberedListItem() */
    @Override
    public final void numberedListItem() {
        if (bulletDepth > 0) {
            outputWrite("\n");
            for (int i = 0; i < bulletDepth; i++) {
                outputWrite("  ");
            }
        }
        
        switch(currentBulletType) {
            case Sink.NUMBERING_DECIMAL:
                outputWrite("1. ");
                break;
            case Sink.NUMBERING_LOWER_ALPHA:
                outputWrite("a. ");
                break;
            case Sink.NUMBERING_LOWER_ROMAN:
                outputWrite("i. ");
                break;
            case Sink.NUMBERING_UPPER_ALPHA:
                outputWrite("A. ");
                break;
            case Sink.NUMBERING_UPPER_ROMAN:
                outputWrite("I. ");
                break;
        }
        
        bulletDepth++;
    }
    
  
    /** @see org.apache.maven.doxia.sink.SinkAdapter#numberedListItem_() */
    @Override
    public final void numberedListItem_() {
        bulletDepth--;
        if (bulletDepth == 0) {
            outputWrite("\n");
        }
    }
    
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#link(java.lang.String) */
    @Override
    public final void link(final String url) {
        auxString = url;
        outputWrite("[");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#link_() */
    @Override
    public final void link_() {
        outputWrite("](" + auxString + ")");
    }
    
    /** @see org.apache.maven.doxia.sink.SinkAdapter#rawText(java.lang.String) */
    @Override
    public final void rawText(final String text) {
        outputWrite(text);
    }

    /** @see org.apache.maven.doxia.sink.SinkAdapter#figureGraphics(java.lang.String, 
     * org.apache.maven.doxia.sink.SinkEventAttributes) */
    @Override
    public final void figureGraphics(final String name) {
        outputWrite("![](" + name + ")");
    }
}
