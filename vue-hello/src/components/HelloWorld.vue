<template>

  <div class="userLogin">
      <div class="text" >
          <Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg" />
          在线考试系统登录界面
      </div>
    <div class="inwar">
            <Form ref="formInline" :model="formInline" :rules="ruleInline"  >
                <FormItem prop="user" >
                    登录名：
                    <Input type="text"  v-model="formInline.user" placeholder="Username" style="width: 200px" clearable>
                        <Icon type="ios-person-outline" slot="center"></Icon>
                    </Input>

                </FormItem>

                <FormItem prop="password">
                  密  码：
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
                        <Button type="primary" @click="handleSubmit('formInline')">登录</Button>
                    </FormItem>
            </Form>
            </div>
          <div class="corp">
            <p>2018-9&copy;第二小组出版，版权归己所有，拒绝侵权</p>
        </div>
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
                }
                // ruleInline: {
                //     user: [
                //         { required: true, message: 'Please fill in the user name', trigger: 'blur' }
                //     ],
                //     password: [
                //         { required: true, message: 'Please fill in the password.', trigger: 'blur' }
                //     ]
                // }
            }
        },



        created() {
          console.log("login created");
          localStorage.setItem("login_message",0)
        },
        methods: {

          handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {

                        const axios = require('axios');
                        let data = {
                            "usernum": this.formInline.user,
                            "password":this.formInline.password,
                            "identity":this.formInline.radio

                        }
                        this.$store.dispatch('userLogin',{data});
                       setTimeout(()=>{
                         console.log(localStorage.getItem("login_message"));
                         if(localStorage.getItem("login_message")==1){
                           this.$Message.error('您的登录名或密码有误，请重新输入！');
                         }

                       },1200)



                    } else {
                        this.$Message.error('请填写必要信息！');
                    }
                })
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.userLogin{
    text-align: center;
    line-height: 200px;
    background: url('~@/assets/test1.jpg');
    background-size: cover;
     }
     .text{
              text-align:center;
              font-size: 18px;
              color: #ffffff;
          }
      .corp{
        text-align: right;
        font-size: 18px;
      }
      .inwar{
          text-align: center;
          color: #ffffff;
      }


</style>
