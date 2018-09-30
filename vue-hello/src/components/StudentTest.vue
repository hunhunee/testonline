<style scoped>
    .text{
            font-size: 8px;
            text-align:right;
         }
</style>
<template>
  <div class="layout">
    <div class="text" >
      <h1> 距离考试结束时间还有：<span style="color:red">{{time}}</span>秒</h1>

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
              计算题   每题15分
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
              time:0
              //minutes:0,
            //  seconds:0
            };
        },

        created: function(){
          console.log("created");

          // this.examSingleList=this.$store.state.exam.examSingleList;
          // console.log(this.examSingleList);

          setInterval(()=>{
             this.examSingleList.length=this.$store.state.exam.examSingleList.length;
             this.examMultipleList.length=this.$store.state.exam.examMultipleList.length;
             this.examJudgeList.length=this.$store.state.exam.examJudgeList.length;
             this.examComputeList.length=this.$store.state.exam.examComputeList.length;

             for (var i = 0; i < this.$store.state.exam.examSingleList.length; i++) {
               this.$set(this.examSingleList,i,this.$store.state.exam.examSingleList[i])
             }

             for (var i = 0; i < this.$store.state.exam.examMultipleList.length; i++) {
               this.$set(this.examMultipleList,i,this.$store.state.exam.examMultipleList[i])
             }

             for (var i = 0; i < this.$store.state.exam.examJudgeList.length; i++) {
               this.$set(this.examJudgeList,i,this.$store.state.exam.examJudgeList[i])
             }

             for (var i = 0; i < this.$store.state.exam.examComputeList.length; i++) {
               this.$set(this.examComputeList,i,this.$store.state.exam.examComputeList[i])
             }
          }, 1000);

        },

        methods:{
          //时间参数
          countDown(){

            let THIS=this;
            THIS.time--;
            //THIS.minutes--;
          //  THIS.seconds--;

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
          }

        },
        //设定时间
        mounted(){
           let THIS=this;
           THIS.time=2;
           //THIS.minutes=(60+60)*120;
           //THIS.seconds=5;
           setInterval(THIS.countDown,1000);
          },
          //监听事件
          watch:{
            'time':function(newVal,oldVal){
          if(newVal==0){
            this.$router.push('');
          }
    }

            // 'minutes':function(newVal,oldVal){
            //   if(newVal>=0){
            //     this.minutes;
            //   }
            // },
              // 'seconds':function(newVal,oldVal){
              //   if(newVal==0){
              //      //alert("还剩5分钟");
              //      //alert("时间到，结束!");
              //      this.$router.push(''); //跳转到指定页面
              //    }
              // }
            }

        }

</script>
