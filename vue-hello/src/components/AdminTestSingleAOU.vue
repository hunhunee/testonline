<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline" label-width="400">

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
          <FormItem   prop="testAns3">
              <Input type="text" v-model="formInline.testAns3" placeholder="testAns3" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <FormItem   prop="testAns4">
              <Input type="text" v-model="formInline.testAns4" placeholder="testAns4" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <FormItem   prop="rightans1">
              <Input type="text" v-model="formInline.rightans1" placeholder="rightans1" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <FormItem prop="lesson">
            <Select v-model="formInline.lesson" style="width:200px" placeholder="LessonName">
              <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>

          </FormItem>
          <FormItem prop="status">
            <Select v-model="formInline.status" style="width:200px" placeholder="testStatus">
              <Option v-for="item in statusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
          </FormItem>

          <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">确认</Button>

            <Button @click="clearable" style="margin-left: 8px">重置</Button>
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
                 testAns3:this.$store.state.test.utest.testAns3,
                 testAns4:this.$store.state.test.utest.testAns4,
                 rightans1:this.$store.state.test.utest.rightans1,
                 lesson: this.$store.state.test.utest.testCourse,
                 status:this.$store.state.test.utest.testStatus,
                },
                ruleInline: {
                    testContent: [
                        { required: true, message: 'Please fill in the testContent', trigger: 'blur' }
                    ],
                    testAns1: [
                        { required: true, message: 'Please fill in the testAns1.', trigger: 'blur' },
                    ],
                    testAns2: [
                        { required: true, message: 'Please fill in the testAns2.', trigger: 'blur' },
                    ],
                    testAns3: [
                        { required: true, message: 'Please fill in the testAns3.', trigger: 'blur' }
                    ],
                    testAns4: [
                        { required: true, message: 'Please fill in the testAns4.', trigger: 'blur' }
                    ],
                    rightans1: [
                        { required: true, message: 'Please fill in the rightans1.', trigger: 'blur' }
                    ],
                    lesson: [
                        { required: true, message: 'Please fill in the lesson.', trigger: 'blur' }
                    ],
                    status: [
                        { required: true, message: 'Please fill in the status.', trigger: 'blur' }
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



                  statusList: [
                    {
                        value: '0',
                        label: '随机'
                    },
                    {
                        value: '1',
                        label: '必考'
                    },

                    ],

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

              handleSubmit(name) {

                this.$refs[name].validate((valid) => {
                                  if (valid) {

                                    console.log("操作类型");
                                    console.log(this.$store.state.test.action);
                                    if(this.$store.state.test.action=="1"){
                                     let data = {

                                       testContent:this.formInline.testContent,
                                       testAns1:this.formInline.testAns1,
                                       testAns2:this.formInline.testAns2,
                                       testAns3:this.formInline.testAns3,
                                       testAns4:this.formInline.testAns4,
                                       rightans1:this.formInline.rightans1,
                                       testType:this.getTestType,
                                       testCourse:this.formInline.lesson,
                                       testStatus:this.formInline.status
                                     }
                                     this.$store.dispatch('addTest',{data});

                                    }else{
                                      const axios = require('axios');
                                      let data = {
                                          testId:this.$store.state.test.utest.testId,
                                          testContent:this.formInline.testContent,
                                          testAns1:this.formInline.testAns1,
                                          testAns2:this.formInline.testAns2,
                                          testAns3:this.formInline.testAns3,
                                          testAns4:this.formInline.testAns4,
                                          rightans1:this.formInline.rightans1,
                                          testType:this.getTestType,
                                          testCourse:this.formInline.lesson,
                                          testStatus:this.formInline.status
                                      }
                                      this.$store.dispatch('updateTest',{data});
                                    }

                                  } else {
                                    this.$Message.error('表单数据不能为空!');
                                  }
                              })


            },
            clearable(){
              this.formInline.testContent='',
              this.formInline.testAns1='',
              this.formInline.testAns2='',
              this.formInline.testAns3='',
              this.formInline.testAns4='',
              this.formInline.rightans1=''

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

<style scoped>
.userLogin{
text-align: left;
background-color: inherit;
 }


</style>
