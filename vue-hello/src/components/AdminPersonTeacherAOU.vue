
<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

          <FormItem prop="teaName" >
              <Input type="text"  v-model="formInline.teaName" placeholder="UserName" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <FormItem   prop="teaNum">
              <Input type="text" v-model="formInline.teaNum" placeholder="UserNum" style="width: 200px" clearable>

              </Input>
          </FormItem>

          <FormItem>
            <Select v-model="lesson" style="width:200px" placeholder="Select your lesson">
              <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
          </FormItem>

        <FormItem   prop="teaClass" >
          <Select v-model="formInline.teaClass" placeholder="Select your class" style="width: 200px">
              <Option value="1">一班</Option>
              <Option value="2">二班</Option>
              <Option value="3">三班</Option>
          </Select>
      </FormItem>

          <FormItem>
            <Button type="primary" @click="handleSubmit()">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
        </FormItem>
      </Form>

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
                l:{value:"",
                    label:""
                },
                lessonIdString:"",
                lessonNameString:"",
                lessonIdList:[],
                lessonNameList:[],
                lesson: ''
            }
        },
        created: function () {
         console.log("created");

                        console.log("lessonlist");
                        this.lessonIdString=localStorage.getItem("lessonIdList");
                        this.lessonNameString=localStorage.getItem("lessonNameList");

                        for (var i = 0; i < this.lessonNameString.split(',').length; i++) {
                          this.lessonList.push({
                            value:this.lessonIdString.split(',')[i],
                            label:this.lessonNameString.split(',')[i]
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
                  let data = {
                      "teaName": this.formInline.teaName,
                      "teaNum":this.formInline.teaNum,
                      "teaCourse":this.lesson,
                      "teaClass":this.formInline.teaClass,
                      "teaPassword":"123"
                  }

               this.$store.dispatch('addTeacher',{data});
               router.push({ path: '/admin_index/admin_person_teacher' });
                }

            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.userLogin{
text-align: center;
background-color: inherit;
 }


</style>
