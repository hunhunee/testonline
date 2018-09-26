<style scoped>
    .layout-con{
        height: 100%;
        width: 100%;
        margin:0 auto;
        margin-right:20px;
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
    .layout-nav{

           width: 420px;
           margin: 0 auto;
           margin-right: 20px;
       }
   .layout-footer-center{
         text-align: center;
   }
   .layout-logo{
         width: 145px;
         height: 50px;
         color:#fff;
         float: left;
         position: relative;
         top: 7px;
         }
</style>
<template>

    <div class="layout">
        <Layout :style="{minHeight: '100vh'}">
            <Sider collapsible :collapsed-width="78" v-model="isCollapsed">
                <Menu active-name="1-2" theme="dark" width="auto" :class="menuitemClasses" @on-select="test">
                    <MenuItem name="1-1">
                      <Icon type="ios-paper-outline" />
                        <span>考试结果</span>
                    </MenuItem>
                    <Submenu name="1-2">
                    <template slot="title">
                        <Icon type="ios-search" />
                        试题管理
                    </template>
                    <MenuItem name="1-2-1">单选题</MenuItem>
                    <MenuItem name="1-2-2">多选题</MenuItem>
                    <MenuItem name="1-2-3">判断题</MenuItem>
                    <MenuItem name="1-2-4">计算题</MenuItem>
                   </Submenu>
                    <MenuItem name="1-3">
                        <Icon type="md-person-add" />
                        <span>个人信息</span>
                    </MenuItem>
                </Menu>
            </Sider>
            <Layout>
            <Header >
              <Menu mode="horizontal" theme="dark" active-name="1">
               <div class="layout-logo">在线考试系统---管理员</div>
                   <div class="layout-nav">

                      <MenuItem name="1">
                       <Icon type="ios-navigate"></Icon>
                         菜单
                      </MenuItem>

                     <MenuItem name="2">
                        <Icon type="ios-keypad"></Icon>
                         设置
                     </MenuItem>

                     <MenuItem name="3">
                       <Icon type="ios-analytics"></Icon>
                          通知
                    </MenuItem>

                    <MenuItem name="4">
                      <Icon type="ios-paper"></Icon>
                           退出
                    </MenuItem>
                   </div>
               </Menu>
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
                <Footer class="layout-footer-center">
                        2018-9-21 &copy; TalkingData
                 </Footer>
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
                  testCourse:localStorage.getItem("lesson"),
                  testType:this.$store.state.test.testType
                }
            };
        },
        methods:{

          test(name){
            let data=this.data;
            switch (name) {
              case "1-1":
              router.push({ path: '/teacher_index/teacher_test_result' });
                break;
              case "1-2-1":

                this.$store.dispatch('testType',{testType:1});
                this.data.testType=this.$store.state.test.testType
                this.$store.dispatch('findTest',{data});
                break;
              case "1-2-2":

                this.$store.dispatch('testType',{testType:2});
                this.data.testType=this.$store.state.test.testType
                this.$store.dispatch('findTest',{data});
                break;
              case "1-2-3":
                this.$store.dispatch('testType',{testType:3});
                this.data.testType=this.$store.state.test.testType
                this.$store.dispatch('findTest',{data});
                break;
              case "1-2-4":
                this.$store.dispatch('testType',{testType:4});
                this.data.testType=this.$store.state.test.testType
                this.$store.dispatch('findTest',{data});
                break;
              case "1-3":
             router.push({ path: '/teacher_index/teacher_message' });
                break;
              default:

            }
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
