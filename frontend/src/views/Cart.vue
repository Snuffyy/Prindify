<template>
    <div v-on:load="fetchCart()">
        <!--<div class="cartView" v-if="returnCart() !== undefined && returnCart().length !== 0">-->
        <div class="cartView" v-if="returnCartObjCart() !== undefined && returnCartObjCart().length !== 0">
            <p class="main-header">My cart:</p>
            <!--<div class="cartListView" v-bind:key="item.product.id" v-for="item in returnCart()">-->
                <!--<div class="cartListView" v-bind:key="item.id" v-for="item in returnCart()">-->
                <div class="cartListView" v-bind:key="item.id" v-for="item in returnCartObjCart()">
                <div class="productContainer">
                    <img src="https://via.placeholder.com/100/efefef/000000?text=Tshirt" alt="product">
                    <p class="productName">{{item.name}}</p>
                    <!--<p class="productName">{{item.product.name}}</p>-->
                    <!--<p>Price: <strong>{{item.product.price}} €</strong></p>-->
                    <p>Price: <strong>{{item.price}} €</strong></p>
                    <div id="div-quantity">
                    <button class="btn-quantity" v-on:click="item.count--;if(item.count<=0){item.count=1}item.price++; item.price--">-</button>
                    <!--<button class="btn-quantity" v-on:click="item.count&#45;&#45;;if(item.count<=0 || item.count === undefined){item.count=1}">-</button>-->
                    <!--<button class="btn-quantity" v-on:click="item.count&#45;&#45;;if(item.count<=0 || item.count === undefined){this.$set(item, count, 1)}">-</button>-->
                        <!--tk: {{returnItemCount(item)}}-->
                        tk: {{item.count}}
                        <!--<div v-bind="returnShared().cartObj"></div>-->
                        <!--tk: {{item.count}}-->
                    <button class="btn-quantity" v-on:click="item.count+=1;item.update++;item.price++; item.price--">+</button>
                    </div>
                    <!--<div class="deleteButtonDiv"><button type="button" v-on:click="deleteFromCart(item.product)">Delete</button></div>-->
                    <div><div class="deleteButtonDiv"><button id="delete-btn" type="button" v-on:click="deleteFromCart(item)">Delete</button></div></div>
                </div>
            </div>
            <p id="total">Total: <strong>{{cartPrice()}}€</strong></p>
            <button id="btn-checkout"><router-link to="/ordering">CHECK OUT</router-link></button>
        </div>
        <div id="no-items-div" v-else>
            <p id="no-items">No items in cart yet...</p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Cart"
    }
</script>

<style scoped>
    :root {
        --main-product-display: inline-block;
    }
    button {
        background-color: dodgerblue;
        text-decoration: none;
        border: none;
        color: white;
        padding: 8px 24px;
        text-align: center;
        display: block;
        font-size: 16px;
        margin-left: auto;
        margin-right: auto;
    }
    button:hover {
        background-color: black;
        color: white;
    }
    button:focus {
        outline: 0;
    }
    .productName {
        display: block;
        margin-left: 5px;
        font-size: 24px;
    }
    img {
        display: inline-block;
        margin-left: auto;
        margin-right: auto;
    }
    .productContainer {
        /*display: var(--main-product-display);*/
        display: inline-block;
        border: 1px solid black;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }
    .cartView {
        display: block;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }
    .cartListView {
        display: inline-block;
        text-align: center;
        margin-right: auto;
        margin-left: 5px;
    }
    .btn-quantity {
        display: inline-block;
        padding: 4px 6px;
        border-radius: 100px;
    }
    #div-quantity {
        display: inline-block;
        margin-bottom: 3px;
    }
    .deleteButtonDiv:hover button{
        background-color: red !important;
        color: white;
    }
    #btn-checkout {
        text-decoration: none;
        text-underline: none;
        border: 0;
        margin-top: 5px;
    }
    #btn-checkout a {
        text-decoration: none;
        color: white;
    }
    .deleteButtonDiv {
        text-align: center;
        padding: 0;
        margin-left: auto;
        margin-right: auto;
        width: auto;
    }
    .deleteButtonDiv button {
        text-align: center;
        margin-left: auto;
        margin-right: auto;
        width: 100%;
        display: block;
    }
    .main-header {
        font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        font-size: 28px;
        font-weight: bold;
    }
    #total {
        font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        font-size: 28px;
        margin-bottom: 5px;
        margin-top: 10px;
    }
    #delete-btn {
        object-fit: fill;
    }

    #no-items-div {
        text-align: center;
    }

    #no-items {
        margin-top: 10%;
        color: black;
        font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        font-size: 22px;
    }
</style>