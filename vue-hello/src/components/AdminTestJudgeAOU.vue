<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

          <FormItem prop="testContent" >
              <Input type="textarea"  v-model="formInline.testContent" placeholder="testContent" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <FormItem   prop="testAns1">
              <Input type="text" v-model="formInline.testAns1" placeholder="testAns1" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <FormItem   prop="testAns2">
              <Input type="text" v-model="formInline.testAns2" placeholder="testAns2" style="width: 200px" clearable>

              </Input>
          </FormItem>

          <FormItem   prop="rightans1">
              <Input type="text" v-model="formInline.rightans1" placeholder="rightans1" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <Select v-model="lesson" style="width:200px">
            <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
          </Select>
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

                 testContent:this.$store.state.test.utest.testContent,
                 testAns1:this.$store.state.test.utest.testAns1,
                 testAns2:this.$store.state.test.utest.testAns2,
                 rightans1:this.$store.state.test.utest.rightans1

                },
                ruleInline: {
                    testContent: [
                        { required: true, message: 'Please fill in the user name', trigger: 'blur' }
                    ],
                    testAns1: [
                        { required: true, message: 'Please fill in the password.', trigger: 'blur' },
                    ],
                    testAns2: [
                        { required: true, message: 'Please fill in the course.', trigger: 'blur' },
                    ],

                    rightans1: [
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
                  lesson: this.$store.state.test.utest.testType,

            }
        },

        created:function(){
            console.log("lessonlist");

            this.lessonIdString=localStorage.getItem("lessonIdList");
            this.lessonNameString=localStorage.getItem("lessonNameList");


            for (var i = 0; i < this.lessonNameString.split(',').length; i++) {
               console.log(this.lessonIdString.split(',')[i]);
               this.lessonList.push({
                 value:this.lessonIdString.split(',')[i],
                 label:this.lessonNameString.split(',')[i]
               })
            }

        },

        methods: {


                    handleSubmit() {
                       console.log("操作类型");
                       console.log(this.$store.state.test.action);
                      if(this.$store.state.test.action=="1"){
                        let data = {

                          testContent:this.formInline.testContent,
                          testAns1:this.formInline.testAns1,
                          testAns2:this.formInline.testAns2,
                          rightans1:this.formInline.rightans1,
                          testType:this.getTestType,
                          testCourse:this.lesson
                        }
                        this.$store.dispatch('addTest',{data});

                      }else{
                         const axios = require('axios');
                         let data = {
                             testId:this.$store.state.test.utest.testId,
                             testContent:this.formInline.testContent,
                             testAns1:this.formInline.testAns1,
                             testAns2:this.formInline.testAns2,
                             rightans1:this.formInline.rightans1,
                             testType:this.getTestType,
                             testCourse:this.lesson
                         }
                         this.$store.dispatch('updateTest',{data});
                       }
                     }

        },


        computed: {
            getLesson:function(){
              return this.$store.getters.getLesson
            },

            getTestType:function(){
              return this.$store.getters.getTestType
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
