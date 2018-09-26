<template>
    <div class="userLayout">
    <div class="text" >
        <Icon type="ios-person-outline"></Icon>
        个人信息维护--修改密码
    </div>

    <Form ref="formInline" :model="formInline" :rules="ruleInline">
     <FormItem prop="password">
      <Input type="password" v-model="formInline.password" placeholder="请输入原密码" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>
        原密码
     </FormItem>

     <FormItem prop="newpassword">
      <Input type="password" v-model="formInline.newpassword" placeholder="请输入新密码" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>
        新密码
     </FormItem>

     <FormItem prop="repassword">
      <Input type="password" v-model="formInline.repassword" placeholder="请再次输入新密码" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>
        确认密码
     </FormItem>

     <FormItem>
          <Button type="primary" @click="handleput('formInline')">修改密码</Button>

     </FormItem>
     </Form>

    </div>
</template>

<script>
    export default {
        data () {
            return {
              formInline:{
              password:'',
                newpassword:'',
                  repassword:''
              },
              ruleInline: {
                  password: [
                      { required: true, message: 'Please fill in the password.', trigger: 'blur' },

                  ],
                  newpassword: [
                      { required: true, message: 'Please fill in the newpassword.', trigger: 'blur' },

                  ],
                  repassword: [
                      { required: true, message: 'Please fill in the repassword.', trigger: 'blur' },

                  ]
              }

            }
        },
        methods: {
          handleput(password){
              const axios = require('axios');
              let data = {
                  "password":this.formInline.password,
                  "newpassword":this.formInline.newpassword,
                  "repassword":this.formInline.repassword
              }
              this.$store.dispatch('userLayout',{data});

          }

        }
    }

</script>
  <style scoped>
    .userLayout{
          text-align:center;
          background-color:	#7FFFAA
     }
     .text{
        text-align:left;
     }

</style>
