
<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

          <FormItem prop="lesId" >
            <Input type="text"  v-model="formInline.lesId" placeholder="lesId" style="width: 200px" clearable>
            </Input>
          </FormItem>
          <FormItem   prop="lesName">
            <Input type="text"  v-model="formInline.lesName" placeholder="lesName" style="width: 200px" clearable>
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
                  lesId:this.$store.state.lesson.ulesson.lesId,
                  lesName:this.$store.state.lesson.ulesson.lesName
                },
                ruleInline: {
                    lesId: [
                        { required: true, message: 'Please fill in the lesson Id', trigger: 'blur' }
                    ],
                    lesName: [
                        { required: true, message: 'Please fill in the lesson Name.', trigger: 'blur' },
                    ],

                }
            }
        },
        methods: {

              handleSubmit() {

                if(this.$store.state.lesson.utaction=="2"){
                  let data = {
                      "lesId": this.formInline.lesId,
                      "lesName":this.formInline.lesName,
                  }
                  this.$store.dispatch('updateLesson',{data});
                  router.push({ path: '/admin_index/admin_Lesson' });
                }else{
                  const axios = require('axios');
                  let data = {
                  "lesId":this.formInline.lesId,
                  "lesName":this.formInline.lesName
                  }

               this.$store.dispatch('addLesson',{data});
               router.push({ path: '/admin_index/admin_Lesson' });
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
