package org.apache.maven.doxia.macro.snippet;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.codehaus.plexus.util.IOUtil;

/**
 * Utility class for reading snippets.
 *
 * @version $Id$
 */
public class SnippetReader
{
    /** System-dependent EOL. */
    private static final String EOL = System.getProperty( "line.separator" );

    /** The source. */
    private URL source;

    /**
     * Constructor.
     *
     * @param src The source.
     */
    public SnippetReader( URL src )
    {
        this.source = src;
    }

    /**
     * Reads the snippet with given id.
     *
     * @param snippetId The id of the snippet.
     * @return The snippet.
     * @throws java.io.IOException if something goes wrong.
     */
    public StringBuffer readSnippet( String snippetId )
        throws IOException
    {
        List<String> lines = readLines( snippetId );
        int minIndent = minIndent( lines );
        StringBuffer result = new StringBuffer();
        for ( String line : lines )
        {
            result.append( line.substring( minIndent ) );
            result.append( EOL );
        }
        return result;
    }

    /**
     * Returns the minimal indent of all the lines in the given List.
     *
     * @param lines A List of lines.
     * @return the minimal indent.
     */
    int minIndent( List<String> lines )
    {
        int minIndent = Integer.MAX_VALUE;
        for ( String line : lines )
        {
            minIndent = Math.min( minIndent, indent( line ) );
        }
        return minIndent;
    }

    /**
     * Returns the indent of the given line.
     *
     * @param line A line.
     * @return the indent.
     */
    int indent( String line )
    {
        char[] chars = line.toCharArray();
        int indent = 0;
        for ( ; indent < chars.length; indent++ )
        {
            if ( chars[indent] != ' ' )
            {
                break;
            }
        }
        return indent;
    }

    /**
     * Reads the snippet and returns the lines in a List.
     *
     * @param snippetId The id of the snippet.
     * @return A List of lines.
     * @throws IOException if something goes wrong.
     */
    private List<String> readLines( String snippetId )
        throws IOException
    {
        // TODO: DOXIA-386, use InputStreamReader(InputStream in, Charset cs)
        BufferedReader reader = new BufferedReader( new InputStreamReader( source.openStream() ) );
        List<String> lines = new ArrayList<String>();
        try
        {
            boolean capture = false;
            String line;
            while ( ( line = reader.readLine() ) != null )
            {
                if ( snippetId == null || "".equals( snippetId.trim() ) )
                {
                    lines.add( line );
                }
                else
                {
                    if ( isStart( snippetId, line ) )
                    {
                        capture = true;
                    }
                    else if ( isEnd( snippetId, line ) )
                    {
                        break;
                    }
                    else if ( capture )
                    {
                        lines.add( line );
                    }
                }
            }
        }
        finally
        {
            IOUtil.close( reader );
        }
        return lines;
    }

    /**
     * Determines if the given line is a start demarcator.
     *
     * @param snippetId the id of the snippet.
     * @param line the line.
     * @return True, if the line is a start demarcator.
     */
    protected boolean isStart( String snippetId, String line )
    {
        return isDemarcator( snippetId, "START", line );
    }

    /**
     * Determines if the given line is a demarcator.
     *
     * @param snippetId the id of the snippet.
     * @param what Identifier for the demarcator.
     * @param line the line.
     * @return True, if the line is a start demarcator.
     */
    protected boolean isDemarcator( String snippetId, String what, String line )
    {
        String upper = line.toUpperCase( Locale.ENGLISH );
        return upper.contains( what.toUpperCase( Locale.ENGLISH ) )
            && upper.contains( "SNIPPET" )
            && line.contains( snippetId );
    }

    /**
     * Determines if the given line is an end demarcator.
     *
     * @param snippetId the id of the snippet.
     * @param line the line.
     * @return True, if the line is an end demarcator.
     */
    protected boolean isEnd( String snippetId, String line )
    {
        return isDemarcator( snippetId, "END", line );
    }
}
