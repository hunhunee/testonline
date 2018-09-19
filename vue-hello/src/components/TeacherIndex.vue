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
                <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">
                 <div>在线考试系统---教师</div>
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
