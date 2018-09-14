<style scoped>
.add{
  margin-top: 20px;
  margin-bottom: 10px;
}
</style>
<template>
    <div class="layout">
        <Input search @on-search="search" v-model="num" enter-button placeholder="Enter something..." style="width:300px" />

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
                   // render: (h, params) => {
                   //     return h('div', [
                   //         h('Icon', {
                   //             props: {
                   //                 type: 'person'
                   //             }
                   //         }),
                   //         h('strong', params.row.name)
                   //     ]);
                   // }
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
                           }, 'View'),
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
    this.$store.dispatch('findAllTeacher');
    this.data6=this.$store.state.person.teacher
    console.log(this.$store.state.person.teacher);
      },
   methods: {
       change (index) {
         let data = {
             "teaNum": this.data6[index].teaNum,
             "teaName":this.data6[index].teaNum,
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
        this.data6=this.$store.state.person.teacher
      },
      search () {
        let data = {
            "num": this.num
        }
         this.$store.dispatch('findTeacher',{data});
         this.data6=this.$store.state.person.teacher
         console.log(this.data6);
      },
      add() {
        this.$store.dispatch('addBeforeTeacher',{data});
        router.push({ path: '/admin_index/admin_person_teacher_aou' });
      }
   }
}
</script>
