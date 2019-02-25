<template>
    <div>
        <div v-if="cartList !== undefined && cartList.length !== 0">
            <div v-for="item in cartList">
                <div class="productContainer">
                    <img src="https://via.placeholder.com/150/efefef/000000?text=Tshirt" alt="product">
                    <p class="productName">{{item.productName}}</p>
                    <p>Price: <strong>{{item.priceEur}} €</strong></p>
                    <div class="watchButtonDiv"><button type="button" v-on:click="watchItem(item)">Vaata</button></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Cart",
        props: ["cartList"]
    }
</script>

<style scoped>

</style>