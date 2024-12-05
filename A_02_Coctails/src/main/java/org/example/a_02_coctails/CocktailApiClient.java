package org.example.a_02_coctails;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class CocktailApiClient {
    private final OkHttpClient client = new OkHttpClient();

    public Cocktail getCocktail(String cocktailName) throws IOException {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + cocktailName;
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            JSONObject jsonResponse = new JSONObject(response.body().string());
            if (jsonResponse.has("drinks") && jsonResponse.getJSONArray("drinks").length() > 0) {
                JSONArray drinksArray = jsonResponse.getJSONArray("drinks");
                JSONObject drink = drinksArray.getJSONObject(0);
                return new Cocktail(
                        drink.getString("strDrink"),
                        drink.getString("strDrinkThumb"),
                        drink.getString("strInstructions")
                );
            }
        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
        return null;
    }
}