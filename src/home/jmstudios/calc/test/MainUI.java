package home.jmstudios.calc.test;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainUI extends UIBase {
	private final static int NUMBER_0_ID  = home.jmstudios.calc.R.id.button0;
	private final static int NUMBER_1_ID  = home.jmstudios.calc.R.id.button1;
	private final static int NUMBER_2_ID  = home.jmstudios.calc.R.id.button2;
	private final static int NUMBER_3_ID  = home.jmstudios.calc.R.id.button3;
	private final static int NUMBER_4_ID  = home.jmstudios.calc.R.id.button4;
	private final static int NUMBER_5_ID  = home.jmstudios.calc.R.id.button5;
	private final static int NUMBER_6_ID  = home.jmstudios.calc.R.id.button6;
	private final static int NUMBER_7_ID  = home.jmstudios.calc.R.id.button7;
	private final static int NUMBER_8_ID  = home.jmstudios.calc.R.id.button8;
	private final static int NUMBER_9_ID  = home.jmstudios.calc.R.id.button9;
	private final static int OPERATOR_MULTIPLY_ID  = home.jmstudios.calc.R.id.buttonMultiply;
	private final static int OPERATOR_PLUS_ID  = home.jmstudios.calc.R.id.buttonPlus;
	private final static int OPERATOR_EQUAL_ID  = home.jmstudios.calc.R.id.buttonEqual;
	private final static int OPERATOR_DIVIDE_ID  = home.jmstudios.calc.R.id.buttonDivide;
	
	private final static int SLIDING_DRAWER_ID  = home.jmstudios.calc.R.id.handle;
	private final static int SIN_BUTTON_ID  = home.jmstudios.calc.R.id.button_sin;
	
	
	
	
	private final static Class<ImageButton> IMAGE_BUTTON_MORE_TPYE  = ImageButton.class;
	private final static Class<TextView> VIEW_SETTING_TPYE  = TextView.class;
	
	
	
	
	private final static int OUTPUT_EDITTEXT_ID  = home.jmstudios.calc.R.id.editText1;
	
	
	public static Button getKeypadButton(char number) {
		switch (number) {
		case '0':
			return getViewFromActivity(NUMBER_0_ID);
		case '1':
			return getViewFromActivity(NUMBER_1_ID);
		case '2':
			return getViewFromActivity(NUMBER_2_ID);
		case '3':
			return getViewFromActivity(NUMBER_3_ID);
		case '4':
			return getViewFromActivity(NUMBER_4_ID);
		case '5':
			return getViewFromActivity(NUMBER_5_ID);
		case '6':
			return getViewFromActivity(NUMBER_6_ID);
		case '7':
			return getViewFromActivity(NUMBER_7_ID);
		case '8':
			return getViewFromActivity(NUMBER_8_ID);
		case '9':
			return getViewFromActivity(NUMBER_9_ID);
		case '*':
			return getViewFromActivity(OPERATOR_MULTIPLY_ID);
		case '+':
			return getViewFromActivity(OPERATOR_PLUS_ID);
		case '/':
			return getViewFromActivity(OPERATOR_DIVIDE_ID);
		case '=':
			return getViewFromActivity(OPERATOR_EQUAL_ID);
			
		default:
			throw new AssertionError(String.format("Cannot find number %s in MainUI", number));
		}
	}
	public static EditText getOutPutTextView(){
		return getViewFromActivity(OUTPUT_EDITTEXT_ID);
	}
	
	public static ImageButton getMoreButton(){
		return getView(IMAGE_BUTTON_MORE_TPYE,"More options");
	}
	
	public static TextView getSettingButton(){
		return getViewByText(VIEW_SETTING_TPYE,"Settings");
	}
	
	public static View getSlidingDrawer(){
		return getViewFromActivity(SLIDING_DRAWER_ID);
	}
	
	public static Button getSinBtn(){
		return getViewFromActivity(SIN_BUTTON_ID);
	}


}
