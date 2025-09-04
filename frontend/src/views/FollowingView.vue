<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { fetchFollowingUsers } from '../api/githubService.ts'
import type { UserDto } from '../types/GithubTypes.ts'
import User from '../components/User.vue'

const following = ref<UserDto[]>([])

onMounted(async () => {
  following.value = await fetchFollowingUsers()
})
</script>

<template>
  <div>
    <div class="flex flex-wrap gap-4 justify-evenly">
      <User v-for="user in following" :key="user.nodeId" :user="user" />
    </div>
  </div>
</template>
