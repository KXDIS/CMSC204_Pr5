
//@author Hendrick Nguyen
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTestSTUDENT {

	MorseCodeTree tree;

	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;

	}

	@Test
	public void testAddNode() {

		assertEquals("a", tree.getRoot().getLeftChild().getRightChild().getData());

		assertEquals("z", tree.getRoot().getRightChild().getRightChild().getLeftChild().getLeftChild().getData());
	}

	@Test
	void testFetch() {
		String s0 = tree.fetch("");
		String s1 = tree.fetch(".");
		String s2 = tree.fetch("-");
		String s3 = tree.fetch("..");
		String s4 = tree.fetch(".-");
		String s5 = tree.fetch("-.");

		assertEquals("e", s1);
		assertEquals("t", s2);
		assertEquals("i", s3);
		assertEquals("a", s4);
		assertEquals("n", s5);

	}

	@Test
	void testUpdate() {
		try {
			tree.update();
		} catch (UnsupportedOperationException e) {
			assertTrue("threw UnsupportedOperationException", true);
		}
	}
}