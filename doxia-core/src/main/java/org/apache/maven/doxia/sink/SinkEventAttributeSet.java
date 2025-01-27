package org.apache.maven.doxia.sink;

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

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.text.AttributeSet;

/**
 * Implementation of MutableAttributeSet using a LinkedHashMap.
 *
 * @author ltheussl
 * @version $Id$
 * @since 1.1
 */
public class SinkEventAttributeSet
    implements SinkEventAttributes, Cloneable
{
    /**
     * An unmodifiable attribute set containing only an underline attribute.
     */
    public static final SinkEventAttributes UNDERLINE;

    /**
     * An unmodifiable attribute set containing only an overline attribute.
     */
    public static final SinkEventAttributes OVERLINE;

    /**
     * An unmodifiable attribute set containing only a linethrough attribute.
     */
    public static final SinkEventAttributes LINETHROUGH;

    /**
     * An unmodifiable attribute set containing only a boxed attribute.
     */
    public static final SinkEventAttributes BOXED;

    /**
     * An unmodifiable attribute set containing only a bold attribute.
     */
    public static final SinkEventAttributes BOLD;

    /**
     * An unmodifiable attribute set containing only an italic attribute.
     */
    public static final SinkEventAttributes ITALIC;

    /**
     * An unmodifiable attribute set containing only a monospaced attribute.
     */
    public static final SinkEventAttributes MONOSPACED;

    /**
     * An unmodifiable attribute set containing only a left attribute.
     */
    public static final SinkEventAttributes LEFT;

    /**
     * An unmodifiable attribute set containing only a right attribute.
     */
    public static final SinkEventAttributes RIGHT;

    /**
     * An unmodifiable attribute set containing only a center attribute.
     */
    public static final SinkEventAttributes CENTER;

    /**
     * An unmodifiable attribute set containing only a justify attribute.
     */
    public static final SinkEventAttributes JUSTIFY;


    static
    {
        UNDERLINE = new SinkEventAttributeSet( new String[] {DECORATION, "underline"} ).unmodifiable();
        OVERLINE = new SinkEventAttributeSet( new String[] {DECORATION, "overline"} ).unmodifiable();
        LINETHROUGH = new SinkEventAttributeSet( new String[] {DECORATION, "line-through"} ).unmodifiable();
        BOXED = new SinkEventAttributeSet( new String[] {DECORATION, "boxed"} ).unmodifiable();

        BOLD = new SinkEventAttributeSet( new String[] {STYLE, "bold"} ).unmodifiable();
        ITALIC = new SinkEventAttributeSet( new String[] {STYLE, "italic"} ).unmodifiable();
        MONOSPACED = new SinkEventAttributeSet( new String[] {STYLE, "monospaced"} ).unmodifiable();

        LEFT = new SinkEventAttributeSet( new String[] {ALIGN, "left"} ).unmodifiable();
        RIGHT = new SinkEventAttributeSet( new String[] {ALIGN, "right"} ).unmodifiable();
        CENTER = new SinkEventAttributeSet( new String[] {ALIGN, "center"} ).unmodifiable();
        JUSTIFY = new SinkEventAttributeSet( new String[] {ALIGN, "justify"} ).unmodifiable();
    }

    private Map<String, Object> attribs;

    private AttributeSet resolveParent;

    /**
     * Constructs a new, empty SinkEventAttributeSet with default size 5.
     */
    public SinkEventAttributeSet()
    {
        this( 5 );
    }

    /**
     * Constructs a new, empty SinkEventAttributeSet with the specified initial size.
     *
     * @param size the initial number of attribs.
     */
    public SinkEventAttributeSet( int size )
    {
        attribs = new LinkedHashMap<String, Object>( size );
    }

    /**
     * Constructs a new SinkEventAttributeSet with the attribute name-value
     * mappings as given by the specified String array.
     *
     * @param attributes the specified String array. If the length of this array
     * is not an even number, an IllegalArgumentException is thrown.
     */
    public SinkEventAttributeSet( String[] attributes )
    {
        int n = attributes.length;

        if ( ( n % 2 ) != 0 )
        {
            throw new IllegalArgumentException( "Missing attribute!" );
        }

        attribs = new LinkedHashMap<String, Object>( n / 2 );

        for ( int i = 0; i < n; i += 2 )
        {
            attribs.put( attributes[i], attributes[i + 1] );
        }
    }

    /**
     * Constructs a new SinkEventAttributeSet with the same attribute name-value
     * mappings as in the specified AttributeSet.
     *
     * @param attributes the specified AttributeSet.
     */
    public SinkEventAttributeSet( AttributeSet attributes )
    {
        attribs = new LinkedHashMap<String, Object>( attributes.getAttributeCount() );

        Enumeration<?> names = attributes.getAttributeNames();

        while ( names.hasMoreElements() )
        {
            Object name = names.nextElement();

            attribs.put( name.toString(), attributes.getAttribute( name ) );
        }
    }

    /**
     * Replace this AttributeSet by an unmodifiable view of itself.
     * Any subsequent attempt to add, remove or modify the underlying mapping
     * will result in an UnsupportedOperationException.
     *
     * @return an unmodifiable view of this AttributeSet.
     *
     * @since 1.1.1
     */
    public SinkEventAttributeSet unmodifiable()
    {
        this.attribs = Collections.unmodifiableMap( attribs );

        return this;
    }

    /**
     * Checks whether the set of attribs is empty.
     *
     * @return true if the set is empty.
     */
    public boolean isEmpty()
    {
        return attribs.isEmpty();
    }

    /** {@inheritDoc} */
    public int getAttributeCount()
    {
        return attribs.size();
    }

    /** {@inheritDoc} */
    public boolean isDefined( Object attrName )
    {
        return attribs.containsKey( attrName );
    }

    /** {@inheritDoc} */
    public boolean isEqual( AttributeSet attr )
    {
        return ( ( getAttributeCount() == attr.getAttributeCount() )
                && containsAttributes( attr ) );
    }

    /** {@inheritDoc} */
    public AttributeSet copyAttributes()
    {
        return ( (AttributeSet) clone() );
    }

    /** {@inheritDoc} */
    public Enumeration<String> getAttributeNames()
    {
        return Collections.enumeration( attribs.keySet() );
    }

    /** {@inheritDoc} */
    public Object getAttribute( Object key  )
    {
        Object value = attribs.get( key  );

        if ( value == null )
        {
            AttributeSet parent = getResolveParent();

            if ( parent != null )
            {
                value = parent.getAttribute( key  );
            }
        }

        return value;
    }

    /** {@inheritDoc} */
    public boolean containsAttribute( Object name, Object value )
    {
        return value.equals( getAttribute( name ) );
    }

    /** {@inheritDoc} */
    public boolean containsAttributes( AttributeSet attributes )
    {
        boolean result = true;

        Enumeration<?> names = attributes.getAttributeNames();

        while ( result && names.hasMoreElements() )
        {
            Object name = names.nextElement();
            result = attributes.getAttribute( name ).equals( getAttribute( name ) );
        }

        return result;
    }

    /**
     * {@inheritDoc}
     *
     * Adds an attribute with the given name and value.
     */
    public void addAttribute( Object name, Object value )
    {
        attribs.put( name.toString(), value );
    }

    /** {@inheritDoc} */
    public void addAttributes( AttributeSet attributes  )
    {
        if ( attributes == null || attributes.getAttributeCount() == 0 )
        {
            return;
        }

        Enumeration<?> names = attributes.getAttributeNames();

        while ( names.hasMoreElements() )
        {
            Object name = names.nextElement();

            addAttribute( name, attributes.getAttribute( name ) );
        }
    }

    /** {@inheritDoc} */
    public void removeAttribute( Object name )
    {
        attribs.remove( name );
    }

    /** {@inheritDoc} */
    public void removeAttributes( Enumeration<?> names )
    {
        while ( names.hasMoreElements() )
        {
            removeAttribute( names.nextElement() );
        }
    }

    /** {@inheritDoc} */
    public void removeAttributes( AttributeSet attributes  )
    {
        if ( attributes == null )
        {
            return;
        }
        else if ( attributes == this )
        {
            attribs.clear();
        }
        else
        {
            Enumeration<?> names = attributes.getAttributeNames();

            while ( names.hasMoreElements() )
            {
                Object name = names.nextElement();
                Object value = attributes.getAttribute( name );

                if ( value.equals( getAttribute( name ) ) )
                {
                    removeAttribute( name );
                }
            }
        }
    }

    /** {@inheritDoc} */
    public AttributeSet getResolveParent()
    {
        return this.resolveParent;
    }

    /** {@inheritDoc} */
    public void setResolveParent( AttributeSet parent )
    {
        this.resolveParent = parent;
    }

    /** {@inheritDoc} */
    @Override
    public Object clone()
    {
        SinkEventAttributeSet attr = new SinkEventAttributeSet( attribs.size() );
        attr.attribs = new LinkedHashMap<String, Object>( attribs );

        if ( resolveParent != null )
        {
            attr.resolveParent = resolveParent.copyAttributes();
        }

        return attr;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int parentHash = ( resolveParent == null ? 0 : resolveParent.hashCode() );

        return attribs.hashCode() + parentHash;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }

        if ( obj instanceof SinkEventAttributeSet )
        {
            return isEqual( (SinkEventAttributeSet) obj  );
        }

        return false;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Enumeration<String> names = getAttributeNames();

        while ( names.hasMoreElements() )
        {
            String key = names.nextElement();
            String value = getAttribute( key ).toString();

            s.append( ' ' ).append( key ).append( '=' ).append( value );
        }

        return s.toString();
    }

}
