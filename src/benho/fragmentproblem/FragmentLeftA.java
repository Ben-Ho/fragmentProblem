package benho.fragmentproblem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentLeftA extends Fragment {

	public OnClickListener mOnClickListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Button btn = new Button(getActivity());
		btn.setText("Open Fragment B");
		btn.setOnClickListener(this.mOnClickListener);
		return btn;
	}
}
