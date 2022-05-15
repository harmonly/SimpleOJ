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
            </div>
          </el-cl>
        </el-row>
      </el-header>
      <el-main style="padding: 0 0;">
        <div class="div_f"></div>
        <div class="div_sec">
          <el-tabs v-model="activeName"
                   class="sign"
                   style="height:1000px">
            <el-tab-pane label="后端"
                         name="first">
              <el-card class="box-card">
                <div slot="header"
                     class="clearfix">
                  <span style="padding-left:20px;font-weight: 700;">Java 16 新特性:record类</span>
                </div>
                <div>
                  <el-link :underline="false"
                           target="_blank"
                           href="https://juejin.cn/post/7096810735417688078">以前我们定义类都是用class关键词,但从Java 16开始......</el-link>
                </div>

              </el-card>
              <el-card class="box-card">
                <div slot="header"
                     class="clearfix">
                  <span style="padding-left:20px;font-weight: 700;">硬核,图解bufio包系列之读取原理</span>
                </div>
                <div>
                  <el-link :underline="false"
                           target="_blank"
                           href="https://juejin.cn/post/7096483642095960072">本系列计划用三篇文章来写:bufio包中的读取原理、bufio包中的写入以及...... </el-link>
                </div>

              </el-card>
              <el-card class="box-card">
                <div slot="header"
                     class="clearfix">
                  <span style="padding-left:20px;font-weight: 700;">Redis高并发缓存架构性能优化实战</span>
                </div>

                <div>
                  <el-link :underline="false"
                           target="_blank"
                           href="https://juejin.cn/post/7095768648551235598">线程A在master获取锁之后,master在同步数据到slave时......</el-link>
                </div>
              </el-card>

            </el-tab-pane>
            <el-tab-pane label="算法"
                         name="second">
              <el-card class="box-card">
                <div slot="header"
                     class="clearfix">
                  <span style="padding-left:20px;font-weight: 700;">【动态规划&数位 DP】数位 DP 的经典运用 </span>
                </div>

                <div>
                  <el-link :underline="false"
                           target="_blank"
                           href="https://juejin.cn/post/7096666256471752740">首先 [1, n][1,n] 共有 nn 个数，而求解 [1, n][1,n] 范围内有多少个......</el-link>
                </div>
              </el-card>
              <el-card class="box-card">
                <div slot="header"
                     class="clearfix">
                  <span style="padding-left:20px;font-weight: 700;">高级数据结构：并查集</span>
                </div>

                <div>
                  <el-link :underline="false"
                           target="_blank"
                           href="https://juejin.cn/post/7096668224833454111">孩子节点指向父亲节点的一种很不一样的树形结构，对于一组数据，主要支持两个动作：......</el-link>
                </div>
              </el-card>

            </el-tab-pane>
            <el-tab-pane label="项目案例"
                         name="third">
              <el-card class="box-card">
                <div slot="header"
                     class="clearfix">
                  <span style="padding-left:20px;font-weight: 700;">Pandas使用经典案例</span>
                </div>
                <div>
                  <el-link :underline="false"
                           target="_blank"
                           href="https://juejin.cn/post/7053071222061416456">本案例中用的数据是小编自行模拟的，主要包含两个数据：订单数据和水果信息数据，并且会将两份数据合并......</el-link>
                </div>
              </el-card>
              <el-card class="box-card">
                <div slot="header"
                     class="clearfix">
                  <span style="padding-left:20px;font-weight: 700;">lottie原理与案例</span>
                </div>

                <div>
                  <el-link :underline="false"
                           target="_blank"
                           href="https://juejin.cn/post/7095768648551235598">lottie 是Airbnb开源的动画库,UI通过AE设计出动画,使用Lottie提供的BodyMovin插件将设计好的动画导出......</el-link>
                </div>
              </el-card>
            </el-tab-pane>
            <el-tab-pane label="题解"
                         name="fourth">
              <el-tabs :tab-position="tabPosition"
                       style="height: fit-content;">
                <el-tab-pane label="1000"><textarea disabled
                            class="show-code">#include <bits/stdc++.h>

using namespace std;

int main() {
    int t, a, b; cin >> t;
    while (t--) {
        cin >> a >> b;
        cout << a + b << '\n';
    }
    return 0;
}</textarea></el-tab-pane>
                <el-tab-pane label="1001"><textarea disabled
                            class="show-code">#include <bits/stdc++.h>

using namespace std;

int main() {
	int w;
	cin >> w;
	if (w & 1 || w < 4) printf("NO\n");
	else printf("YES\n");
	return 0;
}</textarea></el-tab-pane>
                <el-tab-pane label="1002"><textarea disabled
                            class="show-code">#include <bits/stdc++.h>

