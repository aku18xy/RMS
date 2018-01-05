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
public class DeployFragment extends Fragment implements View.OnClickListener {

    Button btnNmea, btnSite, btnManage;

    public DeployFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_deploy, container, false);

        btnNmea = v.findViewById(R.id.btnNmea);
        btnSite = v.findViewById(R.id.btnSite);
        btnManage = v.findViewById(R.id.btnManage);

        btnNmea.setOnClickListener(this);
        btnSite.setOnClickListener(this);
        btnManage.setOnClickListener(this);

//        loadFragment(new NmeaFragment());
        return v;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.btnNmea:
                fragment = new NmeaFragment();
                loadFragment(fragment);
                btnNmea.setEnabled(false);
                btnSite.setEnabled(true);
                btnManage.setEnabled(true);
                break;
            case R.id.btnSite:
                fragment = new SiteFragment();
                loadFragment(fragment);
                btnNmea.setEnabled(true);
                btnSite.setEnabled(false);
                btnManage.setEnabled(true);
                break;
            case R.id.btnManage:
                fragment = new ManageFragment();
                loadFragment(fragment);
                btnNmea.setEnabled(true);
                btnSite.setEnabled(true);
                btnManage.setEnabled(false);
                break;
        }

    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction FT = getFragmentManager().beginTransaction();
        FT.replace(R.id.flDeploy, fragment);
        FT.commit();
    }
}
