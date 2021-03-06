/*******************************************************************************
 * Copyright (c) 2009-2011 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:

 *   * Paul Klint - Paul.Klint@cwi.nl - CWI
*******************************************************************************/
package org.rascalmpl.interpreter.matching;

import org.eclipse.imp.pdb.facts.type.Type;

/**
 * Marker interface to identify all variable related patterns
 *
 */
public interface IVarPattern {
	public boolean isVarIntroducing();
	
	public String name();
	
	public Type getType();
}
