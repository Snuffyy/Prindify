<template>
    <div id="divToChange">
        <!--<component v-bind:is="componentName() === 'Product'">WOW WOWO WOOWOOWO</component>-->
        <div v-bind:key="product.id" v-for="product in products">
            <!--<ul>-->
                <!--<li>Category: {{product.category}}</li>-->
                <!--<li>Available: {{product.available}}</li>-->
                <!--&lt;!&ndash;<li>Image: <img :src="product.imageLink" alt="product"></li>&ndash;&gt;-->
                <!--<li>Image: <img src="https://via.placeholder.com/150/efefef/000000?text=Tshirt" alt="product"></li>-->
            <!--</ul>-->
            <div class="productContainer">
                <img src="https://via.placeholder.com/150/efefef/000000?text=Tshirt" alt="product">
                <p class="productName">{{product.productName}}</p>
                <p>Price: <strong>{{product.priceEur}} €</strong></p>
                <div class="watchButtonDiv"><button type="button" v-on:click="watchItem(product)">Vaata</button></div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Product',
        props: ["products"]
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
        font-size: 16px;
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
