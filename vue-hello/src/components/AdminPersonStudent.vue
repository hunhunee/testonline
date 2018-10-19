<style scoped>
  .add{
    margin-top: 20px;
    margin-bottom: 10px;
  }
</style>
<template>
  <div class="layout">
    <Input  @on-change="search" v-model="num" search enter-button placeholder="请输入学号查找学生" style="width:300px" />
    <div class="add">
      <Button type="primary" @click="add">添加学生信息</Button>
    </div>
    <Table height="480" border :columns="columns7" :data="data6"></Table>
    <Modal
        v-model="modal"
        title="message"

        @on-ok="ok"
        @on-cancel="cancel">
        <p>
          该学生有档案，是否删除其全部数据，请慎重选择！！！
        </p>
    </Modal>
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
            key: 'className'
          },
          {
            title: '信息管理',
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
                }, '修改'),
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
                }, '删除')
              ]);
            }
          }
        ],
        data6: [],
        num: "",
        id:"",
        modal:false
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
        let student = {
          stuNum:this.data6[index].stuNum
        }
        this.$store.dispatch('findStudnetScore', {student});

        setTimeout(()=>{
          console.log("score.length");
          console.log(this.$store.state.score.score.length);
          if(this.$store.state.score.score.length>=1){
              this.modal=true
              console.log("modal:true");
          }else{
            let data = {
              "num": this.data6[index].stuNum
            }
            this.$store.dispatch('deleteStudent', {data});
          }
        },1200)

        this.id=this.data6[index].stuId;
        this.num=this.data6[index].stuNum;

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
      },

      ok:function(){
        let data1 = {
          "stuId": this.id
        }
        this.$store.dispatch('deleteStudnetScore', {data1});


        setTimeout(()=>{
          let data = {
            "num": this.num
          }
          this.$store.dispatch('deleteStudent', {data});
        },2000)


      },
      cancel:function(){

      }

    }
  }
</script>
