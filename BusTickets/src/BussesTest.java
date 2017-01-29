import static org.junit.Assert.*;


import org.junit.Test;

public class BussesTest {

	@Test
	public void test() {
		AdminScreen admin = new AdminScreen();
		Object selectedID = admin.GetDataFromTable(0,0);
		boolean check = Busses.DeleteBus(selectedID);
		assertEquals(true,check);
		fail("Not yet implemented");
	}

}
