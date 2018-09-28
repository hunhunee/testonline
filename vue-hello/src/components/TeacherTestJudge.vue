<style scoped>

</style>
<template>

    <div class="layout">
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
                      key: 'lesName'
                  },
                  {
                      title: '试题类型',
                      key: 'testType'
                  },

                  {
                      title: '状态',
                      key: 'testStatus'
                  },
                  {
                      title: '试题详情',
                      key: 'detail',
                      width: 100,
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
                                          this.detail(params.index)
                                      }
                                  }
                              }, 'detail'),

                          ]);
                      }
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
            router.push({ path: '/teacher_index/teacher_test_judge_aou' });
          },
          remove (index) {
            let data = {
                "testId": this.data[index].testId,
                "testType":this.data[index].testType,
                "testCourse":this.data[index].testCourse
            }
           this.$store.dispatch('deleteTest',{data});
           this.data=this.$store.state.test.test
         },
         add() {
           this.$store.dispatch('addBeforeTest');
           router.push({ path: '/teacher_index/teacher_test_judge_aou' });
         },
         detail (index) {
                         this.$Modal.info({
                             title: 'Test Details',
                             content: `试题内容：${this.data[index].testContent}<br>
                                       试题答案1: ${this.data[index].testAns1}<br>
                                       试题答案2: ${this.data[index].testAns2}<br>
                                       正确答案: ${this.data[index].rightans1}<br>
                                       科目: ${this.data[index].lesName}<br>
                                       试题类型: ${this.data[index].testType}<br>
                                       状态: ${this.data[index].testStatus}<br>`
                         })
                     }

        },
        computed: {
            getLesson:function(){
              return this.$store.getters.getLesson
            }
        }
    }
</script>
