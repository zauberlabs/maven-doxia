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

import org.apache.maven.doxia.markup.TextMarkup;

/**
 * This interface defines all markups and syntaxes used by the <b>Markdown</b> format.
 *
 * @see <a href="http://daringfireball.net/projects/markdown/syntax">http://daringfireball.net/projects/markdown/syntax</a>
 * @author <a href="mailto:mariano@zauberlabs.com">Mariano Cortesi</a>
 * @version $Id$
 * @since 1.3
 */
public interface MarkdownMarkup
    extends TextMarkup
{
    // ----------------------------------------------------------------------
    // Markdown markups
    // ----------------------------------------------------------------------

    /** Syntax for the anchor : '#' */
    char ANCHOR_MARKUP = '#';

    /** Syntax for the start line separator: "   " */
    String THREE_SPACES_MARKUP = "   ";

    /** Syntax for the bold markup: "__" */
    String BOLD_END_MARKUP = "__";

    /** Syntax for the bold markup: "__" */
    String BOLD_START_MARKUP = "__";

    /** Syntax for the bold italic markup: "____" */
    String BOLD_ITALIC_END_MARKUP = "___";

    /** Syntax for the bold italic markup: "___" */
    String BOLD_ITALIC_START_MARKUP = "___";

    /** Syntax for the bold monospaced markup: "==" */
    String BOLD_MONOSPACED_END_MARKUP = "==";

    /** Syntax for the bold monospaced markup: "==" */
    String BOLD_MONOSPACED_START_MARKUP = "==";

    /** Syntax for the horizontal rule markup: "---" */
    String HORIZONTAL_RULE_MARKUP = "---";

    /** Syntax for the italic markup: "_" */
    String ITALIC_END_MARKUP = "_";

    /** Syntax for the italic markup: "_" */
    String ITALIC_START_MARKUP = "_";

    /** Syntax for the link end markup: ")" */
    String LINK_END_MARKUP = ")";

    /** Syntax for the link middle markup: "][" */
    String LINK_MIDDLE_MARKUP = "](";

    /** Syntax for the link start markup: "[[" */
    String LINK_START_MARKUP = "[";
    
    /** Syntax for the figure start markup: "![" */
    String FIGURE_START_MARKUP = "![";
    
    /** Syntax for the figure start markup: "](" */
    String FIGURE_MIDDLE_MARKUP = "](";
    
    /** Syntax for the figure start markup: ")" */
    String FIGURE_END_MARKUP = ")";
    
    /** Syntax for the list item markup: "*" */
    String LIST_ITEM_MARKUP = "* ";

    /** Syntax for the mono-spaced style end: "=" */
    String MONOSPACED_END_MARKUP = "`";

    /** Syntax for the mono-spaced style start: "=" */
    String MONOSPACED_START_MARKUP = "`";

    /** Syntax for the numbering decimal markup char: "1." */
    String NUMBERING_MARKUP = "1.";

    /** Syntax for the numbering lower alpha markup char: "a." */
    String NUMBERING_LOWER_ALPHA_MARKUP = "a.";

    /** Syntax for the numbering lower roman markup char: "i." */
    String NUMBERING_DECIMAL_MARKUP = "1.";

    /** Syntax for the numbering upper alpha markup char: "A." */
    String NUMBERING_UPPER_ALPHA_MARKUP = "A.";

    /** Syntax for the numbering upper roman markup char: "I." */
    String NUMBERING_UPPER_ROMAN_MARKUP = "I.";

    // ----------------------------------------------------------------------
    // Specific Markdown tags
    // ----------------------------------------------------------------------

    String VERBATIM_STYLE = "          ";
}
