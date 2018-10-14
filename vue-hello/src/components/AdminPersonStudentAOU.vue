
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

      <FormItem  prop="stuSex">
        <Select v-model="formInline.stuSex" placeholder="Select your gender" style="width: 200px">
          <Option value="1">男</Option>
          <Option value="2">女</Option>
        </Select>
      </FormItem>

      <FormItem   prop="stuClass">
        <Select v-model="formInline.stuClass" placeholder="Select your class" style="width: 200px">
          <Option v-for="item in classList" :value="item.value" :key="item.value">{{ item.label }}</Option>

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
        },
        classList: [],
        classIdString:"",
        classNameString:""

      }
    },

    created: function () {
     console.log("created");

                    console.log("list");

                    this.classIdString=localStorage.getItem("classIdList");
                    this.classNameString=localStorage.getItem("classNameList");

                   
                   for (var i = 0; i < this.classNameString.split(',').length; i++) {
                     this.classList.push({
                       value:this.classIdString.split(',')[i],
                       label:this.classNameString.split(',')[i]
                     })
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
