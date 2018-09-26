<style scoped>
  .add{
    margin-top: 20px;
    margin-bottom: 10px;
  }
</style>
<template>
  <div class="layout">
    <Input  @on-change="search" v-model="num" search enter-button placeholder="Enter something..." style="width:300px" />
    <div class="add">
      <Button type="primary" @click="add">添加学生信息</Button>
    </div>
    <Table height="480" border :columns="columns7" :data="data6"></Table>
  </div>
</template>

<script>
  import router from '@/router/index'
  export default {
    data() {
      return {
        columns7: [
          {
            title: '学生姓名',
            key: 'stuName',
          },
          {
            title: '性别',
            key: 'stuSex'
          },
          {
            title: '学号',
            key: 'stuNum'
          },
          {
            title: '班级',
            key: 'stuClass'
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
                    marginRight: '3px'
                  },
                  on: {
                    click: () => {
                      this.change(params.index)
                    }
                  }
                }, 'change'),
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
        data6: [],
        num: ""
      }
    },
    created: function () {
      console.log("created");
      setInterval(() => {
        this.data6.length = this.$store.state.person.student.length
        for (var i = 0; i < this.$store.state.person.student.length; i++) {
          this.$set(this.data6, i, this.$store.state.person.student[i])
        }
      }, 1000);
    },
    mounted: function () {
      console.log("mounted");
    },
    destroyed: function () {
      console.log("destroyed");
    },
    methods: {
      change(index) {
        let data = {
          "stuName": this.data6[index].stuName,
          "stuSex": this.data6[index].stuSex,
          "stuNum": this.data6[index].stuNum,
          "stuClass": this.data6[index].stuClass+"",
          "stuPassword": this.data6[index].stuPassword
        }
        this.$store.dispatch('changeStudent', {data});
        router.push({path: '/admin_index/admin_person_student_aou'});
      },
      remove(index) {
        let data = {
          "num": this.data6[index].stuNum
        }
        this.$store.dispatch('deleteStudent', {data});
      },
      search () {
        let data = {
          "num": this.num
        }
        this.$store.dispatch('findStudent',{data});
      },
      add() {
        this.$store.dispatch('addBeforeStudent');
        router.push({ path: '/admin_index/admin_person_student_aou' });
      }
    }
  }
</script>
