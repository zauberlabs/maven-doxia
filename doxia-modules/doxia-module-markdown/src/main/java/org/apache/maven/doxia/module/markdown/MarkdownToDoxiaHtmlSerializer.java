package org.apache.maven.doxia.module.markdown;

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

import org.pegdown.ToHtmlSerializer;
import org.pegdown.ast.VerbatimNode;

/**
 * Custom Markdown to HTML serialization strategy that better matches the
 * conventions of existing Doxia modules.
 *
 * @author Brian Ferris (bdferris@google.com)
 */
public class MarkdownToDoxiaHtmlSerializer
    extends ToHtmlSerializer
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void visit( VerbatimNode node )
    {
        printer.println().print( "<div class=\"source\"><pre>" );
        String text = node.getText();
        text = transformVerbatimText( text );
        printer.printEncoded( text, this );
        printer.print( "</pre></div>" );
    }
}
