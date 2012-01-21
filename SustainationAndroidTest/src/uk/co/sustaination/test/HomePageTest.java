package uk.co.sustaination.test;

import uk.co.sustaination.HomePage;
import android.test.ActivityInstrumentationTestCase2;

public class HomePageTest extends ActivityInstrumentationTestCase2<HomePage> {

	private HomePage homePageActivity;
	
	public HomePageTest() {
		super("uk.co.sustaination", HomePage.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		homePageActivity = this.getActivity();
	}

	public void test_a_oncreate_activity() {
		assertNotNull(homePageActivity);
	}
}
