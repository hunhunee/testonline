<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline" label-width="400">

          <FormItem prop="testContent" >
              <Input type="textarea"  v-model="formInline.testContent" placeholder="testContent" style="width: 200px" clearable>

              </Input>
          </FormItem>

          <FormItem   prop="rightans1">
              <Input type="text" v-model="formInline.rightans1" placeholder="rightans1" style="width: 200px" clearable>

              </Input>
          </FormItem >

          <FormItem prop="lesson">
            <Select v-model="formInline.lesson" style="width:200px" placeholder="LessonName">
              <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>

          </FormItem >

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
                 rightans1:this.$store.state.test.utest.rightans1,
                 lesson: this.$store.state.test.utest.testCourse,
                 status:this.$store.state.test.utest.testStatus

                },
                ruleInline: {
                    testContent: [
                        { required: true, message: 'Please fill in the testContent', trigger: 'blur' }
                    ],
                    rightans1: [
                        { required: true, message: 'Please fill in the rightans1', trigger: 'blur' }
                    ],
                   lesson: [
                        { required: true, message: 'Please fill in the lesson', trigger: 'blur' }
                    ],
                    status: [
                        { required: true, message: 'Please fill in the status', trigger: 'blur' }
                    ]
                },




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
                  // lesson: this.$store.state.test.utest.testCourse,
                  // status:this.$store.state.test.utest.testStatus,

                lessonList: [],

                lessonIdString:"",
                lessonNameString:"",
                lessonIdList:[],
                lessonNameList:[],


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

                         rightans1:this.formInline.rightans1,
                         testType:this.getTestType,
                         testCourse:this.formInline.lesson,
                         testStatus:this.formInline.status,
                       }
                       this.$store.dispatch('addTest',{data});

                      }else{
                        const axios = require('axios');
                        let data = {
                            testId:this.$store.state.test.utest.testId,
                            testContent:this.formInline.testContent,

                            rightans1:this.formInline.rightans1,
                            testType:this.getTestType,
                            testCourse:this.formInline.lesson,
                            testStatus:this.formInline.status,
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
