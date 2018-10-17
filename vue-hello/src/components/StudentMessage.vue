<template>
  <div class="userLayout">
    <div class="text" >
        <Icon type="ios-person-outline"></Icon>
        个人信息维护--修改密码
    </div>

    <Form ref="formInline" :model="formInline" :rules="ruleInline">
     <FormItem prop="password">
         原密码:
      <Input type="password" v-model="formInline.password" placeholder="请输入原密码" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>

     </FormItem>

     <FormItem prop="newpassword">
       新密码:
      <Input type="password" v-model="formInline.newpassword" placeholder="请输入新密码" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>

     </FormItem>

     <FormItem prop="repassword">
       确认密码：
      <Input type="password" v-model="formInline.repassword" placeholder="请再次输入新密码" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>

     </FormItem>

     <FormItem>
          <Button type="primary" @click="handleSubmit('formInline')">修改</Button>

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
                  repassword:'',
                  radio:'3'
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
          handleSubmit(name){

            this.$refs[name].validate((valid) => {
                                if (valid) {

                                  const axios = require('axios');
                                  if (this.formInline.newpassword==this.formInline.repassword) {
                                    let data = {
                                        "password":this.formInline.password,
                                        "newpassword":this.formInline.newpassword,
                                        "repassword":this.formInline.repassword,
                                        "identity":this.formInline.radio,
                                        "userid":localStorage.getItem("userid")
                                    }
                                    this.$store.dispatch('userLayout',{data});

                                    setTimeout(()=>{

                                        this.$Message.error(this.$store.state.info.message);
                                    },1200)

                                  }else{

                                      this.$Message.error('两次密码不相同，请重新输入！');
                                  }


                                } else {
                                    this.$Message.error('Fail!');
                                }
                            })


          }


        }
        }

</script>

<style scoped>
 .userLayout{
           text-align:center;
           background-color: inherit;
      }
      .text{
              text-align:left;
           }

</style>
