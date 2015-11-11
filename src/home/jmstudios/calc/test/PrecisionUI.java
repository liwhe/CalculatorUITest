package home.jmstudios.calc.test;

import android.widget.Button;
import android.widget.EditText;

public class PrecisionUI extends UIBase {
	   private final static int EDIT_PRECISION_ID  = android.R.id.edit;
	   private final static Class<EditText> EDIT_PRECISION_TYPE = EditText.class;
	   private final static int OK_BUTTON_ID  = android.R.id.button1;
	   private final static Class<Button> OK_BUTTON_TYPE = Button.class;
	   
	   
	   public static EditText getEditView(){
		   return getViewFromViews(EDIT_PRECISION_TYPE,EDIT_PRECISION_ID);
	   }
	   
	   public static Button getOkButton(){
		   return getViewFromViews(OK_BUTTON_TYPE,OK_BUTTON_ID);
	   }
}
