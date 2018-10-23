
<template>
  <div class="userLogin">
    <div class="text" >
      科目设置----添加、修改科目信息
    </div>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" :label-width="400">

          <!-- <FormItem prop="lesId" >
            <Input type="text" disabled  v-model="formInline.lesId" placeholder="lesId" style="width: 200px" clearable>
            </Input>
          </FormItem> -->

          <FormItem prop="lesId" >
                <Input v-if="this.$store.state.lesson.utaction=='2'" disabled type="text" v-model="formInline.lesId" placeholder="lessonId" style="width: 200px">
                </Input>

                <Input  v-else type="text" v-model="formInline.lesId" placeholder="lessonId" style="width: 200px" clearable>
                </Input>
          </FormItem>

          <FormItem   prop="lesName">
            <Input type="text"  v-model="formInline.lesName" placeholder="lesName" style="width: 200px" clearable>
            </Input>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">确认</Button>
            <Button v-if="this.$store.state.lesson.utaction=='2'" @click="clearable_update" style="margin-left: 8px">重置</Button>
            <Button v-else @click="clearable" style="margin-left: 8px">重置</Button>
        </FormItem>
      </Form>
      <Modal
        v-model="modal"
        title="message"

        @on-ok="ok"
        @on-cancel="cancel">
        <p>
          该科目编号已经存在或者科目名称重复，请重新输入！！！
        </p>
      </Modal>
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

                       { required: true, message: 'Please fill in the lesson Id.', trigger: 'blur' },
                        { validator: this.validateMobile,trigger: 'blur' }
                    ],
                    lesName: [
                        { required: true, message: 'Please fill in the lesson Name.', trigger: 'blur' },
                    ],

                },
              modal:false,

            }
        },
        methods: {
          validateMobile :(rule, value, callback) => {

           if (!Number.isInteger(+value)) {
               callback(new Error('请输入数字值'));
           } else {
               callback();
           }
       },

              handleSubmit(name) {

                this.$refs[name].validate((valid) => {
                    console.log(this.formInline.lesId);
                    console.log();
                    if (valid) {

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

                        this.$store.dispatch('findLessonByLesNameAndByLesId',{data});

                        setTimeout(()=>{
                          console.log("lesson.length");
                          console.log(this.$store.state.lesson.lesson.length);
                          if (this.$store.state.lesson.lesson.length>=1) {
                            console.log("modal=true");
                            this.modal=true
                          }else{
                            this.$store.dispatch('addLesson',{data});
                          }

                        },1200)
                      }
                    } else {
                        this.$Message.error('表单数据不能为空!');
                    }
                })


        },
        clearable(){
          this.formInline.lesId='',
          this.formInline.lesName=''
       },
       clearable_update(){
         this.formInline.lesName=''
      },
          ok:function(){
            this.modal = false
          },
          cancel:function(){
          }

    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.userLogin{
text-align: left;
background-color: inherit;
 }
 .text{

         text-align:left;
      }
</style>
