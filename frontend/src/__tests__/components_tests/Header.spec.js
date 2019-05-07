// import { shallowMount } from '../../node_modules/@vue/test-utils'
import { shallowMount } from '@vue/test-utils'
import Header from '../../components/Header.vue'

describe('Header', () => {
    test('is a Vue instance', () => {
        const wrapper = shallowMount(Header, {
            stubs: ['router-link']
        })
        expect(wrapper.isVueInstance()).toBeTruthy()
    })
    test('renders nav div', () => {
        const wrapper = shallowMount(Header, {
            stubs: ['router-link']
        })
        expect(wrapper.contains('#nav')).toBeTruthy()
    })
    test('has a header', () => {
        const wrapper = shallowMount(Header, {
            stubs: ['router-link']
        })
        expect(wrapper.contains('h1')).toBeTruthy()
    })
    test('has all 5 links', () => {
        const wrapper = shallowMount(Header, {
            stubs: ['router-link']
        })
        expect(wrapper.findAll('#nav *').length).toBe(5)
    })
})