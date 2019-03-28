package sr.unasat.nyusu.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import sr.unasat.nyusu.R;
import sr.unasat.nyusu.services.CurrencyService;
import sr.unasat.nyusu.services.TimeService;
import sr.unasat.nyusu.services.WeatherService;
import sr.unasat.nyusu.adapters.CurrencyListAdapter;
import sr.unasat.nyusu.adapters.OilpriceListAdapter;
import sr.unasat.nyusu.entities.Currency;
import sr.unasat.nyusu.entities.OilPrice;
import sr.unasat.nyusu.helpers.Helper;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ListView listviewOilpricesList;

    //get oilprices
    OilPrice[] oilPrices = {
            new OilPrice(1, 6.39, 6.24),
            new OilPrice(2, 6.42, 6.26)
    };



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        listviewOilpricesList = view.findViewById(R.id.listview_oilpriceslist);

        //check if there is internet
        if(Helper.isConnectedToInternet(getActivity())){
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Fetching data, please wait");
            progressDialog.show();

            //do api calls
            getHomeData(view);

            progressDialog.dismiss();
        }else{
            //no inernet
            Toast.makeText(getActivity(),"No Internet",Toast.LENGTH_SHORT).show();
        }



        OilpriceListAdapter oilpriceListAdapter = new OilpriceListAdapter(this.getActivity(), oilPrices);
        listviewOilpricesList.setAdapter(oilpriceListAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    public void getHomeData(View view){
        setWeatherData(view);
        setTimeData(view);
        setCurrencyData(view);
    }

    public void setWeatherData(View view){
        WeatherService weatherService = new WeatherService(this.getActivity(), view);
        weatherService.getWeatherData();
    }

    public void setTimeData(View view){
        TimeService timeService = new TimeService(this.getContext(), view);
        timeService.getTimeData();
    }

    public void setCurrencyData(View view){
        CurrencyService currencyService = new CurrencyService(getActivity(), view);
        currencyService.getCurrencyData();
    }





}
