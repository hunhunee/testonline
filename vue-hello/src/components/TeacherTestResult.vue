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
    data() {
      return {
        data: [],
        data1: []
      };
    },

    created: function () {
      console.log("created");
      setInterval(() => {
        this.data1.length = this.$store.state.score.scoretatil.length
        this.data.length = this.$store.state.score.scoretatil2.length

        for (var i = 0; i < this.$store.state.score.scoretatil.length; i++) {
          this.$set(this.data1, i, this.$store.state.score.scoretatil[i])
        }

        for (var i = 0; i < this.$store.state.score.scoretatil2.length; i++) {
          this.$set(this.data, i, this.$store.state.score.scoretatil2[i])
        }
        this.drawLine();
      }, 1000);
    },

    destroyed: function () {
      console.log("destroyed");
      clearInterval();
    },

    methods: {
      drawLine() {
        // 基于准备好的dom，初始化echarts实例
        let myChart = this.$echarts.init(document.getElementById('layout'))
        let myChart1 = this.$echarts.init(document.getElementById('layout1'))
        // 绘制图表
        myChart.setOption({
          title: {text: '成绩分布'},
          tooltip: {},
          xAxis: {
            data: ["0-59", "60-79", "80-89", "90-100"]
          },
          yAxis: {},
          series: [{
            name: '成绩',
            type: 'bar',
            data: this.data
          }]
        });

        myChart1.setOption({
          title: {text: '分差'},
          tooltip: {},
          xAxis: {
            data: ["最高分", "最低分", "平均分"]
          },
          yAxis: {},
          series: [{
            name: '分差',
            type: 'bar',
            data: this.data1
          }]
        });
      }
    }

  }

</script>
