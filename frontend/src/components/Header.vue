<template>
    <header class="header">
        <h1>Prindify</h1>
        <div id="nav">
            <router-link to="/">Home</router-link> |
            <router-link to="/design">Design</router-link> |
            <router-link to="/about">About</router-link> |
            <router-link to="/contact">Contact</router-link> |
            <router-link to="/cart" v-bind:cartList="returnShared().inCart">SHOPPING CART</router-link>
            <!--<p>{{returnShared().inCart}}</p>-->
        </div>
    </header>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>
.header {
    background: dodgerblue;
    color: white;
    text-align: center;
    padding: 10px;
    margin-bottom: 4px;
}
.header a {
    text-decoration: none;
    color: white;
    margin-right: 5px;
    margin-left: 5px;
}
</style>