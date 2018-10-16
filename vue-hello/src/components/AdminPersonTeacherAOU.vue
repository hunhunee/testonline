
<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

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




          <FormItem>
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
            <Button type="primary" @click="handleSubmit()">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
        </FormItem>
      </Form>
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
                },
                lessonList: [],
                lessonIdString:"",
                lessonNameString:"",
                classList: [],
                classIdString:"",
                classNameString:"",
                modal:false
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

              handleSubmit() {

                if(this.$store.state.person.utaction=="2"){

                  let data = {
                      "teaName": this.formInline.teaName,
                      "teaNum":this.formInline.teaNum,
                      "teaCourse":this.formInline.teaCourse,
                      "teaClass":this.formInline.teaClass,
                      "teaPassword":this.$store.state.person.uteacher.teaPassword
                  }
                  this.$store.dispatch('updateTeacher',{data});
                  router.push({ path: '/admin_index/admin_person_teacher' });
                }else{
                  const axios = require('axios');

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

            },

            ok:function(){
             this.modal=false
            },
            cancel:function(){

            }

        }
    }
</script>


<style scoped>
.userLogin{
text-align: center;
background-color: inherit;
 }


</style>
