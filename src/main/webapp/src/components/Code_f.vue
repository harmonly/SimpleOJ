<template>
  <div class="div_Code">
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
            </div>
          </el-cl>
        </el-row>
      </el-header>
      <el-main id="el-main">
        <div class="div_left">
          <el-card class="box-card">
            <div slot="header"
                 class="clearfix">
              <span id="name">xxx</span>
            </div>
            <div id="desc"
                 class="text item"></div>
            <div id="explain"
                 class="text item"></div>
            <div id="input"
                 class="text item"></div>
            <div id="output"
                 class="text item"></div>
          </el-card>
          <el-card v-if="showJudge"
                   class="box-card">
            <div slot="header"
                 class="clearfix">
              <span id="data"
                    style="font-weight:700">编译结果:</span>
            </div>
            <div id="accepted"
                 class="text item info"></div>
            <div id="compileResult"
                 class="text item info"></div>
            <div id="count"
                 class="text item info"></div>
            <div id="doneCount"
                 class="text item info"></div>

            <div id="memory"
                 class="text item info"></div>

            <div id="reason"
                 class="text item info"></div>

            <div id="stdout"
                 class="text item info"></div>

            <div id="time"
                 class="text item info"></div>
          </el-card>
        </div>
        <div class="div_right">
          <div class="ace-container">
            <div class="ace-editor"
                 ref="ace"></div>
            <div class="config-panel"
                 v-show="toggle">
              <div>
                <div class="item">
                  <label class="title">语言</label>
                  <el-select class="value"
                             v-model="modePath"
                             @change="handleModelPathChange"
                             size="mini"
                             value-key="name">
                    <el-option v-for="mode in modeArray"
                               :key="mode.name"
                               :label="mode.name"
                               :value="mode.path">
                    </el-option>
                  </el-select>
                </div>

                <div class="item">
                  <label class="title">换行</label>
                  <el-select class="value"
                             v-model="wrap"
                             @change="handleWrapChange"
                             size="mini"
                             value-key="name">
                    <el-option v-for="wrap in wrapArray"
                               :key="wrap.name"
                               :label="wrap.name"
                               :value="wrap.value">
                    </el-option>
                  </el-select>
                </div>
              </div>
            </div>
            <div class="submitButt">
              <el-button @click="OnClick"
                         type="primary"
                         class="submitCode"
                         v-loading="loading"
                         :disabled="disSubmit">Submit</el-button>
            </div>
            <div class="bookmarklet"
                 @click="toggleConfigPanel"></div>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import ace from 'ace-builds'
import 'ace-builds/src-noconflict/snippets/java'
import 'ace-builds/src-noconflict/snippets/python'
import 'ace-builds/src-noconflict/snippets/c_cpp'
import 'ace-builds/src-noconflict/snippets/csharp'
import 'ace-builds/src-noconflict/snippets/kotlin'
import 'ace-builds/webpack-resolver'  /*在 webpack 环境中使用必须要导入*/
import 'ace-builds/src-noconflict/ext-language_tools'
import 'ace-builds/src-noconflict/theme-monokai' /*默认设置的主题 */
import 'ace-builds/src-noconflict/mode-javascript'

// const themeArray = [{
//   name: 'monokai',
//   path: 'ace/theme/monokai'
// }]

const wrapArray = [{
  name: '开启',
  value: true
}, {
  name: '关闭',
  value: false
}]

const modeArray = [{
  name: 'Java',
  path: 'ace/mode/java'
}, {
  name: 'python',
  path: 'ace/mode/python'
}, {
  name: 'C/C++',
  path: 'ace/mode/c_cpp'
}, {
  name: 'C#',
  path: 'ace/mode/csharp'
}, {
  name: 'kotlin',
  path: 'ace/mode/kotlin'
}]

