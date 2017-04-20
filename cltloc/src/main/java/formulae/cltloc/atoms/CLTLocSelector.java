package formulae.cltloc.atoms;

import com.google.common.base.Preconditions;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocSelector extends CLTLocFormula {


	public CLTLocSelector(String name) {
		super();
		Preconditions.checkNotNull(name, "The clock name cannot be null");
		this.clockName = name;
		this.hash = clockName.hashCode();
	}
	
	public String getName() {
		return clockName;
	}




	private final int hash;
	private final String clockName;


	
	
	
	@Override
	public int hashCode() {
		return this.hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CLTLocSelector other = (CLTLocSelector) obj;
		if (clockName == null) {
			if (other.clockName != null)
				return false;
		} else if (!clockName.equals(other.clockName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return clockName;
	}




	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

}
