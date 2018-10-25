// All robotium methods should have "test" at the start of the name!

package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

//import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest
        extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(LonelyTwitterActivity.class);
    }

    @Override
    public void setUp(){
        solo=new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown(){
        solo.finishOpenedActivities();
    }

    public void testTweet(){
        solo.assertCurrentActivity("wrong activity",
                "LonelyTwitterActivity");
    }

    public void testEqual(){
        assertEquals("not equal", "5", "5");
    }

    public void testAddTweet(){
        solo.enterText((EditText) solo.getView(R.id.body), "new thing");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("new thing"));
    }

    /*
    public void testStart() throws Exception {
        Activity activity = getActivity();

    }*/
}