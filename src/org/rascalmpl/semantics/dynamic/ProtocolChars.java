/*******************************************************************************
 * Copyright (c) 2009-2011 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:

 *   * Jurgen J. Vinju - Jurgen.Vinju@cwi.nl - CWI
 *   * Mark Hills - Mark.Hills@cwi.nl (CWI)
 *   * Arnold Lankamp - Arnold.Lankamp@cwi.nl
*******************************************************************************/
package org.rascalmpl.semantics.dynamic;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IValue;
import org.rascalmpl.interpreter.IEvaluator;
import org.rascalmpl.interpreter.result.Result;

public abstract class ProtocolChars extends org.rascalmpl.ast.ProtocolChars {

	static public class Lexical extends org.rascalmpl.ast.ProtocolChars.Lexical {

		public Lexical(IConstructor __param1, String __param2) {
			super(__param1, __param2);
		}

		@Override
		public Result<IValue> interpret(IEvaluator<Result<IValue>> __eval) {

			String str = this.getString();
			return org.rascalmpl.interpreter.result.ResultFactory.makeResult(TF
					.stringType(), VF
					.string(str.substring(1, str.length() - 3)), __eval);

		}

	}

	public ProtocolChars(IConstructor __param1) {
		super(__param1);
	}
}
