<template>
        <div class="productContainer">
            <!--v-bind:key="product.id" v-for="product in products"-->
            <img src="https://via.placeholder.com/80x70/efefef/000000?text=Tshirt" alt="product">
            <p class="productName">{{oneProduct.name}}</p>
            <p id="price-p">Price: <strong>{{oneProduct.price}} €</strong></p>
            <div class="watchButtonDiv"><button type="button" v-on:click="watchItem(oneProduct)">WATCH</button></div>
        </div>
</template>

<script>
    export default {
        name: 'SingleProduct',
        props: ["oneProduct"]
    }
</script>

<style scoped>
    img {
        display: block;
    }
    .productContainer {
        float: left;
        margin: 0.5% 0.25% 0.5% 0.6%;
        border: 1px solid black;
    }
    p {
        text-align: center;
    }
    button {
        background-color: dodgerblue;
        text-decoration: none;
        border: none;
        color: white;
        padding: 8px 24px;
        text-align: center;
        display: inline-block;
        font-size: 8px;
    }
    .watchButtonDiv {
        text-align: center;
        margin-bottom: 5px;
        margin-top: 5px;

    }
    button:focus {
        outline: 0;
    }
    button:hover {
        background-color: black;
        color: white;
    }
    .productName {
        margin-top: 5px;
    }
</style>