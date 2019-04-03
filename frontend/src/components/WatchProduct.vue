<template>
    <div>
        <div class="backButtonDiv"><button type="button" v-on:click="goToList">Back</button></div>
        <div class="productName">{{shared.product.name}}</div>
        <br/>
        <div class="productView">
            <div class="leftSide">
                <img src="https://via.placeholder.com/220/efefef/000000?text=Tshirt" alt="product">
            </div>
            <div class="rightSide">
                <div class="size"><p>Size: {{shared.product.size}}</p></div><br/>
                <div class="material"><p>Material: {{shared.product.material}}</p></div><br/>
                <div class="description"><p>Description: {{shared.product.description}}</p></div><br/>
                <div class="price"><p>Price: <strong>{{shared.product.price}} €</strong></p></div>
            </div>
        </div>
        <div class="addToCartButton"><button type="button" v-on:click="addToCart(shared.product)">Add to cart</button></div>
        <p>People also watch:</p>
        <div v-bind:key="product.id" v-for="product in returnShared().productsList">
            <SingleProduct v-bind:oneProduct="product"></SingleProduct>
        </div>
    </div>
</template>

<script>
    import SingleProduct from '../components/SingleProduct'

    export default {
        name: "WatchProduct",
        props: ["shared"],
        components: {
            SingleProduct
        }
        // ,
        // data() {
        //     return {
        //         productsList: [
        //             {
        //                 id: 1,
        //                 productName: "T-shirt 1",
        //                 description: "blah blah blah",
        //                 material: "100% cotton",
        //                 category: "T-shirts",
        //                 size: "M",
        //                 available: true,
        //                 priceEur: 25,
        //                 imageLink: "https://google.com"
        //             },
        //             {
        //                 id: 2,
        //                 productName: "T-shirt 2",
        //                 description: "blah blah blah2",
        //                 material: "100% cotton",
        //                 category: "T-shirts",
        //                 size: "S",
        //                 available: true,
        //                 priceEur: 44,
        //                 imageLink: "https://google.com"
        //             },
        //             {
        //                 id: 3,
        //                 productName: "T-shirt 3",
        //                 description: "blah blah blah3",
        //                 material: "100% cotton",
        //                 category: "T-shirts",
        //                 size: "S",
        //                 available: true,
        //                 priceEur: 28,
        //                 imageLink: "https://google.com"
        //             }
        //         ]
        //     }
        // }
    }
</script>

<style scoped>
    button {
        background-color: dodgerblue;
        text-decoration: none;
        border: none;
        color: white;
        padding: 4px 12px;
        text-align: center;
        display: inline-block;
        font-size: 12px;
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
        font-size: 20px;
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