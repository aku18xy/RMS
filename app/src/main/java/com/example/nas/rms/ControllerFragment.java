package com.example.nas.rms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ControllerFragment extends Fragment implements View.OnClickListener {

    Button btnSensor, btnOutput, btnFat;


    public ControllerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_controller, container, false);

        btnSensor = v.findViewById(R.id.btnSensor);
        btnOutput = v.findViewById(R.id.btnOutput);
        btnFat = v.findViewById(R.id.btnFat);

        btnSensor.setOnClickListener(this);
        btnOutput.setOnClickListener(this);
        btnFat.setOnClickListener(this);

//        loadFragment(new SensorFragment());
        return v;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.btnSensor:
                fragment = new SensorFragment();
                loadFragment(fragment);
                btnSensor.setEnabled(false);
                btnOutput.setEnabled(true);
                btnFat.setEnabled(true);
                break;
            case R.id.btnOutput:
                fragment = new OutputFragment();
                loadFragment(fragment);
                btnSensor.setEnabled(true);
                btnOutput.setEnabled(false);
                btnFat.setEnabled(true);
                break;
            case R.id.btnFat:
                fragment = new FATFragment();
                loadFragment(fragment);
                btnSensor.setEnabled(true);
                btnOutput.setEnabled(true);
                btnFat.setEnabled(false);
                break;
        }
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction FT = getFragmentManager().beginTransaction();
        FT.replace(R.id.flController, fragment);
        FT.commit();
    }
}
