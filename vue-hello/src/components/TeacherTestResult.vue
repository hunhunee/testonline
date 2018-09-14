<style scoped>


</style>
<template>
  <div>
    <div id="layout" :style="{width: '600px', height: '500px'}"></div>
    <div id="layout1" :style="{bottom:'500px',left:'600px',width: '300px', height: '500px' }"></div>
  </div>
</template>
<script>
    export default {
        data () {
            return {
             data:[10, 20, 36, 5],
             data1:[49,95,78]
            };
        }
        ,
  mounted(){
    this.drawLine();
  },
  methods: {
    drawLine(){
        // 基于准备好的dom，初始化echarts实例
        let myChart = this.$echarts.init(document.getElementById('layout'))
        let myChart1 = this.$echarts.init(document.getElementById('layout1'))
        // 绘制图表
        myChart.setOption({
            title: { text: '成绩分布' },
            tooltip: {},
            xAxis: {
                data: ["0-59","60-79","80-89","90-100"]
            },
            yAxis: {},
            series: [{
                name: '成绩',
                type: 'bar',
                data:this.data
            }]
        });


        myChart1.setOption({
            title: { text: '分差' },
            tooltip: {},
            xAxis: {
                data: ["最高分","最低分","平均分"]
            },
            yAxis: {},
            series: [{
                name: '分差',
                type: 'bar',
                data:this.data1
            }]
        });
    }
  }

        }

</script>
