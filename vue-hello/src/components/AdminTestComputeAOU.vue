<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

          <FormItem prop="testContent" >
              <Input type="textarea"  v-model="formInline.testContent" placeholder="testContent" style="width: 200px" clearable>

              </Input>
          </FormItem>

          <FormItem   prop="rightans1">
              <Input type="text" v-model="formInline.rightans1" placeholder="rightans1" style="width: 200px" clearable>

              </Input>
          </FormItem>
          <FormItem>
            <Select v-model="lesson" style="width:200px">
              <Option v-for="item in lessonList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>

          </FormItem>
          <FormItem>
            <Select v-model="status" style="width:200px">
              <Option v-for="item in statusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
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

                 testContent:this.$store.state.test.utest.testContent,

                 rightans1:this.$store.state.test.utest.rightans1

                },
                ruleInline: {
                    testContent: [
                        { required: true, message: 'Please fill in the user name', trigger: 'blur' }
                    ],


                    rightans1: [
                        { required: true, message: 'Please fill in the class.', trigger: 'blur' }
                    ],
                },

                lessonList: [
                  {
                      value: '1',
                      label: '英语'
                  },
                  {
                      value: '2',
                      label: '数学'
                  },
                  {
                      value: '3',
                      label: '物理'
                  },
                  {
                      value: '4',
                      label: '语文'
                  },

                  ],


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
                  lesson: this.$store.state.test.utest.testCourse,
                  status:this.$store.state.test.utest.testStatus,

            }
        },
        methods: {


                    handleSubmit() {
                       console.log("操作类型");
                       console.log(this.$store.state.test.action);
                      if(this.$store.state.test.action=="1"){
                        let data = {

                          testContent:this.formInline.testContent,

                          rightans1:this.formInline.rightans1,
                          testType:this.getTestType,
                          testCourse:this.lesson,
                          testStatus:this.status,
                        }
                        this.$store.dispatch('addTest',{data});

                      }else{
                         const axios = require('axios');
                         let data = {
                             testId:this.$store.state.test.utest.testId,
                             testContent:this.formInline.testContent,

                             rightans1:this.formInline.rightans1,
                             testType:this.getTestType,
                             testCourse:this.lesson,
                             testStatus:this.status,
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


<style scoped>
.userLogin{
text-align: center;
background-color: inherit;
 }


</style>
