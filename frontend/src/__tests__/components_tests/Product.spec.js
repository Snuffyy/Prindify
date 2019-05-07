import { shallowMount } from '@vue/test-utils'
import Product from '../../components/Product.vue'

describe('Product', () => {
    test('is a Vue instance', () => {
        const wrapper = shallowMount(Product)
        expect(wrapper.isVueInstance()).toBeTruthy()
    })
    test('renders the product container div', () => {
    let json = {"id":1,"name":"Design","description":"User-designed T-shirt","price":68.0,"material":"COTTON","size":"M","type":"T_SHIRT","image_url":"https://google.com", "count": 1};
    const wrapper = shallowMount(Product, {
            propsData: {
                products: [json]
            }
        })
    expect(wrapper.contains('.productContainer')).toBeTruthy()
    })
    test('product container works as expected', () => {
        let json = {"id":1,"name":"Design","description":"User-designed T-shirt","price":68.0,"material":"COTTON","size":"M","type":"T_SHIRT","image_url":"https://google.com", "count": 1};
        const wrapper = shallowMount(Product, {
            propsData: {
                products: [json]
            }
        })
        expect(wrapper.find('.productName').text()).toBe('Design')
        expect(wrapper.find('#price-p').text()).toBe('Price: 68 €')
    })
})