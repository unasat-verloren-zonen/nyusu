package sr.unasat.nyusu.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sr.unasat.nyusu.R;
import sr.unasat.nyusu.entities.OilPrice;

public class OilpriceListAdapter extends BaseAdapter {

    private final Activity context;
    private final OilPrice[] oilPrices;
    private final int[] oilPriceImages = {
            R.drawable.gow2,
            R.drawable.rb
    };

    public OilpriceListAdapter(Activity context, OilPrice[] oilPrices) {
        this.context = context;
        this.oilPrices = oilPrices;
    }

    @Override
    public int getCount() {
        return oilPrices.length;
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
        View view = context.getLayoutInflater().inflate(R.layout.oilprices_inflater, null);

        ImageView oilpriceImage = view.findViewById(R.id.imageview_oilprice);
        TextView oilpriceUnleaded = view.findViewById(R.id.textview_oilprice_unleaded);
        TextView oilpriceDiesel = view.findViewById(R.id.textview_oilprice_diesel);

        oilpriceImage.setImageResource(oilPriceImages[position]);
        oilpriceUnleaded.setText(String.valueOf(oilPrices[position].getUnleaded()));
        oilpriceDiesel.setText(String.valueOf(oilPrices[position].getDiesel()));

        return view;
    }
}
