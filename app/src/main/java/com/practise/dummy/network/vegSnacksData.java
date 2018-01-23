package com.practise.dummy.network;

import android.app.VoiceInteractor;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.practise.dummy.contentprovider.VegSnacksDataSource;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by win 8 pc on 1/23/2018.
 */

public class vegSnacksData {
    public static final String VEG_SNACKS_URL = "http://hotspice.000webhostapp.com/veg_snacks.php";

    public static void getVegSnacksData(final Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,VEG_SNACKS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response Veg Snacks", response);
                //Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                try {
                    VegSnacksDataSource vegSnacksDataSource=new VegSnacksDataSource();
                    vegSnacksDataSource.open(context);
                    vegSnacksDataSource.storeVegSnacksData(response,context);
                    vegSnacksDataSource.close(context);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Response", error.toString());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put("restaurantname", "restauranthotspice");
                //returning parameter
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
