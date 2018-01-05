package com.example.nas.rms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfigFragment extends Fragment implements View.OnClickListener {

    Button btnControll, btnAton, btnUser;

    public ConfigFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_config, container, false);

        btnControll = v.findViewById(R.id.btnControll);
        btnAton = v.findViewById(R.id.btnAton);
        btnUser = v.findViewById(R.id.btnUser);

        btnControll.setOnClickListener(this);
        btnAton.setOnClickListener(this);
        btnUser.setOnClickListener(this);

//        loadFragment(new ControlFragment());

        return v;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.btnControll:
                fragment = new ControlFragment();
                loadFragment(fragment);
                btnControll.setEnabled(false);
                btnAton.setEnabled(true);
                btnUser.setEnabled(true);
                break;
            case R.id.btnAton:
                fragment = new AtonFragment();
                loadFragment(fragment);
                btnControll.setEnabled(true);
                btnAton.setEnabled(false);
                btnUser.setEnabled(true);
                break;
            case R.id.btnUser:
                fragment = new UserFragment();
                loadFragment(fragment);
                btnControll.setEnabled(true);
                btnAton.setEnabled(true);
                btnUser.setEnabled(false);
                break;
        }
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction FT = getFragmentManager().beginTransaction();
        FT.replace(R.id.flConfig, fragment);
//        FT.addToBackStack(null);
        FT.commit();
    }
}
