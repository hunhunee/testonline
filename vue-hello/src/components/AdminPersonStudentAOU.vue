
<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

      <FormItem prop="stuName" >
        <Input type="text"  v-model="formInline.stuName" placeholder="UserName" style="width: 200px" clearable>

        </Input>
      </FormItem>
      <FormItem   prop="stuNum">
        <Input type="text" v-model="formInline.stuNum" placeholder="UserNum" style="width: 200px" clearable>

        </Input>
      </FormItem>

      <FormItem  prop="stuSex" style="width: 200px">
        <Select v-model="formInline.stuSex" placeholder="Select your course">
          <Option value="1">男</Option>
          <Option value="2">女</Option>
        </Select>
      </FormItem>

      <FormItem   prop="stuClass" style="width: 200px">
        <Select v-model="formInline.stuClass" placeholder="Select your class">
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
          stuName: this.$store.state.person.ustudent.stuName,
          stuNum: this.$store.state.person.ustudent.stuNum,
          stuClass:this.$store.state.person.ustudent.stuClass,
          stuSex:this.$store.state.person.ustudent.stuSex
        },
        ruleInline: {
          stuName: [
            { required: true, message: 'Please fill in the user name', trigger: 'blur' }
          ],
          stuNum: [
            { required: true, message: 'Please fill in the password.', trigger: 'blur' },
          ],
          stuSex: [
            { required: true, message: 'Please fill in the course.', trigger: 'blur' },
          ],
          stuClass: [
            { required: true, message: 'Please fill in the class.', trigger: 'blur' }
          ],
        }
      }
    },
    methods: {

      handleSubmit() {

        if(this.$store.state.person.utaction=="2"){
          let data = {
            "stuName": this.formInline.stuName,
            "stuNum":this.formInline.stuNum,
            "stuSex":this.formInline.stuSex,
            "stuClass":this.formInline.stuClass,
            "stuPassword":this.$store.state.person.ustudent.stuPassword
          }
          this.$store.dispatch('updateStudent',{data});
          router.push({ path: '/admin_index/admin_person_student' });
        }else{
          const axios = require('axios');
          let data = {
            "stuName": this.formInline.stuName,
            "stuNum":this.formInline.stuNum,
            "stuSex":this.formInline.stuSex,
            "stuClass":this.formInline.stuClass,
            "stuPassword":"123"
          }

          this.$store.dispatch('addStudent',{data});
          router.push({ path: '/admin_index/admin_person_student' });
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
