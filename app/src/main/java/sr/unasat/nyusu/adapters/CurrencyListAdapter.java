package sr.unasat.nyusu.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import sr.unasat.nyusu.R;
import sr.unasat.nyusu.entities.Currency;

public class CurrencyListAdapter extends BaseAdapter {

    private final Activity context;
    private final Currency[] currencies;

    public CurrencyListAdapter(Activity context, Currency[] currencies) {
        this.context = context;
        this.currencies = currencies;
    }

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
        View view = context.getLayoutInflater().inflate(R.layout.currency_inflater, null);

        TextView currencySymbol = view.findViewById(R.id.textview_currency_symbol);
        TextView currencyBuy = view.findViewById(R.id.textview_currency_buy);
        TextView currencySell = view.findViewById(R.id.textview_currency_sell);

        currencySymbol.setText(currencies[position].getSymbol() + " - " + currencies[position].getName());
        currencyBuy.setText(String.valueOf(currencies[position].getBuy()));
        currencySell.setText(String.valueOf(currencies[position].getSell()));

        return view;
    }

}
