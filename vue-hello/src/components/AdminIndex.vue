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
</style>
<template>
  <div class="layout">
    <Layout :style="{minHeight: '100vh'}">
      <Sider collapsible :collapsed-width="78" v-model="isCollapsed">
        <Menu active-name="1-1" theme="dark" width="auto" :class="menuitemClasses" @on-select="test">
          <Submenu name="1-1">
            <template slot="title">
              <Icon type="ios-body"/>
              用户管理
            </template>
            <MenuItem name="1-1-1">教师管理</MenuItem>
            <MenuItem name="1-1-2">学生管理</MenuItem>
          </Submenu>

          <Submenu name="1-2">
            <template slot="title">
              <Icon type="ios-search"/>
              试题管理
            </template>
            <MenuItem name="1-2-1">单选题</MenuItem>
            <MenuItem name="1-2-2">多选题</MenuItem>
            <MenuItem name="1-2-3">判断题</MenuItem>
            <MenuItem name="1-2-4">计算题</MenuItem>
          </Submenu>


          <MenuItem name="1-3">
            <Icon type="md-person-add"/>
            <span>个人信息</span>
          </MenuItem>

          <MenuItem name="1-4">
            <Icon type="md-person-add"/>
            <span>科目管理</span>
          </MenuItem>
        </Menu>
      </Sider>
      <Layout>
        <Header>

          <div class="layout-ceiling-main">
            <Menu mode="horizontal" theme="dark" @on-select="test">
              <MenuItem name="h-1-2">
                <span> <p>当前时间：{{nowTime}}</p></span>
              </MenuItem>
              <MenuItem name="h-1-1">
                <Icon type="md-person-add"/>
                <span>注销</span>
              </MenuItem>

            </Menu>
          </div>

        </Header>
        <Content :style="{padding: '5px 5px 5px'}">
          <Card>

            <div style="height: 700px">

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
    data() {
      return {
        isCollapsed: false,
        data: {
          testType: this.getTestType,
        },
        nowTime:""
      };
    },
    // 创建完成时
    created() {
      this.nowTimes();
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
          default:

          case"1-4":
            this.$store.dispatch('findAllLesson');

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
