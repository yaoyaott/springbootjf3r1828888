<template>
  <div>
    <h1>用户模块分析</h1>
    <table>
      <thead>
      <tr>
        <th>用户角色</th>
        <th>用户数量</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(count, role) in userCountByRole" :key="role">
        <td>{{ role }}</td>
        <td>{{ count }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userCountByRole: {}
    };
  },
  created() {
    this.getUserCountByRole();
  },
  methods: {
    getUserCountByRole() {
      this.$http.get('userAnalysis/getUserCountByRole').then(res => {
        if (res.data.code === 0) {
          this.userCountByRole = res.data.data;
        }
      });
    }
  }
};
</script>

<style scoped>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
}
</style>