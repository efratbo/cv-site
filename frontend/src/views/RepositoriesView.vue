<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { fetchMyRepos } from '../api/githubService.ts';
import type { RepositoryDto } from '../types/GithubTypes.ts';
import Repository from '@/components/RepositoryCard.vue';

const repositories = ref<RepositoryDto[]>([]);

onMounted(async () => {
  repositories.value = await fetchMyRepos();
});

function getColorClass(index: number) {
  const colors = [
    'border-red-500',
    'border-green-500',
    'border-blue-500',
    'border-yellow-500',
    'border-purple-500',
    'border-pink-500',
    'border-indigo-500',
    'border-gray-500',
    'border-orange-500',
    'border-teal-500',
    'border-cyan-500',
    'border-lime-500',
    'border-amber-500',
  ];
  return colors[index % colors.length];
}
</script>

<template>
  <div>
    <div class="flex flex-wrap gap-4 justify-between">
      <Repository
        v-for="(repo, index) in repositories"
        :key="repo.nodeId"
        :repository="repo"
        :class="['border-2', 'p-4', 'rounded-lg', getColorClass(index)]"
      />
    </div>
  </div>
</template>
