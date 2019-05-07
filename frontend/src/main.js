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
            // TODO: recheck
            shared.isWatchingProduct = true
            shared.product = product
        },
        deleteFromCart: function (product) {
            // TODO: recheck
            let tmpUrl = 'http://localhost:8080/api/baskets/item/' + product.id;
            fetch(tmpUrl, {
                credentials: 'include',
                method: 'delete',
                headers: {'Content-Type': 'application/json'}
            })
                .then(response => response.json())
            shared.cart.splice(shared.inCart.indexOf(product), 1)
            shared.cartObj.cart.splice(shared.cartObj.cart.indexOf(product), 1)

        },
        addToCart: function (product) {
            let itemToAdd = {
                count: 1,
                product: {
                    id: product.id,
                }
            };
            product.count = 1
            product.update = 0
            shared.cart.push(product)
            shared.cartObj.cart.push(product)
            post('http://localhost:8080/api/baskets/item', JSON.stringify(itemToAdd))
        },
        addDesign: function () {
            let forCart = {
                count: 2,
                // TODO: redo
                product: {
                    id: 1,
                }
            };
            let forRegister = {
                id: 1,
                name: "Design",
                description: "User-designed T-shirt",
                material: document.querySelector("select[name='material']").value.toUpperCase(),
                type: "GENERIC",
                size: document.querySelector("input[name='size']:checked").value.toUpperCase(),
                price: Math.floor((Math.random() * 50) + 20),
                image_url: "https://google.com",
                count: 1
            };

            shared.cart.push(forRegister)

            forCart = JSON.stringify(forCart)
            forRegister = JSON.stringify(forRegister)

            post('http://localhost:8080/api/t-shirts', forRegister).then(post('http://localhost:8080/api/baskets/item', forCart))

        },
        returnShared: function () {
            return shared
        },
        goToList: function () {
            shared.isWatchingProduct = false
        },
        fetchCart: function () {
            // TODO recheck
            fetch('http://localhost:8080/api/baskets')
                .then(resp => resp.json())
                .then(function(data) {
                    shared.inCart = data.items
                })
            return shared.inCart
        },
        returnCart: function () {
            // TODO: recheck
            // return shared.inCart
            // for (let i = 0; i < shared.cart.length; i++) {
            //     shared.cart[i].count = 22
            // }
            return shared.cart
        },
        returnCartObjCart: function () {
            // for (let i = 0; i < shared.cartObj.cart.length; i++) {
            //     shared.cartObj.cart[i].count = 33
            // }
            return shared.cartObj.cart
        },
        cartPrice: function () {
            let tmp_price = 0;
            // for(let i = 0; i < shared.inCart.length; i++){
            //     tmp_price += shared.inCart[i].product.price * shared.inCart[i].count;
            // }
            for(let i = 0; i < shared.cart.length; i++){
                tmp_price += shared.cart[i].price * shared.cart[i].count;
            }
            return tmp_price
        },
        returnItemCount: function (item) {
            return item.count
        },
        reset: function () {
            shared.cart = []
            shared.cartObj.cart = []
        }
    },
    componentNames: ['Product', 'WatchProduct'],
    componentName: 'Product',
})

fetch('http://localhost:8080/api/products')
    .then(resp => resp.json())
    .then(function(data) {
        shared.productsList = data
    })

fetch('http://localhost:8080/api/baskets') // todo recheck
    .then(resp => resp.json())
    .then(function(data) {
        shared.inCart = data.items
    })

const shared =  {
    isWatchingProduct: false,
    productsList: [],
    inCart: [],
    cart: [],
    cartObj: {
        cart: []
    },
    product: ""
}

export default {
    shared
}

new Vue({
    render: h => h(App),
    router,
    data: shared
}).$mount('#app')
