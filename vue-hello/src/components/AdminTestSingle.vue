<style scoped>

</style>
<template>

    <div class="layout">
      <Select @on-change="find" v-model="lesson" style="width:200px" placeholder="LessonName">
        <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
      </Select>
    <Button type="primary" @click="search">查询</Button>
      <div class="add">
        <Button type="primary" @click="add">添加单选题</Button>
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
                      key: 'testTypeName'
                  },

                  {
                      title: '状态',
                      key: 'testStatusName'
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
      created: function () {
       console.log("created");
       console.log(this.$store.state.test.test[0])
       setInterval(()=>{
          this.data.length=this.$store.state.test.test.length
          for (var i = 0; i < this.$store.state.test.test.length; i++) {
            this.$set(this.data,i,this.$store.state.test.test[i])

          }
       }, 1000);
                      console.log("lessonlist");
                      this.lessonIdString=localStorage.getItem("lessonIdList");
                      this.lessonNameString=localStorage.getItem("lessonNameList");

                      for (var i = 0; i < this.lessonNameString.split(',').length; i++) {
                        this.lessonList.push({
                          value:this.lessonIdString.split(',')[i],
                          label:this.lessonNameString.split(',')[i]
                        })
                     }

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
              testAns3:this.data[index].testAns3,
              testAns4:this.data[index].testAns4,
              rightans1:this.data[index].rightans1,
              testCourse:this.data[index].testCourse,
              testType:this.data[index].testType,
              testStatus:this.data[index].testStatus
            }
            this.$store.dispatch('updateBeforeTest',{data});
            router.push({ path: '/admin_index/admin_test_single_aou' });
          },
          remove (index) {
            let data = {
                "testId": this.data[index].testId,
                "testType":this.data[index].testType,
                "testCourse":this.data[index].testCourse
            }
           this.$store.dispatch('deleteTest',{data});
           this.data.length=this.$store.state.test.test.length
            for (var i = 0; i < this.$store.state.test.test.length; i++) {
              console.log(this.$store.state.test.test[i]);
             this.$set(this.data,i,this.$store.state.test.test[i])
            }
         },
         add() {
           this.$store.dispatch('addBeforeTest');
           router.push({ path: '/admin_index/admin_test_single_aou' });
         },

         find(value) {
           let data={
             testCourse:value,
             testType:this.getTestType
           }
          this.$store.dispatch('findTest',{data});
         },

         search() {
          this.data.length=this.$store.state.test.test.length
           for (var i = 0; i < this.$store.state.test.test.length; i++) {
             console.log(this.$store.state.test.test[i]);
            this.$set(this.data,i,this.$store.state.test.test[i])
           }
         },

         detail (index) {
                         this.$Modal.info({
                             title: 'Test Details',
                             content: `试题内容：${this.data[index].testContent}<br>
                                       试题答案1: ${this.data[index].testAns1}<br>
                                       试题答案2: ${this.data[index].testAns2}<br>
                                       试题答案3: ${this.data[index].testAns3}<br>
                                       试题答案4: ${this.data[index].testAns4}<br>
                                       正确答案: ${this.data[index].rightans1}<br>
                                       科目: ${this.data[index].lesName}<br>
                                       试题类型: ${this.data[index].testTypeName}<br>
                                       状态: ${this.data[index].testStatusName}<br>`
                         })
                     }

        },
        computed: {

            getTestType:function(){
              return this.$store.getters.getTestType
            },
        }
    }
</script>
