
<template>
  <div class="userLogin">
    <div class="text" >
        用户管理-----添加教师信息
    </div>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" label-width="400">

          <FormItem prop="teaName" >
              <Input type="text"  v-model="formInline.teaName" placeholder="UserName" style="width: 200px" clearable>
              </Input>
          </FormItem>


          <FormItem prop="teaNum" >
                <Input v-if="this.$store.state.person.utaction=='2'" disabled type="text" v-model="formInline.teaNum" placeholder="UserNum" style="width: 200px">
                </Input>

                <Input  v-else type="text" v-model="formInline.teaNum" placeholder="UserNum" style="width: 200px" clearable>
                </Input>
          </FormItem>




          <FormItem prop="teaCourse">
            <Select v-model="formInline.teaCourse" style="width:200px" placeholder="Select your lesson">
              <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
          </FormItem>

        <FormItem prop="teaClass" >
          <Select v-model="formInline.teaClass" placeholder="Select your class" style="width: 200px">
            <Option v-for="item in classList" :value="item.value" :key="item.value">{{ item.label }}</Option>

          </Select>
      </FormItem>

          <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">Submit</Button>

            <Button @click="clearable" style="margin-left: 8px">Reset</Button>
        </FormItem>
      </Form>
      <Modal
          v-model="modal1"
          title="message"

          @on-ok="ok"
          @on-cancel="cancel">
          <p>
             该工号已经存在，请重新输入！！！
          </p>
      </Modal>
      <Modal
          v-model="modal"
          title="message"

          @on-ok="ok"
          @on-cancel="cancel">
          <p>
             该班级已经有了该科目的老师请重新选择班级！！！
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
                    teaName: this.$store.state.person.uteacher.teaName,
                    teaNum: this.$store.state.person.uteacher.teaNum,
                    teaClass:this.$store.state.person.uteacher.teaClass,
                    teaCourse:this.$store.state.person.uteacher.teaCourse
                },
                ruleInline: {
                    teaName: [
                        { required: true, message: 'Please fill in the user name', trigger: 'blur' }
                    ],
                    teaNum: [
                        { required: true, message: 'Please fill in the password.', trigger: 'blur' },
                    ],
                    teaClass: [
                        { required: true, message: 'Please fill in the class.', trigger: 'blur' }
                    ],
                    teaCourse: [
                        { required: true, message: 'Please fill in the course.', trigger: 'blur' }
                    ]
                },
                lessonList: [],
                lessonIdString:"",
                lessonNameString:"",
                classList: [],
                classIdString:"",
                classNameString:"",
                modal:false,
                modal1:false
            }
        },
        created: function () {
         console.log("created");

                        console.log("lessonlist");
                        this.lessonIdString=localStorage.getItem("lessonIdList");
                        this.lessonNameString=localStorage.getItem("lessonNameList");
                        this.classIdString=localStorage.getItem("classIdList");
                        this.classNameString=localStorage.getItem("classNameList");

                        for (var i = 0; i < this.lessonNameString.split(',').length; i++) {
                          this.lessonList.push({
                            value:this.lessonIdString.split(',')[i],
                            label:this.lessonNameString.split(',')[i]
                          })
                       }
                       console.log(this.formInline.teaClass);
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

                      let teacher = {
                          "teaName": this.formInline.teaName,
                          "teaNum":this.formInline.teaNum,
                          "teaCourse":this.formInline.teaCourse,
                          "teaClass":this.formInline.teaClass,
                          "teaPassword":"123"
                      }
                      this.$store.dispatch('findTeacherByClass',{teacher});

                 setTimeout(()=>{
                  if (this.$store.state.person.teacher.length>=1) {
                          this.$Message.error('该班级已经有了该科目的老师请重新选择班级');
                  }else{
                      let data = {
                          "teaName": this.formInline.teaName,
                          "teaNum":this.formInline.teaNum,
                          "teaCourse":this.formInline.teaCourse,
                          "teaClass":this.formInline.teaClass,
                          "teaPassword":this.$store.state.person.uteacher.teaPassword
                      }
                      this.$store.dispatch('updateTeacher',{data});
                    }
                   },1200)

                    }else{
                      const axios = require('axios');

                      localStorage.setItem("check",1);
                      let data = {
                          "num": this.formInline.teaNum
                      }
                      this.$store.dispatch('findTeacher',{data});

                     setTimeout(()=>{
                       if(this.$store.state.person.teacher.length>=1){
                         this.modal1=true
                       }else{


                         let teacher = {
                             "teaName": this.formInline.teaName,
                             "teaNum":this.formInline.teaNum,
                             "teaCourse":this.formInline.teaCourse,
                             "teaClass":this.formInline.teaClass,
                             "teaPassword":"123"
                         }
                         this.$store.dispatch('findTeacherByClass',{teacher});


                         setTimeout(()=>{

                           if (this.$store.state.person.teacher.length>=1) {
                                  this.modal=true
                           }else{

                             let data = {
                                 "teaName": this.formInline.teaName,
                                 "teaNum":this.formInline.teaNum,
                                 "teaCourse":this.formInline.teaCourse,
                                 "teaClass":this.formInline.teaClass,
                                 "teaPassword":"123"
                             }

                            this.$store.dispatch('addTeacher',{data});
                           }

                         },1200)

                       }
                     },1200)

                    }

                  } else {
                      this.$Message.error('表单数据不能为空!');
                  }
              })



            },

            ok:function(){
             this.modal=false
            },
            cancel:function(){

            },
            clearable(){
              this.formInline.teaName='',
              this.formInline.teaNum='',
              this.formInline.teaCourse='',
              this.formInline.teaClass=''

           }

        }
    }
</script>


<style scoped>
.userLogin{
text-align: left;
background-color: inherit;
 }

 .text{

         text-align:left;
      }
</style>
