package sr.unasat.nyusu.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sr.unasat.nyusu.R;
import sr.unasat.nyusu.entities.Currency;

public class CurrencyListAdapter extends BaseAdapter {

    private Activity context;
    private ArrayList<Currency> currencies;

    public CurrencyListAdapter(Activity context, ArrayList<Currency> currencies) {
        this.context = context;
        this.currencies = currencies;
    }

    @Override
    public int getCount() {
        return currencies.size();
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
        View view = context.getLayoutInflater().inflate(R.layout.currency_inflater, null);

        TextView currencySymbol = view.findViewById(R.id.textview_currency_symbol);
        TextView currencyBuy = view.findViewById(R.id.textview_currency_buy);
        TextView currencySell = view.findViewById(R.id.textview_currency_sell);

        currencySymbol.setText(currencies.get(position).getSymbol() + " - " + currencies.get(position).getName());
        currencyBuy.setText(String.valueOf(currencies.get(position).getBuy()));
        currencySell.setText(String.valueOf(currencies.get(position).getSell()));

        return view;
    }

}
