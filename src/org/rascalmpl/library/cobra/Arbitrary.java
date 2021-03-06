/*******************************************************************************
 * Copyright (c) 2009-2012 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:

 *   * Wietse Venema - wietsevenema@gmail.com - CWI
 *******************************************************************************/
package org.rascalmpl.library.cobra;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.eclipse.imp.pdb.facts.IInteger;
import org.eclipse.imp.pdb.facts.IReal;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;

public class Arbitrary {

	private final Random random;
	private final IValueFactory values;

	public Arbitrary(IValueFactory values) {
		this.random = new Random();
		this.values = values;

	}

	public IValue arbDateTime() {
		return values.datetime(random.nextLong());
	}

	public IValue arbInt() {
		return values.integer(random.nextInt());
	}

	/**
	 * Generate random integer between min (inclusive) and max (exclusive).
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public IValue arbInt(IInteger min, IInteger max) {
		return values.integer(arbInt(min.intValue(), max.intValue()));
	}

	private int arbInt(int min, int max) {
		return random.nextInt(max - min) + min;
	}

	public IValue arbReal(IReal min, IReal max) {
		double minD = min.doubleValue();
		double maxD = max.doubleValue();
		return values
				.real((random.nextDouble() * Math.abs(maxD - minD)) + minD);
	}

	public IValue arbString(IInteger length) {
		return values.string(RandomStringUtils.random(length.intValue()));
	}

	public IValue arbStringAlphabetic(IInteger length) {
		return values.string(RandomStringUtils.randomAlphabetic(length
				.intValue()));
	}

	public IValue arbStringAlphanumeric(IInteger length) {
		return values.string(RandomStringUtils.randomAlphanumeric(length
				.intValue()));
	}

	public IValue arbStringAscii(IInteger length) {
		return values.string(RandomStringUtils.randomAscii(length.intValue()));
	}

	public IValue arbStringNumeric(IInteger length) {
		return values
				.string(RandomStringUtils.randomNumeric(length.intValue()));
	}

	public IValue arbStringWhitespace(IInteger length) {
		char[] cs = { (char) Integer.parseInt("0009", 16),
				(char) Integer.parseInt("000A", 16),
				(char) Integer.parseInt("000B", 16),
				(char) Integer.parseInt("000C", 16),
				(char) Integer.parseInt("000D", 16),
				(char) Integer.parseInt("0020", 16),
				(char) Integer.parseInt("0085", 16),
				(char) Integer.parseInt("00A0", 16),
				(char) Integer.parseInt("1680", 16),
				(char) Integer.parseInt("180E", 16),
				(char) Integer.parseInt("2000", 16),
				(char) Integer.parseInt("2001", 16),
				(char) Integer.parseInt("2002", 16),
				(char) Integer.parseInt("2003", 16),
				(char) Integer.parseInt("2004", 16),
				(char) Integer.parseInt("2005", 16),
				(char) Integer.parseInt("2006", 16),
				(char) Integer.parseInt("2007", 16),
				(char) Integer.parseInt("2008", 16),
				(char) Integer.parseInt("2009", 16),
				(char) Integer.parseInt("200A", 16),
				(char) Integer.parseInt("2028", 16),
				(char) Integer.parseInt("2029", 16),
				(char) Integer.parseInt("202F", 16),
				(char) Integer.parseInt("205F", 16),
				(char) Integer.parseInt("3000", 16) };
		return values.string(RandomStringUtils.random(length.intValue(), cs));
	}

}