<template>
    <div class="userLayout">
    <div class="text" >
        <Icon type="ios-person-outline"></Icon>
        个人信息维护--修改密码
    </div>

    <Form ref="formInline" :model="formInline" :rules="ruleInline">
     <FormItem prop="password">
      <Input type="password" v-model="formInline.password" placeholder="Password" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>
        原密码
     </FormItem>

     <FormItem prop="newpassword">
      <Input type="password" v-model="formInline.newpassword" placeholder="newPassword" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>
        新密码
     </FormItem>

     <FormItem prop="repassword">
      <Input type="password" v-model="formInline.repassword" placeholder="rePassword" style="width: 200px" clearable>
        <Icon type="ios-person-outline" slot="center"></Icon>
      </Input>
        确认密码
     </FormItem>

     <FormItem>
          <Button type="primary" @click="handleput('formInline')">保存</Button>
          <Button type="primary" @click="handleReset('formInline')">重置</Button>
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
                    radio:'1'
              },

            }
        },
        methods: {
              handleput(password) {
                const axios = require('axios');
                let data = {

                    "password":this.formInline.password,
                    "newpassword":this.formInline.newpassword,
                    "repassword":this.formInline.repassword,
                    "identity":this.formInline.radio
                }

             this.$store.dispatch('userLayout',{data});

            },

            handleReset(password){
            const axios = require('axios');
            let data = {
                "password":this.formInline.password,
                "newpassword":this.formInline.newpassword,
                "repassword":this.formInline.repassword,
                "identity":this.formInline.radio
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
