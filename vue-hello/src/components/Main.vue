<style scoped>
    .layout{
        text-align: center;
        font-size: 25px;
      line-height: 210px;

    }
</style>
<template>
<div class="layout">

    欢迎使用在线考试系统！


    <Carousel autoplay v-model="value" loop>
            <CarouselItem>
                <div class="demo-carousel">1.可以添加图片来进行装饰</div>
            </CarouselItem>
            <CarouselItem>
                <div class="demo-carousel">2.也可以添加一些文字</div>
            </CarouselItem>
            <CarouselItem>
                <div class="demo-carousel">3.欢迎使用本系统</div>
            </CarouselItem>
            <CarouselItem>
                <div class="demo-carousel">4.祝考试愉快</div>
            </CarouselItem>
        </Carousel>
</div>
</template>

<script>
    export default {
        data () {
            return {
                value: 0


            };
        }
        }

</script>
