package ta;

import ta.visitors.TAVisitor;

public abstract class ModelElement {

	 public abstract <T> T accept(TAVisitor<T> visitor);
}
