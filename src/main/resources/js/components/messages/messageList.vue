<template>
    <v-container>
        <v-layout align-space-between justify-space-between column>

            <message-form :messageAttr="message"/>
            <message-row
                    v-for="message in sortMessages"
                    :message="message"
                    :key="message.id"
                    :editMessage="editMessage"/>
            <lazy-loader></lazy-loader>
        </v-layout>
    </v-container>
</template>

<script>
    import {mapGetters} from 'vuex'
    import MessageRow from '../messages/MessageRow.vue'
    import MessageForm from '../messages/MessageForm.vue'
    import LazyLoader from "../LazyLoader.vue";

    export default {
        components: {
            LazyLoader,
            MessageRow,
            MessageForm
        },
        data() {
            return {
                message: null
            }
        },
        computed:
            mapGetters(['sortMessages'])
        ,
        methods: {
            editMessage(message) {
                this.message = message
            },
        }
    }
</script>

<style>

</style>