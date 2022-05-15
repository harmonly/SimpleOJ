import { formName } from 'element-ui';
<template>
  <div class="div_main">
    <el-container>
      <el-header>
        <el-row>
          <el-cl :span="24">
            <div class="grid-content bg-purple-dark">
              <ul class="l_f">
                <li id="icon_id"><img src="../img/soj_icon1.png"
                       width="45px"></li>
                <li>
                  <el-link :underline="false"
                           href="../components/Main.vue"><i class="el-icon-s-home"></i></el-link>
                </li>
                <li>
                  <el-link :underline="false"
                           href="../components/study.vue">学习</el-link>
                </li>
                <li>
                  <el-link :underline="false"
                           href="../components/exercise.vue">题库</el-link>
                </li>
              </ul>
              <ul class="l_s">
                <li>
                  <div>
                    <el-button v-if="showOut"
                               @click="loginOut()">登出</el-button>
                  </div>
                </li>
              </ul>
              <ul v-if="!showName"
                  class="l_s">
                <li>
                  <div>
                    <el-button round
                               @click="dialogRegVisible = true">注册</el-button>
                    <el-dialog title="注册"
                               :visible.sync="dialogRegVisible"
                               center
                               width="500px">
                      <el-form :model="ruleForm"
                               status-icon
                               :rules="rules"
                               ref="ruleForm"
                               label-position="left"
                               label-width="80px"
                               class="demo-ruleForm">
                        <el-form-item label="用户名"
                                      prop="username">
                          <el-input v-model="ruleForm.username"></el-input>
                        </el-form-item>
                        <el-form-item label="密码"
                                      prop="pass">
                          <el-input type="password"
                                    v-model="ruleForm.pass"
                                    autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="确认密码"
                                      prop="password">
                          <el-input type="password"
                                    v-model="ruleForm.password"
                                    autocomplete="off"></el-input>
                        </el-form-item>
                      </el-form>
                      <div class="btnGroup">
                        <el-button type="primary"
                                   @click="submitForm('ruleForm')"
                                   v-loading="loading">提交</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                      </div>
                    </el-dialog>
                  </div>
                </li>

                <li>
                  <div>
                    <el-button round
                               @click="dialogFormVisible = true">登录</el-button>
                    <el-dialog title="登录"
                               :visible.sync="dialogFormVisible"
                               width="500px"
                               center>
                      <!-- <h2>登录</h2> -->
                      <el-form :model="ruleForm2"
                               status-icon
                               :rules="rules2"
                               ref="ruleForm2"
                               label-position="left"
                               label-width="70px"
                               class="login-from">
                        <el-form-item label="用户名"
                                      prop="username">
                          <el-input v-model="ruleForm2.username"></el-input>
                        </el-form-item>
                        <el-form-item label="密码"
                                      prop="password">
                          <el-input type="password"
                                    v-model="ruleForm2.password"
                                    autocomplete="off"></el-input>
                        </el-form-item>
                      </el-form>
                      <div class="btnGroup">
                        <el-button type="primary"
                                   @click="submitForm2('ruleForm2')"
                                   v-loading="loading">登录</el-button>
                        <el-button @click="resetForm('ruleForm2')">重置</el-button>
                      </div>
                    </el-dialog>
                  </div>
                </li>
              </ul>
              <span>{{userInfo.NAME}}</span>
            </div>
          </el-cl>
        </el-row>
      </el-header>
      <el-main>
        <div class="div_f">
          <div class="div_ff_f">
            <div>
              <h3>Science</h3>
            </div>
            <el-carousel :interval="4000"
                         height="320px"
                         ref="carousel"
                         @click.native="linkTo">
              <el-carousel-item v-for="item in imgs"
                                :key="item.url">
                <img :src="item.url" />
              </el-carousel-item>
            </el-carousel>

          </div>

          <div class="div_ff_s">
            <h4>Blue Brige Cup</h4>
            <div class="div_blue">
              <el-link :underline="false"
                       href="https://dasai.lanqiao.cn/pages/dasai/competition/individual_competition.html"
                       target="_blink"><img src="../img/b1.png"
                     width="120px"></el-link>
            </div>
            <div class="div_blue">
              <el-link :underline="false"
                       href="https://dasai.lanqiao.cn/pages/dasai/competition/visual_art_competition.html"
                       target="_blink"><img src="../img/b2.png"
                     width="120px"></el-link>
            </div>
            <div class="div_blue">
              <el-link :underline="false"
                       href="https://dasai.lanqiao.cn/pages/dasai/competition/innovation_competition.html"
                       target="_blink"><img src="../img/b3.png"
                     width="120px"></el-link>
            </div>
            <div class="div_blue">
              <el-link :underline="false"
                       href="https://kid.lanqiao.cn/"><img src="../img/b4.png"
                     width="120px"></el-link>
            </div>
            <div class="div_blue"
                 style="margin-top:40px;">
              <el-link :underline="false"
                       href="https://dasai.lanqiao.cn/pages/dasai/news_detail.html?id=1249"
                       target="_blink"><img src="../img/b5.png"
                     width="290px"></el-link>
            </div>
          </div>

          <div class="div_fs">

            <div class="div_table">
              <table class="tab">
                <thead>
                  <tr>
                    <td colspan="2"
                        style="text-align:center; font-weight:bolder;font-size:20px;text-align:center;height:100px;text-line:100px;">HOT TOPIC TOP</td>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td width="50">
                      <el-link>动态规划</el-link>
                    </td>
                    <td width="150">
                      <el-progress :text-inside="true"
                                   :stroke-width="24"
                                   :percentage="70"></el-progress>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <el-link>图论</el-link>
                    </td>
                    <td>
                      <el-progress :text-inside="true"
                                   :stroke-width="24"
                                   :percentage="100"
                                   status="success"></el-progress>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <el-link>二叉树</el-link>
                    </td>
                    <td>
                      <el-progress :text-inside="true"
                                   :stroke-width="24"
                                   :percentage="80"
                                   status="warning"></el-progress>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <el-link>二叉树</el-link>
                    </td>
                    <td>
                      <el-progress :text-inside="true"
                                   :stroke-width="24"
                                   :percentage="50"
                                   status="exception"></el-progress>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="div_circle">
              <div class="div_circle_table">
                <table>
                  <tr>
                    <td style="width:180px;text-align:center;">
                      <el-progress type="circle"
                                   :percentage="25"></el-progress>
                    </td>
                    <td style="width:180px;text-align:center;">
                      <el-progress type="circle"
                                   :percentage="75"></el-progress>
                    </td>
                    <td style="width:180px;text-align:center;">
                      <el-progress type="circle"
                                   :percentage="35"></el-progress>
                    </td>
                  </tr>
                  <tr>
                    <td style="width:180px;text-align:center;">任务指数</td>
                    <td style="text-align:center;width:180px;">正确率</td>
                    <td style="text-align:center;width:180px;">排行比例</td>
                  </tr>

                </table>
              </div>
            </div>

          </div>
        </div>
        <div class="div_s">
          <div class="div_sff">
            <el-carousel height="180px">
              <el-carousel-item v-for="item in 3"
                                :key="item"
                                id="slide_show_s">
              </el-carousel-item>
            </el-carousel>
          </div>

          <div class="div_sfs">
            <video src="../img/HelloAi.mp4"
                   id="videoI"
                   autoplay="autoplay"
                   v-if="play"
                   preload="auto"
                   loop="true"
                   style="height:180px;width:240px"></video>
          </div>

          <div class="div_sft">
            <div class="div_topic"
                 style="text-align:center;padding-top: 10px;">
              每日焦点
            </div>

            <div class="topic_f"
                 style="margin:10px 0 0 5px;padding-left: 50px;">
              <span class="topic_id">1.</span>
              <i class="el-icon-s-comment"></i>
              <el-link :underline="false"
                       style="width:80px;height:20px;padding-bottom: 5px;">动态规划</el-link>
            </div>

            <div class="topic_s"
                 style="margin:10px 0 0 5px;padding-left: 50px;">
              <span class="topic_id">2.</span>
              <i class="el-icon-s-comment"></i>
              <el-link :underline="false"
                       style="width:80px;height:20px;padding-bottom: 5px;">哈希表</el-link>
            </div>

            <div class="topic_th"
                 style="margin:10px 0 0 5px;padding-left: 50px;">
              <span class="topic_id">3.</span>
              <i class="el-icon-s-comment"></i>
              <el-link :underline="false"
                       style="width:80px;height:20px;padding-bottom: 5px;">深度搜索</el-link>
            </div>

            <div class="topic_fiv"
                 style="margin:10px 0 0 5px;padding-left: 50px;">
              <span class="topic_id">4.</span>
              <i class="el-icon-s-comment"></i>
              <el-link :underline="false"
                       style="width:80px;height:20px;padding-bottom: 5px;">链栈</el-link>
            </div>

            <div class="topic_six"
                 style="margin:10px 0 0 5px;padding-left: 50px;">
              <span class="topic_id">5.</span>
              <i class="el-icon-s-comment"></i>
              <el-link :underline="false"
                       style="width:80px;height:20px;padding-bottom: 5px;">图</el-link>
            </div>
          </div>

        </div>
      </el-main>
      <el-footer>
        <div style="margin:0 100px">
          <div class="butt_div">
            <ul id="product_intro">
              <li>产品介绍</li>
              <li>
                <el-link :underline="false"
                         class="tooltip">技术支持
                  <span class="tooltiptext">vue element</span>
                </el-link>
              </li>
              <li>
                <el-link :underline="false"
                         class="tooltip">原生开发
                  <span class="tooltiptext">vue element</span>
                </el-link>
              </li>
              <li>
                <el-link :underline="false"
                         class="tooltip">题库特点
                  <span class="tooltiptext">简单</span>
                </el-link>
              </li>
            </ul>
          </div>
          <div class="butt_div">
            <ul id="help">
              <li>帮助</li>
              <li>
                <el-link :underline="false"
                         class="tooltip">人工服务
                  <span class="tooltiptext">vue element</span>
                </el-link>
              </li>
              <li>
                <el-link :underline="false"
                         class="tooltip">电话联系
                  <span class="tooltiptext">13698101874</span>
                </el-link>
              </li>
              <li>
                <el-link :underline="false"
                         class="tooltip">问题咨询
                  <span class="tooltiptext">vue element</span>
                </el-link>
              </li>
            </ul>
          </div>
          <div class="butt_div">
            <ul id="about_us">
              <li>关于我们</li>
              <li>
                <el-link :underline="false"
                         class="tooltip">开发人员介绍
                  <span class="tooltiptext">文程民 王政 刘誉懋</span>
                </el-link>
              </li>
              <li>
                <el-link :underline="false"
                         class="tooltip">工作组地址
                  <span class="tooltiptext">电子科技大学成都学院</span>
                </el-link>
              </li>
            </ul>
          </div>
        </div>
      </el-footer>
    </el-container>

    <el-backtop></el-backtop>
  </div>

