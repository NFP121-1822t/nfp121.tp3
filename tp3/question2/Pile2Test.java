package question2;

public class Pile2Test extends junit.framework.TestCase {
    private PileI p1;
    private PileI p2;

    public void setUp() {
        p1 = new question2.Pile2();
        p2 = new question2.Pile2();
    }

    public void test_Pile2_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }

    public void test_Pile2_estPleine() throws Exception {
        PileI p = new question2.Pile2(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile2_sommet() throws Exception {
        PileI p = new question2.Pile2(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile2_estVide() throws Exception {
        PileI p = new question2.Pile2(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile2_toString() throws Exception {
        PileI Pile21 = new question2.Pile2(3);
        assertEquals("toString incorrect ? ", "[]", Pile21.toString());
        Pile21.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", Pile21.toString());
        Pile21.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", Pile21.toString());
        Pile21.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", Pile21.toString());

    }

    public void test_Pile2_TailleNegative() {
        PileI p = new question2.Pile2(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile2_equals() throws Exception {

        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);

        p2.empiler(3);
        p2.empiler(2);
        p2.empiler(1);

        assertTrue("égalité de deux Pile2s ? ", p1.equals(p2));
        assertTrue("égalité de deux Pile2s ? ", p2.equals(p1));
        assertTrue("égalité de deux Pile2s ? ", p1.equals(p1));

        p2.empiler(1);
        assertFalse("égalité de deux Pile2s ? ", p1.equals(p2));

    }
}