using namespace std;

#define rep(i, a, n) for (int i = a; i < n; ++i)
#define all(a) (a).begin(), (a).end()
#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define SZ(a) ((int)(a).size())
typedef	vector<int> VI;
typedef long long ll;
typedef	pair<int, int> PII;
mt19937 mrand(random_device{}());
const ll mod = 1000000007;
int rnd(int a) { return mrand() % a; }
ll powmod(ll a, ll b) { ll ans = 1; a %= mod; assert(b >= 0); while (b != 0) { if (b & 1) ans = (ans * a) % mod; b >>= 1; a = (a * a) % mod;} return ans; }
ll gcd(ll a, ll b) { return b ? gcd(b, a % b) : a; }
// head

void solve() {
	int a, b, c, d; cin >> a >> b >> c >> d;
	if (a < c) {
		cout << "Takahashi\n";
	} else if (a > c) {
		cout << "Aoki\n";
	} else {
		if (b <= d) cout << "Takahashi\n";
		else cout << "Aoki\n";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int t; cin >> t;
	while (t--) solve();
	return 0;
}</textarea></el-tab-pane>
                <el-tab-pane label="1003"><textarea disabled
                            class="show-code">#include <bits/stdc++.h>

int main() {
	using namespace std;
	ios_base::sync_with_stdio(false), cin.tie(nullptr);

	int T; cin >> T;
	while (T--) {
		int N; cin >> N;
		std::vector<int> A(N);
		for (auto& a : A) { cin >> a; a--; }
		std::vector<int> B(N);
		for (auto& a : B) { cin >> a; a--; }

		std::vector<int> freq(N);
		for (auto a : A) freq[a]++;

		int root = int(std::max_element(freq.begin(), freq.end()) - freq.begin());
		std::vector<int> inDeg(N);
		std::vector<std::vector<int>> outEdges(N);
		for (int i = 0; i < N; i++) {
			if (A[i] == root || B[i] == root) continue;
			outEdges[A[i]].push_back(B[i]);
			inDeg[B[i]]++;
		}
		std::vector<int> q; q.reserve(N);
		for (int i = 0; i < N; i++) {
			if (inDeg[i] == 0) {
				q.push_back(i);
			}
		}
		for (int z = 0; z < int(q.size()); z++) {
			int cur = q[z];
			for (int nxt : outEdges[cur]) {
				if ((--inDeg[nxt]) == 0) {
					q.push_back(nxt);
				}
			}
		}
		cout << (int(q.size()) == N ? "AC" : "WA") << '\n';
	}

	return 0;
}</textarea></el-tab-pane>
                <el-tab-pane label="1004"></el-tab-pane>
                <el-tab-pane label="1005"></el-tab-pane>
                <el-tab-pane label="1006"></el-tab-pane>
                <el-tab-pane label="1007"></el-tab-pane>
                <el-tab-pane label="1008"></el-tab-pane>
                <el-tab-pane label="1009"></el-tab-pane>
                <el-tab-pane label="1010"></el-tab-pane>
              </el-tabs>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div class="div_th"></div>
      </el-main>

    </el-container>

  </div>

</template>
<style>
/* Header css */
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

.div_f,
.div_sec,
.div_th {
  float: left;
}
.div_sec {
  width: 1015px;
}
.div_f,
.div_th {
  width: 250px;
  height: 600px;
  background-color: #f7f8fa;
}

.box-card {
  float: left;
  width: 230px;
  margin: 10px 10px;
}

.show-code {
  width: 100%;
  min-height: 400px;
  resize: none;
}
</style>

<script>

// 其实要根据选择框的值来判断服务器返回的内容的话应该要在send()方法里加参数，那么就要用post方式，我这里只是先大概写一下，而且也有点不太熟，你来改一下
export default {
  data () {
    var checkNum = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('账号不能为空'));
      }
      setTimeout(() => {
        if (!Number.isInteger(value)) {
          callback(new Error('请输入数字值'));
        } else {
          var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
          if (!myreg.test(value)) {
            callback(new Error('请输入正确的手机号码'));
          } else {
            callback();
          }

        }
      }, 1000);
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {

        callback();
      }
    };
    return {
      loginPower: false,

      ruleForm2: {
        pass: '',
        num: '',
        delivery: false,
      },
      rules2: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],

        num: [
          { validator: checkNum, trigger: 'blur' }
        ]
      },

      dialogTableVisible: false,
      dialogFormVisible: false,
      dialogRegVisible: false,
      form: {
        name: '',
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px',
      activeName: 'first',    //标签页
      tabPosition: 'left'
    };
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {

          dialogFormVisible = false;
          this.$message({
            type: 'success',
            message: '提交成功'
          });
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
    },
  }
};
</script>