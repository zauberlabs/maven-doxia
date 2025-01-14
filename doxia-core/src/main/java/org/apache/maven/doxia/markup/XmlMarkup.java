package org.apache.maven.doxia.markup;

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

/**
 * List of constants used by <code>Xml</code> markup syntax.
 *
 * @author <a href="mailto:vincent.siveton@gmail.com">Vincent Siveton</a>
 * @version $Id$
 * @since 1.0
 */
public interface XmlMarkup
    extends Markup
{
    /** XML namespace: "http://www.w3.org/2001/XMLSchema-instance" */
    String XML_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";

    // ----------------------------------------------------------------------
    // Xml separator characters
    // ----------------------------------------------------------------------

    /** bang character: '!' */
    char BANG = '!';

    // ----------------------------------------------------------------------
    // Xml constants
    // ----------------------------------------------------------------------

    /** CDATA. String: "CDATA". */
    String CDATA = "CDATA";

    /** DOCTYPE start. String: "&lt;!DOCTYPE". */
    String DOCTYPE_START = "<!DOCTYPE";

    /** ENTITY start. String: "&lt;!ENTITY". */
    String ENTITY_START = "<!ENTITY";
}
