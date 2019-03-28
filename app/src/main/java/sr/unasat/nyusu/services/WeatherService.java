package sr.unasat.nyusu.services;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.thbs.skycons.library.CloudFogView;
import com.thbs.skycons.library.CloudMoonView;
import com.thbs.skycons.library.CloudRainView;
import com.thbs.skycons.library.CloudSnowView;
import com.thbs.skycons.library.CloudSunView;
import com.thbs.skycons.library.CloudView;
import com.thbs.skycons.library.MoonView;
import com.thbs.skycons.library.SunView;
import com.thbs.skycons.library.WindView;

import org.json.JSONException;
import org.json.JSONObject;

import sr.unasat.nyusu.R;
import sr.unasat.nyusu.entities.Weather;

public class WeatherService {

    private Activity context;
    private View view;
    private Weather weather;

    //dark sky api key
    private final String key = "cc70f3c6383bf977304c78cc71396e6c";

    public WeatherService(Activity context, View view) {
        this.context = context;
        this.view = view;
        this.weather = new Weather();
    }

    public void getWeatherData() {
        //default location
        double latitude = 5.710426;
        double longitude = -55.164007;

        LocationService locationService = new LocationService(context);
        if(locationService.canGetLocation()){
            latitude = locationService.getLatitude();
            longitude = locationService.getLongitude();
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            locationService.showSettingsAlert();
        }

        String url ="https://api.darksky.net/forecast/"+key+"/"+latitude+","+longitude;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("Reponse", response.toString());

                try {
                    JSONObject jsonObject = response.getJSONObject("currently");

                    weather.setSummary(jsonObject.getString("summary"));
                    weather.setIcon(jsonObject.getString("icon"));
                    weather.setTemperature(jsonObject.getDouble("temperature"));

                    setWeatherData();

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

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonObjectRequest);

        return;
    }

    private void setWeatherData(){
        setWeatherText();
        setWeatherIcon();
    }

    private Double fahrenheitToCelcius(Double fahrenheit){
        return (fahrenheit - 32) * 5/9;
    }

    private void setWeatherText(){
        TextView textViewSummary = view.findViewById(R.id.textview_weather_summary);
        TextView textViewTemperature = view.findViewById(R.id.textview_weather_temperature);
        textViewSummary.setText(weather.getSummary());
        textViewTemperature.setText(String.format("%.0f", fahrenheitToCelcius(weather.getTemperature())) + "°");
    }


    private void setWeatherIcon(){
        int iconMeasure = 250;
        String iconColor = "#616161";
        String iconBackgroundColor = "#ffffff";
        String yellowColor = "#FDD835";

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        params.width = iconMeasure;
        params.height = iconMeasure;

        LinearLayout linearLayoutWeather = view.findViewById(R.id.linearlayout_weather);

        switch (weather.getIcon()){
            case "clear-day":
                SunView sunView = new SunView(context,false,true, Color.parseColor(yellowColor), Color.parseColor(iconBackgroundColor));
                sunView.setLayoutParams(params);
                linearLayoutWeather.addView(sunView);
                break;

            case "clear-night":
                MoonView moonView = new MoonView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                moonView.setLayoutParams(params);
                linearLayoutWeather.addView(moonView);
                break;

            case "rain":
                CloudRainView cloudRainView = new CloudRainView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                cloudRainView.setLayoutParams(params);
                linearLayoutWeather.addView(cloudRainView);
                break;

            case "snow":
                CloudSnowView cloudSnowView = new CloudSnowView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                cloudSnowView.setLayoutParams(params);
                linearLayoutWeather.addView(cloudSnowView);
                break;

            case "sleet":
                CloudSnowView cloudSleetView = new CloudSnowView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                cloudSleetView.setLayoutParams(params);
                linearLayoutWeather.addView(cloudSleetView);
                break;

            case "wind":
                WindView windView = new WindView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                windView.setLayoutParams(params);
                linearLayoutWeather.addView(windView);
                break;

            case "fog":
                CloudFogView cloudFogView = new CloudFogView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                cloudFogView.setLayoutParams(params);
                linearLayoutWeather.addView(cloudFogView);
                break;

            case "cloudly":
                CloudView cloudView = new CloudView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                cloudView.setLayoutParams(params);
                linearLayoutWeather.addView(cloudView);
                break;

            case "partly-cloudy-day":
                CloudSunView cloudSunView = new CloudSunView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                cloudSunView.setLayoutParams(params);
                linearLayoutWeather.addView(cloudSunView);
                break;

            case "partly-cloudy-night":
                CloudMoonView cloudMoonView = new CloudMoonView(context,false,true, Color.parseColor(iconColor), Color.parseColor(iconBackgroundColor));
                cloudMoonView.setLayoutParams(params);
                linearLayoutWeather.addView(cloudMoonView);
                break;

            default:
                SunView defaultView = new SunView(context,false,true, Color.parseColor(yellowColor), Color.parseColor(iconBackgroundColor));
                defaultView.setLayoutParams(params);
                linearLayoutWeather.addView(defaultView);
        }

    }
}
