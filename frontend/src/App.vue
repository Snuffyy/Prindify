<template>
  <div id="app">
    <Header />
    <router-view :cartList="returnShared().inCart" />
    <Footer />
  </div>
</template>

<script>
    import Header from './components/Header'
    import Footer from './components/Footer'
    export default {
        name: "app",
        components: {
            Header, Footer
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
