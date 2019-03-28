package sr.unasat.nyusu.services;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import sr.unasat.nyusu.R;
import sr.unasat.nyusu.adapters.CurrencyListAdapter;
import sr.unasat.nyusu.entities.Currency;

public class CurrencyService {
    ArrayList<Currency> currencies;
    Activity activity;
    View view;

    public CurrencyService(Activity activity, View view) {
        this.activity = activity;
        this.view = view;
    }


    public void getCurrencyData() {
        String url ="http://service.e-gostudio.com/api/nyusu/currency/read.php";
        currencies = new ArrayList<Currency>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Response", response.toString());

                try {
                    for(int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        Currency currency = new Currency(
                                jsonObject.getInt("id"),
                                jsonObject.getString("name"),
                                jsonObject.getString("symbol"),
                                jsonObject.getDouble("buy"),
                                jsonObject.getDouble("sell")
                        );

                        currencies.add(currency);
                    }

                    setCurrencyData();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("Error Response", error.toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(activity);
        queue.add(jsonArrayRequest);

        return;
    }

    public void setCurrencyData(){
        CurrencyListAdapter currencyListAdapter = new CurrencyListAdapter(activity, currencies);

        ListView listviewCurrencyList = view.findViewById(R.id.listview_currencylist);
        listviewCurrencyList.setAdapter(currencyListAdapter);
    }
}
