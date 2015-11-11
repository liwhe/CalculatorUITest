package home.jmstudios.calc.test;


import android.widget.EditText;
import android.widget.ImageButton;

import home.jmstudios.calc.Main;

public class testCase extends ActivityBaseTestCase {
 
	public testCase() {
		super(Main.class);
	}
   @Override  
   public void setUp() throws Exception {  
	   super.setUp(); 
	   
   }  
 
   @Override  
   public void tearDown() throws Exception {  
	  super.tearDown();
		   
   }  
   
	
   /**
	 * @case
	 * @description:  calculate 7*8+3 and Verify the result;
	 * @author
	 */
   public void testBasicCalculation() throws Exception{
//	   solo.unlockScreen();
	   int time = 2000;
	   UIAction.sleep(time);
	   UIAction.click(MainUI.getKeypadButton('7'));
	   UIAction.click(MainUI.getKeypadButton('*'));
	   UIAction.click(MainUI.getKeypadButton('8'));
	   UIAction.click(MainUI.getKeypadButton('+'));
	   UIAction.click(MainUI.getKeypadButton('3'));
	   UIAction.click(MainUI.getKeypadButton('='));
	   UIAction.sleep(time);
	   
       EditText outPutView = MainUI.getOutPutTextView();
       String expected_result = "59";
       assertEquals("The calculator result is not right",expected_result, outPutView.getText().toString());	
   }
   
   
   /**
	 *Go to menu > Settings > Precision, change the precision to 5 Back to main activity, calculate 1 / 3 =
     Verify the result is 0.33333    
	 */
  public void testChangePrecision() throws Exception{
	  UIAction.sleep(2000);
	  ImageButton moreButton = MainUI.getMoreButton();
	  UIAction.click(moreButton);
	  UIAction.click(MainUI.getSettingButton());
	  UIAction.click(SettingsUI.getPrecisionView());
	  UIAction.sleep(2000);
	  String precisionValue = "5";
	  EditText view = PrecisionUI.getEditView();
	  UIAction.enterText(view,precisionValue);
	  UIAction.click(PrecisionUI.getOkButton());
	  UIAction.click(SettingsUI.getGoBackToHome());
	  UIAction.sleep(2000);
	  UIAction.click(MainUI.getKeypadButton('1'));
	  UIAction.click(MainUI.getKeypadButton('/'));
	  UIAction.click(MainUI.getKeypadButton('3'));
	  UIAction.click(MainUI.getKeypadButton('='));
	  UIAction.sleep(2000);
	  String expected_result = "0.33333";
	  EditText outPutView = MainUI.getOutPutTextView();
	  assertEquals("The calculator result is not right",expected_result, outPutView.getText().toString());	    
  }
   
  /**
	Trigonometric functions
    Scroll up from bottom to reveal more functions, calculate sin(90) Verify the result is 1  
	 */
public void testTrigonometric() throws Exception{
	
	UIAction.click(MainUI.getSlidingDrawer());
	UIAction.sleep(2000);
	UIAction.click(MainUI.getSinBtn());
	UIAction.click(MainUI.getSlidingDrawer());
	
	 UIAction.click(MainUI.getKeypadButton('9'));
	 UIAction.click(MainUI.getKeypadButton('0'));
	 UIAction.click(MainUI.getKeypadButton('='));
	 UIAction.sleep(2000);
	   
     EditText outPutView = MainUI.getOutPutTextView();
     String expected_result = "1";
     assertEquals("The calculator result is not right",expected_result, outPutView.getText().toString());	
	
}
   

}
