package home.jmstudios.calc.test;

import android.widget.ImageView;
import android.widget.TextView;

public class SettingsUI extends UIBase{
//	   private final static String PRECISION  = getString (home.jmstudios.calc.R.string.precision_title);
	   private final static int HOME_ID  = android.R.id.home;
	   public static TextView getPrecisionView(){
//			return getViewByText(TextView.class, getString(home.jmstudios.calc.R.string.precision_title));
		   return getViewByText(TextView.class,"Precision");
		} 
	   
	   
	   public static ImageView getGoBackToHome(){
		   return getViewFromActivity(HOME_ID);
	   }


}
