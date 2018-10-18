<style scoped>
.add{
  margin-top: 20px;
  margin-bottom: 10px;
}
</style>
<template>
    <div class="layout">

        <Input @on-change="search" v-model="lesName" search enter-button placeholder="科目名称查询" style="width:300px" />

      <div class="add">
        <Button type="primary" @click="add">添加科目</Button>
      </div>

    <Table height="480" border :columns="columns7" :data="data6"></Table>
      <Modal
        v-model="modal"
        title="message"

        @on-ok="ok"
        @on-cancel="cancel">
        <p>
          该科目有教师所教，不能删除数据，请慎重选择！！！
        </p>
      </Modal>
    </div>
</template>
<script>
import router from '@/router/index'
export default {

   data () {
       return {
           columns7: [
               {
                   title: '科目Id',
                   key: 'lesId',

               },
               {
                   title: '科目名称',
                   key: 'lesName'
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
          lesName:"",
          modal:false
       }
   },

   created: function () {
    console.log("created");
    // this.data6=this.$store.state.lesson.lesson
    // console.log(this.data6);

         setInterval(()=>{

         this.data6.length=this.$store.state.lesson.lesson.length
         for (var i = 0; i < this.$store.state.lesson.lesson.length; i++) {
         this.$set(this.data6,i,this.$store.state.lesson.lesson[i])
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
            "lesId":this.data6[index].lesId,
              "lesName":this.data6[index].lesName
         }
         this.$store.dispatch('changeLesson',{data});
         router.push({ path: '/admin_index/admin_Lesson_aou' });
       },
       remove (index) {
         let teacher = {
           value:this.data6[index].lesId
         }
         this.$store.dispatch('findTeacherByLesson', {teacher});
         setTimeout(()=>{
           console.log("score.length");
           console.log(this.$store.state.person.teacher.length);
           if(this.$store.state.person.teacher.length>=1){
             this.modal=true
             console.log("modal:true");
           }else{
             let data = {
               "lesName": this.data6[index].lesName
             }
             this.$store.dispatch('deleteLesson',{data});

           }
         },1200)
        //  let data = {
        //      "lesName": this.data6[index].lesName
        //  }
        // this.$store.dispatch('deleteLesson',{data});
      },


      search () {
        let data = {
            "lesName": this.lesName
        }
        this.$store.dispatch('findLesson',{data});


      },

      add() {
        this.$store.dispatch('addBeforeLesson');
        router.push({ path: '/admin_index/admin_Lesson_aou' });
      },
     ok:function(){
       this.modal = false


     },
     cancel:function(){

     }

   }
}
</script>
