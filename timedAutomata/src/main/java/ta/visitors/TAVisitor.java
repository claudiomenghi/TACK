package ta.visitors;

import ta.AP;
import ta.State;
import ta.TA;

public interface TAVisitor<T> {

	public T visit(TA ta);

	public T visit(AP ap);

	public T visit(State state);

}
