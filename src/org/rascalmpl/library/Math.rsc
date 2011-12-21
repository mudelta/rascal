@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Jurgen J. Vinju - Jurgen.Vinju@cwi.nl - CWI}
@contributor{Bert Lisser - Bert.Lisser@cwi.nl (CWI)}
@contributor{Paul Klint - Paul.Klint@cwi.nl - CWI}
@contributor{Arnold Lankamp - Arnold.Lankamp@cwi.nl}
module Math

@doc{Absolute value of number.}
public &T <: num abs(&T <: num N)
{
	return N >= 0 ? N : -N;
}

@doc{Return an arbitrary integer value.}
@javaClass{org.rascalmpl.library.Math}
public java int arbInt();

@doc{Return an arbitrary integer value in the interval [0, limit).}
@javaClass{org.rascalmpl.library.Integer}
public java int arbInt(int limit);

@doc{Returns an arbitrary real value in the interval [0.0,1.0).}
@javaClass{org.rascalmpl.library.Math}
public java real arbReal();

@doc{Returns an arbitrary rational value}
public rat arbRat() {
	n = arbInt();
	d = arbInt();
	if(d == 0)
		d = 1;
	return toRat(n, d);
}

@doc{Returns an arbitrary rational value}
public rat arbRat(int limit1, int limit2) {
	n = arbInt(limit1);
	d = arbInt(limit2);
	if(d == 0)
		d = 1;
	return toRat(n, d);
}

@doc{computes cos(x)}
@javaClass{org.rascalmpl.library.Math}
public java real cos(num x);

@doc{Return the rational's denominator}
@javaClass{org.rascalmpl.library.Math}
public java int denominator(rat n);

@doc{e -- returns the constant E}
@javaClass{org.rascalmpl.library.Math}
public java real E();


@doc{computes exp(x)}
@javaClass{org.rascalmpl.library.Math}
public java real exp(num x);

@doc{computes floor(x)}
@javaClass{org.rascalmpl.library.Math}
public java int floor(num x);


@doc{computes natural log of x}
@javaClass{org.rascalmpl.library.Math}
public java real ln(num x);

@doc{computes log_base_(x)}
@javaClass{org.rascalmpl.library.Math}
public java real log(num x, num base);

@doc{Computes the 10 based log(x)}
public real log10(num x) = log(x, 10.0);

@doc{Computes the 2 based log(x)}
public real log2(num x) = log(x, 2.0);

@doc{Largest of two numbers.}
public &T <: num max(&T <: num N, &T <: num M)
{
	return N > M ? N : M;
}

@doc{Smallest of two numbers.}
public &T <: num min(&T <: num N, &T <: num M)
{
	return N < M ? N : M;
}

@doc{Return the rational's numerator}
@javaClass{org.rascalmpl.library.Math}
public java int numerator(rat n);

@doc{computes n-th root of x}
@javaClass{org.rascalmpl.library.Math}
public java real nroot(num x, int n);

@doc{pi -- returns the constant PI}
@javaClass{org.rascalmpl.library.Math}
public java real PI();

@doc{computes the power of x by y}
@javaClass{org.rascalmpl.library.Math}
public java real pow(num x, int y);

@doc{Return the remainder of dividing the numerator by the denominator}
@javaClass{org.rascalmpl.library.Math}
public java int remainder(rat n);

@doc{Round to the nearest integer}
@javaClass{org.rascalmpl.library.Math}
public java int round(num d);

@doc{computes sin(x)}
@javaClass{org.rascalmpl.library.Math}
public java real sin(num x);

@doc{computes sqrt(x)}
@javaClass{org.rascalmpl.library.Math}
public java real sqrt(num x);

@doc{computes tan(x)}
@javaClass{org.rascalmpl.library.Math}
public java real tan(num x);

@doc{Convert a number to an integer.}
@javaClass{org.rascalmpl.library.Math}
public java int toInt(num N);

@doc{Convert a number value to a rational value (not supported on reals).}
@javaClass{org.rascalmpl.library.Math}
public java rat toRat(int numerator, int denominator);

@doc{Convert a number value to a real value.}
@javaClass{org.rascalmpl.library.Math}
public java real toReal(num N);

@doc{Convert a number value to a string.}
@javaClass{org.rascalmpl.library.Math}
public java str toString(num N);


