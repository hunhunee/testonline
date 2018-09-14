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

          <FormItem   prop="rightans2">
              <Input type="text" v-model="formInline.rightans2" placeholder="rightans2" style="width: 200px" clearable>

              </Input>
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
                 testAns1:this.$store.state.test.utest.testAns1,
                 testAns2:this.$store.state.test.utest.testAns1,
                 testAns3:this.$store.state.test.utest.testAns1,
                 testAns4:this.$store.state.test.utest.testAns1,
                 rightans1:this.$store.state.test.utest.rightans1,
                 rightans2:this.$store.state.test.utest.rightans2,
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
                    testAns3: [
                        { required: true, message: 'Please fill in the class.', trigger: 'blur' }
                    ],
                    testAns4: [
                        { required: true, message: 'Please fill in the class.', trigger: 'blur' }
                    ],
                    rightans1: [
                        { required: true, message: 'Please fill in the class.', trigger: 'blur' }
                    ],
                    rightans2: [
                        { required: true, message: 'Please fill in the class.', trigger: 'blur' }
                    ],
                }
            }
        },
        methods: {

              handleSubmit() {

                if(this.$store.state.test.utest.testType!=null){
                  let data = {
                    testId:this.$store.state.test.utest.testId,
                    testContent:this.formInline.testContent,
                    testAns1:this.formInline.testAns1,
                    testAns2:this.formInline.testAns2,
                    testAns3:this.formInline.testAns3,
                    testAns4:this.formInline.testAns4,
                    rightans1:this.formInline.rightans1,
                    rightans2:this.formInline.rightans2,
                    testType:this.getTestType,
                    testCourse:this.getLesson
                  }
                  this.$store.dispatch('updateTest',{data});

                }else{
                  const axios = require('axios');
                  let data = {
                      testContent:this.formInline.testContent,
                      testAns1:this.formInline.testAns1,
                      testAns2:this.formInline.testAns2,
                      testAns3:this.formInline.testAns3,
                      testAns4:this.formInline.testAns4,
                      rightans1:this.formInline.rightans1,
                      rightans2:this.formInline.rightans2,
                      testType:this.getTestType,
                      testCourse:this.getLesson
                  }
                this.$store.dispatch('addTest',{data});
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
