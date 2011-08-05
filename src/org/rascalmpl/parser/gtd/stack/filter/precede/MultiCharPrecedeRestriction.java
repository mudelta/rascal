/*******************************************************************************
 * Copyright (c) 2009-2011 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:

 *   * Arnold Lankamp - Arnold.Lankamp@cwi.nl
*******************************************************************************/
package org.rascalmpl.parser.gtd.stack.filter.precede;

import org.rascalmpl.parser.gtd.location.PositionStore;
import org.rascalmpl.parser.gtd.stack.filter.IEnterFilter;

/**
 * A filter that prevents the indicated substring from being preceded by any of
 * the, with this filter associated, series of characters.
 */
public class MultiCharPrecedeRestriction implements IEnterFilter{
	private final char[][] characters;
	
	public MultiCharPrecedeRestriction(char[][] characters){
		super();

		this.characters = characters;
	}
	
	public boolean isFiltered(char[] input, int start, PositionStore positionStore){
		int startLocation = start - characters.length;
		if(startLocation < 0) return false;
		
		OUTER : for(int i = characters.length - 1; i >= 0; --i){
			char next = input[startLocation + i];
			
			char[] alternatives = characters[i];
			for(int j = alternatives.length - 1; j >= 0; --j){
				if(next == alternatives[j]){
					continue OUTER;
				}
			}
			return false;
		}
		
		return true;
	}
	
	public boolean isEqual(IEnterFilter otherEnterFilter){
		if(!(otherEnterFilter instanceof MultiCharPrecedeRestriction)) return false;
		
		MultiCharPrecedeRestriction otherMultiCharPrecedeFilter = (MultiCharPrecedeRestriction) otherEnterFilter;
		
		char[][] otherCharacters = otherMultiCharPrecedeFilter.characters;
		if(characters.length != otherCharacters.length) return false;
		
		for(int i = characters.length - 1; i >= 0; --i){
			char[] chars = characters[i];
			char[] otherChars = otherCharacters[i];
			if(chars.length != otherChars.length) return false;
			
			POS: for(int j = chars.length - 1; j <= 0; --j){
				char c = chars[j];
				for(int k = otherChars.length - 1; k <= 0; --k){
					if(c == otherChars[k]) continue POS;
				}
				return false;
			}
		}
		// Found all characters.
		
		return true;
	}
}
