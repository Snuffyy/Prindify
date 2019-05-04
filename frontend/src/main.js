import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false


function request(method, url, data) {
    return fetch(url, {
        credentials: 'include',
        method,
        headers: { "Content-Type": "application/json" },
        body: data
    })
        .then(response => response.json())
}

function get(url) {
    return request('GET', url, null)
}
function post(url, data) {
    return request('POST', url, data)
}


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
            let forCart = {
                count: 2,
                product: {
                    id: 1,
                }
            };
            let forRegister = {
                id: 1,
                name: "Design",
                productName: "Design",
                quantity: 1,
                description: "User-designed T-shirt",
                material: document.querySelector("select[name='material']").value.toUpperCase(),
                type: "GENERIC",
                size: document.querySelector("input[name='size']:checked").value.toUpperCase(),
                price: Math.floor((Math.random() * 50) + 20),
                image_url: "https://google.com"
            };
            shared.inCart.push(forRegister)
            /*navigator.sendBeacon('localhost:8080/api/baskets/item', designed)*/
            forCart = JSON.stringify(forCart)
            forRegister = JSON.stringify(forRegister)

            //post('http://localhost:8080/api/t-shirts', forRegister).then(post('http://localhost:8080/api/baskets/item', forCart))

            post('http://localhost:8080/api/t-shirts', forRegister)
            console.log(get("http://localhost:8080/api/session"))

            post('http://localhost:8080/api/baskets/item', forCart)
            console.log(get("http://localhost:8080/api/session"))
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
        },
        cartPrice: function () {
            let k = 0;
            for(let i = 0; i < shared.inCart.length; i++){
                k += shared.inCart[i].price * shared.inCart[i].quantity;
            }
            return k
        }
    },
    componentNames: ['Product', 'WatchProduct'],
    componentName: 'Product',
})

fetch('http://localhost:8080/api/products')
    .then(resp => resp.json())
    .then(function(data) {
        // console.log("HERE: " + data)
        shared.productsList = data
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
    /*productsList: [
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
    ],*/
    productsList: [],
    inCart: [
        {
            id: 1,
            productName: "T-shirt 1",
            name: "T-shirt 1",
            description: "blah blah blah",
            material: "100% cotton",
            category: "T-shirts",
            size: "M",
            available: true,
            price: 25,
            imageLink: "https://google.com",
            quantity: 2
        },
        {
            id: 2,
            productName: "T-shirt 2",
            name: "T-shirt 2",
            description: "blah blah blah2",
            material: "100% cotton",
            category: "T-shirts",
            size: "S",
            available: true,
            price: 44,
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