</template>

<script>
export default {
  data () {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };

    return {
      ruleForm2: {
        username: "",
        password: "",
      },
      ruleForm: {
        username: "",
        pass: "",
        password: "",
      },
      rules2: {
        username: [
          { required: true, message: "用户名不能为空！", trigger: "blur" },
        ],
        password: [
          { required: true, message: "密码不能为空！", trigger: "blur" },
        ],
      },
      rules: {
        username: [
          { required: true, message: "用户名不能为空！", trigger: "blur" },
        ],
        pass: [{ required: true, validator: validatePass, trigger: "blur" }],
        password: [
          { required: true, validator: validatePass2, trigger: "blur" },
        ],
      },
      loading: false,
      dialogFormVisible: false,
      dialogRegVisible: false,
      userInfo: {},
      showName: false,
      showOut: false,
      play: true,
      autoplay: true,

      //轮播图
      imgs: [
        { url: require('../img/journal_f.png'), link: 'https://juejin.cn/post/7004491721073508360' },
        { url: require('../img/journal_s.png'), link: 'https://juejin.cn/post/7073244330537779207' },
        { url: require('../img/journal_four.png'), link: 'https://juejin.cn/post/6876105622274703368' }
      ]
    };
    
  },
  mounted () {     
    if (sessionStorage.getItem('username') != null) {
      this.showName = true
      this.showOut = true
    }
  },
  methods: {
    submitForm2 (formName) {
      // 验证表单中的账号密码是否有效，因为在上面rules中定义为了必填 required: true
      this.$refs[formName].validate((valid) => {
        // 点击登录后，让登录按钮开始转圈圈（展示加载动画）
        this.loading = true;
        // 如果经过校验，账号密码都不为空，则发送请求到后端登录接口
        if (valid) {
          let _this = this;
          // 使用 axios 将登录信息发送到后端
          this.axios({
            url: "http://192.168.1.102:8080/soj/api/login",               // 请求地址/api/user/login
            method: "post",                       // 请求方法
            headers: {                            // 请求头
              "Content-Type": "application/json",
            },
            params: {                             // 请求参数
              username: _this.ruleForm2.username,
              password: _this.ruleForm2.password,
            },
          }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
            if (res.data.data === "login-success") {  // 当响应的data为 login-success 时，说明登录成功
              // 将用户信息存储到sessionStorage中
              sessionStorage.setItem("username", _this.ruleForm2.username);
              //隐藏登录注册按钮
              this.showName = true;
              this.showOut = true;
              // 显示后端响应的成功信息
              this.$message({
                message: '登录成功',
                type: "success",
              });
            } else {  // 当响应的编码不为 login-success 时，说明登录失败
              // 显示后端响应的失败信息
              this.$message.error('登录失败')
            }
            // 不管响应成功还是失败，收到后端响应的消息后就不再让登录按钮显示加载动画了
            this.loading = false;
          });
        } else {  // 如果账号或密码有一个没填，就直接提示必填，不向后端请求
          this.loading = false;
          return false;
        }
      });
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        this.loading = true;  // 提交按钮显示加载动画
        if (valid) {
          let _this = this;
          this.axios({     // axios 向后端发起请求
            url: "http://192.168.1.102:8080/soj/api/register",  // 请求地址
            method: "post",             // 请求方法
            headers: {                  // 请求头
              "Content-Type": "application/json",
            },
            params: { // 请求参数，为 data，与登录的 params 不太一样
              username: _this.ruleForm.username,
              password: _this.ruleForm.password,
            },
          }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
            if (res.data.data == 'register-success') {  // 当响应的编码为 register-success 时，说明注册成功
              // 显示后端响应的成功信息
              this.$message({
                message: '注册成功',
                type: "success",
              });
              this.dialogRegVisible = false
            } else {  // 当响应的编码不为 register-success 时，说明注册失败
              // 显示后端响应的失败信息
              this.$message.error('注册失败')
            }
            // 不管响应成功还是失败，收到后端响应的消息后就不再让登录按钮显示加载动画了
            this.loading = false;
          });
        } else { // 如果账号或密码有一个没填，就直接提示必填，不向后端请求
          this.loading = false;
          return false;
        }
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
    },

    //登出
    loginOut () {
      window.sessionStorage.clear();
      location.reload()

    },

    //轮播图
    linkTo () {
      let activeIndex = this.$refs.carousel.activeIndex
      window.open(this.imgs[activeIndex].link, "_blank")
    },
    
  }
};
</script>

