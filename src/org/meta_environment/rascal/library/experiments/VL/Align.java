package org.meta_environment.rascal.library.experiments.VL;

import org.eclipse.imp.pdb.facts.IList;
import org.meta_environment.rascal.interpreter.IEvaluatorContext;


/**
 * Align elements on consecutive rows. Width is determined by the width property, height is
 * determined by the number and size of the elements. This is similar to aligning words in
 * a text but is opposed to composition in a grid, where the elements are placed on fixed
 * grid ositions.
 * 
 * @author paulk
 *
 */
public class Align extends Compose {
	
	float leftElem[];
	float topRowElem[];
	float rowHeight[];
	float rowWidth[];
	int inRow[];
	static boolean debug = false;

	Align(VLPApplet vlp, PropertyManager inheritedProps, IList props, IList elems, IEvaluatorContext ctx) {
		super(vlp, inheritedProps, props, elems, ctx);
		leftElem = new float[elems.length()];
		topRowElem = new float[elems.length()];
		rowHeight = new float[elems.length()];
		rowWidth = new float[elems.length()];
		inRow = new int[elems.length()];
	}
	
	@Override
	void bbox(){
		
		width = getWidthProperty();
		height = 0;
		float w = 0;
		float hrow = 0;
		float toprow = 0;
		int nrow = 0;
		float hgap = getHGapProperty();
		float vgap = getVGapProperty();
		for(int i = 0; i < velems.length; i++){
			VELEM ve = velems[i];
			ve.bbox();
			if(w + hgap + ve.width > width){
				if(w == 0){
					width = ve.width;
				} else {
					rowHeight[nrow] = hrow;
					rowWidth[nrow] = w;
					nrow++;
					height += hrow + vgap;
					toprow = height;
					w = hrow = 0;
				}
			}
			leftElem[i] = w;
			topRowElem[i] = toprow;
			inRow[i] = nrow;
			w += ve.width + hgap;
			hrow = max(hrow, ve.height);
	
		}
		rowHeight[nrow] = hrow;
		rowWidth[nrow] = w;
		height += hrow;
		if(nrow == 0)
			width = w - hgap;
		if(debug)System.err.printf("Align.bbox: width=%f, height=%f\n", width, height);
	}
	
	@Override
	void draw(float left, float top){
		this.left = left;
		this.top = top;
		applyProperties();

		for(int i = 0; i < velems.length; i++){
			
			VELEM ve = velems[i];
			float hrow = rowHeight[inRow[i]];
			float rfiller = width - rowWidth[inRow[i]];
			
			ve.draw(left + leftElem[i] + ve.properties.hanchor*rfiller,
                    top + topRowElem[i] + ve.properties.vanchor *(hrow - ve.height));                  
		}
	}
}
