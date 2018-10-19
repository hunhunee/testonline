<style scoped>
.add{
  margin-top: 20px;
  margin-bottom: 10px;
}
</style>
<template>
    <div class="layout">

        <Input @on-change="search" v-model="className" search enter-button placeholder="班级名称查询" style="width:300px" />

      <div class="add">
        <Button type="primary" @click="add">添加班级</Button>
      </div>

    <Table height="480" border :columns="columns7" :data="data6"></Table>
    <Modal
        v-model="modal"
        title="message"

        @on-ok="ok"
        @on-cancel="cancel">
        <p>
           该班级还有同学在学习，不能够删除！！！
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
                   title: '班级Id',
                   key: 'classId',

               },
               {
                   title: '班级名称',
                   key: 'className'
               },

               {
                   title: '信息管理',
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
                           }, "修改"),
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
                           }, '删除')
                       ]);
                   }
               }
           ],
           data6:[],
          className:"",
          modal:false
       }
   },

   created: function () {
    console.log("created");
    // this.data6=this.$store.state.lesson.lesson
    // console.log(this.data6);

         setInterval(()=>{

         this.data6.length=this.$store.state.Class.class.length
         for (var i = 0; i < this.$store.state.Class.class.length; i++) {
         this.$set(this.data6,i,this.$store.state.Class.class[i])
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
            "classId":this.data6[index].classId,
              "className":this.data6[index].className
         }
         this.$store.dispatch('changeClass',{data});
         router.push({ path: '/admin_index/admin_Class_aou' });
       },
       remove (index) {
          let student={
           "stuClass":this.data6[index].classId
          }
         this.$store.dispatch('findStudentByClass',{student});

         setTimeout(()=>{

           if (this.$store.state.person.student.length>=1) {
                  this.modal=true
           }else{

             let data = {
                 "className": this.data6[index].className
             }
            this.$store.dispatch('deleteClass',{data});
           }

         },2000)


      },
      search () {
        let data = {
            "className": this.className
        }
        this.$store.dispatch('findClass',{data});


      },

      add() {
        this.$store.dispatch('addBeforeClass');
        router.push({ path: '/admin_index/admin_Class_aou' });
      },
      ok:function(){
       this.modal=false
      },
      cancel:function(){

      },

   }
}
</script>
