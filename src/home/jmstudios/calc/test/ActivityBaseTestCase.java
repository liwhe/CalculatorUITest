package home.jmstudios.calc.test;

import home.jmstudios.calc.Main;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

public class ActivityBaseTestCase<T extends Activity> extends ActivityInstrumentationTestCase2<T> {
    public ActivityBaseTestCase(Class<T> type){
    	super(type);
    }
    public Instrumentation instrumentation;
	public Solo solo;
	
	
	public void setUp() throws Exception {  
		   instrumentation = getInstrumentation();
		   solo = new Solo(instrumentation, getActivity());
		   launchActivity(Main.class);
		   
		    UIBase.instrumentation = instrumentation;
			UIBase.solo = solo;
			UIAction.instrumentation = instrumentation;
			UIAction.solo = solo;
	   } 
	
	public void tearDown() throws Exception{
		Runtime.getRuntime().gc();
		Runtime.getRuntime().runFinalization();
		Runtime.getRuntime().gc();
		solo.finishOpenedActivities(); 
	}
	
	public <T extends Activity> T launchActivity(Class<T> activityCls){
		final String targetPackage = instrumentation.getTargetContext().getPackageName();
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setClassName(targetPackage, activityCls.getName());
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		T activity = (T) instrumentation.startActivitySync(intent);
		instrumentation.waitForIdleSync();
		return activity;
		
	}
}
