import { shallowMount } from '@vue/test-utils'
import Footer from '../../components/Footer.vue'

describe('Footer', () => {
    test('is a Vue instance', () => {
        const wrapper = shallowMount(Footer)
        expect(wrapper.isVueInstance()).toBeTruthy()
    })
    test('renders the footer div', () => {
        const wrapper = shallowMount(Footer)
        expect(wrapper.contains('.footer')).toBeTruthy()
    })
    test('has a paragraph', () => {
        const wrapper = shallowMount(Footer)
        expect(wrapper.contains('p')).toBeTruthy()
    })
})