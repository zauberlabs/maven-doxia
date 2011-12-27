/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */
package org.apache.maven.doxia.module.twiki.parser;

import org.apache.maven.doxia.sink.Sink;

/**
 * TODO: Description of the class, Comments in english by default  
 * 
 * 
 * @author Cristian Pereyra
 * @since Dec 27, 2011
 */
public class NumeratedListItemBlock extends ListItemBlock {
    /**
     * @see #ListItemBlock(Block[], ListBlockItem)
     */
    NumeratedListItemBlock( final Block[] blocks )
    {
        this( blocks, null );
    }

    /**
     * Creates the ListItemBlock.
     *
     * @param blocks    text block, not null.
     * @param innerList child list
     */
    NumeratedListItemBlock( final Block[] blocks, final ListBlockItem innerList )
    {
        super( blocks );
    }

    /** {@inheritDoc} */
    @Override
    void before( final Sink sink )
    {
        sink.numberedListItem();
    }

    /** {@inheritDoc} */
    @Override
    void after( final Sink sink )
    {
        if ( innerList != null )
        {
            innerList.traverse( sink );
        }
        sink.numberedListItem_();
    }
}
