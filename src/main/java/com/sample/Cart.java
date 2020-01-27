package com.sample;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;

public class Cart {

    private JSONArray products;

    private HashMap<Integer, Integer> productList = new HashMap<>();

    private float postage = 0;
    private float totalCost = 0;
    private float finalCost = 0;

    public Cart (JSONArray products) {
        this.products = products;
    }

    public JSONObject add (Integer id) {
        JSONObject product = getProductById(id);

        Integer quantity = 0;

        if (productList.containsKey(id)) {
            quantity = productList.get(id);
        }

        productList.put(id, ++quantity);

        float price = Float.parseFloat(product.get("price").toString());
        float weight = Float.parseFloat(product.get("weight").toString());

        postage += 5*weight;
        totalCost += price;

        applyDiscount();

        return respond( id, quantity, price, weight);
    }

    public JSONObject update (Integer id, Integer quantity) {
        JSONObject product = getProductById(id);

        Integer prevQuantity = 0;

        if (productList.containsKey(id)) {
            prevQuantity = productList.get(id);
        }

        float price = Float.parseFloat(product.get("price").toString());
        float weight = Float.parseFloat(product.get("weight").toString());

        postage -= 5*weight * prevQuantity;
        totalCost -= price * prevQuantity;

        if (quantity <= 0) {
            quantity = 0;
            productList.remove(id);
        } else {
            postage += 5*weight * quantity;
            totalCost += price * quantity;

            productList.put(id, quantity);
        }

        applyDiscount();

        return respond( id, quantity, price, weight);
    }

    public JSONObject remove(Integer id) {
        JSONObject product = getProductById(id);

        Integer prevQuantity = 0;

        if (productList.containsKey(id)) {
            prevQuantity = productList.get(id);
        }

        float price = Float.parseFloat(product.get("price").toString());
        float weight = Float.parseFloat(product.get("weight").toString());

        postage -= 5*weight * prevQuantity;
        totalCost -= price * prevQuantity;

        productList.remove(id);

        applyDiscount();

        return respond( id);
    }

    private JSONObject respond (Integer id) {
        return respond(id, 0, 0, 0);
    }

    private JSONObject respond (Integer id, Integer quantity, float price, float weight) {
        JSONObject response = new JSONObject();

        response.put("success", true);

        JSONObject data = new JSONObject();
        JSONObject responseProduct = new JSONObject();
        JSONObject responseCart = new JSONObject();

        responseProduct.put("id", id);
        responseProduct.put("quantity", quantity);

        if (quantity > 0) {
            responseProduct.put("price", quantity * price);
            responseProduct.put("weight", quantity * weight);
        }

        responseCart.put("postage", postage);
        responseCart.put("finalCost", finalCost);
        responseCart.put("discounted", totalCost > 100);

        data.put("product", responseProduct);
        data.put("cart", responseCart);
        response.put("data", data);

        return response;
    }

    private JSONObject getProductById (Integer id) {
        JSONParser parser = new JSONParser();
        JSONArray filteredProducts = null;

        try {
            filteredProducts = (JSONArray) parser.parse(JsonPath.read(products, "$.*[?(@.ID==\"" + id + "\")]").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject product = (JSONObject) filteredProducts.get(0);

        return product;
    }

    private void applyDiscount () {
        if (totalCost > 100) {
            finalCost = (float) (totalCost * 0.9);
        } else {
            finalCost = totalCost;
        }
    }

    public HashMap<Integer, Integer> getProductList () {
        return productList;
    }

    public float getFinalCost () {
        return finalCost;
    }

    public float getPostage () {
        return postage;
    }
}
