<template>
  <my-el-top-bottom
    title="班级列表"
    placeholder="根据班级名称查找"
    isSearch
    requestUrl="/class/list"
    @update="updateTableData"
  >
    <template #main>
      <el-table
        width="100%"
        :height="useMainHeight().mainHeight"
        :data="formData"
        stripe
      >
        <el-table-column align="center" prop="id" label="序号" />
        <el-table-column align="center" prop="grade" label="年级" />
        <el-table-column align="center" prop="discipline" label="专业名称" />
        <el-table-column align="center" prop="name" label="班级名称" />
        <el-table-column align="center" prop="studentNum" label="班级人数" />
        <el-table-column align="center" label="操作">
          <template #default="scope">
            <el-button type="primary" text @click="selectStudent(scope.row)">
              查看
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
  </my-el-top-bottom>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import myRequest from "@/utils/request.ts";
import { useMainHeight } from "@/store/modules/mainHeight.ts";
import MyElTopBottom from "@/views/admin/components/MyElTopBottom.vue";
import useUserStore from "@/store/modules/user.ts";
import { ApiResult } from "@/utils/type";

const userStore = useUserStore();
interface class_ {
  id: number;
  grade: string;
  discipline: string;
  name: string;
  studentNum: string;
}
const formData = ref([] as class_[]);
const updateTableData = (res) => {
  formData.value = res;
};
const getList = async () => {
  const res = await myRequest.get<any, ApiResult>(
    `/class/list/${userStore.uId}`
  );
  formData.value = res.data as class_[];
};
const selectStudent = async (id: number) => {};
onMounted(() => {
  getList();
});
</script>

<style scoped></style>
