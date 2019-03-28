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

    ListView listviewCurrencyList, listviewOilpricesList;

    //get currencies
    Currency[] currencies = {
            new Currency(1, "USD", "$", 7.396, 7.520),
            new Currency(2, "EUR", "€", 8.319, 8.456)
    };

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

        listviewCurrencyList = view.findViewById(R.id.listview_currencylist);
        listviewOilpricesList = view.findViewById(R.id.listview_oilpriceslist);

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

        CurrencyListAdapter currencyListAdapter = new CurrencyListAdapter(this.getActivity(), currencies);
        listviewCurrencyList.setAdapter(currencyListAdapter);

        OilpriceListAdapter oilpriceListAdapter = new OilpriceListAdapter(this.getActivity(), oilPrices);
        listviewOilpricesList.setAdapter(oilpriceListAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    public void getHomeData(View view){
        setWeatherData(view);
        doGreeting(view);
    }

    public void setWeatherData(View view){
        WeatherService weatherService = new WeatherService(this.getActivity(), view);
        weatherService.getWeatherData();
    }

    public void doGreeting(View view){
        TextView greetinText = view.findViewById(R.id.textview_greeting);

        TimeService timeService = new TimeService(this.getContext());
        greetinText.setText(timeService.getTimeText());
    }




}
