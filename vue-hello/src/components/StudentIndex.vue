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
                      <Submenu name="1-1-1">
                          <template slot="title">必考科目</template>
                          <MenuItem name="1-1-1-1">英语</MenuItem>
                          <MenuItem name="1-1-1-2">数学</MenuItem>
                      </Submenu>
                      <Submenu name="1-1-2">
                          <template slot="title">选修科目</template>
                          <MenuItem name="1-1-2-1">体育</MenuItem>
                          <MenuItem name="1-1-2-2">音乐</MenuItem>
                      </Submenu>
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
                  <MenuItem name="h-1-2">
                    <span> <p>当前时间：{{nowTime}}</p></span>
                  </MenuItem>
                  <MenuItem name="h-1-1" >
                      <Icon type="md-person-add" />
                      <span>注销</span>
                  </MenuItem>
                 </Menu>
              </div>
            </Header>
                <Content :style="{padding: '0 16px 16px'}">
                    <Breadcrumb :style="{margin: '16px 0'}">
                        <BreadcrumbItem>Home</BreadcrumbItem>
                        <BreadcrumbItem>Components</BreadcrumbItem>
                        <BreadcrumbItem>Layout</BreadcrumbItem>
                    </Breadcrumb>
                    <Card>
                        <div style="height: 600px">
                            <router-view/>
                        </div>
                    </Card>
                </Content>
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
                  testCourse:""
                },

                modal:false,
                student:{
                  //从本地获取学生的学号
                  stuNum:localStorage.getItem("usernum")
                },
                nowTime:""
            };
        },
        // 创建完成时
        created() {
          this.nowTimes();
        },
        methods:{
          test(name){
            let data =this.data;
            let student =this.student;
            switch (name) {
              case "1-1":
              router.push({ path: '/student_index/student_test' });
                break;
              case "1-1-1-1":
                 this.data.testCourse="1";
                 this.modal=true
                break;
              case "1-1-1-2":
                 this.data.testCourse="2";
                 this.modal=true
                break;
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
            }
          },
          // 获取当前时间函数
          timeFormate(timeStamp) {
            let year = new Date(timeStamp).getFullYear();
            let month = new Date(timeStamp).getMonth() + 1 < 10 ? "0" + (new Date(timeStamp).getMonth() + 1) : new Date(timeStamp).getMonth() + 1;
            let date = new Date(timeStamp).getDate() < 10 ? "0" + new Date(timeStamp).getDate() : new Date(timeStamp).getDate();
            let hh = new Date(timeStamp).getHours() < 10 ? "0" + new Date(timeStamp).getHours() : new Date(timeStamp).getHours();
            let mm = new Date(timeStamp).getMinutes() < 10 ? "0" + new Date(timeStamp).getMinutes() : new Date(timeStamp).getMinutes();
            let ss =new Date(timeStamp).getSeconds() < 10? "0" + new Date(timeStamp).getSeconds(): new Date(timeStamp).getSeconds();
            //return year + "年" + month + "月" + date +"日"+" "+hh+":"+mm+":"+ss ;
            this.nowTime = year + "年" + month + "月" + date +"日"+" "+hh+":"+mm +":"+ss;

          },
          // 定时器函数
          nowTimes(){
            this.timeFormate(new Date());
            setInterval(this.nowTimes,3*1000);
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
