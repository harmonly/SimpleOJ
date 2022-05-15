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
      <el-main>
        <div class="div_f"></div>
        <div class="div_s">
          <el-table :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)">
            <el-table-column prop="id"
                             label="问题号">
            </el-table-column>
            <el-table-column label="名字">
              <template slot-scope="scope">
                <router-link :to="{name:'Code_f',query:{problem:scope.row}}"
                             v-text="scope.row.name">
                </router-link>
              </template>
            </el-table-column>
            <el-table-column prop="difficulty"
                             label="难度">
              <template slot-scope="scope">
                <p class="easy"
                   v-if="scope.row.difficulty==1">简单</p>
                <p class="medium"
                   v-if="scope.row.difficulty==2">中等</p>
                <p class="hard"
                   v-if="scope.row.difficulty==3">困难</p>
              </template>
            </el-table-column>
          </el-table>

          <!-- 分页器 -->
          <div class="block">
            <el-pagination align='center'
                           @size-change="handleSizeChange"
                           @current-change="handleCurrentChange"
                           :current-page="currentPage"
                           :page-sizes="[5,10,20,40]"
                           :page-size="pageSize"
                           layout="total, sizes, prev, pager, next, jumper"
                           :total="tableData.length">
            </el-pagination>
          </div>
        </div>

        <div class="div_th">
          <div class="div_th_f">

          </div>

          <div class="div_th_s">

          </div>
        </div>

      </el-main>
    </el-container>
  </div>
</template>

<style>
body {
  background-color: #f7f8fa;
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

.div_f {
  float: left;
  width: 270px;
  height: 600px;
}
.div_s {
  float: left;
  width: 920px;
  height: 600px;
}

.div_th {
  float: left;
  width: 270px;
  height: 600px;
  /* background-color: gray; */
}

.block {
  width: 920px;
  text-align: center;
  position: fixed;
  bottom: 41px;
}

.easy {
  font-weight: bold;
  color: green;
}

.medium {
  font-weight: bold;
  color: orange;
}

.hard {
  font-weight: bold;
  color: red;
}

a {
  color: black;
  text-decoration: none;
}

.router-link-active {
  text-decoration: none;
}
</style>

<script type="text/javascript">
// import { Link } from "element-ui";
export default {
  el: '#app',//
  data () {
    return {
      tableData: [],
      currentPage: 1, // 当前页码
      total: 20, // 总条数
      pageSize: 5, // 每页的数据条数
      
    };
  },
  created: function() {
    this.loadProblem();
  },
  methods: {
    //分页
    //每页条数改变时触发 选择一页显示多少行
    handleSizeChange (val) {
      this.currentPage = 1;
      this.pageSize = val;
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange (val) {
      this.currentPage = val;
    },
    loadProblem () {
      this.axios.post("http://192.168.1.102:8080/soj/api/all-problem").then(res => {
        this.tableData = res.data.data
      });
    },
  }
};
</script>
