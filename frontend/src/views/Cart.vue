<template>
    <div>
        <div v-if="returnCart() !== undefined && returnCart().length !== 0">
            <div v-for="item in returnCart()">
                <div class="productContainer">
                    <img src="https://via.placeholder.com/150/efefef/000000?text=Tshirt" alt="product">
                    <p class="productName">{{item.productName}}</p>
                    <p>Price: <strong>{{item.priceEur}} €</strong></p>
                    <!--<div class="watchButtonDiv"><button type="button" v-on:click="watchItem(item)">Vaata</button></div>-->
                    <div class="watchButtonDiv"><button type="button" v-on:click="deleteFromCart(item)">Kustuta</button></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Cart"
    }
</script>

<style scoped>

</style>