<style>
body {
  background-color: #f7f8fa;
}
/* 登录面板表单居中 */
.login-from {
  margin: auto auto;
}
.butt_div ul li:first-child {
  font-size: 23px;
  color: #ffffff;
  margin-bottom: 20px;
}

.butt_div ul li {
  margin: 5px;
  color: rgb(161, 161, 161);
}

.butt_div {
  float: left;
  width: 180px;
  height: 150px;
  margin: 20px;
  background-color: #000000;
}

.el-row {
  margin-bottom: 20px;
  /* &:last-child {
    margin-bottom: 0;
  } */
}
.el-footer {
  min-height: 200px;
  background: #000000;
}

.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #ffffff;
}
.grid-content {
  border-radius: 4px;
  min-height: 42px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.div_f {
  width: 1200px;
  min-height: 500px;
  background-color: #f9fafc;
  float: left;
  margin: 3px;
}

.div_s {
  width: 250px;
  min-height: 500px;
  background-color: #f9fafc;
  float: left;
  margin: 3px;
}

.div_ff_f {
  width: 575px;
  height: 412px;
  background-color: #ffffff;
  float: left;
  margin: 5px;
  text-indent: 0.7cm;
  text-align: center;
}

.div_ff_s {
  width: 565px;
  height: 380px;
  background-color: #ffffff;
  float: left;
  margin: 5px;
  padding: 16px;
  text-indent: 0.7cm;
  text-align: center;
}

.div_ff_f,
.div_ff_s,
.div_fs,
.div_sf {
  border-radius: 30px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.div_blue {
  float: left;
}

.div_fs {
  width: 1190px;
  min-height: 300px;
  float: left;
  background-color: #ffffff;
}

.tab {
  width: 500px;
  height: 180px;
  margin: 20px;
  background-color: #ffffff;
}

.div_table,
.div_circle {
  float: left;
}

.div_table {
  margin-top: -20 px;
}

.div_circle {
  margin-top: 30px;
  width: 550px;
  height: 180px;
  float: right;
}

.div_circle_table {
  margin: 30px;
}

.div_sff {
  width: 240px;
  min-height: 180px;
  background-color: #f9fafc;
  margin: 5px;
}

.div_sfs {
  width: 240px;
  min-height: 180px;
  /* background-image: url('../img/ad1.png'); */
  background-color: #f9fafc;
  margin: 5px;
  margin-top: 15px;
  border-radius: 10px;
}

.div_sft {
  width: 240px;
  min-height: 180px;
  background-color: #ffffff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  margin: 5px;
  margin-top: 15px;
}

.div_topic_f {
  color: #5c5c5c;
  opacity: 0.7;
  text-indent: 20px;
  margin-top: 15px;
  width: 100px;
  height: 40px;
  line-height: 40px;
}

.div_topic_s,
.div_topic_t {
  float: left;
}

.div_topic_s {
  width: 10px;
  height: 45px;
  margin-left: 20px;
  margin-top: 20px;
  line-height: 45px;
}

.div_topic_t {
  width: 180px;
  height: 45px;
  margin-left: 7px;
  margin-top: 20px;
  line-height: 45px;
}

#slide_show_s:nth-child(3) {
  background-image: url('../img/light1.png');
  border-radius: 10px;
}
#slide_show_s:nth-child(4) {
  background-image: url('../assets/1.png');
  border-radius: 10px;
}
#slide_show_s:nth-child(5) {
  background-image: url('../img/light1.png');
  border-radius: 10px;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}
.l_f li {
  float: left;
  height: 4px;
  width: 50px;
  line-height: 42px;
  text-align: center;
}

.l_s li {
  height: 4px;
  width: 90px;
  line-height: 42px;
  text-align: center;
  float: right;
}
#icon_id {
  width: 90px;
}

/* 淡入淡出效果 */
.tooltip {
  position: relative;
  display: inline-block;
  border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 200px;
  background-color: white;
  color: black;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;
  position: absolute;
  z-index: 1;
  bottom: 100%;
  left: 50%;
  margin-left: -60px;
  /* 淡入 - 1秒内从 0% 到 100% 显示: */
  opacity: 0;
  transition: opacity 1s;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
  opacity: 1;
}
</style>