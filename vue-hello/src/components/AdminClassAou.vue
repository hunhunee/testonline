
<template>
  <div class="userLogin">
    <div class="text" >
      班级管理----添加班级
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
            <Button type="primary" @click="handleSubmit('formInline')">Submit</Button>
            <Button @click="clearable" style="margin-left: 8px">Reset</Button>
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
                        { required: true, message: 'Please fill in the class Id', trigger: 'blur' }
                    ],
                    className: [
                        { required: true, message: 'Please fill in the class Name.', trigger: 'blur' },
                    ],

                },
                modal:false
            }
        },
        methods: {

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
                       this.$Message.error('Fail!');
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
