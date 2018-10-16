<style scoped>

</style>
<template>

    <div class="layout">
      <div class="add">
        <Button type="primary" @click="add">添加计算题</Button>
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
              data1:[],
              data2:[],
              currentPage:"1",

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

       },
        methods:{


          page (page){
              this.currentPage=page;

              if(this.data.length%10==0){
                for (var i = (page-1)*10; i <(page*10); i++) {
                   this.data1[i-((page-1)*10)]=this.data[i];
                }
              }else{

                if(page==Math.floor(this.data.length/10)+1){
                  for (var i = (page-1)*10; i <(page-1)*10+this.data.length%10; i++) {
                     this.data1[i-((page-1)*10)]=this.data[i];
                     console.log(this.data1[i-((page-1)*10)]);
                  }
                  this.data1.length=this.data.length%10;
                  console.log(this.data1.length);
                }else {
                  for (var i = (page-1)*10; i <(page*10); i++) {
                     this.data1[i-((page-1)*10)]=this.data[i];
                  }

                }

              }


          },

          change (index) {
            let data = {
              testId:this.data2[index].testId,
              testContent:this.data2[index].testContent,
              rightans1:this.data2[index].rightans1,
              testCourse:this.data2[index].lesName,
              testType:this.data2[index].testType,
              testStatus:this.data2[index].testStatus
            }
            this.$store.dispatch('updateBeforeTest',{data});
            router.push({ path: '/teacher_index/teacher_test_compute_aou' });

            setTimeout(()=>{
               this.page(this.currentPage)
            },1200)
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
              this.page(this.currentPage)
           },1200)
         },
         add() {
           this.$store.dispatch('addBeforeTest');
           router.push({ path: '/teacher_index/teacher_test_compute_aou' });

           setTimeout(()=>{
              this.page(this.currentPage)
           },1200)
         },
         detail (index) {
                         this.$Modal.info({
                             title: 'Test Details',
                             content: `试题内容：${this.data2[index].testContent}<br>
                                       正确答案: ${this.data2[index].rightans1}<br>
                                       科目: ${this.data2[index].lesName}<br>
                                       试题类型: ${this.data2[index].testTypeName}<br>
                                       状态: ${this.data2[index].testStatusName}<br>`
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
