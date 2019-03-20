<template>
  <div id="app">
    <div>
      <WatchProduct v-bind:shared="returnShared()" v-if="returnShared().isWatchingProduct" />
      <Product v-bind:products="productsList" v-else/>
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
        },
        data() {
            return {
                productsList: [
                    {
                        id: 1,
                        productName: "T-shirt 1",
                        description: "blah blah blah",
                        material: "100% cotton",
                        category: "T-shirts",
                        size: "M",
                        available: true,
                        priceEur: 25,
                        imageLink: "https://google.com"
                    },
                    {
                        id: 2,
                        productName: "T-shirt 2",
                        description: "blah blah blah2",
                        material: "100% cotton",
                        category: "T-shirts",
                        size: "S",
                        available: true,
                        priceEur: 44,
                        imageLink: "https://google.com"
                    },
                    {
                        id: 3,
                        productName: "T-shirt 3",
                        description: "blah blah blah3",
                        material: "100% cotton",
                        category: "T-shirts",
                        size: "S",
                        available: true,
                        priceEur: 28,
                        imageLink: "https://google.com"
                    }
                ]
            }
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
