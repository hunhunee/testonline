<style scoped>

</style>
<template>

    <div class="layout">
      <Select v-model="lesson" style="width:200px">
        <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
      </Select>
      <Button type="primary" @click="find">查询科目判断题</Button>
      <div class="add">
        <Button type="primary" @click="add">添加判断题</Button>
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
                      title: '答案1',
                      key: 'testAns1'
                  },
                  {
                      title: '答案2',
                      key: 'testAns2'
                  },
                  {
                      title: '正确答案',
                      key: 'rightans1'
                  },
                  {
                      title: '状态',
                      key: 'testStatus'
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
              lessonList: [
                    {
                        value: '1',
                        label: '英语'
                    },
                    {
                        value: '2',
                        label: '数学'
                    },
                    {
                        value: '3',
                        label: '物理'
                    },
                    {
                        value: '4',
                        label: '语文'
                    },


                ],
                lesson: ''

          }
      },
      created: function () {
       console.log("created");

            setInterval(()=>{
               this.data.length=this.$store.state.test.test.length
               for (var i = 0; i < this.$store.state.test.test.length; i++) {
                 this.$set(this.data,i,this.$store.state.test.test[i])
               }
            }, 1000);
     },

     destroyed: function(){
       clearInterval();
     },

        methods:{
          change (index) {
            let data = {
              testId:this.data[index].testId,
              testContent:this.data[index].testContent,
              testAns1:this.data[index].testAns1,
              testAns2:this.data[index].testAns2,
              rightans1:this.data[index].rightans1,
              testCourse:this.data[index].testCourse,
              testType:this.data[index].testType,
              testStatus:this.data[index].testStatus
            }
            this.$store.dispatch('updateBeforeTest',{data});
            router.push({ path: '/admin_index/admin_test_judge_aou' });
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
           router.push({ path: '/admin_index/admin_test_judge_aou' });
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
