
<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

          <FormItem prop="classId" >
            <Input type="text"  v-model="formInline.classId" placeholder="classId" style="width: 200px" clearable>
            </Input>
          </FormItem>
          <FormItem   prop="className">
            <Input type="text"  v-model="formInline.className" placeholder="className" style="width: 200px" clearable>
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
                  classId:this.$store.state.Class.uclass.classId,
                  className:this.$store.state.Class.uclass.className
                },
                ruleInline: {
                    classId: [
                        { required: true, message: 'Please fill in the class Id', trigger: 'blur' }
                    ],
                    className: [
                        { required: true, message: 'Please fill in the class Name.', trigger: 'blur' },
                    ],

                }
            }
        },
        methods: {

              handleSubmit() {

                if(this.$store.state.Class.utaction=="2"){
                  let data = {
                      "classId": this.formInline.classId,
                      "className":this.formInline.className,
                  }
                  this.$store.dispatch('updateClass',{data});
                  router.push({ path: '/admin_index/admin_Class' });
                }else{
                  const axios = require('axios');
                  let data = {
                  "classId":this.formInline.classId,
                  "className":this.formInline.className
                  }

               this.$store.dispatch('addClass',{data});
               router.push({ path: '/admin_index/admin_Class' });
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
