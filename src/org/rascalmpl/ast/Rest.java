/*******************************************************************************
 * Copyright (c) 2009-2011 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   * Jurgen J. Vinju - Jurgen.Vinju@cwi.nl - CWI
 *   * Tijs van der Storm - Tijs.van.der.Storm@cwi.nl
 *   * Paul Klint - Paul.Klint@cwi.nl - CWI
 *   * Mark Hills - Mark.Hills@cwi.nl (CWI)
 *   * Arnold Lankamp - Arnold.Lankamp@cwi.nl
 *******************************************************************************/
package org.rascalmpl.ast;


import org.eclipse.imp.pdb.facts.IConstructor;
import org.rascalmpl.interpreter.asserts.Ambiguous;
import org.eclipse.imp.pdb.facts.IValue;
import org.rascalmpl.interpreter.Evaluator;
import org.rascalmpl.interpreter.env.Environment;
import org.rascalmpl.interpreter.result.Result;

public abstract class Rest extends AbstractAST {
  public Rest(IConstructor node) {
    super(node);
  }

  

  static public class Ambiguity extends Rest {
    private final java.util.List<org.rascalmpl.ast.Rest> alternatives;
  
    public Ambiguity(IConstructor node, java.util.List<org.rascalmpl.ast.Rest> alternatives) {
      super(node);
      this.alternatives = java.util.Collections.unmodifiableList(alternatives);
    }
    
    @Override
    public Result<IValue> interpret(Evaluator __eval) {
      throw new Ambiguous(this.getTree());
    }
      
    @Override
    public org.eclipse.imp.pdb.facts.type.Type typeOf(Environment env) {
      throw new Ambiguous(this.getTree());
    }
    
    public java.util.List<org.rascalmpl.ast.Rest> getAlternatives() {
      return alternatives;
    }
    
    public <T> T accept(IASTVisitor<T> v) {
    	return v.visitRestAmbiguity(this);
    }
  }

  static public class Lexical extends Rest {
  private final java.lang.String string;
  public Lexical(IConstructor node, java.lang.String string) {
    super(node);
    this.string = string;
  }
  public java.lang.String getString() {
    return string;
  }
  public java.lang.String toString() {
    return string;
  }
  public <T> T accept(IASTVisitor<T> v) {
    return v.visitRestLexical(this);
  }
}

  
}