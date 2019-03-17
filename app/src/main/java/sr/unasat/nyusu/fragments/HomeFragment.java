package sr.unasat.nyusu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import sr.unasat.nyusu.R;
import sr.unasat.nyusu.entities.Currency;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ListView listviewCurrencyList;

    //get currencies
    Currency[] currencies = {
            new Currency(2, "USD", "$", 7.396, 7.520),
            new Currency(1, "EUR", "€", 8.319, 8.456)
    };


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listviewCurrencyList = view.findViewById(R.id.listview_currencylist);

        CurrencyListAdapter currencyListAdapter = new CurrencyListAdapter();
        listviewCurrencyList.setAdapter(currencyListAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    private class CurrencyListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return currencies.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.currency_inflater, null);

            TextView currencySymbol = view.findViewById(R.id.textview_currency_symbol);
            TextView currencyBuy = view.findViewById(R.id.textview_currency_buy);
            TextView currencySell = view.findViewById(R.id.textview_currency_sell);

            currencySymbol.setText(currencies[position].getSymbol() + " - " + currencies[position].getName());
            currencyBuy.setText(String.valueOf(currencies[position].getBuy()));
            currencySell.setText(String.valueOf(currencies[position].getSell()));

            return view;
        }
    }

}
