import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

Vue.mixin({
    methods: {
        watchItem: function (product) {
            shared.isWatchingProduct = true
            shared.product = product
        },
        deleteFromCart: function (item) {
            shared.inCart.splice(shared.inCart.indexOf(item), 1)
        },
        addToCart: function (item) {
            shared.inCart.push(item)
        },
        addDesign: function () {
            let designed = {
                id: 1,
                productName: "My design",
                description: "N/A (self-designed)",
                material: document.querySelector("select[name='material']").value,
                category: "T-shirts",
                size: document.querySelector("input[name='size']:checked").value,
                available: true,
                priceEur: 20,
                imageLink: "https://google.com" // TODO replace
            }
            shared.inCart.push(designed)
        },
        returnShared: function () {
            return shared
        },
        componentName: function () {
            return this.componentName
        },
        goToList: function () {
            shared.isWatchingProduct = false
        },
        returnCart: function () {
            return shared.inCart
        }
    },
    componentNames: ['Product', 'WatchProduct'],
    componentName: 'Product',
})

const shared =  {
    isWatchingProduct: false,
    product: {
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
    ],
    inCart: [
        {
            id: 1,
            productName: "T-shirt 1",
            description: "blah blah blah",
            material: "100% cotton",
            category: "T-shirts",
            size: "M",
            available: true,
            priceEur: 25,
            imageLink: "https://google.com",
            quantity: 2
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
            imageLink: "https://google.com",
            quantity: 3
        }
    ]
}

// shared.install = function () {
//     Object.defineProperty(Vue.prototype, '$shared', {
//         gets() {
//             return shared
//         }
//     })
// }
//
// Vue.use(shared)
export default {
    shared
}

new Vue({
    render: h => h(App),
    router,
    data: shared
}).$mount('#app')
