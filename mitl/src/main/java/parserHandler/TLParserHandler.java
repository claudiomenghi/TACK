package parserHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import formulae.Formula;
import formulae.mitl.TemporizedFormula;

public abstract class TLParserHandler {

	private Set<Formula> formulae;

	private ArrayList<Formula> formulaeOf;

	private int historyLength;

	private int maxbound;

	public boolean dict, verbose;

	private FileOutputStream f0 = null;
	private PrintStream prn = null;

	TLParserHandler() {
		formulae = new LinkedHashSet<>();
		formulaeOf = new ArrayList<>();
		dict = verbose = true;
	}

	public void setHistoryLength(int historyLength) {
		this.historyLength = historyLength;
	}

	private int getHistoryLength() {
		return this.historyLength;
	}

	public Formula addFormula(Formula f) {

		// then insert the simplified formula
		return addToformulae(f);
	}

	private Formula addToformulae(Formula f) {

		// if formula f is in the set
		if (formulae.contains(f)) {
			// get it from the set and return it to the caller
			for (Formula fmla : formulae) {
				if (fmla.equals(f))
					return fmla;
			}
		}

		List<Formula> subf = null;
		List<Formula> newsubf = new ArrayList<>();

		Formula newf;

		// if formula f has subformulae
		if (subf != null) { // null non si usa
			for (Formula fmla : subf) {
				newsubf.add(addToformulae(fmla));
			}

			// update the structure of f
			// newf = f.update(newsubf);
			newf = null;
			//
			formulae.add(newf);
			// then return it
			return newf;

		}
		// otherwise it is an atom
		formulae.add(f);
		// then return it
		return f;
	}

	public Iterator<Formula> iterator() {
		return formulae.iterator();
	}

	public Iterator<Formula> iteratorOf() {
		return formulaeOf.iterator();
	}

	private void visit(Formula f) {

		if (!formulaeOf.contains(f)) {

			formulaeOf.add(f);

			if (f instanceof TemporizedFormula) {
				TemporizedFormula f1 = ((TemporizedFormula) f);

			}

			// List<Formula> subf = f.subformulae();
			// TODO fix this
			List<Formula> subf = null;
			if (subf != null)
				for (Formula fmla : subf)
					visit(fmla);
		}
	}
}
