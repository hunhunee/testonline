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

          <FormItem   prop="rightans1">
              <Input type="text" v-model="formInline.rightans1" placeholder="rightans1" style="width: 200px" clearable>

              </Input>
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
                 rightans1:this.$store.state.test.utest.rightans1,
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

                    rightans1: [
                        { required: true, message: 'Please fill in the rightans1.', trigger: 'blur' }
                    ],
                    status: [
                        { required: true, message: 'Please fill in the status.', trigger: 'blur' }
                    ],
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
                  lesson:localStorage.getItem("lesson"),

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
                       rightans1:this.formInline.rightans1,
                       testType:this.getTestType,
                       testCourse:this.lesson,
                       testStatus:this.formInline.status,
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
                          testCourse:this.lesson,
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
              this.formInline.testAns1='',
              this.formInline.testAns2='',
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.userLogin{
text-align: left;
background-color: inherit;
 }


</style>
