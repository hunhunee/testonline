<style scoped>
    .layout-con{
        height: 100%;
        width: 100%;
    }
    .menu-item span{
        display: inline-block;
        overflow: hidden;
        width: 69px;
        text-overflow: ellipsis;
        white-space: nowrap;
        vertical-align: bottom;
        transition: width .2s ease .2s;
    }
    .menu-item i{
        transform: translateX(0px);
        transition: font-size .2s ease, transform .2s ease;
        vertical-align: middle;
        font-size: 16px;
    }
    .collapsed-menu span{
        width: 0px;
        transition: width .2s ease;
    }
    .collapsed-menu i{
        transform: translateX(5px);
        transition: font-size .2s ease .2s, transform .2s ease .2s;
        vertical-align: middle;
        font-size: 22px;
    }

    .layout-ceiling-main{
        float: right;
      margin-right: 10px;
    }

    .layout-footer-center{
    text-align: center;
}

</style>
<template>
    <div class="layout">
        <Layout :style="{minHeight: '100vh'}">



            <Sider collapsible :collapsed-width="78" v-model="isCollapsed">
                <Menu  active-name="1-3" theme="dark" width="auto" :class="menuitemClasses" @on-select="test" accordion>
                  <Submenu name="1-1">
                      <template slot="title">
                        <Icon type="ios-create-outline" />
                          <span>参加考试</span>
                      </template>

                          <MenuItem v-for="item in lessonList" :name="item.value" :value="item.value" :key="item.value">{{ item.label }}</MenuItem>

                  </Submenu>

                    <MenuItem name="1-2">
                        <Icon type="ios-search" />
                        <span>查看成绩</span>
                    </MenuItem>
                    <MenuItem name="1-3">
                      <Icon type="md-person" />
                        <span>个人信息</span>
                    </MenuItem>

                </Menu>
                <Modal
                    v-model="modal"
                    title="message"

                    @on-ok="ok"
                    @on-cancel="cancel">
                    <p>
                      请确认进行考试，进入考试后无法退出！
                    </p>
                </Modal>
            </Sider>
            <Layout>
            <Header >
              <div class="layout-ceiling-main">
                <Menu mode="horizontal" theme="dark" @on-select="test">

                  <MenuItem name="h-1-1" >
                      <Icon type="ios-power" />
                      <span>注销</span>
                  </MenuItem>
                 </Menu>
              </div>
            </Header>
                <Content :style="{padding: '0 16px 16px'}">

                    <Card>
                        <div style="height: 600px">
                            <router-view/>
                        </div>
                    </Card>
                </Content>
                <Footer class="layout-footer-center">2018-9&copy;第二小组出版，版权归己所有，拒绝侵权 </Footer>
            </Layout>
        </Layout>
    </div>
</template>
<script>
import router from '@/router/index'
    export default {
        data () {
            return {
                isCollapsed: false,
                data:{
                  stuNum:localStorage.getItem("usernum"),
                  testCourse:""
                },

                modal:false,
                student:{
                  //从本地获取学生的学号
                  stuNum:localStorage.getItem("usernum"),

                },


                lessonList: [],
                lessonIdString:"",
                lessonNameString:"",
                lesson: [],
                lessonId:[],
                lessonName:[],

            };
        },

        // 创建完成时
        created: function () {
          this.$api.findAllLesson()
          .then((response) => {
            this.lesson.length=response.data.length;
            for (var i = 0; i < response.data.length; i++) {

             this.lessonList.push({
               value:response.data[i].lesId,
               label:response.data[i].lesName
             })
           }

          })
          .catch((error)=>{
             console.log(error);
            }
          );

          this.$router.push('/student_index/main'); //跳转到指定页面

       },
        methods:{

          test(name){

            if(localStorage.getItem("isExam")==1){
                  this.$Message.error('正在考试，无法进行其他操作！');
            }else{

              let data =this.data;
              let student =this.student;
              switch (name) {

                case "1-2":
                  this.$store.dispatch('findStudnetScore',{student});
                  break;
                case "1-3":
               router.push({ path: '/student_index/student_message' });
                  break;

                case "h-1-1":
                this.$store.dispatch('userLoginOut');
                  break;

                default:
                this.data.testCourse=name;
                this.$api.findByStuNum(data)
                  .then((response) => {
                     if(response.data.length>=1){
                        this.$Message.error('您已经进行过一次考试了，请不要重复考试！');
                     }else{
                       this.data.testCourse=name;
                       this.modal=true

                     }
                  })
                  .catch((error) => {
                      console.log(error);
                    }
                  );

            }





            }
          },

          ok:function(){
                 let data =this.data;
                //alert(this.data.testCourse)
                this.$store.dispatch('findExamPaper',{data});
                setTimeout(()=>{
                  if(this.$store.state.exam.exam_paper_message=="1"){
                    this.$Message.error('抱歉，该科目试题不足，无法进行考试！');
                  }
                },1200)
          },
          cancel:function(){

          }

        },
        computed: {
            menuitemClasses: function () {
                return [
                    'menu-item',
                    this.isCollapsed ? 'collapsed-menu' : ''
                ]
            }
        }
    }
</script>
