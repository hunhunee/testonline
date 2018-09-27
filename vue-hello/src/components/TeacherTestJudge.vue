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
         }

        },
        computed: {
            getLesson:function(){
              return this.$store.getters.getLesson
            }
        }
    }
</script>
