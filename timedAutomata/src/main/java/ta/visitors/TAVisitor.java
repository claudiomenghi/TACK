package ta.visitors;

import ta.TA;

public interface TAVisitor<T> {

	public T visit(TA ta);

}
