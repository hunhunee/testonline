<style scoped>
    .text{
            font-size: 8px;
            text-align:right;
         }
</style>
<template>

  <div class="layout">
    <div class="text" >
      <h1>
        距离考试结束时间还有：
        <span style="color:red">
          {{minutes}}
        </span>
          分
        <span style="color:red">
          {{seconds}}
        </span>
          秒
      </h1>
  </div>

  <Card style="width:1300px">
       <p slot="title">
           <Icon type="ios-film-outline"></Icon>
           单选题   每题2分
       </p>
       <ul>
           <li v-for="item in examSingleList">

             <Card style="width:1000px">
               <p>{{ item.testContent }}</p>
               <RadioGroup v-model="item.testAnswer">
                    <Radio :label="item.testAns1"></Radio>
                    <Radio :label="item.testAns2"></Radio>
                    <Radio :label="item.testAns3"></Radio>
                    <Radio :label="item.testAns4"></Radio>
                </RadioGroup>
             </Card>

           </li>
       </ul>
   </Card>

   <Card style="width:1300px">
        <p slot="title">
            <Icon type="ios-film-outline"></Icon>
            多选题   每题2分
        </p>
        <ul>
            <li v-for="item in examMultipleList">
              <Card style="width:1000px">
                <p>{{ item.testContent }}</p>
                <CheckboxGroup v-model="item.testAnswerArray">
                    <Checkbox :label="item.testAns1"></Checkbox>
                    <Checkbox :label="item.testAns2"></Checkbox>
                    <Checkbox :label="item.testAns3"></Checkbox>
                    <Checkbox :label="item.testAns4"></Checkbox>
                </CheckboxGroup>
              </Card>
            </li>
        </ul>
    </Card>


    <Card style="width:1300px">
         <p slot="title">
             <Icon type="ios-film-outline"></Icon>
             判断题   每题2分
         </p>
         <ul>
             <li v-for="item in examJudgeList">
               <Card style="width:1000px">
                 <p>{{ item.testContent }}</p>
                 <RadioGroup v-model="item.testAnswer">
                      <Radio :label="item.testAns1"></Radio>
                      <Radio :label="item.testAns2"></Radio>
                  </RadioGroup>
               </Card>
             </li>
         </ul>
     </Card>


     <Card style="width:1300px">
          <p slot="title">
              <Icon type="ios-film-outline"></Icon>
              综合题   每题15分
          </p>
          <ul>
              <li v-for="item in examComputeList">
                <Card style="width:1000px">
                  <p>{{ item.testContent }}</p>
                  <Input v-model="item.testAnswer" placeholder="请输入正确答案，答题步骤不需要填入" style="width: 300px" />
                </Card>
              </li>
          </ul>
      </Card>
      <Button type="primary" size="large" @click="submit">交卷</Button></Button>
    </div>
</template>
<script>
    export default {
        data () {
            return {
              examSingleList:[],
              examMultipleList:[],
              examJudgeList:[],
              examComputeList:[],
              minutes:60,  //定义分数值参数
              seconds:0,//定义秒值参数

            };
        },

        created: function(){
          console.log("created");

          // this.examSingleList=this.$store.state.exam.examSingleList;
          // console.log(this.examSingleList);

          setInterval(()=>{
             this.examSingleList.length=15;
             this.examMultipleList.length=10;
             this.examJudgeList.length=10;
             this.examComputeList.length=2;

             for (var i = 0; i < 15; i++) {
               this.$set(this.examSingleList,i,this.$store.state.exam.examSingleList[i])
             }

             for (var i = 0; i < 10; i++) {
               this.$set(this.examMultipleList,i,this.$store.state.exam.examMultipleList[i])
             }

             for (var i = 0; i < 10; i++) {
               this.$set(this.examJudgeList,i,this.$store.state.exam.examJudgeList[i])
             }

             for (var i = 0; i < 2; i++) {
               this.$set(this.examComputeList,i,this.$store.state.exam.examComputeList[i])
             }
          }, 1000);

        },

        methods:{
          //判断
          countDown(){
            let THIS=this;

              if( THIS.minutes == 0 && THIS.seconds == 0 ){
                  THIS.minutes = 60;

                    var examList_sm =this.examSingleList.concat(this.examMultipleList);
                    var examList_jm =this.examJudgeList.concat(this.examComputeList);
                    var examList=examList_sm.concat(examList_jm);

                    let data={
                      studentAnswer:{
                        stuId:localStorage.getItem("userid"),
                        stuClass:localStorage.getItem("_class")
                      },
                      examList:examList
                    }
                     this.$store.dispatch('addExamResult',{data});
                     localStorage.setItem("isExam",0);
                  this.$router.push('/student_index/student_end'); //跳转到指定页面

                }else if (THIS.minutes >= 0) {

                  if(THIS.seconds > 0 ){

                    THIS.seconds--;

                  }else if (THIS.seconds == 0) {

                      THIS.minutes--;
                      THIS.seconds = 60;

                  }

              }

          },

          submit:function(){
            var examList_sm =this.examSingleList.concat(this.examMultipleList);
            var examList_jm =this.examJudgeList.concat(this.examComputeList);
            var examList=examList_sm.concat(examList_jm);


            let data={
              studentAnswer:{
                stuId:localStorage.getItem("userid"),
                stuClass:localStorage.getItem("_class")
              },
              examList:examList
            }
             this.$store.dispatch('addExamResult',{data});



             setTimeout(()=>{
              let student={
                 //从本地获取学生的学号
                 stuNum:localStorage.getItem("usernum"),

               }
               localStorage.setItem("isExam",0);
              this.$store.dispatch('findStudnetScore',{student})
            },1000)

          }

        },

        mounted(){
           let THIS=this;
           setInterval(THIS.countDown,1000);

          },

        }



</script>
