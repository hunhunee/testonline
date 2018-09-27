<style scoped>

</style>
<template>

    <div class="layout">
      <Select v-model="lesson" style="width:200px">
        <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
      </Select>
      <Button type="primary" @click="find">查询科目计算题</Button>
      <div class="add">
        <Button type="primary" @click="add">添加计算题</Button>
      </div>
    <Table height="480" border :columns="columns" :data="data"></Table>
    </div>
</template>
<script>
import router from '@/router/index'
    export default {
      data () {
          return {
              columns: [
                  {
                      title: '试题ID',
                      key: 'testId',
                  },
                  {
                      title: '试题内容',
                      key: 'testContent'
                  },
                  {
                      title: '试题科目',
                      key: 'testCourse'
                  },
                  {
                      title: '试题类型',
                      key: 'testType'
                  },
                  {
                      title: '正确答案',
                      key: 'rightans1'
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
                              }, 'edit'),
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
              data:[],
              lessonList: [],
              l:{value:"",
                  label:""
              },
              lessonIdString:"",
              lessonNameString:"",
              lessonIdList:[],
              lessonNameList:[],
                lesson: ''

          }
      },
       mounted: function () {
          this.data=this.$store.state.test.test
          console.log("admin_test_multiple  test");
          console.log(this.data);
       },

       created:function(){
           console.log("lessonlist");

           this.lessonIdString=localStorage.getItem("lessonIdList");
           this.lessonNameString=localStorage.getItem("lessonNameList");


           for (var i = 0; i < this.lessonNameString.split(',').length; i++) {
              console.log(this.lessonIdString.split(',')[i]);
              this.lessonList.push({
                value:this.lessonIdString.split(',')[i],
                label:this.lessonNameString.split(',')[i]
              })
           }

       },

        methods:{
          change (index) {
            let data = {
              testId:this.data[index].testId,
              testContent:this.data[index].testContent,
              rightans1:this.data[index].rightans1,
              testCourse:this.data[index].testCourse,
              testType:this.data[index].testType
            }
            this.$store.dispatch('updateBeforeTest',{data});
            router.push({ path: '/admin_index/admin_test_compute_aou' });
          },
          remove (index) {
            let data = {
                "id": this.data[index].testId
            }
           this.$store.dispatch('deleteTest',{data});
           this.data=this.$store.state.test.test
         },
         add() {
           this.$store.dispatch('addBeforeTest');
           router.push({ path: '/admin_index/admin_test_compute_aou' });
         },

         find() {

           let data={
             testCourse:this.lesson,
             testType:this.getTestType
           }

          this.$store.dispatch('findTest',{data});
          this.data=this.$store.state.test.test
         },


        },
        computed: {
            getLesson:function(){
              return this.$store.getters.getLesson
            },

            getTestType:function(){
              return this.$store.getters.getTestType
            },
        }
    }
</script>
