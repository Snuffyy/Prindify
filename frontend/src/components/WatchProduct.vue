<template>
    <div>
        <div class="backButtonDiv"><button type="button" v-on:click="goToList">Tagasi</button></div>
        <div class="productName">{{shared.product.productName}}</div>
        <br/>
        <div class="productView">
            <div class="leftSide">
                <img src="https://via.placeholder.com/270/efefef/000000?text=Tshirt" alt="product">
            </div>
            <div class="rightSide">
                <div class="size"><p>Size: {{shared.product.size}}</p></div><br/>
                <div class="material"><p>Material: {{shared.product.material}}</p></div><br/>
                <div class="description"><p>Description: {{shared.product.description}}</p></div><br/>
                <div class="price"><p>Price: <strong>{{shared.product.priceEur}} €</strong></p></div>
            </div>
        </div>
        <div class="addToCartButton"><button type="button">Liisa korvi</button></div>
        <p>Ka vaatavad:</p>
        <!--<Product v-bind:products="shared.productsList" />-->
    </div>
</template>

<script>
    export default {
        name: "WatchProduct",
        props: ["shared"]
    }
</script>

<style scoped>
    button {
        background-color: dodgerblue;
        text-decoration: none;
        border: none;
        color: white;
        padding: 8px 24px;
        text-align: center;
        display: inline-block;
        font-size: 16px;
        margin-left: 5px;
    }
    .backButtonDiv {
        text-align: left;
        margin-bottom: 5px;
        margin-top: 5px;
        display: inline-block;
    }
    button:hover {
        background-color: black;
        color: white;
    }
    button:focus {
        outline: 0;
    }
    .productName {
        display: inline-block;
        margin-left: 5px;
        font-size: 24px;
    }
    img {
        display: inline-block;
    }
    .description, .size, .material, .price {
        display: inline-block;
    }
    .price{
        font-size: 28px;
    }
    .rightSide {
        display: inline-block;
        margin-left: 5px;
        margin-top: 0;
        float: left;
    }
    .leftSide {
        display: inline-block;
        float: left;
    }
    .productView {
        display: inline-block;
    }
    .addToCartButton {
        display: block;
    }
</style>