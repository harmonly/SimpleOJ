<template>
  <div id="app">
    <router-view />
    <Main></Main>
    <study></study>
    <exercise></exercise>
    <Code_f></Code_f>
   </div>
</template>

<script>
import "../src/components/Main.vue"
import "./components/study.vue"
import "./components/exercise.vue"
import "./components/Code_f.vue"
export default {
  name: 'App',
  components: {
 
  }
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: normal;
  color: #2c3e50;
  margin-top: 10px;
}
</style>
