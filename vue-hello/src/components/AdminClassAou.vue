
<template>
  <div class="userLogin">
    <div class="text" >
      班级管理----添加、修改班级信息
    </div>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" :label-width="400">

          <!-- <FormItem prop="classId" >
            <Input type="text" disabled v-model="formInline.classId" placeholder="classId" style="width: 200px" clearable>
            </Input>
          </FormItem> -->

          <FormItem prop="classId" >
                <Input v-if="this.$store.state.Class.utaction=='2'" disabled type="text" v-model="formInline.classId" placeholder="classId" style="width: 200px">
                </Input>

                <Input  v-else type="text" v-model="formInline.classId" placeholder="classId" style="width: 200px" clearable>
                </Input>
          </FormItem>

          <FormItem   prop="className">
            <Input type="text"  v-model="formInline.className" placeholder="className" style="width: 200px" clearable>
            </Input>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')">确认</Button>
            <Button v-if="this.$store.state.Class.utaction=='2'" @click="clearable_update" style="margin-left: 8px">重置</Button>
            <Button v-else @click="clearable" style="margin-left: 8px">重置</Button>
        </FormItem>
      </Form>
      <Modal
          v-model="modal"
          title="message"

          @on-ok="ok"
          @on-cancel="cancel">
          <p>
             该班级名或者班级ID已存在，不能够重复添加！！！
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
                  classId:this.$store.state.Class.uclass.classId,
                  className:this.$store.state.Class.uclass.className
                },
                ruleInline: {
                    classId: [
                        { required: true, message: 'Please fill in the class Id.', trigger: 'blur' },
                        { validator: this.validateMobile,trigger: 'blur'}
                    ],
                    className: [
                        { required: true, message: 'Please fill in the class Name.', trigger: 'blur' },
                    ],

                },
                modal:false
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
                   if (valid) {

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

                       this.$store.dispatch('findClassById',{data});

                       setTimeout(()=>{
                        console.log("class.length");
                        console.log(this.$store.state.Class.class.length);
                        if (this.$store.state.Class.class.length>=1) {
                             console.log("modal=true");
                               this.modal=true
                        }else{

                         this.$store.dispatch('addClass',{data});
                        }

                      },1500)
                     // this.$store.dispatch('addClass',{data});
                     // router.push({ path: '/admin_index/admin_Class' });
                         }
                   } else {
                       this.$Message.error('表单数据不能为空!');
                   }
               })
            },
            ok:function(){
              this.modal = false
            },
            cancel:function(){
            },
            clearable(){
              this.formInline.classId='',
              this.formInline.className=''
           },
           clearable_update(){
             this.formInline.className=''
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
