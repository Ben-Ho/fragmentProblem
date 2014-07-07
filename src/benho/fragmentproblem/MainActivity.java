package benho.fragmentproblem;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity {
	
	FragmentLeftA mFragmentLeftA;
	FragmentLeftB mFragmentLeftB;
	FragmentRightC mFragmentRightC;
	FragmentRightD mFragmentRightD;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.act_main);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		mFragmentLeftA = new FragmentLeftA();
		mFragmentLeftA.mOnClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mFragmentLeftB == null) {
					mFragmentLeftB = new FragmentLeftB();
					mFragmentLeftB.mOnClickListenerC = new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							if (mFragmentRightC == null) {
								mFragmentRightC = new FragmentRightC();
							}
							FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
							ft.replace(R.id.c_act_main_right, mFragmentRightC);
							ft.addToBackStack(null);
							ft.commit();
						}
					};
					mFragmentLeftB.mOnClickListenerD = new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							if (mFragmentRightD == null) {
								mFragmentRightD = new FragmentRightD();
							}
							FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
							ft.replace(R.id.c_act_main_right, mFragmentRightD);
							ft.addToBackStack(null);
							ft.commit();
						}
					};
				}
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.c_act_main_left, mFragmentLeftB);
				ft.addToBackStack(null);
				ft.commit();
			}
		};
		ft.replace(R.id.c_act_main_left, mFragmentLeftA);
		ft.addToBackStack("firstState");
		ft.commit();
	}
	
	@Override
	public void onBackPressed() {
		FragmentManager fm = getSupportFragmentManager();
		if (!fm.popBackStackImmediate("firstState", 0)) {
			fm.popBackStack();
			super.onBackPressed();
		}
	}
}
