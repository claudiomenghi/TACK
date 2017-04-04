/**
 * 
 */
package formulae.mitli.formulae;

import static org.junit.Assert.*;

import org.junit.Test;

import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIAtom;
import formulae.mitli.atoms.MITLIPropositionalAtom;

/**
 * @author Claudio1
 *
 */
public class MITLINegationTest {

	@Test
	public void test() {
		MITLIAtom a=new MITLIPropositionalAtom("a");
		
		assertEquals("double negation is simplified", a, MITLIFormula.not(MITLIFormula.not(a)));
	}

}
