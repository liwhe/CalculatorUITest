package home.jmstudios.calc.test;

import java.util.ArrayList;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UIAction {

	public static Solo solo;
    public static Instrumentation instrumentation;

	public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new AssertionError(e.getMessage());
        }
    }
	
   public static void click(View view, boolean mustVisible) {
       
       if (mustVisible && !view.isShown()) {
           throw new AssertionError(String.format("View is not visible, View: type-%s", view.getClass().getSimpleName()));
       }
       solo.clickOnView(view);
   }

   public static void click(View view) {
       click(view, true);
   }
   
   
   public static void enterText(final EditText editView, final String text) {
       if (!editView.isEnabled()) {
           throw new AssertionError("Given edit view cannot input string, it is diabled!");
       }
       instrumentation.runOnMainSync(new Runnable() {
           @Override
           public void run() {
               editView.setText(text);
           }
       });
       waitUiSync();
   }
   
   public static void waitUiSync() {
       instrumentation.waitForIdleSync();
   }
   
   public static  <T extends View> T getViewFromActivity(final int id){
//   	waitUiSync();
   	   Activity activity = solo.getCurrentActivity();
       return (T) activity.findViewById(id);
   }
   
   public static <T extends View> T getViewFromViews(final Class<T> viewClass,final int id){
	   return waitForView(new IGetView<T>() {
           @Override
           public T getView() {
               ArrayList<T> views = solo.getCurrentViews(viewClass);
               T viewResult = null;
               for (T view : views) {
                   if (view.getId() == id) {
                	   viewResult = view;
                	   return viewResult;
                   }
               }
               throw new AssertionError();
           }
       }, 50000, String.format("View type: %s, View name: %s", viewClass.getSimpleName(), getViewName(id)));
   }
   
   public static  <T extends View> T getView(final Class<T> viewClass,final String contentDescription){
	   return waitForView(new IGetView<T>() {
           @Override
           public T getView() {
               for (T view : solo.getCurrentViews(viewClass)) {
                   if (TextUtils.equals(view.getContentDescription(), contentDescription)) {
                       return view;
                   }
               }
               throw new AssertionError();
           }
       }, 50000, String.format("View type: %s, View content description: %s", viewClass.getSimpleName(), contentDescription));
  
   }

   
   public static <T extends TextView> T getViewByText(final Class<T> viewClass, final String text) {
       return waitForView(new IGetView<T>() {
           @Override
           public T getView() {
               ArrayList<T> views = solo.getCurrentViews(viewClass);
               for (T view : views) {
                   if (view.getText().toString().equals(text)) {
                       if (view.isShown())
                           return view;
                   }
               }
               throw new AssertionError();
           }
       }, 50000, String.format("View type: %s, View text: %s", viewClass.getSimpleName(), text));
   }
   
public static <T extends View> T waitForView(IGetView<T> getViewCallback, int timeout, String errMsg) {
    T view = null;
    long endTime = System.currentTimeMillis() + timeout;
    do {
        try {
            view = getViewCallback.getView();
        } catch (AssertionError e) {
            sleep(2000);
        }
    } while (null == view && endTime > System.currentTimeMillis());

    if (null == view) {
        throw new AssertionError("Cannot find the specified View: " + errMsg);
    } else {
        return view;
    }
}

public static String getViewName(int viewId) {
    if (View.NO_ID == viewId) {
        return "NO_ID";
    } else {
        try {
            return instrumentation.getTargetContext().getResources().getResourceName(viewId);
        } catch (Resources.NotFoundException e) {
            return "No resource name for this view: hardcoded Id is " + String.valueOf(viewId);
        }
    }
   
}
}