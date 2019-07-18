<template>
    <v-layout>
        <!--        вешаем сщбытие на клавешу-->
        <!--        @keyup.enter="save"-->
        <v-text-field
                label="New message"
                placeholder="Some write"
                v-model="text"
                @keyup.enter="save"
        >
        </v-text-field>
        <v-btn v-on:click="save">Save</v-btn>
    </v-layout>
</template>

<script>
    import {mapActions} from 'vuex'

    export default {
        props: ['messageAttr'],
        data() {
            return {
                text: '',
                id: null
            }
        },
        watch: {
            messageAttr(newVal, oldVal) {
                this.id = newVal.id
                this.text = newVal.text

            }
        },

        methods: {
            ...mapActions(['addMessageAction', 'updateMessageAction']),
            save() {
                const message = {
                    id: this.id,
                    text: this.text
                }
                if (this.id) {
                    this.updateMessageAction(message)
                } else {
                    this.addMessageAction(message)
                }
                this.id = null
                this.text = ''
            }
        }
    }
</script>

<style>

</style>