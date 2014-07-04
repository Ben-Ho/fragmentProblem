package benho.fragmentproblem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class FragmentLeftB extends Fragment {

	public OnClickListener mOnClickListenerC;
	public OnClickListener mOnClickListenerD;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout ll = new LinearLayout(getActivity());
		
		Button btnC = new Button(getActivity());
		btnC.setText("Open Fragment C");
		btnC.setOnClickListener(this.mOnClickListenerC);
		ll.addView(btnC);
		
		Button btnD = new Button(getActivity());
		btnD.setText("Open Fragment D");
		btnD.setOnClickListener(this.mOnClickListenerD);
		ll.addView(btnD);
		
		return ll;
	}
}
