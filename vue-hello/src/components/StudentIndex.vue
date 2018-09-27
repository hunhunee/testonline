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
        white-space: nowrap;s
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
</style>
<template>
    <div class="layout">
        <Layout :style="{minHeight: '100vh'}">
            <Sider collapsible :collapsed-width="78" v-model="isCollapsed">
                <Menu  active-name="1-2" theme="dark" width="auto" :class="menuitemClasses" @on-select="test">
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
            </Sider>
            <Layout>
                <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">
                 <div>在线考试系统---学生</div>
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
                }
            };
        },
        methods:{
          test(name){
            let data =this.data;
            switch (name) {
              case "1-1":
              router.push({ path: '/student_index/student_test' });
                break;
              case "1-1-1-1":
                this.data.testCourse="1";
                this.$store.dispatch('findExamPaper',{data});
                break;
              case "1-1-1-2":
                this.data.testCourse="2";
                this.$store.dispatch('findExamPaper',{data});
                break;
              case "1-2":
              router.push({ path: '/student_index/student_test_result' });
                break;
              case "1-3":
             router.push({ path: '/student_index/student_message' });
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
