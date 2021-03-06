package org.rascalmpl.library.experiments.resource.results.buffers;

import java.util.Iterator;

import org.eclipse.imp.pdb.facts.IValue;

	public class LazyIterator implements Iterator<IValue> {
		
		private IValue buffer[] = null;
		private int currentPos = 0;
		private boolean atEnd = false;
		private ILazyFiller filler = null;
		private int bufferSize = 0;
		
		public LazyIterator(ILazyFiller filler, int bufferSize) {
			this.bufferSize = bufferSize;
			this.filler = filler;
		}

		public void init() {
			refillBuffer();
		}
		
		private void refillBuffer() {
			buffer = filler.refill(bufferSize);
			if (buffer.length == 0) {
				this.atEnd = true;
			}
			this.currentPos = 0;
		}
		
		@Override
		public boolean hasNext() {
			return !atEnd;
		}

		@Override
		public IValue next() {
			IValue nextValue = buffer[currentPos++];
			if (currentPos >= buffer.length) {
				refillBuffer();
			}
			return nextValue;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Cannot remove elements from the underlying database table or query");
		}
		
	}
