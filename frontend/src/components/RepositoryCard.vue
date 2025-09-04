<script setup lang="ts">
import { useRouter } from 'vue-router'
import type { RepositoryDto } from '../types/GithubTypes.ts'

const props = defineProps<{
  repository: RepositoryDto
}>()

const router = useRouter();

const addStar = () => {
  // Logic to add a star to the repository
  console.log(`Star added to ${props.repository.name}`)
}

const navigateToRepo = () => {
  router.push({ 
    path: `/repositories/${props.repository.nodeId}`,
  });
}
</script>

<template>
  <div class="repository-card border border-gray-300 border-1 rounded-lg p-4 shadow-md mb-4 max-w-xs flex flex-col justify-between">
    <h1 @click="navigateToRepo" class="text-xl font-bold cursor-pointer">{{ repository.name }}</h1>
    <p v-if="repository.language" class="my-2"><span class="bg-transparent border border-gray-300 px-2 py-1 rounded">{{ repository.language }}</span></p>
    <p>📆 {{ repository.updatedAt }}</p>
    <p>⭐ X {{ repository.stars }}</p>
  </div>
</template>

