<style scoped>

</style>
<template>

    <div class="layout">
      <Select @on-change="find" v-model="lesson" style="width:200px" placeholder="LessonName">
        <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
      </Select>
      <Button type="primary" @click="find">查询科目多选题</Button>
      <div class="add">
        <Button type="primary" @click="add">添加多选题</Button>
      </div>
    <Table height="480" border :columns="columns" :data="data2"></Table>
    <Page :total="this.data.length" show-elevator   show-total @on-change="page"/>
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
                              }, '详情'),

                          ]);
                      }
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
                              }, '编辑'),
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
              data:[],
              data1:[],
              data2:[],
              currentPage:"1",


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

            setInterval(()=>{
               this.data.length=this.$store.state.test.test.length
               for (var i = 0; i < this.$store.state.test.test.length; i++) {
                 this.$set(this.data,i,this.$store.state.test.test[i])
               }
            }, 1000);


            if (this.$store.state.test.test.length<10) {
              this.data1.length=this.$store.state.test.test.length;
              for (var i = 0; i < this.$store.state.test.test.length; i++) {
                this.$set(this.data1,i,this.$store.state.test.test[i])
              }
            }else{
              this.data1.length=10;
              for (var i = 0; i < 10; i++) {

                this.$set(this.data1,i,this.$store.state.test.test[i])
              }
            }

            setInterval(()=>{
               this.data2.length= this.data1.length;
               for (var i = 0; i < this.data1.length; i++) {
                 this.$set(this.data2,i,this.data1[i])
               }

            }, 1000);

            console.log("lessonlist");

            this.lessonIdString=localStorage.getItem("lessonIdList");
            this.lessonNameString=localStorage.getItem("lessonNameList");

            this.lessonList.push({value:"0",label:"all"});
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
              testId:this.data2[index].testId,
              testContent:this.data2[index].testContent,
              testAns1:this.data2[index].testAns1,
              testAns2:this.data2[index].testAns2,
              testAns3:this.data2[index].testAns3,
              testAns4:this.data2[index].testAns4,
              rightans1:this.data2[index].rightans1,
              rightans2:this.data2[index].rightans2,
              testCourse:this.data2[index].testCourse,
              testType:this.data2[index].testType,
              testStatus:this.data2[index].testStatus
            }
            this.$store.dispatch('updateBeforeTest',{data});
            router.push({ path: '/admin_index/admin_test_multiple_aou' });
          },

          page (page){
            console.log(page);
              this.currentPage=page;
              console.log(this.data.length%10);
              if(this.data.length%10==0){
                for (var i = (page-1)*10; i <(page*10); i++) {
                   this.data1[i-((page-1)*10)]=this.data[i];
                   console.log(this.data1[i-((page-1)*10)]);
                }
              }else{

                if(page==Math.floor(this.data.length/10)+1){
                  for (var i = (page-1)*10; i <(page-1)*10+this.data.length%10; i++) {
                     this.data1[i-((page-1)*10)]=this.data[i];
                     console.log(this.data1[i-((page-1)*10)]);
                  }
                  this.data1.length=this.data.length%10;
                }else {
                  for (var i = (page-1)*10; i <(page*10); i++) {
                     this.data1[i-((page-1)*10)]=this.data[i];
                     console.log(this.data1[i-((page-1)*10)]);
                  }

                }

              }


          },

          remove (index) {
            let data = {
                "testId": this.data2[index].testId,
                "testType":this.data2[index].testType,
                "testCourse":this.data2[index].testCourse
            }
           this.$store.dispatch('deleteTest',{data});
           this.data=this.$store.state.test.test


           setTimeout(()=>{
              this.page(Math.ceil(this.currentPage))
           },1200)
         },
         add() {
           this.$store.dispatch('addBeforeTest');
           router.push({ path: '/admin_index/admin_test_multiple_aou' });
           setTimeout(()=>{
              this.page(Math.ceil(this.currentPage))
           },1200)
         },

         find(value) {
           if(value=="0"){
             let data={
               testType:this.getTestType
             }
               this.$store.dispatch('findAllTest',{data});
           }else{
             let data={
               testCourse:value,
               testType:this.getTestType
             }
            this.$store.dispatch('findTest',{data});
           }

           setTimeout(()=>{
              this.page(Math.ceil(this.currentPage))
           },1200)

         },

         detail (index) {
                         this.$Modal.info({
                             title: '试题详情',
                             content: `试题内容：${this.data2[index].testContent}<br>
                                       试题答案1: ${this.data2[index].testAns1}<br>
                                       试题答案2: ${this.data2[index].testAns2}<br>
                                       试题答案3: ${this.data2[index].testAns3}<br>
                                       试题答案4: ${this.data2[index].testAns4}<br>
                                       正确答案1: ${this.data2[index].rightans1}<br>
                                       正确答案2: ${this.data2[index].rightans1}<br>
                                       科目: ${this.data2[index].lesName}<br>
                                       试题类型: ${this.data2[index].testTypeName}<br>
                                       状态: ${this.data2[index].testStatusName}<br>`
                         })
                     }


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
