<style scoped>
  .layout-con {
    height: 100%;
    width: 100%;
  }

  .menu-item span {
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }

  .menu-item i {
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }

  .collapsed-menu span {
    width: 0px;
    transition: width .2s ease;
  }

  .collapsed-menu i {
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }

  .layout-ceiling-main {
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
        <Menu active-name="1-1" theme="dark" width="auto" :class="menuitemClasses" @on-select="test" accordion>
          <Submenu name="1-1">
            <template slot="title">
            <Icon type="md-person-add" />
              <span>用户管理</span>
            </template>
            <MenuItem name="1-1-1">教师管理</MenuItem>
            <MenuItem name="1-1-2">学生管理</MenuItem>
          </Submenu>

          <Submenu name="1-2">
            <template slot="title">
            <Icon type="ios-paper-outline" />
              <span>试题管理</span>
            </template>
            <MenuItem name="1-2-1">单选题</MenuItem>
            <MenuItem name="1-2-2">多选题</MenuItem>
            <MenuItem name="1-2-3">判断题</MenuItem>
            <MenuItem name="1-2-4">综合题</MenuItem>
          </Submenu>

          <MenuItem name="1-4">
          <Icon type="md-book" />
            <span>科目管理</span>
          </MenuItem>
          <MenuItem name="1-5">
          <Icon type="md-school" />
            <span>班级管理</span>
          </MenuItem>

          <MenuItem name="1-3">
          <Icon type="md-person" />
            <span>个人信息</span>
          </MenuItem>

        </Menu>
      </Sider>
      <Layout>
        <Header>

          <div class="layout-ceiling-main">
            <Menu mode="horizontal" theme="dark" @on-select="test">

              <MenuItem name="h-1-1">
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
    data() {
      return {
        isCollapsed: false,
        data: {
          testType: this.getTestType,
        },

      };
    },
    // 创建完成时
    created() {
    localStorage.setItem("load",1);
    this.$store.dispatch('findAllLesson');
    this.$store.dispatch('findAllClass');
     this.$router.push('/admin_index/main'); //跳转到指定页面



    },

    methods: {
      test(name) {
        let data = this.data;
        switch (name) {

          case "1-1-1":
            this.$store.dispatch('findAllTeacher');
            break;
          //-------学生------
          case "1-1-2":
            this.$store.dispatch('findAllStudent');
            break;
          case "1-2-1":
            this.$store.dispatch('testType', {testType: 1});
            this.data.testType = this.getTestType;
            this.$store.dispatch('findAllTest', {data});
            break;
          case "1-2-2":
            this.$store.dispatch('testType', {testType: 2});
            this.data.testType = this.getTestType;
            this.$store.dispatch('findAllTest', {data});

            break;
          case "1-2-3":
            this.$store.dispatch('testType', {testType: 3});
            this.data.testType = this.getTestType;
            this.$store.dispatch('findAllTest', {data});
            break;
          case "1-2-4":
            this.$store.dispatch('testType', {testType: 4});
            this.data.testType = this.getTestType;
            this.$store.dispatch('findAllTest', {data});
            break;
          case "1-3":
            router.push({path: '/admin_index/admin_message'});
            break;
          case "h-1-1":
            this.$store.dispatch('userLoginOut');
            break;
          case"1-4":
            localStorage.setItem("load",0);
            this.$store.dispatch('findAllLesson');
            break;
          case"1-5":
              localStorage.setItem("load",0);
              this.$store.dispatch('findAllClass');
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
      },

      getTestType: function () {
        return this.$store.getters.getTestType
      },
    }
  }
</script>
