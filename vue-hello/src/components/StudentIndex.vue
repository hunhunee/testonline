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
                <Menu  active-name="1-3" theme="dark" width="auto" :class="menuitemClasses" @on-select="test">
                  <Submenu name="1-1">
                      <template slot="title">
                          <Icon type="ios-filing" />
                          参加考试
                      </template>

                          <MenuItem v-for="item in lessonList" :name="item.value" :value="item.value" :key="item.value">{{ item.label }}</MenuItem>

                  </Submenu>

                    <MenuItem name="1-2">
                        <Icon type="ios-search" />
                        <span>查看成绩</span>
                    </MenuItem>
                    <MenuItem name="1-3">
                        <Icon type="md-person-add" />
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
                      <Icon type="md-person-add" />
                      <span>注销</span>
                  </MenuItem>
                 </Menu>
              </div>
            </Header>
                <Content :style="{padding: '0 16px 16px'}">
                    <Breadcrumb :style="{margin: '16px 0'}">
                        <BreadcrumbItem>Home 主页</BreadcrumbItem>
                        <BreadcrumbItem>Components 上一页</BreadcrumbItem>
                        <BreadcrumbItem>Layout 当前页面</BreadcrumbItem>
                    </Breadcrumb>
                    <Card>
                        <div style="height: 600px">
                            <router-view/>
                        </div>
                    </Card>
                </Content>
                  <Footer class="layout-footer-center">2018 &copy; TalkingData</Footer>
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
                length:[]

            };
        },
        // 创建完成时
        created: function () {
          this.$store.dispatch('findAllLesson');
         console.log("created");

                        console.log("lessonlist");
                        this.lessonIdString=localStorage.getItem("lessonIdList");
                        this.lessonNameString=localStorage.getItem("lessonNameList");

                        for (var i = 0; i < this.lessonNameString.split(',').length; i++) {
                          this.lessonList.push({
                            value:this.lessonIdString.split(',')[i],
                            label:this.lessonNameString.split(',')[i]
                          })
                       }

                       console.log("teacher lesson length");

                       setInterval(()=>{
                          this.length.length=this.$store.state.score.score1.length
                       }, 1000);

       },
        methods:{

          test(name){
            let data =this.data;
            let student =this.student;
            switch (name) {
              // case "1-1":
              // router.push({ path: '/student_index/student_test' });
              //   break;
              // case "1-1-1-1":
              //    this.data.testCourse="1";
              //    this.modal=true
              //   break;
              // case "1-1-1-2":
              //    this.data.testCourse="2";
              //    this.modal=true
              //   break;
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
                      alert("您已经进行过一次考试了，请不要重复考试！")
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
          },

          ok:function(){
                 let data =this.data;
                //alert(this.data.testCourse)
                this.$store.dispatch('findExamPaper',{data});
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
