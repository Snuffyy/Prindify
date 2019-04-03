<template>
  <div id="app">
    <div>
      <WatchProduct v-bind:shared="returnShared()" v-if="returnShared().isWatchingProduct" />
      <Product v-bind:products="returnShared().productsList" v-else/>
    </div>
  </div>
</template>

<script>
    import Product from '../components/Product'
    import WatchProduct from '../components/WatchProduct'

    export default {
        name: 'Home',
        components: {
            Product, WatchProduct
        }
    }
</script>

<style>
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }
  body {
    font-family: Arial, Helvetica, sans-serif;
    line-height: 1.4;
  }
</style>
