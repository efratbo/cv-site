<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { fetchMyRepos } from '../api/githubService.ts'
import type { RepositoryDto } from '../types/GithubTypes.ts'
import ReadmeViewer from '@/components/ReadmeViewer.vue'

const route = useRoute()
const repository = ref<RepositoryDto | null>(null)

onMounted(async () => {
  const repoId = route.params.nodeId
  if (repoId) {
    repository.value = (await fetchMyRepos()).filter((repo) => repo.nodeId === repoId)[0]
  }
})
</script>

<template>
  <div class="container mx-auto p-4">
    <h1 class="text-3xl font-bold mb-4">{{ repository?.name }}</h1>
    <div class="shadow-md rounded-lg p-6 mb-4">
      <p v-if="repository?.description" class="text-white mb-2">
        Description: <span class="font-semibold">{{ repository.description }}</span>
      </p>
      <p v-if="repository?.homepage" class="text-white mb-2">
        Homepage: <a :href="repository.homepage" class="text-blue-500">{{ repository.homepage }}</a>
      </p>
      <p v-if="repository?.language" class="text-white mb-2">
        Language: <span class="font-semibold">{{ repository.language }}</span>
      </p>
      <p class="text-white mb-2">
        Updated at: <span class="font-semibold">{{ repository?.updatedAt }}</span>
      </p>
      <p class="text-white mb-2">
        Stars: <span class="font-semibold">{{ repository?.stars }}</span>
      </p>
      <p class="text-white mb-2">
        Fork: <span class="font-semibold">{{ repository?.fork ? 'Yes' : 'No' }}</span>
      </p>
      <p class="text-white mb-2">
        Archived: <span class="font-semibold">{{ repository?.archived ? 'Yes' : 'No' }}</span>
      </p>
      <p class="text-white mb-2">
        Visibility: <span class="font-semibold">{{ repository?.visibility }}</span>
      </p>
      <p class="text-white mb-2">
        Size: <span class="font-semibold">{{ repository?.size }} KB</span>
      </p>
      <p class="text-white mb-2">
        Template: <span class="font-semibold">{{ repository?.isTemplate ? 'Yes' : 'No' }}</span>
      </p>
      <p class="text-white mb-2">
        URL: <a :href="repository?.url" class="text-blue-500">{{ repository?.url }}</a>
      </p>
      <p class="text-white mb-2">
        Created at: <span class="font-semibold">{{ repository?.createdAt }}</span>
      </p>
      <ReadmeViewer v-if="repository?.markdown" :repository="repository" class="mt-4" />
      <p v-else class="text-white-500 mt-4">No readme available</p>
    </div>
  </div>
</template>
