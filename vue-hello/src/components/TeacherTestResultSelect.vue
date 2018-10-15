<style scoped>

</style>
<template>
  <div class="layout">
    <Input  @on-change="search" v-model="num" search enter-button placeholder="Enter something..." style="width:300px" />
    <Table height="480" border :columns="columns" :data="data"></Table>
  </div>
</template>
<script>
  export default {
    data () {
      return {
        columns: [
          {
            title: '学生姓名',
            key:'stuName'
          },
          {
            title: '学生学号',
            key: 'stuNum'
          },
          {
            title: '班级',
            key: 'stuClass'
          },
          {
            title: '考试科目',
            key: 'lesName'
          },
          {
            title: '成绩',
            key: 'totalscore'
          },
        ],
        data:[],
        num:"",
      };

    },

    created: function () {
      console.log("created");
      setInterval(()=>{
        this.data.length=this.$store.state.score.score1.length
        for (var i = 0; i < this.$store.state.score.score1.length; i++) {
          this.$set(this.data,i,this.$store.state.score.score1[i])
        }
      }, 1000);
    },

    destroyed: function(){
      console.log("destroyed");
      clearInterval();
    },

    methods:{
      search () {
        let data = {
          "stuNum": this.num,
          "testCourse":localStorage.getItem("lesson")
        }
        this.$store.dispatch('findByStuNum',{data});
      },
    }
  }

</script>
