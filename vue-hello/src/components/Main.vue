<style scoped>
    .layout{
        text-align: center;
        font-size: 25px;
        line-height: 120px;

    }
</style>
<template>
<div class="layout">
    欢迎使用在线考试系统！

    <Carousel autoplay v-model="value" loop>
            <CarouselItem>
                <div class="demo-carousel"><img src="~@/assets/test1.jpg" height="400"></div>
            </CarouselItem>
            <CarouselItem>
                <div class="demo-carousel"><img src="~@/assets/3.jpg" height="400"></div>
            </CarouselItem>
            <CarouselItem>
                <div class="demo-carousel"><img src="~@/assets/18.jpg" height="400"></div>
            </CarouselItem>
            <CarouselItem>
                <div class="demo-carousel"><img src="~@/assets/16.jpg" height="400"></div>
            </CarouselItem>
        </Carousel>
</div>
</template>

<script>
    export default {
        data () {
            return {
                value: 1


            };
        }
        }

</script>
