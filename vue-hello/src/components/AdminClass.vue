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
          className:""
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
         let data = {
             "className": this.data6[index].className
         }
        this.$store.dispatch('deleteClass',{data});
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
      }

   }
}
</script>