export default {
  props: {
    value: String
  },
  data () {
    this.code_type = 'cpp'
    this.problem_id = 1000
    return {
      aceEditor: null,
      toggle: false,
      wrap: true,
      themePath: 'ace/theme/twilight',
      modePath: 'ace/mode/java',
      modeArray: modeArray,
      wrapArray: wrapArray,

      loginPower: false,
      dialogTableVisible: false,
      form: {
        name: '',
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px',
      showJudge: false,
      loading: false,
      disSubmit: false
    }
  },
  mounted () {
    this.aceEditor = ace.edit(this.$refs.ace, {
      maxLines: 40,   /*最大行数，超过会自动出现滚动条 */
      minLines: 35,   /*最小行数，还未到最大行数时，编辑器会自动伸缩大小 */
      fontSize: 14,
      value: this.value ? this.value : '',
      theme: this.themePath,  /*默认设置的主题*/
      mode: this.modePath,    /*默认设置的语言模式 */
      wrap: this.wrap,
      tabSize: 4
    })
    // 激活自动提示
    this.aceEditor.setOptions({   /*自动提示 */
      enableSnippets: true,
      enableLiveAutocompletion: true,
      enableBasicAutocompletion: true
    })
    this.aceEditor.getSession().on('change', this.change)   /*实时获取值，绑定事件*/
    this.aceEditor.getSession().setValue("")                /*初始化编辑器数据 */
    var problem = this.$route.query.problem
    this.problem_id = problem.id
    document.getElementById('name').innerHTML = problem.name
    document.getElementById('desc').innerHTML = problem.desc
    document.getElementById('explain').innerHTML = problem.explain
    document.getElementById('input').innerHTML = '样例输入:<br>' + problem.input
    document.getElementById('output').innerHTML = '样例输出:<br>' + problem.output
  },
  methods: {
    toggleConfigPanel () {          /*打开/关闭 */
      this.toggle = !this.toggle
    },
    change () {
      this.$emit('input', this.aceEditor.getSession().getValue())
      this.code_content = this.aceEditor.getSession().getValue("");
    },
    handleModelPathChange (modelPath) {   /*实现属性修改 change事件 */
      this.aceEditor.getSession().setMode(modelPath)
      var type = modelPath;
      type = type.substring(type.lastIndexOf('/') + 1);
      this.code_type = type;
    },
    handleWrapChange (wrap) {
      this.aceEditor.getSession().setUseWrapMode(wrap)
    },
    OnClick () {
      this.loading = true;
      this.disSubmit = true;
      //判断username是否存在，否则跳转至登录页面进行登录
      if (sessionStorage.getItem("username") == null) {
        this.$router.push('/src/components/Main.vue');
        this.$message.error('请先登录在提交');
        return;
      }
      this.axios({     // axios 向后端发起请求
        url: "http://192.168.1.102:8080/soj/api/judge",  // 请求地址
        method: "post",             // 请求方法
        headers: {                  // 请求头
          "Content-Type": "application/json",
        },
        data: { // 请求参数，为 data，与登录的 params 不太一样
          username: sessionStorage.getItem("username"),
          problem_id: this.problem_id,
          code_content: this.code_content,
          code_type: this.code_type,
        },
      }).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
        var judgeRes = res.data.data;
        if (res.data.code == 200) {  // 当响应的编码为 200 时，说明数据传输成功
          //展示判断结果
          this.showJudge = true
          setTimeout(() => {
            document.getElementById('accepted').innerHTML = ''
            document.getElementById('compileResult').innerHTML = ''
            document.getElementById('count').innerHTML = ''
            document.getElementById('doneCount').innerHTML = ''
            document.getElementById('memory').innerHTML = ''
            document.getElementById('reason').innerHTML = ''
            document.getElementById('stdout').innerHTML = ''
            document.getElementById('time').innerHTML = ''

            document.getElementById('accepted').innerHTML = '执行结果:' + judgeRes.accepted
            if (judgeRes.compileResult != undefined)
              document.getElementById('compileResult').innerHTML = '编译信息:<br>' + judgeRes.compileResult
            document.getElementById('count').innerHTML = '测试用例数量:<br>' + judgeRes.count
            document.getElementById('doneCount').innerHTML = '通过测试用例数量:<br>' + judgeRes.doneCount
            document.getElementById('memory').innerHTML = '运行内存:<br>' + judgeRes.memory + 'KB'
            if (judgeRes.reason != undefined)
              document.getElementById('reason').innerHTML = '错误原因:<br>' + judgeRes.reason
            if (judgeRes.stdout != undefined)
              document.getElementById('stdout').innerHTML = '标准输出:<br>' + judgeRes.stdout
            document.getElementById('time').innerHTML = '运行时间:<br>' + judgeRes.time + 'ms'
          }, 500);
          // 显示后端响应的成功信息
          this.$message({
            message: '提交成功',
            type: "success",
          });
        } else {  // 当响应的编码不为 0 时，说明数据传输失败
          // 显示后端响应的失败信息
          this.$message({
            message: res.data.msg,
            type: "warning",
          });
        }
        this.loading = false
        this.disSubmit = false
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
    },
  }
}
</script>

<style lang='scss' scoped>
body {
  background-color: #f7f8fa;
}

.el-main {
  padding-bottom: 0px;
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

.proDes {
  width: 700px;
  height: 100px;
}
.proEx {
  width: 700px;
  height: 50px;
}
.proInput {
  width: 700px;
  height: 50px;
}
.proOutput {
  width: 700px;
  height: 50px;
}
.div_left {
  width: 700px;
  height: 550px;
  margin-right: 20px;
  float: left;
}

.div_right {
  width: 720px;
  height: 550px;
  float: left;
  float: right;
}

//CodeEditor
.ace-container {
  position: relative;
  width: 100%;
  float: right;
}

.config-panel {
  position: absolute;
  right: 0;
  bottom: 0;
  width: 100%;
  height: 120px;
  overflow: scroll;
  box-shadow: grey -5px 2px 3px;
  background-color: rgba(255, 255, 255, 0.5);
  z-index: 1;

  .item {
    margin: 10px auto;
    text-align: center;

    .title {
      color: white;
      margin: 0 10px;
      font-size: 14px;
    }
  }
}

.info {
  margin-top: 10px;
}

.bookmarklet {
  position: absolute;
  right: 0;
  bottom: 0;
  width: 20px;
  height: 20px;
  z-index: 2;
  cursor: pointer;
  border-width: 9px;
  border-style: solid;
  border-color: lightblue gray gray rgb(206, 173, 230);
  border-image: initial;
}

.submitButt {
  width: 600px;
  height: 40px;
  margin-top: 10px;
  background-color: #ffffff;
  border-radius: 30px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
}
</style>
