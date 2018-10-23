
<template>
  <div class="userLogin">
    <div class="text" >
        用户管理-----添加、修改学生信息
    </div>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" :label-width="400">

      <FormItem prop="stuName" >
        <Input type="text"  v-model="formInline.stuName" placeholder="UserName" style="width: 200px" clearable>

        </Input>
      </FormItem>
      <FormItem   prop="stuNum">
        <Input type="text" v-model="formInline.stuNum" placeholder="UserNum" style="width: 200px" clearable>

        </Input>
      </FormItem>

      <FormItem  prop="stuSex">
        <Select v-model="formInline.stuSex" placeholder="Select your gender" style="width: 200px">
          <Option value="male">男</Option>
          <Option value="female">女</Option>
        </Select>
      </FormItem>

      <FormItem   prop="stuClass">
        <Select v-model="formInline.stuClass" placeholder="Select your class" style="width: 200px">
          <Option v-for="item in classList" :value="item.value" :key="item.value">{{ item.label }}</Option>
        </Select>
      </FormItem>

      <FormItem>
        <Button type="primary" @click="handleSubmit('formInline')">确认</Button>
        <Button @click="clearable" style="margin-left: 8px">重置</Button>
      </FormItem>
    </Form>

    <Modal
        v-model="modal1"
        title="message"

        @on-ok="ok"
        @on-cancel="cancel">
        <p>
           该学号已经存在，请重新输入！！！
        </p>
    </Modal>

  </div>

</template>

<script>
  import router from '@/router/index'
  export default {

    data () {
      return {
        formInline: {
          stuName: this.$store.state.person.ustudent.stuName,
          stuNum: this.$store.state.person.ustudent.stuNum,
          stuClass:this.$store.state.person.ustudent.stuClass,
          stuSex:this.$store.state.person.ustudent.stuSex
        },
        ruleInline: {
          stuName: [
            { required: true, message: 'Please fill in the student name', trigger: 'blur' }
          ],
          stuNum: [
            { required: true, message: 'Please fill in the student Num.', trigger: 'blur' },
          ],
          stuSex: [
            { required: true, message: 'Please fill in the course.', trigger: 'blur' },
          ],
          stuClass: [
            { required: true, message: 'Please fill in the class.', trigger: 'blur' }
          ],
        },
        classList: [],
        classIdString:"",
        classNameString:"",
        modal1:false

      }
    },

    created: function () {
     console.log("created");

                    console.log("list");

                    this.classIdString=localStorage.getItem("classIdList");
                    this.classNameString=localStorage.getItem("classNameList");


                   for (var i = 0; i < this.classNameString.split(',').length; i++) {
                     this.classList.push({
                       value:this.classIdString.split(',')[i],
                       label:this.classNameString.split(',')[i]
                     })
                  }

    },

    methods: {

      handleSubmit(name) {

        this.$refs[name].validate((valid) => {
                          if (valid) {

                            if(this.$store.state.person.utaction=="2"){
                              let data = {
                                "stuName": this.formInline.stuName,
                                "stuNum":this.formInline.stuNum,
                                "stuSex":this.formInline.stuSex,
                                "stuClass":this.formInline.stuClass,
                                "stuPassword":this.$store.state.person.ustudent.stuPassword
                              }
                              this.$store.dispatch('updateStudent',{data});
                              router.push({ path: '/admin_index/admin_person_student' });
                            }else{
                              const axios = require('axios');

                              localStorage.setItem("check",1);
                              let data = {
                                  "num": this.formInline.stuNum
                              }
                              this.$store.dispatch('findStudent',{data});

                              setTimeout(()=>{
                               if(this.$store.state.person.student.length>=1){
                                 this.modal1=true
                               }else{

                              let data = {
                                "stuName": this.formInline.stuName,
                                "stuNum":this.formInline.stuNum,
                                "stuSex":this.formInline.stuSex,
                                "stuClass":this.formInline.stuClass,
                                "stuPassword":"123"
                              }

                              this.$store.dispatch('addStudent',{data});
                              router.push({ path: '/admin_index/admin_person_student' });
                            }
                          },1200)
                             }

                          } else {
                              this.$Message.error('表单数据不能为空!');
                          }
                      })


      },
      clearable(){
        this.formInline.stuName='',
        this.formInline.stuNum='',
        this.formInline.stuSex='',
        this.formInline.stuClass=''
      },
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .userLogin{
    text-align: left;
    background-color: inherit;
  }
  .text{

          text-align:left;
       }

</style>
