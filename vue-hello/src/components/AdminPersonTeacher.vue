<style scoped>
.add{
  margin-top: 20px;
  margin-bottom: 10px;
}
</style>
<template>
    <div class="layout">
        <Input @on-change="search"   v-model="num" enter-button placeholder="Enter something..." style="width:300px" />

      <div class="add">
        <Button type="primary" @click="add">添加教师信息</Button>
      </div>


    <Table height="480" border :columns="columns7" :data="data6"></Table>
    </div>
</template>
<script>
import router from '@/router/index'
export default {

   data () {
       return {
           columns7: [
               {
                   title: '姓名',
                   key: 'teaName',

               },
               {
                   title: '科目',
                   key: 'teaCourse'
               },
               {
                   title: '工号',
                   key: 'teaNum'
               },
               {
                   title: '班级',
                   key: 'teaClass'
               },
               {
                   title: 'Action',
                   key: 'action',
                   width: 150,
                   align: 'center',
                   render: (h, params) => {
                       return h('div', [
                           h('Button', {
                               props: {
                                   type: 'primary',
                                   size: 'small'
                               },
                               style: {
                                   marginRight: '5px'
                               },
                               on: {
                                   click: () => {
                                       this.change(params.index)
                                   }
                               }
                           }, "change"),
                           h('Button', {
                               props: {
                                   type: 'error',
                                   size: 'small'
                               },
                               on: {
                                   click: () => {
                                       this.remove(params.index)
                                   }
                               }
                           }, 'Delete')
                       ]);
                   }
               }
           ],
           data6:[],
           num:""



       }
   },

   created: function () {
    console.log("created");

         setInterval(()=>{
            this.data6.length=this.$store.state.person.teacher.length
            for (var i = 0; i < this.$store.state.person.teacher.length; i++) {
              this.$set(this.data6,i,this.$store.state.person.teacher[i])
            }
         }, 1000);
  },

   mounted: function(){
     console.log("mounted");
   },


  destroyed: function(){
    console.log("destroyed");
  },
   methods: {
       change (index) {
         let data = {
             "teaNum": this.data6[index].teaNum,
             "teaName":this.data6[index].teaName,
             "teaClass":this.data6[index].teaClass,
             "teaCourse":this.data6[index].teaCourse,
             "teaPassword":this.data6[index].teaPassword
         }
         this.$store.dispatch('changeTeacher',{data});
         router.push({ path: '/admin_index/admin_person_teacher_aou' });
       },
       remove (index) {
         let data = {
             "num": this.data6[index].teaNum
         }
        this.$store.dispatch('deleteTeacher',{data});

      },
      search () {
        let data = {
            "num": this.num
        }
         this.$store.dispatch('findTeacher',{data});
      },

      // show(){
      //     console.log("show");
      //     console.log(this.$store.state.person.teacher[0]);
      //     if(this.$store.state.person.teacher[0]==null||this.$store.state.person.teacher[0]==""){
      //       alert("没有这个老师！")
      //     }
      //     clearInterval();
      //     this.$set(this.data6,0,this.$store.state.person.teacher[0])
      // },

      add() {
        this.$store.dispatch('addBeforeTeacher');
        router.push({ path: '/admin_index/admin_person_teacher_aou' });
      }
   }
}
</script>
