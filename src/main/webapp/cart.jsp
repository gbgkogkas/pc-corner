<%@ page import="org.json.simple.JSONArray, org.json.simple.JSONObject, java.text.DecimalFormat, com.sample.Cart, java.text.MessageFormat, java.util.HashMap" %>
<html>
    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-15">
    <head>
        <title>Your PC Corner</title>
        <style>
            html, body {
                padding: 0%;
                margin: 0%;
            }

            div.row {
                position: relative;

                width: 60%;
                margin-left: 20%;
                margin-right: 20%;
            }

            div.row div.row {
                width: 100%;
                margin: 0;
            }

            .button {
                background-color: blue;
                color: white;
                padding: 1em;
            }

            .text-center {
                text-align: center;
            }

            .text-right {
                text-align: right;
            }

            .margin-top {
                margin-top: 1rem;
            }

            .margin-bottom {
                margin-bottom: 1rem;
            }

            .hide {
                display: none;
            }

            header {
                border-bottom: 1px solid black;
            }

            .header-row {
                display: inline-flex;
            }

            .menu-line{
                list-style: none;
                padding: 0%;
                margin: 0%;
            }

            .menu-line li{
                display: table-cell;
                vertical-align: middle;
                height: 2em;
            }

            .header-row .menu-line {
                position: absolute;
                right: 0;

                display: table-row;
                margin-top: 1.4em;
                margin-bottom: 1.4em;
            }

            .header-row .menu-line .button {
                padding: 1em;
                text-decoration: none;
                color: #000;

                background-color: white;
            }

            #products-table, #cart-table {
                width: 100%;
                border-collapse: collapse;
            }

            #products-table thead, #cart-table thead {
                text-align: center;
            }

            #products-table td, #cart-table td {
                border: 1px solid black;
                height: 2em;
            }

            #products-table td .button {
                text-align: center;
                display: block;

                margin-left: auto;
                margin-right: auto;

                padding: 0.3em;
            }

            #cart-table input {
                width: 70%;
            }

            #cart_price_table {
                width: 10rem;

                position: absolute;
                right: 0;

                margin: 0;
                padding: 0;

                list-style: none;
            }

            .cart_price_label{
                text-align: left;
                float: left;
            }

            .button.cart_remove {
                float: right;

                background-color: red;
                padding: 0.2em;
                margin-right: 0.5em;

                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <header>
            <div class="row header-row">
                <a href="/pc-corner" style="text-decoration:none; color:black"><h1>PC Corner</h1></a>
            </div>
        </header>
        <main>
            <div id="discount_notification" class="row text-center hide margin-bottom">
                Congratulation you got a 10% discount
            </div>
            <div class="row">
                <table id="cart-table">
                    <thead>
                        <td>name</td>
                        <td width="10%">weight</td>
                        <td width="10%">quantity</td>
                        <td width="10%">price</td>
                    </thead>
                    <tbody id="cartTable">
                        <%
                            Cart cart = (Cart) session.getAttribute("cart");
                            HashMap<Integer, Integer> cartProductList = null;

                            if (cart != null) {
                                cartProductList = cart.getProductList();
                            }

                            JSONArray products = (JSONArray) request.getAttribute("products");
                            JSONArray inCart = new JSONArray();

                            if (products != null) {
                                for (int i = 0; i < products.size(); i++) {
                                    JSONObject product = (JSONObject) products.get(i);

                                    if (cartProductList != null && cartProductList.containsKey(Integer.valueOf(product.get("ID").toString()))) {
                                        Integer quantity = cartProductList.get(Integer.valueOf(product.get("ID").toString()));

                                        DecimalFormat weightFormat = new DecimalFormat("0.000");
                                        DecimalFormat priceFormat = new DecimalFormat("0.00");

                                        String weight = weightFormat.format(Float.valueOf(product.get("weight").toString()) * quantity);
                                        String price = priceFormat.format(Float.valueOf(product.get("price").toString()) * quantity);

                                        out.println(MessageFormat.format("<tr id=\"product_{4}\" data-product-id=\"{4}\"><td>{0}<a href=\"#\" class=\"button cart_remove\">X</a></td><td><span class=\"weight_display\">{1}</span></td><td><input class=\"quantity\" type=\"number\" value=\"{2}\"/></td><td><span class=\"price_display\">{3}</span> &euro;</td></tr>",
                                            product.get("name"), weight, quantity, price, product.get("ID")));
                                    }
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <div class="row margin-top text-right">
                <ul id="cart_price_table">
                    <li>
                        <span class="cart_price_label">Cost</span>
                        <div><span id="cost_display"><% if (cart != null) {out.println(cart.getFinalCost());} %></span> &euro;</div>
                    </li>
                    <li id="discount_display" class="hide">
                        <span class="cart_price_label">Discount</span>
                        <div>10%</div>
                    </li>
                    <li>
                        <span class="cart_price_label">Postage</span>
                        <div><span id="postage_display"><% if (cart != null) {out.println(cart.getPostage());} %></span> &euro;</div>
                    </li>
                    <li>
                        <span class="cart_price_label">Total cost</span>
                        <div><span id="total_display"><% if (cart != null) {out.println(cart.getFinalCost() + cart.getPostage());} %></span> &euro;</div>
                    </li>
                </ul>
            </div>
        </main>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script>
             $(document).ready(function () {
                var products = <% out.println(products.toString()); %>
                    inCart = <% if (cartProductList != null) {out.println(new JSONObject(cartProductList).toString());} else {out.println("{}");} %>;

                $(document)
                    .on('change', '.quantity', function (e) {
                        var obj = $(this),
                            tr = obj.closest('tr');

                        $.ajax({
                            method: "POST",
                            url: "/pc-corner/cart/update",
                            data: {
                                product_id : tr.data('product-id'),
                                quantity : obj.val(),
                            },
                            success: function (data) {
                                updateCart(data);
                            }
                        });
                    })
                    .on('click', '.cart_remove', function (e) {
                        e.preventDefault();

                        var obj = $(this),
                            tr = obj.closest('tr');

                        $.ajax({
                            method: "POST",
                            url: "/pc-corner/cart/remove",
                            data: {
                                product_id : tr.data('product-id'),
                            },
                            success: function (data) {
                                updateCart(data);
                            }
                        });
                    });

                $('#products .button').on('click', function (e) {
                    e.preventDefault();

                    var obj = $(this);

                    $.ajax({
                        method: "POST",
                        url: "/pc-corner/cart/add",
                        data: {
                            product_id : obj.data('product-id')
                        },
                        success: function (data) {
                            updateCart(data);
                        }
                    });
                });

                function updateCart (data) {
                    var cartTable = $('#cartTable'),
                        cost_display = $('#cost_display'),
                        postage_display = $('#postage_display'),
                        total_display = $('#total_display');

                    if (Object.keys(inCart).indexOf(data.data.product.id.toString()) < 0) {
                        var product = products.filter(function (a,b) {
                            if (a.ID == data.data.product.id)
                                return a;
                        })[0];

                        cartTable.append('<tr id="product_' + data.data.product.id + '" data-product-id="' + data.data.product.id + '"><td>' + product.name + '<a href="#" class="button cart_remove">X</a></td><td><span class="weight_display">' + data.data.product.weight + '<span></td><td><input class="quantity" type="number" value="' + data.data.product.quantity + '"/></td><td><span class="price_display">' + data.data.product.price + '</span> &euro;</td></tr>')

                        inCart[data.data.product.id] = 1;
                    } else {
                        var target = $('#product_' + data.data.product.id);

                        if (data.data.product.quantity) {
                            var quantity = target.find('.quantity'),
                                weight_display = target.find('.weight_display'),
                                price_display = target.find('.price_display');

                            ++inCart[data.data.product.id];

                            weight_display.text(data.data.product.weight);
                            price_display.text(data.data.product.price);
                            quantity.val(data.data.product.quantity);
                        } else {
                            target.remove();

                            delete inCart[data.data.product.id];

                            console.log(inCart);
                        }
                    }

                    cost_display.text(data.data.cart.finalCost);
                    postage_display.text(data.data.cart.postage);
                    total_display.text(data.data.cart.finalCost + data.data.cart.postage);

                    $('#discount_display, #discount_notification').toggle(data.data.cart.discounted);
                }
            });
        </script>
    </body>
</html>