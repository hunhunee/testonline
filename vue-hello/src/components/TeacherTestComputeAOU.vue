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
                }
            }
        },
        methods: {

              handleSubmit() {

                if(this.$store.state.test.utest.testType!=null){
                  let data = {
                    testId:this.$store.state.test.utest.testId,
                    testContent:this.formInline.testContent,

                    rightans1:this.formInline.rightans1,
                    testType:this.getTestType,
                    testCourse:this.getLesson
                  }
                  this.$store.dispatch('updateTest',{data});

                }else{
                  const axios = require('axios');
                  let data = {
                      testContent:this.formInline.testContent,
                     
                      rightans1:this.formInline.rightans1,
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
