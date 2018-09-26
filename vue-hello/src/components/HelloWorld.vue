
<template>
  <div class="userLogin">

    <Form ref="formInline" :model="formInline" :rules="ruleInline">

          <FormItem prop="user" >
              <Input type="text"  v-model="formInline.user" placeholder="Username" style="width: 200px" clearable>
                  <Icon type="ios-person-outline" slot="center"></Icon>
              </Input>
          </FormItem>
          <FormItem prop="password">
              <Input type="password" v-model="formInline.password" placeholder="Password" style="width: 200px" clearable>
                  <Icon type="ios-lock-outline" slot="center"></Icon>
              </Input>
          </FormItem>

            <FormItem >
              <RadioGroup v-model="formInline.radio">
                  <Radio label="1">管理员</Radio>
                  <Radio label="2">教师</Radio>
                  <Radio label="3">学生</Radio>
              </RadioGroup>
          </FormItem>

          <FormItem>
              <Button type="primary" @click="handleSubmit('formInline')">Signin</Button>
          </FormItem>
      </Form>

  </div>

</template>

<script>

export default {

        data () {
            return {
                formInline: {
                    user: '',
                    password: '',
                    radio:'1'
                },
                ruleInline: {
                    user: [
                        { required: true, message: 'Please fill in the user name', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: 'Please fill in the password.', trigger: 'blur' },

                    ]
                }
            }
        },
        methods: {

              handleSubmit(name) {

                const axios = require('axios');
                let data = {
                    "usernum": this.formInline.user,
                    "password":this.formInline.password,
                    "identity":this.formInline.radio
                }
                      //
                      // this.$api.login(data)
                      // .then((response) => {
                      //    console.log(response)
                      // }).catch(
                      //   (error)=>{
                      //     console.log(error)
                      //   }
                      // );
             this.$store.dispatch('userLogin',{data});



            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.userLogin{
text-align: center;
background-color: #7FFFAA;
 }


</style>
