<template>
    <v-container>
        <v-layout justify-space-around>
            <v-list>
                <v-list-tile
                        v-for="item in subscriptions"
                        :key="item.subscriber.id"
                >
                    <user-link
                            :user="item.subscriber"
                            size="24"
                    ></user-link>

                    <v-btn
                            @click="changeSubscriptionStatus(item.subscriber.id)"
                    >
                        {{item.active ? "Dismiss" : "Approve"}}
                    </v-btn>
                </v-list-tile>
            </v-list>
        </v-layout>
    </v-container>
</template>

<script>
    import profileApi from '../api/profile'
    import UserLink from '../components/UserLink.vue'
    import Vue from 'vue'

    export default {
        name: 'Subscriptions',
        components: {UserLink},
        data() {
            return {
                subscriptions: []
            }
        },
        methods: {
            async changeSubscriptionStatus(subscriberId) {

               const response =  await profileApi.changeSubscriptionStatus(subscriberId)
                   .catch((err) => {
                       console.log('err')
                       console.log(err)
                   })

                if (response.ok) {
                    const subscriptionIndex = this.subscriptions.findIndex(item =>
                        item.subscriber.id === subscriberId
                    )
                    const subscription = this.subscriptions[subscriptionIndex]
                    this.subscriptions = [
                        ...this.subscriptions.slice(0, subscriptionIndex),
                        {
                            ...subscription,
                            active: !subscription.active
                        },
                        ...this.subscriptions.slice(subscriptionIndex + 1)
                    ]
                } else {
                    console.log('trable')
                }
            }
        },
        async beforeMount() {
            const resp = await profileApi.subscriberList(this.$store.state.profile.id)
            this.subscriptions = await resp.json()

        }
    }
</script>

<style scoped>
</style>


<!--<template>-->
<!--    <v-content>-->
<!--        <v-layout justify-space-around>-->
<!--            <v-list>-->
<!--                <v-list-tile-->
<!--                        v-for="item in subscriptions">-->
<!--                    <user-link-->
<!--                            :user="item.subscriber"-->
<!--                            size="24"-->
<!--                    ></user-link>-->

<!--                    <v-btn-->
<!--                            @click="changeSubscriptionStatus(item.subscriber.id)"-->
<!--                    >-->
<!--                        {{item.active ? "Dismiss" : "Approve"}}-->
<!--                    </v-btn>-->
<!--                </v-list-tile>-->
<!--            </v-list>-->
<!--        </v-layout>-->
<!--    </v-content>-->
<!--</template>-->

<!--<script>-->
<!--    import UserLink from "../components/UserLink.vue";-->
<!--    import profileApi from "api/profile"-->

<!--    export default {-->
<!--        name: "Subscriptions",-->
<!--        components: {UserLink},-->
<!--        data() {-->
<!--            return {-->
<!--                subscriptions: []-->
<!--            }-->
<!--        },-->
<!--        methods: {-->
<!--            async changeSubscriptionStatus(subscriberId) {-->
<!--                await profileApi.changeSubscriptionStatus(subscriberId)-->
<!--                const subscriptionIndex = this.subscriptions.findIndex(item =>-->
<!--                    item.subscriber.id === subscriberId-->
<!--                )-->
<!--                const subscription = this.subscriptions[subscriptionIndex]-->
<!--                this.subscriptions = [-->
<!--                    ...this.subscriptions.slice(0, subscriptionIndex),-->
<!--                    {-->
<!--                        ...subscription,-->
<!--                        active: !subscription.active-->
<!--                    },-->
<!--                    ...this.subscriptions.slice(subscriptionIndex + 1)-->
<!--                ]-->
<!--            }-->
<!--        },-->
<!--        async beforeMount() {-->
<!--            const resp = await profileApi.subscriberList(this.$store.state.profile.id)-->
<!--            this.subscriptions = await resp.json();-->

<!--        }-->
<!--    }-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->